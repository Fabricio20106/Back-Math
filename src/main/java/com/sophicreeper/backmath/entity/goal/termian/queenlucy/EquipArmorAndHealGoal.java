package com.sophicreeper.backmath.entity.goal.termian.queenlucy;

import com.sophicreeper.backmath.entity.custom.QueenLucy;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class EquipArmorAndHealGoal extends CastSpellGoal {
    private final QueenLucy queenLucy;

    public EquipArmorAndHealGoal(QueenLucy queenLucy) {
        super(queenLucy);
        this.queenLucy = queenLucy;
    }

    @Override
    protected void castSpell() {
        this.queenLucy.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
        this.queenLucy.heal(25);
    }

    @Override
    protected int getCastingTime() {
        return 100;
    }

    @Override
    protected int getCastingInterval() {
        return 340;
    }

    @Override
    protected QueenLucySpells getSpellType() {
        return QueenLucySpells.EQUIP_DIAMOND_CHESTPLATE_AND_HEAL;
    }
}
