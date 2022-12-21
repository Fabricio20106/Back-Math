package com.sophicreeper.backmath.core.world.entity.creature;

import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import com.sophicreeper.backmath.core.world.entity.monster.*;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ShyFabricio extends CreatureEntity {
    public ShyFabricio(EntityType<ShyFabricio> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.1D, Ingredient.fromItems(AxolotlTest.HONEYED_BREAD.get()), true));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, PlayerEntity.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, AngrySophie.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, WandererSophie.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, WarriorSophie.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, ArcherLucia.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, KarateLucia.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, InsomniaSophie.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, ArcherInsomniaSophie.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, InsomniaZombie.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, ZombieFabricio.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, AljamicBones.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, SleepishSkeleton.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, Amaracameler.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(2, new ShyFabricio.AvoidEntityGoal<>(this, Janticle.class, 24.0F, 2.1D, 1.6D));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookAtGoal(this, ShyFabricio.class, 6.0F));
        this.goalSelector.addGoal(4, new LookAtGoal(this, Malaika.class, 5.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute createShyFabricioAttributes() {
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62F;
    }

    static class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
        public AvoidEntityGoal(ShyFabricio fab, Class<T> p_i46403_2_, float p_i46403_3_, double p_i46403_4_, double p_i46403_6_) {
            super(fab, p_i46403_2_, p_i46403_3_, p_i46403_4_, p_i46403_6_);
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
}
