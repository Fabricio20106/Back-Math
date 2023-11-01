package com.sophicreeper.backmath.event;

import com.mojang.serialization.Codec;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.dimension.BMDimensions;
import com.sophicreeper.backmath.world.ore.BMOreGeneration;
import com.sophicreeper.backmath.world.plant.BMPlantGeneration;
import com.sophicreeper.backmath.world.structure.BMStructureGeneration;
import com.sophicreeper.backmath.world.carver.BMCarverGeneration;
import com.sophicreeper.backmath.world.structure.BMStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DebugChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID)
public class BMWorldEvents {
    @SubscribeEvent
    public static void generateCarvers(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();
            if (serverWorld.getChunkProvider().generator instanceof DebugChunkGenerator && serverWorld.getDimensionKey().equals(BMDimensions.THE_ALJAN)) {
                BMCarverGeneration.canGenerate = false;
                BMConfigs.SERVER_CONFIGS.enableAljanCarverGeneration.set(false);
            } else {
                BMConfigs.SERVER_CONFIGS.enableAljanCarverGeneration.set(true);
            }
        }
    }

    @SubscribeEvent
    public static void biomeLoadEvent(final BiomeLoadingEvent event) {
        BMOreGeneration.generateOres(event);
        BMOreGeneration.generateAljanstoneOres(event);
        BMOreGeneration.generateSleepingstoneOres(event);
        BMCarverGeneration.generateCarvers(event);
        BMPlantGeneration.generatePlantsAndTrees(event);

        BMStructureGeneration.generateStructures(event);
    }

    @SubscribeEvent
    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();

            try {
                Method GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR_CODEC.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkProvider().generator));

                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) {
                    return;
                }
            } catch (Exception exception) {
                String message = new TranslationTextComponent("messages.backmath.terraforged_chunk_generator", serverWorld.getDimensionKey().getLocation()).getString();
                LogManager.getLogger().error(message);
            }

            // Prevent spawning our structure in Vanilla's superflat world.
            if (serverWorld.getChunkProvider().generator instanceof FlatChunkGenerator && serverWorld.getDimensionKey().equals(World.OVERWORLD)) {
                return;
            }

            // Adding our structure to the Map.
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
            tempMap.putIfAbsent(BMStructures.SOPHIE_TOWER.get(), DimensionStructuresSettings.field_236191_b_.get(BMStructures.SOPHIE_TOWER.get()));
            tempMap.putIfAbsent(BMStructures.FABRICIO_HIDEOUT_DUNGEON.get(), DimensionStructuresSettings.field_236191_b_.get(BMStructures.FABRICIO_HIDEOUT_DUNGEON.get()));
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
        }
    }
}
