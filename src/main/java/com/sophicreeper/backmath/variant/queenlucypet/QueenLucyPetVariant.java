package com.sophicreeper.backmath.variant.queenlucypet;

import com.google.gson.*;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class QueenLucyPetVariant extends ForgeRegistryEntry.UncheckedRegistryEntry<QueenLucyPetVariant> {
    public static Map<ResourceLocation, QueenLucyPetVariant> DATA_DRIVEN_VARIANTS = new HashMap<>();
    private final ResourceLocation assetID;
    private final ITextComponent displayName;
    private final ResourceLocation textureLocation;

    public QueenLucyPetVariant(ResourceLocation assetID, ITextComponent displayName, ResourceLocation textureLocation) {
        this.assetID = assetID;
        this.displayName = displayName;
        this.textureLocation = textureLocation;
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

    public JsonObject writeJSON(QueenLucyPetVariant variant) {
        JsonObject object = new JsonObject();
        object.addProperty("asset_id", variant.assetID.toString());
        object.addProperty("texture_location", variant.textureLocation.toString());
        object.add("display_name", ITextComponent.Serializer.toJsonTree(variant.displayName));
        return object;
    }

    public static class Serializer implements JsonDeserializer<QueenLucyPetVariant>, JsonSerializer<QueenLucyPetVariant> {
        @Override
        public QueenLucyPetVariant deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = element.getAsJsonObject();
            ResourceLocation assetID = ResourceLocation.tryParse(JSONUtils.getAsString(object, "asset_id"));
            ITextComponent displayName = ITextComponent.Serializer.fromJson(JSONUtils.getAsJsonObject(object, "display_name"));
            ResourceLocation textureLocation = ResourceLocation.tryParse(JSONUtils.getAsString(object, "texture_location"));
            return new QueenLucyPetVariant(assetID, displayName, textureLocation);
        }

        @Override
        public JsonElement serialize(QueenLucyPetVariant variant, Type sourceType, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("asset_id", variant.assetID.toString());
            object.addProperty("texture_location", variant.textureLocation.toString());
            object.add("display_name", ITextComponent.Serializer.toJsonTree(variant.displayName));
            return object;
        }
    }
}
