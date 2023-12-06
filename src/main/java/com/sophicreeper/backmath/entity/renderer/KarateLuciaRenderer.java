package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.KarateLucia;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KarateLuciaRenderer extends BMBipedRenderer<KarateLucia> {
    public KarateLuciaRenderer(EntityRendererManager manager) {
        super(manager, new BMBipedModel<>(0, 0, 64, 32), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0, 64, 32), new BMBipedModel<>(1, 0, 64, 32)));
    }

    public ResourceLocation getEntityTexture(KarateLucia karateLucia) {
        return BackMath.resourceLoc("textures/entity/karate_lucia.png");
    }
}
