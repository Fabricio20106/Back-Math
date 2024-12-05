package com.sophicreeper.backmath.entity.custom.termian;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class TermianMemberEntity extends TermianRaiderEntity {
    public TermianMemberEntity(EntityType<? extends CreatureEntity> mob, World world) {
        super(mob, world);
    }

    @OnlyIn(Dist.CLIENT)
    public ArmPose getArmPose() {
        return ArmPose.NEUTRAL;
    }

    @OnlyIn(Dist.CLIENT)
    public enum ArmPose {
        ATTACKING,
        CASTING_SPELL,
        BOW_AND_ARROW,
        CROSSBOW_HOLD,
        CROSSBOW_CHARGE,
        CELEBRATING,
        NEUTRAL
    }
}
