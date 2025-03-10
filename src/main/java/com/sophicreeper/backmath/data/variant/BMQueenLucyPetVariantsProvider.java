package com.sophicreeper.backmath.data.variant;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.variant.queenlucypet.BMQueenLucyPetVariants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class BMQueenLucyPetVariantsProvider extends QueenLucyPetVariantProvider {
    public BMQueenLucyPetVariantsProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper, BackMath.MOD_ID);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Back Math - Queen Lucy Pet Variants";
    }

    @Override
    protected void addVariants() {
        this.add("current", BMQueenLucyPetVariants.CURRENT.get());
        this.add("alternate", BMQueenLucyPetVariants.ALTERNATE.get());
        this.add("relic", BMQueenLucyPetVariants.RELIC.get());
        this.add("shy_fabricio", BMQueenLucyPetVariants.SHY_FABRICIO.get());

        this.add("sv_yellow_axolotl", BMQueenLucyPetVariants.SV_YELLOW_AXOLOTL.get());
        this.add("sv_cyan_axolotl", BMQueenLucyPetVariants.SV_CYAN_AXOLOTL.get());
        this.add("sv_creeper", BMQueenLucyPetVariants.SV_CREEPER.get());
        this.add("sv_modified", BMQueenLucyPetVariants.SV_MODIFIED.get());
        this.add("sv_original", BMQueenLucyPetVariants.SV_ORIGINAL.get());
        this.add("sv_savannah", BMQueenLucyPetVariants.SV_SAVANNAH.get());
        this.add("sv_brazil_shirt", BMQueenLucyPetVariants.SV_BRAZIL_SHIRT.get());
        this.add("sv_pajama", BMQueenLucyPetVariants.SV_PAJAMA.get());
        this.add("sv_witcher", BMQueenLucyPetVariants.SV_WITCHER.get());
        this.add("sv_maid", BMQueenLucyPetVariants.SV_MAID.get());
        this.add("sv_ender", BMQueenLucyPetVariants.SV_ENDER.get());
        this.add("sv_worker", BMQueenLucyPetVariants.SV_WORKER.get());
        this.add("sv_blue_axolotl", BMQueenLucyPetVariants.SV_BLUE_AXOLOTL.get());
        this.add("sv_cyan_axolotl_2", BMQueenLucyPetVariants.SV_CYAN_AXOLOTL_2.get());
        this.add("sv_empresary2", BMQueenLucyPetVariants.SV_EMPRESARY2.get());
        this.add("sv_entrepreneur", BMQueenLucyPetVariants.SV_ENTREPRENEUR.get());
    }
}
