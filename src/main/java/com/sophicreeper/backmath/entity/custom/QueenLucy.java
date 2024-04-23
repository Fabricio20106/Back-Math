package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.entity.goal.queenlucy.*;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class QueenLucy extends MonsterEntity implements ISophieFriendlies {
    private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.NOTCHED_6);
    private static final DataParameter<String> SPELL = EntityDataManager.defineId(QueenLucy.class, DataSerializers.STRING);
    public int spellTicks;

    public QueenLucy(EntityType<QueenLucy> type, World world) {
        super(type, world);
        this.setHealth(this.getMaxHealth());
        this.getNavigation().setCanFloat(true);
        this.xpReward = 450;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SPELL, "none");
    }

    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        this.spellTicks = tag.getInt("spell_ticks");
    }

    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("spell_ticks", this.spellTicks);
    }

    public boolean isCastingSpell() {
        if (this.level.isClientSide) {
            return !this.entityData.get(SPELL).equals("none");
        } else {
            return this.spellTicks > 0;
        }
    }

    public int getSpellTicks() {
        return this.spellTicks;
    }

    public void setSpellType(QueenLucySpells spells) {
        this.entityData.set(SPELL, spells.name());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.2D));
        this.goalSelector.addGoal(2, new SummonWarriorSophiesGoal(this));
        this.goalSelector.addGoal(2, new SummonArcherInsomniaSophiesGoal(this));
        this.goalSelector.addGoal(2, new SummonInsomniaSophiesGoal(this));
        this.goalSelector.addGoal(3, new EquipArmorAndHealGoal(this));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, WarriorSophie.class, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, ArcherInsomniaSophie.class, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, InsomniaSophie.class, 6));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.addAttackTargets();
        super.registerGoals();
    }

    protected void addAttackTargets() {
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, QueenLucyPet.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.spellTicks > 0) --this.spellTicks;
        if (this.tickCount % 20 == 0) this.heal(2);
        if (this.tickCount % 30 == 0) this.heal(3);
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void tick() {
        super.tick();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.DAMAGE_RESISTANCE);
    }

    public void aiStep() {
        this.updateSwingTime();
        super.aiStep();
    }

    public boolean causeFallDamage(float distance, float damageMultiplier) {
        return false;
    }

    public boolean addEffect(EffectInstance instance) {
        return false;
    }

    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void dropCustomDeathLoot(DamageSource source, int lootingLevel, boolean wasRecentlyHit) {
        super.dropCustomDeathLoot(source, lootingLevel, wasRecentlyHit);
        ItemEntity staffStack = this.spawnAtLocation(AxolotlTest.QUEEN_LUCY_SUMMONER_STAFF.get());
        if (staffStack != null) staffStack.setExtendedLifetime();
    }

    // Add the given player to the list of players tracking this entity.
    // For instance, a player may track a boss in order to view its associated boss bar.
    public void startSeenByPlayer(ServerPlayerEntity player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    // Removes the given player from the list of players tracking this entity.
    // See Entity#addTrackingPlayer(ServerPlayerEntity) for more information on tracking.
    public void stopSeenByPlayer(ServerPlayerEntity player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public boolean canRide(Entity entity) {
        return false;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public static AttributeModifierMap.MutableAttribute createQueenLucyAttributes() {
        return CreatureEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 8).add(Attributes.MAX_HEALTH, 250).add(Attributes.FOLLOW_RANGE, 100).add(Attributes.MOVEMENT_SPEED, 0.30F);
    }

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.QUEEN_LUCY_SUMMONER_STAFF.get()));
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_SOPHIE_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_SOPHIE_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_SOPHIE_HURT_BERRY_BUSH : BMSounds.ENTITY_SOPHIE_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_SOPHIE_DEATH;
    }

    public boolean isAlliedTo(Entity entity) {
        if (super.isAlliedTo(entity)) {
            return true;
        } else return entity instanceof ISophieFriendlies;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.QUEEN_LUCY_SPAWN_EGG.get());
    }

    public void rideTick() {
        super.rideTick();
        if (this.getVehicle() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getVehicle();
            this.yBodyRot = entity.yBodyRot;
        }
    }

    public SoundEvent getSpellSound() {
        return BMSounds.ENTITY_QUEEN_LUCY_CAST_SPELL;
    }
}
