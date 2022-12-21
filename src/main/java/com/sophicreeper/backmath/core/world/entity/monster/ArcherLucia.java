package com.sophicreeper.backmath.core.world.entity.monster;

import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.item.BMArmorItem;
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

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        ListNBT listnbt = new ListNBT();

        for(int i = 0; i < this.inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = this.inventory.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                listnbt.add(itemstack.write(new CompoundNBT()));
            }
        }
        compound.put("Inventory", listnbt);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        ListNBT listnbt = compound.getList("Inventory", 10);

        for(int i = 0; i < listnbt.size(); ++i) {
            ItemStack itemstack = ItemStack.read(listnbt.getCompound(i));
            if (!itemstack.isEmpty()) {
                this.inventory.addItem(itemstack);
            }
        }
        this.setCanPickUpLoot(true);
    }

    @Override
    public ItemStack findAmmo(ItemStack shootable) {
        if (shootable.getItem() instanceof ShootableItem) {
            Predicate<ItemStack> predicate = ((ShootableItem) shootable.getItem()).getAmmoPredicate();
            ItemStack itemstack = ShootableItem.getHeldAmmo(this, predicate);
            return itemstack.isEmpty() ? new ItemStack(Items.ARROW) : itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    public void func_230283_U__() {
        this.idleTime = 0;
    }

    public void setCharging(boolean p_213671_1_) {
        this.dataManager.set(IS_CHARGING_CROSSBOW, p_213671_1_);
    }

    protected void func_241844_w(float p_241844_1_) {
        super.func_241844_w(p_241844_1_);
        if (this.rand.nextInt(300) == 0) {
            ItemStack itemstack = this.getHeldItemMainhand();
            if (itemstack.getItem() == AxolotlTest.ANGELIC_CROSSBOW.get()) {
                Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemstack);
                map.putIfAbsent(Enchantments.PIERCING, 1);
                EnchantmentHelper.setEnchantments(map, itemstack);
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack);
            }
        }
    }

    public boolean isOnSameTeam(Entity entityIn) {
        if (super.isOnSameTeam(entityIn)) {
            return true;
        } else if (entityIn instanceof ArcherLucia || entityIn instanceof WandererSophie || entityIn instanceof KarateLucia || entityIn instanceof InsomniaSophie) {
            return this.getTeam() == null && entityIn.getTeam() == null;
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

    protected float getStandingEyeHeight(Pose pose, EntitySize entitySize) {
        return 1.62F;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld iServerWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData iLivingEntityData, @Nullable CompoundNBT compoundNBT) {
        this.setEquipmentBasedOnDifficulty(difficultyInstance);
        this.setEnchantmentBasedOnDifficulty(difficultyInstance);
        return super.onInitialSpawn(iServerWorld, difficultyInstance, spawnReason, iLivingEntityData, compoundNBT);
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficultyInstance) {
        super.setEquipmentBasedOnDifficulty(difficultyInstance);
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.ARCHER_LUCIA_HOOD.get()));
        this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ARCHER_LUCIA_VEST.get()));
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_CROSSBOW.get()));
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity playerEntity) {
        return true;
    }

    public boolean func_230280_a_(ShootableItem shootableItem) {
        return shootableItem == AxolotlTest.ANGELIC_CROSSBOW.get();
    }

    public void setItemStackToSlot(EquipmentSlotType equipmentSlotType, ItemStack itemStack) {
        super.setItemStackToSlot(equipmentSlotType, itemStack);
    }

    public void attackEntityWithRangedAttack(LivingEntity livingEntity, float p_82196_2_) {
        this.func_234281_b_(this, 1.6F);
    }

    public void func_230284_a_(LivingEntity livingEntity, ItemStack itemStack, ProjectileEntity projectileEntity, float p_230284_4_) {
        this.func_234279_a_(this, livingEntity, projectileEntity, p_230284_4_, 1.6F);
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

    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
            return true;
        } else {
            int i = inventorySlot - 300;
            if (i >= 0 && i < this.inventory.getSizeInventory()) {
                this.inventory.setInventorySlotContents(i, itemStackIn);
                return true;
            } else {
                return false;
            }
        }
    }
}
