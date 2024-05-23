package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ArcherLucia;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArcherLuciaRenderer extends TermianBipedRenderer<ArcherLucia> {
    public ArcherLuciaRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    public ResourceLocation getTextureLocation(ArcherLucia lucia) {
        return BackMath.resourceLoc("textures/entity/archer_lucia.png");
    }
}
