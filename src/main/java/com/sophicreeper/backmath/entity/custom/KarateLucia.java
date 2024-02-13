package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class KarateLucia extends CreatureEntity implements ISophieFriendlies {
    public KarateLucia(EntityType<KarateLucia> type, World world) {
        super(type, world);
    }

    @Override
    public boolean isOnSameTeam(Entity entity) {
        if (super.isOnSameTeam(entity)) {
            return true;
        } else return entity instanceof ISophieFriendlies;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.applyEntityAI();
        super.registerGoals();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5D, false));
    }

    public static AttributeModifierMap.MutableAttribute createKarateLuciaAttributes() {
        return CreatureEntity.func_233666_p_()
                // Old karate Lucia health was 50.0d.
                // Old new karate Lucia health was 28.0d.
                .createMutableAttribute(Attributes.MAX_HEALTH, 20).createMutableAttribute(Attributes.FOLLOW_RANGE, 32).createMutableAttribute(Attributes.ATTACK_DAMAGE, 6).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F)
                .createMutableAttribute(Attributes.ARMOR, 3);
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        this.setEnchantmentBasedOnDifficulty(difficulty);
        this.setEquipmentBasedOnDifficulty(difficulty);
        return spawnData;
    }

    @Override
    public void tick() {
        super.tick();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.RESISTANCE);
    }

    public void livingTick() {
        this.updateArmSwingProgress();
        if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION)) {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0) {
                this.heal(1);
            }
        }
        super.livingTick();
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getRidingEntity();
            this.renderYawOffset = entity.renderYawOffset;
        }
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_LUCIA_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_LUCIA_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_LUCIA_HURT_BERRY_BUSH : BMSounds.ENTITY_LUCIA_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_SOPHIE_DEATH;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.KARATE_LUCIA_SPAWN_EGG.get());
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.KARATE_TRAINING_STICK.get()));
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.YELLOW_KARATE_BAND.get()));
    }
}
