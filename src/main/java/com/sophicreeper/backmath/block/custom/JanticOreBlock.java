package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.block.custom.variants.BMOreBlock;
import com.sophicreeper.backmath.entity.custom.Janticle;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class JanticOreBlock extends BMOreBlock {
    public JanticOreBlock(Properties properties) {
        super(3, 6, properties);
    }

    @Override
    public void spawnAdditionalDrops(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        if (!world.isRemote) {
            Janticle janticle = new Janticle(world);
            world.addEntity(janticle);
        }
        super.spawnAdditionalDrops(state, world, pos, stack);
    }
}
