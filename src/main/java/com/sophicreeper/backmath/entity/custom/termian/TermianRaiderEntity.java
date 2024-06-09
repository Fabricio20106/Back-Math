package com.sophicreeper.backmath.entity.custom.termian;

import com.sophicreeper.backmath.entity.custom.QueenLucyPet;
import com.sophicreeper.backmath.entity.goal.termian.PromoteTermianLeaderGoal;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.entity.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public abstract class TermianRaiderEntity extends TermianPatrollerEntity {
    public static final DataParameter<Boolean> IS_CELEBRATING = EntityDataManager.defineId(TermianRaiderEntity.class, DataSerializers.BOOLEAN);
    public static final Predicate<ItemEntity> ALLOWED_ITEMS = (itemEntity) -> !itemEntity.hasPickUpDelay() && itemEntity.isAlive() && itemEntity.getItem().getItem().is(BMTags.Items.TERMIAN_RAIDER_CAN_PICKUP);
    private int wave;
    private boolean canJoinSophieRaid;
    private int ticksOutsideSophieRaid;

    public TermianRaiderEntity(EntityType<? extends CreatureEntity> mob, World world) {
        super(mob, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PromoteTermianLeaderGoal <>(this));
        // Move Towards Raid Goal
        // Invade Home Goal
        // Celebrate Raid Loss Goal
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_CELEBRATING, false);
    }

    public abstract void applySophieRaidBuffs(int currentWave, boolean spawnedWithRaid);

    public boolean canJoinSophieRaid() {
        return this.canJoinSophieRaid;
    }

    public void allowJoiningSophieRaid(boolean allow) {
        this.canJoinSophieRaid = allow;
    }

    @Override
    public void aiStep() {
        if (this.level instanceof ServerWorld && this.isAlive()) {
            if (this.canJoinSophieRaid()) {
                if (this.getTarget() != null && (this.getTarget().getType().is(BMTags.EntityTypes.TERMIAN_RAIDERS_ATTACK))) {
                    this.noActionTime = 0;
                }
            }
        }
        super.aiStep();
    }

    protected void updateNoActionTime() {
        this.noActionTime += 2;
    }

    @Override
    public void die(DamageSource source) {
        if (this.level instanceof ServerWorld) {
            Entity killer = source.getEntity();
            if (this.isPatrolLeader() && ((ServerWorld) this.level).getRaidAt(this.blockPosition()) == null) {
                ItemStack headStack = this.getItemBySlot(EquipmentSlotType.HEAD);
                PlayerEntity player = null;
                // Checks the killers to get the player.
                if (killer instanceof PlayerEntity) {
                    player = (PlayerEntity) killer;
                } else if (killer instanceof WolfEntity) {
                    WolfEntity wolf = (WolfEntity) killer;
                    LivingEntity wolfOwner = wolf.getOwner();
                    if (wolf.isTame() && wolfOwner instanceof PlayerEntity) {
                        player = (PlayerEntity) wolfOwner;
                    }
                } else if (killer instanceof QueenLucyPet) {
                    QueenLucyPet queenLucyPet = (QueenLucyPet) killer;
                    LivingEntity qlpOwner = queenLucyPet.getOwner();
                    if (queenLucyPet.isTame() && qlpOwner instanceof PlayerEntity) {
                        player = (PlayerEntity) qlpOwner;
                    }
                }

                if (!headStack.isEmpty() && ItemStack.matches(headStack, BMUtils.getTermianBannerInstance()) && player != null) {
                    EffectInstance playerBadOmen = player.getEffect(Effects.BAD_OMEN);
                    int effectLevel = 1;
                    if (playerBadOmen != null) {
                        effectLevel += playerBadOmen.getAmplifier();
                        player.removeEffectNoUpdate(Effects.BAD_OMEN);
                    } else {
                        --effectLevel;
                    }

                    effectLevel = MathHelper.clamp(effectLevel, 0, 4);
                    EffectInstance badOmen = new EffectInstance(Effects.BAD_OMEN, 120000, effectLevel, false, false, true);
                    if (!this.level.getGameRules().getBoolean(GameRules.RULE_DISABLE_RAIDS)) player.addEffect(badOmen);
                }
            }
        }
        super.die(source);
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public int getWave() {
        return this.wave;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isCelebrating() {
        return this.entityData.get(IS_CELEBRATING);
    }

    public void setCelebrating(boolean celebrating) {
        this.entityData.set(IS_CELEBRATING, celebrating);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("current_wave", this.wave);
        tag.putBoolean("can_join_sophie_raid", this.canJoinSophieRaid);
        tag.putBoolean("is_celebrating", this.entityData.get(IS_CELEBRATING));
        // "sophie_raid_id"
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        this.wave = tag.getInt("current_wave");
        this.canJoinSophieRaid = tag.getBoolean("can_join_sophie_raid");
        this.setCelebrating(tag.getBoolean("is_celebrating"));
    }

    @Override
    public void pickUpItem(ItemEntity itemEntity) {
        super.pickUpItem(itemEntity);
    }

    public int getTicksOutsideSophieRaid() {
        return this.ticksOutsideSophieRaid;
    }

    public void setTicksOutsideSophieRaid(int ticks) {
        this.ticksOutsideSophieRaid = ticks;
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT dataTag) {
        this.allowJoiningSophieRaid(this.getType().is(BMTags.EntityTypes.CANNOT_JOIN_SOPHIE_RAID) || reason != SpawnReason.NATURAL);
        return super.finalizeSpawn(world, difficulty, reason, entityData, dataTag);
    }

    public abstract SoundEvent getCelebrationSound();
}
