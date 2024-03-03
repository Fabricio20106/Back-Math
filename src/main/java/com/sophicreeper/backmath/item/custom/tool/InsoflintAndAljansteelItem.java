package com.sophicreeper.backmath.item.custom.tool;

import net.minecraft.block.*;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InsoflintAndAljansteelItem extends FlintAndSteelItem {
    public InsoflintAndAljansteelItem(Properties properties) {
        super(properties);
        DispenserBlock.registerDispenseBehavior(this, new OptionalDispenseBehavior() {
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                World world = source.getWorld();
                this.setSuccessful(true);
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                BlockPos pos = source.getBlockPos().offset(direction);
                BlockState state = world.getBlockState(pos);
                if (AbstractFireBlock.canLightBlock(world, pos, direction)) {
                    world.setBlockState(pos, AbstractFireBlock.getFireForPlacement(world, pos));
                } else if (CampfireBlock.canBeLit(state)) {
                    world.setBlockState(pos, state.with(BlockStateProperties.LIT, true));
                } else if (state.isFlammable(world, pos, source.getBlockState().get(DispenserBlock.FACING).getOpposite())) {
                    state.catchFire(world, pos, source.getBlockState().get(DispenserBlock.FACING).getOpposite(), null);
                    if (state.getBlock() instanceof TNTBlock) {
                        world.removeBlock(pos, false);
                    }
                } else {
                    this.setSuccessful(false);
                }

                if (this.isSuccessful() && stack.attemptDamageItem(1, world.rand, null)) {
                    stack.setCount(0);
                }

                return stack;
            }
        });
    }
}
