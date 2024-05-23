package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.Malaika;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MalaikaRenderer extends BMBipedRenderer<Malaika> {
    public MalaikaRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    // Returns the location of an entity's texture.
    @Override
    public ResourceLocation getTextureLocation(Malaika malaika) {
        return BackMath.resourceLoc("textures/entity/malaika.png");
    }
}
