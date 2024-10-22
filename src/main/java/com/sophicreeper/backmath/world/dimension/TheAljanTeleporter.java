package com.sophicreeper.backmath.world.dimension;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.custom.AljanPortalStandBlock;
import com.sophicreeper.backmath.block.custom.BMBlockStateProperties;
import com.sophicreeper.backmath.util.tag.BMBlockTags;
import com.sophicreeper.backmath.util.tag.BMFluidTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.function.Function;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class TheAljanTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideTheAljan = true;

    public TheAljanTeleporter(BlockPos pos, boolean insideTheAljan) {
        thisPos = pos;
        TheAljanTeleporter.insideTheAljan = insideTheAljan;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);

        BlockPos targetPos = getTargetPosition(thisPos, entity, destinationWorld);
        double[] entityPos = new double[] {targetPos.getX() + 0.5, targetPos.getY() + 0.9, targetPos.getZ() + 0.5};
        sendMessage(new StringTextComponent("Moving the player to " + entityPos[0] + ", " + entityPos[1] + ", " + entityPos[2]));
        entity.teleportTo(entityPos[0], entityPos[1], entityPos[2]);
        placePortalStand(targetPos, destinationWorld, insideTheAljan, COMMON_CONFIGS.safeAljan.get());
        return entity;
    }

    public static BlockPos getTargetPosition(BlockPos pos, @Nullable Entity entity, ServerWorld destinationWorld) {
        // Used to be 61, then 63, then 0, then 1, now 0 again.
        int y = pos.getY();
        sendMessage(new StringTextComponent("Using last dimension's stand Y level; current Y level is " + y));

        BlockPos targetPos = new BlockPos(pos.getX(), y, pos.getZ());
        sendMessage(new StringTextComponent("The current destination pos is " + targetPos.getX() + ", " + targetPos.getY() + ", " + targetPos.getZ()));

        int tries = 0;
        sendMessage(new StringTextComponent("About to try to find a suitable location for the Aljan Portal Stand..."));

        while (destinationWorld.getBlockState(targetPos).equals(Blocks.CAVE_AIR.defaultBlockState()) && !destinationWorld.getBlockState(targetPos).is(BMBlockTags.ALJAN_TELEPORTER_REPLACEABLES) && tries < 250) {
            targetPos = targetPos.above(1);
            tries++;
            sendMessage(entity, new StringTextComponent("Attempt " + tries + ": Could not find a suitable spot for the Aljan Portal Stand"));
        }

        while (destinationWorld.getBlockState(targetPos.below()).getMaterial() == Material.AIR || destinationWorld.getBlockState(targetPos.below()).is(BMBlockTags.ALJAN_TELEPORTER_REPLACEABLES)) {
            sendMessage(entity, new StringTextComponent("Moving location below since it's in the air (Y: " + targetPos.getY() + ")"));
            if (targetPos.getY() <= 0) {
                targetPos = targetPos.above(255);
                sendMessage(new StringTextComponent("Resetting Y to " + targetPos.getY() + " since it looked for air below Y: 0"));
            }
            targetPos = targetPos.below(1);
        }
        return targetPos;
    }

    public static int placePortalStand(BlockPos targetPos, ServerWorld destinationWorld, boolean insideTheAljan, boolean placeWithJantical) {
        if (insideTheAljan) {
            boolean placeStand = true;

            for (BlockPos checkPos : BlockPos.betweenClosed(targetPos.below(10).west(10).north(10), targetPos.above(10).east(10).south(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof AljanPortalStandBlock) {
                    placeStand = false;
                    break;
                }
            }

            if (placeStand) {
                if (placeWithJantical) {
                    sendMessage(new StringTextComponent("Placing the Aljan Portal Stand (with a Jantical) at X: " + targetPos.getX() + ", Y: " + targetPos.getY() + ", Z: " + targetPos.getZ()));
                    destinationWorld.setBlockAndUpdate(targetPos, BMBlocks.ALJAN_PORTAL_STAND.get().defaultBlockState().setValue(BMBlockStateProperties.JANTICAL, true));
                } else {
                    sendMessage(new StringTextComponent("Placing the Aljan Portal Stand (without a Jantical) at X: " + targetPos.getX() + ", Y: " + targetPos.getY() + ", Z: " + targetPos.getZ()));
                    destinationWorld.setBlockAndUpdate(targetPos, BMBlocks.ALJAN_PORTAL_STAND.get().defaultBlockState());
                }

                // Places a Polished Sleepingstone below the stand when above water or sleepishwater.
                if (destinationWorld.getFluidState(targetPos.below()).is(BMFluidTags.ALJAN_CARVER_REPLACEABLES)) {
                    sendMessage(new StringTextComponent("Placing a Polished Sleepingstone at X: " + targetPos.getX() + ", Y: " + (targetPos.getY() - 1) + ", Z: " + targetPos.getZ()));
                    destinationWorld.setBlockAndUpdate(targetPos.below(), BMBlocks.POLISHED_SLEEPINGSTONE.get().defaultBlockState());
                }
                return 1;
            } else sendMessage(new StringTextComponent("No need to place another Aljan Portal Stand."));
        }
        return 0;
    }

    private static void sendMessage(IFormattableTextComponent component) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null && COMMON_CONFIGS.logAljanTeleporterDebugging.get()) player.sendMessage(component.withStyle(TextFormatting.GRAY).withStyle(TextFormatting.ITALIC), Util.NIL_UUID);
    }

    private static void sendMessage(Entity entity, IFormattableTextComponent component) {
        if (entity instanceof ServerPlayerEntity && COMMON_CONFIGS.logAljanTeleporterDebugging.get()) {
            ((ServerPlayerEntity) entity).sendMessage(component.withStyle(TextFormatting.GRAY), ChatType.GAME_INFO, Util.NIL_UUID);
        }
    }
}
