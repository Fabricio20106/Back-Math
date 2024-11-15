package com.sophicreeper.backmath.entity.custom.aljan;

import com.sophicreeper.backmath.entity.custom.*;
import com.sophicreeper.backmath.entity.custom.aljamic.AljamicMemberEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class AljamicBonesEntity extends AbstractSkeletonEntity implements AljanMobUtils {
    public AljamicBonesEntity(EntityType<AljamicBonesEntity> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MalaikaEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AljamicMemberEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WandererSophieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WarriorSophieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaSophieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherInsomniaSophieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherLuciaEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, KarateLuciaEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucyEntity.class, true));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute createAljamicBonesAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.ALJAMIC_BONES_SPAWN_EGG.get());
    }

    // Gives armor or weapon for entity based on given DifficultyInstance.
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
//        EquipmentTableUtils.equipWithGear(BMResourceLocations.ALJAMIC_BONES_EQUIPMENT, this);
        if (this.random.nextBoolean()) this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJANSTONE_SWORD.get()));
        else this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJANWOOD_SWORD.get()));
        this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ALJAMIC_BONE_HELMET.get()));
        this.populateAljanEquipmentSlots(this, this.random);
    }
}
