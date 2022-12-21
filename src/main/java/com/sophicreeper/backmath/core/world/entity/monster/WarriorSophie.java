package com.sophicreeper.backmath.core.world.entity.monster;

import com.sophicreeper.backmath.core.world.entity.monster.aljan.Janticle;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WarriorSophie extends CreatureEntity {
    public WarriorSophie(EntityType<WarriorSophie> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.1D, false));
        this.goalSelector.addGoal(4, new LookAtGoal(this, QueenSophie.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.applyMobAI();
        super.registerGoals();
    }

    protected void applyMobAI() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenSophiePet.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
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

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
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
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.angelic_warrior_helmet.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.angelic_chestplate.get()));
            this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.angelic_leggings.get()));
            this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.angelic_boots.get()));
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_SWORD.get()));
        } else {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.devil_warrior_helmet.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.devil_chestplate.get()));
            this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.devil_leggings.get()));
            this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.devil_boots.get()));
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.DEVIL_SWORD.get()));
        }
        super.setEquipmentBasedOnDifficulty(difficulty);
    }
}
