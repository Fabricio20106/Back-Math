package com.sophicreeper.backmath.blockentity;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.blockentity.custom.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMBlockEntities {
    public static final DeferredRegister<TileEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, BackMath.MOD_ID);

    public static final RegistryObject<TileEntityType<BMBarrelBlockEntity>> BM_BARREL = BLOCK_ENTITIES.register("bm_barrel", () -> TileEntityType.Builder.of(BMBarrelBlockEntity::new,
            BMBlocks.ALJANWOOD_BARREL.get(), BMBlocks.ALJANCAP_BARREL.get(), BMBlocks.INSOMNIAN_BARREL.get(), BMBlocks.AVONDALIC_WILLOW_BARREL.get()).build(null));
    public static final RegistryObject<TileEntityType<CrateBlockEntity>> CRATE = BLOCK_ENTITIES.register("crate", () -> TileEntityType.Builder.of(CrateBlockEntity::new, BMBlocks.CRATE.get()).build(null));
    public static final RegistryObject<TileEntityType<HeadBlockEntity>> HEAD = BLOCK_ENTITIES.register("head", () -> TileEntityType.Builder.of(HeadBlockEntity::new,
            BMBlocks.ANGRY_SOPHIE_HEAD.get(), BMBlocks.ANGRY_SOPHIE_WALL_HEAD.get(), BMBlocks.INSOMNIA_SOPHIE_HEAD.get(), BMBlocks.INSOMNIA_SOPHIE_WALL_HEAD.get(),
            BMBlocks.ALJAMIC_BONES_SKULL.get(), BMBlocks.ALJAMIC_BONES_WALL_SKULL.get(), BMBlocks.SLEEPISH_SKELETON_SKULL.get(), BMBlocks.SLEEPISH_SKELETON_WALL_SKULL.get(),
            BMBlocks.ZOMBIE_FABRICIO_HEAD.get(), BMBlocks.ZOMBIE_FABRICIO_WALL_HEAD.get()).build(null));
    public static final RegistryObject<TileEntityType<WandererSophieHeadBlockEntity>> WANDERER_SOPHIE_HEAD = BLOCK_ENTITIES.register("wanderer_sophie_head", () ->
            TileEntityType.Builder.of(WandererSophieHeadBlockEntity::new, BMBlocks.WANDERER_SOPHIE_HEAD.get(), BMBlocks.WANDERER_SOPHIE_WALL_HEAD.get()).build(null));
    public static final RegistryObject<TileEntityType<QueenLucyHeadBlockEntity>> QUEEN_LUCY_HEAD = BLOCK_ENTITIES.register("queen_lucy_head", () ->
            TileEntityType.Builder.of(QueenLucyHeadBlockEntity::new, BMBlocks.QUEEN_LUCY_HEAD.get(), BMBlocks.QUEEN_LUCY_WALL_HEAD.get()).build(null));
}
