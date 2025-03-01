package com.sophicreeper.backmath.blockentity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.custom.head.AbstractHeadBlock;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.blockentity.custom.BMHeadType;
import com.sophicreeper.backmath.variant.queenlucy.QueenLucyVariant;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BMItemStackBlockEntityRenderer extends ItemStackTileEntityRenderer {
    @Override
    public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        Item item = stack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            if (block instanceof AbstractHeadBlock) {
                if (item == AxolotlTest.WANDERER_SOPHIE_HEAD.get()) {
                    ResourceLocation headTexture = BMHeadType.WANDERER_SOPHIE.getTextureLocation();
                    ResourceLocation emissiveTexture = null;
                    WandererSophieVariant variant = WandererSophieVariant.getVariantFromStack(stack);
                    if (variant != null) headTexture = BackMath.textureLocation(variant.getTextureLocation());
                    if (variant != null && variant.getEmissiveTexture() != null) emissiveTexture = BackMath.textureLocation(variant.getEmissiveTexture());
                    WandererSophieHeadBlockEntityRenderer.renderHead(null, 180, headTexture, emissiveTexture, matrixStack, buffer, combinedLight);
                } else if (item == AxolotlTest.QUEEN_LUCY_HEAD.get()) {
                    ResourceLocation headTexture = BMHeadType.QUEEN_LUCY.getTextureLocation();
                    ResourceLocation emissiveTexture = null;
                    QueenLucyVariant variant = QueenLucyVariant.getVariantFromStack(stack);
                    if (variant != null) headTexture = BackMath.textureLocation(variant.getTextureLocation());
                    if (variant != null && variant.getEmissiveTexture() != null) emissiveTexture = BackMath.textureLocation(variant.getEmissiveTexture());
                    QueenLucyHeadBlockEntityRenderer.renderHead(null, 180, headTexture, emissiveTexture, matrixStack, buffer, combinedLight);
                } else {
                    HeadBlockEntityRenderer.renderHead(null, 180, ((AbstractHeadBlock) block).getType(), matrixStack, buffer, combinedLight);
                }
            }
        }
    }
}
