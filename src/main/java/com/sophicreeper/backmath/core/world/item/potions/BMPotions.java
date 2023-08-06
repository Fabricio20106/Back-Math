package com.sophicreeper.backmath.core.world.item.potions;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
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
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, AxolotlTest.ALJAME.get(), INSOMNIA.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(BMPotions.INSOMNIA.get(), Items.REDSTONE, LONG_INSOMNIA.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(BMPotions.INSOMNIA.get(), Items.GLOWSTONE_DUST, DEEP_INSOMNIA.get()));
    }

    private static class BetterBrewingRecipe implements IBrewingRecipe {
        private final Potion bottleInput;
        private final Item itemInput;
        private final ItemStack output;

        public BetterBrewingRecipe(Potion bottleInputIn, Item itemInputIn, Potion outputIn){
            this.bottleInput = bottleInputIn;
            this.itemInput = itemInputIn;
            this.output = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), outputIn);
        }

        // checks the item where the water bottle would go
        @Override
        public boolean isInput(ItemStack input) {
            return PotionUtils.getPotionFromItem(input).equals(this.bottleInput);
        }

        // checks the item where the nether wart would go
        @Override
        public boolean isIngredient(ItemStack ingredient) {
            return ingredient.getItem().equals(this.itemInput);
        }

        // gets the output potion. Very important to call copy because ItemStacks are mutable
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
