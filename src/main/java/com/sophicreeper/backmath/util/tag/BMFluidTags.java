package com.sophicreeper.backmath.util.tag;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class BMFluidTags {
    // Back Math Tags
    public static final ITag.INamedTag<Fluid> HILLARY = backMath("hillary");
    public static final ITag.INamedTag<Fluid> MILKLLARY = backMath("milkllary");
    public static final ITag.INamedTag<Fluid> LIQUID_ALJAME = backMath("liquid_aljame");
    public static final ITag.INamedTag<Fluid> LIQUID_MANGA = backMath("liquid_manga");
    public static final ITag.INamedTag<Fluid> LIQUEFIED_MONSTER = backMath("liquefied_monster");
    public static final ITag.INamedTag<Fluid> SLEEPISHWATER = backMath("sleepishwater");

    public static final ITag.INamedTag<Fluid> ALJAN_CARVER_REPLACEABLES = backMath("aljan_carver_replaceables");

    // Melony Tags
    public static final ITag.INamedTag<Fluid> HYDRATES_WATER_BASED_FARMLAND = melony("hydrates_farmland/water");

    public static final ITag.INamedTag<Fluid> MILK = forge("milk");

    private static ITag.INamedTag<Fluid> forge(String name) {
        return FluidTags.bind(new ResourceLocation("forge", name).toString());
    }

    private static ITag.INamedTag<Fluid> melony(String name) {
        return FluidTags.bind(new ResourceLocation("melony", name).toString());
    }

    private static ITag.INamedTag<Fluid> backMath(String name) {
        return FluidTags.bind(BackMath.backMath(name).toString());
    }
}
