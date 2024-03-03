package com.sophicreeper.backmath.block.custom.properties;

import net.minecraft.util.IStringSerializable;

public enum Molds implements IStringSerializable {
    EMPTY("empty"),
    SINGULARITY("singularity"),
    CRYSTALLIZED("crystallized"),
    INGOT("ingot"),
    MOLD("mold"),
    ROD("rod");

    private final String name;

    Molds(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getString() {
        return this.name;
    }

    public static Molds getMoldFromString(String mold) {
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
            default:
                return EMPTY;
        }
    }
}
