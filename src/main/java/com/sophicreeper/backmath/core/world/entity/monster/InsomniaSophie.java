package com.sophicreeper.backmath.core.world.entity.monster;

import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.WandererSophie;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class InsomniaSophie extends MonsterEntity {
    public InsomniaSophie(EntityType<InsomniaSophie> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 3 + this.world.rand.nextInt(6);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.6f));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.6f, false));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, QueenSophiePet.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, WolfEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractIllagerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute createInsomniaSophieAttributes() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0f)
                .createMutableAttribute(Attributes.MAX_HEALTH, 28.0f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23f);
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

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        return spawnDataIn;
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_SWORD.get()));
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (!super.attackEntityAsMob(entity)) {
            return false;
        } else {
            if (entity instanceof LivingEntity && !(entity instanceof InsomniaSophie || entity instanceof ArcherInsomniaSophie)) {
                ((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.POISON, 200));
                ((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 600));
            }
            return true;
        }
    }
}
