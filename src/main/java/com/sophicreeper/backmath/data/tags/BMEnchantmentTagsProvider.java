package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.tag.BMEnchantmentTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BMEnchantmentTagsProvider extends ForgeRegistryTagsProvider<Enchantment> {
    public BMEnchantmentTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, ForgeRegistries.ENCHANTMENTS, BackMath.MOD_ID, fileHelper);
    }

    @Override
    @Nonnull
    public String getName() {
        return "Back Math - Enchantment Tags";
    }

    @Override
    protected void addTags() {
        this.tag(BMEnchantmentTags.APPLICABLE_TO_SUMMONER_STAFF).add(Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.MOB_LOOTING, Enchantments.FIRE_ASPECT, Enchantments.SWEEPING_EDGE,
                Enchantments.KNOCKBACK);
        this.tag(BMEnchantmentTags.APPLICABLE_TO_BACK_MATH_BOWS).add(Enchantments.POWER_ARROWS, Enchantments.PUNCH_ARROWS, Enchantments.FLAMING_ARROWS, Enchantments.INFINITY_ARROWS);
    }
}
