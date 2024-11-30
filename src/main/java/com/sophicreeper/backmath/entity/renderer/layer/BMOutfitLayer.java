package com.sophicreeper.backmath.entity.renderer.layer;

import com.google.common.collect.Sets;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.entity.model.BMOutfitModel;
import com.sophicreeper.backmath.entity.model.BMPlayerModel;
import com.sophicreeper.backmath.item.custom.armor.OutfitItem;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Collections;

@OnlyIn(Dist.CLIENT)
public class BMOutfitLayer<T extends CreatureEntity, M extends BMOutfitModel<T>, A extends BMPlayerModel<T>> extends LayerRenderer<T, A> {
    private final BMPlayerModel<T> originalModel;

    public BMOutfitLayer(IEntityRenderer<T, A> renderer, BMPlayerModel<T> originalModel) {
        super(renderer);
        this.originalModel = originalModel;
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, T mob, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.HEAD, packedLight, this.originalModel);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.CHEST, packedLight, this.originalModel);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.LEGS, packedLight, this.originalModel);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.FEET, packedLight, this.originalModel);
    }

    private void renderOutfitPart(MatrixStack stack, IRenderTypeBuffer buffer, T mob, EquipmentSlotType slotType, int packedLight, BMPlayerModel<T> model) {
        boolean isWearingOutfit = false;
        if (mob instanceof TermianPatrollerEntity) isWearingOutfit = ((TermianPatrollerEntity) mob).isWearingOutfit();

        if (!mob.getItemBySlot(slotType).isEmpty() && mob.getItemBySlot(slotType).getItem() instanceof OutfitItem && !isWearingOutfit) {
            A outfitModel = this.getParentModel();
            outfitModel.setAllVisible(true);
            OutfitItem item = (OutfitItem) mob.getItemBySlot(slotType).getItem();
            IVertexBuilder translucentBuffer = buffer.getBuffer(RenderType.entityTranslucent(parseOutfitLocation(item.getMaterial().getName(), slotType)));
            outfitModel.renderToBuffer(stack, translucentBuffer, packedLight, LivingRenderer.getOverlayCoords(mob, 0), 1, 1, 1, 1);
        } else if (isWearingOutfit && mob instanceof TermianPatrollerEntity) {
            TermianPatrollerEntity patroller = (TermianPatrollerEntity) mob;
            ResourceLocation outfitLocation = patroller.parseOutfitLocation(this.originalModel, patroller.getOutfitTexture(), slotType);

            if (patroller.shouldHideTexture(this.originalModel, slotType)) {
                A outfitModel = this.getParentModel();
                outfitModel.setAllVisible(true);
                IVertexBuilder translucentBuffer = buffer.getBuffer(RenderType.entityTranslucent(outfitLocation));
                outfitModel.renderToBuffer(stack, translucentBuffer, packedLight, LivingRenderer.getOverlayCoords(mob, 0), 1, 1, 1, 1);
            }
        }
    }

    private ResourceLocation parseOutfitLocation(String name, EquipmentSlotType slotType) {
        ResourceLocation location = new ResourceLocation(name);
        ResourceLocation chestLocation = new ResourceLocation(location.getNamespace(), "textures/models/outfit/" + location.getPath() + "_" + slotType.getName() + "_" + (this.originalModel.slimArms() ? "slim" : "wide") + ".png");
        ResourceLocation defaultLocation = new ResourceLocation(location.getNamespace(), "textures/models/outfit/" + location.getPath() + "_" + slotType.getName() + ".png");

        return slotType == EquipmentSlotType.CHEST ? chestLocation : defaultLocation;
    }
}
