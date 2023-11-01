package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class WarriorSophie extends CreatureEntity {
    public WarriorSophie(EntityType<WarriorSophie> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.1D, false));
        this.goalSelector.addGoal(4, new LookAtGoal(this, QueenLucy.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.applyMobAI();
        super.registerGoals();
    }

    protected void applyMobAI() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractIllagerEntity.class, true));
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

    public static AttributeModifierMap.MutableAttribute createWarriorSophieAttributes() {
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0f)
                .createMutableAttribute(Attributes.MAX_HEALTH, 36.0f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25f);
    }

    public void livingTick() {
        this.updateArmSwingProgress();

        if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION)) {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0) {
                this.heal(1.0F);
            }
        }
        super.livingTick();
    }

    public double getYOffset() {
        return -0.35D;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.WARRIOR_SOPHIE_SPAWN_EGG.get());
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (!super.attackEntityAsMob(entity)) {
            return false;
        } else {
            if (entity instanceof LivingEntity && !entity.isImmuneToFire()) {
                ItemStack devilSword = new ItemStack(AxolotlTest.DEVIL_SWORD.get());
                if (this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).equals(devilSword)) {
                    LivingEntity livEntity = (LivingEntity) entity;
                    livEntity.setFire(5);
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return super.onInitialSpawn(world, difficulty, spawnReason, spawnData, dataTag);
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getRidingEntity();
            this.renderYawOffset = entity.renderYawOffset;
        }
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        int i = this.rand.nextInt(3);
        if (i == 0) {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.MILKLLARY_HELMET.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.MILKLLARY_CHESTPLATE.get()));
            this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.MILKLLARY_LEGGINGS.get()));
            this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.MILKLLARY_BOOTS.get()));
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.MILKLLARY_SWORD.get()));
        } else if (i == 1) {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ANGELIC_WARRIOR_HELMET.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ANGELIC_CHESTPLATE.get()));
            this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.ANGELIC_LEGGINGS.get()));
            this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.ANGELIC_BOOTS.get()));
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_SWORD.get()));
        } else {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.DEVIL_WARRIOR_HELMET.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.DEVIL_CHESTPLATE.get()));
            this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.DEVIL_LEGGINGS.get()));
            this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.DEVIL_BOOTS.get()));
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.DEVIL_SWORD.get()));
        }
        super.setEquipmentBasedOnDifficulty(difficulty);
    }
}
