package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AngrySophie extends MonsterEntity {
    public AngrySophie(EntityType<AngrySophie> type, World world) {
        super(type, world);
        this.xpReward = 3 + this.level.random.nextInt(5);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.applyEntityAI();
        super.registerGoals();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, QueenLucy.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, QueenLucyPet.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, WarriorSophie.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WandererSophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ArcherLucia.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, KarateLucia.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, InsomniaSophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ArcherInsomniaSophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false));
    }

    public static AttributeModifierMap.MutableAttribute createAngrySophieAttributes() {
        return MonsterEntity.createMonsterAttributes()
                // She had 75 health at first (I think) now it's 45, but I think it still a lot.
                // But now she'll have 28 health, because it was still too much.
                .add(Attributes.MAX_HEALTH, 28).add(Attributes.ATTACK_KNOCKBACK, 0.25F).add(Attributes.FOLLOW_RANGE, 12).add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.MOVEMENT_SPEED, 0.23F);
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return 10;
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
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

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.ANGRY_SOPHIE_SPAWN_EGG.get());
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        spawnData = super.finalizeSpawn(world, difficulty, spawnReason, spawnData, dataTag);
        this.populateDefaultEquipmentSlots(difficulty);
        this.populateDefaultEquipmentEnchantments(difficulty);
        return super.finalizeSpawn(world, difficulty, spawnReason, spawnData, dataTag);
    }

    public void rideTick() {
        super.rideTick();
        if (this.getVehicle() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getVehicle();
            this.yBodyRot = entity.yBodyRot;
        }
    }

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
        this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ANGELIC_HELMET.get()));
    }

    protected void dropCustomDeathLoot(DamageSource source, int lootingLevel, boolean wasRecentlyHit) {
        super.dropCustomDeathLoot(source, lootingLevel, wasRecentlyHit);
        Entity entity = source.getEntity();
        if (entity instanceof CreeperEntity) {
            CreeperEntity creeper = (CreeperEntity) entity;
            if (creeper.canDropMobsSkull()) {
                ItemStack skullStack = this.getSkullDrop();
                if (!skullStack.isEmpty()) {
                    creeper.increaseDroppedSkulls();
                    this.spawnAtLocation(skullStack);
                }
            }
        }
    }

    protected ItemStack getSkullDrop() {
        return new ItemStack(AxolotlTest.ANGRY_SOPHIE_HEAD.get());
    }
}
