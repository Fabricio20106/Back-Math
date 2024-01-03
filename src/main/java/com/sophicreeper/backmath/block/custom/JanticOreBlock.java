package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.entity.custom.Janticle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JanticOreBlock extends Block {
    public JanticOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isRemote && !player.isCreative()) {
            Janticle janticle = new Janticle(world);
            world.addEntity(janticle);
        }
        super.onBlockHarvested(world, pos, state, player);
    }
}
