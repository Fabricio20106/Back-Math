package com.sophicreeper.backmath.core.world.item.weapon;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.function.Predicate;

public class BMBowItem extends ShootableItem {
    public boolean isFieryBowClass = false;

    public BMBowItem(Properties properties) {
        super(properties);
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity livEntity, int timeLeft) {
        if (livEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livEntity;
            boolean isInfinite = player.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack arrowStack = player.findAmmo(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, world, player, i, !arrowStack.isEmpty() || isInfinite);
            if (i < 0) return;

            if (!arrowStack.isEmpty() || isInfinite) {
                if (arrowStack.isEmpty()) {
                    arrowStack = new ItemStack(Items.ARROW);
                }

                float arrowsVelocity = getArrowVelocity(i);
                if (!((double) arrowsVelocity < 0.1D)) {
                    boolean flag1 = player.abilities.isCreativeMode || (arrowStack.getItem() instanceof ArrowItem && ((ArrowItem) arrowStack.getItem()).isInfinite(arrowStack, stack, player));
                    if (!world.isRemote) {
                        ArrowItem arrowitem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                        AbstractArrowEntity arrowEntity = arrowitem.createArrow(world, arrowStack, player);
                        arrowEntity = customArrow(arrowEntity);
                        // arrowsEntity.shootFromRotation
                        arrowEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, arrowsVelocity * 3.0F, 1.0F);

                        if (arrowsVelocity == 1) {
                            // If the arrow's velocity is at one, it marks the arrow as a critical arrow.
                            arrowEntity.setIsCritical(true);
                        }

                        int powerPredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                        if (powerPredicate > 0) {
                            // Adds additional damage to the arrow (or Power) to the arrow.
                            arrowEntity.setDamage(arrowEntity.getDamage() + (double) powerPredicate * 0.5D + 0.5D);
                        }

                        int punchPredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                        if (punchPredicate > 0) {
                            // Sets the knockback strength of the arrow.
                            arrowEntity.setKnockbackStrength(punchPredicate);
                        }

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0 || this.isFieryBowClass) {
                            // Sets the target on fire for 100 ticks (or 5 seconds).
                            arrowEntity.setFire(100);
                        }

                        stack.damageItem(1, player, (livingEntity) -> livingEntity.sendBreakAnimation(player.getActiveHand()));

                        if (flag1 || player.abilities.isCreativeMode && arrowStack.getItem().isIn(ItemTags.ARROWS)) {
                            arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        world.addEntity(arrowEntity);
                    }

                    world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1, 1 / (random.nextFloat() * 0.4f + 1.2f) + arrowsVelocity * 0.5f);
                    if (!flag1 && !player.abilities.isCreativeMode) {
                        arrowStack.shrink(1);
                        if (arrowStack.isEmpty()) {
                            player.inventory.deleteStack(arrowStack);
                        }
                    }

                    player.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getArrowVelocity(int charge) {
        float f = (float) charge / 20;
        f = (f * f + f * 2) / 3;
        if (f > 1) {
            f = 1;
        }

        return f;
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItemStack = player.getHeldItem(hand);
        boolean flag = !player.findAmmo(heldItemStack).isEmpty();

        ActionResult<ItemStack> actionResult = ForgeEventFactory.onArrowNock(heldItemStack, world, player, hand, flag);
        if (actionResult != null) return actionResult;

        if (!player.abilities.isCreativeMode && !flag) {
            return ActionResult.resultFail(heldItemStack);
        } else {
            player.setActiveHand(hand);
            return ActionResult.resultConsume(heldItemStack);
        }
    }

    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return ARROWS;
    }

    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        return arrow;
    }

    // getDefaultProjectileRange
    public int func_230305_d_() {
        return 15;
    }
}
