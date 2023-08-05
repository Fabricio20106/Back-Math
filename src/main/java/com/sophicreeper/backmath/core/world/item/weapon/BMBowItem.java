package com.sophicreeper.backmath.core.world.item.weapon;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.function.Predicate;

public class BMBowItem extends ProjectileWeaponItem implements Vanishable {
    private final boolean forcedCriticalArrow;
    private final boolean canBeDamaged;
    private final int additionalArrowDamage;
    private final int flameInTicks;
    private final int fireRateDelay;

    public BMBowItem(boolean forcedCriticalArrow, boolean canBeDamaged, int additionalArrowDamage, int flameInTicks, int fireRateDelay, Properties properties) {
        super(properties);
        this.forcedCriticalArrow = forcedCriticalArrow;
        this.canBeDamaged = canBeDamaged;
        this.additionalArrowDamage = additionalArrowDamage;
        this.flameInTicks = flameInTicks;
        this.fireRateDelay = fireRateDelay;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void releaseUsing(ItemStack stack, Level world, LivingEntity livEntity, int timeLeft) {
        if (livEntity instanceof Player) {
            Player player = (Player) livEntity;
            boolean isInfinite = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack arrowStack = player.getProjectile(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, world, player, i, !arrowStack.isEmpty() || isInfinite);
            if (i < 0) return;

            if (!arrowStack.isEmpty() || isInfinite) {
                if (arrowStack.isEmpty()) {
                    arrowStack = new ItemStack(Items.ARROW);
                }

                float arrowsVelocity = getArrowVelocity(i);
                if (fireRateDelay < 22) {
                    arrowsVelocity = 1;
                }
                if (!((double) arrowsVelocity < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (arrowStack.getItem() instanceof ArrowItem && ((ArrowItem) arrowStack.getItem()).isInfinite(arrowStack, stack, player));
                    if (!world.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                        AbstractArrow arrowEntity = arrowitem.createArrow(world, arrowStack, player);
                        arrowEntity = customArrow(arrowEntity);
                        // arrowsEntity.shootFromRotation
                        arrowEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, arrowsVelocity * 3, 1);

                        if (arrowsVelocity == 1 || forcedCriticalArrow) {
                            // If the arrow's velocity is at one, it marks the arrow as a critical arrow.
                            arrowEntity.setCritArrow(true);
                        }

                        int powerPredicate = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                        if (powerPredicate > 0) {
                            // Adds additional damage to the arrow (or Power) to the arrow.
                            arrowEntity.setBaseDamage(arrowEntity.getBaseDamage() + (double) powerPredicate * 0.5D + 0.5D);
                        }
                        arrowEntity.setBaseDamage(arrowEntity.getBaseDamage() + additionalArrowDamage);
                        // sendMessage(player, Component.translatable("tooltip." + BackMath.MOD_ID + ".arrow_damage", arrowEntity.getBaseDamage()));

                        int punchPredicate = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                        if (punchPredicate > 0) {
                            // Sets the knockback strength of the arrow.
                            arrowEntity.setKnockback(punchPredicate);
                        }

                        // Sets the target on fire.
                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {
                            // Default: 100 ticks (5 seconds)
                            arrowEntity.setSecondsOnFire(100);
                        } else if (flameInTicks > 0) {
                             arrowEntity.setSecondsOnFire(flameInTicks);
                        }

                        if (canBeDamaged) {
                            stack.hurtAndBreak(1, player, (livingEntity) -> livingEntity.broadcastBreakEvent(player.getUsedItemHand()));
                        }

                        if (flag1 || player.getAbilities().instabuild && arrowStack.is(ItemTags.ARROWS)) {
                            arrowEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        world.addFreshEntity(arrowEntity);
                    }

                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1 / (world.getRandom().nextFloat() * 0.4f + 1.2f) + arrowsVelocity * 0.5f);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        arrowStack.shrink(1);
                        if (arrowStack.isEmpty()) {
                            player.getInventory().removeItem(arrowStack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getArrowVelocity(int charge) {
        float trueCharge = (float) charge / 20;
        trueCharge = (trueCharge * trueCharge + trueCharge * 2) / 3;
        if (trueCharge > 1) {
            trueCharge = 1;
        }

        return trueCharge;
    }

    // Default is 72.000
    public int getUseDuration(ItemStack stack) {
        return fireRateDelay;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItemStack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(heldItemStack).isEmpty();

        InteractionResultHolder<ItemStack> actionResult = ForgeEventFactory.onArrowNock(heldItemStack, world, player, hand, flag);
        if (actionResult != null) return actionResult;

        if (!player.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(heldItemStack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(heldItemStack);
        }
    }

    private static void sendMessage(Player player, Component text) {
        ((ServerPlayer) player).sendSystemMessage(text, true);
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    // getDefaultProjectileRange
    public int getDefaultProjectileRange() {
        return 15;
    }
}
