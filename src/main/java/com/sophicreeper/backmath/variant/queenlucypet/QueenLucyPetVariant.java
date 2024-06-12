package com.sophicreeper.backmath.variant.queenlucypet;

import com.google.gson.*;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.lang.reflect.Type;

public class QueenLucyPetVariant extends ForgeRegistryEntry.UncheckedRegistryEntry<QueenLucyPetVariant> {
    private final ITextComponent displayName;
    private final ResourceLocation textureLocation;

    public QueenLucyPetVariant(ITextComponent displayName, ResourceLocation textureLocation) {
        this.displayName = displayName;
        this.textureLocation = textureLocation;
    }

    public ITextComponent getDisplayName() {
        return this.displayName;
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    public JsonObject writeJSON(QueenLucyPetVariant variant) {
        JsonObject object = new JsonObject();
        object.addProperty("texture_location", variant.textureLocation.toString());

        if (variant.displayName instanceof StringTextComponent) {
            JsonObject name = new JsonObject();
            name.addProperty("text", variant.displayName.getString());
            object.add("display_name", name);
        } else if (variant.displayName instanceof TranslationTextComponent) {
            JsonObject name = new JsonObject();
            name.addProperty("translate", variant.displayName.getString());
            object.add("display_name", name);
        }
        return object;
    }

    public static class Serializer implements JsonDeserializer<QueenLucyPetVariant>, JsonSerializer<QueenLucyPetVariant> {
        @Override
        public QueenLucyPetVariant deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = element.getAsJsonObject();
            ITextComponent displayName = deserializeDisplayName(object);
            ResourceLocation textureLocation = ResourceLocation.tryParse(JSONUtils.getAsString(object, "texture_location"));
            return new QueenLucyPetVariant(displayName, textureLocation);
        }

        @Override
        public JsonElement serialize(QueenLucyPetVariant variant, Type sourceType, JsonSerializationContext context) {
            JsonObject object = new JsonObject();
            object.addProperty("texture_location", variant.textureLocation.toString());

            if (variant.displayName instanceof StringTextComponent) {
                JsonObject name = new JsonObject();
                name.addProperty("text", variant.displayName.getString());
                object.add("display_name", name);
            } else if (variant.displayName instanceof TranslationTextComponent) {
                JsonObject name = new JsonObject();
                name.addProperty("translate", variant.displayName.getString());
                object.add("display_name", name);
            }
            return object;
        }

        private ITextComponent deserializeDisplayName(JsonObject object) {
            JsonObject displayName = JSONUtils.getAsJsonObject(object, "display_name");
            StringTextComponent stringComponent;
            TranslationTextComponent translationComponent;
            if (displayName.has("text")) {
                stringComponent = new StringTextComponent(JSONUtils.getAsString(displayName, "text"));
                return stringComponent;
            } else if (displayName.has("translate")) {
                translationComponent = new TranslationTextComponent(JSONUtils.getAsString(displayName, "translate"));
                return translationComponent;
            }
            return new StringTextComponent("No translation.");
        }
    }
}
