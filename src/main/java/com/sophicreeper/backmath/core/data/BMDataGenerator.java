package com.sophicreeper.backmath.core.data;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.data.models.BMBlockModelGenerators;
import com.sophicreeper.backmath.core.data.models.BMItemModelGenerators;
import com.sophicreeper.backmath.core.data.tags.BMBlockTagsProvider;
import com.sophicreeper.backmath.core.data.tags.BMFluidTagsProvider;
import com.sophicreeper.backmath.core.data.tags.BMItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BMDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> providerLookup = event.getLookupProvider();

        generator.addProvider(true, new BMBlockModelGenerators(output, fileHelper));
        generator.addProvider(true, new BMItemModelGenerators(output, fileHelper));

        BMBlockTagsProvider bmBlockTags = new BMBlockTagsProvider(output, providerLookup, fileHelper);
        generator.addProvider(true, bmBlockTags);
        generator.addProvider(true, new BMItemTagsProvider(output, providerLookup, bmBlockTags.contentsGetter(), fileHelper));
        generator.addProvider(true, new BMFluidTagsProvider(output, providerLookup, fileHelper));
        //generator.addProvider(new BMFluidTagsProvider(generator, fileHelper));
        //generator.addProvider(new BMEntityTagsProvider(generator, fileHelper));
    }
}
