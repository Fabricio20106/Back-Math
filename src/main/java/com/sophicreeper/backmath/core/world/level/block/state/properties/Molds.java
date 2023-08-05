package com.sophicreeper.backmath.core.world.level.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum Molds implements StringRepresentable {
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

    public String getSerializedName() {
        return this.name;
    }
}
