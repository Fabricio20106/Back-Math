package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.WandererSophie;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WandererSophieRenderer extends TermianBipedRenderer<WandererSophie> {
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

    public WandererSophieRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
    }

    public ResourceLocation getTextureLocation(WandererSophie sophie) {
        return WANDERER_SOPHIE_LOCATIONS[sophie.getVariant()];
    }
}
