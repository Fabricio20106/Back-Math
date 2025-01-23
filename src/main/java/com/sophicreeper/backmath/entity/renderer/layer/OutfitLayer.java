package com.sophicreeper.backmath.entity.renderer.layer;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.misc.WornOutfit;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class OutfitLayer<T extends LivingEntity, A extends BipedModel<T>> extends LayerRenderer<T, A> {
    public static final Map<String, ResourceLocation> OUTFIT_TEXTURE_CACHE = Maps.newHashMap();
    private final boolean slimArms;

    public OutfitLayer(IEntityRenderer<T, A> renderer, boolean slimArms) {
        super(renderer);
        this.slimArms = slimArms;
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, T mob, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.HEAD, packedLight, this.slimArms);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.CHEST, packedLight, this.slimArms);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.LEGS, packedLight, this.slimArms);
        this.renderOutfitPart(stack, buffer, mob, EquipmentSlotType.FEET, packedLight, this.slimArms);
    }

    private void renderOutfitPart(MatrixStack stack, IRenderTypeBuffer buffer, T mob, EquipmentSlotType slotType, int packedLight, boolean slimArms) {
        boolean isWearingOutfit = false;
        if (mob instanceof WornOutfit) isWearingOutfit = ((WornOutfit) mob).isWearingOutfit();

        ItemStack armorStack = mob.getItemBySlot(slotType);
        A parentModel = this.getParentModel();
        parentModel.setAllVisible(true);

        // Updated outfit rendering ~isa 4-12-24
        if (mob instanceof WornOutfit && isWearingOutfit) {
            WornOutfit outfit = (WornOutfit) mob;
            ResourceLocation outfitLocation = OUTFIT_TEXTURE_CACHE.computeIfAbsent(WornOutfit.parseOutfitLocation(slimArms, outfit.getOutfitTexture(), slotType).toString(), ResourceLocation::new);
            IVertexBuilder translucentBuffer = buffer.getBuffer(RenderType.entityTranslucent(outfitLocation));
            float transparency = mob.isInvisible() && !mob.isInvisibleTo(Minecraft.getInstance().player) ? 0.15F : (mob.isInvisible() ? 0 : 1);
            if (outfit.shouldHideTexture(slimArms, slotType)) parentModel.renderToBuffer(stack, translucentBuffer, packedLight, LivingRenderer.getOverlayCoords(mob, 0), 1, 1, 1, transparency);
        } else if (!armorStack.isEmpty() && armorStack.getItem() instanceof ArmorItem && armorStack.getItem().is(BMItemTags.OUTFITS)) {
            ArmorItem item = (ArmorItem) mob.getItemBySlot(slotType).getItem();
            ResourceLocation outfitLocation = OUTFIT_TEXTURE_CACHE.computeIfAbsent(WornOutfit.parseOutfitLocation(slimArms, item.getMaterial().getName(), slotType).toString(), ResourceLocation::new);
            if (item.is(BMItemTags.FULLY_LIT_ITEMS)) packedLight = LightTexture.pack(15, 15);

            RenderType translucentType = RenderType.entityTranslucent(outfitLocation);
            parentModel.renderToBuffer(stack, buffer.getBuffer(translucentType), packedLight, LivingRenderer.getOverlayCoords(mob, 0), 1, 1, 1, 1);
        }
    }
}
