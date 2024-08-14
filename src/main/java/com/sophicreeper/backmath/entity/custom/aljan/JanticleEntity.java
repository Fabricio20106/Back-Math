package com.sophicreeper.backmath.entity.custom.aljan;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.*;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class JanticleEntity extends MonsterEntity {
    public JanticleEntity(World world) {
        this(BMEntities.JANTICLE.get(), world);
    }

    public JanticleEntity(EntityType<JanticleEntity> entity, World world) {
        super(entity, world);
        this.moveControl = new FlyingMovementController(this, 10, false);
        this.setPathfindingMalus(PathNodeType.DANGER_FIRE, -1);
        this.setPathfindingMalus(PathNodeType.DAMAGE_FIRE, -1);
        this.setPathfindingMalus(PathNodeType.COCOA, -1);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2d, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomFlyingGoal(this, 1));
        this.goalSelector.addGoal(4, new LookAtGoal(this, JanticleEntity.class, 8));
        this.goalSelector.addGoal(4, new LookAtGoal(this, InsomniaZombieEntity.class, 8));
        this.goalSelector.addGoal(4, new LookAtGoal(this, ZombieFabricioEntity.class, 8));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MalaikaEntity.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, QueenLucyEntity.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WolfEntity.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, CatEntity.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ParrotEntity.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, QueenLucyPetEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WandererSophieEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaSophieEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherInsomniaSophieEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherLuciaEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WarriorSophieEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, KarateLuciaEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricioEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, false));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute createJanticleAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.MAX_HEALTH, 15).add(Attributes.FLYING_SPEED, 0.4f)
                .add(Attributes.ATTACK_DAMAGE, 2);
    }

    public void tick() {
        Vector3d vec3D = this.getDeltaMovement();
        if (this.level.isClientSide) {
            this.level.addParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.DIAMOND_BLOCK.defaultBlockState()), this.getX() - vec3D.x, this.getY() - vec3D.y + 0.15D, this.getZ() - vec3D.z, 0, 0, 0);
            this.level.addParticle(ParticleTypes.WARPED_SPORE, this.getX() - vec3D.x, this.getY() - vec3D.y + 0.15D, this.getZ() - vec3D.z, 0, 0, 0);
        }
        super.tick();
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {}

    @Override
    protected PathNavigator createNavigation(World world) {
        FlyingPathNavigator pathNavigator = new FlyingPathNavigator(this, world);
        pathNavigator.setCanFloat(true);
        pathNavigator.setCanOpenDoors(true);
        return pathNavigator;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 0.25f;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.JANTICLE_SPAWN_EGG.get());
    }
}
