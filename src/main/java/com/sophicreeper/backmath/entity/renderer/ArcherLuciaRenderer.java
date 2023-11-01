package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ArcherLucia;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArcherLuciaRenderer extends BipedRenderer<ArcherLucia, BMBipedModel<ArcherLucia>> {
    public ArcherLuciaRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BMBipedModel<>(0, 0, 64, 32), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0, 64, 32), new BMBipedModel<>(1, 0, 64, 32)));
    }

    // Returns the location of an entity's texture.
    public ResourceLocation getEntityTexture(ArcherLucia archerLucia) {
        return BackMath.resourceLoc("textures/entity/archer_lucia.png");
    }
}