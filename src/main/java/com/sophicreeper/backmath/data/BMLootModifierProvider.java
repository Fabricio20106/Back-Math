package com.sophicreeper.backmath.data;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.loot.modifier.AddToTableLootModifier;
import com.sophicreeper.backmath.loot.modifier.ItemStackAdditionLootModifier;
import com.sophicreeper.backmath.util.BMResourceLocations;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.conditions.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class BMLootModifierProvider extends GlobalLootModifierProvider {
    public BMLootModifierProvider(DataGenerator generator) {
        super(generator, BackMath.MOD_ID);
    }

    @Override
    protected void start() {
        // Music Discs
        this.add("wellerman_disc_modifier", new ItemStackAdditionLootModifier.Serializer().setRegistryName(BackMath.backMath("wellerman_disc_modifier")),
                new ItemStackAdditionLootModifier(new ILootCondition[] {new LootTableIdCondition.Builder(LootTables.SHIPWRECK_TREASURE).build()},
                        new ItemStack(AxolotlTest.WELLERMAN_DISC.get()), 0.75F));
        this.add("snowman_disc_modifier", new ItemStackAdditionLootModifier.Serializer().setRegistryName(BackMath.backMath("snowman_disc_modifier")),
                new ItemStackAdditionLootModifier(new ILootCondition[] {new LootTableIdCondition.Builder(LootTables.IGLOO_CHEST).build()},
                        new ItemStack(AxolotlTest.SNOWMAN_DISC.get()), 0.75F));
        this.add("arcade_disc_modifier", new ItemStackAdditionLootModifier.Serializer().setRegistryName(BackMath.backMath("arcade_disc_modifier")),
                new ItemStackAdditionLootModifier(new ILootCondition[] {new LootTableIdCondition.Builder(LootTables.NETHER_BRIDGE).build()},
                        new ItemStack(AxolotlTest.ARCADE_DISC.get()), 0.75F));
        this.add("ericwho_disc_modifier", new ItemStackAdditionLootModifier.Serializer().setRegistryName(BackMath.backMath("ericwho_disc_modifier")),
                new ItemStackAdditionLootModifier(new ILootCondition[] {new LootTableIdCondition.Builder(LootTables.VILLAGE_PLAINS_HOUSE).build()},
                        new ItemStack(AxolotlTest.DADADADA_DA_DISC.get()), 0.3F));
        this.add("stay_disc_modifier", new ItemStackAdditionLootModifier.Serializer().setRegistryName(BackMath.backMath("stay_disc_modifier")),
                new ItemStackAdditionLootModifier(new ILootCondition[] {new LootTableIdCondition.Builder(LootTables.SIMPLE_DUNGEON).build()},
                        new ItemStack(AxolotlTest.STAY_DISC.get()), 0.4F));

        // Miscellaneous
        this.add("mech_mech_modifier", new ItemStackAdditionLootModifier.Serializer().setRegistryName(BackMath.backMath("mech_mech_modifier")),
                new ItemStackAdditionLootModifier(new ILootCondition[] {new LootTableIdCondition.Builder(LootTables.NETHER_BRIDGE).build()},
                        new ItemStack(AxolotlTest.MECH_MECH.get()), 0.2F));
        this.add("red_yellow_wool_modifier", new AddToTableLootModifier.Serializer().setRegistryName(BackMath.backMath("red_yellow_wool_modifier")),
                new AddToTableLootModifier(new ILootCondition[] {new LootTableIdCondition.Builder(LootTables.SHEPHERD_GIFT).build()},
                        BMResourceLocations.SHEPHERD_GIFT_ADDITION, 0.0588235294117647D));

        this.add("green_apple_modifier", new ItemStackAdditionLootModifier.Serializer().setRegistryName(BackMath.backMath("green_apple_modifier")),
                new ItemStackAdditionLootModifier(new ILootCondition[] {
                        new LootTableIdCondition.Builder(new ResourceLocation("blocks/oak_leaves")).build(),
                        SurvivesExplosion.survivesExplosion().build(),
                        TableBonus.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F).build(),
                        Inverted.invert(Alternative.alternative(
                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)),
                                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(
                                        new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))).build()
                }, new ItemStack(AxolotlTest.GREEN_APPLE.get()), 1));
    }
}
