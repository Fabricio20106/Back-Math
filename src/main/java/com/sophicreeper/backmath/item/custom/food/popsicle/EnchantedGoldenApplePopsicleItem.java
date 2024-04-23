package com.sophicreeper.backmath.item.custom.food.popsicle;

import com.sophicreeper.backmath.item.tab.SophiesCursedFoods;
import net.minecraft.item.*;

public class EnchantedGoldenApplePopsicleItem extends Item {
    public EnchantedGoldenApplePopsicleItem(Food food) {
        super(new Properties().tab(SophiesCursedFoods.TAB).rarity(Rarity.EPIC).food(food));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
