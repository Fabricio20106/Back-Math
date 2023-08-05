package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class CharjanCoalBlockItem extends BlockItem {
    public CharjanCoalBlockItem(Properties properties) {
        super(BMBlocks.CHARJAN_COAL_BLOCK.get(), properties);
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return 4800;
    }
}
