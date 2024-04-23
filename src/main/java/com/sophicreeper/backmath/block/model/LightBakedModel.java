package com.sophicreeper.backmath.block.model;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.data.IModelData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class LightBakedModel implements IBakedModel {
    private static final int UPPER_HALF = 65536; // 2^16
    private IBakedModel lightBakedModel;

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        List<BakedQuad> quads = this.lightBakedModel.getQuads(state, side, rand, extraData);
        if(MinecraftForgeClient.getRenderLayer() == RenderType.translucent()) {
            for(int i = 0; i < quads.size(); i++) {
                BakedQuad quad = quads.get(i);
                int[] vertexData = quad.getVertices();
                for(int j = 0; j < 4; j++) {
                    vertexData[8 * j + 6] = getLightValue();
                }
                quads.set(i, new BakedQuad(vertexData, quad.getTintIndex(), quad.getDirection(), quad.getSprite(), quad.isShade()));
            }
        }
        return quads;
    }

    private static int getLightValue() {
        return UPPER_HALF * 15 * 16 + 15 * 16;
    }

    // ---- All methods below are required by the interface, but we don't do anything special with them.

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        // throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
        throw new AssertionError(new TranslationTextComponent("messages.backmath.get_quads_error").getString());
    }

    // getParticleTexture is used directly when player is inside the block. The game will crash if you don't use something meaningful here.
    @Override
    public TextureAtlasSprite getParticleIcon() {
        return lightBakedModel.getParticleIcon();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return lightBakedModel.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return lightBakedModel.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        // Related to item "diffuselighting".
        return lightBakedModel.usesBlockLight();
    }

    @Override
    public boolean isCustomRenderer() {
        return lightBakedModel.isCustomRenderer();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return lightBakedModel.getOverrides();
    }

    @Override
    public ItemCameraTransforms getTransforms() {
        return lightBakedModel.getTransforms();
    }
}
