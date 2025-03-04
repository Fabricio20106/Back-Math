package com.sophicreeper.backmath.entity.misc;

import com.sophicreeper.backmath.entity.custom.alcalyte.GroupAlcalyteEntity;
import net.minecraft.entity.ILivingEntityData;

public class AlcalyteGroupData implements ILivingEntityData {
    public final GroupAlcalyteEntity leader;

    public AlcalyteGroupData(GroupAlcalyteEntity leader) {
        this.leader = leader;
    }
}
