package com.sophicreeper.backmath.item.custom.potion;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, BackMath.MOD_ID);

    public static final RegistryObject<Potion> INSOMNIA = POTIONS.register("insomnia", () ->
            new Potion("insomnia", new EffectInstance(Effects.POISON, 200), new EffectInstance(Effects.BLINDNESS, 600)));

    public static final RegistryObject<Potion> LONG_INSOMNIA = POTIONS.register("long_insomnia", () ->
            new Potion("insomnia", new EffectInstance(Effects.POISON, 400), new EffectInstance(Effects.BLINDNESS, 1200)));

    public static final RegistryObject<Potion> DEEP_INSOMNIA = POTIONS.register("deep_insomnia", () ->
            new Potion("insomnia", new EffectInstance(Effects.POISON, 800, 1), new EffectInstance(Effects.BLINDNESS, 2400, 1)));

    public static void addPotionRecipes() {
        BrewingRecipeRegistry.addRecipe(new BMBrewingRecipe(Potions.AWKWARD, AxolotlTest.ALJAME.get(), INSOMNIA.get()));
        BrewingRecipeRegistry.addRecipe(new BMBrewingRecipe(BMPotions.INSOMNIA.get(), Items.REDSTONE, LONG_INSOMNIA.get()));
        BrewingRecipeRegistry.addRecipe(new BMBrewingRecipe(BMPotions.INSOMNIA.get(), Items.GLOWSTONE_DUST, DEEP_INSOMNIA.get()));
    }

    private static class BMBrewingRecipe implements IBrewingRecipe {
        private final Potion bottleInput;
        private final Item itemInput;
        private final ItemStack output;

        public BMBrewingRecipe(Potion potion, Item ingredient, Potion output) {
            this.bottleInput = potion;
            this.itemInput = ingredient;
            this.output = PotionUtils.setPotion(new ItemStack(Items.POTION), output);
        }

        // Checks the item where the potion would go.
        @Override
        public boolean isInput(ItemStack input) {
            return PotionUtils.getPotion(input).equals(this.bottleInput);
        }

        // Checks the item where the nether wart would go.
        @Override
        public boolean isIngredient(ItemStack ingredient) {
            return ingredient.getItem().equals(this.itemInput);
        }

        // Gets the output potion. Very important to call copy because ItemStacks are mutable.
        @Override
        public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
            if (isInput(input) && isIngredient(ingredient)) {
                return this.output.copy();
            } else {
                return ItemStack.EMPTY;
            }
        }
    }
}
