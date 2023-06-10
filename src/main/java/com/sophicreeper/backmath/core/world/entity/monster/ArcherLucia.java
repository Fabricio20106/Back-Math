package com.sophicreeper.backmath.core.world.entity.monster;

import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.item.armor.BMArmorItem;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.WandererSophie;
import com.sophicreeper.backmath.core.world.entity.goal.BMRangedCrossbowAttackGoal;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Predicate;

public class ArcherLucia extends CreatureEntity implements ICrossbowUser {
    private static final DataParameter<Boolean> IS_CHARGING_CROSSBOW = EntityDataManager.createKey(ArcherLucia.class, DataSerializers.BOOLEAN);
    private final Inventory inventory = new Inventory(5);

    public ArcherLucia(EntityType<ArcherLucia> entity, World worldIn) {
        super(entity, worldIn);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(IS_CHARGING_CROSSBOW, false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BMRangedCrossbowAttackGoal<>(this, 1.1D, 8.0f));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.APPLE), false));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, QueenSophiePet.class, false));
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

    public void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        ListNBT inventoryNBTList = new ListNBT();

        for(int i = 0; i < this.inventory.getSizeInventory(); ++i) {
            ItemStack stack = this.inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                inventoryNBTList.add(stack.write(new CompoundNBT()));
            }
        }
        compoundNBT.put("Inventory", inventoryNBTList);
    }

    public void readAdditional(CompoundNBT compoundNBT) {
        super.readAdditional(compoundNBT);
        ListNBT inventoryNBTList = compoundNBT.getList("Inventory", 10);

        for(int i = 0; i < inventoryNBTList.size(); ++i) {
            ItemStack stack = ItemStack.read(inventoryNBTList.getCompound(i));
            if (!stack.isEmpty()) {
                this.inventory.addItem(stack);
            }
        }
        this.setCanPickUpLoot(true);
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
            if (heldStack.getItem() == AxolotlTest.ANGELIC_CROSSBOW.get()) {
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
        } else if (entity instanceof ArcherLucia || entity instanceof WandererSophie || entity instanceof KarateLucia || entity instanceof InsomniaSophie) {
            return this.getTeam() == null && entity.getTeam() == null;
        } else {
            return false;
        }
    }

    public static AttributeModifierMap.MutableAttribute createArcherLuciaAttributes() {
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.25F)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F);
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
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

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ARCHER_LUCIA_HOOD.get()));
        this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ARCHER_LUCIA_VEST.get()));
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_CROSSBOW.get()));
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return true;
    }

    public boolean func_230280_a_(ShootableItem shootableItem) {
        return shootableItem == AxolotlTest.ANGELIC_CROSSBOW.get();
    }

    public void setItemStackToSlot(EquipmentSlotType slot, ItemStack stack) {
        super.setItemStackToSlot(slot, stack);
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        this.func_234281_b_(this, 1.6F);
    }

    public void func_230284_a_(LivingEntity livingEntity, ItemStack stack, ProjectileEntity arrow, float p_230284_4_) {
        this.func_234279_a_(this, livingEntity, arrow, p_230284_4_, 1.6F);
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
        return item instanceof BMArmorItem;
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
