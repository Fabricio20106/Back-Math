package com.sophicreeper.backmath.core.world.item;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DevilCrossbowItem extends ShootableItem implements IVanishable {
    private boolean isLoadingStart = false;
    private boolean isLoadingMiddle = false;

    public DevilCrossbowItem(Properties properties) {
        super(properties);
    }

    public Predicate<ItemStack> getAmmoPredicate() {
        return ARROWS_OR_FIREWORKS;
    }

    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return ARROWS;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItemStack = player.getHeldItem(hand);
        if (isCharged(heldItemStack)) {
            fireProjectiles(world, player, hand, heldItemStack, func_220013_l(heldItemStack), 1);
            setCharged(heldItemStack, false);
            return ActionResult.resultConsume(heldItemStack);
        } else if (!player.findAmmo(heldItemStack).isEmpty()) {
            if (!isCharged(heldItemStack)) {
                this.isLoadingStart = false;
                this.isLoadingMiddle = false;
                player.setActiveHand(hand);
            }

            return ActionResult.resultConsume(heldItemStack);
        } else {
            return ActionResult.resultFail(heldItemStack);
        }
    }

    public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity livEntity, int timeLeft) {
        int i = this.getUseDuration(stack) - timeLeft;
        float charge = getCharge(i, stack);
        if (charge >= 1 && !isCharged(stack) && hasAmmo(livEntity, stack)) {
            setCharged(stack, true);
            SoundCategory soundcategory = livEntity instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
            world.playSound(null, livEntity.getPosX(), livEntity.getPosY(), livEntity.getPosZ(), SoundEvents.ITEM_CROSSBOW_LOADING_END, soundcategory, 1, 1 / (random.nextFloat() * 0.5F + 1) + 0.2F);
        }
    }

    private static boolean hasAmmo(LivingEntity livEntity, ItemStack stack) {
        int multishotPredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.MULTISHOT, stack);
        int multishotLevelPredicate = multishotPredicate == 0 ? 1 : 3;
        boolean isInfinite = livEntity instanceof PlayerEntity && ((PlayerEntity)livEntity).abilities.isCreativeMode;
        ItemStack ammoStack = livEntity.findAmmo(stack);
        ItemStack ammoStackCopy = ammoStack.copy();

        for(int k = 0; k < multishotLevelPredicate; ++k) {
            if (k > 0) {
                ammoStack = ammoStackCopy.copy();
            }

            if (ammoStack.isEmpty() && isInfinite) {
                ammoStack = new ItemStack(Items.ARROW);
                ammoStackCopy = ammoStack.copy();
            }

            if (!func_220023_a(livEntity, stack, ammoStack, k > 0, isInfinite)) {
                return false;
            }
        }

        return true;
    }

    private static boolean func_220023_a(LivingEntity livEntity, ItemStack stack, ItemStack stack1, boolean b, boolean b1) {
        if (stack1.isEmpty()) {
            return false;
        } else {
            boolean arrowStack = b1 && stack1.getItem() instanceof ArrowItem;
            ItemStack stack2;
            if (!arrowStack && !b1 && !b) {
                stack2 = stack1.split(1);
                if (stack1.isEmpty() && livEntity instanceof PlayerEntity) {
                    ((PlayerEntity) livEntity).inventory.deleteStack(stack1);
                }
            } else {
                stack2 = stack1.copy();
            }

            addChargedProjectile(stack, stack2);
            return true;
        }
    }

    public static boolean isCharged(ItemStack stack) {
        CompoundNBT compoundNBT = stack.getTag();
        return compoundNBT != null && compoundNBT.getBoolean("Charged");
    }

    public static void setCharged(ItemStack stack, boolean isCharged) {
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        compoundNBT.putBoolean("Charged", isCharged);
    }

    private static void addChargedProjectile(ItemStack crossbow, ItemStack projectile) {
        CompoundNBT compoundNBT = crossbow.getOrCreateTag();
        ListNBT nbtList;
        if (compoundNBT.contains("ChargedProjectiles", 9)) {
            nbtList = compoundNBT.getList("ChargedProjectiles", 10);
        } else {
            nbtList = new ListNBT();
        }

        CompoundNBT compoundNBT1 = new CompoundNBT();
        projectile.write(compoundNBT1);
        nbtList.add(compoundNBT1);
        compoundNBT.put("ChargedProjectiles", nbtList);
    }

    private static List<ItemStack> getChargedProjectiles(ItemStack stack) {
        List<ItemStack> list = Lists.newArrayList();
        CompoundNBT compoundNBT = stack.getTag();
        if (compoundNBT != null && compoundNBT.contains("ChargedProjectiles", 9)) {
            ListNBT nbtList = compoundNBT.getList("ChargedProjectiles", 10);
            if (nbtList != null) {
                for(int i = 0; i < nbtList.size(); ++i) {
                    CompoundNBT compoundNBT1 = nbtList.getCompound(i);
                    list.add(ItemStack.read(compoundNBT1));
                }
            }
        }

        return list;
    }

    private static void clearProjectiles(ItemStack stack) {
        CompoundNBT compoundNBT = stack.getTag();
        if (compoundNBT != null) {
            ListNBT nbtList = compoundNBT.getList("ChargedProjectiles", 9);
            nbtList.clear();
            compoundNBT.put("ChargedProjectiles", nbtList);
        }
    }

    public static boolean hasChargedProjectile(ItemStack stack, Item ammoItem) {
        return getChargedProjectiles(stack).stream().anyMatch((stack1) -> stack1.getItem() == ammoItem);
    }

    private static void fireProjectile(World world, LivingEntity shooter, Hand hand, ItemStack crossbow, ItemStack projectile, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy, float projectileAngle) {
        if (!world.isRemote) {
            boolean fireworkProjPredicate = projectile.getItem() == Items.FIREWORK_ROCKET;
            ProjectileEntity projEntity;
            if (fireworkProjPredicate) {
                projEntity = new FireworkRocketEntity(world, projectile, shooter, shooter.getPosX(), shooter.getPosYEye() - (double) 0.15F, shooter.getPosZ(), true);
            } else {
                projEntity = createArrow(world, shooter, crossbow, projectile);
                if (isCreativeMode || projectileAngle != 0) {
                    ((AbstractArrowEntity)projEntity).pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                }
            }

            if (shooter instanceof ICrossbowUser) {
                ICrossbowUser crossbowUser = (ICrossbowUser) shooter;
                crossbowUser.func_230284_a_(crossbowUser.getAttackTarget(), crossbow, projEntity, projectileAngle);
            } else {
                Vector3d vector3D1 = shooter.getUpVector(1);
                Quaternion quaternion = new Quaternion(new Vector3f(vector3D1), projectileAngle, true);
                Vector3d vector3D = shooter.getLook(1);
                Vector3f vector3F = new Vector3f(vector3D);
                vector3F.transform(quaternion);
                projEntity.shoot(vector3F.getX(), vector3F.getY(), vector3F.getZ(), velocity, inaccuracy);
            }

            crossbow.damageItem(fireworkProjPredicate ? 3 : 1, shooter, (livEntity) -> livEntity.sendBreakAnimation(hand));
            world.addEntity(projEntity);
            world.playSound(null, shooter.getPosX(), shooter.getPosY(), shooter.getPosZ(), SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1, soundPitch);
        }
    }

    private static AbstractArrowEntity createArrow(World world, LivingEntity shooter, ItemStack crossbow, ItemStack ammo) {
        ArrowItem arrowItem = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
        AbstractArrowEntity arrowEntity = arrowItem.createArrow(world, ammo, shooter);
        if (shooter instanceof PlayerEntity) {
            arrowEntity.setIsCritical(true);
            arrowEntity.setFire(100);
        }

        arrowEntity.setHitSound(SoundEvents.ITEM_CROSSBOW_HIT);
        arrowEntity.setShotFromCrossbow(true);
        int piercingPredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.PIERCING, crossbow);
        if (piercingPredicate > 0) {
            arrowEntity.setPierceLevel((byte)piercingPredicate);
        }

        return arrowEntity;
    }

    public static void fireProjectiles(World world, LivingEntity shooter, Hand hand, ItemStack stack, float velocity, float inaccuracy) {
        List<ItemStack> chargedProjList = getChargedProjectiles(stack);
        float[] afloat = getRandomSoundPitches(shooter.getRNG());

        for(int i = 0; i < chargedProjList.size(); ++i) {
            ItemStack stack1 = chargedProjList.get(i);
            boolean isInCreative = shooter instanceof PlayerEntity && ((PlayerEntity) shooter).abilities.isCreativeMode;
            if (!stack1.isEmpty()) {
                if (i == 0) {
                    fireProjectile(world, shooter, hand, stack, stack1, afloat[i], isInCreative, velocity, inaccuracy, 0);
                } else if (i == 1) {
                    fireProjectile(world, shooter, hand, stack, stack1, afloat[i], isInCreative, velocity, inaccuracy, -10);
                } else if (i == 2) {
                    fireProjectile(world, shooter, hand, stack, stack1, afloat[i], isInCreative, velocity, inaccuracy, 10);
                }
            }
        }

        fireProjectilesAfter(world, shooter, stack);
    }

    private static float[] getRandomSoundPitches(Random rand) {
        boolean nextBoolean = rand.nextBoolean();
        return new float[]{1, getRandomSoundPitch(nextBoolean), getRandomSoundPitch(!nextBoolean)};
    }

    private static float getRandomSoundPitch(boolean flag) {
        float f = flag ? 0.63F : 0.43F;
        return 1 / (random.nextFloat() * 0.5F + 1.8F) + f;
    }

    private static void fireProjectilesAfter(World world, LivingEntity shooter, ItemStack stack) {
        if (shooter instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity)shooter;
            if (!world.isRemote) {
                CriteriaTriggers.SHOT_CROSSBOW.test(serverPlayer, stack);
            }
            serverPlayer.addStat(Stats.ITEM_USED.get(stack.getItem()));
        }
        clearProjectiles(stack);
    }

    public void onUse(World world, LivingEntity livEntity, ItemStack stack, int count) {
        if (!world.isRemote) {
            int quickChargePredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
            SoundEvent qcpSoundEvent = this.getSoundEvent(quickChargePredicate);
            SoundEvent scpSoundEventMiddle = quickChargePredicate == 0 ? SoundEvents.ITEM_CROSSBOW_LOADING_MIDDLE : null;
            float f = (float) (stack.getUseDuration() - count) / (float)getChargeTime(stack);
            if (f < 0.2F) {
                this.isLoadingStart = false;
                this.isLoadingMiddle = false;
            }

            if (f >= 0.2F && !this.isLoadingStart) {
                this.isLoadingStart = true;
                world.playSound(null, livEntity.getPosX(), livEntity.getPosY(), livEntity.getPosZ(), qcpSoundEvent, SoundCategory.PLAYERS, 0.5F, 1);
            }

            if (f >= 0.5F && scpSoundEventMiddle != null && !this.isLoadingMiddle) {
                this.isLoadingMiddle = true;
                world.playSound(null, livEntity.getPosX(), livEntity.getPosY(), livEntity.getPosZ(), scpSoundEventMiddle, SoundCategory.PLAYERS, 0.5F, 1);
            }
        }
    }

    public int getUseDuration(ItemStack stack) {
        return getChargeTime(stack) + 3;
    }

    public static int getChargeTime(ItemStack stack) {
        int quickChargePredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
        return quickChargePredicate == 0 ? 25 : 25 - 5 * quickChargePredicate;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    private SoundEvent getSoundEvent(int enchantmentLevel) {
        switch(enchantmentLevel) {
            case 1:
                return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_1;
            case 2:
                return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_2;
            case 3:
                return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_3;
            default:
                return SoundEvents.ITEM_CROSSBOW_LOADING_START;
        }
    }

    private static float getCharge(int useTime, ItemStack stack) {
        float f = (float) useTime / (float) getChargeTime(stack);
        if (f > 1) {
            f = 1;
        }
        return f;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        List<ItemStack> chargedProjList = getChargedProjectiles(stack);
        if (isCharged(stack) && !chargedProjList.isEmpty()) {
            ItemStack stack1 = chargedProjList.get(0);
            tooltip.add((new TranslationTextComponent("item.minecraft.crossbow.projectile")).appendString(" ").append(stack1.getTextComponent()));
            if (flag.isAdvanced() && stack1.getItem() == Items.FIREWORK_ROCKET) {
                List<ITextComponent> textComponents = Lists.newArrayList();
                Items.FIREWORK_ROCKET.addInformation(stack1, world, textComponents, flag);
                if (!textComponents.isEmpty()) {
                    for(int i = 0; i < textComponents.size(); ++i) {
                        textComponents.set(i, (new StringTextComponent("  ")).append(textComponents.get(i)).mergeStyle(TextFormatting.GRAY));
                    }
                    tooltip.addAll(textComponents);
                }
            }
        }
    }

    private static float func_220013_l(ItemStack stack) {
        return stack.getItem() == Items.CROSSBOW && hasChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.6F : 3.15F;
    }

    public int func_230305_d_() {
        return 8;
    }
}
