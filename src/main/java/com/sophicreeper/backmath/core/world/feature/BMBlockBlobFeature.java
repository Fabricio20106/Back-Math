package com.sophicreeper.backmath.core.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class BMBlockBlobFeature extends Feature<BlockStateProvidingFeatureConfig> {
    public BMBlockBlobFeature(Codec<BlockStateProvidingFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateProvidingFeatureConfig config) {
        for(; pos.getY() > 5; pos = pos.down()) {
            if (!reader.isAirBlock(pos.down())) {
                Block blockBelow = reader.getBlockState(pos.down()).getBlock();
                if (isDirt(blockBelow) || isStone(blockBelow)) {
                    break;
                }
            }
        }

        if (pos.getY() <= 3) {
            return false;
        } else {
            for(int int1 = 0; int1 < 3; ++int1) {
                int rand1 = rand.nextInt(4);
                int rand2 = rand.nextInt(4);
                int rand3 = rand.nextInt(4);
                float float1 = (float) (rand1 + rand2 + rand3) * 0.333f + 0.5f;

                for (BlockPos blockPosInBox : BlockPos.getAllInBoxMutable(pos.add(-rand1, -rand2, -rand3), pos.add(rand1, rand2, rand3))) {
                    if (blockPosInBox.distanceSq(pos) <= (double) (float1 * float1)) {
                        reader.setBlockState(blockPosInBox, config.field_227268_a_.getBlockState(rand, pos), 4);
                    }
                }

                pos = pos.add(-1 + rand.nextInt(2), -rand.nextInt(2), -1 + rand.nextInt(2));
            }

            return true;
        }
    }
}
