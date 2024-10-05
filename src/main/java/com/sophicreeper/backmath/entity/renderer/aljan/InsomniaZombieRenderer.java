package com.sophicreeper.backmath.entity.renderer.aljan;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.model.BMZombieModel;
import com.sophicreeper.backmath.entity.custom.aljan.InsomniaZombieEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class InsomniaZombieRenderer extends BipedRenderer<InsomniaZombieEntity, BMZombieModel<InsomniaZombieEntity>> {
    public InsomniaZombieRenderer(EntityRendererManager manager) {
        super(manager, new BMZombieModel<>(0, 0, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMZombieModel<>(0.5F, 0, 64, 32), new BMZombieModel<>(1, 0, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(InsomniaZombieEntity zombie) {
        return BackMath.entityTexture("zombie/insomnia_zombie");
    }
}
