package com.sophicreeper.backmath.core.world.entity.creature.aljan;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Random;

public class Malaika extends CreatureEntity {
    public Malaika(EntityType<Malaika> entity, World world) {
        super(entity, world);
        this.experienceValue = 2;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.3f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(4, new LookAtGoal(this, Malaika.class, 6));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.entityAttackTargets();
        super.registerGoals();
    }

    protected void entityAttackTargets() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
    }

    public static AttributeModifierMap.MutableAttribute createMalaikaAttributes() {
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 15)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23f)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.25f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 2;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62f;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT compoundNBT) {
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return spawnData;
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

    public static boolean canSpawnMalaikaOn(EntityType<Malaika> malaika, IServerWorld iServerWorld, SpawnReason reason, BlockPos pos, Random randomIn) {
        if (Objects.equals(iServerWorld.getBiome(pos), BMBiomes.ALJAN_WOODS.get()) ||
                Objects.equals(iServerWorld.getBiome(pos), BMBiomes.ALJAMIC_HIGHLANDS.get()) ||
                Objects.equals(iServerWorld.getBiome(pos), BMBiomes.CAPPED_HILLS.get()) ||
                Objects.equals(iServerWorld.getBiome(pos), BMBiomes.INSOMNIAN_WOODS.get()) ||
                Objects.equals(iServerWorld.getBiome(pos), BMBiomes.AMARACAMEL_STICKS.get()) ||
                Objects.equals(iServerWorld.getBiome(pos), BMBiomes.SLEEPISH_OCEAN.get()) ||
                Objects.equals(iServerWorld.getBiome(pos), BMBiomes.DEEP_SLEEPISH_OCEAN.get()) && BMConfigs.SERVER_CONFIGS.malaikaSpawn.get()) {
            canSpawnOn(malaika, iServerWorld, reason, pos, randomIn);
        }
        return false;
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setEquipmentBasedOnDifficultyCustom(difficulty);
        this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.ALJAMEED_BOOTS.get()));
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.GOLDEN_HALO.get()));
        if (rand.nextInt(2) == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJANWOOD_SWORD.get()));
        } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJANSTONE_SWORD.get()));
        }
    }
}
