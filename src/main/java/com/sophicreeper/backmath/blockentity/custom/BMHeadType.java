package com.sophicreeper.backmath.blockentity.custom;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class BMHeadType {
    private final ResourceLocation textureLocation;
    @Nullable
    private final ResourceLocation eyesLocation;
    private final boolean playerLikeTexture;

    public static final BMHeadType WANDERER_SOPHIE = new BMHeadType(BackMath.entityTexture("sophie/wanderer/yellow_axolotl"));
    public static final BMHeadType ANGRY_SOPHIE = new BMHeadType(BackMath.entityTexture("sophie/angry_sophie"));
    public static final BMHeadType INSOMNIA_SOPHIE = new BMHeadType(BackMath.entityTexture("sophie/insomnia/insomnia_sophie"));
    public static final BMHeadType QUEEN_LUCY = new BMHeadType(BackMath.entityTexture("queen_lucy/current"));
    public static final BMHeadType ZOMBIE_FABRICIO = new BMHeadType(BackMath.entityTexture("zombie/zombie_fabricio"));
    public static final BMHeadType ALJAMIC_BONES = new BMHeadType(BackMath.entityTexture("skeleton/aljamic_bones"), null, false);
    public static final BMHeadType SLEEPISH_SKELETON = new BMHeadType(BackMath.entityTexture("skeleton/sleepish_skeleton"), BackMath.entityTexture("skeleton/sleepish_skeleton_eyes"), false);

    public BMHeadType(ResourceLocation textureLocation) {
        this(textureLocation, null, true);
    }

    public BMHeadType(ResourceLocation textureLocation, @Nullable ResourceLocation eyesLocation, boolean playerLikeTexture) {
        this.textureLocation = textureLocation;
        this.eyesLocation = eyesLocation;
        this.playerLikeTexture = playerLikeTexture;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    @Nullable
    public ResourceLocation getEyesLocation() {
        return this.eyesLocation;
    }

    public boolean usesPlayerLikeTexture() {
        return this.playerLikeTexture;
    }
}
