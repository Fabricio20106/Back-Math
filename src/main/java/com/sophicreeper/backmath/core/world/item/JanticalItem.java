package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.level.block.AljanPortalStandBlock;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JanticalItem extends Item {
    public JanticalItem(Properties properties) {
        super(properties);
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        BlockState state = world.getBlockState(pos);
        if (state.isIn(BMBlocks.ALJAN_PORTAL_STAND.get()) && !state.get(AljanPortalStandBlock.JANTICAL)) {
            if (world.isRemote) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState withJanticalState = state.with(AljanPortalStandBlock.JANTICAL, true);
                Block.nudgeEntitiesWithNewState(state, withJanticalState, world, pos);
                world.setBlockState(pos, withJanticalState, 2);
                world.updateComparatorOutputLevel(pos, BMBlocks.ALJAN_PORTAL_STAND.get());
                context.getItem().shrink(1);
                world.playEvent(1503, pos, 0);

                return ActionResultType.CONSUME;
            }
        } else {
            return ActionResultType.PASS;
        }
    }
}
