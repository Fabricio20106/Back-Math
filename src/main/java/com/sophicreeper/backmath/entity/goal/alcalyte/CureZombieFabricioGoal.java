package com.sophicreeper.backmath.entity.goal.alcalyte;

import com.sophicreeper.backmath.entity.custom.alcalyte.CollectorAlcalyteEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;

public class CureZombieFabricioGoal extends MeleeAttackGoal {
    private final CollectorAlcalyteEntity collector;

    public CureZombieFabricioGoal(CollectorAlcalyteEntity collector, double speed) {
        super(collector, speed, false);
        this.collector = collector;
    }

    @Override
    public boolean canUse() {
        return !this.hasItemInInventory(new ItemStack(AxolotlTest.JANTIQUIFIED_ALJAME.get())).isEmpty() &&
                !this.hasItemInInventory(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), Potions.WEAKNESS)).isEmpty();
    }

    public ItemStack hasItemInInventory(ItemStack targetStack) {
        for (int i = 0; i < this.collector.getInventory().getContainerSize(); ++i) {
            ItemStack stack = this.collector.getInventory().getItem(i);
            if (stack.equals(targetStack, true)) return stack;
        }
        return ItemStack.EMPTY;
    }
}
