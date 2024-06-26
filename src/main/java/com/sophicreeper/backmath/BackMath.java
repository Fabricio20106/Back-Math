package com.sophicreeper.backmath;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.proxy.ClientProxy;
import com.sophicreeper.backmath.proxy.CommonProxy;
import com.sophicreeper.backmath.proxy.ServerProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeMod;
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
        ForgeMod.enableMilkFluid();
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BMConfigs.COMMON_SPEC, "backmath-common.toml");
        BMConfigs.init();
    }

    public static ResourceLocation resourceLoc(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
