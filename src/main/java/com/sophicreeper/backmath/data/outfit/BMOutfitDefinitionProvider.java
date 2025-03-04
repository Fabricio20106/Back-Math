package com.sophicreeper.backmath.data.outfit;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.outfit.Outfits;
import net.minecraft.data.DataGenerator;

import javax.annotation.Nonnull;

public class BMOutfitDefinitionProvider extends OutfitDefinitionProvider {
    public BMOutfitDefinitionProvider(DataGenerator generator) {
        super(generator, BackMath.MOD_ID);
    }

    @Override
    @Nonnull
    public String getName() {
        return "Back Math - Outfit Definitions";
    }

    @Override
    protected void addDefinitions() {
        this.add("qls_current", Outfits.QUEEN_LUCY_SHIRT_CURRENT);
        this.add("qls_alt", Outfits.QUEEN_LUCY_SHIRT_ALTERNATE);
        this.add("qls_relic", Outfits.QUEEN_LUCY_SHIRT_RELIC);
        this.add("crate", Outfits.CRATE);
        this.add("karate_headband", Outfits.KARATE_HEADBAND);
        this.add("cat_tiara", Outfits.CAT_TIARA);
        this.add("dog_tiara", Outfits.DOG_TIARA);

        this.add("insomnia_sophie_sleepwear", Outfits.INSOMNIA_SOPHIE_SLEEPWEAR);
        this.add("termian_guard", Outfits.TERMIAN_GUARD);
        this.add("bakugou", Outfits.BAKUGOU);
        this.add("plateforced_mid_term", Outfits.PLATEFORCED_MID_TERM);
    }
}
