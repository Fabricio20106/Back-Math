package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.AngrySophie;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AngrySophieRenderer extends BMBipedRenderer<AngrySophie> {
    public AngrySophieRenderer(EntityRendererManager renderManager) {
        super(renderManager, 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0, 64, 32, true), new BMBipedModel<>(1, 0, 64, 32, true)));
    }

    public ResourceLocation getTextureLocation(AngrySophie angrySophie) {
        return BackMath.resourceLoc("textures/entity/angry_sophie.png");
    }
}
