package com.sophicreeper.backmath.world.renderer;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.ISkyRenderHandler;

public class AljanRenderInfo extends DimensionRenderInfo {
    public AljanRenderInfo(float cloudHeight, boolean placebo, FogType fogType, boolean brightenLightMap, boolean entityLightingBottomsLit) {
        super(cloudHeight, placebo, fogType, brightenLightMap, entityLightingBottomsLit);
    }

    @Override
    public Vector3d func_230494_a_(Vector3d vec3D, float p_230494_2_) {
        return vec3D.mul(p_230494_2_ * 0.94F + 0.06F, p_230494_2_ * 0.94F + 0.06F, p_230494_2_ * 0.91F + 0.09F);
    }

    @Override
    public boolean func_230493_a_(int p_230493_1_, int p_230493_2_) {
        return false;
    }

    @Override
    public void setSkyRenderHandler(ISkyRenderHandler skyRenderHandler) {
        skyRenderHandler = new AljanSkyRenderer();
    }

    public static void init() {}
}
