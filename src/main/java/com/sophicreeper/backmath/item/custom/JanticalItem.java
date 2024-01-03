package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.block.custom.AljanPortalStandBlock;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.misc.BMSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JanticalItem extends Item {
    public JanticalItem(Properties properties) {
        super(properties);
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        BlockState state = world.getBlockState(pos);
        if (state.isIn(BMBlocks.ALJAN_PORTAL_STAND.get()) && !state.get(AljanPortalStandBlock.JANTICAL)) {
            if (world.isRemote) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState withJantical = state.with(AljanPortalStandBlock.JANTICAL, true);
                Block.nudgeEntitiesWithNewState(state, withJantical, world, pos);
                world.setBlockState(pos, withJantical, 2);
                world.updateComparatorOutputLevel(pos, BMBlocks.ALJAN_PORTAL_STAND.get());
                context.getItem().shrink(1);

                world.playSound(null, pos, BMSounds.BLOCK_ALJAN_PORTAL_STAND_FILL, SoundCategory.BLOCKS, 1, 1);
                for(int k1 = 0; k1 < 16; ++k1) {
                    double particleX = (double) pos.getX() + (5 + random.nextDouble() * 6) / 16;
                    double particleY = (double) pos.getY() + 0.8125D;
                    double particleZ = (double) pos.getZ() + (5 + random.nextDouble() * 6) / 16;
                    world.addParticle(ParticleTypes.SMOKE, particleX, particleY, particleZ, 0, 0, 0);
                }

                return ActionResultType.CONSUME;
            }
        } else {
            return ActionResultType.PASS;
        }
    }
}
