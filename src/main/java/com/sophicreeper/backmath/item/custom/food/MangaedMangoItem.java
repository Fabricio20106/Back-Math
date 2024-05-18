package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MangaedMangoItem extends Item {
    public MangaedMangoItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livEntity;
            BMUtils.addBakugouArmor(serverPlayer);
        }
        return stack;
    }
}
