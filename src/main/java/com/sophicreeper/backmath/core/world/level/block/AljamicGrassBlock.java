package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

public class AljamicGrassBlock extends SpreadableSnowyAljanDirtBlock implements IGrowable {
    public AljamicGrassBlock(Properties properties) {
        super(properties);
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld serverWorld, Random rand, BlockPos pos, BlockState state) {
        BlockPos pos1 = pos.up();
        BlockState state1 = Blocks.GRASS.getDefaultState();

        label48:
        for(int i = 0; i < 128; ++i) {
            BlockPos pos2 = pos1;

            for(int j = 0; j < i / 16; ++j) {
                pos2 = pos2.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (!serverWorld.getBlockState(pos2.down()).isIn(this) || serverWorld.getBlockState(pos2).hasOpaqueCollisionShape(serverWorld, pos2)) {
                    continue label48;
                }
            }

            BlockState state2 = serverWorld.getBlockState(pos2);
            if (state2.isIn(state1.getBlock()) && rand.nextInt(10) == 0) {
                ((IGrowable) state1.getBlock()).grow(serverWorld, rand, pos2, state2);
            }

            if (state2.isAir()) {
                BlockState state3;
                if (rand.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = serverWorld.getBiome(pos2).getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    ConfiguredFeature<?, ?> configuredFeature = list.get(0);
                    FlowersFeature flowersFeature = (FlowersFeature) configuredFeature.feature;
                    state3 = flowersFeature.getFlowerToPlace(rand, pos2, configuredFeature.getConfig());
                } else {
                    state3 = state1;
                }

                if (state3.isValidPosition(serverWorld, pos2)) {
                    serverWorld.setBlockState(pos2, state3, 3);
                }
            }
        }
    }
}
