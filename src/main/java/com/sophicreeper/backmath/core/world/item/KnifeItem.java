package com.sophicreeper.backmath.core.world.item;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraftforge.common.ToolType;

import java.util.Set;

public class KnifeItem extends ToolItem {
    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.GRASS, Blocks.TALL_GRASS, Blocks.FERN, Blocks.LARGE_FERN, Blocks.SEAGRASS, Blocks.TALL_SEAGRASS, Blocks.KELP, Blocks.KELP_PLANT, Blocks.CRIMSON_ROOTS, Blocks.WARPED_ROOTS, Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS, Blocks.NETHER_SPROUTS, Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS, Blocks.NETHER_WART, Blocks.SWEET_BERRY_BUSH, Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING);
    public static final ToolType KNIFE = ToolType.get("knife");

    public KnifeItem(float attackDamage, float attackSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, attackSpeed, tier, EFFECTIVE_ON, properties.addToolType(KNIFE, tier.getHarvestLevel()));
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        if (container.attemptDamageItem(1, random, null)) {
            return ItemStack.EMPTY;
        } else {
            return container;
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
