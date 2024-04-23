package com.sophicreeper.backmath.world.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.world.dimension.BMDimensions;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class AljanSkyRenderer implements ISkyRenderHandler {
    private static final ResourceLocation ALJAN_SUN_TEXTURES = BackMath.resourceLoc("textures/environment/aljan_sun.png");
    private final VertexFormat skyVertexFormat = DefaultVertexFormats.POSITION;
    private VertexBuffer skyVBO;
    private VertexBuffer starVBO;
    private VertexBuffer sky2VBO;

    public AljanSkyRenderer() {
        this.generateStars();
        this.generateSky();
        this.generateSky2();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {
        if (mc.level != null && mc.level.dimension() == BMDimensions.THE_ALJAN) {
            RenderSystem.disableTexture();
            Vector3d skyColor = world.getSkyColor(mc.gameRenderer.getMainCamera().getBlockPosition(), partialTicks);
            FogRenderer.levelFogColor();
            BufferBuilder bufferBuilder = Tessellator.getInstance().getBuilder();
            RenderSystem.depthMask(false);
            RenderSystem.enableFog();
            RenderSystem.color3f((float) skyColor.x, (float) skyColor.y, (float) skyColor.z);
            this.skyVBO.bind();
            this.skyVertexFormat.setupBufferState(0L);
            this.skyVBO.draw(matrixStack.last().pose(), 7);
            VertexBuffer.unbind();
            this.skyVertexFormat.clearBufferState();
            RenderSystem.disableFog();
            RenderSystem.disableAlphaTest();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            float[] afloat = world.effects().getSunriseColor(world.getTimeOfDay(partialTicks), partialTicks);
            if (afloat != null) {
                RenderSystem.disableTexture();
                RenderSystem.shadeModel(7425);
                matrixStack.pushPose();
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(90));
                float f3 = MathHelper.sin(world.getSunAngle(partialTicks)) < 0 ? 180 : 0;
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(f3));
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90));
                float f4 = afloat[0];
                float f5 = afloat[1];
                float f6 = afloat[2];
                Matrix4f matrix4F = matrixStack.last().pose();
                bufferBuilder.begin(6, DefaultVertexFormats.POSITION_COLOR);
                bufferBuilder.vertex(matrix4F, 0, 100, 0).color(f4, f5, f6, afloat[3]).endVertex();

                for(int j = 0; j <= 16; ++j) {
                    float f7 = (float)j * ((float) Math.PI * 2F) / 16;
                    float f8 = MathHelper.sin(f7);
                    float f9 = MathHelper.cos(f7);
                    bufferBuilder.vertex(matrix4F, f8 * 120, f9 * 120, -f9 * 40 * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0).endVertex();
                }

                bufferBuilder.end();
                WorldVertexBufferUploader.end(bufferBuilder);
                matrixStack.popPose();
                RenderSystem.shadeModel(7424);
            }

            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            matrixStack.pushPose();
            float f11 = 1 - world.getRainLevel(partialTicks);
            RenderSystem.color4f(1, 1, 1, f11);
            matrixStack.mulPose(Vector3f.YP.rotationDegrees(-90));
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360));
            Matrix4f matrix4F = matrixStack.last().pose();

            mc.textureManager.bind(ALJAN_SUN_TEXTURES);
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
            bufferBuilder.vertex(matrix4F, -30, 100, -30).uv(0, 0).endVertex();
            bufferBuilder.vertex(matrix4F, 30, 100, -30).uv(1, 0).endVertex();
            bufferBuilder.vertex(matrix4F, 30, 100, 30).uv(1, 1).endVertex();
            bufferBuilder.vertex(matrix4F, -30, 100, 30).uv(0, 1).endVertex();
            bufferBuilder.end();
            WorldVertexBufferUploader.end(bufferBuilder);
            RenderSystem.disableTexture();
            float f10 = world.getStarBrightness(partialTicks) * f11;
            if (f10 > 0) {
                RenderSystem.color4f(f10, f10, f10, f10);
                this.starVBO.bind();
                this.skyVertexFormat.setupBufferState(0L);
                this.starVBO.draw(matrixStack.last().pose(), 7);
                VertexBuffer.unbind();
                this.skyVertexFormat.clearBufferState();
            }

            RenderSystem.color4f(1, 1, 1, 1);
            RenderSystem.disableBlend();
            RenderSystem.enableAlphaTest();
            RenderSystem.enableFog();
            matrixStack.popPose();
            RenderSystem.disableTexture();
            RenderSystem.color3f(0, 0, 0);
            double d0 = mc.player.getEyePosition(partialTicks).y - world.getLevelData().getHorizonHeight();
            if (d0 < 0) {
                matrixStack.pushPose();
                matrixStack.translate(0, 12, 0);
                this.sky2VBO.bind();
                this.skyVertexFormat.setupBufferState(0L);
                this.sky2VBO.draw(matrixStack.last().pose(), 7);
                VertexBuffer.unbind();
                this.skyVertexFormat.clearBufferState();
                matrixStack.popPose();
            }

            if (world.effects().hasGround()) {
                RenderSystem.color3f((float) (skyColor.x * 0.2F + 0.04F), (float) (skyColor.y * 0.2F + 0.04F), (float) (skyColor.z * 0.6F + 0.1F));
            } else {
                RenderSystem.color3f((float) skyColor.x, (float) skyColor.y, (float) skyColor.z);
            }

            RenderSystem.enableTexture();
            RenderSystem.depthMask(true);
            RenderSystem.disableFog();
        }
    }

    private void generateSky2() {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuilder();
        if (this.sky2VBO != null) {
            this.sky2VBO.close();
        }

        this.sky2VBO = new VertexBuffer(this.skyVertexFormat);
        renderSky(bufferbuilder, -16, true);
        bufferbuilder.end();
        this.sky2VBO.upload(bufferbuilder);
    }

    private void generateSky() {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuilder();
        if (this.skyVBO != null) {
            this.skyVBO.close();
        }

        this.skyVBO = new VertexBuffer(this.skyVertexFormat);
        renderSky(bufferbuilder, 16, false);
        bufferbuilder.end();
        this.skyVBO.upload(bufferbuilder);
    }

    private void renderSky(BufferBuilder bufferBuilder, float posY, boolean reverseX) {
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);

        for(int k = -384; k <= 384; k += 64) {
            for(int l = -384; l <= 384; l += 64) {
                float f = (float)k;
                float f1 = (float)(k + 64);
                if (reverseX) {
                    f1 = (float)k;
                    f = (float)(k + 64);
                }

                bufferBuilder.vertex(f, posY, l).endVertex();
                bufferBuilder.vertex(f1, posY, l).endVertex();
                bufferBuilder.vertex(f1, posY, (l + 64)).endVertex();
                bufferBuilder.vertex(f, posY, (l + 64)).endVertex();
            }
        }
    }

    private void generateStars() {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuilder();
        if (this.starVBO != null) {
            this.starVBO.close();
        }

        this.starVBO = new VertexBuffer(this.skyVertexFormat);
        renderStars(bufferbuilder);
        bufferbuilder.end();
        this.starVBO.upload(bufferbuilder);
    }

    private void renderStars(BufferBuilder bufferBuilderIn) {
        Random random = new Random(10842L);
        bufferBuilderIn.begin(7, DefaultVertexFormats.POSITION);

        for(int i = 0; i < 1500; ++i) {
            double d0 = random.nextFloat() * 2 - 1;
            double d1 = random.nextFloat() * 2 - 1;
            double d2 = random.nextFloat() * 2 - 1;
            double d3 = 0.15F + random.nextFloat() * 0.1F;
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
                double d14 = random.nextDouble() * Math.PI * 2;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for(int j = 0; j < 4; ++j) {
                    double d18 = (double)((j & 2) - 1) * d3;
                    double d19 = (double)((j + 1 & 2) - 1) * d3;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0 * d13;
                    double d24 = 0 * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    bufferBuilderIn.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }
    }
}
