package com.sophicreeper.backmath.core.world.entity.monster.aljan;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Random;

public class AljamicBones extends AbstractSkeletonEntity {
    public AljamicBones(EntityType<AljamicBones> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute createAljamicBonesAttributes() {
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
                    return Items.GOLDEN_HELMET;
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
                    return Items.GOLDEN_CHESTPLATE;
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
                    return Items.GOLDEN_LEGGINGS;
                } else if (chance == 2) {
                    return Items.CHAINMAIL_LEGGINGS;
                } else if (chance == 3) {
                    return AxolotlTest.ALJAMEED_LEGGINGS.get();
                } else if (chance == 4) {
                    return AxolotlTest.MOONERING_LEGGINGS.get();
                }
            case FEET:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_BOOTS.get();
                } else if (chance == 1) {
                    return Items.GOLDEN_BOOTS;
                } else if (chance == 2) {
                    return Items.CHAINMAIL_BOOTS;
                } else if (chance == 3) {
                    return AxolotlTest.ALJAMEED_BOOTS.get();
                } else if (chance == 4) {
                    return AxolotlTest.MOONERING_BOOTS.get();
                }
            default:
                return null;
        }
    }

    public static boolean canSpawnABOn(EntityType<AljamicBones> aljamicBones, IServerWorld iServerWorld, SpawnReason reason, BlockPos pos, Random randomIn) {
        if (iServerWorld.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel(iServerWorld, pos, randomIn) && BMConfigs.SERVER_CONFIGS.aljamicBonesSpawn.get()) {
            if (
                    Objects.equals(iServerWorld.getBiome(pos), BMBiomes.ALJAN_WOODS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.ALJAMIC_HIGHLANDS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.CAPPED_HILLS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.INSOMNIAN_WOODS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.AMARACAMEL_STICKS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.SLEEPISH_OCEAN.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.DEEP_SLEEPISH_OCEAN.get())) {
                canSpawnOn(aljamicBones, iServerWorld, reason, pos, randomIn);
            }
        }
        return false;
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setEquipmentBasedOnDifficultyCustom(difficulty);
        if (rand.nextInt(2) == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJANSTONE_SWORD.get()));
        } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJANWOOD_SWORD.get()));
        }
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ALJAMIC_BONE_HELMET.get()));
    }
}
