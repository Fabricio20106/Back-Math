package com.sophicreeper.backmath.core.world.dimension;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.level.block.AljanPortalStandBlock;
import com.sophicreeper.backmath.core.world.level.block.BMBlockStateProperties;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.material.BMFluids;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
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
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        // Used to be 61.
        double y = 63;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX() + 2.5f, y, thisPos.getZ());

        int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) && !destinationWorld.getBlockState(destinationPos).isReplaceable(Fluids.WATER) &&
                destinationWorld.getBlockState(destinationPos.up()).getMaterial() != Material.AIR && !destinationWorld.getBlockState(destinationPos.up()).isReplaceable(Fluids.WATER) && tries < 25 &&
                (destinationWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) && !destinationWorld.getBlockState(destinationPos).isReplaceable(BMFluids.SLEEPISHWATER.get()) &&
                destinationWorld.getBlockState(destinationPos.up()).getMaterial() != Material.AIR && !destinationWorld.getBlockState(destinationPos.up()).isReplaceable(BMFluids.SLEEPISHWATER.get()) && tries < 25) {
            destinationPos = destinationPos.up(2);
            tries++;
        }

        entity.setPositionAndUpdate(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.getAllInBoxMutable(destinationPos.down(10).west(10), destinationPos.up(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof AljanPortalStandBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                if (BMConfigs.SERVER_CONFIGS.safeAljan.get()) {
                    destinationWorld.setBlockState(destinationPos, BMBlocks.ALJAN_PORTAL_STAND.get().getDefaultState().with(BMBlockStateProperties.JANTICAL, true));
                } else {
                    destinationWorld.setBlockState(destinationPos, BMBlocks.ALJAN_PORTAL_STAND.get().getDefaultState());
                }
            }
        }

        return entity;
    }
}
