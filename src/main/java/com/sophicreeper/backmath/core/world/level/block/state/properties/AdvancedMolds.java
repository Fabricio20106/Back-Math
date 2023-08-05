package com.sophicreeper.backmath.core.world.level.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum AdvancedMolds implements StringRepresentable {
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

    public String getSerializedName() {
        return this.name;
    }
}
