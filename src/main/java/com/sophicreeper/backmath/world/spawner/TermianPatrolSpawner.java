package com.sophicreeper.backmath.world.spawner;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.ISpecialSpawner;
import net.minecraft.world.spawner.WorldEntitySpawner;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public class TermianPatrolSpawner implements ISpecialSpawner {
    private int nextTick;

    @Override
    public int tick(ServerWorld world, boolean spawnEnemies, boolean spawnFriendlies) {
        if (!spawnEnemies) {
            return 0;
        } else if (!world.getGameRules().getBoolean(GameRules.RULE_DO_PATROL_SPAWNING)) {
            return 0;
        } else {
            Random rand = world.random;
            --this.nextTick;
            if (this.nextTick > 0) {
                return 0;
            } else {
                this.nextTick += 12000 + rand.nextInt(1200);
                long day = world.getDayTime() / 24000L;
                if (day >= 5L && world.isDay()) {
                    if (rand.nextInt(5) != 0) {
                        return 0;
                    } else {
                        int players = world.players().size();
                        if (players < 1) {
                            return 0;
                        } else {
                            PlayerEntity player = world.players().get(rand.nextInt(players));
                            if (player.isSpectator()) {
                                return 0;
                            } else if (world.isCloseToVillage(player.blockPosition(), 2)) {
                                return 0;
                            } else {
                                int x = (24 + rand.nextInt(24)) * (rand.nextBoolean() ? -1 : 1);
                                int z = (24 + rand.nextInt(24)) * (rand.nextBoolean() ? -1 : 1);
                                BlockPos.Mutable mutablePos = player.blockPosition().mutable().move(x, 0, z);
                                if (!world.hasChunksAt(mutablePos.getX() - 10, mutablePos.getY() - 10, mutablePos.getZ() - 10, mutablePos.getX() + 10, mutablePos.getY() + 10, mutablePos.getZ() + 10)) {
                                    return 0;
                                } else {
                                    Biome biome = world.getBiome(mutablePos);
                                    Biome.Category biomeCategory = biome.getBiomeCategory();
                                    if (biomeCategory == Biome.Category.MUSHROOM) {
                                        return 0;
                                    } else {
                                        int i1 = 0;
                                        int j1 = (int) Math.ceil(world.getCurrentDifficultyAt(mutablePos).getEffectiveDifficulty()) + 1;

                                        for(int k1 = 0; k1 < j1; ++k1) {
                                            ++i1;
                                            mutablePos.setY(world.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, mutablePos).getY());
                                            if (k1 == 0) {
                                                if (!this.spawnPatrolMember(world, mutablePos, rand, true)) {
                                                    break;
                                                }
                                            } else {
                                                this.spawnPatrolMember(world, mutablePos, rand, false);
                                            }

                                            mutablePos.setX(mutablePos.getX() + rand.nextInt(5) - rand.nextInt(5));
                                            mutablePos.setZ(mutablePos.getZ() + rand.nextInt(5) - rand.nextInt(5));
                                        }

                                        return i1;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    return 0;
                }
            }
        }
    }

    private boolean spawnPatrolMember(ServerWorld world, BlockPos pos, Random rand, boolean leader) {
        BlockState state = world.getBlockState(pos);
        if (!WorldEntitySpawner.isValidEmptySpawnBlock(world, pos, state, state.getFluidState(), BMEntities.WANDERER_SOPHIE.get())) {
            return false;
        } else if (!TermianPatrollerEntity.checkTermianPatrolSpawnRules(BMEntities.WANDERER_SOPHIE.get(), world, SpawnReason.PATROL, pos, rand)) {
            return false;
        } else {
            TermianPatrollerEntity termianPatroller = BMEntities.WANDERER_SOPHIE.get().create(world);
            if (termianPatroller != null) {
                if (leader) {
                    termianPatroller.setPatrolLeader(true);
                    termianPatroller.findPatrolTarget();
                }

                termianPatroller.setPos(pos.getX(), pos.getY(), pos.getZ());
                if (ForgeHooks.canEntitySpawn(termianPatroller, world, pos.getX(), pos.getY(), pos.getZ(), null, SpawnReason.PATROL) == -1) return false;
                termianPatroller.finalizeSpawn(world, world.getCurrentDifficultyAt(pos), SpawnReason.PATROL, null, null);
                world.addFreshEntityWithPassengers(termianPatroller);
                return true;
            } else {
                return false;
            }
        }
    }
}
