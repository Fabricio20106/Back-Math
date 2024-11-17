package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;

public class TeaDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    @Nonnull
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        for (LivingEntity livEntity : source.getLevel().getEntitiesOfClass(LivingEntity.class, new AxisAlignedBB(pos), LivingEntity::isAlive)) {
            if (stack.getItem() instanceof ToolBehaviors) {
                ToolBehaviors behaviors = (ToolBehaviors) stack.getItem();
                if (!behaviors.getAppliedEffects().isEmpty()) {
                    for (EffectInstance instance : behaviors.getAppliedEffects()) livEntity.addEffect(instance);
                    setSuccess(true);
                    stack.shrink(1);
                    return stack;
                }
            }
        }
        return super.execute(source, stack);
    }
}
