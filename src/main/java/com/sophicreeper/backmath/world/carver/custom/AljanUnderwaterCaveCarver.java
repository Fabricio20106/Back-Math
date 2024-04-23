package com.sophicreeper.backmath.world.carver.custom;

import com.mojang.serialization.Codec;
import com.sophicreeper.backmath.block.BMFluids;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.UnderwaterCaveWorldCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class AljanUnderwaterCaveCarver extends UnderwaterCaveWorldCarver {
    public static final FluidState SLEEPISHWATER = BMFluids.SLEEPISHWATER.get().defaultFluidState();

    public AljanUnderwaterCaveCarver(Codec<ProbabilityConfig> codec) {
        super(codec);
    }

    protected boolean carveBlock(IChunk chunk, Function<BlockPos, Biome> biomePos, BitSet carvingMask, Random rand, BlockPos.Mutable mutablePos, BlockPos.Mutable mutablePos1, BlockPos.Mutable mutablePos2, int p_230358_8_, int p_230358_9_, int p_230358_10_, int posX, int posZ, int p_230358_13_, int posY, int p_230358_15_, MutableBoolean mutableBoolean) {
        return carveCave(this, chunk, carvingMask, rand, mutablePos, p_230358_8_, p_230358_9_, p_230358_10_, posX, posZ, p_230358_13_, posY, p_230358_15_);
    }

    protected static boolean carveCave(WorldCarver<?> worldCarver, IChunk chunk, BitSet carvingMask, Random rand, BlockPos.Mutable mutable, int p_222728_5_, int p_222728_6_, int p_222728_7_, int posX, int posZ, int p_222728_10_, int posY, int p_222728_12_) {
        if (posY >= p_222728_5_) {
            return false;
        } else {
            int lvt_13_1_ = p_222728_10_ | p_222728_12_ << 4 | posY << 8;
            if (carvingMask.get(lvt_13_1_)) {
                return false;
            } else {
                carvingMask.set(lvt_13_1_);
                mutable.set(posX, posY, posZ);
                BlockState state = chunk.getBlockState(mutable);
                if (!worldCarver.canReplaceBlock(state)) {
                    return false;
                } else if (posY == 10) {
                    float randFloat = rand.nextFloat();
                    if ((double) randFloat < 0.25) {
                        chunk.setBlockState(mutable, Blocks.MAGMA_BLOCK.defaultBlockState(), false);
                        chunk.getBlockTicks().scheduleTick(mutable, Blocks.MAGMA_BLOCK, 0);
                    } else {
                        chunk.setBlockState(mutable, Blocks.OBSIDIAN.defaultBlockState(), false);
                    }

                    return true;
                } else if (posY < 10) {
                    chunk.setBlockState(mutable, Blocks.LAVA.defaultBlockState(), false);
                    return false;
                } else {
                    boolean flag = false;

                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        int xOffset = posX + direction.getStepX();
                        int zOffset = posZ + direction.getStepZ();
                        if (xOffset >> 4 != p_222728_6_ || zOffset >> 4 != p_222728_7_ || chunk.getBlockState(mutable.set(xOffset, posY, zOffset)).isAir()) {
                            chunk.setBlockState(mutable, SLEEPISHWATER.createLegacyBlock(), false);
                            chunk.getLiquidTicks().scheduleTick(mutable, SLEEPISHWATER.getType(), 0);
                            flag = true;
                            break;
                        }
                    }

                    mutable.set(posX, posY, posZ);
                    if (!flag) {
                        chunk.setBlockState(mutable, SLEEPISHWATER.createLegacyBlock(), false);
                    }
                    return true;
                }
            }
        }
    }

    @Override
    public boolean canReplaceBlock(BlockState state) {
        return state.is(BMTags.Blocks.ALJAN_CARVER_REPLACEABLES);
    }
}
