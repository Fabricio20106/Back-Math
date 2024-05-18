package com.sophicreeper.backmath.item.custom.food.jam;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class MangaedMangoJamItem extends JamItem {
    public MangaedMangoJamItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        super.finishUsingItem(stack, world, livEntity);
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            BMUtils.addBakugouArmor(serverPlayer);
        }

        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) {
            stack.shrink(1);
        }

        if (stack.isEmpty()) {
            return new ItemStack(AxolotlTest.JAM_POT.get());
        } else {
            if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) {
                ItemStack potStack = new ItemStack(AxolotlTest.JAM_POT.get());
                PlayerEntity player = (PlayerEntity) livEntity;
                if (!player.inventory.add(potStack)) {
                    player.drop(potStack, false);
                }
            }
            return stack;
        }
    }
}
