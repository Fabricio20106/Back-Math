package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.client.model.entity.BMBipedModel;
import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KarateLuciaRenderer extends BipedRenderer<KarateLucia, BMBipedModel<KarateLucia>> {
    public KarateLuciaRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BMBipedModel<>(0.0F, 0.0F, 64, 32), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0.0F, 64, 32), new BMBipedModel<>(1.0F, 0.0F, 64, 32)));
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(KarateLucia karateLucia) {
        return BackMath.resourceLoc("textures/entity/karate_lucia.png");
    }
}
