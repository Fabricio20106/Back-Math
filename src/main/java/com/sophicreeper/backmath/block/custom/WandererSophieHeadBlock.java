package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.blockentity.custom.BMHeadType;
import com.sophicreeper.backmath.blockentity.custom.WandererSophieHeadBlockEntity;
import com.sophicreeper.backmath.util.TagTypes;
import com.sophicreeper.backmath.variant.wansophie.BMWandererSophieVariants;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WandererSophieHeadBlock extends HeadBlock {
    public WandererSophieHeadBlock(Properties properties) {
        super(BMHeadType.WANDERER_SOPHIE, properties);
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity livEntity, ItemStack stack) {
        super.setPlacedBy(world, pos, state, livEntity, stack);
        TileEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof WandererSophieHeadBlockEntity) {
            WandererSophieHeadBlockEntity headBlock = (WandererSophieHeadBlockEntity) blockEntity;
            if (stack.getTag() != null && stack.getTag().contains("variant", TagTypes.STRING)) {
                headBlock.setVariant(stack.getTag().getString("variant"));
            } else {
                headBlock.setVariant(BMWandererSophieVariants.YELLOW_AXOLOTL.get());
            }
        }
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        TileEntity blockEntity = world.getBlockEntity(pos);
        ItemStack stack = super.getPickBlock(state, target, world, pos, player);
        if (blockEntity instanceof WandererSophieHeadBlockEntity) {
            WandererSophieHeadBlockEntity headBlock = (WandererSophieHeadBlockEntity) blockEntity;
            if (headBlock.getVariant() != null) stack.getOrCreateTag().putString("variant", headBlock.getVariant().getAssetID().toString());
        }
        return stack;
    }

    @Override
    @Nullable
    public TileEntity newBlockEntity(IBlockReader world) {
        return new WandererSophieHeadBlockEntity();
    }
}
