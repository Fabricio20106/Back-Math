package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.util.tag.BMBlockTags;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;

public class QLPRandomFlyingGoal extends WaterAvoidingRandomWalkingGoal {
    public QLPRandomFlyingGoal(QueenLucyPetEntity lucyPet, double speed) {
        super(lucyPet, speed);
    }

    @Nullable
    protected Vector3d getPosition() {
        Vector3d position = null;

        if (this.mob.isInWater()) position = RandomPositionGenerator.getLandPos(this.mob, 15, 15);
        if (this.mob.getRandom().nextFloat() >= this.probability) position = this.getPreferredPosition();

        return position == null ? super.getPosition() : position;
    }

    @Nullable
    private Vector3d getPreferredPosition() {
        BlockPos pos = this.mob.blockPosition();
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();
        BlockPos.Mutable mutablePos1 = new BlockPos.Mutable();

        for (BlockPos pos1 : BlockPos.betweenClosed(MathHelper.floor(this.mob.getX() - 3), MathHelper.floor(this.mob.getY() - 6), MathHelper.floor(this.mob.getZ() - 3), MathHelper.floor(this.mob.getX() + 3),
                MathHelper.floor(this.mob.getY() + 6), MathHelper.floor(this.mob.getZ() + 3))) {
            if (!pos.equals(pos1)) {
                Block block = this.mob.level.getBlockState(mutablePos1.setWithOffset(pos1, Direction.DOWN)).getBlock();
                boolean isPreferred = block.is(BMBlockTags.QUEEN_LUCY_PET_PREFERRED_BLOCKS);
                if (isPreferred && this.mob.level.isEmptyBlock(pos1) && this.mob.level.isEmptyBlock(mutablePos.setWithOffset(pos1, Direction.UP))) {
                    return Vector3d.atBottomCenterOf(pos1);
                }
            }
        }

        return null;
    }
}
