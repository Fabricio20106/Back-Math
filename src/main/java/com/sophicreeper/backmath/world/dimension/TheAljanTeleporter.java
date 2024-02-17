package com.sophicreeper.backmath.world.dimension;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.custom.AljanPortalStandBlock;
import com.sophicreeper.backmath.block.custom.BMBlockStateProperties;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class TheAljanTeleporter implements ITeleporter {
    public static final Logger LOGGER = LogManager.getLogger();
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public TheAljanTeleporter(BlockPos pos, boolean insideDimension) {
        thisPos = pos;
        TheAljanTeleporter.insideDimension = insideDimension;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        // Used to be 61, then 63, then 0, now 1.
        double y = 0;

        if (!insideDimension) {
            y = thisPos.getY();
            if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Using last dimension's stand Y level, so the Y level is now {}", y);
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());
        if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("The current destination pos is {}, {}, {}", thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("About to try to find a suitable location for the Aljan Portal Stand...");
        while (destinationWorld.getBlockState(destinationPos).equals(Blocks.CAVE_AIR.getDefaultState()) && !destinationWorld.getBlockState(destinationPos).isIn(BMTags.Blocks.ALJAN_TELEPORTER_REPLACEABLES) && tries < 250) {
            destinationPos = destinationPos.up(1);
            tries++;
            if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Attempt {}: Could not find a suitable spot for the Aljan Portal Stand", tries);
        }

        while (destinationWorld.getBlockState(destinationPos.down()).getMaterial() == Material.AIR) {
            if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Moving location down since it's in the air (Y: {})", destinationPos.getY());
            if (destinationPos.getY() <= 0) {
                destinationPos = destinationPos.up(255);
                if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Resetting Y to {} since it looked for air below Y: 0", destinationPos.getY());
            }
            destinationPos = destinationPos.down(1);
        }
        // Now positions the entity at ~ ~1 ~ (~ = the location of the stand).
        if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Moving the player to {}, {}, {}", destinationPos.getX() + 0.5, destinationPos.getY() + 0.9, destinationPos.getZ() + 0.5);
        entity.setPositionAndUpdate(destinationPos.getX() + 0.5, destinationPos.getY() + 0.9, destinationPos.getZ() + 0.5);

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.getAllInBoxMutable(destinationPos.down(10).west(10), destinationPos.up(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof AljanPortalStandBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                if (COMMON_CONFIGS.safeAljan.get()) {
                    if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Placing the Aljan Portal Stand (with a Jantical) at X: {}, Y: {}, Y: {}", destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());
                    destinationWorld.setBlockState(destinationPos, BMBlocks.ALJAN_PORTAL_STAND.get().getDefaultState().with(BMBlockStateProperties.JANTICAL, true));
                } else {
                    if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Placing the Aljan Portal Stand (without a Jantical) at X: {}, Y: {}, Y: {}", destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());
                    destinationWorld.setBlockState(destinationPos, BMBlocks.ALJAN_PORTAL_STAND.get().getDefaultState());
                }
                // Places a Polished Sleepingstone below the stand when above water or sleepishwater
                if (destinationWorld.getFluidState(destinationPos.down()).isTagged(BMTags.Fluids.ALJAN_CARVER_REPLACEABLES)) {
                    if (COMMON_CONFIGS.logAljanTeleporterDebugging.get()) LOGGER.debug("Placing a Polished Sleepingstone at X: {}, Y: {}, Y: {}", destinationPos.getX(), destinationPos.down().getY(), destinationPos.getZ());
                    destinationWorld.setBlockState(destinationPos.down(), BMBlocks.POLISHED_SLEEPINGSTONE.get().getDefaultState());
                }
            }
        }

        return entity;
    }
}
