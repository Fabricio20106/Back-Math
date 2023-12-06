package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ShyFabricio;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShyFabricioRenderer extends BMBipedRenderer<ShyFabricio> {
    public ShyFabricioRenderer(EntityRendererManager manager) {
        super(manager, 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0, 0, 64, 32), new BMBipedModel<>(1, 0, 64, 32)));
    }

    public ResourceLocation getEntityTexture(ShyFabricio shyFabricio) {
        return BackMath.resourceLoc("textures/entity/shy_fabricio.png");
    }
}
