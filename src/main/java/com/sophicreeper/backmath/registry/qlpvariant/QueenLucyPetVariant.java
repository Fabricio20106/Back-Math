package com.sophicreeper.backmath.registry.qlpvariant;

import com.google.gson.*;
import com.sophicreeper.backmath.registry.wsvariant.WandererSophieVariant;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.lang.reflect.Type;

public class QueenLucyPetVariant extends ForgeRegistryEntry.UncheckedRegistryEntry<QueenLucyPetVariant> {
    private final ResourceLocation textureLocation;

    public QueenLucyPetVariant(ResourceLocation textureLocation) {
        this.textureLocation = textureLocation;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    public JsonObject writeJSON(QueenLucyPetVariant variant) {
        JsonObject object = new JsonObject();
        object.addProperty("asset_id", variant.textureLocation.toString());
        return object;
    }

    public static class Serializer implements JsonDeserializer<QueenLucyPetVariant>, JsonSerializer<QueenLucyPetVariant> {
        @Override
        public QueenLucyPetVariant deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = element.getAsJsonObject();
            ResourceLocation textureLocation = ResourceLocation.tryParse(JSONUtils.getAsString(object, "asset_id"));
            return new QueenLucyPetVariant(textureLocation);
        }

        @Override
        public JsonElement serialize(QueenLucyPetVariant variant, Type sourceType, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("asset_id", variant.textureLocation.toString());
            return object;
        }
    }
}
