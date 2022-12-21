package com.sophicreeper.backmath.core.proxy;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.sounds.BMSounds;
import com.sophicreeper.backmath.core.world.dimension.BMDimensions;
import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.WandererSophie;
import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import com.sophicreeper.backmath.core.world.entity.decoration.BMMotives;
import com.sophicreeper.backmath.core.world.entity.monster.*;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import com.sophicreeper.backmath.core.world.gen.carver.BMConfiguredCarvers;
import com.sophicreeper.backmath.core.world.gen.carver.BMWorldCarvers;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.item.BMStats;
import com.sophicreeper.backmath.core.world.item.BMVanillaCompatibility;
import com.sophicreeper.backmath.core.world.item.alchemy.BMPotions;
import com.sophicreeper.backmath.core.world.item.integration.mysticalagriculture.BMMysticalAgricultureIntegration;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.material.BMFluids;
import com.sophicreeper.backmath.core.world.structure.BMStructures;
import com.sophicreeper.backmath.core.world.surfacebuilders.BMSurfaceBuilders;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CommonProxy {
    public static final DeferredRegister<Item> MYSTICAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BackMath.MOD_ID);

    CommonProxy() {
        IEventBus bmEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BMBlocks.BLOCKS.register(bmEventBus);
        AxolotlTest.ITEMS.register(bmEventBus);
        BMEntities.ENTITIES.register(bmEventBus);
        if (ModList.get().isLoaded("variants")) {
            AxolotlTest.VARIANTS_COMPAT_ITEMS.register(bmEventBus);
        }
        if (ModList.get().isLoaded("mysticalagriculture")) {
            //BMMysticalAgricultureIntegration.classLoad();
            MYSTICAL_ITEMS.register(bmEventBus);
        }
        BMFluids.FLUIDS.register(bmEventBus);
        BMWorldCarvers.WORLD_CARVERS.register(bmEventBus);
        BMBiomes.BIOMES.register(bmEventBus);
        BMMotives.MOTIVES.register(bmEventBus);
        BMPotions.POTIONS.register(bmEventBus);
        BMStructures.STRUCTURES.register(bmEventBus);
        BMStats.init();
        BMSounds.registerSounds();

        bmEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        RegistryKey<Biome> backFieldsKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, BMBiomes.ORIGINAL_BACK_FIELDS.getId());
        RegistryKey<Biome> modifiedBackFieldsKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, BMBiomes.MODIFIED_BACK_FIELDS.getId());
        RegistryKey<Biome> angelicWoodsKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, BMBiomes.ANGELIC_WOODS.getId());
        if (BMConfigs.SERVER_CONFIGS.originalBackFieldsGen.get()) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(backFieldsKey, 15));
        }
        if (BMConfigs.SERVER_CONFIGS.modifiedBackFieldsGen.get()) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(modifiedBackFieldsKey, 10));
        }
        if (BMConfigs.SERVER_CONFIGS.angelicWoodsGen.get()) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(angelicWoodsKey, 12));
        }

        // Entity Spawning
        EntitySpawnPlacementRegistry.register(BMEntities.INSOMNIA_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, InsomniaZombie::canSpawnIZOn);
        EntitySpawnPlacementRegistry.register(BMEntities.ZOMBIE_FABRICIO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZombieFabricio::canSpawnZFOn);
        EntitySpawnPlacementRegistry.register(BMEntities.ALJAMIC_BONES.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AljamicBones::canSpawnABOn);
        EntitySpawnPlacementRegistry.register(BMEntities.SLEEPISH_SKELETON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SleepishSkeleton::canSpawnSSOn);
        EntitySpawnPlacementRegistry.register(BMEntities.AMARACAMELER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Amaracameler::canSpawnAmaracamelerOn);
        EntitySpawnPlacementRegistry.register(BMEntities.MALAIKA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Malaika::canSpawnMalaikaOn);

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
        GlobalEntityTypeAttributes.put(BMEntities.SLEEPISH_SKELETON.get(), SleepishSkeleton.createSleepishSkeletonAttributes().create());
        BMPotions.addPotionRecipes();
        BMDimensions.init();
        BMConfiguredCarvers.register();
        BMVanillaCompatibility.registerCompatibilities();
        BMSurfaceBuilders.init();
        BMStructures.setupStructures();
    }
}
