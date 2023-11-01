package com.sophicreeper.backmath.entity.custom;

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
import net.minecraft.entity.projectile.ArrowEntity;
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

import javax.annotation.Nullable;

public class SleepishSkeleton extends AbstractSkeletonEntity {
    public SleepishSkeleton(EntityType<SleepishSkeleton> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WandererSophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, KarateLucia.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherLucia.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WarriorSophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucy.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucyPet.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaSophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherInsomniaSophie.class, true));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute createSleepishSkeletonAttributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_SKELETON_STEP;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (!super.attackEntityAsMob(entity)) {
            return false;
        } else {
            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 600));
            return true;
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.SLEEPISH_SKELETON_SPAWN_EGG.get());
    }

    protected void setEquipmentBasedOnDifficultyCustom(DifficultyInstance difficulty) {
        if (this.rand.nextFloat() < 0.15F * difficulty.getClampedAdditionalDifficulty()) {
            int i = this.rand.nextInt(2);
            float f = this.world.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (this.rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (this.rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (this.rand.nextFloat() < 0.095F) {
                ++i;
            }

            boolean flag = true;

            for(EquipmentSlotType equipmentSlotType : EquipmentSlotType.values()) {
                if (equipmentSlotType.getSlotType() == EquipmentSlotType.Group.ARMOR) {
                    ItemStack stack = this.getItemStackFromSlot(equipmentSlotType);
                    if (!flag && this.rand.nextFloat() < f) {
                        break;
                    }

                    flag = false;
                    if (stack.isEmpty()) {
                        Item item = getBackMathArmorByChance(equipmentSlotType, i);
                        if (item != null) {
                            this.setItemStackToSlot(equipmentSlotType, new ItemStack(item));
                        }
                    }
                }
            }
        }

    }

    @Nullable
    public static Item getBackMathArmorByChance(EquipmentSlotType slotIn, int chance) {
        switch(slotIn) {
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

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setEquipmentBasedOnDifficultyCustom(difficulty);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
    }

    protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
        AbstractArrowEntity arrowEntity = super.fireArrow(arrowStack, distanceFactor);
        if (arrowEntity instanceof ArrowEntity) {
            ((ArrowEntity) arrowEntity).addEffect(new EffectInstance(Effects.POISON, 100));
            ((ArrowEntity) arrowEntity).addEffect(new EffectInstance(Effects.BLINDNESS, 600));
        }
        return arrowEntity;
    }
}
