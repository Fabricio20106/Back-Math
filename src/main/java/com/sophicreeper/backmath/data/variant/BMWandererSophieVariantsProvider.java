package com.sophicreeper.backmath.data.variant;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.variant.wansophie.BMWandererSophieVariants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class BMWandererSophieVariantsProvider extends WandererSophieVariantProvider {
    public BMWandererSophieVariantsProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper, BackMath.MOD_ID);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Back Math - Wanderer Sophie Variants";
    }

    @Override
    protected void addVariants() {
        this.add("yellow_axolotl", BMWandererSophieVariants.YELLOW_AXOLOTL.get());
        this.add("cyan_axolotl", BMWandererSophieVariants.CYAN_AXOLOTL.get());
        this.add("creeper", BMWandererSophieVariants.CREEPER.get());
        this.add("modified", BMWandererSophieVariants.MODIFIED.get());
        this.add("original", BMWandererSophieVariants.ORIGINAL.get());
        this.add("savannah", BMWandererSophieVariants.SAVANNAH.get());
        this.add("brazil_shirt", BMWandererSophieVariants.BRAZIL_SHIRT.get());
        this.add("pajama", BMWandererSophieVariants.PAJAMA.get());
        this.add("witcher", BMWandererSophieVariants.WITCHER.get());
        this.add("maid", BMWandererSophieVariants.MAID.get());
        this.add("ender", BMWandererSophieVariants.ENDER.get());
        this.add("worker", BMWandererSophieVariants.WORKER.get());
        this.add("blue_axolotl", BMWandererSophieVariants.BLUE_AXOLOTL.get());
        this.add("cyan_axolotl_2", BMWandererSophieVariants.CYAN_AXOLOTL_2.get());
        this.add("empresary2", BMWandererSophieVariants.EMPRESARY2.get());
        this.add("entrepreneur", BMWandererSophieVariants.ENTREPRENEUR.get());
        this.add("farmer", BMWandererSophieVariants.FARMER.get());
        this.add("piglin_brute", BMWandererSophieVariants.PIGLIN_BRUTE.get());
        this.add("swimsuit", BMWandererSophieVariants.SWIMSUIT.get());
        this.add("green_hoodie", BMWandererSophieVariants.GREEN_HOODIE.get());
        this.add("round_six", BMWandererSophieVariants.ROUND_SIX.get());
    }
}
