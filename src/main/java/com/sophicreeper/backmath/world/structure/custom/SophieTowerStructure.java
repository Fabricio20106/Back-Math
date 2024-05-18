package com.sophicreeper.backmath.world.structure.custom;

import com.google.common.collect.ImmutableList;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.util.BMResourceLocations;
import net.minecraft.block.BlockState;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
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

import java.util.List;

public class SophieTowerStructure extends Structure<NoFeatureConfig> {
    private static final List<MobSpawnInfo.Spawners> STRUCTURE_CREATURES = ImmutableList.of(
            new MobSpawnInfo.Spawners(BMEntities.WANDERER_SOPHIE.get(), 8, 4, 12),
            new MobSpawnInfo.Spawners(BMEntities.KARATE_LUCIA.get(), 6, 3, 8),
            new MobSpawnInfo.Spawners(BMEntities.ARCHER_LUCIA.get(), 5, 3, 7)
    );

    public SophieTowerStructure() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeProvider, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        BlockPos centerOfChunk = new BlockPos((chunkX << 4) + 7, 0, (chunkZ << 4) + 7);
        int landHeight = chunkGenerator.getBaseHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG);

        IBlockReader columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ());
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.above(landHeight));

        return topBlock.getFluidState().isEmpty();
    }

    @Override
    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
        return STRUCTURE_CREATURES;
    }

    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return STRUCTURE_CREATURES;
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return SophieTowerStructure.Start::new;
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

            JigsawManager.addPieces(dynamicRegistryManager, new VillageConfig(() -> dynamicRegistryManager.registry(Registry.TEMPLATE_POOL_REGISTRY).get().get(BMResourceLocations.SOPHIE_TOWER_START_POOL), 10), AbstractVillagePiece::new,
                    chunkGenerator, templateManager, pos, this.pieces, this.random,false, true);

            this.pieces.forEach(piece -> piece.move(0, BMConfigs.COMMON_CONFIGS.sophieTowerYOffset.get(), 0));
            this.pieces.forEach(piece -> piece.getBoundingBox().y0 -= BMConfigs.COMMON_CONFIGS.sophieTowerYOffset.get());

            this.calculateBoundingBox();

            if (BMConfigs.COMMON_CONFIGS.logStructureLocationMessages.get()) {
                LogManager.getLogger().log(Level.DEBUG, new TranslationTextComponent("console.backmath.sophie_tower_location",
                        this.pieces.get(0).getBoundingBox().x0,
                        this.pieces.get(0).getBoundingBox().y0 + BMConfigs.COMMON_CONFIGS.sophieTowerYOffset.get(),
                        this.pieces.get(0).getBoundingBox().z0).getString());
            }
        }
    }
}
