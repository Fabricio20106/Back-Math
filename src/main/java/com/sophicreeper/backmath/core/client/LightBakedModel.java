package com.sophicreeper.backmath.core.client;

public class LightBakedModel/* implements BakedModel*/ {
    /*private BakedModel lightBakedModel;

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull RandomSource rand) {
        List<BakedQuad> quads = this.lightBakedModel.getQuads(state, side, rand);
        if(getRenderType() == RenderType.translucent()) {
            for(int i = 0; i < quads.size(); i++) {
                BakedQuad quad = quads.get(i);
                int[] vertexData = quad.getVertexData();
                for(int j = 0; j < 4; j++) {
                    vertexData[8 * j + 6] = getLightValue();
                }
                quads.set(i, new BakedQuad(vertexData, quad.getTintIndex(), quad.getFace(), quad.getSprite(), quad.applyDiffuseLighting()));
            }
        }
        return quads;
    }

    private static final int UPPER_HALF = 65536; // 2^16
    private static int getLightValue() {
        return UPPER_HALF * 15 * 16 + 15 * 16;
    }

    // ---- All these methods are required by the interface, but we don't do anything special with them.

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
    }

    // getTexture is used directly when player is inside the block. The game will crash if you don't use something
    //   meaningful here.
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return lightBakedModel.getParticleTexture();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return lightBakedModel.isAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return lightBakedModel.isGui3d();
    }

    @Override
    public boolean isSideLit() {
        return lightBakedModel.isSideLit(); // related to item "diffuselighting"
    }

    @Override
    public boolean isBuiltInRenderer() {
        return lightBakedModel.isBuiltInRenderer();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return lightBakedModel.getOverrides();
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return lightBakedModel.getItemCameraTransforms();
    }*/
}
