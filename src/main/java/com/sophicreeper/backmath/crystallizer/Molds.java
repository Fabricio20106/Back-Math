package com.sophicreeper.backmath.crystallizer;

import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

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

    @Override
    @Nonnull
    public String getSerializedName() {
        return this.name;
    }
}
