package com.sophicreeper.backmath.crystallizer.advanced;

import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public enum AdvancedMolds implements IStringSerializable {
    EMPTY("empty"),
    SINGULARITY("singularity"),
    CRYSTALLIZED("crystallized"),
    INGOT("ingot"),
    MOLD("mold"),
    ROD("rod"),
    CRYSTALLINE_EMPTY("crystalline_empty"),
    CRYSTALLINE_GEM("crystalline_gem");

    private final String name;

    AdvancedMolds(String name) {
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
