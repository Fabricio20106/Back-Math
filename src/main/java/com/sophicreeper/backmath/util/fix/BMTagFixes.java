package com.sophicreeper.backmath.util.fix;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

public class BMTagFixes {
    // Updates the old "SpellTicks" tag of Queen Lucies to the new "lucy_spells.spell_cooldown_ticks" tag.
    public static int fixSpellTicksTag(CompoundNBT tag) {
        CompoundNBT lucySpells = tag.getCompound("lucy_spells");
        if (!lucySpells.contains("spell_cooldown_ticks") || tag.contains("SpellTicks")) {
            lucySpells.putInt("spell_cooldown_ticks", tag.getInt("SpellTicks"));
            tag.remove("SpellTicks");
        }
        return lucySpells.getInt("spell_cooldown_ticks");
    }

    // Updates the old "Inventory" tag of Archer Lucias to the new "inventory" tag.
    public static ListNBT fixInventoryTag(CompoundNBT tag) {
        if (tag.contains("Inventory")) {
            tag.put("inventory", tag.getList("Inventory", 10));
            tag.remove("Inventory");
        }
        return tag.getList("inventory", 10);
    }

    // Updates the old "CanBreakDoors" tag of Insomnia Zombies and Zombie Fabricios to the new "can_break_doors" tag.
    public static boolean fixCanBreakDoorsTag(CompoundNBT tag) {
        if (tag.contains("CanBreakDoors")) {
            tag.putBoolean("can_break_doors", tag.getBoolean("CanBreakDoors"));
            tag.remove("CanBreakDoors");
        }
        return tag.getBoolean("can_break_doors");
    }

    // Updates the old "Size" tag of Amaracamelers to the new "size" tag.
    public static int fixSizeTag(CompoundNBT tag) {
        if (tag.contains("Size")) {
            tag.putInt("size", tag.getInt("Size"));
            tag.remove("Size");
        }
        return tag.getInt("size");
    }

    // Updates the old "wasOnGround" tag of Amaracamelers to the new "was_on_ground" tag.t
    public static boolean fixWasOnGroundTag(CompoundNBT tag) {
        if (tag.contains("wasOnGround")) {
            tag.putBoolean("was_on_ground", tag.getBoolean("wasOnGround"));
            tag.remove("wasOnGround");
        }
        return tag.getBoolean("was_on_ground");
    }
}
