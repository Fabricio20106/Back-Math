package com.sophicreeper.backmath.entity.goal;

import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.BreakBlockGoal;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class StompTurtleEggGoal extends BreakBlockGoal {
    private final CreatureEntity creature;

    public StompTurtleEggGoal(CreatureEntity creature, double d, int d1) {
        super(Blocks.TURTLE_EGG, creature, d, d1);
        this.creature = creature;
    }

    public void playDestroyProgressSound(IWorld world, BlockPos pos) {
        world.playSound(null, pos, SoundEvents.ZOMBIE_DESTROY_EGG, SoundCategory.HOSTILE, 0.5F, 0.9F + this.creature.getRandom().nextFloat() * 0.2F);
    }

    public void playBreakSound(World world, BlockPos pos) {
        world.playSound(null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + world.random.nextFloat() * 0.2F);
    }

    public double acceptedDistance() {
        return 1.14D;
    }
}
