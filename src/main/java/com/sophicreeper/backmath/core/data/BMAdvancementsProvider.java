package com.sophicreeper.backmath.core.data;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class BMAdvancementsProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> saver, ExistingFileHelper fileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.GOLDEN_PLATED.get()),
                        Component.translatable("advancements.backmath.root.title"),
                        Component.translatable("advancements.backmath.root.description"),
                        BackMath.resourceLoc("textures/block/glazed_tabu.png"), FrameType.TASK,
                        false, /*showToast*/ false, /*announceToChat*/ false /*hidden*/))
                .addCriterion("has_fruits", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.GUARANA.get(),
                        AxolotlTest.MANGO.get())).save(saver, BackMath.resourceLoc("backmath/root"), fileHelper);

        // Straight from the Nether!
        Advancement devilIngot = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.DEVIL_INGOT.get()),
                        Component.translatable("advancements.backmath.devil_ingot.title"),
                        Component.translatable("advancements.backmath.devil_ingot.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_devil_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.DEVIL_INGOT.get()))
                .save(saver, BackMath.resourceLoc("backmath/devil_ingot"), fileHelper);

        // Hell Armor
        Advancement devilArmorSet = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.DEVIL_CHESTPLATE.get()),
                        Component.translatable("advancements.backmath.devil_armor.title"),
                        Component.translatable("advancements.backmath.devil_armor.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(devilIngot)
                .addCriterion("has_devil_armor_set", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.DEVIL_HELMET.get(), AxolotlTest.DEVIL_CHESTPLATE.get(),
                        AxolotlTest.DEVIL_LEGGINGS.get(), AxolotlTest.DEVIL_BOOTS.get())).save(saver, BackMath.resourceLoc("backmath/devil_armor_set"), fileHelper);

        // Wait, the Aether doesn't exist
        Advancement angelicIngot = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.ANGELIC_INGOT.get()),
                        Component.translatable("advancements.backmath.angelic_ingot.title"),
                        Component.translatable("advancements.backmath.angelic_ingot.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_angelic_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.ANGELIC_INGOT.get()))
                .save(saver, BackMath.resourceLoc("backmath/angelic_ingot"), fileHelper);

        // Aether Armor
        Advancement angelicArmorSet = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.ANGELIC_CHESTPLATE.get()),
                        Component.translatable("advancements.backmath.angelic_armor.title"),
                        Component.translatable("advancements.backmath.angelic_armor.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(angelicIngot)
                .addCriterion("has_angelic_armor_set", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.ANGELIC_HELMET.get(), AxolotlTest.ANGELIC_CHESTPLATE.get(),
                        AxolotlTest.ANGELIC_LEGGINGS.get(), AxolotlTest.ANGELIC_BOOTS.get())).save(saver, BackMath.resourceLoc("backmath/angelic_armor_set"), fileHelper);

        // Angelical Casing
        Advancement angelicalCasing = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.ANGELICAL_CASING.get()),
                        Component.translatable("advancements.backmath.angelical_casing.title"),
                        Component.translatable("advancements.backmath.angelical_casing.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(angelicIngot)
                .addCriterion("has_a_casing", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.ANGELICAL_CASING.get()))
                .save(saver, BackMath.resourceLoc("backmath/angelical_casing"), fileHelper);

        // The Crystallizer
        Advancement crystallizer = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.CRYSTALLIZER.get()),
                        Component.translatable("advancements.backmath.crystallizer.title"),
                        Component.translatable("advancements.backmath.crystallizer.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(angelicalCasing)
                .addCriterion("has_the_crystallizer", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.CRYSTALLIZER.get()))
                .save(saver, BackMath.resourceLoc("backmath/crystallizer"), fileHelper);

        // More like Crystallizer MK2!
        Advancement crystallineCrystallizer = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.CRYSTALLINE_CRYSTALLIZER.get()),
                        Component.translatable("advancements.backmath.crystalline_crystallizer.title"),
                        Component.translatable("advancements.backmath.crystalline_crystallizer.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(crystallizer)
                .addCriterion("has_the_crystalline_crystallizer", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.CRYSTALLINE_CRYSTALLIZER.get()))
                .save(saver, BackMath.resourceLoc("backmath/crystalline_crystallizer"), fileHelper);

        // Crystallizing Mixture
        Advancement milkllaryIngot = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()),
                        Component.translatable("advancements.backmath.milkllary_ingot.title"),
                        Component.translatable("advancements.backmath.milkllary_ingot.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(crystallizer)
                .addCriterion("has_the_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MILKLLARY_INGOT.get()))
                .save(saver, BackMath.resourceLoc("backmath/milkllary_ingot"), fileHelper);

        // Purple Lanterns
        Advancement hillaryLanterns = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.HILLARY_LANTERN.get()),
                        Component.translatable("advancements.backmath.hillary_lamps.title"),
                        Component.translatable("advancements.backmath.hillary_lamps.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_the_lamps", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.HILLARY_LANTERN.get()))
                .save(saver, BackMath.resourceLoc("backmath/hillary_lanterns"), fileHelper);

        // Oh Hey, Toys!
        Advancement aliceToy = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.ALICE_TOY.get()),
                        Component.translatable("advancements.backmath.oh_hey_toys.title"),
                        Component.translatable("advancements.backmath.oh_hey_toys.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_an_alice_toy", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.ALICE_TOY.get()))
                .save(saver, BackMath.resourceLoc("backmath/alice_toy"), fileHelper);

        // Oh Hey, More Toys!
        Advancement otherToys = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.LEANDRO_TOY.get()),
                        Component.translatable("advancements.backmath.oh_hey_more_toys.title"),
                        Component.translatable("advancements.backmath.oh_hey_more_toys.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(aliceToy)
                .addCriterion("has_a_leandro_toy", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.LEANDRO_TOY.get()))
                .addCriterion("has_a_teenager_alice_toy", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.TEENAGER_ALICE_TOY.get()))
                .addCriterion("has_a_tyler_toy", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.TYLER_TOY.get()))
                .addCriterion("has_a_malena_toy", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MALENA_TOY.get()))
                .save(saver, BackMath.resourceLoc("backmath/other_toys"), fileHelper);

        // A Legendary Sapling
        Advancement goldenwoodSapling = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.GOLDENWOOD_SAPLING.get()),
                        Component.translatable("advancements.backmath.a_legendary_sapling.title"),
                        Component.translatable("advancements.backmath.a_legendary_sapling.description"),
                        null, FrameType.GOAL, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_the_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.GOLDENWOOD_SAPLING.get()))
                .save(saver, BackMath.resourceLoc("backmath/goldenwood_sapling"), fileHelper);

        // Truly a Masterpiece
        Advancement enchantedGoldenwoodSapling = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.ENCHANTED_GOLDENWOOD_SAPLING.get()),
                        Component.translatable("advancements.backmath.truly_a_masterpiece.title"),
                        Component.translatable("advancements.backmath.truly_a_masterpiece.description"),
                        null, FrameType.CHALLENGE, true, true, false))
                //.rewards(AdvancementRewards.Builder.experience(100))
                .rewards(new AdvancementRewards.Builder().addExperience(100))
                .parent(goldenwoodSapling)
                .addCriterion("has_the_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.ENCHANTED_GOLDENWOOD_SAPLING.get()))
                .save(saver, BackMath.resourceLoc("backmath/enchanted_goldenwood_sapling"), fileHelper);

        // Water in Dust Form?
        Advancement waterTalcPower = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.WATER_TALC_POWDER.get()),
                        Component.translatable("advancements.backmath.water_in_dust_form.title"),
                        Component.translatable("advancements.backmath.water_in_dust_form.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_the_water_talc_power", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.WATER_TALC_POWDER.get()))
                .save(saver, BackMath.resourceLoc("backmath/water_talc_powder"), fileHelper);

        // Swords, Personified
        Advancement personaBlade = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.PERSONA_BLADE.get()),
                        Component.translatable("advancements.backmath.swords_personified.title"),
                        Component.translatable("advancements.backmath.swords_personified.description"),
                        null, FrameType.GOAL, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_the_sword", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.PERSONA_BLADE.get()))
                .save(saver, BackMath.resourceLoc("backmath/persona_blade"), fileHelper);

        // The True Overpower
        Advancement allMidTermGear = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_SPAREY.get()),
                        Component.translatable("advancements.backmath.true_overpower.title"),
                        Component.translatable("advancements.backmath.true_overpower.description"),
                        null, FrameType.CHALLENGE, true, true, true))
                .rewards(new AdvancementRewards.Builder().addExperience(2800))
                .parent(rootAdvancement)
                .addCriterion("has_the_set", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_SPAREY.get(),
                        AxolotlTest.MID_TERM_WARRIOR_HELMET.get(), AxolotlTest.MID_TERM_BREASTPLATE.get(), AxolotlTest.MID_TERM_LEGGINGS.get(), AxolotlTest.MID_TERM_BOOTS.get(),
                        AxolotlTest.MID_TERM_SHIELD.get())).save(saver, BackMath.resourceLoc("backmath/all_mid_term_gear"), fileHelper);

        // Some Sick Hats
        Advancement allBackMathHats = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()),
                        Component.translatable("advancements.backmath.some_sick_hats.title"),
                        Component.translatable("advancements.backmath.some_sick_hats.description"),
                        null, FrameType.CHALLENGE, true, true, false))
                .rewards(new AdvancementRewards.Builder().addExperience(50))
                .parent(rootAdvancement)
                .addCriterion("has_bakugou_hair", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.BAKUGOU_HAIR.get()))
                .addCriterion("has_golden_halo", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.GOLDEN_HALO.get()))
                .addCriterion("has_aljamic_bone_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.ALJAMIC_BONE_HELMET.get()))
                .addCriterion("has_cat_tiara", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.CAT_TIARA.get()))
                .addCriterion("has_dog_tiara", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.DOG_TIARA.get()))
                .addCriterion("has_candy_pink_turtle_shell", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.CANDY_PINK_TURTLE_HELMET.get()))
                .addCriterion("has_candy_yellow_turtle_shell", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.CANDY_YELLOW_TURTLE_HELMET.get()))
                .addCriterion("has_yellow_karate_band", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.YELLOW_KARATE_BAND.get()))
                .addCriterion("has_golden_crown", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.GOLDEN_CROWN.get()))
                .save(saver, BackMath.resourceLoc("backmath/all_back_math_hats"), fileHelper);

        // Heat Singularity
        Advancement midTerm = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.MID_TERM.get()),
                        Component.translatable("advancements.backmath.mid_term.title"),
                        Component.translatable("advancements.backmath.mid_term.description"),
                        null, FrameType.CHALLENGE, true, true, true))
                .rewards(new AdvancementRewards.Builder().addExperience(1200))
                .parent(rootAdvancement)
                .addCriterion("has_emotional_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.EMOTIONAL_SINGULARITY.get()))
                .addCriterion("has_heat_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.HEAT_SINGULARITY.get()))
                .addCriterion("has_christianity_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.CHRISTIANITY_SINGULARITY.get()))
                .addCriterion("has_milkllary_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MILKLLARITY.get()))
                .addCriterion("has_meaty_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MEATY_SINGULARITY_SOPHIE.get()))
                .addCriterion("has_frutifery_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.FRUTIFERY_SINGULARITY_BACKMATH.get()))
                .addCriterion("has_vegetably_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.VEGETABLY_SINGULARITY.get()))
                .addCriterion("has_mangaed_mango_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MANGIBELARITY.get()))
                .save(saver, BackMath.resourceLoc("backmath/mid_term"), fileHelper);

        // With ALL Powers Combined!
        Advancement allSingularities = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.EMOTIONAL_SINGULARITY.get()),
                        Component.translatable("advancements.backmath.with_all_powers_combined.title"),
                        Component.translatable("advancements.backmath.with_all_powers_combined.description"),
                        null, FrameType.CHALLENGE, true, true, true))
                .rewards(new AdvancementRewards.Builder().addExperience(500))
                .parent(rootAdvancement)
                .addCriterion("has_emotional_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.EMOTIONAL_SINGULARITY.get()))
                .addCriterion("has_heat_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.HEAT_SINGULARITY.get()))
                .addCriterion("has_christianity_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.CHRISTIANITY_SINGULARITY.get()))
                .addCriterion("has_milkllary_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MILKLLARITY.get()))
                .addCriterion("has_meaty_sg_sophie", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MEATY_SINGULARITY_SOPHIE.get()))
                .addCriterion("has_meaty_sg_lucia", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MEATY_SINGULARITY_LUCIA.get()))
                .addCriterion("has_meaty_sg_fabricio", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MEATY_SINGULARITY_FABRICIO.get()))
                .addCriterion("has_meaty_sg_minecraft", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MEATY_SINGULARITY_MINECRAFT.get()))
                .addCriterion("has_fishy_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.FISHY_SINGULARITY.get()))
                .addCriterion("has_frutifery_sg_back_math", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.FRUTIFERY_SINGULARITY_BACKMATH.get()))
                .addCriterion("has_frutifery_sg_minecraft", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.FRUTIFERY_SINGULARITY_MINECRAFT.get()))
                .addCriterion("has_vegetably_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.VEGETABLY_SINGULARITY.get()))
                .addCriterion("has_mangaed_mango_sg", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MANGIBELARITY.get()))
                .addCriterion("has_mid_term", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM.get()))
                .addCriterion("has_obsidian_infused_mid_term", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()))
                .save(saver, BackMath.resourceLoc("backmath/all_singularities"), fileHelper);

        // Are They Cold or Hot?
        Advancement midTermTools = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.MID_TERM_SWORD.get()),
                        Component.translatable("advancements.backmath.mid_term_tools.title"),
                        Component.translatable("advancements.backmath.mid_term_tools.description"),
                        null, FrameType.CHALLENGE, true, true, false))
                .parent(midTerm)
                .addCriterion("has_mid_term_sword", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_SWORD.get()))
                .addCriterion("has_mid_term_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_PICKAXE.get()))
                .addCriterion("has_mid_term_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_SHOVEL.get()))
                .addCriterion("has_mid_term_axe", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_AXE.get()))
                .addCriterion("has_mid_term_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_HOE.get()))
                .addCriterion("has_mid_term_shield", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_SHIELD.get()))
                .save(saver, BackMath.resourceLoc("backmath/mid_term_tools"), fileHelper);

        // Making Expensive Doors
        Advancement midTermDoors = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.MID_TERM_DOOR.get()),
                        Component.translatable("advancements.backmath.decorative_expensive.title"),
                        Component.translatable("advancements.backmath.decorative_expensive.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(midTerm)
                .addCriterion("has_the_door", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_DOOR.get()))
                .save(saver, BackMath.resourceLoc("backmath/mid_term_door"), fileHelper);

        // Making Expensive Lights
        Advancement midTermLanterns = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.MID_TERM_HILLARY_LANTERN.get()),
                        Component.translatable("advancements.backmath.mt_hillary_lamps.title"),
                        Component.translatable("advancements.backmath.mt_hillary_lamps.description"),
                        null, FrameType.GOAL, true, true, false))
                .parent(midTermDoors)
                .addCriterion("has_the_lanterns", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.MID_TERM_HILLARY_LANTERN.get()))
                .save(saver, BackMath.resourceLoc("backmath/mid_term_hillary_lantern"), fileHelper);

        // That Kid with Expensive School Supplies
        Advancement rainbowPencil = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.RAINBOW_PENCIL.get()),
                        Component.translatable("advancements.backmath.lapis_rainbow.title"),
                        Component.translatable("advancements.backmath.lapis_rainbow.description"),
                        null, FrameType.CHALLENGE, true, true, false))
                .parent(midTerm)
                .addCriterion("has_the_pencil", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.RAINBOW_PENCIL.get()))
                .save(saver, BackMath.resourceLoc("backmath/rainbow_pencil"), fileHelper);

        // Mixing Ingots
        Advancement alloyIngots = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_INGOT.get()),
                        Component.translatable("advancements.backmath.mixing_ingots.title"),
                        Component.translatable("advancements.backmath.mixing_ingots.description"),
                        null, FrameType.TASK, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_any_alloy_ingots", InventoryChangeTrigger.TriggerInstance.hasItems(AxolotlTest.DEVIL_ANGELIC_ALLOY_INGOT.get(),
                        AxolotlTest.CHRISTIAN_MID_TERM_DEVIL_ALLOY_INGOT.get(), AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_INGOT.get()))
                .save(saver, BackMath.resourceLoc("backmath/alloy_ingots"), fileHelper);
    }
}
