package com.sophicreeper.backmath.data.outfit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sophicreeper.backmath.entity.outfit.OutfitDefinition;
import cpw.mods.modlauncher.api.LamdbaExceptionUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.Tuple;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public abstract class OutfitDefinitionProvider implements IDataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Map<String, Tuple<OutfitDefinition, JsonObject>> toSerialize = new HashMap<>();
    private final DataGenerator generator;
    private final String modID;

    public OutfitDefinitionProvider(DataGenerator generator, String modID) {
        this.generator = generator;
        this.modID = modID;
    }

    @Override
    @Nonnull
    public String getName() {
        return "Outfit Definitions: " + this.modID;
    }

    protected abstract void addDefinitions();

    @Override
    public void run(DirectoryCache cache) throws IOException {
        this.addDefinitions();
        String definitionPath = "data/" + this.modID + "/outfit_definition/";

        this.toSerialize.forEach(LamdbaExceptionUtils.rethrowBiConsumer((name, pair) -> {
            Path definitionFile = this.generator.getOutputFolder().resolve(definitionPath + name + ".json");
            IDataProvider.save(GSON, cache, pair.getB(), definitionFile);
        }));
    }

    public void add(String name, OutfitDefinition definition) {
        this.toSerialize.put(name, new Tuple<>(definition, definition.toJSON(definition)));
    }
}
