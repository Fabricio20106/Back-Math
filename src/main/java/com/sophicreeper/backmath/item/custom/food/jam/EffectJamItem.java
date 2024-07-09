package com.sophicreeper.backmath.item.custom.food.jam;

import com.sophicreeper.backmath.item.AxolotlTest;
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

public class EffectJamItem extends Item {
    public EffectJamItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), Potions.WATER);
    }

    // Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using the Item before the action is complete.
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
            if (player != null) player.inventory.add(new ItemStack(AxolotlTest.JAM_POT.get()));
        }

        return stack;
    }

    // How long it takes to use or consume an item.
    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    // Returns the action that specifies what animation to play when the items are being used.
    @Override
    @Nonnull
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    // Drinking sound for when you are consuming this item.
    @Override
    @Nonnull
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    // Eating sound for when you are consuming this item.
    @Override
    @Nonnull
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    // Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see "onItemUse".
    @Override
    @Nonnull
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }

    // Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have different names based on their damage or NBT.
    @Override
    @Nonnull
    public String getDescriptionId(ItemStack stack) {
        return PotionUtils.getPotion(stack).getName(this.getDescriptionId() + ".effect.");
    }

    // Allows items to add custom lines of information to the mouseover description.
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        PotionUtils.addPotionTooltip(stack, tooltip, 1);
    }

    // Returns true if this item has an enchantment glint. By default, this returns "stack.isItemEnchanted()", but other items can override it (for instance, written books always return true).
    // Note that if you override this method, you generally want to also call the super version Item.java to get the glint for enchanted items. Of course, that is unnecessary if the overwritten version always returns true.
    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }

    // Returns a list of items with the same ID, but different meta (eg: dye returns 16 items).
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (this.allowdedIn(tab)) {
            for (Potion potion : ForgeRegistries.POTION_TYPES) {
                if (potion != Potions.EMPTY) list.add(PotionUtils.setPotion(new ItemStack(this), potion));
            }
        }
    }
}
