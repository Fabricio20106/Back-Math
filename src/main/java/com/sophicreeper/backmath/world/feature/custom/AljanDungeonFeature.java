package com.sophicreeper.backmath.world.feature.custom;

import com.mojang.serialization.Codec;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.util.BMResourceLocations;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructurePiece;

import java.util.Random;

public class AljanDungeonFeature extends Feature<NoFeatureConfig> {
    private static final EntityType<?>[] SPAWNER_ENTITIES = new EntityType[] {BMEntities.ALJAMIC_BONES.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.INSOMNIA_ZOMBIE.get()};
    private static final BlockState CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();

    public AljanDungeonFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int j = rand.nextInt(2) + 2;
        int k = -j - 1;
        int l = j + 1;
        int k1 = rand.nextInt(2) + 2;
        int l1 = -k1 - 1;
        int i2 = k1 + 1;
        int j2 = 0;

        for(int k2 = k; k2 <= l; ++k2) {
            for(int l2 = -1; l2 <= 4; ++l2) {
                for(int i3 = l1; i3 <= i2; ++i3) {
                    BlockPos pos1 = pos.add(k2, l2, i3);
                    Material material = reader.getBlockState(pos1).getMaterial();
                    boolean flag = material.isSolid();
                    if (l2 == -1 && !flag) {
                        return false;
                    }

                    if (l2 == 4 && !flag) {
                        return false;
                    }

                    if ((k2 == k || k2 == l || i3 == l1 || i3 == i2) && l2 == 0 && reader.isAirBlock(pos1) && reader.isAirBlock(pos1.up())) {
                        ++j2;
                    }
                }
            }
        }

        if (j2 >= 1 && j2 <= 5) {
            for(int k3 = k; k3 <= l; ++k3) {
                for(int i4 = 3; i4 >= -1; --i4) {
                    for(int k4 = l1; k4 <= i2; ++k4) {
                        BlockPos pos1 = pos.add(k3, i4, k4);
                        BlockState state = reader.getBlockState(pos1);
                        if (k3 != k && i4 != -1 && k4 != l1 && k3 != l && i4 != 4 && k4 != i2) {
                            if (!state.isIn(Blocks.CHEST) && !state.isIn(Blocks.SPAWNER)) {
                                reader.setBlockState(pos1, CAVE_AIR, 2);
                            }
                        } else if (pos1.getY() >= 0 && !reader.getBlockState(pos1.down()).getMaterial().isSolid()) {
                            reader.setBlockState(pos1, CAVE_AIR, 2);
                        } else if (state.getMaterial().isSolid() && !state.isIn(Blocks.CHEST)) {
                            if (i4 == -1 && rand.nextInt(4) != 0) {
                                reader.setBlockState(pos1, BMBlocks.COBBLED_ALJANSTONE.get().getDefaultState(), 2);
                            } else {
                                reader.setBlockState(pos1, BMBlocks.ALJANSTONE_BRICKS.get().getDefaultState(), 2);
                            }
                        }
                    }
                }
            }

            for(int l3 = 0; l3 < 2; ++l3) {
                for(int j4 = 0; j4 < 3; ++j4) {
                    int l4 = pos.getX() + rand.nextInt(j * 2 + 1) - j;
                    int i5 = pos.getY();
                    int j5 = pos.getZ() + rand.nextInt(k1 * 2 + 1) - k1;
                    BlockPos pos1 = new BlockPos(l4, i5, j5);
                    if (reader.isAirBlock(pos1)) {
                        int j3 = 0;

                        for(Direction direction : Direction.Plane.HORIZONTAL) {
                            if (reader.getBlockState(pos1.offset(direction)).getMaterial().isSolid()) {
                                ++j3;
                            }
                        }

                        if (j3 == 1) {
                            reader.setBlockState(pos1, StructurePiece.correctFacing(reader, pos1, Blocks.CHEST.getDefaultState()), 2);
                            LockableLootTileEntity.setLootTable(reader, rand, pos1, BMResourceLocations.ALJAN_DUNGEON_LOOT);
                            break;
                        }
                    }
                }
            }

            reader.setBlockState(pos, Blocks.SPAWNER.getDefaultState(), 2);
            TileEntity spawner = reader.getTileEntity(pos);
            if (spawner instanceof MobSpawnerTileEntity) {
                ((MobSpawnerTileEntity) spawner).getSpawnerBaseLogic().setEntityType(SPAWNER_ENTITIES[rand.nextInt(SPAWNER_ENTITIES.length)]);
            } else {
                BackMath.LOGGER.error("Back Math: Failed to fetch Spawner block entity at ({}, {}, {}).", pos.getX(), pos.getY(), pos.getZ());
            }

            return true;
        } else {
            return false;
        }
    }
}
