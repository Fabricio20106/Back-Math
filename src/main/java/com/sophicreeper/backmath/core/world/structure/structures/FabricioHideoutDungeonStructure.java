package com.sophicreeper.backmath.core.world.structure.structures;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.config.BMConfigs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
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
        super(NoFeatureConfig.field_236558_a_);
    }

    @Override
    public GenerationStage.Decoration getDecorationStage() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
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
        // generatePieces
        public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            // Turns chunk coordinates into actual coordinates we can use by getting the center of that chunk.
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            BlockPos pos = new BlockPos(x, 0, z);

            // addPieces()
            JigsawManager.func_242837_a(dynamicRegistryManager, new VillageConfig(() -> dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY).getOrDefault(BackMath.resourceLoc(
                    "fabricio_hideout_dungeon/start_pool")), 10), AbstractVillagePiece::new, chunkGenerator, templateManager, pos, this.components, this.rand, false,
                    true);

            this.components.forEach(piece -> piece.offset(0, BMConfigs.SERVER_CONFIGS.fabricioHideoutDungeonYOffset.get(), 0));
            this.components.forEach(piece -> piece.getBoundingBox().minY -= BMConfigs.SERVER_CONFIGS.fabricioHideoutDungeonYOffset.get());

            this.recalculateStructureSize();

            if (BMConfigs.SERVER_CONFIGS.logStructureLocationMessages.get()) {
                LogManager.getLogger().log(Level.DEBUG, new TranslationTextComponent("messages.backmath.fabricio_hideout_location",
                        this.components.get(0).getBoundingBox().minX,
                        this.components.get(0).getBoundingBox().minY,
                        this.components.get(0).getBoundingBox().minZ).toString());
            }
        }
    }
}
