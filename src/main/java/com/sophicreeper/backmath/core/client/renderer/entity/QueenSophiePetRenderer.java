package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.client.model.entity.QueenLucyPetModel;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenLucyPet;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenSophiePetRenderer extends BipedRenderer<QueenLucyPet, QueenLucyPetModel> {
    public static final ResourceLocation[] QUEEN_SOPHIE_PET_LOCATIONS = new ResourceLocation[] {
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_current.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_alt.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_relic.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_shy_fabricio.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_original.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_modified.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_creeper.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_brazil_shirt.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_pajama.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_savannah.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_witcher.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_maid.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_yellow_sophixolotl.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_blue_sophixolotl.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_enderphie.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_worker.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_empresary2.png"),
            BackMath.resourceLoc("textures/entity/queen_sophie_pet/qsp_sv_entrepreneur.png")
    };

    public QueenSophiePetRenderer(EntityRendererManager renderManager) {
        super(renderManager, new QueenLucyPetModel(), 0.25f);
        // better not render armor than it being giant
        //this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.5F, 0.0F, 64, 32),
        //        new BMBipedModel<>(0.0F, 0.0F, 64, 32)));
        // elytra is also like this
        //this.addLayer(new ElytraLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(QueenLucyPet queenSophiePet) {
        return QUEEN_SOPHIE_PET_LOCATIONS[queenSophiePet.getVariant()];
    }
}
