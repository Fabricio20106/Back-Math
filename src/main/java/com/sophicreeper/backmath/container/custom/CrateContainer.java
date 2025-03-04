package com.sophicreeper.backmath.container.custom;

import com.sophicreeper.backmath.container.BMContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ShulkerBoxSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class CrateContainer extends Container {
    private final IInventory container;

    public CrateContainer(int containerID, PlayerInventory playerInventory) {
        this(containerID, playerInventory, new Inventory(18));
    }

    public CrateContainer(int containerID, PlayerInventory playerInventory, IInventory inventory) {
        super(BMContainers.CRATE.get(), containerID);
        checkContainerSize(inventory, 18);
        this.container = inventory;
        inventory.startOpen(playerInventory.player);
        int i1 = (2 - 4) * 18;

        for (int y = 0; y < 2; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlot(new ShulkerBoxSlot(inventory, x + y * 9, 8 + x * 18, 18 + y * 18));
            }
        }

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 103 + y * 18 + i1));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 161 + i1));
        }
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return this.container.stillValid(player);
    }

    @Override
    public void removed(PlayerEntity player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    @Override
    @Nonnull
    public ItemStack quickMoveStack(PlayerEntity player, int slotID) {
        ItemStack movedStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotID);
        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            movedStack = slotStack.copy();
            if (slotID < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(slotStack, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotStack, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return movedStack;
    }
}
