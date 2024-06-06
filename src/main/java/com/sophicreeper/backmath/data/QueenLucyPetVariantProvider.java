package com.sophicreeper.backmath.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sophicreeper.backmath.registry.qlpvariant.QueenLucyPetVariant;
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
    private final DataGenerator generation;
    private final String modID;

    public QueenLucyPetVariantProvider(DataGenerator generation, String modID) {
        this.generation = generation;
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
        String variantsPath = "data/" + this.modID + "/queen_sophie_pet_variant/";
        List<ResourceLocation> entries = new ArrayList<>();

        this.toSerialize.forEach(LamdbaExceptionUtils.rethrowBiConsumer((name, pair) -> {
            entries.add(new ResourceLocation(this.modID, name));
            Path variantFile = this.generation.getOutputFolder().resolve(variantsPath + name + ".json");

            IDataProvider.save(GSON, cache, pair.getB(), variantFile);
        }));
    }

    public void add(String name, QueenLucyPetVariant variant) {
        this.toSerialize.put(name, new Tuple<>(variant, variant.writeJSON(variant)));
    }
}
