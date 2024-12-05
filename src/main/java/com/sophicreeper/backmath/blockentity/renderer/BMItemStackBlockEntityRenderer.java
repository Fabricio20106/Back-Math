package com.sophicreeper.backmath.blockentity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.block.custom.AbstractHeadBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// Heads currently don't render on the inventory.
public class BMItemStackBlockEntityRenderer extends ItemStackTileEntityRenderer {
    @Override
    public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        Item item = stack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            if (block instanceof AbstractHeadBlock) {
                HeadBlockEntityRenderer.renderHead(null, 180, ((AbstractHeadBlock) block).getType(), matrixStack, buffer, combinedLight);
            }
        }
    }
}
