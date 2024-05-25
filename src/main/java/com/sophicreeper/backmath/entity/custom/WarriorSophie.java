package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.entity.custom.termian.TermianMemberEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class WarriorSophie extends TermianMemberEntity implements ISophieFriendlies {
    public WarriorSophie(EntityType<WarriorSophie> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.2D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.1D, false));
        this.goalSelector.addGoal(4, new LookAtGoal(this, QueenLucy.class, 6));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.addAttackTargets();
    }

    protected void addAttackTargets() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, (livEntity) -> livEntity.getType().is(EntityTypeTags.RAIDERS)));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VexEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucyPet.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
    }

    @Override
    public void applySophieRaidBuffs(int currentWave, boolean spawnedWithRaid) {
        for(EquipmentSlotType slotType : EquipmentSlotType.values()) {
            if (slotType.getType() == EquipmentSlotType.Group.ARMOR) {
                this.enchantSpawnedArmor(0.5F * currentWave, slotType);
            }
        }
    }

    @Override
    public ArmPose getArmPose() {
        if (this.isAggressive()) {
            return ArmPose.ATTACKING;
        } else {
            return this.isCelebrating() ? ArmPose.CELEBRATING : ArmPose.NEUTRAL;
        }
    }

    public static AttributeModifierMap.MutableAttribute createWarriorSophieAttributes() {
        return CreatureEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 6).add(Attributes.MAX_HEALTH, 36).add(Attributes.FOLLOW_RANGE, 12)
                .add(Attributes.MOVEMENT_SPEED, 0.25F);
    }

    @Override
    public void tick() {
        super.tick();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.DAMAGE_RESISTANCE);
    }

    public void aiStep() {
        this.updateSwingTime();
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.level.getGameRules().getBoolean(GameRules.RULE_NATURAL_REGENERATION)) {
            if (this.getHealth() < this.getMaxHealth() && this.tickCount % 20 == 0) {
                this.heal(1);
            }
        }
        super.aiStep();
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
        } else return entity.getType().is(BMTags.EntityTypes.SOPHIE_ALLIES);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.WARRIOR_SOPHIE_SPAWN_EGG.get());
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (!super.doHurtTarget(entity)) {
            return false;
        } else {
            if (entity instanceof LivingEntity && !entity.fireImmune()) {
                ItemStack devilSword = new ItemStack(AxolotlTest.DEVIL_SWORD.get());
                if (this.getItemBySlot(EquipmentSlotType.MAINHAND).equals(devilSword)) {
                    LivingEntity livEntity = (LivingEntity) entity;
                    livEntity.setSecondsOnFire(5);
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT dataTag) {
        this.populateDefaultEquipmentSlots(difficulty);
        this.populateDefaultEquipmentEnchantments(difficulty);
        return super.finalizeSpawn(world, difficulty, reason, entityData, dataTag);
    }

    @Override
    public SoundEvent getCelebrationSound() {
        return BMSounds.ENTITY_SOPHIE_CELEBRATE;
    }

    public void rideTick() {
        super.rideTick();
        if (this.getVehicle() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getVehicle();
            this.yBodyRot = entity.yBodyRot;
        }
    }

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        int i = this.random.nextInt(3);
        if (i == 0) {
            this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.MILKLLARY_WARRIOR_HELMET.get()));
            this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.MILKLLARY_CHESTPLATE.get()));
            this.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.MILKLLARY_LEGGINGS.get()));
            this.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.MILKLLARY_BOOTS.get()));
            this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.MILKLLARY_SWORD.get()));
        } else if (i == 1) {
            this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ANGELIC_WARRIOR_HELMET.get()));
            this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ANGELIC_CHESTPLATE.get()));
            this.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.ANGELIC_LEGGINGS.get()));
            this.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.ANGELIC_BOOTS.get()));
            this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_SWORD.get()));
        } else {
            this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.DEVIL_WARRIOR_HELMET.get()));
            this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.DEVIL_CHESTPLATE.get()));
            this.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.DEVIL_LEGGINGS.get()));
            this.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.DEVIL_BOOTS.get()));
            this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.DEVIL_SWORD.get()));
        }
        super.populateDefaultEquipmentSlots(difficulty);
    }
}
