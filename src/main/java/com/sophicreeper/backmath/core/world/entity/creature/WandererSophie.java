package com.sophicreeper.backmath.core.world.entity.creature;

import com.sophicreeper.backmath.core.world.entity.monster.AngrySophie;
import com.sophicreeper.backmath.core.world.entity.monster.ArcherLucia;
import com.sophicreeper.backmath.core.world.entity.monster.InsomniaSophie;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WandererSophie extends CreatureEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(WandererSophie.class, DataSerializers.VARINT);

    public WandererSophie(EntityType<WandererSophie> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Variant", this.getVariant());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setVariant(compound.getInt("Variant"));
    }

    public int getVariant() {
        return MathHelper.clamp(this.dataManager.get(VARIANT), 0, 11);
    }

    public void setVariant(int variantIn) {
        this.dataManager.set(VARIANT, variantIn);
    }

    public boolean isOnSameTeam(Entity entityIn) {
        if (super.isOnSameTeam(entityIn)) {
            return true;
        } else if (entityIn instanceof ArcherLucia || entityIn instanceof WandererSophie || entityIn instanceof KarateLucia || entityIn instanceof InsomniaSophie) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.1D, Ingredient.fromItems(AxolotlTest.MILKLLARY_CAKE.get()), false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.applyEntityAI();
        super.registerGoals();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false));
    }

    public static AttributeModifierMap.MutableAttribute createWandererSophieAttributes() {
        // Old wanderer Sophie health was 70.0D.
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 35.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.25F)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62F;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setVariant(this.rand.nextInt(12));
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        return spawnDataIn;
    }

    /**
     * If this mob can be leashed to
     * @return If this mob can be leashed to
     */
    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return true;
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        int i = this.rand.nextInt(3);
        if (i == 0) {
            // variable 1: Angelic Sword, Angelic Chestplate and Toti
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_SWORD.get()));
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.CAT_TIARA.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.angelic_chestplate.get()));
        } else if (i == 1) {
            // variable 2: Devil Sword and Devil Chestplate (not including the new tito)
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.DEVIL_SWORD.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.devil_chestplate.get()));
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.TITO.get()));
        } else {
            // variable 3: Cat Tiara and Butter Sword
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_HELMET.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_CHESTPLATE.get()));
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.BUTTER_SWORD.get()));
        }
    }
}
