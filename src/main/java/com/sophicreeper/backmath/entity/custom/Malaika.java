package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class Malaika extends CreatureEntity implements ISophieFriendlies {
    public Malaika(EntityType<Malaika> entity, World world) {
        super(entity, world);
        this.experienceValue = 2;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(3, new LookAtGoal(this, Malaika.class, 6));
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
        return CreatureEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 15).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23f).createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.25f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 2;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62f;
    }

    public double getYOffset() {
        return -0.35D;
    }

    @Override
    public void tick() {
        super.tick();
        ItemStack headStack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
        boolean acceptableHelmets = headStack.getItem().isIn(BMTags.Items.PROVIDES_WATER_BREATHING);

        if (acceptableHelmets && !this.areEyesInFluid(FluidTags.WATER)) {
            this.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        }
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

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return spawnData;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_MALAIKA_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_MALAIKA_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_MALAIKA_HURT_BERRY_BUSH : BMSounds.ENTITY_MALAIKA_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_MALAIKA_DEATH;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.MALAIKA_SPAWN_EGG.get());
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
                        Item item = getAljanArmorByChance(equipmentSlotType, i);
                        if (item != null) {
                            this.setItemStackToSlot(equipmentSlotType, new ItemStack(item));
                        }
                    }
                }
            }
        }

    }

    @Nullable
    public static Item getAljanArmorByChance(EquipmentSlotType armorSlot, int chance) {
        switch(armorSlot) {
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
