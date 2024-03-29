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
    private static final DataParameter<Boolean> IS_CHARGING_CROSSBOW = EntityDataManager.createKey(ArcherLucia.class, DataSerializers.BOOLEAN);
    private final Inventory inventory = new Inventory(5);

    public ArcherLucia(EntityType<ArcherLucia> entity, World world) {
        super(entity, world);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(IS_CHARGING_CROSSBOW, false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BMRangedCrossbowAttackGoal<>(this, 1.1d, 12));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.1d, Ingredient.fromTag(BMTags.Items.ARCHER_LUCIA_TEMPT_ITEMS), false));
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

    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        ListNBT inventoryNBTList = new ListNBT();

        for(int i = 0; i < this.inventory.getSizeInventory(); ++i) {
            ItemStack stack = this.inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                inventoryNBTList.add(stack.write(new CompoundNBT()));
            }
        }
        tag.put("Inventory", inventoryNBTList);
    }

    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        ListNBT inventoryNBTList = tag.getList("Inventory", 10);

        for(int i = 0; i < inventoryNBTList.size(); ++i) {
            ItemStack stack = ItemStack.read(inventoryNBTList.getCompound(i));
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
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.RESISTANCE);
    }

    @Override
    public ItemStack findAmmo(ItemStack shootable) {
        if (shootable.getItem() instanceof ShootableItem) {
            Predicate<ItemStack> predicate = ((ShootableItem) shootable.getItem()).getAmmoPredicate();
            ItemStack ammoStack = ShootableItem.getHeldAmmo(this, predicate);
            return ammoStack.isEmpty() ? new ItemStack(Items.ARROW) : ammoStack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    public double getYOffset() {
        return -0.35D;
    }

    public void func_230283_U__() {
        this.idleTime = 0;
    }

    public void setCharging(boolean isCharging) {
        this.dataManager.set(IS_CHARGING_CROSSBOW, isCharging);
    }

    protected void func_241844_w(float f) {
        super.func_241844_w(f);
        if (this.rand.nextInt(300) == 0) {
            ItemStack heldStack = this.getHeldItemMainhand();
            if (heldStack.getItem().isIn(BMTags.Items.CROSSBOWS)) {
                Map<Enchantment, Integer> crossbowEnchantsMap = EnchantmentHelper.getEnchantments(heldStack);
                crossbowEnchantsMap.putIfAbsent(Enchantments.PIERCING, 1);
                EnchantmentHelper.setEnchantments(crossbowEnchantsMap, heldStack);
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, heldStack);
            }
        }
    }

    public boolean isOnSameTeam(Entity entity) {
        if (super.isOnSameTeam(entity)) {
            return true;
        } else return entity instanceof ISophieFriendlies;
    }

    public static AttributeModifierMap.MutableAttribute createArcherLuciaAttributes() {
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 25)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.25F)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F);
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
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return super.onInitialSpawn(world, difficulty, spawnReason, spawnData, dataTag);
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
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ARCHER_LUCIA_HOOD.get()));
        this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ARCHER_LUCIA_VEST.get()));
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_CROSSBOW.get()));
    }

    // Why were Back Math mobs leashable? (29/07/23)
    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    public boolean func_230280_a_(ShootableItem shootableItem) {
        return shootableItem.isIn(BMTags.Items.CROSSBOWS);
    }

    public void setItemStackToSlot(EquipmentSlotType slot, ItemStack stack) {
        super.setItemStackToSlot(slot, stack);
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        this.func_234281_b_(this, 1.6f);
    }

    public void func_230284_a_(LivingEntity livEntity, ItemStack stack, ProjectileEntity arrow, float distanceFactor) {
        this.func_234279_a_(this, livEntity, arrow, distanceFactor, 1.6f);
    }

    protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
        ItemStack stack = itemEntity.getItem();
        if (stack.getItem() instanceof BMArmorItem) {
            super.updateEquipmentIfNeeded(itemEntity);
        } else {
            Item item = stack.getItem();
            if (this.pickupableItems(item)) {
                this.triggerItemPickupTrigger(itemEntity);
                ItemStack stack1 = this.inventory.addItem(stack);
                if (stack1.isEmpty()) {
                    itemEntity.remove();
                } else {
                    stack.setCount(stack1.getCount());
                }
            }
        }
    }

    private boolean pickupableItems(Item item) {
        return item instanceof BMArmorItem || item instanceof BMCrossbowItem || item.isIn(BMTags.Items.ARCHER_LUCIA_PICKUPABLES);
    }

    public boolean replaceItemInInventory(int inventorySlot, ItemStack stack) {
        if (super.replaceItemInInventory(inventorySlot, stack)) {
            return true;
        } else {
            int i = inventorySlot - 300;
            if (i >= 0 && i < this.inventory.getSizeInventory()) {
                this.inventory.setInventorySlotContents(i, stack);
                return true;
            } else {
                return false;
            }
        }
    }
}
