package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.entity.model.QueenLucyPetModel;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class QueenLucyPetRenderer extends BipedRenderer<QueenLucyPetEntity, QueenLucyPetModel> {
    public QueenLucyPetRenderer(EntityRendererManager manager) {
        super(manager, new QueenLucyPetModel(), 0.25F);
        // I'd rather not render the armor than have it render 2x the size of the mob.
        // this.addLayer(new BipedArmorLayer<>(this, new BMBipedModel<>(0.25F, 0, 64, 32), new BMBipedModel<>(0.5F, 0, 64, 32)));
        // Elytra also renders 2x the mob size.
        // this.addLayer(new ElytraLayer<>(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(QueenLucyPetEntity lucy) {
        try {
            QueenLucyPetVariant variant = QueenLucyPetVariant.DATA_DRIVEN_VARIANTS.get(new ResourceLocation(lucy.getVariant()));
            return new ResourceLocation(variant.getTextureLocation().getNamespace(), "textures/" + variant.getTextureLocation().getPath() + ".png");
        } catch (NullPointerException exception) {
            return BackMath.entityTexture("queen_lucy_pet/qsp_current");
        }
    }
}
