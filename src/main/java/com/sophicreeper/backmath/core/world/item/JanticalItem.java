package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.level.block.AljanPortalStandBlock;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class JanticalItem extends Item {
    public JanticalItem(Properties properties) {
        super(properties);
    }

    public InteractionResult use(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (state.is(BMBlocks.ALJAN_PORTAL_STAND.get()) && !state.getValue(AljanPortalStandBlock.JANTICAL)) {
            if (world.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState withJanticalState = state.setValue(AljanPortalStandBlock.JANTICAL, true);
                Block.pushEntitiesUp(state, withJanticalState, world, pos);
                world.setBlock(pos, withJanticalState, 2);
                world.updateNeighbourForOutputSignal(pos, BMBlocks.ALJAN_PORTAL_STAND.get());
                context.getItemInHand().shrink(1);
                world.levelEvent(1503, pos, 0);

                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
}
