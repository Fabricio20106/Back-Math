package com.sophicreeper.backmath.entity.misc;

import net.minecraft.entity.ILivingEntityData;

public class ZombieGroupData implements ILivingEntityData {
    public final boolean isBaby;
    public final boolean canSpawnJockey;

    public ZombieGroupData(boolean isBaby, boolean canSpawnJockey) {
        this.isBaby = isBaby;
        this.canSpawnJockey = canSpawnJockey;
    }
}
