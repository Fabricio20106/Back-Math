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
import net.minecraft.entity.passive.AnimalEntity;
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

        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        RegistryKey<Biome> backFieldKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, BMBiomes.BACK_FIELD.getId());
        RegistryKey<Biome> originalBackFieldsKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, BMBiomes.ORIGINAL_BACK_FIELDS.getId());
        RegistryKey<Biome> modifiedBackFieldsKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, BMBiomes.MODIFIED_BACK_FIELDS.getId());
        RegistryKey<Biome> angelicWoodsKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, BMBiomes.ANGELIC_WOODS.getId());

        if (BMConfigs.COMMON_CONFIGS.backFieldGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(backFieldKey, 5));
        if (BMConfigs.COMMON_CONFIGS.originalBackFieldsGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(originalBackFieldsKey, 15));
        if (BMConfigs.COMMON_CONFIGS.modifiedBackFieldsGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(modifiedBackFieldsKey, 10));
        if (BMConfigs.COMMON_CONFIGS.angelicWoodsGen.get()) BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(angelicWoodsKey, 12));

        event.enqueueWork(() -> {
            // Entity Spawning, but it now works! I just needed both the old and this new code together instead of deleting the old code.
            if (BMConfigs.COMMON_CONFIGS.groundMobSpawningAljan.get()) {
                EntitySpawnPlacementRegistry.register(BMEntities.INSOMNIA_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.ZOMBIE_FABRICIO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.ALJAMIC_BONES.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.SLEEPISH_SKELETON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.AMARACAMELER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SlimeEntity::canSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.MALAIKA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Malaika::canMalaikaSpawnOn);
            }

            if (BMConfigs.COMMON_CONFIGS.groundMobSpawningBackFields.get()) {
                EntitySpawnPlacementRegistry.register(BMEntities.WANDERER_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::canSophieSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.ARCHER_LUCIA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::canSophieSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.SHY_FABRICIO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::canSophieSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.KARATE_LUCIA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererSophie::canSophieSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.ANGRY_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.INSOMNIA_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
            }
        });

        // Entity Attributes
        GlobalEntityTypeAttributes.put(BMEntities.WANDERER_SOPHIE.get(), WandererSophie.createWandererSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ARCHER_LUCIA.get(), ArcherLucia.createArcherLuciaAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ANGRY_SOPHIE.get(), AngrySophie.createAngrySophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.SHY_FABRICIO.get(), ShyFabricio.createShyFabricioAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.KARATE_LUCIA.get(), KarateLucia.createKarateLuciaAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.INSOMNIA_SOPHIE.get(), InsomniaSophie.createInsomniaSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.QUEEN_LUCY.get(), QueenLucy.createQueenLucyAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.WARRIOR_SOPHIE.get(), WarriorSophie.createWarriorSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.QUEEN_LUCY_PET.get(), QueenLucyPet.createQueenLucyPetAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), ArcherInsomniaSophie.createArcherInsomniaSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.INSOMNIA_ZOMBIE.get(), InsomniaZombie.createInsomniaZombieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ZOMBIE_FABRICIO.get(), ZombieFabricio.createZombieFabricioAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.AMARACAMELER.get(), MonsterEntity.func_234295_eP_().create());
        GlobalEntityTypeAttributes.put(BMEntities.MALAIKA.get(), Malaika.createMalaikaAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.JANTICLE.get(), Janticle.createJanticleAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ALJAMIC_BONES.get(), AljamicBones.createAljamicBonesAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.SLEEPISH_SKELETON.get(), SleepishSkeleton.createSleepishSkeletonAttributes().create());

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
