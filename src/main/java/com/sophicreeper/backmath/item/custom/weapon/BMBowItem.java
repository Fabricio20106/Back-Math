package com.sophicreeper.backmath.item.custom.weapon;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.BMKeys;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class BMBowItem extends ShootableItem {
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

    // Called when the player stops using an Item (stops holding the right mouse button).
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
                if (fireRateDelay < 22) {
                    arrowsVelocity = 1;
                }
                if (!((double) arrowsVelocity < 0.1D)) {
                    boolean flag1 = player.abilities.isCreativeMode || (arrowStack.getItem() instanceof ArrowItem && ((ArrowItem) arrowStack.getItem()).isInfinite(arrowStack, stack, player));
                    if (!world.isRemote) {
                        ArrowItem arrowitem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                        AbstractArrowEntity arrowEntity = arrowitem.createArrow(world, arrowStack, player);
                        arrowEntity = customArrow(arrowEntity);
                        // arrowsEntity.shootFromRotation
                        arrowEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0, arrowsVelocity * 3, 1);

                        if (arrowsVelocity == 1 || forcedCriticalArrow) {
                            // If the arrow's velocity is at one, it marks the arrow as a critical arrow.
                            arrowEntity.setIsCritical(true);
                        }

                        int powerPredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                        if (powerPredicate > 0) {
                            // Adds additional damage to the arrow (or Power) to the arrow.
                            arrowEntity.setDamage(arrowEntity.getDamage() + (double) powerPredicate * 0.5D + 0.5D);
                        }
                        arrowEntity.setDamage(arrowEntity.getDamage() + additionalArrowDamage);
                        if (BMConfigs.COMMON_CONFIGS.bowDamageCounter.get()) {
                            sendMessage(player, new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".arrow_damage", arrowEntity.getDamage()));
                        }

                        int punchPredicate = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                        if (punchPredicate > 0) {
                            // Sets the knockback strength of the arrow.
                            arrowEntity.setKnockbackStrength(punchPredicate);
                        }

                        // Sets the target on fire.
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                            // Default: 100 ticks (5 seconds)
                            arrowEntity.setFire(100);
                        } else if (flameInTicks > 0) {
                             arrowEntity.setFire(flameInTicks);
                        }

                        if (canBeDamaged) {
                            stack.damageItem(1, player, (livingEntity) -> livingEntity.sendBreakAnimation(player.getActiveHand()));
                        }

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
        float trueCharge = (float) charge / 20;
        trueCharge = (trueCharge * trueCharge + trueCharge * 2) / 3;
        if (trueCharge > 1) {
            trueCharge = 1;
        }
        return trueCharge;
    }

    // Default is 72.000.
    public int getUseDuration(ItemStack stack) {
        return fireRateDelay;
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

    private static void sendMessage(PlayerEntity player, ITextComponent text) {
        ((ServerPlayerEntity) player).func_241151_a_(text, ChatType.GAME_INFO, Util.DUMMY_UUID);
    }

    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return ARROWS;
    }

    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        return arrow;
    }

    // getDefaultProjectileRange()
    public int func_230305_d_() {
        return 15;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.POWER || enchantment == Enchantments.PUNCH || enchantment == Enchantments.FLAME || enchantment == Enchantments.INFINITY || super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (flag.isAdvanced()) {
            if (!BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.bow.hold_shift.not_held"));
            if (BMKeys.isHoldingShift()) {
                tooltip.add(new TranslationTextComponent("tooltip.backmath.bow.hold_shift.held"));
                tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
                tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".bow.forced_critical_arrow", new TranslationTextComponent(this.forcedCriticalArrow ? "tooltip." + BackMath.MOD_ID + ".false" : "tooltip." + BackMath.MOD_ID + ".true")));
                tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".bow.can_be_damaged", new TranslationTextComponent(this.canBeDamaged ? "tooltip." + BackMath.MOD_ID + ".false" : "tooltip." + BackMath.MOD_ID + ".true")));
                tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".bow.additional_arrow_damage", this.additionalArrowDamage));
                tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".bow.flame_in_seconds", this.flameInTicks / 20));
                tooltip.add(new TranslationTextComponent(getFireRateDelay(), this.fireRateDelay));
            }
        }
        super.addInformation(stack, world, tooltip, flag);
    }

    private String getFireRateDelay() {
        if (this.fireRateDelay == 72000) {
            return  "tooltip." + BackMath.MOD_ID + ".bow.fire_rate_delay.one_hour";
        } else if (this.fireRateDelay >= 72001) {
            return  "tooltip." + BackMath.MOD_ID + ".bow.fire_rate_delay.above_one_hour";
        } else {
            return "tooltip." + BackMath.MOD_ID + ".bow.fire_rate_delay.accurate";
        }
    }
}
