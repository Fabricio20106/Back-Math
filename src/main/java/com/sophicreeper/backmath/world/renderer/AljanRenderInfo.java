package com.sophicreeper.backmath.world.renderer;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.ISkyRenderHandler;

public class AljanRenderInfo extends DimensionRenderInfo {
    public AljanRenderInfo(float cloudHeight, boolean placebo, FogType fogType, boolean brightenLightMap, boolean entityLightingBottomsLit) {
        super(cloudHeight, placebo, fogType, brightenLightMap, entityLightingBottomsLit);
    }

    @Override
    public Vector3d func_230494_a_(Vector3d vec3D, float f) {
        return vec3D.mul(f * 0.94F + 0.06F, f * 0.94F + 0.06F, f * 0.91F + 0.09F);
    }

    @Override
    public boolean func_230493_a_(int i, int i1) {
        return false;
    }

    @Override
    public void setSkyRenderHandler(ISkyRenderHandler skyRenderHandler) {
        skyRenderHandler = new AljanSkyRenderer();
    }
}
