package com.sophicreeper.backmath.core.data;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.data.models.BMBlockModelGenerators;
import com.sophicreeper.backmath.core.data.models.BMItemModelGenerators;
import com.sophicreeper.backmath.core.data.tags.BMBiomeTagsProvider;
import com.sophicreeper.backmath.core.data.tags.BMBlockTagsProvider;
import com.sophicreeper.backmath.core.data.tags.BMFluidTagsProvider;
import com.sophicreeper.backmath.core.data.tags.BMItemTagsProvider;
import com.sophicreeper.backmath.core.data.worldgen.BMWorldGenerationProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BMDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> providerLookup = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new BMBlockModelGenerators(output, fileHelper));
        generator.addProvider(event.includeClient(), new BMItemModelGenerators(output, fileHelper));

        generator.addProvider(event.includeClient(), new ForgeAdvancementProvider(output, providerLookup, fileHelper, List.of(new BMAdvancementsProvider())));

        BMBlockTagsProvider bmBlockTags = new BMBlockTagsProvider(output, providerLookup, fileHelper);
        generator.addProvider(event.includeServer(), bmBlockTags);
        generator.addProvider(event.includeServer(), new BMItemTagsProvider(output, providerLookup, bmBlockTags.contentsGetter(), fileHelper));
        generator.addProvider(event.includeServer(), new BMFluidTagsProvider(output, providerLookup, fileHelper));
        generator.addProvider(event.includeServer(), new BMBiomeTagsProvider(output, providerLookup, fileHelper));
        // generator.addProvider(event.includeServer(), new BMEntityTagsProvider(output, providerLookup, fileHelper));

        generator.addProvider(event.includeServer(), new BMWorldGenerationProvider(output, providerLookup));
    }
}
