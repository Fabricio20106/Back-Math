package com.sophicreeper.backmath.entity.custom.aljan;

import com.sophicreeper.backmath.entity.custom.*;
import com.sophicreeper.backmath.entity.custom.aljamic.AljamicMemberEntity;
import com.sophicreeper.backmath.entity.custom.misc.InsomniaArrowEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SleepishSkeletonEntity extends AbstractSkeletonEntity {
    public SleepishSkeletonEntity(EntityType<SleepishSkeletonEntity> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MalaikaEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AljamicMemberEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WandererSophieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, KarateLuciaEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherLuciaEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WarriorSophieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucyEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucyPetEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaSophieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherInsomniaSophieEntity.class, true));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute createSleepishSkeletonAttributes() {
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

    @Nonnull
    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (!super.doHurtTarget(entity)) {
            return false;
        } else {
            ((LivingEntity) entity).addEffect(new EffectInstance(Effects.BLINDNESS, 600));
            return true;
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.SLEEPISH_SKELETON_SPAWN_EGG.get());
    }

    protected void populateAljanEquipmentSlots(DifficultyInstance difficulty) {
        if (this.random.nextFloat() < 0.15F * difficulty.getSpecialMultiplier()) {
            int rand = this.random.nextInt(2);
            float chancePerDifficulty = this.level.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (this.random.nextFloat() < 0.095F) ++rand;
            if (this.random.nextFloat() < 0.095F) ++rand;
            if (this.random.nextFloat() < 0.095F) ++rand;
            boolean populateArmor = true;

            for (EquipmentSlotType equipmentSlotType : EquipmentSlotType.values()) {
                if (equipmentSlotType.getType() == EquipmentSlotType.Group.ARMOR) {
                    ItemStack stack = this.getItemBySlot(equipmentSlotType);
                    if (!populateArmor && this.random.nextFloat() < chancePerDifficulty) break;

                    populateArmor = false;
                    if (stack.isEmpty()) {
                        Item item = getAljanArmorByChance(equipmentSlotType, rand);
                        if (item != null) this.setItemSlot(equipmentSlotType, new ItemStack(item));
                    }
                }
            }
        }
    }

    @Nullable
    public static Item getAljanArmorByChance(EquipmentSlotType slot, int chance) {
        switch (slot) {
            case HEAD:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_HELMET.get();
                } else if (chance == 1) {
                    return AxolotlTest.ARCHER_FABRICIO_HOOD.get();
                } else if (chance == 2) {
                    return AxolotlTest.ARCHER_FABRICIO_HOOD.get();
                } else if (chance == 3) {
                    return AxolotlTest.ALJAMEED_HELMET.get();
                } else if (chance == 4) {
                    return AxolotlTest.MOONERING_HELMET.get();
                }
            case CHEST:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_CHESTPLATE.get();
                } else if (chance == 1) {
                    return AxolotlTest.ARCHER_FABRICIO_VEST.get();
                } else if (chance == 2) {
                    return AxolotlTest.ARCHER_FABRICIO_VEST.get();
                } else if (chance == 3) {
                    return AxolotlTest.ALJAMEED_CHESTPLATE.get();
                } else if (chance == 4) {
                    return AxolotlTest.MOONERING_CHESTPLATE.get();
                }
            case LEGS:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_LEGGINGS.get();
                } else if (chance == 1) {
                    return Items.AIR;
                } else if (chance == 2) {
                    return Items.AIR;
                } else if (chance == 3) {
                    return AxolotlTest.ALJAMEED_LEGGINGS.get();
                } else if (chance == 4) {
                    return AxolotlTest.MOONERING_LEGGINGS.get();
                }
            case FEET:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_BOOTS.get();
                } else if (chance == 1) {
                    return Items.AIR;
                } else if (chance == 2) {
                    return Items.AIR;
                } else if (chance == 3) {
                    return AxolotlTest.ALJAMEED_BOOTS.get();
                } else if (chance == 4) {
                    return AxolotlTest.MOONERING_BOOTS.get();
                }
            default:
                return null;
        }
    }

    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
//        EquipmentTableUtils.equipWithGear(BMResourceLocations.SLEEPISH_SKELETON_EQUIPMENT, this);
        this.populateAljanEquipmentSlots(difficulty);
    }

    @Nonnull
    protected AbstractArrowEntity getArrow(ItemStack arrowStack, float distanceFactor) {
        return new InsomniaArrowEntity(this.level, this);
    }
}
