package com.sophicreeper.backmath.core.data.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BMBiomeTagsProvider extends BiomeTagsProvider {
    public BMBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> providerLookup, @Nullable ExistingFileHelper fileHelper) {
        super(output, providerLookup, BackMath.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BMTags.Biomes.HAS_CRYSTALLINE_ANGELIC_ORE).add(Biomes.WINDSWEPT_HILLS).add(Biomes.WINDSWEPT_GRAVELLY_HILLS);
        this.tag(BMTags.Biomes.HAS_ABUNDANT_ANGELIC_ORE).add(Biomes.WINDSWEPT_HILLS).add(Biomes.WINDSWEPT_GRAVELLY_HILLS);

        this.tag(BMTags.Biomes.IS_ALJAN);
        this.tag(BMTags.Biomes.ALJAMIC_HIGHLANDS_ORES);

        this.tag(BiomeTags.IS_OVERWORLD).add(BMBiomes.ORIGINAL_BACK_FIELDS);
        this.tag(BiomeTags.IS_FOREST).add(BMBiomes.ORIGINAL_BACK_FIELDS);
    }
}
