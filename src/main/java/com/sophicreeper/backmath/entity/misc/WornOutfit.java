package com.sophicreeper.backmath.entity.misc;

import com.google.common.collect.Sets;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Collections;

public interface WornOutfit {
    ExistingFileHelper FILE_HELPER = new ExistingFileHelper(Collections.emptySet(), Sets.newHashSet("minecraft", "forge", "backmath"), true, null, null);

    String getOutfitTexture();

    void setOutfitTexture(String outfitTexture);

    boolean isWearingOutfit();

    static ResourceLocation parseOutfitLocation(boolean slimArms, String name, EquipmentSlotType slotType) {
        ResourceLocation location = new ResourceLocation(name);
        if (slotType == EquipmentSlotType.CHEST) return new ResourceLocation(location.getNamespace(), "textures/models/outfit/" + location.getPath() + "_" + slotType.getName() + "_" + (slimArms ? "slim" : "classic") + ".png");
        else return new ResourceLocation(location.getNamespace(), "textures/models/outfit/" + location.getPath() + "_" + slotType.getName() + ".png");
    }

    default boolean shouldHideTexture(boolean slimArms, EquipmentSlotType slotType) {
        return FILE_HELPER.exists(parseOutfitLocation(slimArms, this.getOutfitTexture(), slotType), ResourcePackType.CLIENT_RESOURCES);
    }
}
