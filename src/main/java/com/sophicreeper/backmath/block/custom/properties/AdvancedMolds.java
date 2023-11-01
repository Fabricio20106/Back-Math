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
}
