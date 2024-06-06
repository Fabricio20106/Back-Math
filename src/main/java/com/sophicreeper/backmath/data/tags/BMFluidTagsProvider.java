package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.block.BMFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BMFluidTagsProvider extends FluidTagsProvider {
    public BMFluidTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, BackMath.MOD_ID, fileHelper);
    }

    @Override
    @Nonnull
    public String getName() {
        return "Back Math - Fluid Tags";
    }

    @Override
    protected void addTags() {
        this.tag(BMTags.Fluids.HILLARY).add(BMFluids.HILLARY.get()).add(BMFluids.FLOWING_HILLARY.get());
        this.tag(BMTags.Fluids.MILKLLARY).add(BMFluids.MILKLLARY.get()).add(BMFluids.FLOWING_MILKLLARY.get());
        this.tag(BMTags.Fluids.LIQUID_ALJAME).add(BMFluids.LIQUID_ALJAME.get()).add(BMFluids.FLOWING_LIQUID_ALJAME.get());
        this.tag(BMTags.Fluids.LIQUID_MANGA).add(BMFluids.LIQUID_MANGA.get()).add(BMFluids.FLOWING_LIQUID_MANGA.get());
        this.tag(BMTags.Fluids.LIQUEFIED_MONSTER).add(BMFluids.LIQUEFIED_MONSTER.get()).add(BMFluids.FLOWING_LIQUEFIED_MONSTER.get());
        this.tag(BMTags.Fluids.SLEEPISHWATER).add(BMFluids.SLEEPISHWATER.get()).add(BMFluids.FLOWING_SLEEPISHWATER.get());

        this.tag(FluidTags.WATER).addTag(BMTags.Fluids.HILLARY).addTag(BMTags.Fluids.MILKLLARY).addTag(BMTags.Fluids.LIQUID_ALJAME).addTag(BMTags.Fluids.LIQUID_MANGA)
                .addTag(BMTags.Fluids.LIQUEFIED_MONSTER).addTag(BMTags.Fluids.SLEEPISHWATER);

        this.tag(BMTags.Fluids.ALJAN_CARVER_REPLACEABLES).addTag(BMTags.Fluids.SLEEPISHWATER).addTag(FluidTags.WATER);

        this.tag(BMTags.Fluids.HYDRATES_WATER_BASED_FARMLAND).addTag(FluidTags.WATER);

        this.tag(BMTags.Fluids.MILK).add(ForgeMod.MILK.get()).add(ForgeMod.FLOWING_MILK.get());
    }
}
