package com.sophicreeper.backmath.core.data.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.level.material.BMFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BMFluidTagsProvider extends FluidTagsProvider {
    public BMFluidTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, BackMath.MOD_ID, fileHelper);
    }

    @Override
    public String getName() {
        return "Back Math - Fluid Tags";
    }

    @Override
    protected void registerTags() {
        this.getOrCreateBuilder(BMTags.Fluids.HILLARY).add(BMFluids.HILLARY.get()).add(BMFluids.FLOWING_HILLARY.get());
        this.getOrCreateBuilder(BMTags.Fluids.MILKLLARY).add(BMFluids.MILKLLARY.get()).add(BMFluids.FLOWING_MILKLLARY.get());
        this.getOrCreateBuilder(BMTags.Fluids.LIQUID_ALJAME).add(BMFluids.LIQUID_ALJAME.get()).add(BMFluids.FLOWING_LIQUID_ALJAME.get());
        this.getOrCreateBuilder(BMTags.Fluids.LIQUID_MANGA).add(BMFluids.LIQUID_MANGA.get()).add(BMFluids.FLOWING_LIQUID_MANGA.get());
        this.getOrCreateBuilder(BMTags.Fluids.LIQUEFIED_MONSTER).add(BMFluids.LIQUEFIED_MONSTER.get()).add(BMFluids.FLOWING_LIQUEFIED_MONSTER.get());
        this.getOrCreateBuilder(BMTags.Fluids.SLEEPISHWATER).add(BMFluids.SLEEPISHWATER.get()).add(BMFluids.FLOWING_SLEEPISHWATER.get());

        this.getOrCreateBuilder(FluidTags.WATER).addTag(BMTags.Fluids.HILLARY).addTag(BMTags.Fluids.MILKLLARY).addTag(BMTags.Fluids.LIQUID_ALJAME).addTag(BMTags.Fluids.LIQUID_MANGA)
                .addTag(BMTags.Fluids.LIQUEFIED_MONSTER).addTag(BMTags.Fluids.SLEEPISHWATER);
    }
}
