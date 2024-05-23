package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.util.fix.BMTagFixes;
import com.sophicreeper.backmath.entity.goal.InsomniaZombieAttackGoal;
import com.sophicreeper.backmath.entity.goal.StompTurtleEggGoal;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
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
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.function.Predicate;

public class InsomniaZombie extends MonsterEntity {
    private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (difficulty) -> difficulty == Difficulty.HARD;
    private final BreakDoorGoal breakDoor = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
    private boolean canBreakDoors;

    public InsomniaZombie(EntityType<InsomniaZombie> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new StompTurtleEggGoal(this, 1, 3));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.addAttackTargets();
    }

    protected void addAttackTargets() {
        this.goalSelector.addGoal(2, new InsomniaZombieAttackGoal(this, 1, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WandererSophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WarriorSophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaSophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherInsomniaSophie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherLucia.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, KarateLucia.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucy.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute createInsomniaZombieAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35).add(Attributes.MOVEMENT_SPEED, 0.23F).add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ARMOR, 2);
    }

    public boolean canBreakDoors() {
        return this.canBreakDoors;
    }

    // Sets or removes EntityAIBreakDoor task.
    public void setCanBreakDoors(boolean enabled) {
        if (this.supportsBreakDoorGoal() && GroundPathHelper.hasGroundPathNavigation(this)) {
            if (this.canBreakDoors != enabled) {
                this.canBreakDoors = enabled;
                ((GroundPathNavigator) this.getNavigation()).setCanOpenDoors(enabled);
                if (enabled) {
                    this.goalSelector.addGoal(1, this.breakDoor);
                } else {
                    this.goalSelector.removeGoal(this.breakDoor);
                }
            }
        } else if (this.canBreakDoors) {
            this.goalSelector.removeGoal(this.breakDoor);
            this.canBreakDoors = false;
        }
    }

    protected boolean supportsBreakDoorGoal() {
        return true;
    }

    // Get the experience points the entity currently has.
    protected int getExperienceReward(PlayerEntity player) {
        if (this.isBaby()) this.xpReward = (int) ((float) this.xpReward * 2.5F);

        return super.getExperienceReward(player);
    }

    // Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons use this to react to sunlight and start to burn.
    public void aiStep() {
        if (this.isAlive()) {
            boolean shouldBurn = this.shouldBurnInDay() && this.isSunBurnTick();
            if (shouldBurn) {
                ItemStack headStack = this.getItemBySlot(EquipmentSlotType.HEAD);
                if (!headStack.isEmpty()) {
                    if (headStack.isDamageableItem()) {
                        headStack.setDamageValue(headStack.getDamageValue() + this.random.nextInt(2));
                        if (headStack.getDamageValue() >= headStack.getMaxDamage()) {
                            this.broadcastBreakEvent(EquipmentSlotType.HEAD);
                            this.setItemSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                        }
                    }
                    shouldBurn = false;
                }

                if (shouldBurn) {
                    this.setSecondsOnFire(8);
                }
            }
        }
        super.aiStep();
    }

    protected boolean shouldBurnInDay() {
        return true;
    }

    public boolean doHurtTarget(Entity entity) {
        boolean sup = super.doHurtTarget(entity);
        if (sup) {
            float localDifficulty = this.level.getCurrentDifficultyAt(this.blockPosition()).getSpecialMultiplier();
            if (this.getMainHandItem().isEmpty() && this.isOnFire() && this.random.nextFloat() < localDifficulty * 0.3F) {
                entity.setSecondsOnFire(2 * (int) localDifficulty);
            }
        }
        return sup;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ZOMBIE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 1);
    }

    public CreatureAttribute getMobType() {
        return CreatureAttribute.UNDEAD;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.INSOMNIA_ZOMBIE_SPAWN_EGG.get());
    }

    protected void populateAljanEquipmentSlots(DifficultyInstance difficulty) {
        if (this.random.nextFloat() < 0.15F * difficulty.getSpecialMultiplier()) {
            int i = this.random.nextInt(2);
            float f = this.level.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (this.random.nextFloat() < 0.095F) {
                ++i;
            }

            if (this.random.nextFloat() < 0.095F) {
                ++i;
            }

            if (this.random.nextFloat() < 0.095F) {
                ++i;
            }

            boolean flag = true;

            for(EquipmentSlotType equipmentSlots : EquipmentSlotType.values()) {
                if (equipmentSlots.getType() == EquipmentSlotType.Group.ARMOR) {
                    ItemStack armorSlotStacks = this.getItemBySlot(equipmentSlots);
                    if (!flag && this.random.nextFloat() < f) break;

                    flag = false;
                    if (armorSlotStacks.isEmpty()) {
                        Item aljanArmor = getAljanArmorByChance(equipmentSlots, i);
                        if (aljanArmor != null) {
                            this.setItemSlot(equipmentSlots, new ItemStack(aljanArmor));
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public static Item getAljanArmorByChance(EquipmentSlotType slot, int chance) {
        switch(slot) {
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
        this.populateAljanEquipmentSlots(difficulty);
        if (this.random.nextFloat() < (this.level.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = this.random.nextInt(3);
            if (i == 0) {
                this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJAMEED_BLADE.get()));
            } else {
                this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJAMEED_SHOVEL.get()));
            }
        }
    }

    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("can_break_doors", this.canBreakDoors());
    }

    // (abstract) Protected helper method to read subclass entity data from NBT.
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        this.setCanBreakDoors(BMTagFixes.fixCanBreakDoorsTag(tag));
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.74F;
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        spawnData = super.finalizeSpawn(world, difficulty, spawnReason, spawnData, dataTag);
        float clampedAdditionalDifficulty = difficulty.getSpecialMultiplier();
        this.setCanPickUpLoot(this.random.nextFloat() < 0.55F * clampedAdditionalDifficulty);

        this.setCanBreakDoors(this.supportsBreakDoorGoal() && this.random.nextFloat() < clampedAdditionalDifficulty * 0.1F);
        this.populateDefaultEquipmentSlots(difficulty);
        this.populateDefaultEquipmentEnchantments(difficulty);

        if (this.getItemBySlot(EquipmentSlotType.HEAD).isEmpty()) {
            LocalDate localDate = LocalDate.now();
            int dayOfMonth = localDate.getDayOfMonth();
            int monthOfYear = localDate.getMonth().getValue();
            if (monthOfYear == 10 && dayOfMonth == 31 && this.random.nextFloat() < 0.25F) {
                this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.armorDropChances[EquipmentSlotType.HEAD.getIndex()] = 0;
            }
        }

        this.applyAttributeBonuses(clampedAdditionalDifficulty);
        return spawnData;
    }

    protected void applyAttributeBonuses(float difficulty) {
        this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addPermanentModifier(new AttributeModifier("Random Knockback Res. Bonus", this.random.nextDouble() * (double) 0.05F, AttributeModifier.Operation.ADDITION));
        double d0 = this.random.nextDouble() * 1.5D * (double) difficulty;
        if (d0 > 1) {
            this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(new AttributeModifier("Random Follow Range Bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        if (this.random.nextFloat() < difficulty * 0.05F) {
            this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).addPermanentModifier(new AttributeModifier("Leader Insomnia Zombie Bonus", this.random.nextDouble() * 0.25D + 0.5D, AttributeModifier.Operation.ADDITION));
            this.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(new AttributeModifier("Leader Insomnia Zombie Bonus", this.random.nextDouble() * 3 + 1, AttributeModifier.Operation.MULTIPLY_TOTAL));
            this.setCanBreakDoors(this.supportsBreakDoorGoal());
        }
    }

    // Returns the Y Offset of this entity.
    public double getMyRidingOffset() {
        return -0.45D;
    }
}
