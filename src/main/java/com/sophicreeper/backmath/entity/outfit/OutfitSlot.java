package com.sophicreeper.backmath.entity.outfit;

import com.google.gson.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.Optional;

public class OutfitSlot {
    public static final Codec<OutfitSlot> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf(
            "texture").forGetter(OutfitSlot::texture), ResourceLocation.CODEC.optionalFieldOf("emissive_texture").forGetter(slot -> Optional.ofNullable(slot.emissiveTexture))).apply(instance, OutfitSlot::new));
    private final ResourceLocation texture;
    @Nullable
    private final ResourceLocation emissiveTexture;

    public OutfitSlot(ResourceLocation texture, @Nullable ResourceLocation emissiveTexture) {
        this.texture = texture;
        this.emissiveTexture = emissiveTexture;
    }

    public OutfitSlot(ResourceLocation texture) {
        this(texture, (ResourceLocation) null);
    }

    public OutfitSlot(ResourceLocation texture, Optional<ResourceLocation> emissiveTexture) {
        this(texture, emissiveTexture.orElse(null));
    }

    public ResourceLocation texture() {
        return this.texture;
    }

    public ResourceLocation emissiveTexture() {
        return this.emissiveTexture;
    }

    public static OutfitSlot fromJSON(JsonObject object) {
        ResourceLocation texture = ResourceLocation.tryParse(JSONUtils.getAsString(object, "texture"));
        ResourceLocation emissiveTexture = object.has("emissive_texture") && object.get("emissive_texture").isJsonPrimitive() ? ResourceLocation.tryParse(object.get("emissive_texture").getAsString()) : null;
        return new OutfitSlot(texture, emissiveTexture);
    }

    public static JsonElement toJSON(OutfitSlot slot) {
        JsonObject object = new JsonObject();
        object.addProperty("texture", slot.texture.toString());
        if (slot.emissiveTexture != null) object.addProperty("emissive_texture", slot.emissiveTexture.toString());
        return object;
    }

    @Override
    public String toString() {
        return "OutfitSlot[texture=" + this.texture + ", emissive_texture=" + this.emissiveTexture + "]";
    }

    public static class Serializer implements JsonDeserializer<OutfitSlot>, JsonSerializer<OutfitSlot> {
        @Override
        public OutfitSlot deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = element.getAsJsonObject();
            ResourceLocation texture = ResourceLocation.tryParse(JSONUtils.getAsString(object, "texture"));
            ResourceLocation emissiveTexture = object.has("emissive_texture") && object.get("emissive_texture").isJsonPrimitive() ? ResourceLocation.tryParse(object.get("emissive_texture").getAsString()) : null;
            return new OutfitSlot(texture, emissiveTexture);
        }

        @Override
        public JsonElement serialize(OutfitSlot slot, Type type, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("texture", slot.texture.toString());
            if (slot.emissiveTexture != null) object.addProperty("emissive_texture", slot.emissiveTexture.toString());
            return object;
        }
    }
}
