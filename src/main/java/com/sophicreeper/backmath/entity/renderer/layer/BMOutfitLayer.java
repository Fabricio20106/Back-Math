package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.misc.WornOutfit;
import com.sophicreeper.backmath.entity.model.BMOutfitModel;
import com.sophicreeper.backmath.entity.model.BMPlayerModel;
import com.sophicreeper.backmath.item.custom.armor.OutfitItem;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMOutfitLayer<T extends CreatureEntity, M extends BMOutfitModel<T>, A extends BMPlayerModel<T>> extends LayerRenderer<T, A> {
    public BMOutfitLayer(IEntityRenderer<T, A> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, T mob, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.HEAD, packedLight);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.CHEST, packedLight);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.LEGS, packedLight);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.FEET, packedLight);
    }

    private void renderOutfitPart(MatrixStack stack, IRenderTypeBuffer buffer, T mob, EquipmentSlotType slotType, int packedLight) {
        boolean isWearingOutfit = false;
        if (mob instanceof WornOutfit) isWearingOutfit = ((WornOutfit) mob).isWearingOutfit();

        A parentModel = this.getParentModel();
        parentModel.setAllVisible(true);

        // Updated outfit rendering ~isa 4-12-24
        if (mob instanceof WornOutfit && isWearingOutfit) {
            WornOutfit outfit = (WornOutfit) mob;
            ResourceLocation outfitLocation = WornOutfit.parseOutfitLocation(parentModel.slimArms(), outfit.getOutfitTexture(), slotType);
            IVertexBuilder translucentBuffer = buffer.getBuffer(RenderType.entityTranslucent(outfitLocation));
            if (outfit.shouldHideTexture(parentModel.slimArms(), slotType)) parentModel.renderToBuffer(stack, translucentBuffer, packedLight, LivingRenderer.getOverlayCoords(mob, 0), 1, 1, 1, 1);
        } else if (!mob.getItemBySlot(slotType).isEmpty() && mob.getItemBySlot(slotType).getItem() instanceof OutfitItem) {
            OutfitItem item = (OutfitItem) mob.getItemBySlot(slotType).getItem();
            RenderType translucentType = RenderType.entityTranslucent(WornOutfit.parseOutfitLocation(parentModel.slimArms(), item.getMaterial().getName(), slotType));
            IVertexBuilder foilBuffer = ItemRenderer.getArmorFoilBuffer(buffer, translucentType, false, mob.getItemBySlot(slotType).hasFoil());
            parentModel.renderToBuffer(stack, foilBuffer, packedLight, LivingRenderer.getOverlayCoords(mob, 0), 1, 1, 1, 1);
        }
    }
}
