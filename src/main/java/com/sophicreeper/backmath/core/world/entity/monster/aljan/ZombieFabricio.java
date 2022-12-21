package com.sophicreeper.backmath.core.world.entity.monster.aljan;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import com.sophicreeper.backmath.core.world.entity.goal.BMZombieFabricioAttackGoal;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.GroundPathHelper;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

public class ZombieFabricio extends MonsterEntity {
    private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (difficulty) -> difficulty == Difficulty.HARD;
    private final BreakDoorGoal breakDoor = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
    private boolean isBreakDoorsTaskSet;

    public ZombieFabricio(EntityType<ZombieFabricio> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.goalSelector.addGoal(2, new BMZombieFabricioAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute createZombieFabricioAttributes() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.ARMOR, 2.0D);
    }

    public boolean isBreakDoorsTaskSet() {
        return this.isBreakDoorsTaskSet;
    }

    /**
     * Sets or removes EntityAIBreakDoor task
     */
    public void setBreakDoorsAITask(boolean enabled) {
        if (this.canBreakDoors() && GroundPathHelper.isGroundNavigator(this)) {
            if (this.isBreakDoorsTaskSet != enabled) {
                this.isBreakDoorsTaskSet = enabled;
                ((GroundPathNavigator)this.getNavigator()).setBreakDoors(enabled);
                if (enabled) {
                    this.goalSelector.addGoal(1, this.breakDoor);
                } else {
                    this.goalSelector.removeGoal(this.breakDoor);
                }
            }
        } else if (this.isBreakDoorsTaskSet) {
            this.goalSelector.removeGoal(this.breakDoor);
            this.isBreakDoorsTaskSet = false;
        }

    }

    protected boolean canBreakDoors() {
        return true;
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(PlayerEntity player) {
        if (this.isChild()) {
            this.experienceValue = (int)((float)this.experienceValue * 2.5F);
        }

        return super.getExperiencePoints(player);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void livingTick() {
        if (this.isAlive()) {
            boolean flag = this.shouldBurnInDay() && this.isInDaylight();
            if (flag) {
                ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
                if (!itemstack.isEmpty()) {
                    if (itemstack.isDamageable()) {
                        itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
                        if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
                            this.sendBreakAnimation(EquipmentSlotType.HEAD);
                            this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    this.setFire(8);
                }
            }
        }

        super.livingTick();
    }

    protected boolean shouldBurnInDay() {
        return true;
    }

    public boolean attackEntityAsMob(Entity entity) {
        boolean flag = super.attackEntityAsMob(entity);
        if (flag) {
            float f = this.world.getDifficultyForLocation(this.getPosition()).getAdditionalDifficulty();
            if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
                entity.setFire(2 * (int) f);
            }
        }

        return flag;
    }

    public static boolean canSpawnZFOn(EntityType<ZombieFabricio> zombieFabricio, IServerWorld iServerWorld, SpawnReason reason, BlockPos pos, Random randomIn) {
        if (iServerWorld.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel(iServerWorld, pos, randomIn) && BMConfigs.SERVER_CONFIGS.zombieFabricioSpawn.get()) {
            if (
                    Objects.equals(iServerWorld.getBiome(pos), BMBiomes.ALJAN_WOODS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.ALJAMIC_HIGHLANDS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.CAPPED_HILLS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.INSOMNIAN_WOODS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.AMARACAMEL_STICKS.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.SLEEPISH_OCEAN.get()) ||
                            Objects.equals(iServerWorld.getBiome(pos), BMBiomes.DEEP_SLEEPISH_OCEAN.get())) {
                canSpawnOn(zombieFabricio, iServerWorld, reason, pos, randomIn);
            }
        }
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEAD;
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

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setEquipmentBasedOnDifficultyCustom(difficulty);
        if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = this.rand.nextInt(3);
            if (i == 0) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJAMEED_BLADE.get()));
            } else {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJAMEED_SHOVEL.get()));
            }
        }

    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setBreakDoorsAITask(compound.getBoolean("CanBreakDoors"));
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize entitySize) {
        return 1.74F;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld iServerWorld, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(iServerWorld, difficulty, spawnReason, spawnDataIn, dataTag);
        float f = difficulty.getClampedAdditionalDifficulty();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);

        this.setBreakDoorsAITask(this.canBreakDoors() && this.rand.nextFloat() < f * 0.1F);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);

        if (this.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty()) {
            LocalDate localDate = LocalDate.now();
            int dayOfMonth = localDate.get(ChronoField.DAY_OF_MONTH);
            int monthOfYear = localDate.get(ChronoField.MONTH_OF_YEAR);
            if (monthOfYear == 10 && dayOfMonth == 31 && this.rand.nextFloat() < 0.25F) {
                this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.inventoryArmorDropChances[EquipmentSlotType.HEAD.getIndex()] = 0.0F;
            }
        }

        this.applyAttributeBonuses(f);
        return spawnDataIn;
    }

    protected void applyAttributeBonuses(float difficulty) {
        this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).applyPersistentModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * (double)0.05F, AttributeModifier.Operation.ADDITION));
        double d0 = this.rand.nextDouble() * 1.5D * (double)difficulty;
        if (d0 > 1.0D) {
            this.getAttribute(Attributes.FOLLOW_RANGE).applyPersistentModifier(new AttributeModifier("Random zombie-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        if (this.rand.nextFloat() < difficulty * 0.05F) {
            this.getAttribute(Attributes.MAX_HEALTH).applyPersistentModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
            this.setBreakDoorsAITask(this.canBreakDoors());
        }

    }

    /**
     * Returns the Y Offset of this entity.
     */
    public double getYOffset() {
        return -0.45D;
    }

    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropSpecialItems(source, looting, recentlyHitIn);
        Entity entity = source.getTrueSource();
        if (entity instanceof CreeperEntity) {
            CreeperEntity creeper = (CreeperEntity)entity;
            if (creeper.ableToCauseSkullDrop()) {
                ItemStack stack = this.getSkullDrop();
                if (!stack.isEmpty()) {
                    creeper.incrementDroppedSkulls();
                    this.entityDropItem(stack);
                }
            }
        }

    }

    protected ItemStack getSkullDrop() {
        return new ItemStack(AxolotlTest.ZOMBIE_FABRICIO_HEAD.get());
    }
}
