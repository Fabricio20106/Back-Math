package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BMMaterials {
    public static final MaterialColor ALJAN = new MaterialColor(59, 0xD4EAEA);
    public static final MaterialColor INSOMNIAN_PLANKS = new MaterialColor(60, 0x85D7E7);

    public static final Material BAG = new Material.Builder(MaterialColor.COLOR_ORANGE).destroyOnPush().build();
    public static final Material HEAD = new Material.Builder(MaterialColor.NONE).notSolidBlocking().nonSolid().destroyOnPush().build();
    public static final Material ALJAN_ROCK = new Material.Builder(ALJAN).build();
    public static final Material SLEEPINGSTONE_ROCK = new Material.Builder(MaterialColor.COLOR_PURPLE).build();
    public static final Material SLEEPISHWATER = new Material.Builder(MaterialColor.COLOR_PURPLE).notSolidBlocking().noCollider().nonSolid().replaceable().liquid().build();
}
