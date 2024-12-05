package com.sophicreeper.backmath.blockentity;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.blockentity.custom.HeadBlockEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMBlockEntities {
    public static final DeferredRegister<TileEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, BackMath.MOD_ID);

    public static final RegistryObject<TileEntityType<HeadBlockEntity>> HEAD = BLOCK_ENTITIES.register("head", () -> TileEntityType.Builder.of(HeadBlockEntity::new,
            BMBlocks.ANGRY_SOPHIE_HEAD.get(), BMBlocks.ANGRY_SOPHIE_WALL_HEAD.get(), BMBlocks.INSOMNIA_SOPHIE_HEAD.get(), BMBlocks.INSOMNIA_SOPHIE_WALL_HEAD.get(),
            BMBlocks.QUEEN_LUCY_HEAD.get(), BMBlocks.QUEEN_LUCY_WALL_HEAD.get(), BMBlocks.ZOMBIE_FABRICIO_HEAD.get(), BMBlocks.ZOMBIE_FABRICIO_WALL_HEAD.get())
            .build(null));
}
