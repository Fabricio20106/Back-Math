package com.sophicreeper.backmath.variant.manager;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.sophicreeper.backmath.misc.BMRegistries;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

// TODO: Make the data-driven wanderer sophie variant files count for the actual registry.
public class WandererSophieVariantManager extends JsonReloadListener {
    private Map<ResourceLocation, WandererSophieVariant> wandererSophieVariants = ImmutableMap.of();
    private static final Gson GSON = createWandererSophieVariantSerializer().create();
    public static final Logger LOGGER = LogManager.getLogger();

    public WandererSophieVariantManager() {
        super(GSON, "wanderer_sophie_variant");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> resourceList, IResourceManager manager, IProfiler profiler) {
        ImmutableMap.Builder<ResourceLocation, WandererSophieVariant> builder = ImmutableMap.builder();

        resourceList.forEach(((location, element) -> {
            try {
                if (element.isJsonObject()) {
                    WandererSophieVariant variant = GSON.fromJson(element, WandererSophieVariant.class);
                    String assetID = JSONUtils.getAsString(element.getAsJsonObject(), "texture_location").replace("entity/wanderer_sophie/", "");
                    try {
                        if (!BMRegistries.WANDERER_SOPHIE_VARIANT.containsKey(ResourceLocation.tryParse(assetID))) {
                            BMRegistries.WANDERER_SOPHIE_VARIANT.register(variant);
                        }
                    } catch (Exception exception) {
                        LOGGER.error("Back Math: Could not register Wanderer Sophie variant '{}' into the Forge registry", assetID);
                    }
                    builder.put(location, variant);
                }
            } catch (Exception exception) {
                LOGGER.error(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.wanderer_sophie_variant.parse_error", location)).getString(), exception);
            }
        }));
        this.wandererSophieVariants = builder.build();
        LOGGER.info(new TranslationTextComponent("console.backmath.wanderer_sophie_variant.loaded", builder.build().size()).getString());
    }

    public static GsonBuilder createWandererSophieVariantSerializer() {
        return new GsonBuilder().registerTypeAdapter(WandererSophieVariant.class, new WandererSophieVariant.Serializer());
    }
}
