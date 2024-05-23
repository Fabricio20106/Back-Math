package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ArcherInsomniaSophie;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArcherInsomniaSophieRenderer extends TermianBipedRenderer<ArcherInsomniaSophie> {
    public ArcherInsomniaSophieRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    public ResourceLocation getTextureLocation(ArcherInsomniaSophie sophie) {
        return BackMath.resourceLoc("textures/entity/insomnia_sophie.png");
    }
}
