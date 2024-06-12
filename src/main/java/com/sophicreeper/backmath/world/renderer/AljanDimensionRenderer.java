package com.sophicreeper.backmath.world.renderer;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nullable;

public class AljanDimensionRenderer extends DimensionRenderInfo {
    public AljanDimensionRenderer() {
        super(128, false, DimensionRenderInfo.FogType.NONE, false, false);
    }

    @Override
    public Vector3d getBrightnessDependentFogColor(Vector3d color, float sunHeight) {
        return color.multiply(sunHeight * 0.94F + 0.06F, sunHeight * 0.94F + 0.06F, sunHeight * 0.91F + 0.09F);
    }

    @Override
    public boolean isFoggyAt(int cameraX, int cameraY) {
        return false;
    }

    @Nullable
    @Override
    public ISkyRenderHandler getSkyRenderHandler() {
        return new AljanSkyRenderer();
    }
}
