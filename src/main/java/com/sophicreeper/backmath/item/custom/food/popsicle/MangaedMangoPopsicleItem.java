package com.sophicreeper.backmath.item.custom.food.popsicle;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MangaedMangoPopsicleItem extends PopsicleItem {
    public MangaedMangoPopsicleItem(Food food) {
        super(food);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livEntity;
            player.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()));
            player.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.BAKUGOU_BLOUSE.get()));
            player.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.BAKUGOU_PANTS.get()));
            player.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.BAKUGOU_SHOES.get()));
        }
        ItemStack stack1 = super.finishUsingItem(stack, world, livEntity);
        return livEntity instanceof PlayerEntity && ((PlayerEntity) livEntity).abilities.instabuild ? stack1 : new ItemStack(Items.STICK);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("messages.backmath.take_armor_off.popsicle"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
