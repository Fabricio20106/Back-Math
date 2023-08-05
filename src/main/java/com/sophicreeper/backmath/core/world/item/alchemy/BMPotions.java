package com.sophicreeper.backmath.core.world.item.alchemy;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BMPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, BackMath.MOD_ID);

    public static final RegistryObject<Potion> INSOMNIA = POTIONS.register("insomnia", () ->
            new Potion("insomnia", new MobEffectInstance(MobEffects.POISON, 200), new MobEffectInstance(MobEffects.BLINDNESS, 600)));

    public static final RegistryObject<Potion> LONG_INSOMNIA = POTIONS.register("long_insomnia", () ->
            new Potion("insomnia", new MobEffectInstance(MobEffects.POISON, 400), new MobEffectInstance(MobEffects.BLINDNESS, 1200)));

    public static final RegistryObject<Potion> DEEP_INSOMNIA = POTIONS.register("deep_insomnia", () ->
            new Potion("insomnia", new MobEffectInstance(MobEffects.POISON, 800, 1), new MobEffectInstance(MobEffects.BLINDNESS, 2400, 1)));

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
            this.output = PotionUtils.setPotion(new ItemStack(Items.POTION), outputIn);
        }

        // Checks the item where the water bottle would go.
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
