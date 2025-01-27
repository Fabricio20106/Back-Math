package com.sophicreeper.backmath.item.behavior;

import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.UseAction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public class FoodSettings {
    public Supplier<Item> defaultRemainder = null;
    public int useDuration = 32;
    public UseAction animation = UseAction.DRINK;
    public SoundEvent consumeSound = SoundEvents.GENERIC_DRINK;
    public IDispenseItemBehavior dispenseBehavior = null;
    public final boolean isDrink;

    public FoodSettings(boolean drink) {
        this.isDrink = drink;
    }

    public FoodSettings() {
        this(false);
    }

    public FoodSettings defaultRemainder(Supplier<Item> remainderStack) {
        this.defaultRemainder = remainderStack;
        return this;
    }

    public FoodSettings useDuration(int ticks) {
        this.useDuration = ticks;
        return this;
    }

    public FoodSettings animation(UseAction animation) {
        this.animation = animation;
        return this;
    }

    public FoodSettings consumeSound(SoundEvent sound) {
        this.consumeSound = sound;
        return this;
    }

    public FoodSettings dispenseBehavior(IDispenseItemBehavior dispenseBehavior) {
        this.dispenseBehavior = dispenseBehavior;
        return this;
    }
}
