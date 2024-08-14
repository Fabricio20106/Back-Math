package com.sophicreeper.backmath.compat.jei;

import com.sophicreeper.backmath.BackMath;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class BMJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return BackMath.backMath("jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(BMAnvilRecipeMaker.getAnvilRecipes(registration.getVanillaRecipeFactory()), VanillaRecipeCategoryUid.ANVIL);
    }
}
