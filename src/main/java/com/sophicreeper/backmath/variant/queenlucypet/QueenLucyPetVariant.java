package com.sophicreeper.backmath.variant.queenlucypet;

import com.google.gson.*;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class QueenLucyPetVariant extends ForgeRegistryEntry.UncheckedRegistryEntry<QueenLucyPetVariant> {
    public static Map<ResourceLocation, QueenLucyPetVariant> DATA_DRIVEN_VARIANTS = new HashMap<>();
    private final ResourceLocation assetID;
    private final ITextComponent displayName;
    private final ResourceLocation textureLocation;
    @Nullable
    private final ResourceLocation emissiveTexture;

    public QueenLucyPetVariant(ResourceLocation assetID, ITextComponent displayName, ResourceLocation textureLocation, @Nullable ResourceLocation emissiveTexture) {
        this.assetID = assetID;
        this.displayName = displayName;
        this.textureLocation = textureLocation;
        this.emissiveTexture = emissiveTexture;
    }

    public QueenLucyPetVariant(ResourceLocation assetID, ITextComponent displayName, ResourceLocation textureLocation) {
        this(assetID, displayName, textureLocation, null);
    }

    public ResourceLocation getAssetID() {
        return this.assetID;
    }

    public ITextComponent getDisplayName() {
        return this.displayName;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    @Nullable
    public ResourceLocation getEmissiveTexture() {
        return this.emissiveTexture;
    }

    public JsonObject writeJSON(QueenLucyPetVariant variant) {
        JsonObject object = new JsonObject();
        object.addProperty("asset_id", variant.assetID.toString());
        object.addProperty("texture_location", variant.textureLocation.toString());
        if (variant.emissiveTexture != null) object.addProperty("emissive_texture", variant.emissiveTexture.toString());
        object.add("display_name", ITextComponent.Serializer.toJsonTree(variant.displayName));
        return object;
    }

    @Override
    public String toString() {
        return "QueenLucyPetVariant[asset_id=" + this.assetID + ",texture_location=" + this.textureLocation + ",emissive_texture=" + this.emissiveTexture + ",display_name=" + this.displayName.getString() + "]";
    }

    public static class Serializer implements JsonDeserializer<QueenLucyPetVariant>, JsonSerializer<QueenLucyPetVariant> {
        @Override
        public QueenLucyPetVariant deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = element.getAsJsonObject();
            ResourceLocation assetID = ResourceLocation.tryParse(JSONUtils.getAsString(object, "asset_id"));
            ITextComponent displayName = ITextComponent.Serializer.fromJson(JSONUtils.getAsJsonObject(object, "display_name"));
            ResourceLocation textureLocation = ResourceLocation.tryParse(JSONUtils.getAsString(object, "texture_location"));
            ResourceLocation emissiveTexture = object.has("emissive_texture") && object.get("emissive_texture").isJsonPrimitive() ? ResourceLocation.tryParse(object.get("emissive_texture").getAsString()) : null;
            return new QueenLucyPetVariant(assetID, displayName, textureLocation, emissiveTexture);
        }

        @Override
        public JsonElement serialize(QueenLucyPetVariant variant, Type sourceType, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("asset_id", variant.assetID.toString());
            object.addProperty("texture_location", variant.textureLocation.toString());
            if (variant.emissiveTexture != null) object.addProperty("emissive_texture", variant.emissiveTexture.toString());
            object.add("display_name", ITextComponent.Serializer.toJsonTree(variant.displayName));
            return object;
        }
    }
}
