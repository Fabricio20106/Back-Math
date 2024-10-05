package com.sophicreeper.backmath.entity.misc;

import com.sophicreeper.backmath.entity.custom.aljamic.AljamicGroupMemberEntity;
import net.minecraft.entity.ILivingEntityData;

public class AljamicGroupData implements ILivingEntityData {
    public final AljamicGroupMemberEntity leader;

    public AljamicGroupData(AljamicGroupMemberEntity leader) {
        this.leader = leader;
    }
}
