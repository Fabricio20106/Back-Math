package com.sophicreeper.backmath.block.model;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.data.IModelData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FullbrightModel implements IBakedModel {
    private final Set<ResourceLocation> textures;
    private final IBakedModel model;

    public FullbrightModel(Set<ResourceLocation> textures, IBakedModel model) {
        this.textures = textures;
        this.model = model;
    }

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        List<BakedQuad> quads = this.model.getQuads(state, side, rand, extraData);
        for (int i = 0; i < quads.size(); i++) {
            BakedQuad quad = quads.get(i);
            if (this.textures.contains(quad.getSprite().getName())) quads.set(i, makeQuadFullyBright(quad, quads, i));
        }
        return quads;
    }

    private static BakedQuad makeQuadFullyBright(BakedQuad quad, List<BakedQuad> quads, int i) {
        int[] vertexData = quad.getVertices().clone();
        vertexData[6] = getLightValue();
        vertexData[6 + 8] = getLightValue();
        vertexData[6 + 8 + 8] = getLightValue();
        vertexData[6 + 8 + 8 + 8] = getLightValue();
        return new BakedQuad(vertexData, quad.getTintIndex(), quad.getDirection(), quad.getSprite(), quad.isShade());
    }

    private static int getLightValue() {
        return 0xF000F0;
    }

    @Override
    public boolean isLayered() {
        return true;
    }

    // ---- All methods below are required by the interface, but we don't do anything special with them.

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        // throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
        throw new AssertionError(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.assertion_exception.get_quads").getString()));
    }

    // getParticleTexture is used directly when player is inside the block. The game will crash if you don't use something meaningful here.
    @Override
    @Nonnull
    public TextureAtlasSprite getParticleIcon() {
        return this.model.getParticleIcon();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return this.model.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return this.model.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return this.model.usesBlockLight(); // Related to item "diffuselighting".
    }

    @Override
    public boolean isCustomRenderer() {
        return this.model.isCustomRenderer();
    }

    @Override
    @Nonnull
    public ItemOverrideList getOverrides() {
        return this.model.getOverrides();
    }

    @Override
    @Nonnull
    public ItemCameraTransforms getTransforms() {
        return this.model.getTransforms();
    }
}
