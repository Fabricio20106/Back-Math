package com.sophicreeper.backmath.core.world.structure.structures;

/*public class FabricioHideoutDungeonStructure extends Structure<NoFeatureConfig> {
    public static final Random rand = new Random();

    public FabricioHideoutDungeonStructure() {
        super(NoFeatureConfig.field_236558_a_);
    }

    @Override
    public GenerationStage.Decoration getDecorationStage() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
    }

    /*@Override
    protected boolean func_230363_a_(ChunkGenerator chunkGenerator, BiomeProvider biomeProvider, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        BlockPos centerOfChunk = new BlockPos((chunkX << 4) + 7, rand.nextInt(40), (chunkZ << 4) + 7);
        int landHeight = chunkGenerator.getHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.OCEAN_FLOOR_WG);

        IBlockReader columnOfBlocks = chunkGenerator.func_230348_a_(centerOfChunk.getX(), centerOfChunk.getZ());
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.up(landHeight));

        return topBlock.getFluidState().isEmpty();
    }*/

    /*@Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return FabricioHideoutDungeonStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, mutableBoundingBox, reference, seed);
        }

        @Override // generatePieces
        public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            // Turns chunk coordinates into actual coordinates we can use by getting the center of that chunk.
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            BlockPos pos = new BlockPos(x, 0, z);

            // addpieces()
            JigsawManager.func_242837_a(dynamicRegistryManager, new VillageConfig(() -> dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY).getOrDefault(BackMath.resourceLoc(
                    "fabricio_hideout_dungeon/start_pool")), 10), AbstractVillagePiece::new, chunkGenerator, templateManager, pos, this.components, this.rand, false,
                    true);

            this.components.forEach(piece -> piece.offset(0, -48, 0));
            this.components.forEach(piece -> piece.getBoundingBox().minY -= -48);

            this.recalculateStructureSize();

            if (BackMath.logDebugMessages) {
                LogManager.getLogger().log(Level.DEBUG, "Back Math: Fabricio's Hideout Dungeon located at: /tp @p " +
                        this.components.get(0).getBoundingBox().minX + " " +
                        this.components.get(0).getBoundingBox().minY + " " +
                        this.components.get(0).getBoundingBox().minZ);
            }
        }
    }
}*/
