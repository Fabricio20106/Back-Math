package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class QueenLucy extends MonsterEntity implements ISophieFriendlies {
    private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.NOTCHED_6);
    private static final DataParameter<Byte> SPELL = EntityDataManager.createKey(QueenLucy.class, DataSerializers.BYTE);
    protected int spellTicks;

    public QueenLucy(EntityType<QueenLucy> type, World world) {
        super(type, world);
        this.setHealth(this.getMaxHealth());
        this.getNavigator().setCanSwim(true);
        this.experienceValue = 450;
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SPELL, (byte) 0);
    }

    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        this.spellTicks = tag.getInt("SpellTicks");
    }

    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putInt("SpellTicks", this.spellTicks);
    }

    public boolean isSpellcasting() {
        if (this.world.isRemote) {
            return this.dataManager.get(SPELL) > 0;
        } else {
            return this.spellTicks > 0;
        }
    }

    public void setSpellType(QueenSophieSpells spells) {
        this.dataManager.set(SPELL, (byte) spells.id);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new SummonWarriorSophiesGoal());
        this.goalSelector.addGoal(2, new SummonArcherInsomniaSophiesGoal());
        this.goalSelector.addGoal(2, new SummonInsomniaSophiesGoal());
        this.goalSelector.addGoal(3, new EquipArmorAndHealGoal());
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, WarriorSophie.class, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, ArcherInsomniaSophie.class, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, InsomniaSophie.class, 6));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.applyMobAI();
        super.registerGoals();
    }

    protected void applyMobAI() {
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, QueenLucyPet.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
    }

    protected void updateAITasks() {
        super.updateAITasks();
        if (this.spellTicks > 0) {
            --this.spellTicks;
        }
        if (this.ticksExisted % 20 == 0) {
            this.heal(2);
        }
        if (this.ticksExisted % 30 == 0) {
            this.heal(3);
        }

        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void tick() {
        super.tick();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.RESISTANCE);
    }

    public void livingTick() {
        this.updateArmSwingProgress();
        super.livingTick();
    }

    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    public boolean addPotionEffect(EffectInstance instance) {
        return false;
    }

    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void dropSpecialItems(DamageSource source, int lootingLevel, boolean wasRecentlyHit) {
        super.dropSpecialItems(source, lootingLevel, wasRecentlyHit);
        ItemEntity staffStack = this.entityDropItem(AxolotlTest.QUEEN_LUCY_SUMMONER_STAFF.get());
        if (staffStack != null) {
            staffStack.setNoDespawn();
        }
    }

    // Add the given player to the list of players tracking this entity.
    // For instance, a player may track a boss in order to view its associated boss bar.
    public void addTrackingPlayer(ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    // Removes the given player from the list of players tracking this entity.
    // See Entity#addTrackingPlayer(ServerPlayerEntity) for more information on tracking.
    public void removeTrackingPlayer(ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public boolean isNonBoss() {
        return false;
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    public static AttributeModifierMap.MutableAttribute createQueenLucyAttributes() {
        return CreatureEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE, 8).createMutableAttribute(Attributes.MAX_HEALTH, 250).createMutableAttribute(Attributes.FOLLOW_RANGE, 100)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30f);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.QUEEN_LUCY_SUMMONER_STAFF.get()));
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

    public boolean isOnSameTeam(Entity entity) {
        if (super.isOnSameTeam(entity)) {
            return true;
        } else return entity instanceof ISophieFriendlies;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.QUEEN_LUCY_SPAWN_EGG.get());
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getRidingEntity();
            this.renderYawOffset = entity.renderYawOffset;
        }
    }

    public enum QueenSophieSpells {
        NONE(0),
        SUMMON_WARRIOR_SOPHIES(1),
        SUMMON_ARCHER_INSOMNIA_SOPHIES(2),
        SUMMON_INSOMNIA_SOPHIES(3),
        EQUIP_DIAMOND_CHESTPLATE_AND_HEAL(4);

        private final int id;

        QueenSophieSpells(int id) {
            this.id = id;
        }
    }

    protected SoundEvent getSpellSound() {
        return BMSounds.ENTITY_QUEEN_LUCY_CAST_SPELL;
    }

    public abstract class UseSpellGoal extends Goal {
        protected int spellWarmup;
        protected int spellCooldown;

        protected UseSpellGoal() {}

        public boolean shouldExecute() {
            LivingEntity queenSophieTarget = QueenLucy.this.getAttackTarget();
            if (queenSophieTarget != null && queenSophieTarget.isAlive()) {
                if (QueenLucy.this.isSpellcasting()) {
                    return false;
                } else {
                    return QueenLucy.this.ticksExisted >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        public boolean shouldContinueExecuting() {
            LivingEntity queenSophieTarget = QueenLucy.this.getAttackTarget();
            return queenSophieTarget != null && queenSophieTarget.isAlive() && this.spellWarmup > 0;
        }

        public void startExecuting() {
            this.spellWarmup = this.getCastWarmupTime();
            QueenLucy.this.spellTicks = this.getCastingTime();
            this.spellCooldown = QueenLucy.this.ticksExisted + this.getCastingInterval();
            SoundEvent prepareSpellSound = this.getSpellPrepareSound();
            if (prepareSpellSound != null) {
                QueenLucy.this.playSound(prepareSpellSound, 1, 1);
            }
            QueenLucy.this.setSpellType(this.getSpellType());
        }

        public void tick() {
            --this.spellWarmup;
            if (this.spellWarmup == 0) {
                this.castSpell();
                QueenLucy.this.playSound(QueenLucy.this.getSpellSound(), 1, 1);
            }
        }

        protected abstract void castSpell();

        protected int getCastWarmupTime() {
            return 20;
        }

        protected abstract int getCastingTime();

        protected abstract int getCastingInterval();

        @Nullable
        protected SoundEvent getSpellPrepareSound() {
            return BMSounds.ENTITY_QUEEN_LUCY_PREPARE_SUMMON;
        }

        protected abstract QueenSophieSpells getSpellType();
    }

    class SummonWarriorSophiesGoal extends UseSpellGoal {
        private final EntityPredicate entityPredicate = new EntityPredicate().setDistance(16).setLineOfSiteRequired().setUseInvisibilityCheck().allowInvulnerable().allowFriendlyFire();

        private SummonWarriorSophiesGoal() {}

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else {
                int i = QueenLucy.this.world.getTargettableEntitiesWithinAABB(WarriorSophie.class, this.entityPredicate, QueenLucy.this, QueenLucy.this.getBoundingBox().grow(16)).size();
                return QueenLucy.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime() {
            return 100;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            ServerWorld serverWorld = (ServerWorld) QueenLucy.this.world;

            for(int i = 0; i < 3; ++i) {
                BlockPos pos = QueenLucy.this.getPosition().add(-2 + QueenLucy.this.rand.nextInt(5), 1, -2 + QueenLucy.this.rand.nextInt(5));
                WarriorSophie warriorSophie = BMEntities.WARRIOR_SOPHIE.get().create(QueenLucy.this.world);
                warriorSophie.moveToBlockPosAndAngles(pos, 0, 0);
                warriorSophie.onInitialSpawn(serverWorld, QueenLucy.this.world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
                serverWorld.func_242417_l(warriorSophie);
            }
        }

        protected SoundEvent getSpellPrepareSound() {
            return BMSounds.ENTITY_QUEEN_LUCY_PREPARE_SUMMON;
        }

        protected QueenSophieSpells getSpellType() {
            return QueenSophieSpells.SUMMON_WARRIOR_SOPHIES;
        }
    }

    class SummonInsomniaSophiesGoal extends UseSpellGoal {
        private final EntityPredicate entityPredicate = new EntityPredicate()
                .setDistance(16)
                .setLineOfSiteRequired()
                .setUseInvisibilityCheck()
                .allowInvulnerable()
                .allowFriendlyFire();

        private SummonInsomniaSophiesGoal() {}

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else {
                int i = QueenLucy.this.world.getTargettableEntitiesWithinAABB(InsomniaSophie.class, this.entityPredicate, QueenLucy.this, QueenLucy.this.getBoundingBox().grow(16)).size();
                return QueenLucy.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime() {
            return 100;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            ServerWorld serverWorld = (ServerWorld) QueenLucy.this.world;

            for(int i = 0; i < 3; ++i) {
                BlockPos pos = QueenLucy.this.getPosition().add(-2 + QueenLucy.this.rand.nextInt(5), 1, -2 + QueenLucy.this.rand.nextInt(5));
                InsomniaSophie insomniaSophie = BMEntities.INSOMNIA_SOPHIE.get().create(QueenLucy.this.world);
                insomniaSophie.moveToBlockPosAndAngles(pos, 0, 0);
                insomniaSophie.onInitialSpawn(serverWorld, QueenLucy.this.world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
                serverWorld.func_242417_l(insomniaSophie);
            }
        }

        protected SoundEvent getSpellPrepareSound() {
            return BMSounds.ENTITY_QUEEN_LUCY_PREPARE_SUMMON;
        }

        protected QueenSophieSpells getSpellType() {
            return QueenSophieSpells.SUMMON_INSOMNIA_SOPHIES;
        }
    }

    class SummonArcherInsomniaSophiesGoal extends UseSpellGoal {
        private final EntityPredicate entityPredicate = new EntityPredicate()
                .setDistance(16)
                .setLineOfSiteRequired()
                .setUseInvisibilityCheck()
                .allowInvulnerable()
                .allowFriendlyFire();

        private SummonArcherInsomniaSophiesGoal() {}

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else {
                int i = QueenLucy.this.world.getTargettableEntitiesWithinAABB(ArcherInsomniaSophie.class, this.entityPredicate, QueenLucy.this, QueenLucy.this.getBoundingBox().grow(16)).size();
                return QueenLucy.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime() {
            return 100;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            ServerWorld serverWorld = (ServerWorld) QueenLucy.this.world;

            for(int i = 0; i < 3; ++i) {
                BlockPos pos = QueenLucy.this.getPosition().add(-2 + QueenLucy.this.rand.nextInt(5), 1, -2 + QueenLucy.this.rand.nextInt(5));
                ArcherInsomniaSophie archerInsomniaSophie = BMEntities.ARCHER_INSOMNIA_SOPHIE.get().create(QueenLucy.this.world);
                archerInsomniaSophie.moveToBlockPosAndAngles(pos, 0, 0);
                archerInsomniaSophie.onInitialSpawn(serverWorld, QueenLucy.this.world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
                serverWorld.func_242417_l(archerInsomniaSophie);
            }
        }

        protected SoundEvent getSpellPrepareSound() {
            return BMSounds.ENTITY_QUEEN_LUCY_PREPARE_SUMMON;
        }

        protected QueenSophieSpells getSpellType() {
            return QueenSophieSpells.SUMMON_ARCHER_INSOMNIA_SOPHIES;
        }
    }

    public class EquipArmorAndHealGoal extends UseSpellGoal {
        private EquipArmorAndHealGoal() {}

        public boolean shouldExecute() {
            return super.shouldExecute();
        }

        protected int getCastingTime() {
            return 100;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            QueenLucy.this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
            QueenLucy.this.heal(25);
        }

        protected SoundEvent getSpellPrepareSound() {
            return BMSounds.ENTITY_QUEEN_LUCY_PREPARE_HEAL;
        }

        protected QueenSophieSpells getSpellType() {
            return QueenSophieSpells.EQUIP_DIAMOND_CHESTPLATE_AND_HEAL;
        }
    }
}
