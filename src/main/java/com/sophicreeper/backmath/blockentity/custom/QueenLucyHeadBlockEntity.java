package com.sophicreeper.backmath.blockentity.custom;

import com.sophicreeper.backmath.blockentity.BMBlockEntities;
import com.sophicreeper.backmath.util.TagTypes;
import com.sophicreeper.backmath.variant.queenlucy.BMQueenLucyVariants;
import com.sophicreeper.backmath.variant.queenlucy.QueenLucyVariant;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.sophicreeper.backmath.BackMath.textureLocation;

public class QueenLucyHeadBlockEntity extends TileEntity {
    @Nullable
    private QueenLucyVariant variant;

    public QueenLucyHeadBlockEntity() {
        super(BMBlockEntities.QUEEN_LUCY_HEAD.get());
    }

    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.worldPosition, 14, this.getUpdateTag());
    }

    @Override
    @Nonnull
    public CompoundNBT getUpdateTag() {
        return this.save(new CompoundNBT());
    }

    @Override
    @Nonnull
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        if (this.variant != null) tag.putString("variant", this.variant.getAssetID().toString());
        return tag;
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        super.load(state, tag);
        if (tag.contains("variant", TagTypes.STRING)) setVariant(tag.getString("variant"));
    }

    public void setVariant(String variant) {
        ResourceLocation variantLocation = ResourceLocation.tryParse(variant);
        boolean variantAvailable = QueenLucyVariant.DATA_DRIVEN_VARIANTS.containsKey(variantLocation);
        if (variantAvailable) {
            this.variant = QueenLucyVariant.DATA_DRIVEN_VARIANTS.get(variantLocation);
            this.setChanged();
        }
    }

    @Nullable
    public QueenLucyVariant getVariant() {
        return this.variant;
    }

    public void setVariant(QueenLucyVariant variant) {
        this.variant = variant;
        this.setChanged();
    }

    public ResourceLocation getHeadTexture() {
        return this.variant != null ? textureLocation(this.variant.getTextureLocation()) : textureLocation(BMQueenLucyVariants.CURRENT.get().getTextureLocation());
    }

    @Nullable
    public ResourceLocation getEmissiveHeadTexture() {
        return this.variant != null && this.variant.getEmissiveTexture() != null ? textureLocation(this.variant.getEmissiveTexture()) : null;
    }

    @Override
    @Nonnull
    public TileEntityType<?> getType() {
        return BMBlockEntities.QUEEN_LUCY_HEAD.get();
    }
}
