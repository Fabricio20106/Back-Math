package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.model.BMZombieBipedModel;
import com.sophicreeper.backmath.entity.custom.InsomniaZombie;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InsomniaZombieRenderer extends BipedRenderer<InsomniaZombie, BMZombieBipedModel<InsomniaZombie>> {
    public InsomniaZombieRenderer(EntityRendererManager manager) {
        super(manager, new BMZombieBipedModel<>(0, 0, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMZombieBipedModel<>(0.5F, 0, 64, 32), new BMZombieBipedModel<>(1, 0, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    public ResourceLocation getTextureLocation(InsomniaZombie zombie) {
        return BackMath.resourceLoc("textures/entity/zombie/insomnia_zombie.png");
    }
}
