package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class AljamicGrassBlock extends SpreadingSnowyAljanDirtBlock implements BonemealableBlock {
    public AljamicGrassBlock(Properties properties) {
        super(properties);
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.above()).isAir();
    }

    public boolean isBonemealSuccess(Level world, RandomSource rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel world, RandomSource rand, BlockPos pos, BlockState state) {
        BlockPos abovePos = pos.above();
        BlockState grass = Blocks.GRASS.defaultBlockState();
        Optional<Holder.Reference<PlacedFeature>> optionalHolder = world.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(VegetationPlacements.GRASS_BONEMEAL);

        label48:
        for(int i = 0; i < 128; ++i) {
            BlockPos abovePos1 = abovePos;

            for(int j = 0; j < i / 16; ++j) {
                abovePos1 = abovePos1.offset(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (!world.getBlockState(abovePos1.below()).is(this) || world.getBlockState(abovePos1).isCollisionShapeFullBlock(world, abovePos1)) {
                    continue label48;
                }
            }

            BlockState state1 = world.getBlockState(abovePos1);
            if (state1.is(grass.getBlock()) && rand.nextInt(10) == 0) {
                ((BonemealableBlock) grass.getBlock()).performBonemeal(world, rand, abovePos1, state1);
            }

            if (state1.isAir()) {
                Holder<PlacedFeature> holder;
                if (rand.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = world.getBiome(abovePos1).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    holder = ((RandomPatchConfiguration) list.get(0).config()).feature();
                } else {
                    if (!optionalHolder.isPresent()) continue;
                    holder = optionalHolder.get();
                }
                holder.value().place(world, world.getChunkSource().getGenerator(), rand, abovePos1);
            }
        }
    }
}
