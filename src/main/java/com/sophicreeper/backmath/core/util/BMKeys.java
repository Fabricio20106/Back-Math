package com.sophicreeper.backmath.core.util;

import net.minecraft.client.Minecraft;

public class BMKeys {
    public static boolean isHoldingShift() {
        return Minecraft.getInstance().options.keyShift.isDown();
    }
}
