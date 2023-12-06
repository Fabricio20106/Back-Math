package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.entity.model.QueenLucyPetModel;
import com.sophicreeper.backmath.entity.custom.QueenLucyPet;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyPetRenderer extends BipedRenderer<QueenLucyPet, QueenLucyPetModel> {
    public static final ResourceLocation[] QUEEN_LUCY_PET_LOCATIONS = new ResourceLocation[] {
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_current.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_alt.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_relic.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_shy_fabricio.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_original.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_modified.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_creeper.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_brazil_shirt.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_pajama.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_savannah.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_witcher.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_maid.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_yellow_sophixolotl.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_blue_sophixolotl.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_enderphie.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_worker.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_empresary2.png"),
            BackMath.resourceLoc("textures/entity/queen_lucy_pet/qsp_sv_entrepreneur.png")
    };

    public QueenLucyPetRenderer(EntityRendererManager manager) {
        super(manager, new QueenLucyPetModel(), 0.25f);
        // I'd rather not render the armor than have it render 2x the size of the mob.
        this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.25F, 0, 64, 32), new BMBipedModel<>(0.5f, 0, 64, 32)));
        // Elytra also renders 2x the mob size.
        // this.addLayer(new ElytraLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(QueenLucyPet queenLucyPet) {
        return QUEEN_LUCY_PET_LOCATIONS[queenLucyPet.getVariant()];
    }
}
