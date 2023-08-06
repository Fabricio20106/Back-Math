package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.client.model.entity.BMBipedModel;
import com.sophicreeper.backmath.core.client.model.entity.QueenLucyModel;
import com.sophicreeper.backmath.core.world.entity.monster.QueenLucy;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenSophieRenderer extends BipedRenderer<QueenLucy, QueenLucyModel> {
    public QueenSophieRenderer(EntityRendererManager renderManager) {
        super(renderManager, new QueenLucyModel(), 0.5f);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0.0F, 64, 32), new BMBipedModel<>(1.0F, 0.0F, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(QueenLucy queenSophie) {
        return BackMath.resourceLoc("textures/entity/queen_sophie.png");
    }
}
