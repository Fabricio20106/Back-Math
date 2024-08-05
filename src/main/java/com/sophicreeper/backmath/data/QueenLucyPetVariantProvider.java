package com.sophicreeper.backmath.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import cpw.mods.modlauncher.api.LamdbaExceptionUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class QueenLucyPetVariantProvider implements IDataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Map<String, Tuple<QueenLucyPetVariant, JsonObject>> toSerialize = new HashMap<>();
    private final DataGenerator generator;
    private final String modID;

    public QueenLucyPetVariantProvider(DataGenerator generator, String modID) {
        this.generator = generator;
        this.modID = modID;
    }

    @Override
    @Nonnull
    public String getName() {
        return "Queen Lucy Pet Variants: " + this.modID;
    }

    protected abstract void addVariants();

    @Override
    public void run(DirectoryCache cache) {
        this.addVariants();
        String variantsPath = "data/" + this.modID + "/queen_lucy_pet_variant/";
        List<ResourceLocation> entries = new ArrayList<>();

        this.toSerialize.forEach(LamdbaExceptionUtils.rethrowBiConsumer((name, pair) -> {
            entries.add(new ResourceLocation(this.modID, name));
            Path variantFile = this.generator.getOutputFolder().resolve(variantsPath + name + ".json");

            IDataProvider.save(GSON, cache, pair.getB(), variantFile);
        }));
    }

    public void add(String name, QueenLucyPetVariant variant) {
        this.toSerialize.put(name, new Tuple<>(variant, variant.writeJSON(variant)));
    }
}
