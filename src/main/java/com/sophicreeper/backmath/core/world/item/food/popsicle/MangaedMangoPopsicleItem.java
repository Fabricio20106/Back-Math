package com.sophicreeper.backmath.core.world.item.food.popsicle;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class MangaedMangoPopsicleItem extends PopsicleItem {
    public MangaedMangoPopsicleItem(FoodProperties food) {
        super(food);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            player.setItemSlot(EquipmentSlot.HEAD, new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()));
            player.setItemSlot(EquipmentSlot.CHEST, new ItemStack(AxolotlTest.BAKUGOU_BLOUSE.get()));
            player.setItemSlot(EquipmentSlot.LEGS, new ItemStack(AxolotlTest.BAKUGOU_PANTS.get()));
            player.setItemSlot(EquipmentSlot.FEET, new ItemStack(AxolotlTest.BAKUGOU_SHOES.get()));
        }
        ItemStack stack1 = super.finishUsingItem(stack, world, livingEntity);
        return livingEntity instanceof Player && ((Player) livingEntity).getAbilities().instabuild ? stack1 : new ItemStack(Items.STICK);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("messages.backmath.take_armor_off.popsicle"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
