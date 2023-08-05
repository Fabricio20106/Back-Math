package com.sophicreeper.backmath.core.client;

import com.sophicreeper.backmath.core.config.BMCommonConfigs;
import com.sophicreeper.backmath.core.proxy.ClientProxy;
import com.sophicreeper.backmath.core.proxy.CommonProxy;
import com.sophicreeper.backmath.core.proxy.ServerProxy;
import net.minecraft.resources.ResourceLocation;
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
    public static final boolean logDebugMessages = false;

    public final CommonProxy proxy;

    public BackMath() {
        MinecraftForge.EVENT_BUS.register(this);
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BMCommonConfigs.SPEC);
    }

    public static ResourceLocation resourceLoc(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
