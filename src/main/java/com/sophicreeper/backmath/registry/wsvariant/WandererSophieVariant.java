package com.sophicreeper.backmath.registry.wsvariant;

import com.google.gson.*;
import com.sophicreeper.backmath.registry.BMRegistries;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.lang.reflect.Type;

public class WandererSophieVariant extends ForgeRegistryEntry.UncheckedRegistryEntry<WandererSophieVariant> {
    private final ResourceLocation textureLocation;
    private final boolean slimArms;

    public WandererSophieVariant(ResourceLocation textureLocation, boolean slimArms) {
        this.textureLocation = textureLocation;
        this.slimArms = slimArms;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    public WandererSophieVariant readJSON(JsonObject object) {
        return new WandererSophieVariant(ResourceLocation.tryParse(JSONUtils.getAsString(object, "asset_id")), JSONUtils.getAsBoolean(object, "slim_arms"));
    }

    public JsonObject writeJSON(WandererSophieVariant variant) {
        JsonObject object = new JsonObject();
        object.addProperty("asset_id", variant.textureLocation.toString());
        object.addProperty("slim_arms", variant.slimArms);
        return object;
    }

    @Nullable
    public static WandererSophieVariant byName(String name) {
        return BMRegistries.WANDERER_SOPHIE_VARIANT.getValue(ResourceLocation.tryParse(name));
    }

    public static class Serializer implements JsonDeserializer<WandererSophieVariant>, JsonSerializer<WandererSophieVariant> {
        @Override
        public WandererSophieVariant deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = element.getAsJsonObject();
            ResourceLocation textureLocation = ResourceLocation.tryParse(JSONUtils.getAsString(object, "asset_id"));
            boolean slimArms = JSONUtils.getAsBoolean(object, "slim_arms");
            return new WandererSophieVariant(textureLocation, slimArms);
        }

        @Override
        public JsonElement serialize(WandererSophieVariant variant, Type sourceType, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("asset_id", variant.textureLocation.toString());
            object.addProperty("slim_arms", variant.slimArms);
            return object;
        }
    }
}
