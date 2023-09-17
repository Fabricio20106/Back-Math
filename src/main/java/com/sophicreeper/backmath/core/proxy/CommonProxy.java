package com.sophicreeper.backmath.core.proxy;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.dimension.BMDimensions;
import com.sophicreeper.backmath.core.world.effect.BMMobEffects;
import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.entity.decoration.BMMotives;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.item.BMCreativeTabs;
import com.sophicreeper.backmath.core.world.item.alchemy.BMPotions;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.fluid.BMFluidTypes;
import com.sophicreeper.backmath.core.world.level.fluid.BMFluids;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

public class CommonProxy {
    CommonProxy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BMCreativeTabs.TABS.register(eventBus);
        BMBlocks.BLOCKS.register(eventBus);
        AxolotlTest.ITEMS.register(eventBus);
        BMEntities.ENTITIES.register(eventBus);
        BMMobEffects.MOB_EFFECTS.register(eventBus);
        //BMConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        //BMPlacedFeatures.PLACED_FEATURES.register(eventBus);
        BMFluidTypes.FLUID_TYPES.register(eventBus);
        BMFluids.FLUIDS.register(eventBus);
        //BMWorldCarvers.WORLD_CARVERS.register(eventBus);
        //BMBiomes.BIOMES.register(eventBus);
        BMMotives.MOTIVES.register(eventBus);
        BMPotions.POTIONS.register(eventBus);
        //BMStructures.STRUCTURES.register(eventBus);
        //BMStats.init();
        //BMSounds.registerSounds();

        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        //ResourceKey<Biome> originalBackFieldsKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BMBiomes.ORIGINAL_BACK_FIELDS.registry());
        ResourceKey<Biome> originalBackFieldsKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BackMath.resourceLoc("original_back_fields"));
        //ResourceKey<Biome> modifiedBackFieldsKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BMBiomes.MODIFIED_BACK_FIELDS.getId());
        //ResourceKey<Biome> angelicWoodsKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BMBiomes.ANGELIC_WOODS.getId());

        //if (BMConfigs.SERVER_CONFIGS.originalBackFieldsGen.get()) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(originalBackFieldsKey, 15));
        /*}
        if (BMConfigs.SERVER_CONFIGS.modifiedBackFieldsGen.get()) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(modifiedBackFieldsKey, 10));
        }
        if (BMConfigs.SERVER_CONFIGS.angelicWoodsGen.get()) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(angelicWoodsKey, 12));
        }*/

        /*event.enqueueWork(() -> {
            // Entity spawning, but it now works! I just needed both the old and this new code together instead of deleting the old code.
            if (BMConfigs.SERVER_CONFIGS.groundMobSpawningAljan.get()) {
                EntitySpawnPlacementRegistry.register(BMEntities.INSOMNIA_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.ZOMBIE_FABRICIO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.ALJAMIC_BONES.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.SLEEPISH_SKELETON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.AMARACAMELER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SlimeEntity::canSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.MALAIKA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
            }

            if (BMConfigs.SERVER_CONFIGS.groundMobSpawningBackFields.get()) {
                EntitySpawnPlacementRegistry.register(BMEntities.WANDERER_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.ARCHER_LUCIA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.SHY_FABRICIO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.KARATE_LUCIA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
                EntitySpawnPlacementRegistry.register(BMEntities.ANGRY_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.INSOMNIA_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
                EntitySpawnPlacementRegistry.register(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
            }
        });

        // Entity attributes
        GlobalEntityTypeAttributes.put(BMEntities.WANDERER_SOPHIE.get(), WandererSophie.createWandererSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ARCHER_LUCIA.get(), ArcherLucia.createArcherLuciaAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ANGRY_SOPHIE.get(), AngrySophie.createAngrySophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.SHY_FABRICIO.get(), ShyFabricio.createShyFabricioAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.KARATE_LUCIA.get(), KarateLucia.createKarateLuciaAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.INSOMNIA_SOPHIE.get(), InsomniaSophie.createInsomniaSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.QUEEN_SOPHIE.get(), QueenSophie.createQueenSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.WARRIOR_SOPHIE.get(), WarriorSophie.createWarriorSophieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.QUEEN_SOPHIE_PET.get(), QueenSophiePet.createQueenSophiePetAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), ArcherInsomniaSophie.createMobAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.INSOMNIA_ZOMBIE.get(), InsomniaZombie.createInsomniaZombieAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ZOMBIE_FABRICIO.get(), ZombieFabricio.createZombieFabricioAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.AMARACAMELER.get(), MonsterEntity.func_234295_eP_().create());
        GlobalEntityTypeAttributes.put(BMEntities.MALAIKA.get(), Malaika.createMalaikaAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.JANTICLE.get(), Janticle.createJanticleAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.ALJAMIC_BONES.get(), AljamicBones.createAljamicBonesAttributes().create());
        GlobalEntityTypeAttributes.put(BMEntities.SLEEPISH_SKELETON.get(), SleepishSkeleton.createSleepishSkeletonAttributes().create());*/

        // Other things to load
        BMPotions.addPotionRecipes();
        BMDimensions.init();
        //BMConfiguredCarvers.register();
        //BMVanillaCompatibility.registerCompatibilities();
        //BMSurfaceBuilders.init();
        //BMStructures.setupStructures();
    }
}
