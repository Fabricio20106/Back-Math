package com.sophicreeper.backmath.core.util;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class BMSmithingTemplateComponents {
    public static final Component MID_TERM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", BackMath.resourceLoc("mid_term_upgrade"))).withStyle(ChatFormatting.GRAY);
    public static final Component MID_TERM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.mid_term_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE);
    public static final Component MID_TERM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.mid_term_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE);
    public static final Component MID_TERM_UPGRADE_BASE_SLOT_DESC = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.mid_term_upgrade.base_slot_description"))).withStyle(ChatFormatting.GRAY);
    public static final Component MID_TERM_UPGRADE_ADDITIONS_SLOT_DESC = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.mid_term_upgrade.additions_slot_description"))).withStyle(ChatFormatting.GRAY);
    public static final Component OBSIDIAN_INFUSED_MID_TERM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", BackMath.resourceLoc("obsidian_infused_mid_term_upgrade"))).withStyle(ChatFormatting.GRAY);
    public static final Component OBSIDIAN_INFUSED_MID_TERM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.obsidian_infused_mid_term_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE);
    public static final Component OBSIDIAN_INFUSED_MID_TERM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.obsidian_infused_mid_term_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE);
    public static final Component OBSIDIAN_INFUSED_MID_TERM_UPGRADE_BASE_SLOT_DESC = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.obsidian_infused_mid_term_upgrade.base_slot_description"))).withStyle(ChatFormatting.GRAY);
    public static final Component OBSIDIAN_INFUSED_MID_TERM_UPGRADE_ADDITIONS_SLOT_DESC = Component.translatable(Util.makeDescriptionId("item", BackMath.resourceLoc("smithing_template.obsidian_infused_mid_term_upgrade.additions_slot_description"))).withStyle(ChatFormatting.GRAY);

    public static final ResourceLocation EMPTY_SLOT_WARRIOR_HELMET = BackMath.resourceLoc("item/empty_slot_warrior_helmet");
    public static final ResourceLocation EMPTY_SLOT_SPAREY = BackMath.resourceLoc("item/empty_slot_sparey");
    public static final ResourceLocation EMPTY_SLOT_KNIFE = BackMath.resourceLoc("item/empty_slot_knife");
    public static final ResourceLocation EMPTY_SLOT_SHEARS = BackMath.resourceLoc("item/empty_slot_shears");
    public static final ResourceLocation EMPTY_SLOT_BOW = BackMath.resourceLoc("item/empty_slot_bow");
    public static final ResourceLocation EMPTY_SLOT_CROWN = BackMath.resourceLoc("item/empty_slot_crown");
    public static final ResourceLocation EMPTY_SLOT_MID_TERM = BackMath.resourceLoc("item/empty_slot_mid_term");

    // Copied from SmithingTemplateItem
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");

    public static SmithingTemplateItem createMidTermUpgradeTemplate() {
        return new SmithingTemplateItem(MID_TERM_UPGRADE_APPLIES_TO, MID_TERM_UPGRADE_INGREDIENTS, MID_TERM_UPGRADE, MID_TERM_UPGRADE_BASE_SLOT_DESC,
                MID_TERM_UPGRADE_ADDITIONS_SLOT_DESC, createMidTermUpgradeIconList(), createMidTermUpgradeMaterialList());
    }

    public static SmithingTemplateItem createObsidianInfusedMidTermUpgradeTemplate() {
        return new SmithingTemplateItem(OBSIDIAN_INFUSED_MID_TERM_UPGRADE_APPLIES_TO, OBSIDIAN_INFUSED_MID_TERM_UPGRADE_INGREDIENTS, OBSIDIAN_INFUSED_MID_TERM_UPGRADE, OBSIDIAN_INFUSED_MID_TERM_UPGRADE_BASE_SLOT_DESC,
                OBSIDIAN_INFUSED_MID_TERM_UPGRADE_ADDITIONS_SLOT_DESC, createOIMTUpgradeIconList(), createMidTermUpgradeMaterialList());
    }

    private static List<ResourceLocation> createMidTermUpgradeIconList() {
        return List.of(EMPTY_SLOT_CROWN, EMPTY_SLOT_WARRIOR_HELMET, EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_SPAREY, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_KNIFE, EMPTY_SLOT_SHEARS, EMPTY_SLOT_BOW);
    }

    private static List<ResourceLocation> createOIMTUpgradeIconList() {
        return List.of(EMPTY_SLOT_WARRIOR_HELMET, EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_SPAREY, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_KNIFE, EMPTY_SLOT_SHEARS);
    }

    private static List<ResourceLocation> createMidTermUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT, EMPTY_SLOT_MID_TERM);
    }
}
