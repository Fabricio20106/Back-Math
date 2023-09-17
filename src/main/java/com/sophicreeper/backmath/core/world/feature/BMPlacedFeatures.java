package com.sophicreeper.backmath.core.world.feature;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.placement.BMOrePlacements;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class BMPlacedFeatures {
    // Ores
    public static final ResourceKey<PlacedFeature> PLACED_DEVIL_ORE = registerKey("placed_devil_ore");
    public static final ResourceKey<PlacedFeature> PLACED_ANGELIC_ORE = registerKey("placed_angelic_ore");
    public static final ResourceKey<PlacedFeature> PLACED_ABUNDANT_ANGELIC_ORE = registerKey("placed_abundant_angelic_ore");
    public static final ResourceKey<PlacedFeature> PLACED_CRYSTALLINE_ANGELIC_ORE = registerKey("placed_crystalline_angelic_ore");
    public static final ResourceKey<PlacedFeature> PLACED_MID_TERM_ORE = registerKey("placed_mid_term_ore");

    // Aljan Ores
    public static final ResourceKey<PlacedFeature> PLACED_ALJAMEED_ORE = registerKey("placed_aljameed_ore");
    public static final ResourceKey<PlacedFeature> PLACED_ALJAMIC_COPPER_ORE = registerKey("placed_aljamic_copper_ore");
    public static final ResourceKey<PlacedFeature> PLACED_ALJAMIC_TIN_ORE = registerKey("placed_aljamic_tin_ore");
    public static final ResourceKey<PlacedFeature> PLACED_MOONERING_ORE = registerKey("placed_moonering_ore");
    public static final ResourceKey<PlacedFeature> PLACED_JANTIC_ORE = registerKey("placed_jantic_ore");
    public static final ResourceKey<PlacedFeature> PLACED_HIGHLANDS_JANTIC_ORE = registerKey("placed_highlands_jantic_ore");

    // Trees
    public static final ResourceKey<PlacedFeature> PLACED_GUARANA_OAK = registerKey("placed_guarana_oak");
    public static final ResourceKey<PlacedFeature> PLACED_MANGO_OAK = registerKey("placed_mango_oak");
    public static final ResourceKey<PlacedFeature> PLACED_ALJAME_BIRCH = registerKey("placed_aljame_birch");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Ores
        register(context, PLACED_DEVIL_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.DEVIL_ORE_VEIN), BMOrePlacements.commonOrePlacement(20,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(63))));

        register(context, PLACED_ANGELIC_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.ANGELIC_ORE_VEIN), BMOrePlacements.commonOrePlacement(20,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(181))));

        register(context, PLACED_ABUNDANT_ANGELIC_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.ABUNDANT_ANGELIC_ORE_VEIN), BMOrePlacements.commonOrePlacement(30,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(181))));

        register(context, PLACED_CRYSTALLINE_ANGELIC_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.CRYSTALLINE_ANGELIC_ORE_VEIN), BMOrePlacements.commonOrePlacement(
                6, HeightRangePlacement.uniform(VerticalAnchor.absolute(40), VerticalAnchor.absolute(319))));

        register(context, PLACED_MID_TERM_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.MID_TERM_ORE_VEIN), BMOrePlacements.commonOrePlacement(4,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(255))));

        // Aljan Ores
        register(context, PLACED_ALJAMEED_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.ALJAMEED_ORE_VEIN), BMOrePlacements.commonOrePlacement(9,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(320))));

        register(context, PLACED_MOONERING_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.MOONERING_ORE_VEIN), BMOrePlacements.commonOrePlacement(8,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16))));

        register(context, PLACED_ALJAMIC_COPPER_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.ALJAMIC_COPPER_ORE_VEIN), BMOrePlacements.commonOrePlacement(7,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));

        register(context, PLACED_ALJAMIC_TIN_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.ALJAMIC_TIN_ORE_VEIN), BMOrePlacements.commonOrePlacement(7,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));

        register(context, PLACED_JANTIC_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.JANTIC_ORE_VEIN), BMOrePlacements.commonOrePlacement(7,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-16))));

        register(context, PLACED_HIGHLANDS_JANTIC_ORE, configuredFeatures.getOrThrow(BMConfiguredFeatures.HIGHLANDS_JANTIC_ORE_VEIN), BMOrePlacements.commonOrePlacement(5,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(70), VerticalAnchor.absolute(96))));

        // Trees
        register(context, PLACED_GUARANA_OAK, configuredFeatures.getOrThrow(BMConfiguredFeatures.GUARANA_OAK), VegetationPlacements.treePlacement(
                PlacementUtils.countExtra(3, 0.1f, 1), BMBlocks.GUARANA_OAK_SAPLING.get()));

        register(context, PLACED_MANGO_OAK, configuredFeatures.getOrThrow(BMConfiguredFeatures.MANGO_OAK), VegetationPlacements.treePlacement(
                PlacementUtils.countExtra(3, 0.1f, 1), BMBlocks.MANGO_OAK_SAPLING.get()));

        register(context, PLACED_ALJAME_BIRCH, configuredFeatures.getOrThrow(BMConfiguredFeatures.ALJAME_BIRCH), VegetationPlacements.treePlacement(
                PlacementUtils.countExtra(1, 0.01f, 1), BMBlocks.ALJAME_BIRCH_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, BackMath.resourceLoc(name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
