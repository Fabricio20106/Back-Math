package com.sophicreeper.backmath.entity.custom.aljamic;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.entity.misc.WornOutfit;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMFoodStats;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.TagTypes;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.OpenDoorGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AljamicMemberEntity extends CreatureEntity implements WornOutfit {
    private static final DataParameter<String> OUTFIT_TEXTURE = EntityDataManager.defineId(AljamicMemberEntity.class, DataSerializers.STRING);
    protected final BMFoodStats foodData = new BMFoodStats();

    public AljamicMemberEntity(EntityType<? extends AljamicMemberEntity> type, World world) {
        super(type, world);
        ((GroundPathNavigator) this.getNavigation()).setCanOpenDoors(true);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new OpenDoorGoal(this, true));
    }

    @Override
    public boolean isAlliedTo(Entity entity) {
        return super.isAlliedTo(entity) || entity.getType().is(BMEntityTypeTags.FABRICIOS);
    }

    @Override
    public double getMyRidingOffset() {
        return -0.35D;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
    }

    @Override
    public String getOutfitTexture() {
        return this.entityData.get(OUTFIT_TEXTURE);
    }

    @Override
    public void setOutfitTexture(String outfitTexture) {
        this.entityData.set(OUTFIT_TEXTURE, outfitTexture);
    }

    @Override
    public boolean isWearingOutfit() {
        return !this.entityData.get(OUTFIT_TEXTURE).isEmpty();
    }

    public boolean isHurt() {
        return this.getHealth() > 0 && this.getHealth() < this.getMaxHealth();
    }

    public boolean canEat(boolean canAlwaysEat) {
        return canAlwaysEat || this.foodData.canEat();
    }

    public boolean shouldEat() {
        return this.foodData.getNutritionLevel() <= 16;
    }

    public void causeExhaustion(float exhaustion) {
        if (!this.level.isClientSide) this.foodData.addExhaustion(exhaustion);
    }

    public BMFoodStats getFoodData() {
        return this.foodData;
    }

    @Override
    @Nonnull
    public ItemStack eat(World world, ItemStack stack) {
        this.foodData.eat(stack.getItem(), stack);
        world.playSound(null, this.getX(), this.getY(), this.getZ(), BMSounds.ENTITY_FABRICIO_BURP, this.getSoundSource(), 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        return super.eat(world, stack);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) this.foodData.tick(this);
        ItemStack headStack = this.getItemBySlot(EquipmentSlotType.HEAD);
        boolean acceptableHelmets = headStack.getItem().is(BMItemTags.PROVIDES_WATER_BREATHING);
        if (acceptableHelmets && !this.isEyeInFluid(FluidTags.WATER)) {
            this.addEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        }
    }

    @Override
    public void rideTick() {
        super.rideTick();
        if (this.getVehicle() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getVehicle();
            this.yBodyRot = entity.yBodyRot;
        }
    }

    @Override
    public void aiStep() {
        if (this.foodData.canEat() && this.tickCount % 10 == 0) this.foodData.setNutritionLevel(this.foodData.getNutritionLevel() + 1);
        super.aiStep();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(OUTFIT_TEXTURE, "");
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("outfit", TagTypes.STRING)) this.entityData.set(OUTFIT_TEXTURE, tag.getString("outfit"));
        if (tag.contains("CanPickUpLoot", TagTypes.ANY_NUMERIC)) this.setCanPickUpLoot(tag.getBoolean("CanPickUpLoot"));
        this.foodData.readFoodStats(tag);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        this.foodData.writeFoodStats(tag);
        if (!this.entityData.get(OUTFIT_TEXTURE).isEmpty()) tag.putString("outfit", this.entityData.get(OUTFIT_TEXTURE));
    }

    protected void populateAljanEquipmentSlots() {
        if (this.random.nextFloat() < BMConfigs.COMMON_CONFIGS.aljamicMembersArmorChance.get()) {
            int rand = this.random.nextInt(2);
            float chancePerDifficulty = this.level.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (this.random.nextFloat() < 0.095F) ++rand;
            if (this.random.nextFloat() < 0.095F) ++rand;
            if (this.random.nextFloat() < 0.095F) ++rand;
            boolean populateArmor = true;

            EquipmentSlotType[] armorSlots = new EquipmentSlotType[] {EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};
            for (EquipmentSlotType equipmentSlotType : armorSlots) {
                if (equipmentSlotType.getType() == EquipmentSlotType.Group.ARMOR) {
                    ItemStack stack = this.getItemBySlot(equipmentSlotType);
                    if (!populateArmor && this.random.nextFloat() < chancePerDifficulty) break;

                    populateArmor = false;
                    if (stack.isEmpty()) {
                        Item armorItem = getAljanArmorByChance(equipmentSlotType, rand);
                        Item weaponItem = getSwordByChance(rand);
                        if (armorItem != null) this.setItemSlot(equipmentSlotType, new ItemStack(armorItem));
                        if (weaponItem != null) this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(weaponItem));
                    }
                }
            }
        }
        else this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ALJANSTONE_KNIFE.get()));
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
                    return AxolotlTest.ALJAMEED_HELMET.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_HELMET.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_HELMET.get();
                }
            case CHEST:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_CHESTPLATE.get();
                } else if (chance == 1) {
                    return AxolotlTest.ARCHER_FABRICIO_VEST.get();
                } else if (chance == 2) {
                    return AxolotlTest.ALJAMEED_CHESTPLATE.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_CHESTPLATE.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_CHESTPLATE.get();
                }
            case LEGS:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_LEGGINGS.get();
                } else if (chance == 1) {
                    return Items.AIR;
                } else if (chance == 2) {
                    return AxolotlTest.ALJAMEED_LEGGINGS.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_LEGGINGS.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_LEGGINGS.get();
                }
            case FEET:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_BOOTS.get();
                } else if (chance == 1) {
                    return Items.AIR;
                } else if (chance == 2) {
                    return AxolotlTest.ALJAMEED_BOOTS.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_BOOTS.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_BOOTS.get();
                }
            default: return null;
        }
    }

    public static Item getSwordByChance(int chance) {
        switch (chance) {
            case 0: return AxolotlTest.ALJANWOOD_SWORD.get();
            case 1: return AxolotlTest.ALJANSTONE_SWORD.get();
            case 2: return AxolotlTest.ALJAMEED_BLADE.get();
            case 3: return AxolotlTest.MOONERING_SWORD.get();
            case 4: return AxolotlTest.JANTIQUIFIED_MOONERING_SWORD.get();
            default: return null;
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean superRuns = super.hurt(source, amount);
        if (this.level.isClientSide) {
            return false;
        } else {
            if (superRuns && source.getEntity() instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) source.getEntity();
                if (this.canAttack(target) && EntityPredicates.ATTACK_ALLOWED.test(target)) this.setTarget(target);
            }
            return superRuns;
        }
    }

    @Override
    protected void actuallyHurt(DamageSource source, float amount) {
        this.causeExhaustion(source.getFoodExhaustion());
        super.actuallyHurt(source, amount);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_FABRICIO_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_FABRICIO_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_FABRICIO_HURT_BERRY_BUSH : BMSounds.ENTITY_FABRICIO_HURT;
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_FABRICIO_DEATH;
    }
}
