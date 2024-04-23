package com.sophicreeper.backmath.world.structure.custom;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class FabricioHideoutDungeonStructure extends Structure<NoFeatureConfig> {
    public FabricioHideoutDungeonStructure() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
    }

    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeProvider, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        BlockPos centerOfChunk = new BlockPos(chunkX, 0, chunkZ);
        int landHeight = chunkGenerator.getBaseHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG);

        IBlockReader columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ());
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.above(landHeight));

        return topBlock.getFluidState().isEmpty() || topBlock.is(Blocks.BEDROCK);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return FabricioHideoutDungeonStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, mutableBoundingBox, reference, seed);
        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            // Turns chunk coordinates into actual coordinates we can use by getting the center of that chunk.
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            BlockPos pos = new BlockPos(x, 0, z);

            JigsawManager.addPieces(dynamicRegistryManager, new VillageConfig(() -> dynamicRegistryManager.registry(Registry.TEMPLATE_POOL_REGISTRY).get().get(BackMath.resourceLoc(
                            "fabricio_hideout_dungeon/start_pool")), 10), AbstractVillagePiece::new, chunkGenerator, templateManager, pos, this.pieces, this.random, false,
                    true);

            this.pieces.forEach(piece -> piece.move(0, BMConfigs.COMMON_CONFIGS.fabricioHideoutDungeonYOffset.get(), 0));
            this.pieces.forEach(piece -> piece.getBoundingBox().y0 -= BMConfigs.COMMON_CONFIGS.fabricioHideoutDungeonYOffset.get());

            this.calculateBoundingBox();

            if (BMConfigs.COMMON_CONFIGS.logStructureLocationMessages.get()) {
                LogManager.getLogger().log(Level.DEBUG, new TranslationTextComponent("messages.backmath.fabricio_hideout_dungeon_location",
                        this.pieces.get(0).getBoundingBox().x0,
                        this.pieces.get(0).getBoundingBox().y0 + BMConfigs.COMMON_CONFIGS.fabricioHideoutDungeonYOffset.get(),
                        this.pieces.get(0).getBoundingBox().z0).getString());
            }
        }
    }
}
