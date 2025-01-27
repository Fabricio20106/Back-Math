package com.sophicreeper.backmath.item.custom.food.drink;

import com.sophicreeper.backmath.item.behavior.FoodSettings;
import com.sophicreeper.backmath.item.behavior.ItemBehavior;
import com.sophicreeper.backmath.item.behavior.ItemBehaviorParameters;
import com.sophicreeper.backmath.item.custom.food.BMFoodItem;

import java.util.function.Supplier;

public class JuiceItem extends BMFoodItem {
    public JuiceItem(FoodSettings settings, Supplier<ItemBehavior> behavior, Properties properties) {
        super(settings, behavior, properties);
    }

    public JuiceItem(Properties properties) {
        super(ItemBehaviorParameters.BOTTLE_DRINK, properties);
    }
}
