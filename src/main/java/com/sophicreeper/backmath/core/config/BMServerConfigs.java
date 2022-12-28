package com.sophicreeper.backmath.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BMServerConfigs {
    // World generation
    public final ForgeConfigSpec.BooleanValue midTermOreGen;
    public final ForgeConfigSpec.BooleanValue devilOreGen;
    public final ForgeConfigSpec.BooleanValue angelicOreGen;
    public final ForgeConfigSpec.BooleanValue abundantAngelicOreGen;
    public final ForgeConfigSpec.BooleanValue crystallineAngelicOreGen;
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

    // Gameplay Aspects
    public final ForgeConfigSpec.BooleanValue safeAljan;

    public BMServerConfigs(ForgeConfigSpec.Builder builder) {
        builder.comment("Welcome to the Back Math configurations file. Created in 08th and 09th of April of 2022 and made working on 21st and 22nd of April of 2022.");
        builder.push("oregen");
        this.devilOreGen = builder.comment("Allow devil ore generation in both overworld and the nether?").define("devilOreGen", true);
        this.angelicOreGen = builder.comment("Allow angelic ore generation?").define("angelicOreGen", true);
        this.abundantAngelicOreGen = builder.comment("Allow abundant angelic ore generation in the Angelic Woods?").define("abundantAngelicOreGen", true);
        this.crystallineAngelicOreGen = builder.comment("Allow crystalline angelic ore generation in the Angelic Woods?").define("crystallineAngelicOreGen", true);
        this.midTermOreGen = builder.comment("Allow mid-term ore to generate in the end?").define("midTermOreGen", false);
        this.aljameedOreGen = builder.comment("Allow aljameed ore to generate in the aljan?").define("aljameedOreGen", true);
        this.mooneringOreGen = builder.comment("Allow moonering ore to generate in the aljan?").define("mooneringOreGen", true);
        this.janticOreGen = builder.comment("Allow jantic ore to generate in the aljan?").define("janticOreGen", true);
        this.aljamicHighlandsAbundantJanticOreGen = builder.comment("Allow abundant jantic ore to generate in the Aljamic Highlands?").define("aljamicHighlandsAbundantJanticOreGen", true);
        this.aljamicCopperGen = builder.comment("Allow aljamic copper ore to generate in the aljan?").define("aljamicCopperOreGen", true);
        this.aljamicTinGen = builder.comment("Allow aljamic tin ore to generate in the aljan?").define("aljamicTinOreGen", true);
        builder.pop();

        builder.push("featuregen");
        this.grapeVinesInTaigas = builder.comment("Allow grape vines to generate in any biome categorized as a taiga?").define("grapeVinesInTaiga", true);
        this.bananaJunglesInJungles = builder.comment("Allow banana jungles to generate in any biome categorized as a jungle?").define("bananaJunglesInJungles", true);
        this.turtleFriedEggFlowersInBeaches = builder.comment("Allow turtle fried egg flowers to generate in any biome categorized as a beach?").define("turtleFriedEggFlowersInBeaches", true);
        builder.pop();

        builder.push("biomegen");
        this.originalBackFieldsGen = builder.comment("Allow the original back fields to generate?").define("originalBackFieldsGen", true);
        this.modifiedBackFieldsGen = builder.comment("Allow the modified back fields to generate?").define("modifiedBackFieldsGen", true);
        this.angelicWoodsGen = builder.comment("Allow angelic wood forests to generate?").define("angelicWoodsGen", true);
        builder.pop();

        builder.push("mobspawns");
        this.wandererSophieSpawn = builder.comment("Allow wanderer Sophies to spawn in back fields?").define("wandererSophieSpawn", true);
        this.angrySophieSpawn = builder.comment("Allow angry Sophies to spawn in back fields?").define("angrySophieSpawn", true);
        this.shyFabricioSpawn = builder.comment("Allow shy Fabricios to spawn in back fields?").define("shyFabricioSpawn", true);
        this.archerLuciaSpawn = builder.comment("Allow archer Lucias to spawn in back fields?").define("archerLuciaSpawn", true);
        this.karateLuciaSpawn = builder.comment("Allow karate Lucias to spawn in back fields?").define("karateLuciaSpawn", true);
        this.insomniaSophieSpawn = builder.comment("Allow insomnia Sophies to spawn in back fields?").define("insomniaSophieSpawn", true);
        this.archerInsomniaSophieSpawn = builder.comment("Allow archer insomnia Sophies to spawn in back fields?").define("archerInsomniaSophieSpawn", true);
        builder.comment("The Aljan mobs below");
        this.insomniaZombieSpawn = builder.comment("Allow insomnia zombies to spawn in the aljan?").define("insomniaZombieSpawn", true);
        this.zombieFabricioSpawn = builder.comment("Allow zombie Fabricios to spawn in the aljan?").define("zombieFabricioSpawn", true);
        this.aljamicBonesSpawn = builder.comment("Allow aljamic boneses to spawn in the aljan?").define("aljamicBonesSpawn", true);
        this.sleepishSkeletonSpawn = builder.comment("Allow sleepish skeletons to spawn in the aljan?").define("sleepihSkeletonSpawn", true);
        this.amaracamelerSpawn = builder.comment("Allow amaracamelers to spawn in amaracamel sticks?").define("amaracamelerSpawn", true);
        this.malaikaSpawn = builder.comment("Allow malaikas to spawn in the aljan?").define("malaikaSpawn", true);
        builder.pop();

        builder.push("gameplayAspects");
        this.safeAljan = builder.comment("When you teleport to the Aljan through the Aljan Portal Stand, the stand on the other side will already have a jantical in it.").define("safeAljan", false);
        builder.pop();
    }
}
