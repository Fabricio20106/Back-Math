package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.model.entity.BMBipedModel;
import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.entity.monster.InsomniaSophie;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InsomniaSophieRenderer extends BipedRenderer<InsomniaSophie, BMBipedModel<InsomniaSophie>> {
    private static final ResourceLocation INSOMNIA_SOPHIE_LOCATION = BackMath.resourceLoc("textures/entity/insomnia_sophie.png");

    public InsomniaSophieRenderer(EntityRendererManager p_i50974_1_) {
        super(p_i50974_1_, new BMBipedModel<>(0.0F, 0.0F, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0.0F, 64, 32), new BMBipedModel<>(1.0F, 0.0F, 64, 32)));
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(InsomniaSophie insomniaSophie) {
        return INSOMNIA_SOPHIE_LOCATION;
    }
}
