package com.sophicreeper.backmath.core.client.model.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AmaracamelerModel<T extends Entity> extends SegmentedModel<T> {
    private final ModelRenderer slimeBodies;
    private final ModelRenderer slimeRightEye;
    private final ModelRenderer slimeLeftEye;
    private final ModelRenderer slimeMouth;

    public AmaracamelerModel(int size) {
        this.slimeBodies = new ModelRenderer(this, 0, size);
        this.slimeRightEye = new ModelRenderer(this, 32, 0);
        this.slimeLeftEye = new ModelRenderer(this, 32, 4);
        this.slimeMouth = new ModelRenderer(this, 32, 8);
        if (size > 0) {
            this.slimeBodies.addBox(-3, 17, -3, 6, 6, 6);
            this.slimeRightEye.addBox(-3.25F, 18, -3.5F, 2, 2, 2);
            this.slimeLeftEye.addBox(1.25F, 18, -3.5F, 2, 2, 2);
            this.slimeMouth.addBox(0, 21, -3.5F, 1, 1, 1);
        } else {
            this.slimeBodies.addBox(-4, 16, -4, 8, 8, 8);
        }

    }

    public void setRotationAngles(T amaracameler, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.slimeBodies, this.slimeRightEye, this.slimeLeftEye, this.slimeMouth);
    }
}
