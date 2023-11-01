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
}
