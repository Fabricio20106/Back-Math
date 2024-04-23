package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.entity.goal.BMRangedCrossbowAttackGoal;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.armor.BMArmorItem;
import com.sophicreeper.backmath.item.custom.weapon.BMCrossbowItem;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Predicate;

public class ArcherLucia extends CreatureEntity implements IBMCrossbowUser, ISophieFriendlies {
    private static final DataParameter<Boolean> IS_CHARGING_CROSSBOW = EntityDataManager.defineId(ArcherLucia.class, DataSerializers.BOOLEAN);
    private final Inventory inventory = new Inventory(5);

    public ArcherLucia(EntityType<ArcherLucia> entity, World world) {
        super(entity, world);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_CHARGING_CROSSBOW, false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BMRangedCrossbowAttackGoal<>(this, 1.1D, 12));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.1D, Ingredient.of(BMTags.Items.ARCHER_LUCIA_TEMPT_ITEMS), false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractIllagerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, QueenLucyPet.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
    }

    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        ListNBT inventoryNBTList = new ListNBT();

        for(int i = 0; i < this.inventory.getContainerSize(); ++i) {
            ItemStack stack = this.inventory.getItem(i);
            if (!stack.isEmpty()) {
                inventoryNBTList.add(stack.save(new CompoundNBT()));
            }
        }
        tag.put("inventory", inventoryNBTList);
    }

    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        ListNBT inventoryNBTList = tag.getList("inventory", 10);

        for(int i = 0; i < inventoryNBTList.size(); ++i) {
            ItemStack stack = ItemStack.of(inventoryNBTList.getCompound(i));
            if (!stack.isEmpty()) {
                this.inventory.addItem(stack);
            }
        }
        this.setCanPickUpLoot(true);
    }

    @Override
    public void tick() {
        super.tick();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.DAMAGE_RESISTANCE);
    }

    @Override
    public ItemStack getProjectile(ItemStack shootable) {
        if (shootable.getItem() instanceof ShootableItem) {
            Predicate<ItemStack> predicate = ((ShootableItem) shootable.getItem()).getAllSupportedProjectiles();
            ItemStack ammoStack = ShootableItem.getHeldProjectile(this, predicate);
            return ammoStack.isEmpty() ? new ItemStack(Items.ARROW) : ammoStack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    public double getMyRidingOffset() {
        return -0.35D;
    }

    public void onCrossbowAttackPerformed() {
        this.noActionTime = 0;
    }

    public void setChargingCrossbow(boolean isCharging) {
        this.entityData.set(IS_CHARGING_CROSSBOW, isCharging);
    }

    protected void enchantSpawnedWeapon(float chance) {
        super.enchantSpawnedWeapon(chance);
        if (this.random.nextInt(300) == 0) {
            ItemStack heldStack = this.getMainHandItem();
            if (heldStack.getItem().is(BMTags.Items.CROSSBOWS)) {
                Map<Enchantment, Integer> crossbowEnchantsMap = EnchantmentHelper.getEnchantments(heldStack);
                crossbowEnchantsMap.putIfAbsent(Enchantments.PIERCING, 1);
                EnchantmentHelper.setEnchantments(crossbowEnchantsMap, heldStack);
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, heldStack);
            }
        }
    }

    public boolean isAlliedTo(Entity entity) {
        if (super.isAlliedTo(entity)) {
            return true;
        } else return entity instanceof ISophieFriendlies;
    }

    public static AttributeModifierMap.MutableAttribute createArcherLuciaAttributes() {
        return CreatureEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 25).add(Attributes.ATTACK_KNOCKBACK, 0.25F).add(Attributes.FOLLOW_RANGE, 12).add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.MOVEMENT_SPEED, 0.23F);
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_LUCIA_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_LUCIA_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_LUCIA_HURT_BERRY_BUSH : BMSounds.ENTITY_LUCIA_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_LUCIA_DEATH;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.ARCHER_LUCIA_SPAWN_EGG.get());
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
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

    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ARCHER_LUCIA_HOOD.get()));
        this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ARCHER_LUCIA_VEST.get()));
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_CROSSBOW.get()));
    }

    // Why were Back Math mobs leashable? (29/07/23)
    @Override
    public boolean canBeLeashed(PlayerEntity player) {
        return false;
    }

    public boolean canFireProjectileWeapon(ShootableItem shootableItem) {
        return shootableItem.is(BMTags.Items.CROSSBOWS);
    }

    public void setItemStackToSlot(EquipmentSlotType slot, ItemStack stack) {
        super.setItemSlot(slot, stack);
    }

    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        this.performCrossbowAttack(this, 1.6F);
    }

    public void shootCrossbowProjectile(LivingEntity livEntity, ItemStack stack, ProjectileEntity arrow, float distanceFactor) {
        this.shootCrossbowProjectile(this, livEntity, arrow, distanceFactor, 1.6F);
    }

    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack stack = itemEntity.getItem();
        if (stack.getItem() instanceof BMArmorItem) {
            super.pickUpItem(itemEntity);
        } else {
            Item item = stack.getItem();
            if (this.wantsItem(item)) {
                this.onItemPickup(itemEntity);
                ItemStack stack1 = this.inventory.addItem(stack);
                if (stack1.isEmpty()) {
                    itemEntity.remove();
                } else {
                    stack.setCount(stack1.getCount());
                }
            }
        }
    }

    private boolean wantsItem(Item item) {
        return item instanceof BMArmorItem || item instanceof BMCrossbowItem || item.is(BMTags.Items.ARCHER_LUCIA_PICKUPABLES);
    }

    public boolean setSlot(int inventorySlot, ItemStack stack) {
        if (super.setSlot(inventorySlot, stack)) {
            return true;
        } else {
            int i = inventorySlot - 300;
            if (i >= 0 && i < this.inventory.getContainerSize()) {
                this.inventory.setItem(i, stack);
                return true;
            } else {
                return false;
            }
        }
    }
}
