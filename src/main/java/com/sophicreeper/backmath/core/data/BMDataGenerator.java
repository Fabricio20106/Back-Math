package com.sophicreeper.backmath.core.data;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.data.models.BMBlockModelGenerators;
import com.sophicreeper.backmath.core.data.models.BMItemModelGenerators;
import com.sophicreeper.backmath.core.data.tags.BMBlockTagsProvider;
import com.sophicreeper.backmath.core.data.tags.BMItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BMDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        dataGen.addProvider(new BMBlockModelGenerators(dataGen, fileHelper));
        dataGen.addProvider(new BMItemModelGenerators(dataGen, fileHelper));

        BMBlockTagsProvider bmBlockTags = new BMBlockTagsProvider(dataGen, fileHelper);
        dataGen.addProvider(bmBlockTags);
        dataGen.addProvider(new BMItemTagsProvider(dataGen, bmBlockTags, fileHelper));
    }
}
