package com.sophicreeper.backmath.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BMServerConfigs {
    // World generation
    public final ForgeConfigSpec.BooleanValue devilOreGen;
    public final ForgeConfigSpec.BooleanValue netherDevilOreGen;
    public final ForgeConfigSpec.BooleanValue angelicOreGen;
    public final ForgeConfigSpec.BooleanValue abundantAngelicOreGen;
    public final ForgeConfigSpec.BooleanValue crystallineAngelicOreGen;
    public final ForgeConfigSpec.BooleanValue midTermOreGen;
    public final ForgeConfigSpec.BooleanValue aljameedOreGen;
    public final ForgeConfigSpec.BooleanValue mooneringOreGen;
    public final ForgeConfigSpec.BooleanValue janticOreGen;
    public final ForgeConfigSpec.BooleanValue aljamicHighlandsAbundantJanticOreGen;
    public final ForgeConfigSpec.BooleanValue aljamicCopperGen;
    public final ForgeConfigSpec.BooleanValue aljamicTinGen;

    // Plants
    public final ForgeConfigSpec.BooleanValue grapeVinesInTaigas;
    public final ForgeConfigSpec.BooleanValue bananaJunglesInJungles;
    public final ForgeConfigSpec.BooleanValue turtleFriedEggFlowersInBeaches;

    // Biome generation
    public final ForgeConfigSpec.BooleanValue originalBackFieldsGen;
    public final ForgeConfigSpec.BooleanValue modifiedBackFieldsGen;
    public final ForgeConfigSpec.BooleanValue angelicWoodsGen;

    // Mob spawning
    public final ForgeConfigSpec.BooleanValue wandererSophieSpawn;
    public final ForgeConfigSpec.BooleanValue archerLuciaSpawn;
    public final ForgeConfigSpec.BooleanValue karateLuciaSpawn;
    public final ForgeConfigSpec.BooleanValue angrySophieSpawn;
    public final ForgeConfigSpec.BooleanValue insomniaSophieSpawn;
    public final ForgeConfigSpec.BooleanValue archerInsomniaSophieSpawn;
    public final ForgeConfigSpec.BooleanValue shyFabricioSpawn;
    public final ForgeConfigSpec.BooleanValue insomniaZombieSpawn;
    public final ForgeConfigSpec.BooleanValue zombieFabricioSpawn;
    public final ForgeConfigSpec.BooleanValue amaracamelerSpawn;
    public final ForgeConfigSpec.BooleanValue malaikaSpawn;
    public final ForgeConfigSpec.BooleanValue aljamicBonesSpawn;
    public final ForgeConfigSpec.BooleanValue sleepishSkeletonSpawn;
    public final ForgeConfigSpec.BooleanValue groundMobSpawningBackFields;
    public final ForgeConfigSpec.BooleanValue groundMobSpawningAljan;

    // Gameplay Aspects
    public final ForgeConfigSpec.BooleanValue safeAljan;
    public final ForgeConfigSpec.BooleanValue standingAljanTeleport;
    public final ForgeConfigSpec.BooleanValue peaceTeaInvisibilityToggle;
    public final ForgeConfigSpec.BooleanValue peaceTeaGlowingToggle;

    public BMServerConfigs(ForgeConfigSpec.Builder builder) {
        builder.comment("Welcome to the Back Math configuration file. Created on April 08th and 09th, 2022 and made working on April 21st and 22nd, 2022.");
        builder.push("oreGeneration");
        this.devilOreGen = builder.comment("Allow devil ore generation in the Overworld?").define("devilOreGeneration", true);
        this.netherDevilOreGen = builder.comment("Allow nether devil ore generation in the Nether?").define("netherDevilOreGeneration", true);
        this.angelicOreGen = builder.comment("Allow angelic ore generation?").define("angelicOreGeneration", true);
        this.abundantAngelicOreGen = builder.comment("Allow abundant angelic ore generation in the Angelic Woods?").define("abundantAngelicOreGeneration", true);
        this.crystallineAngelicOreGen = builder.comment("Allow crystalline angelic ore generation in the Angelic Woods?").define("crystallineAngelicOreGeneration", true);
        this.midTermOreGen = builder.comment("Allow mid-term ore to generate in the end?").define("midTermOreGeneration", false);
        builder.comment("Aljan Ore Generation");
        this.aljameedOreGen = builder.comment("Allow aljameed ore to generate in the aljan?").define("aljameedOreGeneration", true);
        this.mooneringOreGen = builder.comment("Allow moonering ore to generate in the aljan?").define("mooneringOreGeneration", true);
        this.janticOreGen = builder.comment("Allow jantic ore to generate in the aljan?").define("janticOreGen", true);
        this.aljamicHighlandsAbundantJanticOreGen = builder.comment("Allow abundant jantic ore to generate in the Aljamic Highlands?").define("aljamicHighlAbundantJanticOreGeneration", true);
        this.aljamicCopperGen = builder.comment("Allow aljamic copper ore to generate in the aljan?").define("aljamicCopperOreGeneration", true);
        this.aljamicTinGen = builder.comment("Allow aljamic tin ore to generate in the aljan?").define("aljamicTinOreGeneration", true);
        builder.pop();

        builder.push("featureGeneration");
        this.grapeVinesInTaigas = builder.comment("Allow grape vines to generate in any biome categorized as a taiga?").define("grapeVinesInTaiga", true);
        this.bananaJunglesInJungles = builder.comment("Allow banana jungles to generate in any biome categorized as a jungle?").define("bananaJunglesInJungles", true);
        this.turtleFriedEggFlowersInBeaches = builder.comment("Allow turtle fried egg flowers to generate in any biome categorized as a beach?").define("turtleFriedEggFlowersInBeaches", true);
        builder.pop();

        builder.push("biomeGeneration");
        this.originalBackFieldsGen = builder.comment("Allow the original back fields to generate?").define("originalBackFieldsGeneration", true);
        this.modifiedBackFieldsGen = builder.comment("Allow the modified back fields to generate?").define("modifiedBackFieldsGeneration", true);
        this.angelicWoodsGen = builder.comment("Allow angelic wood forests to generate?").define("angelicWoodsGeneration", true);
        builder.pop();

        builder.push("mobSpawning");
        this.wandererSophieSpawn = builder.comment("Allow wanderer Sophies to spawn in back fields?").define("wandererSophieSpawning", true);
        this.angrySophieSpawn = builder.comment("Allow angry Sophies to spawn in back fields?").define("angrySophieSpawn", true);
        this.shyFabricioSpawn = builder.comment("Allow shy Fabricios to spawn in back fields?").define("shyFabricioSpawning", true);
        this.archerLuciaSpawn = builder.comment("Allow archer Lucias to spawn in back fields?").define("archerLuciaSpawning", true);
        this.karateLuciaSpawn = builder.comment("Allow karate Lucias to spawn in back fields?").define("karateLuciaSpawning", true);
        this.insomniaSophieSpawn = builder.comment("Allow insomnia Sophies to spawn in back fields?").define("insomniaSophieSpawning", true);
        this.archerInsomniaSophieSpawn = builder.comment("Allow archer insomnia Sophies to spawn in back fields?").define("archerInsomniaSophieSpawning", true);
        builder.comment("Aljan Mobs Spawning:");
        this.insomniaZombieSpawn = builder.comment("Allow insomnia zombies to spawn in the aljan?").define("insomniaZombieSpawning", true);
        this.zombieFabricioSpawn = builder.comment("Allow zombie Fabricios to spawn in the aljan?").define("zombieFabricioSpawning", true);
        this.aljamicBonesSpawn = builder.comment("Allow aljamic bones' to spawn in the aljan?").define("aljamicBonesSpawning", true);
        this.sleepishSkeletonSpawn = builder.comment("Allow sleepish skeletons to spawn in the aljan?").define("sleepishSkeletonSpawning", true);
        this.amaracamelerSpawn = builder.comment("Allow amaracamelers to spawn in amaracamel sticks?").define("amaracamelerSpawning", true);
        this.malaikaSpawn = builder.comment("Allow malaikas to spawn in the aljan?").define("malaikaSpawn", true);
        builder.comment("Mob Spawning:");
        this.groundMobSpawningBackFields = builder.comment("Make it so that Back Fields mobs spawn in the ground and not on top of leaves or air. Disable for old behaviour.").define("groundMobSpawning.backFields", true);
        this.groundMobSpawningAljan = builder.comment("Make it so that aljan mobs spawn in the ground and not on top of leaves or air.").define("groundMobSpawning.aljan", true);
        builder.pop();

        builder.push("gameplayAspects");
        this.safeAljan = builder.comment("When you teleport to the Aljan through the Aljan Portal Stand, the stand on the other side will already have a jantical in it.").define("safeAljan", false);
        this.standingAljanTeleport = builder.comment("When turned on, you'll be able to stand besides the portal stand and be teleported over.").define("standingAljanTeleport", true);
        this.peaceTeaInvisibilityToggle = builder.comment("Makes peace teas give you or the affected mob Invisibility.").define("peaceTea.invisibilityToggle", false);
        this.peaceTeaGlowingToggle = builder.comment("Makes peace teas give you or the affected mob Glowing.").define("peaceTea.glowingToggle", false);
        builder.pop();
    }
}
