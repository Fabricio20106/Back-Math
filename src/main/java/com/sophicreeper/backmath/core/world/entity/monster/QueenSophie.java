package com.sophicreeper.backmath.core.world.entity.monster;

import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.entity.BMEntities;
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
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class QueenSophie extends MonsterEntity {
    private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);
    private static final DataParameter<Byte> SPELL = EntityDataManager.createKey(QueenSophie.class, DataSerializers.BYTE);
    protected int spellTicks;

    public QueenSophie(EntityType<QueenSophie> type, World worldIn) {
        super(type, worldIn);
        this.setHealth(this.getMaxHealth());
        this.getNavigator().setCanSwim(true);
        this.experienceValue = 150;
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SPELL, (byte) 0);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.spellTicks = compound.getInt("SpellTicks");
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("SpellTicks", this.spellTicks);
    }

    public boolean isSpellcasting() {
        if (this.world.isRemote) {
            return this.dataManager.get(SPELL) > 0;
        } else {
            return this.spellTicks > 0;
        }
    }

    public void setSpellType(QueenSophie.BMSpellType spellType) {
        this.dataManager.set(SPELL, (byte) spellType.id);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new SummonWarriorSpellGoal());
        this.goalSelector.addGoal(2, new SummonArchersSpellGoal());
        this.goalSelector.addGoal(2, new SummonInsomniaSpellGoal());
        this.goalSelector.addGoal(3, new EquipArmorAndHealSpellGoal());
        this.goalSelector.addGoal(4, new PanicGoal(this, 0.40f));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookAtGoal(this, WarriorSophie.class, 6.0F));
        this.goalSelector.addGoal(5, new LookAtGoal(this, ArcherLucia.class, 6.0F));
        this.goalSelector.addGoal(5, new LookAtGoal(this, InsomniaSophie.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.applyMobAI();
        super.registerGoals();
    }

    protected void applyMobAI() {
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, QueenSophiePet.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, QueenSophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
    }

    protected void updateAITasks() {
        super.updateAITasks();
        if (this.spellTicks > 0) {
            --this.spellTicks;
        }
        if (this.ticksExisted % 10 == 0) {
            this.heal(2.0F);
        }
        if (this.ticksExisted % 20 == 0) {
            this.heal(3.0F);
        }

        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    public boolean addPotionEffect(EffectInstance effectInstanceIn) {
        return false;
    }

    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropSpecialItems(source, looting, recentlyHitIn);
        ItemEntity item = this.entityDropItem(AxolotlTest.QUEEN_SOPHIE_SUMMONER_STAFF.get());
        if (item != null) {
            item.setNoDespawn();
        }
    }

    /**
     * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in order
     * to view its associated boss bar.
     */
    public void addTrackingPlayer(ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    /**
     * Removes the given player from the list of players tracking this entity. See {@link Entity#addTrackingPlayer} for
     * more information on tracking.
     */
    public void removeTrackingPlayer(ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public boolean isNonBoss() {
        return false;
    }

    public static AttributeModifierMap.MutableAttribute createQueenSophieAttributes() {
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0f)
                .createMutableAttribute(Attributes.MAX_HEALTH, 350.0f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 100.0f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30f);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.QUEEN_SOPHIE_SUMMONER_STAFF.get()));
    }

    public enum BMSpellType {
        NONE(0, 0.0D, 0.0D, 0.0D),
        SUMMON_WARRIOR_SOPHIES(1, 0.7D, 0.7D, 0.8D),
        SUMMON_ARCHER_LUCIAS(2, 0.7D, 0.7D, 0.8D),
        SUMMON_INSOMNIA_SOPHIES(3, 0.7D, 0.7D, 0.8D),
        EQUIP_MID_TERM_BREASTPLATE_AND_HEAL(4, 0.7d, 0.7d, 0.7d);

        private final int id;

        BMSpellType(int idIn, double xParticleSpeed, double yParticleSpeed, double zParticleSpeed) {
            this.id = idIn;
            double[] particleSpeed = new double[]{
                    xParticleSpeed, yParticleSpeed, zParticleSpeed
            };
        }

        public static QueenSophie.BMSpellType getFromId(int idIn) {
            for(QueenSophie.BMSpellType spellType : values()) {
                if (idIn == spellType.id) {
                    return spellType;
                }
            }
            return NONE;
        }
    }

    protected SoundEvent getSpellSound() {
        return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
    }

    public abstract class UseSpellGoal extends Goal {
        protected int spellWarmup;
        protected int spellCooldown;

        protected UseSpellGoal() {}

        public boolean shouldExecute() {
            LivingEntity livingentity = QueenSophie.this.getAttackTarget();
            if (livingentity != null && livingentity.isAlive()) {
                if (QueenSophie.this.isSpellcasting()) {
                    return false;
                } else {
                    return QueenSophie.this.ticksExisted >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        public boolean shouldContinueExecuting() {
            LivingEntity livingEntity = QueenSophie.this.getAttackTarget();
            return livingEntity != null && livingEntity.isAlive() && this.spellWarmup > 0;
        }

        public void startExecuting() {
            this.spellWarmup = this.getCastWarmupTime();
            QueenSophie.this.spellTicks = this.getCastingTime();
            this.spellCooldown = QueenSophie.this.ticksExisted + this.getCastingInterval();
            SoundEvent prepareSpellSound = this.getSpellPrepareSound();
            if (prepareSpellSound != null) {
                QueenSophie.this.playSound(prepareSpellSound, 1.0F, 1.0F);
            }
            QueenSophie.this.setSpellType(this.getSpellType());
        }

        public void tick() {
            --this.spellWarmup;
            if (this.spellWarmup == 0) {
                this.castSpell();
                QueenSophie.this.playSound(QueenSophie.this.getSpellSound(), 1.0F, 1.0F);
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
            return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
        }

        protected abstract QueenSophie.BMSpellType getSpellType();
    }

    class SummonWarriorSpellGoal extends QueenSophie.UseSpellGoal {
        private final EntityPredicate entityPredicate = new EntityPredicate()
                .setDistance(16.0D)
                .setLineOfSiteRequired()
                .setUseInvisibilityCheck()
                .allowInvulnerable()
                .allowFriendlyFire();

        private SummonWarriorSpellGoal() {}

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else {
                int i = QueenSophie.this.world.getTargettableEntitiesWithinAABB(WarriorSophie.class, this.entityPredicate, QueenSophie.this, QueenSophie.this.getBoundingBox().grow(16.0D)).size();
                return QueenSophie.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime() {
            return 100;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            ServerWorld serverWorld = (ServerWorld) QueenSophie.this.world;

            for(int i = 0; i < 3; ++i) {
                BlockPos pos = QueenSophie.this.getPosition().add(-2 + QueenSophie.this.rand.nextInt(5), 1, -2 + QueenSophie.this.rand.nextInt(5));
                WarriorSophie warriorSophie = BMEntities.WARRIOR_SOPHIE.get().create(QueenSophie.this.world);
                warriorSophie.moveToBlockPosAndAngles(pos, 0.0F, 0.0F);
                warriorSophie.onInitialSpawn(serverWorld, QueenSophie.this.world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
                serverWorld.func_242417_l(warriorSophie);
            }
        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
        }

        protected QueenSophie.BMSpellType getSpellType() {
            return BMSpellType.SUMMON_WARRIOR_SOPHIES;
        }
    }

    class SummonInsomniaSpellGoal extends QueenSophie.UseSpellGoal {
        private final EntityPredicate entityPredicate = new EntityPredicate()
                .setDistance(16.0D)
                .setLineOfSiteRequired()
                .setUseInvisibilityCheck()
                .allowInvulnerable()
                .allowFriendlyFire();

        private SummonInsomniaSpellGoal() {}

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else {
                int i = QueenSophie.this.world.getTargettableEntitiesWithinAABB(InsomniaSophie.class, this.entityPredicate, QueenSophie.this, QueenSophie.this.getBoundingBox().grow(16.0D)).size();
                return QueenSophie.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime() {
            return 100;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            ServerWorld serverWorld = (ServerWorld) QueenSophie.this.world;

            for(int i = 0; i < 3; ++i) {
                BlockPos pos = QueenSophie.this.getPosition().add(-2 + QueenSophie.this.rand.nextInt(5), 1, -2 + QueenSophie.this.rand.nextInt(5));
                InsomniaSophie insomniaSophie = BMEntities.INSOMNIA_SOPHIE.get().create(QueenSophie.this.world);
                insomniaSophie.moveToBlockPosAndAngles(pos, 0.0F, 0.0F);
                insomniaSophie.onInitialSpawn(serverWorld, QueenSophie.this.world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
                serverWorld.func_242417_l(insomniaSophie);
            }
        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
        }

        protected QueenSophie.BMSpellType getSpellType() {
            return BMSpellType.SUMMON_INSOMNIA_SOPHIES;
        }
    }

    class SummonArchersSpellGoal extends QueenSophie.UseSpellGoal {
        private final EntityPredicate entityPredicate = new EntityPredicate()
                .setDistance(16.0D)
                .setLineOfSiteRequired()
                .setUseInvisibilityCheck()
                .allowInvulnerable()
                .allowFriendlyFire();

        private SummonArchersSpellGoal() {}

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else {
                int i = QueenSophie.this.world.getTargettableEntitiesWithinAABB(ArcherLucia.class, this.entityPredicate, QueenSophie.this, QueenSophie.this.getBoundingBox().grow(16.0D)).size();
                return QueenSophie.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime() {
            return 100;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            ServerWorld serverWorld = (ServerWorld) QueenSophie.this.world;

            for(int i = 0; i < 3; ++i) {
                BlockPos pos = QueenSophie.this.getPosition().add(-2 + QueenSophie.this.rand.nextInt(5), 1, -2 + QueenSophie.this.rand.nextInt(5));
                ArcherLucia archerLucia = BMEntities.ARCHER_LUCIA.get().create(QueenSophie.this.world);
                archerLucia.moveToBlockPosAndAngles(pos, 0.0F, 0.0F);
                archerLucia.onInitialSpawn(serverWorld, QueenSophie.this.world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
                serverWorld.func_242417_l(archerLucia);
            }
        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
        }

        protected QueenSophie.BMSpellType getSpellType() {
            return BMSpellType.SUMMON_ARCHER_LUCIAS;
        }
    }

    class EquipArmorAndHealSpellGoal extends QueenSophie.UseSpellGoal {
        private EquipArmorAndHealSpellGoal() {}

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
            QueenSophie.this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.MID_TERM_BREASTPLATE.get()));
            QueenSophie.this.heal(25.0f);
        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
        }

        protected QueenSophie.BMSpellType getSpellType() {
            return BMSpellType.EQUIP_MID_TERM_BREASTPLATE_AND_HEAL;
        }
    }
}
