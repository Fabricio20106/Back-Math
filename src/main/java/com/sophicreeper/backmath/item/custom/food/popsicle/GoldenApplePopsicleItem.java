package com.sophicreeper.backmath.item.custom.food.popsicle;

import com.sophicreeper.backmath.item.tab.SophiesCursedFoods;
import net.minecraft.item.*;

public class GoldenApplePopsicleItem extends Item {
    public GoldenApplePopsicleItem(Food food) {
        super(new Properties().tab(SophiesCursedFoods.TAB).rarity(Rarity.RARE).food(food));
    }
}
