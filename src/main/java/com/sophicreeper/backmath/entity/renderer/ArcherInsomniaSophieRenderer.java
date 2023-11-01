package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ArcherInsomniaSophie;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArcherInsomniaSophieRenderer extends BipedRenderer<ArcherInsomniaSophie, BMBipedModel<ArcherInsomniaSophie>> {
    private static final ResourceLocation ARCHER_INSOMNIA_SOPHIE_LOCATION = BackMath.resourceLoc("textures/entity/insomnia_sophie.png");

    public ArcherInsomniaSophieRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BMBipedModel<>(0, 0, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0, 64, 32), new BMBipedModel<>(1, 0, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    public ResourceLocation getEntityTexture(ArcherInsomniaSophie archerInsomniaSophie) {
        return ARCHER_INSOMNIA_SOPHIE_LOCATION;
    }
}