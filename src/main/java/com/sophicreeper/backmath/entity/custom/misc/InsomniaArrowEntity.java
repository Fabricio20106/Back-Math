package com.sophicreeper.backmath.entity.custom.misc;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class InsomniaArrowEntity extends AbstractArrowEntity {
    private ItemStack arrowItem = new ItemStack(AxolotlTest.INSOMNIA_ARROW.get());
    private int poisonDuration = 200;
    private int blindnessDuration = 600;

    public InsomniaArrowEntity(EntityType<? extends AbstractArrowEntity> type, World world) {
        super(type, world);
    }

    public InsomniaArrowEntity(World world, double x, double y, double z) {
        super(BMEntities.INSOMNIA_ARROW.get(), x, y, z, world);
    }

    public InsomniaArrowEntity(World world, LivingEntity shooter) {
        super(BMEntities.INSOMNIA_ARROW.get(), shooter, world);
    }

    @Override
    @Nonnull
    protected ItemStack getPickupItem() {
        return this.arrowItem.copy();
    }

    @Override
    protected void doPostHurtEffects(LivingEntity livEntity) {
        super.doPostHurtEffects(livEntity);
        livEntity.addEffect(new EffectInstance(Effects.POISON, this.poisonDuration, 0));
        livEntity.addEffect(new EffectInstance(Effects.BLINDNESS, this.blindnessDuration, 0));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.put("item", this.arrowItem.save(new CompoundNBT()));
        tag.putInt("poison_duration", this.poisonDuration);
        tag.putInt("blindness_duration", this.blindnessDuration);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("item", TagTypes.COMPOUND)) this.arrowItem = ItemStack.of(tag.getCompound("item"));
        this.poisonDuration = tag.getInt("poison_duration");
        this.blindnessDuration = tag.getInt("blindness_duration");
    }

    @Override
    public void checkDespawn() {
        if (this.inGroundTime > 1200) this.remove();
    }

    @Override
    @Nonnull
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
