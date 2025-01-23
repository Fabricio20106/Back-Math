package com.sophicreeper.backmath.variant.wansophie;

import com.google.gson.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class WandererSophieVariant extends ForgeRegistryEntry.UncheckedRegistryEntry<WandererSophieVariant> {
    public static final Codec<WandererSophieVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(ResourceLocation.CODEC.fieldOf("asset_id").forGetter(WandererSophieVariant::getAssetID),
            ResourceLocation.CODEC.fieldOf("texture_location").forGetter(WandererSophieVariant::getTextureLocation),
            Codec.BOOL.fieldOf("slim_arms").forGetter(WandererSophieVariant::hasSlimArms)).apply(instance, WandererSophieVariant::new));
    public static Map<ResourceLocation, WandererSophieVariant> DATA_DRIVEN_VARIANTS = new HashMap<>();
    private final ResourceLocation assetID;
    private final ResourceLocation textureLocation;
    private final boolean slimArms;
    private final boolean spawnsNaturally;
    @Nullable
    private String descriptionID;

    public WandererSophieVariant(ResourceLocation assetID, ResourceLocation textureLocation, boolean slimArms, boolean spawnsNaturally) {
        this.assetID = assetID;
        this.textureLocation = textureLocation;
        this.slimArms = slimArms;
        this.spawnsNaturally = spawnsNaturally;
    }

    public WandererSophieVariant(ResourceLocation assetID, ResourceLocation textureLocation, boolean slimArms) {
        this(assetID, textureLocation, slimArms, true);
    }

    public static WandererSophieVariant getVariant(String variantLocation) {
        return DATA_DRIVEN_VARIANTS.get(new ResourceLocation(variantLocation));
    }

    public static boolean isVariantRegistered(String variantLocation) {
        return DATA_DRIVEN_VARIANTS.containsKey(new ResourceLocation(variantLocation));
    }

    public static boolean isVariantRegistered(WandererSophieVariant variantLocation) {
        return DATA_DRIVEN_VARIANTS.containsValue(variantLocation);
    }

    public static ResourceLocation trueTextureLocation(ResourceLocation textureLocation) {
        return new ResourceLocation(textureLocation.getNamespace(), "textures/" + textureLocation.getPath() + ".png");
    }

    public ResourceLocation getAssetID() {
        return this.assetID;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    public boolean hasSlimArms() {
        return this.slimArms;
    }

    public boolean spawnsNaturally() {
        return this.spawnsNaturally;
    }

    @Nullable
    public static WandererSophieVariant getVariantFromStack(ItemStack stack) {
        if (stack.getTag() != null && stack.getTag().contains("variant", TagTypes.STRING)) {
            ResourceLocation location = ResourceLocation.tryParse(stack.getTag().getString("variant"));
            return WandererSophieVariant.DATA_DRIVEN_VARIANTS.get(location);
        }
        return null;
    }

    protected String getOrMakeTranslation() {
        if (this.descriptionID == null) this.descriptionID = Util.makeDescriptionId("wanderer_sophie_variant", this.getAssetID());
        return this.descriptionID;
    }

    public String getTranslation() {
        return this.getOrMakeTranslation();
    }

    public JsonObject writeJSON(WandererSophieVariant variant) {
        JsonObject object = new JsonObject();
        object.addProperty("asset_id", variant.assetID.toString());
        object.addProperty("texture_location", variant.textureLocation.toString());
        object.addProperty("slim_arms", variant.slimArms);
        object.addProperty("spawns_naturally", variant.spawnsNaturally);
        return object;
    }

    @Override
    public String toString() {
        return "[asset_id=" + this.assetID + ",texture_location=" + this.textureLocation + ",slim_arms=" + this.slimArms + ",spawns_naturally=" + this.spawnsNaturally + "]";
    }

    public static class Serializer implements JsonDeserializer<WandererSophieVariant>, JsonSerializer<WandererSophieVariant> {
        @Override
        public WandererSophieVariant deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = element.getAsJsonObject();
            ResourceLocation assetID = ResourceLocation.tryParse(JSONUtils.getAsString(object, "asset_id"));
            ResourceLocation textureLocation = ResourceLocation.tryParse(JSONUtils.getAsString(object, "texture_location"));
            boolean slimArms = JSONUtils.getAsBoolean(object, "slim_arms");
            boolean spawnsNaturally = JSONUtils.getAsBoolean(object, "spawns_naturally");
            return new WandererSophieVariant(assetID, textureLocation, slimArms, spawnsNaturally);
        }

        @Override
        public JsonElement serialize(WandererSophieVariant variant, Type sourceType, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("asset_id", variant.assetID.toString());
            object.addProperty("texture_location", variant.textureLocation.toString());
            object.addProperty("slim_arms", variant.slimArms);
            object.addProperty("spawns_naturally", variant.spawnsNaturally);
            return object;
        }
    }
}
