package com.sophicreeper.backmath.entity.goal.termian.queenlucy;

import com.sophicreeper.backmath.entity.custom.QueenLucyEntity;
import com.sophicreeper.backmath.util.BMResourceLocations;
import com.sophicreeper.backmath.util.EquipmentTableUtils;

public class EquipArmorAndHealGoal extends CastSpellGoal {
    private final QueenLucyEntity queenLucy;

    public EquipArmorAndHealGoal(QueenLucyEntity queenLucy) {
        super(queenLucy);
        this.queenLucy = queenLucy;
    }

    @Override
    public void castSpell() {
        EquipmentTableUtils.equipWithGear(BMResourceLocations.QUEEN_LUCY_FROM_EQUIP_SPELL_EQUIPMENT, this.queenLucy);
        this.queenLucy.heal(25);
    }

    @Override
    public int castingTime() {
        return 100;
    }

    @Override
    public int castingInterval() {
        return 340;
    }

    @Override
    public QueenLucySpells spellType() {
        return QueenLucySpells.EQUIP_DIAMOND_CHESTPLATE_AND_HEAL;
    }
}
