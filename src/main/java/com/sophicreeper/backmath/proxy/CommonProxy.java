package com.sophicreeper.backmath.proxy;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.BMFluids;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.effect.BMEffects;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.*;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.BMSpawnEggItem;
import com.sophicreeper.backmath.item.custom.potion.BMPotions;
import com.sophicreeper.backmath.item.custom.weapon.misc.QueenLucySummonerStaffItem;
import com.sophicreeper.backmath.misc.BMMotives;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.misc.BMStats;
import com.sophicreeper.backmath.util.BMVanillaCompatibility;
import com.sophicreeper.backmath.world.biome.BMBiomes;
import com.sophicreeper.backmath.world.carver.BMConfiguredCarvers;
import com.sophicreeper.backmath.world.carver.BMWorldCarvers;
import com.sophicreeper.backmath.world.dimension.BMDimensions;
import com.sophicreeper.backmath.world.feature.BMFeature;
import com.sophicreeper.backmath.world.structure.BMStructures;
import com.sophicreeper.backmath.world.surface.BMSurfaceBuilders;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

public class CommonProxy {
    CommonProxy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BMBlocks.BLOCKS.register(eventBus);
        AxolotlTest.ITEMS.register(eventBus);
        BMEntities.ENTITIES.register(eventBus);
        BMEffects.EFFECTS.register(eventBus);
        BMFluids.FLUIDS.register(eventBus);
        BMFeature.FEATURES.register(eventBus);
        BMWorldCarvers.WORLD_CARVERS.register(eventBus);
        BMBiomes.BIOMES.register(eventBus);
        BMMotives.MOTIVES.register(eventBus);
        BMPotions.POTIONS.register(eventBus);
        BMStructures.STRUCTURES.register(eventBus);
        BMStats.init();
        BMSounds.registerSounds();
        new BMFeature();

        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        RegistryKey<Biome> backFieldKey = RegistryKey.create(ForgeRegistries.Keys.BIOMES, BMBiomes.BACK_FIELD.getId());
        RegistryKey<Biome> originalBackFieldsKey = RegistryKey.create(ForgeRegistries.Keys.BIOMES, BMBiomes.ORIGINAL_BACK_FIELDS.getId());
        RegistryKey<Biome> modifiedBackFieldsKey = RegistryKey.create(ForgeRegistries.Keys.BIOMES, BMBiomes.MODIFIED_BACK_FIELDS.getId());
        RegistryKey<Biome> angelicWoodsKey = RegistryKey.create(ForgeRegistries.Keys.BIOMES, BMBiomes.ANGELIC_WOODS.getId());

        if (BMConfigs.COMMON_CONFIGS.backFieldGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(backFieldKey, 5));
        if (BMConfigs.COMMON_CONFIGS.originalBackFieldsGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(originalBackFieldsKey, 15));
        if (BMConfigs.COMMON_CONFIGS.modifiedBackFieldsGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(modifiedBackFieldsKey, 10));
        if (BMConfigs.COMMON_CONFIGS.angelicWoodsGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(angelicWoodsKey, 12));

        event.enqueueWork(() -> {
            // Entity Spawning, but it now works! I just needed both the old and this new code together instead of deleting the old code.
            if (BMConfigs.COMMON_CONFIGS.groundMobSpawningAljan.get()) {
                EntitySpawnPlacementRegistry.register(BMEntities.INSOMNIA_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.ZOMBIE_FABRICIO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.ALJAMIC_BONES.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.SLEEPISH_SKELETON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.AMARACAMELER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Amaracameler::checkAmaracamelerSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.MALAIKA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Malaika::checkMalaikaSpawnRules);
            }

            if (BMConfigs.COMMON_CONFIGS.groundMobSpawningBackFields.get()) {
                EntitySpawnPlacementRegistry.register(BMEntities.WANDERER_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::checkSophieSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.ARCHER_LUCIA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::checkSophieSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.SHY_FABRICIO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::checkSophieSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.KARATE_LUCIA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::checkSophieSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.ANGRY_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.INSOMNIA_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
                EntitySpawnPlacementRegistry.register(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
            }
        });

        // Entity Attributes
        GlobalEntityTypeAttributes.put(BMEntities.WANDERER_SOPHIE.get(), WandererSophie.createWandererSophieAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.ARCHER_LUCIA.get(), ArcherLucia.createArcherLuciaAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.ANGRY_SOPHIE.get(), AngrySophie.createAngrySophieAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.SHY_FABRICIO.get(), ShyFabricio.createShyFabricioAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.KARATE_LUCIA.get(), KarateLucia.createKarateLuciaAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.INSOMNIA_SOPHIE.get(), InsomniaSophie.createInsomniaSophieAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.QUEEN_LUCY.get(), QueenLucy.createQueenLucyAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.WARRIOR_SOPHIE.get(), WarriorSophie.createWarriorSophieAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.QUEEN_LUCY_PET.get(), QueenLucyPet.createQueenLucyPetAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), ArcherInsomniaSophie.createArcherInsomniaSophieAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.INSOMNIA_ZOMBIE.get(), InsomniaZombie.createInsomniaZombieAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.ZOMBIE_FABRICIO.get(), ZombieFabricio.createZombieFabricioAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.AMARACAMELER.get(), MonsterEntity.createMonsterAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.MALAIKA.get(), Malaika.createMalaikaAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.JANTICLE.get(), Janticle.createJanticleAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.ALJAMIC_BONES.get(), AljamicBones.createAljamicBonesAttributes().build());
        GlobalEntityTypeAttributes.put(BMEntities.SLEEPISH_SKELETON.get(), SleepishSkeleton.createSleepishSkeletonAttributes().build());

        // Other Things to Load
        BMPotions.addPotionRecipes();
        BMDimensions.init();
        BMConfiguredCarvers.init();
        BMVanillaCompatibility.initCompats();
        BMSurfaceBuilders.init();
        BMStructures.setupStructures();

        // Spawn Eggs
        BMSpawnEggItem.initBackMathEggs();
        QueenLucySummonerStaffItem.initQueenLucyPet();
    }
}
