package com.sophicreeper.backmath.core.world.dimension;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.level.block.AljanPortalStandBlock;
import com.sophicreeper.backmath.core.world.level.block.BMBlockStateProperties;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.material.BMFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class TheAljanTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public TheAljanTeleporter(BlockPos pos, boolean insideDimension) {
        thisPos = pos;
        TheAljanTeleporter.insideDimension = insideDimension;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destinationWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        // Used to be 61.
        double y = 63;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX() + 2.5f, y, thisPos.getZ());

        int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).get() != Material.AIR) && !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                destinationWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR && !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && tries < 25 &&
                (destinationWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) && !destinationWorld.getBlockState(destinationPos).canBeReplaced(BMFluids.SLEEPISHWATER.get()) &&
                destinationWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR && !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(BMFluids.SLEEPISHWATER.get()) && tries < 25) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.teleportTo(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10), destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof AljanPortalStandBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                if (BMConfigs.SERVER_CONFIGS.safeAljan.get()) {
                    destinationWorld.setBlockAndUpdate(destinationPos, BMBlocks.ALJAN_PORTAL_STAND.get().defaultBlockState().setValue(BMBlockStateProperties.JANTICAL, true));
                } else {
                    destinationWorld.setBlockAndUpdate(destinationPos, BMBlocks.ALJAN_PORTAL_STAND.get().defaultBlockState());
                }
            }
        }

        return entity;
    }
}
