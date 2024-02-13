package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.entity.goal.BMRangedBowAttackGoal;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.weapon.BMBowItem;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractIllagerEntity;
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
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ArcherInsomniaSophie extends MonsterEntity implements IRangedAttackMob, ISophieFriendlies {
    private final BMRangedBowAttackGoal<ArcherInsomniaSophie> aiArrowAttack = new BMRangedBowAttackGoal<>(this, 1, 20, 15);
    private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2d, false) {
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

    @Override
    public void tick() {
        super.tick();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.RESISTANCE);
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
    }

    public double getYOffset() {
        return -0.35D;
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

    public boolean isOnSameTeam(Entity entity) {
        if (super.isOnSameTeam(entity)) {
            return true;
        } else return entity instanceof ISophieFriendlies;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BMRangedBowAttackGoal<>(this, 1.1d, 8, 8));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractIllagerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, QueenLucyPet.class, false));
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
        double d1 = target.getPosYHeight(0.3333333333333333d) - arrow.getPosY();
        double d2 = target.getPosZ() - this.getPosZ();
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        arrow.shoot(d0, d1 + d3 * (double) 0.2f, d2, 1.6f, (float) (14 - this.world.getDifficulty().getId() * 4));

        this.playSound(BMSounds.ENTITY_SOPHIE_SHOOT, 1, 1 / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.world.addEntity(arrow);
    }

    protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
        return ProjectileHelper.fireArrow(this, arrowStack, distanceFactor);
    }

    public boolean func_230280_a_(ShootableItem shootableItem) {
        return shootableItem instanceof BMBowItem || shootableItem instanceof BowItem;
    }

    public static AttributeModifierMap.MutableAttribute createMobAttributes() {
        return MonsterEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE, 4).createMutableAttribute(Attributes.MAX_HEALTH, 28).createMutableAttribute(Attributes.FOLLOW_RANGE, 12)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23f);
    }

    protected void dropSpecialItems(DamageSource source, int lootingLevel, boolean wasRecentlyHit) {
        super.dropSpecialItems(source, lootingLevel, wasRecentlyHit);
        Entity entity = source.getTrueSource();
        if (entity instanceof CreeperEntity) {
            CreeperEntity creeper = (CreeperEntity) entity;
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
