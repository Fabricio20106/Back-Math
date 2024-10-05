package com.sophicreeper.backmath.item.custom.food.drink;

import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MangaedMangoJuiceItem extends JuiceItem {
    public MangaedMangoJuiceItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        super.finishUsingItem(stack, world, livEntity);
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
            player.awardStat(Stats.ITEM_USED.get(this));
            BMUtils.addBakugouArmor(player);
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) {
                ItemStack bottleStack = getFoodUseRemainder(stack);
                PlayerEntity player = (PlayerEntity) livEntity;
                stack.shrink(1);
                if (!player.inventory.add(bottleStack)) player.drop(bottleStack, false);
            }
            return stack;
        }
    }
}
