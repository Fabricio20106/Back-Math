package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.model.entity.BMBipedModel;
import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.entity.monster.WarriorSophie;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WarriorSophieRenderer extends BipedRenderer<WarriorSophie, BMBipedModel<WarriorSophie>> {
    public WarriorSophieRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new BMBipedModel<>(0.0F, 0.0F, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0.0F, 64, 32), new BMBipedModel<>(1.0F, 0.0F, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(WarriorSophie warriorSophie) {
        return BackMath.resourceLoc("textures/entity/warrior_sophie.png");
    }
}