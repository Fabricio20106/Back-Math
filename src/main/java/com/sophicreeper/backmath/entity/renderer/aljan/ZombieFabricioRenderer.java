package com.sophicreeper.backmath.entity.renderer.aljan;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.model.BMZombieModel;
import com.sophicreeper.backmath.entity.custom.aljan.ZombieFabricioEntity;
import com.sophicreeper.backmath.entity.model.ZombieFabricioModel;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class ZombieFabricioRenderer extends BipedRenderer<ZombieFabricioEntity, ZombieFabricioModel<ZombieFabricioEntity>> {
    public ZombieFabricioRenderer(EntityRendererManager manager) {
        super(manager, new ZombieFabricioModel<>(0, 0, 64, 64), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMZombieModel<>(0.5F, 0, 64, 32), new BMZombieModel<>(1, 0, 64, 32)));
        this.addLayer(new ElytraLayer<>(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(ZombieFabricioEntity zombie) {
        return BackMath.entityTexture("zombie/zombie_fabricio");
    }

    @Override
    protected boolean isShaking(ZombieFabricioEntity zombie) {
        return zombie.isConvertingToFabricio();
    }
}
