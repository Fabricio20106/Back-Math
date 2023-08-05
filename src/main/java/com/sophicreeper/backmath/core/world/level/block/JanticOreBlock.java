package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class JanticOreBlock extends Block {
    public JanticOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide) {
            //Janticle janticle = new Janticle(world);
            //world.addFreshEntity(janticle);
        }
        super.playerWillDestroy(world, pos, state, player);
    }
}
