package com.sophicreeper.backmath.misc;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.ResourceLocation;

public class BMHeadType {
    private final ResourceLocation textureLocation;
    public static final BMHeadType ANGRY_SOPHIE = new BMHeadType(BackMath.entityTexture("sophie/angry_sophie"));
    public static final BMHeadType INSOMNIA_SOPHIE = new BMHeadType(BackMath.entityTexture("sophie/insomnia/insomnia_sophie"));
    public static final BMHeadType QUEEN_LUCY = new BMHeadType(BackMath.entityTexture("queen_lucy/current"));
    public static final BMHeadType ZOMBIE_FABRICIO = new BMHeadType(BackMath.entityTexture("zombie/zombie_fabricio"));

    public BMHeadType(ResourceLocation textureLocation) {
        this.textureLocation = textureLocation;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }
}
