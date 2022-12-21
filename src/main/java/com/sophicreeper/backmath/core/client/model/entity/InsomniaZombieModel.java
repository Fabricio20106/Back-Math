package com.sophicreeper.backmath.core.client.model.entity;

import com.sophicreeper.backmath.core.world.entity.monster.aljan.InsomniaZombie;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InsomniaZombieModel extends BMZombieBipedModel<InsomniaZombie> {
    public InsomniaZombieModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
        super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
    }
}
