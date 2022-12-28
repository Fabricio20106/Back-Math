package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.world.entity.monster.aljan.Janticle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class JanticOreBlock extends Block {
    public JanticOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isRemote) {
            Janticle janticle = new Janticle(world);
            world.addEntity(janticle);
        }
        super.onBlockHarvested(world, pos, state, player);
    }
}
