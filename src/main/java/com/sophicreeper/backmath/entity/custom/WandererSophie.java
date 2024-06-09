package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.entity.custom.termian.TermianMemberEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.misc.BMRegistries;
import com.sophicreeper.backmath.variant.wansophie.BMWandererSophieVariants;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.util.BMUtils;
import com.sophicreeper.backmath.util.fix.BMTagFixes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effects;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Random;

public class WandererSophie extends TermianMemberEntity implements ISophieFriendlies {
    public static final Logger LOGGER = LogManager.getLogger();
    private static final DataParameter<String> VARIANT = EntityDataManager.defineId(WandererSophie.class, DataSerializers.STRING);

    public WandererSophie(EntityType<WandererSophie> type, World world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, BMWandererSophieVariants.YELLOW_AXOLOTL.get().getRegistryName().toString());
    }

    @Override
    public void applySophieRaidBuffs(int currentWave, boolean spawnedWithRaid) {
        this.enchantSpawnedWeapon(1);
        for(EquipmentSlotType slotType : EquipmentSlotType.values()) {
            if (slotType.getType() == EquipmentSlotType.Group.ARMOR) this.enchantSpawnedArmor(1, slotType);
        }
    }

    @Override
    public SoundEvent getCelebrationSound() {
        return BMSounds.ENTITY_SOPHIE_CELEBRATE;
    }

    @Override
    public void tick() {
        super.tick();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.DAMAGE_RESISTANCE);
    }

    public void aiStep() {
        this.updateSwingTime();
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.level.getGameRules().getBoolean(GameRules.RULE_NATURAL_REGENERATION)) {
            if (this.getHealth() < this.getMaxHealth() && this.tickCount % 20 == 0) {
                this.heal(1);
            }
        }
        super.aiStep();
    }

    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(BMTagFixes.fixWandererSophieVariantTag(tag));
        tag.remove("Variant");
    }

    public String getVariant() {
        if (BMRegistries.WANDERER_SOPHIE_VARIANT.containsKey(ResourceLocation.tryParse(this.entityData.get(VARIANT)))) {
            return this.entityData.get(VARIANT);
        } else {
            LOGGER.error(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.wanderer_sophie_variant.invalid_get", this.entityData.get(VARIANT))).getString());
        }
        return BMWandererSophieVariants.YELLOW_AXOLOTL.get().getRegistryName().toString();
    }

    public WandererSophieVariant getRegistryVariant() {
        return BMRegistries.WANDERER_SOPHIE_VARIANT.getValue(ResourceLocation.tryParse(this.entityData.get(VARIANT)));
    }

    public void setVariant(WandererSophieVariant variant) {
        if (BMRegistries.WANDERER_SOPHIE_VARIANT.containsValue(variant)) {
            this.entityData.set(VARIANT, variant.getRegistryName().toString());
        } else {
            LOGGER.error(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.wanderer_sophie_variant.invalid_set", variant.getRegistryName().toString())).getString());
        }
    }

    public boolean isAlliedTo(Entity entity) {
        if (super.isAlliedTo(entity)) {
            return true;
        } else return entity.getType().is(BMTags.EntityTypes.SOPHIE_ALLIES);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.1D, Ingredient.of(BMTags.Items.WANDERER_SOPHIE_TEMPT_ITEMS), false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.addAttackTargets();
    }

    protected void addAttackTargets() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, (livEntity) -> livEntity.getType().is(EntityTypeTags.RAIDERS)));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VexEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false));
    }

    public static AttributeModifierMap.MutableAttribute createWandererSophieAttributes() {
        // Old wanderer Sophie health was 70.
        // Old new wanderer Sophie health was 35.
        return CreatureEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.ATTACK_KNOCKBACK, 0.25F).add(Attributes.FOLLOW_RANGE, 12)
                .add(Attributes.ATTACK_DAMAGE, 3).add(Attributes.MOVEMENT_SPEED, 0.25F);
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
        spawnData = super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
        BMUtils.setRandomWSRegistryBasedVariant(this);
        this.populateDefaultEquipmentEnchantments(difficulty);
        this.populateDefaultEquipmentSlots(difficulty);
        return spawnData;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_SOPHIE_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_SOPHIE_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_SOPHIE_HURT_BERRY_BUSH : BMSounds.ENTITY_SOPHIE_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_SOPHIE_DEATH;
    }

    // If this mob can be leashed.
    // Returns: If this mob can be leashed.
    // Old Back Math shenanigans.
    @Override
    public boolean canBeLeashed(PlayerEntity player) {
        return false;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.WANDERER_SOPHIE_SPAWN_EGG.get());
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity && !entity.isInvulnerableTo(DamageSource.IN_FIRE)) {
            ItemStack devilSword = new ItemStack(AxolotlTest.DEVIL_SWORD.get());
            if (this.getItemBySlot(EquipmentSlotType.MAINHAND).equals(devilSword)) {
                LivingEntity livEntity = (LivingEntity) entity;
                livEntity.setSecondsOnFire(5);
            }
        }
        return super.doHurtTarget(entity);
    }

    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
        int i = this.random.nextInt(3);
        if (i == 0) {
            // Variant 1: Angelic Sword, Angelic Chestplate and Cat Tiara
            this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_SWORD.get()));
            this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.CAT_TIARA.get()));
            this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ANGELIC_CHESTPLATE.get()));
        } else if (i == 1) {
            // Variant 2: Devil Sword, Devil Chestplate and Tito
            this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.DEVIL_SWORD.get()));
            this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.DEVIL_CHESTPLATE.get()));
            this.setItemSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.TITO.get()));
        } else {
            // Variant 3: Hardened Amaracamel Helmet, Hardened Amaracamel Chestplate and Butter Sword
            this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_HELMET.get()));
            this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_CHESTPLATE.get()));

            ItemStack butterSword = new ItemStack(AxolotlTest.BUTTER_SWORD.get());
            CompoundNBT tag = butterSword.getOrCreateTag();
            tag.putInt("stored_experience", 55);
            this.setItemSlot(EquipmentSlotType.MAINHAND, butterSword);
        }
    }

    public static boolean checkSophieSpawnRules(EntityType<? extends CreatureEntity> termianFriendly, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return world.getBlockState(pos.below()).is(BMTags.Blocks.SOPHIES_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8;
    }
}
