package com.sophicreeper.backmath.entity.outfit;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.ResourceLocation;

public class Outfits {
    public static final OutfitDefinition QUEEN_LUCY_SHIRT_CURRENT = new OutfitDefinition(BackMath.backMath("qls_current"), null, new OutfitSlot(texture("qls_current_chest")), null, null);
    public static final OutfitDefinition QUEEN_LUCY_SHIRT_ALTERNATE = new OutfitDefinition(BackMath.backMath("qls_alt"), null, new OutfitSlot(texture("qls_alt_chest")), null, null);
    public static final OutfitDefinition QUEEN_LUCY_SHIRT_RELIC = new OutfitDefinition(BackMath.backMath("qls_relic"), null, new OutfitSlot(texture("qls_relic_chest")), null, null);
    public static final OutfitDefinition KARATE_BAND = new OutfitDefinition(BackMath.backMath("karate_band"), new OutfitSlot(texture("karate_band_head")), null, null, null);
    public static final OutfitDefinition CAT_TIARA = new OutfitDefinition(BackMath.backMath("cat_tiara"), new OutfitSlot(texture("cat_tiara_head")), null, null, null);
    public static final OutfitDefinition DOG_TIARA = new OutfitDefinition(BackMath.backMath("dog_tiara"), new OutfitSlot(texture("dog_tiara_head")), null, null, null);

    public static final OutfitDefinition INSOMNIA_SOPHIE_SLEEPWEAR = new OutfitDefinition(BackMath.backMath("insomnia_sophie_sleepwear"), null, new OutfitSlot(texture("insomnia_sophie_sleepwear_chest")), new OutfitSlot(texture("insomnia_sophie_sleepwear_legs")), null);
    public static final OutfitDefinition TERMIAN_GUARD = new OutfitDefinition(BackMath.backMath("termian_guard"), null, new OutfitSlot(texture("termian_guard_chest")), new OutfitSlot(texture("termian_guard_legs")), new OutfitSlot(texture("termian_guard_feet")));
    public static final OutfitDefinition BAKUGOU = new OutfitDefinition(BackMath.backMath("bakugou"), new OutfitSlot(texture("bakugou_head")), new OutfitSlot(texture("bakugou_chest")), new OutfitSlot(texture("bakugou_legs")), new OutfitSlot(texture("bakugou_feet")));
    public static final OutfitDefinition PLATEFORCED_MID_TERM = new OutfitDefinition(BackMath.backMath("plateforced_mid_term"), new OutfitSlot(texture("plateforced_mid_term_head")), new OutfitSlot(texture("plateforced_mid_term_chest")), new OutfitSlot(texture("plateforced_mid_term_legs")), new OutfitSlot(texture("plateforced_mid_term_feet")));

    public static ResourceLocation texture(String name) {
        return BackMath.backMath("models/outfit/" + name);
    }
}
