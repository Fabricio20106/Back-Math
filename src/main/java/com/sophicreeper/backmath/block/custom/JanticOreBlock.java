package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.block.custom.variants.BMOreBlock;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.aljan.JanticleEntity;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.server.ServerWorld;

public class JanticOreBlock extends BMOreBlock {
    public JanticOreBlock(Properties properties) {
        super(3, 6, properties);
    }

    @Override
    public void spawnAfterBreak(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.spawnAfterBreak(state, world, pos, stack);
        if (world.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            JanticleEntity janticle = BMEntities.JANTICLE.get().create(world);
            janticle.moveTo((double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, 0, 0);
            world.addFreshEntity(janticle);
        }
    }
}
