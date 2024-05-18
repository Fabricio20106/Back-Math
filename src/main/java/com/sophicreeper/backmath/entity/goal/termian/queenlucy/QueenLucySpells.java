package com.sophicreeper.backmath.entity.goal.termian.queenlucy;

import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;

public enum QueenLucySpells {
    NONE("none"),
    SUMMON_WARRIOR_SOPHIES("summon_warrior_sophies"),
    SUMMON_ARCHER_INSOMNIA_SOPHIES("summon_archer_insomnia_sophies"),
    SUMMON_INSOMNIA_SOPHIES("summon_insomnia_sophies"),
    EQUIP_DIAMOND_CHESTPLATE_AND_HEAL("equip_diamond_chestplate_and_heal");

    private final String name;

    QueenLucySpells(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean isValidSpell(String name) {
        return name.equals("none") || name.equals("summon_warrior_sophies") || name.equals("summon_archer_insomnia_sophies") || name.equals("summon_insomnia_sophies") || name.equals("equip_diamond_chestplate_and_heal");
    }

    public static QueenLucySpells setFromString(String spellName) {
        switch (spellName) {
            case "summon_warrior_sophies":
                return QueenLucySpells.SUMMON_WARRIOR_SOPHIES;
            case "summon_insomnia_sophies":
                return QueenLucySpells.SUMMON_INSOMNIA_SOPHIES;
            case "summon_archer_insomnia_sophies":
                return QueenLucySpells.SUMMON_ARCHER_INSOMNIA_SOPHIES;
            case "equip_diamond_chestplate_and_heal":
                return QueenLucySpells.EQUIP_DIAMOND_CHESTPLATE_AND_HEAL;
            case "none":
                return QueenLucySpells.NONE;
            default:
                LogManager.getLogger().error(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.queen_lucy_spells.unknown_spell", spellName)).getString());
                return QueenLucySpells.NONE;
        }
    }
}
