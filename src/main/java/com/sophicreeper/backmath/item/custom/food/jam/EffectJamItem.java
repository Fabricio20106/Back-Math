package com.sophicreeper.backmath.item.custom.food.jam;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EffectJamItem extends Item implements ToolBehaviors {
    public EffectJamItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), Potions.WATER);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        PlayerEntity player = livEntity instanceof PlayerEntity ? (PlayerEntity) livEntity : null;
        if (player instanceof ServerPlayerEntity) CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) player, stack);

        if (!world.isClientSide) {
            for (EffectInstance instance : PotionUtils.getCustomEffects(stack)) {
                if (instance.getEffect().isInstantenous()) {
                    instance.getEffect().applyInstantenousEffect(player, player, livEntity, instance.getAmplifier(), 1);
                } else {
                    livEntity.addEffect(new EffectInstance(instance));
                }
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.abilities.instabuild) stack.shrink(1);
        }

        if (player == null || !player.abilities.instabuild) {
            if (stack.isEmpty()) return new ItemStack(AxolotlTest.JAM_POT.get());
            if (player != null) player.inventory.add(getFoodUseRemainder(stack, new ItemStack(AxolotlTest.JAM_POT.get())));
        }

        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    @Nonnull
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    @Nonnull
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    @Nonnull
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }

    @Override
    @Nonnull
    public String getDescriptionId(ItemStack stack) {
        return PotionUtils.getPotion(stack).getName(this.getDescriptionId() + ".effect.");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        PotionUtils.addPotionTooltip(stack, tooltip, 1);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (this.allowdedIn(tab)) {
            for (Potion potion : ForgeRegistries.POTION_TYPES) {
                if (potion != Potions.EMPTY) list.add(PotionUtils.setPotion(new ItemStack(this), potion));
            }
        }
    }
}
