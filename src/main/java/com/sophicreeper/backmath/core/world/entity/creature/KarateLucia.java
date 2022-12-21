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
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class KarateLucia extends CreatureEntity {
    public KarateLucia(EntityType<KarateLucia> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
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
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.applyEntityAI();
        super.registerGoals();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5D, false));
    }

    public static AttributeModifierMap.MutableAttribute createKarateLuciaAttributes() {
        return CreatureEntity.func_233666_p_()
                // Old karate Lucia health was 50.0d.
                .createMutableAttribute(Attributes.MAX_HEALTH, 28.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 32.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F)
                .createMutableAttribute(Attributes.ARMOR, 3.0d);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62F;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        return spawnDataIn;
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficultyIn) {
        super.setEquipmentBasedOnDifficulty(difficultyIn);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.KARATE_TRAINING_STICK.get()));
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.YELLOW_KARATE_BAND.get()));
    }
}
