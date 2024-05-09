package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ArcherLucia;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArcherLuciaRenderer extends BMBipedRenderer<ArcherLucia> {
    public ArcherLuciaRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BMBipedModel<>(0, 0, 64, 32, false), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0, 64, 32, false), new BMBipedModel<>(1, 0, 64, 32, false)));
    }

    public ResourceLocation getTextureLocation(ArcherLucia archerLucia) {
        return BackMath.resourceLoc("textures/entity/archer_lucia.png");
    }
}
