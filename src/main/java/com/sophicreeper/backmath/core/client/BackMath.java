package com.sophicreeper.backmath.core.client;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.proxy.ClientProxy;
import com.sophicreeper.backmath.core.proxy.CommonProxy;
import com.sophicreeper.backmath.core.proxy.ServerProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BackMath.MOD_ID)
public class BackMath {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "backmath";

    public final CommonProxy proxy;

    public BackMath() {
        MinecraftForge.EVENT_BUS.register(this);
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BMConfigs.SERVER_SPEC, "backmath-common.toml");
        BMConfigs.init();
    }

    public static ResourceLocation resourceLoc(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    /*@SubscribeEvent
    public void missingItemMappings(final RegistryEvent.MissingMappings<Item> event) {
        RegistrationHelper.handleMissingMappings(event, MOD_ID, item -> {
            switch (item) {
                case "levan_polkka_disc":
                    return AxolotlTest.IEVAN_POLKKA_DISC.get();
                default:
                    return null;
            }
        });
    }

    @SubscribeEvent
    public static void missingBiomeMappings(final RegistryEvent.MissingMappings<Biome> event) {
        RegistrationHelper.handleMissingMappings(event, MOD_ID, item -> {
            switch (item) {
                case "back_field":
                    return BMBiomes.ORIGINAL_BACK_FIELDS.get();
                default:
                    return null;
            }
        });
    }*/
}
