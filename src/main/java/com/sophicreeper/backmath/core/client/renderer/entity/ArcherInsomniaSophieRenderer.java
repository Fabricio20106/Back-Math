package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.model.entity.BMBipedModel;
import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.entity.monster.ArcherInsomniaSophie;
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

    public ArcherInsomniaSophieRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new BMBipedModel<>(0.0F, 0.0F, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0.0F, 64, 32), new BMBipedModel<>(1.0F, 0.0F, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    public ResourceLocation getEntityTexture(ArcherInsomniaSophie archerInsomniaSophie) {
        return ARCHER_INSOMNIA_SOPHIE_LOCATION;
    }
}
