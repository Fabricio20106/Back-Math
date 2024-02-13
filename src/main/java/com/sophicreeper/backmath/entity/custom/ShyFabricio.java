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
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class ShyFabricio extends CreatureEntity {
    public ShyFabricio(EntityType<ShyFabricio> type, World world) {
        super(type, world);
        this.stepHeight = 1;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.1d, Ingredient.fromTag(BMTags.Items.SHY_FABRICIO_TEMPT_ITEMS), true));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, LivingEntity.class, 24, 1.6d, 2.6d, (livEntity) -> !(livEntity instanceof ShyFabricio)));
        this.goalSelector.addGoal(2, new PanicGoal(this, 2.1d));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(4, new LookAtGoal(this, ShyFabricio.class, 6));
        this.goalSelector.addGoal(4, new LookAtGoal(this, Malaika.class, 5));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute createShyFabricioAttributes() {
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23f);
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62f;
    }

    public double getYOffset() {
        return -0.35D;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_FABRICIO_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_FABRICIO_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_FABRICIO_HURT_BERRY_BUSH : BMSounds.ENTITY_FABRICIO_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_FABRICIO_DEATH;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.SHY_FABRICIO_SPAWN_EGG.get());
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
        spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return spawnData;
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getRidingEntity();
            this.renderYawOffset = entity.renderYawOffset;
        }
    }
}
