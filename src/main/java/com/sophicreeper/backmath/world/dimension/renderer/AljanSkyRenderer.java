package com.sophicreeper.backmath.world.dimension.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.sophicreeper.backmath.BackMath;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.ISkyRenderHandler;

import java.util.Random;

// Methods copied from vanilla's WorldRenderer class.
@SuppressWarnings("deprecation")
public class AljanSkyRenderer implements ISkyRenderHandler {
    public static final ResourceLocation ALJAN_SUN = BackMath.texture("environment/aljan_sun");
    private final VertexFormat skyVertexFormat = DefaultVertexFormats.POSITION;
    private VertexBuffer starsBuffer;
    private VertexBuffer lightSkyBuffer;
    private VertexBuffer darkSkyBuffer;

    public AljanSkyRenderer() {
        this.generateStars(3000);
        this.makeBrightSky();
        this.makeDarkSky();
    }

    /**
     * Mostly copied from {@link net.minecraft.client.renderer.WorldRenderer#renderSky WorldRenderer.renderSky(MatrixStack, float)}.
    */
    @Override
    public void render(int ticks, float partialTicks, MatrixStack stack, ClientWorld world, Minecraft minecraft) {
        RenderSystem.disableTexture();
        Vector3d vector3D = world.getSkyColor(minecraft.gameRenderer.getMainCamera().getBlockPosition(), partialTicks);
        FogRenderer.levelFogColor();
        BufferBuilder buffer = Tessellator.getInstance().getBuilder();
        RenderSystem.depthMask(false);
        RenderSystem.enableFog();
        RenderSystem.color3f((float) vector3D.x, (float) vector3D.y, (float) vector3D.z);
        this.lightSkyBuffer.bind();
        this.skyVertexFormat.setupBufferState(0L);
        this.lightSkyBuffer.draw(stack.last().pose(), 7);
        VertexBuffer.unbind();
        this.skyVertexFormat.clearBufferState();
        RenderSystem.disableFog();
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        float[] sunriseColors = world.effects().getSunriseColor(world.getTimeOfDay(partialTicks), partialTicks);
        if (sunriseColors != null) {
            stack.pushPose();
            stack.mulPose(Vector3f.XP.rotationDegrees(90));
            float sunAngle = MathHelper.sin(world.getSunAngle(partialTicks)) < 0 ? 180 : 0;
            stack.mulPose(Vector3f.ZP.rotationDegrees(sunAngle));
            stack.mulPose(Vector3f.ZP.rotationDegrees(90));
            float sunriseColor1 = sunriseColors[0];
            float sunriseColor2 = sunriseColors[1];
            float sunriseColor3 = sunriseColors[2];
            Matrix4f lastPose = stack.last().pose();
            buffer.begin(6, DefaultVertexFormats.POSITION_COLOR);
            buffer.vertex(lastPose, 0, 100, 0).color(sunriseColor1, sunriseColor2, sunriseColor3, sunriseColors[3]).endVertex();

            for (int j = 0; j <= 16; ++j) {
                float f7 = (float) j * ((float) Math.PI * 2F) / 16;
                float f8 = MathHelper.sin(f7);
                float f9 = MathHelper.cos(f7);
                buffer.vertex(lastPose, f8 * 120, f9 * 120, -f9 * 40 * sunriseColors[3]).color(sunriseColors[0], sunriseColors[1], sunriseColors[2], 0).endVertex();
            }

            buffer.end();
            WorldVertexBufferUploader.end(buffer);
            stack.popPose();
        }

        RenderSystem.enableTexture();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        stack.pushPose();
        stack.mulPose(Vector3f.YP.rotationDegrees(-90));
        stack.mulPose(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360));
        Matrix4f matrix4F = stack.last().pose();

        minecraft.textureManager.bind(ALJAN_SUN);
        buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        int sunPos = 30; // 30 is default.
        buffer.vertex(matrix4F, -sunPos, 100, -sunPos).uv(0, 0).endVertex();
        buffer.vertex(matrix4F, sunPos, 100, -sunPos).uv(1, 0).endVertex();
        buffer.vertex(matrix4F, sunPos, 100, sunPos).uv(1, 1).endVertex();
        buffer.vertex(matrix4F, -sunPos, 100, sunPos).uv(0, 1).endVertex();
        buffer.end();
        WorldVertexBufferUploader.end(buffer);
        RenderSystem.disableTexture();

        float rainLevel = 1 - world.getRainLevel(partialTicks);
        float starBrightness = world.getStarBrightness(partialTicks) * rainLevel;
        if (starBrightness > 0) {
            RenderSystem.color4f(starBrightness, starBrightness, starBrightness, starBrightness);
            this.starsBuffer.bind();
            this.skyVertexFormat.setupBufferState(0L);
            this.starsBuffer.draw(stack.last().pose(), 7);
            VertexBuffer.unbind();
            this.skyVertexFormat.clearBufferState();
        }

        RenderSystem.disableBlend();
        RenderSystem.enableAlphaTest();
        RenderSystem.enableFog();
        stack.popPose();
        assert minecraft.player != null;
        double startHeight = minecraft.player.getEyePosition(partialTicks).y - world.getLevelData().getHorizonHeight();
        if (startHeight < 0) {
            stack.pushPose();
            stack.translate(0, 12, 0);
            this.darkSkyBuffer.bind();
            this.skyVertexFormat.setupBufferState(0L);
            this.darkSkyBuffer.draw(stack.last().pose(), 7);
            VertexBuffer.unbind();
            this.skyVertexFormat.clearBufferState();
            stack.popPose();
        }

        //RenderSystem.color3f(x * 0.2F + 0.04F, y * 0.2F + 0.04F, z * 0.6F + 0.1F);

        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.enableAlphaTest();
    }

    private void makeDarkSky() {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuilder();
        if (this.darkSkyBuffer != null) this.darkSkyBuffer.close();

        this.darkSkyBuffer = new VertexBuffer(this.skyVertexFormat);
        drawSkyHemisphere(bufferBuilder, -16, true);
        bufferBuilder.end();
        this.darkSkyBuffer.upload(bufferBuilder);
    }

    private void makeBrightSky() {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuilder();
        if (this.lightSkyBuffer != null) this.lightSkyBuffer.close();

        this.lightSkyBuffer = new VertexBuffer(this.skyVertexFormat);
        drawSkyHemisphere(bufferBuilder, 16, false);
        bufferBuilder.end();
        this.lightSkyBuffer.upload(bufferBuilder);
    }

    private void drawSkyHemisphere(BufferBuilder bufferBuilder, float y, boolean bottomHemisphere) {
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);

        for (int k = -384; k <= 384; k += 64) {
            for (int l = -384; l <= 384; l += 64) {
                float f = (float) k;
                float f1 = (float) (k + 64);
                if (bottomHemisphere) {
                    f1 = (float) k;
                    f = (float) (k + 64);
                }

                bufferBuilder.vertex(f, y, l).endVertex();
                bufferBuilder.vertex(f1, y, l).endVertex();
                bufferBuilder.vertex(f1, y, (l + 64)).endVertex();
                bufferBuilder.vertex(f, y, (l + 64)).endVertex();
            }
        }
    }

    private void generateStars(int starCount) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuilder();
        if (this.starsBuffer != null) this.starsBuffer.close();

        this.starsBuffer = new VertexBuffer(this.skyVertexFormat);
        renderStars(bufferBuilder, starCount);
        bufferBuilder.end();
        this.starsBuffer.upload(bufferBuilder);
    }

    private void renderStars(BufferBuilder bufferBuilder, int starCount) {
        Random rand = new Random(10842L);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);

        for (int i = 0; i < starCount; ++i) {
            double d0 = rand.nextFloat() * 2 - 1;
            double d1 = rand.nextFloat() * 2 - 1;
            double d2 = rand.nextFloat() * 2 - 1;
            double d3 = 0.15F + rand.nextFloat() * 0.1F;
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d4 < 1 && d4 > 0.01D) {
                d4 = 1 / Math.sqrt(d4);
                d0 = d0 * d4;
                d1 = d1 * d4;
                d2 = d2 * d4;
                double d5 = d0 * 100;
                double d6 = d1 * 100;
                double d7 = d2 * 100;
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = rand.nextDouble() * Math.PI * 2;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for (int j = 0; j < 4; ++j) {
                    double d18 = (double) ((j & 2) - 1) * d3;
                    double d19 = (double) ((j + 1 & 2) - 1) * d3;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0 * d13;
                    double d24 = 0 * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    bufferBuilder.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }
    }
}
