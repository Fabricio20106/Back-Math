package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.TagTypes;
import com.sophicreeper.backmath.variant.queenlucy.BMQueenLucyVariants;
import com.sophicreeper.backmath.variant.queenlucy.QueenLucyVariant;
import com.sophicreeper.backmath.variant.wansophie.BMWandererSophieVariants;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BMHeadItem extends WallOrFloorItem {
    public BMHeadItem(Block floorBlock, Block wallBlock, Properties properties) {
        super(floorBlock, wallBlock, properties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    @Nullable
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }

    @Override
    public boolean verifyTagAfterLoad(CompoundNBT tag) {
        super.verifyTagAfterLoad(tag);
        if (tag.contains("variant", TagTypes.STRING)) {
            if (this == AxolotlTest.WANDERER_SOPHIE_HEAD.get() && !WandererSophieVariant.DATA_DRIVEN_VARIANTS.containsKey(ResourceLocation.tryParse(tag.getString("variant")))) {
                tag.remove("variant");
                return true;
            } else if (this == AxolotlTest.QUEEN_LUCY_HEAD.get() && !WandererSophieVariant.DATA_DRIVEN_VARIANTS.containsKey(ResourceLocation.tryParse(tag.getString("variant")))) {
                tag.remove("variant");
                return true;
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (stack.getItem() == AxolotlTest.WANDERER_SOPHIE_HEAD.get()) {
            TextFormatting color = TextFormatting.GRAY;
            IFormattableTextComponent component = new TranslationTextComponent(BMWandererSophieVariants.YELLOW_AXOLOTL.get().getTranslation());
            WandererSophieVariant variant = WandererSophieVariant.getVariantFromStack(stack);

            if (variant != null) {
                component = new TranslationTextComponent(variant.getTranslation());
                if (!variant.spawnsNaturally()) color = TextFormatting.GOLD;
            }
            tooltip.add(component.withStyle(color));
        } else if (stack.getItem() == AxolotlTest.QUEEN_LUCY_HEAD.get()) {
            TextFormatting color = TextFormatting.GRAY;
            IFormattableTextComponent component = new TranslationTextComponent(BMQueenLucyVariants.CURRENT.get().getTranslation());
            QueenLucyVariant variant = QueenLucyVariant.getVariantFromStack(stack);

            if (variant != null) {
                component = new TranslationTextComponent(variant.getTranslation());
                if (variant.getTranslation().equals("queen_lucy_variant.backmath.relic")) color = TextFormatting.GOLD;
            }
            tooltip.add(component.withStyle(color));
        }
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> items) {
        if (this.allowdedIn(tab) && this == AxolotlTest.WANDERER_SOPHIE_HEAD.get() && BMConfigs.COMMON_CONFIGS.populateWandererSophieHeadVariants.get()) {
            for (ResourceLocation variant : WandererSophieVariant.DATA_DRIVEN_VARIANTS.keySet()) {
                ItemStack stack = new ItemStack(AxolotlTest.WANDERER_SOPHIE_HEAD.get());
                stack.getOrCreateTag().putString("variant", variant.toString());
                items.add(stack);
            }
        } else if (this.allowdedIn(tab) && this == AxolotlTest.QUEEN_LUCY_HEAD.get() && BMConfigs.COMMON_CONFIGS.populateQueenLucyHeadVariants.get()) {
            for (ResourceLocation variant : QueenLucyVariant.DATA_DRIVEN_VARIANTS.keySet()) {
                ItemStack stack = new ItemStack(AxolotlTest.QUEEN_LUCY_HEAD.get());
                stack.getOrCreateTag().putString("variant", variant.toString());
                items.add(stack);
            }
        } else {
            super.fillItemCategory(tab, items);
        }
    }
}
