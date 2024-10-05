package com.sophicreeper.backmath.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class AmaracamelerModel<T extends Entity> extends SegmentedModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer rightEye;
    private final ModelRenderer leftEye;
    private final ModelRenderer mouth;

    public AmaracamelerModel() {
        this(0);
    }

    public AmaracamelerModel(int size) {
        this.body = new ModelRenderer(this, 0, size);
        this.rightEye = new ModelRenderer(this, 32, 0);
        this.leftEye = new ModelRenderer(this, 32, 4);
        this.mouth = new ModelRenderer(this, 32, 8);
        if (size > 0) {
            this.body.addBox(-3, 17, -3, 6, 6, 6);
            this.rightEye.addBox(-3.25F, 18, -3.5F, 2, 2, 2);
            this.leftEye.addBox(1.25F, 18, -3.5F, 2, 2, 2);
            this.mouth.addBox(0, 21, -3.5F, 1, 1, 1);
        } else {
            this.body.addBox(-4, 16, -4, 8, 8, 8);
        }
    }

    public void setupAnim(T amaracameler, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    @Nonnull
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.body, this.rightEye, this.leftEye, this.mouth);
    }
}
