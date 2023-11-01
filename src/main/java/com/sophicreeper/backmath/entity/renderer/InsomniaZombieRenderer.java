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
    public static final ResourceLocation INSOMNIA_ZOMBIE_LOCATION = BackMath.resourceLoc("textures/entity/zombie/insomnia_zombie.png");

    public InsomniaZombieRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new BMZombieBipedModel<>(0.0F, 0.0F, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMZombieBipedModel<>(0.5F, 0.0F, 64, 32), new BMZombieBipedModel<>(1.0F, 0.0F, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    public ResourceLocation getEntityTexture(InsomniaZombie insomniaZombie) {
        return INSOMNIA_ZOMBIE_LOCATION;
    }
}
