package com.sophicreeper.backmath.core.world;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.feature.BMPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BMBiomeModifiers {
    // Ores
    public static final ResourceKey<BiomeModifier> ADD_DEVIL_ORE_TO_OVERWORLD_BIOMES = registerKey("add_overworld_devil_ore");
    public static final ResourceKey<BiomeModifier> ADD_DEVIL_ORE_TO_NETHER_BIOMES = registerKey("add_nether_devil_ore");
    public static final ResourceKey<BiomeModifier> ADD_ANGELIC_ORE_TO_OVERWORLD_BIOMES = registerKey("add_overworld_angelic_ore");
    public static final ResourceKey<BiomeModifier> ADD_ABUNDANT_ANGELIC_ORE_TO_TAGGED_BIOMES = registerKey("add_tagged_biomes_abundant_angelic_ore");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTALLINE_ANGELIC_ORE_TO_TAGGED_BIOMES = registerKey("add_angelic_woods_crystalline_angelic");
    public static final ResourceKey<BiomeModifier> ADD_MID_TERM_ORE_TO_END_BIOMES = registerKey("add_end_mid_term_ore");

    // Aljan Biomes
    public static final ResourceKey<BiomeModifier> ADD_ALJAMEED_ORE_TO_ALJAN_BIOMES = registerKey("add_aljan_aljameed_ore");
    public static final ResourceKey<BiomeModifier> ADD_ALJAMIC_COPPER_ORE_TO_ALJAN_BIOMES = registerKey("add_aljan_aljamic_copper_ore");
    public static final ResourceKey<BiomeModifier> ADD_ALJAMIC_TIN_ORE_TO_ALJAN_BIOMES = registerKey("add_aljan_aljamic_tin_ore");
    public static final ResourceKey<BiomeModifier> ADD_MOONERING_ORE_TO_ALJAN_BIOMES = registerKey("add_aljan_moonering_ore");
    public static final ResourceKey<BiomeModifier> ADD_JANTIC_ORE_TO_ALJAN_BIOMES = registerKey("add_aljan_jantic_ore");
    public static final ResourceKey<BiomeModifier> ADD_JANTIC_ORE_TO_TAGGED_BIOMES = registerKey("add_tagged_jantic_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // Ores
        context.register(ADD_DEVIL_ORE_TO_OVERWORLD_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_DEVIL_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEVIL_ORE_TO_NETHER_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_DEVIL_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ANGELIC_ORE_TO_OVERWORLD_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_ANGELIC_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ABUNDANT_ANGELIC_ORE_TO_TAGGED_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.HAS_ABUNDANT_ANGELIC_ORE),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_ABUNDANT_ANGELIC_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTALLINE_ANGELIC_ORE_TO_TAGGED_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.HAS_CRYSTALLINE_ANGELIC_ORE),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_CRYSTALLINE_ANGELIC_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_MID_TERM_ORE_TO_END_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_MID_TERM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Aljan Ores
        context.register(ADD_ALJAMEED_ORE_TO_ALJAN_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.IS_ALJAN),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_ALJAMEED_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ALJAMIC_COPPER_ORE_TO_ALJAN_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.IS_ALJAN),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_ALJAMIC_COPPER_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ALJAMIC_TIN_ORE_TO_ALJAN_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.IS_ALJAN),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_ALJAMIC_TIN_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_MOONERING_ORE_TO_ALJAN_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.IS_ALJAN),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_MOONERING_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_JANTIC_ORE_TO_ALJAN_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.IS_ALJAN),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_JANTIC_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_JANTIC_ORE_TO_TAGGED_BIOMES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BMTags.Biomes.ALJAMIC_HIGHLANDS_ORES),
                HolderSet.direct(placedFeatures.getOrThrow(BMPlacedFeatures.PLACED_HIGHLANDS_JANTIC_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, BackMath.resourceLoc(name));
    }
}
