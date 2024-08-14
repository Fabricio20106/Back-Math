package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.projectile.EyeOfEnderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nonnull;

public class JantiquifiedPearlDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    @Nonnull
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        BlockPos strongholdPos = source.getLevel().getChunkSource().getGenerator().findNearestMapFeature(source.getLevel(), Structure.STRONGHOLD, source.getPos(), 100, false);
        if (strongholdPos != null) {
            EyeOfEnderEntity enderEye = new EyeOfEnderEntity(source.getLevel(), pos.getX(), pos.getY(), pos.getZ());
            enderEye.setItem(new ItemStack(AxolotlTest.JANTIQUIFIED_PEARL.get()));
            enderEye.signalTo(strongholdPos);
            source.getLevel().addFreshEntity(enderEye);
            source.getLevel().playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (source.getLevel().random.nextFloat() * 0.4F + 0.8F));
            source.getLevel().levelEvent(null, Constants.WorldEvents.ENDEREYE_LAUNCH_SOUND, source.getPos(), 0);
            stack.shrink(1);
            setSuccess(true);
        }
        return stack;
    }
}
