package com.sophicreeper.backmath.data.models;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public abstract class BMItemModelModels extends ItemModelProvider {
    private final ModelFile generated = getExistingFile(mcLoc("item/generated"));

    public BMItemModelModels(DataGenerator generator, String modID, ExistingFileHelper fileHelper) {
        super(generator, modID, fileHelper);
    }

    public void standard(ModelFile parent, String name) {
        getBuilder(name).parent(parent).texture("layer0", "item/" + name);
    }

    public void toolSet(ModelFile parent, String material, boolean milkedSword, String... toolNames) {
        if (milkedSword) {
            if (toolNames[0].equals("_blade")) {
                getBuilder("milked_" + material + toolNames[0]).parent(parent).texture("layer0", "item/" + material + toolNames[0]).texture("layer1", "item/milked_aljameed_blade_base");
            } else if (toolNames[0].contains("sparey")) {
                getBuilder("milked_" + material + toolNames[0]).parent(parent).texture("layer0", "item/" + material + toolNames[0]).texture("layer1", "item/milked_sparey_base");
            } else {
                getBuilder("milked_" + material + toolNames[0]).parent(parent).texture("layer0", "item/" + material + toolNames[0]).texture("layer1", "item/milked" + toolNames[0] + "_base");
            }
        }
        getBuilder(material + toolNames[0]).parent(parent).texture("layer0", "item/" + material + toolNames[0]);
        getBuilder(material + toolNames[1]).parent(parent).texture("layer0", "item/" + material + toolNames[1]);
        getBuilder(material + toolNames[2]).parent(parent).texture("layer0", "item/" + material + toolNames[2]);
        getBuilder(material + toolNames[3]).parent(parent).texture("layer0", "item/" + material + toolNames[3]);
        getBuilder(material + toolNames[4]).parent(parent).texture("layer0", "item/" + material + toolNames[4]);
    }

    public void toolSet(ModelFile parent, String material, boolean milkedSword) {
        toolSet(parent, material, milkedSword, "_sword", "_pickaxe", "_shovel", "_axe", "_hoe");
    }

    public void armorSet(ModelFile parent, String material, boolean isBreastplate, boolean hasWarriorHelmet) {
        getBuilder(material + "_helmet").parent(parent).texture("layer0", "item/" + material + "_helmet");
        if (hasWarriorHelmet) getBuilder(material + "_warrior_helmet").parent(parent).texture("layer0", "item/" + material + "_warrior_helmet");
        getBuilder(material + (isBreastplate ? "_breastplate" : "_chestplate")).parent(parent).texture("layer0", "item/" + material + (isBreastplate ? "_breastplate" : "_chestplate"));
        getBuilder(material + "_leggings").parent(parent).texture("layer0", "item/" + material + "_leggings");
        getBuilder(material + "_boots").parent(parent).texture("layer0", "item/" + material + "_boots");
    }

    public void queenLucyShirts(ModelFile parent, String... shirtDesigns) {
        for (String design : shirtDesigns) getBuilder("queen_lucy_shirt_" + design).parent(parent).texture("layer0", "item/queen_lucy_shirt_" + design);
    }

    public void oneTextureCrowns(String... crowns) {
        for (String crown : crowns) {
            getBuilder(crown + "_crown").parent(getExistingFile(modLoc("item/template_crown"))).texture("crown", "item/crown/" + crown + "_crown");
        }
    }

    public void twoTextureCrowns(String... crowns) {
        for (String crown : crowns) {
            getBuilder(crown + "_crown").parent(getExistingFile(modLoc("item/template_two_texture_crown"))).texture("crown_a", "item/crown/" + crown + "_crown_a").texture("crown_b", "item/crown/" + crown + "_crown_b");
        }
    }

    public void swordWithMilked(ModelFile parent, String sword, boolean sparey) {
        getBuilder(sword).parent(parent).texture("layer0", "item/" + sword);
        getBuilder("milked_" + sword).parent(parent).texture("layer0", "item/" + sword).texture("layer1", "item/milked_" + (sparey ? "sparey" : "sword") + "_base");
    }

    public void vanillaMilkedSword(ModelFile parent, String sword) {
        getBuilder("milked_" + sword).parent(parent).texture("layer0", mcLoc("item/" + sword)).texture("layer1", modLoc("item/milked_sword_base"));
    }

    public void block(String name) {
        withExistingParent(name, modLoc("block/" + name));
    }

    public void block(String name, String extras) {
        withExistingParent(name, modLoc("block/" + name + extras));
    }

    public void blockItem(String name) {
        getBuilder(name).parent(this.generated).texture("layer0", "block/" + name);
    }

    public void blockItem(String name, String extras) {
        getBuilder(name).parent(this.generated).texture("layer0", "block/" + name + extras);
    }

    public void glassPane(String name) {
        getBuilder(name + "_pane").parent(this.generated).texture("layer0", "block/" + name);
    }

    public void grapeVinePost(String woodName) {
        withExistingParent(woodName + "_grape_vine_post", modLoc("block/grape_vine_posts/" + woodName));
    }

    public void notebook(String name, String bottom, String screen, String keyboard) {
        getBuilder(name).parent(getExistingFile(modLoc("item/template_notebook"))).texture("bottom", "block/" + bottom).texture("screen", "block/" + screen).texture("keyboard", "block/" + keyboard);
    }

    public void stuffedNotebook(String name, String bottom, String screen, String keyboard, String inner) {
        getBuilder(name).parent(getExistingFile(modLoc("item/template_stuffed_cookie_notebook"))).texture("bottom", "block/" + bottom).texture("screen", "block/" + screen).texture("keyboard", "block/" + keyboard)
                .texture("inner", "block/" + inner);
    }
}
