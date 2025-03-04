package com.sophicreeper.backmath.entity.goal.alcalyte;

import com.mojang.datafixers.util.Pair;
import com.sophicreeper.backmath.entity.custom.alcalyte.CollectorAlcalyteEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;

import javax.annotation.Nullable;
import java.util.function.Predicate;

/// why the f does the inventory duplicate weirdly whether they finish eating!?
/// <p>
///    - me after spending at least 2 hours on this
public class ConsumeItemGoal<T extends CollectorAlcalyteEntity> extends Goal {
    private Pair<ItemStack, Integer> inventoryPair = null;
    private final T collector;
    private final SoundEvent consumeSound;
    private final Predicate<? super T> whenToUse;

    public ConsumeItemGoal(T collector, @Nullable SoundEvent consumeSound, Predicate<? super T> whenToUse) {
        this.collector = collector;
        this.consumeSound = consumeSound;
        this.whenToUse = whenToUse;
    }

    @Override
    public boolean canUse() {
        return this.whenToUse.test(this.collector);
    }

    @Override
    public boolean canContinueToUse() {
        return this.collector.isUsingItem();
    }

    @Override
    public void start() {
        /*Pair<ItemStack, Integer> consumablePair = this.collector.findConsumableInInventory();
        Inventory inventory = this.collector.getInventory();
        if (consumablePair != null) {
            this.inventoryPair = consumablePair;
            inventory.setItem(consumablePair.getSecond(), this.collector.getItemInHand(Hand.MAIN_HAND));
            this.collector.setItemSlot(EquipmentSlotType.MAINHAND, consumablePair.getFirst());
            this.collector.startUsingItem(Hand.MAIN_HAND);
        }*/
    }

    @Override
    public void stop() {
        if (this.inventoryPair != null) {
            ItemStack handStack = this.collector.getItemInHand(Hand.MAIN_HAND);
            Inventory inventory = this.collector.getInventory();
            this.collector.setItemSlot(EquipmentSlotType.MAINHAND, inventory.getItem(this.inventoryPair.getSecond()));
            inventory.setItem(this.inventoryPair.getSecond(), handStack);
            if (this.consumeSound != null) {
                this.collector.playSound(this.consumeSound, 1, this.collector.getRandom().nextFloat() * 0.2F + 0.9F);
            }
        }
    }
}
