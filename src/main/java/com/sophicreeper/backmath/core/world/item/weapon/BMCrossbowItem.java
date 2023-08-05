package com.sophicreeper.backmath.core.world.item.weapon;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;

public class BMCrossbowItem extends CrossbowItem {
    public BMCrossbowItem() {
        super(new Properties().durability(520));
    }

    public boolean useOnRelease(ItemStack stack) {
        return stack.getItem() == AxolotlTest.ANGELIC_CROSSBOW.get() || stack.getItem() == AxolotlTest.DEVIL_CROSSBOW.get();
    }
}
