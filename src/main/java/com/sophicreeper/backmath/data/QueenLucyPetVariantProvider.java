package com.sophicreeper.backmath.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import cpw.mods.modlauncher.api.LamdbaExceptionUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class QueenLucyPetVariantProvider implements IDataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Map<String, Tuple<QueenLucyPetVariant, JsonObject>> toSerialize = new HashMap<>();
    private final DataGenerator generator;
    private final ExistingFileHelper helper;
    private final String modID;

    public QueenLucyPetVariantProvider(DataGenerator generator, ExistingFileHelper fileHelper, String modID) {
        this.generator = generator;
        this.helper = fileHelper;
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
            this.validateVariant(pair.getA());

            IDataProvider.save(GSON, cache, pair.getB(), variantFile);
        }));
    }

    public void add(String name, QueenLucyPetVariant variant) {
        this.toSerialize.put(name, new Tuple<>(variant, variant.writeJSON(variant)));
    }

    private void validateVariant(QueenLucyPetVariant variant) throws FileNotFoundException {
        boolean valid = this.helper.exists(variant.getTextureLocation(), ResourcePackType.CLIENT_RESOURCES, ".png", "textures");
        if (!valid) throw new FileNotFoundException("Unable to find texture " + variant.getTextureLocation() + " for queen lucy pet variant '" + variant.getAssetID() + "'");
    }
}
