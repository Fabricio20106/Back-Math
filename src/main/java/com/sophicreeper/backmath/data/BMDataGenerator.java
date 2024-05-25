package com.sophicreeper.backmath.data;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.data.models.BMBlockStateProvider;
import com.sophicreeper.backmath.data.models.BMItemModelProvider;
import com.sophicreeper.backmath.data.tags.BMBlockTagsProvider;
import com.sophicreeper.backmath.data.tags.BMEntityTypeTagsProvider;
import com.sophicreeper.backmath.data.tags.BMFluidTagsProvider;
import com.sophicreeper.backmath.data.tags.BMItemTagsProvider;
import com.sophicreeper.backmath.data.variant.BMWandererSophieVariantsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BMDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(new BMBlockStateProvider(generator, fileHelper));
        generator.addProvider(new BMItemModelProvider(generator, fileHelper));

        BMBlockTagsProvider bmBlockTags = new BMBlockTagsProvider(generator, fileHelper);
        generator.addProvider(bmBlockTags);
        generator.addProvider(new BMItemTagsProvider(generator, bmBlockTags, fileHelper));
        generator.addProvider(new BMFluidTagsProvider(generator, fileHelper));
        generator.addProvider(new BMEntityTypeTagsProvider(generator, fileHelper));
        generator.addProvider(new BMWandererSophieVariantsProvider(generator));
    }
}
