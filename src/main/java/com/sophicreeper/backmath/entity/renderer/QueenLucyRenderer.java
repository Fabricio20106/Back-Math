package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.entity.model.QueenLucyModel;
import com.sophicreeper.backmath.entity.custom.QueenLucy;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyRenderer extends BipedRenderer<QueenLucy, QueenLucyModel> {
    public QueenLucyRenderer(EntityRendererManager manager) {
        super(manager, new QueenLucyModel(), 0.5f);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0, 0, 64, 32), new BMBipedModel<>(1, 0, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(QueenLucy queenSophie) {
        return BackMath.resourceLoc("textures/entity/queen_lucy.png");
    }
}
