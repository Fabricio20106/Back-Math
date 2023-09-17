package com.sophicreeper.backmath.core.world.aaa;

public class BMPlacedFeatures {
    /*public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, BackMath.MOD_ID);

    public static final RegistryObject<PlacedFeature> DEVIL_ORE_VEIN = PLACED_FEATURES.register("devil_ore_placed", () -> new PlacedFeature(BMConfiguredFeatures.DEVIL_ORE_VEIN
        .getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(63)))));

    public static final RegistryObject<PlacedFeature> ANGELIC_ORE_VEIN = PLACED_FEATURES.register("angelic_ore_placed", () -> new PlacedFeature(BMConfiguredFeatures.ANGELIC_ORE_VEIN
            .getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(63)))));

    public static final RegistryObject<PlacedFeature> ABUNDANT_ANGELIC_ORE_VEIN = PLACED_FEATURES.register("abundant_angelic_ore_placed", () -> new PlacedFeature(
            BMConfiguredFeatures.ABUNDANT_ANGELIC_ORE_VEIN.getHolder().get(), commonOrePlacement(30, HeightRangePlacement.triangle(VerticalAnchor.absolute(10),
            VerticalAnchor.absolute(181)))));

    public static final RegistryObject<PlacedFeature> CRYSTALLINE_ANGELIC_ORE_VEIN = PLACED_FEATURES.register("crystalline_angelic_ore_placed", () -> new PlacedFeature(
            BMConfiguredFeatures.CRYSTALLINE_ANGELIC_ORE_VEIN.getHolder().get(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(70),
            VerticalAnchor.absolute(96)))));

    public static final RegistryObject<PlacedFeature> MID_TERM_ORE_VEIN = PLACED_FEATURES.register("mid_term_ore_placed", () -> new PlacedFeature(BMConfiguredFeatures.
            MID_TERM_ORE_VEIN.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0),
            VerticalAnchor.absolute(117)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier1) {
        return List.of(modifier, InSquarePlacement.spread(), modifier1, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(veinsPerChunk), modifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int veinsPerChunk, PlacementModifier modifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(veinsPerChunk), modifier);
    }*/
}
