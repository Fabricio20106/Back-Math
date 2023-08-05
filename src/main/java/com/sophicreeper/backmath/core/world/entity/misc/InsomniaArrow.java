package com.sophicreeper.backmath.core.world.entity.misc;

import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class InsomniaArrow extends AbstractArrow {
    private int poisonDuration = 200;
    private int blindnessDuration = 600;

    public InsomniaArrow(EntityType<? extends AbstractArrow> type, Level world) {
        super(type, world);
    }

    public InsomniaArrow(Level world, LivingEntity shooter) {
        super(BMEntities.INSOMNIA_ARROW.get(), shooter, world);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(AxolotlTest.INSOMNIA_ARROW.get());
    }

    protected void doPostHurtEffects(LivingEntity livingEntity) {
        super.doPostHurtEffects(livingEntity);
        MobEffectInstance poison = new MobEffectInstance(MobEffects.POISON, this.poisonDuration, 0);
        MobEffectInstance blindness = new MobEffectInstance(MobEffects.BLINDNESS, this.blindnessDuration, 0);
        livingEntity.addEffect(poison);
        livingEntity.addEffect(blindness);
    }

    public void addAdditionalSaveData(CompoundTag compoundNBT) {
        super.addAdditionalSaveData(compoundNBT);
        if (compoundNBT.contains("PoisonDuration")) {
            this.poisonDuration = compoundNBT.getInt("PoisonDuration");
        }
        if (compoundNBT.contains("BlindnessDuration")) {
            this.blindnessDuration = compoundNBT.getInt("BlindnessDuration");
        }
    }

    public void readAdditionalSaveData(CompoundTag compoundNBT) {
        super.readAdditionalSaveData(compoundNBT);
        compoundNBT.putInt("PoisonDuration", this.poisonDuration);
        compoundNBT.putInt("BlindnessDuration", this.blindnessDuration);
    }

    @Override
    public void tickDespawn() {
        if (this.inGroundTime > 1200) {
            this.discard();
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
