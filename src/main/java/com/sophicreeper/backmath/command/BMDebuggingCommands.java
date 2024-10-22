package com.sophicreeper.backmath.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.entity.custom.WandererSophieEntity;
import com.sophicreeper.backmath.misc.BMRegistries;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import com.sophicreeper.backmath.world.dimension.TheAljanTeleporter;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;

import java.util.Collection;

public class BMDebuggingCommands {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        APSPlacementCommand.register(dispatcher);
        SpawnWandererSophiesCommand.register(dispatcher);
        SpawnQLPs.register(dispatcher);
    }

    // For testing Aljan portal stand placement when teleporting. Separation of the teleportation logic was made for this reason.
    // ~isa 21-10-24
    public static class APSPlacementCommand {
        public static void register(CommandDispatcher<CommandSource> dispatcher) {
            dispatcher.register(Commands.literal("backmath-aps_placement").requires(source -> source.hasPermission(2))
                    .then(Commands.argument("pos", BlockPosArgument.blockPos())
                            .executes(context -> placeStand(context, true, BMConfigs.COMMON_CONFIGS.safeAljan.get()))
                            .then(Commands.argument("inside_aljan", BoolArgumentType.bool())
                                    .executes(context -> placeStand(context, BoolArgumentType.getBool(context, "inside_aljan"), BMConfigs.COMMON_CONFIGS.safeAljan.get()))
                                    .then(Commands.argument("place_with_jantical", BoolArgumentType.bool())
                                            .executes(context -> placeStand(context, BoolArgumentType.getBool(context, "inside_aljan"), BoolArgumentType.getBool(context, "place_with_jantical")))))));
        }

        private static int placeStand(CommandContext<CommandSource> context, boolean insideAljan, boolean placeWithJantical) throws CommandSyntaxException {
            ServerWorld world = context.getSource().getLevel();
            BlockPos pos = TheAljanTeleporter.getTargetPosition(BlockPosArgument.getLoadedBlockPos(context, "pos"), context.getSource().getEntity(), world);
            int result = TheAljanTeleporter.placePortalStand(pos, world, insideAljan, placeWithJantical);
            if (result >= 1) context.getSource().sendSuccess(new StringTextComponent("Successfully placed an Aljan Portal Stand on " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ()), false);
            else context.getSource().sendFailure(new StringTextComponent("Did not place an Aljan Portal Stand"));
            return result;
        }
    }

    public static class SpawnWandererSophiesCommand {
        public static void register(CommandDispatcher<CommandSource> dispatcher) {
            dispatcher.register(Commands.literal("backmath-spawn_wanderer_sophies").requires(source -> source.hasPermission(2))
                    .then(Commands.argument("only_naturally_spawned", BoolArgumentType.bool())
                            .executes(context -> spawnWandererSophies(context.getSource(), BoolArgumentType.getBool(context, "only_naturally_spawned")))));
        }

        private static int spawnWandererSophies(CommandSource source, boolean onlyNaturallySpawned) {
            Collection<WandererSophieVariant> variants = BMRegistries.WANDERER_SOPHIE_VARIANT.getValues();
            BlockPos pos = new BlockPos(source.getPosition());
            int spawnedVariants = 0;
            for (WandererSophieVariant variant : variants) {
                if (variant.spawnsNaturally() || !onlyNaturallySpawned) {
                    ServerWorld world = source.getLevel();

                    WandererSophieEntity wandererSophie = new WandererSophieEntity(world);
                    wandererSophie.setPos(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
                    wandererSophie.setVariant(variant);
                    wandererSophie.setNoAi(true);
                    wandererSophie.setPersistenceRequired();
                    wandererSophie.setSilent(true);
                    wandererSophie.setCustomName(new StringTextComponent(variant.getAssetID().toString()));
                    wandererSophie.setCustomNameVisible(true);
                    wandererSophie.setCapeVisibility(false);
                    if (world.addFreshEntity(wandererSophie)) ++spawnedVariants;
                    else source.sendFailure(new StringTextComponent("Failed to spawn variant '" + variant.getAssetID() + "'"));

                    world.setBlockAndUpdate(pos, Blocks.SEA_LANTERN.defaultBlockState());
                    pos = pos.west(2);
                }
            }
            if (spawnedVariants > 0) source.sendSuccess(new StringTextComponent("Spawned " + spawnedVariants + " Wanderer Sophie variants"), false);
            else source.sendFailure(new StringTextComponent("No Wanderer Sophie variants were spawned"));
            return 1;
        }
    }

    public static class SpawnQLPs {
        public static void register(CommandDispatcher<CommandSource> dispatcher) {
            dispatcher.register(Commands.literal("backmath-spawn_qlps").requires(source -> source.hasPermission(2))
                    .executes(context -> spawnQLPs(context.getSource())));
        }

        private static int spawnQLPs(CommandSource source) {
            Collection<QueenLucyPetVariant> variants = BMRegistries.QUEEN_LUCY_PET_VARIANT.getValues();
            BlockPos pos = new BlockPos(source.getPosition());
            int spawnedVariants = 0;
            for (QueenLucyPetVariant variant : variants) {
                ServerWorld world = source.getLevel();

                QueenLucyPetEntity queenLucyPet = new QueenLucyPetEntity(BMEntities.QUEEN_LUCY_PET.get(), world);
                queenLucyPet.setPos(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
                queenLucyPet.setVariant(variant);
                queenLucyPet.setNoAi(true);
                queenLucyPet.setPersistenceRequired();
                queenLucyPet.setSilent(true);
                queenLucyPet.setCustomName(new StringTextComponent(variant.getAssetID().toString()));
                queenLucyPet.setCustomNameVisible(true);
                if (world.addFreshEntity(queenLucyPet)) ++spawnedVariants;
                else source.sendFailure(new StringTextComponent("Failed to spawn variant '" + variant.getAssetID() + "'"));

                world.setBlockAndUpdate(pos, Blocks.SEA_LANTERN.defaultBlockState());
                pos = pos.west(2);
            }
            if (spawnedVariants > 0) source.sendSuccess(new StringTextComponent("Spawned " + spawnedVariants + " QLP variants"), false);
            else source.sendFailure(new StringTextComponent("No QLP variants were spawned"));
            return 1;
        }
    }
}
