package com.sophicreeper.backmath.misc;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class BMStats {
    public static final ResourceLocation INTERACT_WITH_MEAL_COOKER = registerCustom("interact_with_meal_cooker", IStatFormatter.DEFAULT);
    public static final ResourceLocation CHANGE_CRYSTALLIZER_MOLD = registerCustom("change_crystallizer_mold", IStatFormatter.DEFAULT);
    public static final ResourceLocation CRAFT_IN_CRYSTALLIZER = registerCustom("craft_in_crystallizer", IStatFormatter.DEFAULT);
    public static final ResourceLocation CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD = registerCustom("change_crystalline_crystallizer_mold", IStatFormatter.DEFAULT);
    public static final ResourceLocation CRAFT_IN_CRYSTALLINE_CRYSTALLIZER = registerCustom("craft_in_crystalline_crystallizer", IStatFormatter.DEFAULT);

    private static ResourceLocation registerCustom(String name, IStatFormatter formatter) {
        ResourceLocation registryName = BackMath.resourceLoc(name);
        Registry.register(Registry.CUSTOM_STAT, name, registryName);
        Stats.CUSTOM.get(registryName, formatter);
        return registryName;
    }

    public static void init() {}
}
