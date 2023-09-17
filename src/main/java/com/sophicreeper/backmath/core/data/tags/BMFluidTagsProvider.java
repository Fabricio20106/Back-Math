package com.sophicreeper.backmath.core.data.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.level.fluid.BMFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BMFluidTagsProvider extends FluidTagsProvider {
    public BMFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> providerLookup, @Nullable ExistingFileHelper fileHelper) {
        super(output, providerLookup, BackMath.MOD_ID, fileHelper);
    }

    @Override
    public String getName() {
        return "Back Math - Fluid Tags";
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BMTags.Fluids.HILLARY).add(BMFluids.HILLARY.get()).add(BMFluids.FLOWING_HILLARY.get());
        /*this.tag()(BMTags.Fluids.MILKLLARY).add(BMFluids.MILKLLARY.get()).add(BMFluids.FLOWING_MILKLLARY.get());
        this.tag()(BMTags.Fluids.LIQUID_ALJAME).add(BMFluids.LIQUID_ALJAME.get()).add(BMFluids.FLOWING_LIQUID_ALJAME.get());
        this.tag()(BMTags.Fluids.LIQUID_MANGA).add(BMFluids.LIQUID_MANGA.get()).add(BMFluids.FLOWING_LIQUID_MANGA.get());
        this.tag()(BMTags.Fluids.LIQUEFIED_MONSTER).add(BMFluids.LIQUEFIED_MONSTER.get()).add(BMFluids.FLOWING_LIQUEFIED_MONSTER.get());
        this.tag()(BMTags.Fluids.SLEEPISHWATER).add(BMFluids.SLEEPISHWATER.get()).add(BMFluids.FLOWING_SLEEPISHWATER.get());*/

        this.tag(FluidTags.WATER).addTag(BMTags.Fluids.HILLARY);/*.addTag(BMTags.Fluids.MILKLLARY).addTag(BMTags.Fluids.LIQUID_ALJAME).addTag(BMTags.Fluids.LIQUID_MANGA)
                .addTag(BMTags.Fluids.LIQUEFIED_MONSTER).addTag(BMTags.Fluids.SLEEPISHWATER);*/
    }
}
