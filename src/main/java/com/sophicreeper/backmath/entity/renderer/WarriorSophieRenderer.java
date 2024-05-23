package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.WarriorSophie;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WarriorSophieRenderer extends TermianBipedRenderer<WarriorSophie> {
    public WarriorSophieRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    public ResourceLocation getTextureLocation(WarriorSophie sophie) {
        return BackMath.resourceLoc("textures/entity/warrior_sophie.png");
    }
}