package com.sophicreeper.backmath.world.dimension.renderer;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class AljanDimensionRenderer extends DimensionRenderInfo {
    private ISkyRenderHandler skyRenderer;

    public AljanDimensionRenderer() {
        super(128, true, FogType.NONE, false, false);
    }

    @Override
    @Nonnull
    public Vector3d getBrightnessDependentFogColor(Vector3d color, float sunHeight) {
        return color.multiply(sunHeight * 0.94F + 0.06F, sunHeight * 0.94F + 0.06F, sunHeight * 0.91F + 0.09F);
    }

    @Override
    public boolean isFoggyAt(int cameraX, int cameraY) {
        return false;
    }

    @Override
    @Nullable
    public ISkyRenderHandler getSkyRenderHandler() {
        if (this.skyRenderer == null) this.skyRenderer = new AljanSkyRenderer();
        return this.skyRenderer;
    }
}
