package com.sophicreeper.backmath.item.behavior;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.OptionalInt;

public class ItemBehavior extends ForgeRegistryEntry<ItemBehavior> {
    public final BehaviorEffects effects;
    private int durabilityBarColor;

    public ItemBehavior(BehaviorEffects effects) {
        this.effects = effects;
    }

    public ItemBehavior durabilityBarColor(int color) {
        this.durabilityBarColor = color;
        return this;
    }

    public OptionalInt getDurabilityBarColor() {
        return OptionalInt.of(this.durabilityBarColor);
    }

    public interface BehaviorEffects {
        void run(ItemStack stack, LivingEntity livEntity, World world);
    }
}
