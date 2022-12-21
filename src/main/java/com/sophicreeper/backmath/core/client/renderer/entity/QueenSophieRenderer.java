package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.client.model.entity.BMBipedModel;
import com.sophicreeper.backmath.core.client.model.entity.QueenSophieModel;
import com.sophicreeper.backmath.core.world.entity.monster.QueenSophie;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenSophieRenderer extends BipedRenderer<QueenSophie, QueenSophieModel> {
    public QueenSophieRenderer(EntityRendererManager renderManager) {
        super(renderManager, new QueenSophieModel(), 0.5f);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0.0F, 64, 32), new BMBipedModel<>(1.0F, 0.0F, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(QueenSophie queenSophie) {
        return BackMath.resourceLoc("textures/entity/queen_sophie.png");
    }
}
