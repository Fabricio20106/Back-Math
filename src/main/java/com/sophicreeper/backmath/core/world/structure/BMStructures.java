package com.sophicreeper.backmath.core.world.structure;

public class BMStructures {
    /*public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, BackMath.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> SOPHIE_TOWER = STRUCTURES.register("sophie_tower", SophieTowerStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> FABRICIO_HIDEOUT_DUNGEON = STRUCTURES.register("fabricio_hideout_dungeon", FabricioHideoutDungeonStructure::new);

    // Methods for structure generation below were taken from TelepathicGrunt's Structure Tutorial Mod GitHub.
    /**
     * "setupMapSpacingAndLand" parameters:
     * 1. Average distance apart in chunks between spawn attempts.
     * 2. Minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE.
     * 3. This modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique.
     *
    public static void setupStructures() {
        setupMapSpacingAndLand(SOPHIE_TOWER.get(), new StructureSeparationSettings(10,5, 1073741823),
                true);
        setupMapSpacingAndLand(FABRICIO_HIDEOUT_DUNGEON.get(), new StructureSeparationSettings(15, 10, 27482834),
                false);
    }

    /**
     * Adds the provided structure to the registry, and adds the separation settings.
     * The rarity of the structure is determined based on the values passed into this method in the structureSeparationSettings argument.
     * This method is called by setupStructures method above.

    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
        // Add our structures into the map in Structure class.
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        /*
         * Whether surrounding land will be modified automatically to conform to the bottom of the structure.
         * Basically, it adds land at the base of the structure like it does for Villages and Pillager Outposts.
         * Doesn't work well on structure that have pieces stacked vertically or change in heights.

        if (transformSurroundingLand) {
            Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder().addAll(Structure.field_236384_t_).add(structure).build();
        }

        /*
         * This is the map that holds the default spacing of all structures.
         * Always add your structure to here so that other mods can utilize it if needed.
         *
         * However, while it does propagate the spacing to some correct dimensions from this map,
         * it seems it doesn't always work for code made dimensions as they read from this list beforehand.
         *
         * Instead, we will use the WorldEvent.Load event in BMWorldEvents to add the structure spacing from this list into that dimension or to do dimension
         *  blacklisting properly.
         * We also use our entry in DimensionStructuresSettings.DEFAULTS in WorldEvent.Load as well.
         *
         * DEFAULTS requires AccessTransformer (See resources/META-INF/accesstransformer.cfg)

        DimensionStructuresSettings.field_236191_b_ = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.field_236191_b_).put(structure,
                structureSeparationSettings).build();

        /*
         * There are very few mods that relies on seeing your structure in the noise settings registry before the world is made.
         *
         * You may see some mods add their spacings to DimensionSettings.BUILTIN_OVERWORLD instead of the NOISE_GENERATOR_SETTINGS loop below but that field
         *  only applies for the default overworld and won't add to other world types or dimensions, such as amplified or the Nether.
         * So yeah, don't use DimensionSettings.BUILTIN_OVERWORLD. Use the NOISE_GENERATOR_SETTINGS loop below instead if you must.

        WorldGenRegistries.NOISE_SETTINGS.getEntries().forEach(settings -> {Map<Structure<?>, StructureSeparationSettings> structureMap =
                settings.getValue().getStructures().func_236195_a_();

            /*
             * Pre-caution in case a mod makes the structure map immutable like datapacks do.
             * I take no chances myself. You never know what another mods do...
             *
             * structureConfig requires AccessTransformer (See resources/META-INF/accesstransformer.cfg)

            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().getStructures().func_236195_a_();

            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }*/
}
