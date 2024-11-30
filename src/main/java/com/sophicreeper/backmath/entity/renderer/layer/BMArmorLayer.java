package com.sophicreeper.backmath.entity.renderer.layer;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.item.custom.armor.OutfitItem;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;

import javax.annotation.Nullable;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class BMArmorLayer<T extends LivingEntity, M extends BipedModel<T>, A extends BipedModel<T>> extends LayerRenderer<T, M> {
    private static final Map<String, ResourceLocation> ARMOR_LOCATION_CACHE = Maps.newHashMap();
    private final A leggingsModel;
    private final A model;

    public BMArmorLayer(IEntityRenderer<T, M> renderer, A leggingsModel, A model) {
        super(renderer);
        this.leggingsModel = leggingsModel;
        this.model = model;
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, T mob, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        this.renderArmorPiece(stack, buffer, mob, EquipmentSlotType.CHEST, packedLight, this.getArmorModel(EquipmentSlotType.CHEST));
        this.renderArmorPiece(stack, buffer, mob, EquipmentSlotType.LEGS, packedLight, this.getArmorModel(EquipmentSlotType.LEGS));
        this.renderArmorPiece(stack, buffer, mob, EquipmentSlotType.FEET, packedLight, this.getArmorModel(EquipmentSlotType.FEET));
        this.renderArmorPiece(stack, buffer, mob, EquipmentSlotType.HEAD, packedLight, this.getArmorModel(EquipmentSlotType.HEAD));
    }

    private void renderArmorPiece(MatrixStack stack, IRenderTypeBuffer buffer, T mob, EquipmentSlotType slotType, int packedLight, A armorModel) {
        ItemStack armorStack = mob.getItemBySlot(slotType);

        if (armorStack.getItem() instanceof ArmorItem && !(armorStack.getItem() instanceof OutfitItem)) {
            ArmorItem armorItem = (ArmorItem) armorStack.getItem();
            if (armorItem.getSlot() == slotType) {
                armorModel = ForgeHooksClient.getArmorModel(mob, armorStack, slotType, armorModel);
                this.getParentModel().copyPropertiesTo(armorModel);
                this.setPartVisibility(armorModel, slotType);
                boolean enchantmentGlint = armorStack.hasFoil();

                if (armorItem instanceof IDyeableArmorItem) {
                    int color = ((IDyeableArmorItem) armorItem).getColor(armorStack);
                    float red = (float) (color >> 16 & 255) / 255;
                    float green = (float) (color >> 8 & 255) / 255;
                    float blue = (float) (color & 255) / 255;
                    this.renderModel(stack, buffer, armorStack, packedLight, enchantmentGlint, armorModel, red, green, blue, this.getArmorResource(mob, armorStack, slotType, null));
                    this.renderModel(stack, buffer, armorStack, packedLight, enchantmentGlint, armorModel, 1, 1, 1, this.getArmorResource(mob, armorStack, slotType, "overlay"));
                } else {
                    this.renderModel(stack, buffer, armorStack, packedLight, enchantmentGlint, armorModel, 1, 1, 1, this.getArmorResource(mob, armorStack, slotType, null));
                }
            }
        }
    }

    protected void setPartVisibility(A model, EquipmentSlotType slotType) {
        model.setAllVisible(false);
        switch(slotType) {
            case HEAD:
                model.head.visible = true;
                model.hat.visible = true;
                break;
            case CHEST:
                model.body.visible = true;
                model.rightArm.visible = true;
                model.leftArm.visible = true;
                break;
            case LEGS:
                model.body.visible = true;
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
                break;
            case FEET:
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
        }
    }

    private void renderModel(MatrixStack stack, IRenderTypeBuffer buffer, ItemStack armorStack, int packedLight, boolean enchantmentGlint, A armorModel, float red, float green, float blue, ResourceLocation textureLocation) {
        int light = armorStack.getItem().is(BMItemTags.FULLY_LIT_ITEMS) ? LightTexture.pack(15, 15) : packedLight;
        IVertexBuilder foilBuffer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.armorCutoutNoCull(textureLocation), false, enchantmentGlint);
        armorModel.renderToBuffer(stack, foilBuffer, light, OverlayTexture.NO_OVERLAY, red, green, blue, 1);
    }

    private A getArmorModel(EquipmentSlotType slotType) {
        return this.usesInnerModel(slotType) ? this.leggingsModel : this.model;
    }

    private boolean usesInnerModel(EquipmentSlotType slotType) {
        return slotType == EquipmentSlotType.LEGS;
    }

    public ResourceLocation getArmorResource(Entity entity, ItemStack stack, EquipmentSlotType slotType, @Nullable String overlayName) {
        ArmorItem armorItem = (ArmorItem) stack.getItem();
        String materialName = armorItem.getMaterial().getName();
        String namespace = "minecraft";
        int index = materialName.indexOf(':');

        if (index != -1) {
            namespace = materialName.substring(0, index);
            materialName = materialName.substring(index + 1);
        }
        String format = String.format("%s:textures/models/armor/%s_layer_%d%s.png", namespace, materialName, (usesInnerModel(slotType) ? 2 : 1), overlayName == null ? "" : String.format("_%s", overlayName));

        format = ForgeHooksClient.getArmorTexture(entity, stack, format, slotType, overlayName);
        ResourceLocation cacheLocation = ARMOR_LOCATION_CACHE.get(format);

        if (cacheLocation == null) {
            cacheLocation = new ResourceLocation(format);
            ARMOR_LOCATION_CACHE.put(format, cacheLocation);
        }

        return cacheLocation;
    }
}
