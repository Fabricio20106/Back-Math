package com.sophicreeper.backmath.core.world.gen.carver;

/*public class AljanUnderwaterCaveCarver extends UnderwaterCaveWorldCarver {
    public static final FluidState SLEEPISHWATER = BMFluids.SLEEPISHWATER.get().getDefaultState();

    public AljanUnderwaterCaveCarver(Codec<ProbabilityConfig> codec) {
        super(codec);
        this.carvableBlocks = ImmutableSet.of(BMBlocks.ALJAMIC_DIRT.get(), BMBlocks.ALJAMIC_GRASS_BLOCK.get(), BMBlocks.AVONDALIC_NYLIUM.get(), BMBlocks.ALJANSTONE.get(),
                BMBlocks.SLEEPINGSTONE.get(), BMBlocks.INSOGRAVEL.get(), BMBlocks.ALJAMIC_SAND.get(), Blocks.GRASS_BLOCK);
    }

    protected boolean carveBlock(IChunk iChunk, Function<BlockPos, Biome> blockPosBiomeFunction, BitSet bitSet, Random random, BlockPos.Mutable mutable, BlockPos.Mutable mutable1, BlockPos.Mutable mutable2, int p_230358_8_, int p_230358_9_, int p_230358_10_, int p_230358_11_, int p_230358_12_, int p_230358_13_, int p_230358_14_, int p_230358_15_, MutableBoolean mutableBoolean) {
        return func_222728_a(this, iChunk, bitSet, random, mutable, p_230358_8_, p_230358_9_, p_230358_10_, p_230358_11_, p_230358_12_, p_230358_13_, p_230358_14_, p_230358_15_);
    }

    protected static boolean func_222728_a(WorldCarver<?> worldCarver, IChunk iChunk, BitSet bitSet, Random random, BlockPos.Mutable mutable, int p_222728_5_, int p_222728_6_, int p_222728_7_, int p_222728_8_, int p_222728_9_, int p_222728_10_, int p_222728_11_, int p_222728_12_) {
        if (p_222728_11_ >= p_222728_5_) {
            return false;
        } else {
            int lvt_13_1_ = p_222728_10_ | p_222728_12_ << 4 | p_222728_11_ << 8;
            if (bitSet.get(lvt_13_1_)) {
                return false;
            } else {
                bitSet.set(lvt_13_1_);
                mutable.setPos(p_222728_8_, p_222728_11_, p_222728_9_);
                BlockState state = iChunk.getBlockState(mutable);
                if (!worldCarver.isCarvable(state)) {
                    return false;
                } else if (p_222728_11_ == 10) {
                    float lvt_15_1_ = random.nextFloat();
                    if ((double)lvt_15_1_ < 0.25) {
                        iChunk.setBlockState(mutable, Blocks.MAGMA_BLOCK.getDefaultState(), false);
                        iChunk.getBlocksToBeTicked().scheduleTick(mutable, Blocks.MAGMA_BLOCK, 0);
                    } else {
                        iChunk.setBlockState(mutable, Blocks.OBSIDIAN.getDefaultState(), false);
                    }

                    return true;
                } else if (p_222728_11_ < 10) {
                    iChunk.setBlockState(mutable, Blocks.LAVA.getDefaultState(), false);
                    return false;
                } else {
                    boolean lvt_15_2_ = false;

                    for (Direction lvt_17_1_ : Direction.Plane.HORIZONTAL) {
                        int lvt_18_1_ = p_222728_8_ + lvt_17_1_.getXOffset();
                        int lvt_19_1_ = p_222728_9_ + lvt_17_1_.getZOffset();
                        if (lvt_18_1_ >> 4 != p_222728_6_ || lvt_19_1_ >> 4 != p_222728_7_ || iChunk.getBlockState(mutable.setPos(lvt_18_1_, p_222728_11_, lvt_19_1_)).isAir()) {
                            iChunk.setBlockState(mutable, SLEEPISHWATER.getBlockState(), false);
                            iChunk.getFluidsToBeTicked().scheduleTick(mutable, SLEEPISHWATER.getFluid(), 0);
                            lvt_15_2_ = true;
                            break;
                        }
                    }

                    mutable.setPos(p_222728_8_, p_222728_11_, p_222728_9_);
                    if (!lvt_15_2_) {
                        iChunk.setBlockState(mutable, SLEEPISHWATER.getBlockState(), false);
                    }
                    return true;
                }
            }
        }
    }
}*/
