package com.sophicreeper.backmath.core.world.entity.monster;

import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.goal.BMRangedBowAttackGoal;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.item.weapon.BMBowItem;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ArcherInsomniaSophie extends MonsterEntity implements IRangedAttackMob {
    private final BMRangedBowAttackGoal<ArcherInsomniaSophie> aiArrowAttack = new BMRangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2D, false) {
        public void resetTask() {
            super.resetTask();
            ArcherInsomniaSophie.this.setAggroed(false);
        }

        public void startExecuting() {
            super.startExecuting();
            ArcherInsomniaSophie.this.setAggroed(true);
        }
    };

    public ArcherInsomniaSophie(EntityType<ArcherInsomniaSophie> type, World world) {
        super(type, world);
        this.setCombatTask();
        this.experienceValue = 3 + this.world.rand.nextInt(6);
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getRidingEntity();
            this.renderYawOffset = entity.renderYawOffset;
        }
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_BOW.get()));
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.ARCHER_INSOMNIA_SOPHIE_SPAWN_EGG.get());
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        spawnData = super.onInitialSpawn(world, difficulty, spawnReason, spawnData, dataTag);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        this.setCombatTask();
        return spawnData;
    }

    public void setCombatTask() {
        if (this.world != null && !this.world.isRemote) {
            this.goalSelector.removeGoal(this.aiAttackOnCollide);
            this.goalSelector.removeGoal(this.aiArrowAttack);
            ItemStack bowStack = this.getHeldItem(ProjectileHelper.getHandWith(this, AxolotlTest.ANGELIC_BOW.get()));
            if (bowStack.getItem() instanceof BMBowItem) {
                int attackCooldown = 20;
                if (this.world.getDifficulty() != Difficulty.HARD) {
                    attackCooldown = 40;
                }

                this.aiArrowAttack.setAttackCooldown(attackCooldown);
                this.goalSelector.addGoal(4, this.aiArrowAttack);
            } else {
                this.goalSelector.addGoal(4, this.aiAttackOnCollide);
            }

        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BMRangedBowAttackGoal<>(this, 1.1D, 8, 8.0f));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenSophiePet.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack ammoStack = this.findAmmo(this.getHeldItem(ProjectileHelper.getHandWith(this, AxolotlTest.ANGELIC_BOW.get())));
        AbstractArrowEntity arrow = this.fireArrow(ammoStack, distanceFactor);

        if (this.getHeldItemMainhand().getItem() instanceof BMBowItem) arrow = ((BMBowItem) this.getHeldItemMainhand().getItem()).customArrow(arrow);

        double d0 = target.getPosX() - this.getPosX();
        double d1 = target.getPosYHeight(0.3333333333333333D) - arrow.getPosY();
        double d2 = target.getPosZ() - this.getPosZ();
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        arrow.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.world.getDifficulty().getId() * 4));

        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(arrow);
    }

    protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
        return ProjectileHelper.fireArrow(this, arrowStack, distanceFactor);
    }

    public boolean func_230280_a_(ShootableItem shootableItem) {
        return shootableItem instanceof BMBowItem || shootableItem instanceof BowItem;
    }

    public static AttributeModifierMap.MutableAttribute createMobAttributes() {
        return MonsterEntity.func_233666_p_()
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0f)
                .createMutableAttribute(Attributes.MAX_HEALTH, 28.0f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23f);
    }

    protected void dropSpecialItems(DamageSource source, int lootingLevel, boolean wasRecentlyHit) {
        super.dropSpecialItems(source, lootingLevel, wasRecentlyHit);
        Entity entity = source.getTrueSource();
        if (entity instanceof CreeperEntity) {
            CreeperEntity creeper = (CreeperEntity) entity;
            // If it is a charged creeper
            if (creeper.ableToCauseSkullDrop()) {
                ItemStack skullStack = this.getSkullDrop();
                if (!skullStack.isEmpty()) {
                    creeper.incrementDroppedSkulls();
                    this.entityDropItem(skullStack);
                }
            }
        }
    }

    protected ItemStack getSkullDrop() {
        return new ItemStack(AxolotlTest.INSOMNIA_SOPHIE_HEAD.get());
    }
}
