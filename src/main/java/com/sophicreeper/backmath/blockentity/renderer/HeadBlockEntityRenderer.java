package com.sophicreeper.backmath.blockentity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.block.custom.head.AbstractHeadBlock;
import com.sophicreeper.backmath.block.custom.head.HeadBlock;
import com.sophicreeper.backmath.block.custom.head.WallHeadBlock;
import com.sophicreeper.backmath.blockentity.custom.BMHeadType;
import com.sophicreeper.backmath.blockentity.custom.HeadBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.entity.model.HumanoidHeadModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class HeadBlockEntityRenderer extends TileEntityRenderer<HeadBlockEntity> {
    public HeadBlockEntityRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(HeadBlockEntity blockEntity, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        BlockState state = blockEntity.getBlockState();
        boolean isMountedOnWall = state.getBlock() instanceof WallHeadBlock;
        Direction facingDirection = isMountedOnWall ? state.getValue(WallHeadBlock.FACING) : null;
        float rotation = 22.5F * (float) (isMountedOnWall ? (2 + facingDirection.get2DDataValue()) * 4 : state.getValue(HeadBlock.ROTATION));
        renderHead(facingDirection, rotation, ((AbstractHeadBlock) state.getBlock()).getType(), stack, buffer, combinedLight);
    }

    public static void renderHead(@Nullable Direction facing, float rotation, BMHeadType type, MatrixStack stack, IRenderTypeBuffer buffer, int combinedLight) {
        GenericHeadModel headModel = type.usesPlayerLikeTexture() ? new HumanoidHeadModel() : new GenericHeadModel(0, 0, 64, 32);

        stack.pushPose();
        if (facing == null) {
            stack.translate(0.5D, 0, 0.5D);
        } else {
            stack.translate(0.5F - (float) facing.getStepX() * 0.25F, 0.25D, 0.5F - (float) facing.getStepZ() * 0.25F);
        }

        stack.scale(-1, -1, 1);
        IVertexBuilder translucentBuffer = buffer.getBuffer(RenderType.entityTranslucent(type.getTextureLocation()));
        headModel.setupAnim(0, rotation, 0);
        headModel.renderToBuffer(stack, translucentBuffer, combinedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        stack.popPose();

        if (type.getEyesLocation() != null) {
            stack.pushPose();
            if (facing == null) {
                stack.translate(0.5D, 0, 0.5D);
            } else {
                stack.translate(0.5F - (float) facing.getStepX() * 0.25F, 0.25D, 0.5F - (float) facing.getStepZ() * 0.25F);
            }

            stack.scale(-1, -1, 1);
            headModel.setupAnim(0, rotation, 0);

            IVertexBuilder eyesBuilder = buffer.getBuffer(RenderType.eyes(type.getEyesLocation()));
            headModel.renderToBuffer(stack, eyesBuilder, 0xF00000, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            stack.popPose();
        }
    }
}
