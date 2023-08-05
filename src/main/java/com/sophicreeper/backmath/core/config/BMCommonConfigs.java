package com.sophicreeper.backmath.core.config;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMCommonConfigs {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static boolean peaceTeaInvisibilityToggle;
    public static boolean peaceTeaGlowingToggle;

    // Gameplay Aspects - Peace Tea
    private static final ForgeConfigSpec.BooleanValue PEACE_TEA_INVISIBILITY_TOGGLE = BUILDER
            .comment("Makes peace teas give you or the affected mob Invisibility.")
            .define("peaceTeaInvisibilityToggle", false);

    private static final ForgeConfigSpec.BooleanValue PEACE_TEA_GLOWING_TOGGLE = BUILDER
            .comment("Makes peace teas give you or the affected mob Glowing.")
            .define("peaceTeaGlowingToggle", false);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event) {
        peaceTeaInvisibilityToggle = PEACE_TEA_INVISIBILITY_TOGGLE.get();
        peaceTeaGlowingToggle = PEACE_TEA_GLOWING_TOGGLE.get();
    }
}
