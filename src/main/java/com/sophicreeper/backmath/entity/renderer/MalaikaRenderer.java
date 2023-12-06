package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.entity.custom.Malaika;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MalaikaRenderer extends BMBipedRenderer<Malaika> {
    public MalaikaRenderer(EntityRendererManager manager) {
        super(manager, 0.5f);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5f, 0.5f, 64, 32), new BMBipedModel<>(1, 0, 64, 32)));
    }

    // Returns the location of an entity's texture.
    @Override
    public ResourceLocation getEntityTexture(Malaika malaika) {
        return BackMath.resourceLoc("textures/entity/malaika.png");
    }
}
