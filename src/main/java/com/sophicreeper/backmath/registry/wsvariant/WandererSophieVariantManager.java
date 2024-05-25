package com.sophicreeper.backmath.registry.wsvariant;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;

import java.util.*;

// TODO: Make the data-driven wanderer sophie variant files count for the actual registry.
public class WandererSophieVariantManager extends JsonReloadListener {
    private static final Gson GSON = createWandererSophieVariantSerializer().create();
    private Map<ResourceLocation, WandererSophieVariant> wandererSophieVariants = ImmutableMap.of();
    private static final String VARIANTS_FOLDER = "wanderer_sophie_variant";
    private static final Collection<ResourceLocation> LOCATIONS = new ArrayList<>();

    public WandererSophieVariantManager() {
        super(GSON, VARIANTS_FOLDER);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> resourceList, IResourceManager manager, IProfiler profiler) {
        ImmutableMap.Builder<ResourceLocation, WandererSophieVariant> builder = ImmutableMap.builder();

        resourceList.forEach(((location, element) -> {
            try {
//                LogManager.getLogger().debug("Location: \"{}\", Element: Is JSON Object? {}. Full JSON object: {}", location, element.isJsonObject(), element);
                if (element.isJsonObject()) {
                    JsonObject object = element.getAsJsonObject();
                    LogManager.getLogger().debug("Object: {}", object);
                    WandererSophieVariant variant = GSON.fromJson(element, WandererSophieVariant.class);
//                    builder.put(location, new WandererSophieVariant(ResourceLocation.tryParse(JSONUtils.getAsString(object, "asset_id")), JSONUtils.getAsBoolean(object, "slim_arms")));
                    builder.put(location, variant);
                } else {
//                    LogManager.getLogger().debug("'element' is not a JSON object. Full JSON: {}", element);
                }
            } catch (Exception exception) {
                LogManager.getLogger().error(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.wanderer_sophie_variant.parse_error", location)).getString(), exception);
            }
        }));
        this.wandererSophieVariants = builder.build();
//        LogManager.getLogger().debug("getVariantLocations() called from apply(): {}", getVariantLocations());
        LogManager.getLogger().info(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("console.backmath.wanderer_sophie_variant.loaded", builder.build().size())).getString());
    }

    public static GsonBuilder createWandererSophieVariantSerializer() {
        return new GsonBuilder().registerTypeAdapter(WandererSophieVariant.class, new WandererSophieVariant.Serializer());
    }

    public Collection<WandererSophieVariant> getWandererSophieVariants() {
        return this.wandererSophieVariants.values();
    }

    public Collection<ResourceLocation> getVariantLocations() {
//        LogManager.getLogger().debug("Values in wandererSophieVariants: {}", getWandererSophieVariants());
        for (WandererSophieVariant variant : getWandererSophieVariants()) {
            LOCATIONS.add(variant.getTextureLocation());
//            LogManager.getLogger().debug("Added location '{}' to the texture locations map {}", variant.getTextureLocation(), LOCATIONS);
        }
        return LOCATIONS;
    }
}
