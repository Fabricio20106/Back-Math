package com.sophicreeper.backmath.item.custom.food.popsicle;

import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class MangaedMangoPopsicleItem extends PopsicleItem {
    public MangaedMangoPopsicleItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livEntity;
            BMUtils.addBakugouArmor(serverPlayer);
        }
        ItemStack superStack = super.finishUsingItem(stack, world, livEntity);
        return livEntity instanceof PlayerEntity && ((PlayerEntity) livEntity).abilities.instabuild ? superStack : new ItemStack(Items.STICK);
    }
}
