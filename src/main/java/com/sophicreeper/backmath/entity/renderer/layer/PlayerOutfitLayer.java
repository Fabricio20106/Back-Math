package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.misc.WornOutfit;
import com.sophicreeper.backmath.item.custom.armor.OutfitItem;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlayerOutfitLayer<T extends AbstractClientPlayerEntity, A extends PlayerModel<T>> extends LayerRenderer<T, A> {
    public PlayerOutfitLayer(IEntityRenderer<T, A> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, T mob, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.HEAD, packedLight);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.CHEST, packedLight);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.LEGS, packedLight);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.FEET, packedLight);
    }

    private void renderOutfitPart(MatrixStack stack, IRenderTypeBuffer buffer, T player, EquipmentSlotType slotType, int packedLight) {
        A parentModel = this.getParentModel();
        parentModel.setAllVisible(true);

        if (!player.getItemBySlot(slotType).isEmpty() && player.getItemBySlot(slotType).getItem() instanceof OutfitItem) {
            OutfitItem item = (OutfitItem) player.getItemBySlot(slotType).getItem();
            RenderType translucentType = RenderType.entityTranslucent(WornOutfit.parseOutfitLocation(parentModel.slim, item.getMaterial().getName(), slotType));
            IVertexBuilder foilBuffer = ItemRenderer.getArmorFoilBuffer(buffer, translucentType, false, player.getItemBySlot(slotType).hasFoil());
            parentModel.renderToBuffer(stack, foilBuffer, packedLight, LivingRenderer.getOverlayCoords(player, 0), 1, 1, 1, 1);
        }
    }
}
