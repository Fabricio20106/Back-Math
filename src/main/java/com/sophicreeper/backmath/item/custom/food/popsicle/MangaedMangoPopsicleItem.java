package com.sophicreeper.backmath.item.custom.food.popsicle;

import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MangaedMangoPopsicleItem extends PopsicleItem {
    public MangaedMangoPopsicleItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) livEntity;
            BMUtils.addBakugouArmor(player);
        }
        ItemStack superStack = super.finishUsingItem(stack, world, livEntity);
        return livEntity instanceof PlayerEntity && ((PlayerEntity) livEntity).abilities.instabuild ? superStack : getFoodContainerItem(stack, new ItemStack(Items.STICK));
    }
}
