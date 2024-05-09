package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.WandererSophie;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.entity.renderer.layer.WandererSophieCapeLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WandererSophieRenderer extends BMBipedRenderer<WandererSophie> {
    public static final ResourceLocation[] WANDERER_SOPHIE_LOCATIONS = new ResourceLocation[] {
            BackMath.resourceLoc("textures/entity/wanderer_sophie/yellow_axolotl.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/cyan_axolotl.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/creeper.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/modified.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/original.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/savannah.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/brazil_shirt.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/pajama.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/witcher.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/maid.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/ender.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/worker.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/blue_axolotl.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/cyan_axolotl_2.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/empresary2.png"),
            BackMath.resourceLoc("textures/entity/wanderer_sophie/entrepreneur.png")
    };

    public WandererSophieRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0, 64, 32, false), new BMBipedModel<>(1, 0, 64, 32, false)));
        this.addLayer(new WandererSophieCapeLayer(this));
    }

    public ResourceLocation getTextureLocation(WandererSophie wandererSophie) {
        return WANDERER_SOPHIE_LOCATIONS[wandererSophie.getVariant()];
    }
}
