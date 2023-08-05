package com.sophicreeper.backmath.core.data;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BMDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        /*generator.addProvider(new BMBlockModelGenerators(generator, fileHelper));
        generator.addProvider(new BMItemModelGenerators(generator, fileHelper));

        BMBlockTagsProvider bmBlockTags = new BMBlockTagsProvider(generator, fileHelper);
        generator.addProvider(bmBlockTags);
        generator.addProvider(new BMItemTagsProvider(generator, bmBlockTags, fileHelper));
        generator.addProvider(new BMFluidTagsProvider(generator, fileHelper));
        generator.addProvider(new BMEntityTagsProvider(generator, fileHelper));*/
    }
}
