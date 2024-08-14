package com.sophicreeper.backmath.misc;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMBrewingRecipe;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, BackMath.MOD_ID);

    public static final RegistryObject<Potion> INSOMNIA = POTIONS.register("insomnia", () -> new Potion("insomnia", new EffectInstance(Effects.POISON, 200), new EffectInstance(Effects.BLINDNESS, 600)));
    public static final RegistryObject<Potion> LONG_INSOMNIA = POTIONS.register("long_insomnia", () -> new Potion("insomnia", new EffectInstance(Effects.POISON, 400), new EffectInstance(Effects.BLINDNESS, 1200)));
    public static final RegistryObject<Potion> DEEP_INSOMNIA = POTIONS.register("deep_insomnia", () -> new Potion("insomnia", new EffectInstance(Effects.POISON, 800, 1), new EffectInstance(Effects.BLINDNESS, 2400, 1)));

    public static void addPotionRecipes() {
        BrewingRecipeRegistry.addRecipe(new BMBrewingRecipe(Potions.AWKWARD, AxolotlTest.ALJAME.get(), INSOMNIA.get()));
        BrewingRecipeRegistry.addRecipe(new BMBrewingRecipe(BMPotions.INSOMNIA.get(), Items.REDSTONE, LONG_INSOMNIA.get()));
        BrewingRecipeRegistry.addRecipe(new BMBrewingRecipe(BMPotions.INSOMNIA.get(), Items.GLOWSTONE_DUST, DEEP_INSOMNIA.get()));
    }
}
