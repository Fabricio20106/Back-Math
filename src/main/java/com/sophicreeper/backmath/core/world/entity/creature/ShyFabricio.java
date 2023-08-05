package com.sophicreeper.backmath.core.world.entity.creature;

import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.RayTraceResult;
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
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.1D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.1D, Ingredient.fromItems(AxolotlTest.HONEYED_BREAD.get()), true));
        this.goalSelector.addGoal(2, new ShyFabricioAvoidEntityGoal<>(this, LivingEntity.class, 24.0F, 1.6D, 2.1D));
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

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.SHY_FABRICIO_SPAWN_EGG.get());
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    static class ShyFabricioAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
        public ShyFabricioAvoidEntityGoal(ShyFabricio shyFabricio, Class<T> entityToAvoid, float avoidDistance, double farRunningSpeed, double nearRunningSpeed) {
            super(shyFabricio, entityToAvoid, avoidDistance, farRunningSpeed, nearRunningSpeed);
        }
    }
}
