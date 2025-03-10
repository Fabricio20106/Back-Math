package com.sophicreeper.backmath.world.structure;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.world.structure.custom.FabricioHideoutDungeonStructure;
import com.sophicreeper.backmath.world.structure.custom.SophieTowerStructure;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class BMStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, BackMath.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> SOPHIE_TOWER = STRUCTURES.register("sophie_tower", SophieTowerStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> FABRICIO_HIDEOUT_DUNGEON = STRUCTURES.register("fabricio_hideout_dungeon", FabricioHideoutDungeonStructure::new);

    // Methods for structure generation below were taken from TelepathicGrunt's Structure Tutorial Mod GitHub.

    /// <code>setupMapSpacingAndLand</code> parameters:
    /// 1. Average distance apart in chunks between spawn attempts.
    /// 2. Minimum distance apart in chunks between spawn attempts. <b>MUST BE LESS THAN ABOVE VALUE</b>.
    /// 3. This modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique.
    public static void setupStructures() {
        setupMapSpacingAndLand(SOPHIE_TOWER.get(), new StructureSeparationSettings(COMMON_CONFIGS.sophieTowerAvgDistance.get(), COMMON_CONFIGS.sophieTowerMinDistance.get(), COMMON_CONFIGS.sophieTowerSeed.get()),
                COMMON_CONFIGS.sophieTowerTST.get());
        setupMapSpacingAndLand(FABRICIO_HIDEOUT_DUNGEON.get(), new StructureSeparationSettings(COMMON_CONFIGS.fabricioHideoutDungeonAvgDistance.get(), COMMON_CONFIGS.fabricioHideoutDungeonMinDistance.get(),
                COMMON_CONFIGS.fabricioHideoutDungeonSeed.get()), COMMON_CONFIGS.fabricioHideoutDungeonTST.get());
    }

    /// Adds the provided structure to the registry, and adds the separation settings. <p>
    /// The rarity of the structure is determined based on the values passed into this method in the <code>structureSeparationSettings</code> argument. <p>
    /// This method is called by <code>setupStructures</code> method above.
    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean terraformSurroundingTerrain) {
        // Add our structures into the map in Structure class.
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        // Whether surrounding land will be modified automatically to conform to the bottom of the structure.
        // Basically, it adds land at the base of the structure like it does for Villages and Pillager Outposts.
        // Doesn't work well on structure that have pieces stacked vertically or change in heights.
        if (terraformSurroundingTerrain) Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder().addAll(Structure.NOISE_AFFECTING_FEATURES).add(structure).build();

        // This is the map that holds the default spacing of all structures.
        // Always add your structure to here so that other mods can utilize it if needed.

        // However, while it does propagate the spacing to some correct dimensions from this map,
        // it seems it doesn't always work for code made dimensions as they read from this list beforehand.

        // Instead, we will use the WorldEvent.Load event in BMWorldEvents to add the structure spacing from this list into that dimension or to do dimension
        // blacklisting properly.
        // We also use our entry in DimensionStructuresSettings.DEFAULTS in WorldEvent.Load as well.

        // DEFAULTS requires AccessTransformer (See resources/META-INF/accesstransformer.cfg)
        DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.DEFAULTS).put(structure, structureSeparationSettings).build();

        // There are very few mods that relies on seeing your structure in the noise settings registry before the world is made.

        // You may see some mods add their spacings to DimensionSettings.BUILTIN_OVERWORLD instead of the NOISE_GENERATOR_SETTINGS loop below but that field
        // only applies for the default overworld and won't add to other world types or dimensions, such as amplified or the Nether.
        // So yeah, don't use DimensionSettings.BUILTIN_OVERWORLD. Use the NOISE_GENERATOR_SETTINGS loop below instead if you must.
        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();

            // Pre-caution in case a mod makes the structure map immutable like datapacks do.
            // I take no chances myself. You never know what other mods do...

            // structureConfig requires AccessTransformer (See resources/META-INF/accesstransformer.cfg)
            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig();
            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }
}
