package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.AngrySophie;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AngrySophieRenderer extends BMBipedRenderer<AngrySophie> {
    public AngrySophieRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    public ResourceLocation getTextureLocation(AngrySophie sophie) {
        return BackMath.resourceLoc("textures/entity/angry_sophie.png");
    }
}
