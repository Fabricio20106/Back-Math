package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMFluids;
import com.sophicreeper.backmath.util.tag.BMFluidTags;
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
        this.tag(BMFluidTags.HILLARY).add(BMFluids.HILLARY.get()).add(BMFluids.FLOWING_HILLARY.get());
        this.tag(BMFluidTags.MILKLLARY).add(BMFluids.MILKLLARY.get()).add(BMFluids.FLOWING_MILKLLARY.get());
        this.tag(BMFluidTags.LIQUID_ALJAME).add(BMFluids.LIQUID_ALJAME.get()).add(BMFluids.FLOWING_LIQUID_ALJAME.get());
        this.tag(BMFluidTags.LIQUID_MANGA).add(BMFluids.LIQUID_MANGA.get()).add(BMFluids.FLOWING_LIQUID_MANGA.get());
        this.tag(BMFluidTags.LIQUEFIED_MONSTER).add(BMFluids.LIQUEFIED_MONSTER.get()).add(BMFluids.FLOWING_LIQUEFIED_MONSTER.get());
        this.tag(BMFluidTags.SLEEPISHWATER).add(BMFluids.SLEEPISHWATER.get()).add(BMFluids.FLOWING_SLEEPISHWATER.get());

        this.tag(FluidTags.WATER).addTag(BMFluidTags.HILLARY).addTag(BMFluidTags.MILKLLARY).addTag(BMFluidTags.LIQUID_ALJAME).addTag(BMFluidTags.LIQUID_MANGA)
                .addTag(BMFluidTags.LIQUEFIED_MONSTER).addTag(BMFluidTags.SLEEPISHWATER);

        this.tag(BMFluidTags.ALJAN_CARVER_REPLACEABLES).addTag(BMFluidTags.SLEEPISHWATER).addTag(FluidTags.WATER);

        this.tag(BMFluidTags.HYDRATES_WATER_BASED_FARMLAND).addTag(FluidTags.WATER);

        this.tag(BMFluidTags.MILK).add(ForgeMod.MILK.get()).add(ForgeMod.FLOWING_MILK.get());
    }
}
