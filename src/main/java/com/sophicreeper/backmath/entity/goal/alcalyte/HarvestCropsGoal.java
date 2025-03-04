package com.sophicreeper.backmath.entity.goal.alcalyte;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Predicate;

import static net.minecraft.state.properties.BlockStateProperties.AGE_3;
import static net.minecraft.state.properties.BlockStateProperties.AGE_7;

public class HarvestCropsGoal extends MoveToBlockGoal {
    private final CreatureEntity entity;
    private final Predicate<BlockState> statePredicate;

    public HarvestCropsGoal(CreatureEntity entity, Predicate<BlockState> statePredicate) {
        super(entity, 1.1, 4);
        this.entity = entity;
        this.statePredicate = statePredicate;
    }

    @Override
    @Nonnull
    protected BlockPos getMoveToTarget() {
        return this.blockPos;
    }

    @Override
    public double acceptedDistance() {
        return 0.5F;
    }

    @Override
    public void tick() {
        super.tick();
        this.entity.getLookControl().setLookAt((double) this.blockPos.getX() + 0.5D, this.blockPos.getY() + 1,
                (double) this.blockPos.getZ() + 0.5D, 10, (float) this.entity.getMaxHeadXRot());

        if (this.isReachedTarget()) {
            BlockPos pos = this.blockPos;
            BlockState state = this.entity.level.getBlockState(this.blockPos);

            if (this.statePredicate.test(state)) {
                if (state.hasProperty(AGE_7) && state.getValue(AGE_7) == 7) {
                    breakBlock(AGE_7, state, pos);
                } else if (state.hasProperty(AGE_3) && state.getValue(AGE_3) == 3) {
                    breakBlock(AGE_3, state, pos);
                } else {
                    breakBlock(null, state, pos);
                }
            }
        }
    }

    @Override
    protected boolean isValidTarget(IWorldReader world, BlockPos pos) {
        return this.statePredicate.test(world.getBlockState(pos));
    }

    private void breakBlock(@Nullable IntegerProperty ageProperty, BlockState state, BlockPos pos) {
        World world = this.entity.level;
        Block.dropResources(state, world, pos, null);
        SoundType soundType = state.getSoundType(world, pos, null);
        world.playSound(null, pos, soundType.getBreakSound(), SoundCategory.BLOCKS, (soundType.getVolume() + 1) / 2, soundType.getPitch() * 0.8F);
        Minecraft.getInstance().particleEngine.destroy(pos, state);
        this.entity.swing(Hand.MAIN_HAND);
        if (ageProperty != null) world.setBlockAndUpdate(pos, state.setValue(ageProperty, 0));
        else world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
    }
}
