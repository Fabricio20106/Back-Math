package com.sophicreeper.backmath.core.world.level.block;

public class CrystallizerOldBlock /*extends HorizontalBlock*/ {
    //public static final DirectionProperty facing = HorizontalBlock.HORIZONTAL_FACING;

    /*public CrystallizerBlockOld(Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(facing, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(facing, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack heldMainhand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack heldOffhand = player.getHeldItem(Hand.OFF_HAND);
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.milklary_bucket.get() && heldOffhand.getItem() == AxolotlTest.singularity_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.milkllarity.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(1);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.mid_term_ingot.get() && heldOffhand.getItem() == AxolotlTest.singularity_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.mid_term.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(1);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.mid_term.get() && heldOffhand.getItem() == AxolotlTest.ingot_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.mid_term_ingot.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(1);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.milklary_bucket.get() && heldOffhand.getItem() == AxolotlTest.ingot_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.milkllary_ingot.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(1);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.milkllarity.get() && heldOffhand.getItem() == AxolotlTest.ingot_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.milkllary_ingot.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(1);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.devil_nugget.get() && heldMainhand.getCount() == 9 && heldOffhand.getItem() == AxolotlTest.ingot_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.devil_ingot.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(9);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.angelic_nugget.get() && heldMainhand.getCount() == 9 && heldOffhand.getItem() == AxolotlTest.ingot_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.angelic_ingot.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(9);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.mid_term_nugget.get() && heldMainhand.getCount() == 9 && heldOffhand.getItem() == AxolotlTest.ingot_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.mid_term_ingot.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(9);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.christian_mid_term_nugget.get() && heldMainhand.getCount() == 9 && heldOffhand.getItem() == AxolotlTest.ingot_mold.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.christian_mid_term_ingot.get()));
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(9);
        }
        if (!worldIn.isRemote && heldMainhand.getItem() == AxolotlTest.aljame.get() && heldMainhand.getCount() == 4 && heldOffhand.getItem() == Items.BUCKET) {
            player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.LIQUID_ALJAME_BUCKET.get()));
            worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
            heldMainhand.shrink(4);
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(facing);
    }*/
}
