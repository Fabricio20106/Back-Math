package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.entity.renderer.layer.TermianPatrollerCapeLayer;
import com.sophicreeper.backmath.entity.renderer.layer.TermianPatrollerElytraLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TermianBipedRenderer<T extends TermianPatrollerEntity> extends BMBipedRenderer<T> {
    public TermianBipedRenderer(EntityRendererManager manager, float shadowSize, boolean slimArms) {
        super(manager, shadowSize, slimArms);
        this.addLayer(new TermianPatrollerElytraLayer<>(this));
        this.addLayer(new TermianPatrollerCapeLayer<>(this));
        this.enableDefaultElytra = false;
    }
}
