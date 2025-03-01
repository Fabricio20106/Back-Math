package com.sophicreeper.backmath.data.variant;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.variant.queenlucy.BMQueenLucyVariants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class BMQueenLucyVariantsProvider extends QueenLucyVariantProvider {
    public BMQueenLucyVariantsProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper, BackMath.MOD_ID);
    }

    @Override
    @Nonnull
    public String getName() {
        return "Back Math - Queen Lucy Variants";
    }

    @Override
    protected void addVariants() {
        this.add("current", BMQueenLucyVariants.CURRENT.get());
        this.add("alternate", BMQueenLucyVariants.ALTERNATE.get());
        this.add("relic", BMQueenLucyVariants.RELIC.get());
    }
}
