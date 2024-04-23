package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MangaedMangoItem extends Item {
    public MangaedMangoItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            player.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()));
            player.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.BAKUGOU_BLOUSE.get()));
            player.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.BAKUGOU_PANTS.get()));
            player.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.BAKUGOU_SHOES.get()));
        }
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("messages.backmath.take_armor_off.mangaed_mango"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
