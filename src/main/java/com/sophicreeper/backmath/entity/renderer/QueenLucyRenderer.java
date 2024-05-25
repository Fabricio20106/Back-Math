package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucy;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyRenderer extends TermianBipedRenderer<QueenLucy> {
    public QueenLucyRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
    }

    @Override
    public ResourceLocation getTextureLocation(QueenLucy lucy) {
        return BackMath.resourceLoc("textures/entity/queen_lucy.png");
    }
}
