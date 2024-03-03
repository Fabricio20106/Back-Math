package com.sophicreeper.backmath.block.custom.properties;

import net.minecraft.util.IStringSerializable;

public enum AdvancedMolds implements IStringSerializable {
    EMPTY("empty"),
    SINGULARITY("singularity"),
    CRYSTALLIZED("crystallized"),
    INGOT("ingot"),
    MOLD("mold"),
    CRYSTALLINE_EMPTY("crystalline_empty"),
    CRYSTALLINE_GEM("crystalline_gem"),
    ROD("rod");

    private final String name;

    AdvancedMolds(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getString() {
        return this.name;
    }

    public static AdvancedMolds getMoldFromString(String mold) {
        switch (mold) {
            case "singularity":
                return SINGULARITY;
            case "crystallized":
                return CRYSTALLIZED;
            case "ingot":
                return INGOT;
            case "mold":
                return MOLD;
            case "rod":
                return ROD;
            case "crystalline_empty":
                return CRYSTALLINE_EMPTY;
            case "crystalline_gem":
                return CRYSTALLINE_GEM;
            default:
                return EMPTY;
        }
    }
}
