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

    public InsomniaArrow(World world, LivingEntity shooter) {
        super(BMEntities.INSOMNIA_ARROW.get(), shooter, world);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(AxolotlTest.INSOMNIA_ARROW.get());
    }

    protected void arrowHit(LivingEntity livingEntity) {
        super.arrowHit(livingEntity);
        EffectInstance poison = new EffectInstance(Effects.POISON, this.poisonDuration, 0);
        EffectInstance blindness = new EffectInstance(Effects.BLINDNESS, this.blindnessDuration, 0);
        livingEntity.addPotionEffect(poison);
        livingEntity.addPotionEffect(blindness);
    }

    public void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        if (compoundNBT.contains("PoisonDuration")) {
            this.poisonDuration = compoundNBT.getInt("PoisonDuration");
        }
        if (compoundNBT.contains("BlindnessDuration")) {
            this.blindnessDuration = compoundNBT.getInt("BlindnessDuration");
        }
    }

    public void readAdditional(CompoundNBT compoundNBT) {
        super.readAdditional(compoundNBT);
        compoundNBT.putInt("PoisonDuration", this.poisonDuration);
        compoundNBT.putInt("BlindnessDuration", this.blindnessDuration);
    }

    @Override
    public void checkDespawn() {
        if (this.timeInGround > 1200) {
            this.remove();
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
