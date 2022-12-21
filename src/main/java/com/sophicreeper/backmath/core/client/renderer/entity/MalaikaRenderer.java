package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.client.model.entity.BMBipedModel;
import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MalaikaRenderer extends BipedRenderer<Malaika, BMBipedModel<Malaika>> {
    public static final ResourceLocation MALAIKA_LOCATION = BackMath.resourceLoc("textures/entity/malaika.png");

    public MalaikaRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BMBipedModel<>(0.0f, 0.0f, 64, 64), 0.5f);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5f, 0.5f, 64, 32), new BMBipedModel<>(1.0f, 0, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getEntityTexture(Malaika malaika) {
        return MALAIKA_LOCATION;
    }
}
