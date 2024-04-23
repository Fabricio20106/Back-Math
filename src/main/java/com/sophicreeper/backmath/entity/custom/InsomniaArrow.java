package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.item.AxolotlTest;
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

public class InsomniaArrow extends AbstractArrowEntity {
    private int poisonDuration = 200;
    private int blindnessDuration = 600;

    public InsomniaArrow(EntityType<? extends AbstractArrowEntity> type, World world) {
        super(type, world);
    }

    public InsomniaArrow(World world, double x, double y, double z) {
        super(BMEntities.INSOMNIA_ARROW.get(), x, y, z, world);
    }

    public InsomniaArrow(World world, LivingEntity shooter) {
        super(BMEntities.INSOMNIA_ARROW.get(), shooter, world);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(AxolotlTest.INSOMNIA_ARROW.get());
    }

    protected void doPostHurtEffects(LivingEntity livEntity) {
        super.doPostHurtEffects(livEntity);
        livEntity.addEffect(new EffectInstance(Effects.POISON, this.poisonDuration, 0));
        livEntity.addEffect(new EffectInstance(Effects.BLINDNESS, this.blindnessDuration, 0));
    }

    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        if (tag.contains("poison_duration")) {
            this.poisonDuration = tag.getInt("poison_duration");
        }
        if (tag.contains("blindness_duration")) {
            this.blindnessDuration = tag.getInt("blindness_duration");
        }
    }

    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        tag.putInt("poison_duration", this.poisonDuration);
        tag.putInt("blindness_duration", this.blindnessDuration);
    }

    @Override
    public void checkDespawn() {
        if (this.inGroundTime > 1200) this.remove();
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
