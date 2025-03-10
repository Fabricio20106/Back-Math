package com.sophicreeper.backmath.event;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.model.FullbrightModel;
import com.sophicreeper.backmath.command.BMDebuggingCommands;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.outfit.OutfitDefinitionManager;
import com.sophicreeper.backmath.entity.renderer.HandArmorRenderer;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMUtils;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import com.sophicreeper.backmath.variant.manager.QueenLucyPetVariantManager;
import com.sophicreeper.backmath.variant.manager.QueenLucyVariantManager;
import com.sophicreeper.backmath.variant.manager.WandererSophieVariantManager;
import com.sophicreeper.backmath.world.carver.BMCarverGeneration;
import com.sophicreeper.backmath.world.dimension.BMDimensions;
import com.sophicreeper.backmath.world.ore.BMOreGeneration;
import com.sophicreeper.backmath.world.plant.BMPlantGeneration;
import com.sophicreeper.backmath.world.structure.BMStructureGeneration;
import com.sophicreeper.backmath.world.structure.BMStructures;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sophicreeper.backmath.BackMath.LOGGER;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID)
public class BMEvents {
    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        if (Minecraft.getInstance().getLaunchedVersion().contains("melony-studios-dev")) BMDebuggingCommands.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void biomeLoadEvent(final BiomeLoadingEvent event) {
        BMOreGeneration.generateOres(event);
        BMOreGeneration.generateAljanstoneOres(event);
        BMOreGeneration.generateSleepingstoneOres(event);
        BMCarverGeneration.generateCarvers(event);
        BMPlantGeneration.generatePlantsAndTrees(event);

        BMStructureGeneration.generateStructures(event);
    }

    @SubscribeEvent
    public static void thickenAljanFogAtNight(EntityViewRenderEvent.FogDensity event) {
        ClientWorld world = Minecraft.getInstance().level;
        if (world != null && ambienceEnabled(world) && BMConfigs.COMMON_CONFIGS.enableAljanFog.get()) {
            event.setCanceled(true);
            double density = BMConfigs.COMMON_CONFIGS.aljanFogDensity.get();
            event.setDensity((float) density);
        }
    }

    @SubscribeEvent
    public static void changeAljanFogColorAtNight(EntityViewRenderEvent.FogColors event) {
        ClientWorld world = Minecraft.getInstance().level;
        if (world != null) {
            int dayTime = (int) (world.getDayTime() % 24000L);
            if (isTimeWithinBounds(dayTime) && ambienceEnabled(world) && BMConfigs.COMMON_CONFIGS.changeAljanFogColorAtNight.get()) {
                BMUtils.transitionFogColor(event, dayTime <= 22300);
            }
        }
    }

    public static boolean ambienceEnabled(ClientWorld world) {
        return world.dimensionType().effectsLocation().equals(BackMath.backMath("the_aljan")) && BMUtils.aljanPackEnabled();
    }

    public static boolean isTimeWithinBounds(long dayTime) {
        return dayTime >= 13300 && dayTime <= 22400;
    }

    @SubscribeEvent
    public static void lowerVisibilityWithHead(LivingEvent.LivingVisibilityEvent event) {
        Item headItem = event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).getItem();
        EntityType<?> type = event.getEntityLiving().getType();
        boolean angrySophie = type == BMEntities.ANGRY_SOPHIE.get() && headItem == AxolotlTest.ANGRY_SOPHIE_HEAD.get();
        boolean insomniaSophie = (type == BMEntities.INSOMNIA_SOPHIE.get() || type == BMEntities.ARCHER_INSOMNIA_SOPHIE.get()) && headItem == AxolotlTest.INSOMNIA_SOPHIE_HEAD.get();
        boolean queenLucy = event.getEntityLiving().getType() == BMEntities.QUEEN_LUCY.get() && headItem == AxolotlTest.QUEEN_LUCY_HEAD.get();
        boolean zombieFabricio = event.getEntityLiving().getType() == BMEntities.ZOMBIE_FABRICIO.get() && headItem == AxolotlTest.ZOMBIE_FABRICIO_HEAD.get();
        if (angrySophie || insomniaSophie || queenLucy || zombieFabricio) event.modifyVisibility(0.5F);
    }

    @SubscribeEvent
    public static void onModelBakeEvent(ModelBakeEvent event) {
        for (BlockState state : BMBlocks.INSOMNIAN_TULIP.get().getStateDefinition().getPossibleStates()) {
            ModelResourceLocation modelLocation = BlockModelShapes.stateToModelLocation(state);
            IBakedModel existingModel = event.getModelRegistry().get(modelLocation);
            if (existingModel == null) {
                LOGGER.warn(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.insomnian_tulip.model_not_found").getString()));
            } else if (existingModel instanceof FullbrightModel) {
                LOGGER.warn(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.light_baked_model.replacement_attempt").getString()));
            } else {
                event.getModelRegistry().put(modelLocation, new FullbrightModel(Sets.newHashSet(BackMath.backMath("block/insomnian_tulip_overlay")), existingModel));
            }
        }
    }

    @SubscribeEvent
    @SuppressWarnings("unchecked")
    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();

            try {
                Method getCodecMethod = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation chunkGeneratorRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) getCodecMethod.invoke(serverWorld.getChunkSource().generator));

                if (chunkGeneratorRL != null && chunkGeneratorRL.getNamespace().equals("terraforged")) return;
            } catch (Exception exception) {
                LogManager.getLogger().error(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.using_terraforged_chunk_generator", serverWorld.dimension().location()).getString()));
            }

            // Prevent spawning our structure in Vanilla's superflat world.
            if (serverWorld.getChunkSource().generator instanceof FlatChunkGenerator && serverWorld.dimension().equals(World.OVERWORLD)) {
                return;
            }
            // Who cares about structures not generating in Superflat?
            // Ok, maybe this was causing issues with Superflat worlds.

            // Adding our structure to the Map.
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(BMStructures.SOPHIE_TOWER.get(), DimensionStructuresSettings.DEFAULTS.get(BMStructures.SOPHIE_TOWER.get()));
            if (!serverWorld.dimension().equals(BMDimensions.THE_ALJAN)) {
                tempMap.putIfAbsent(BMStructures.FABRICIO_HIDEOUT_DUNGEON.get(), DimensionStructuresSettings.DEFAULTS.get(BMStructures.FABRICIO_HIDEOUT_DUNGEON.get()));
            }
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }

    @SubscribeEvent
    public static void addVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CARTOGRAPHER) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();

            // Level 3 "Journeyman"
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.COMPASS), BMUtils.makeBackFieldsExplorerMap(trader),
                    12, 10, 0.2F));
        }
    }

    @SubscribeEvent
    public static void addWanderingTraderTrades(WandererTradesEvent event) {
        List<VillagerTrades.ITrade> genericTrades = event.getGenericTrades();

        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.GUARANA_OAK_SAPLING.get(), 1),
                // Max Trades, XP, Price Multiplier
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.CRYSTALLINE_BIRCH_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.MANGO_OAK_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.MANGAED_MANGO_OAK_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.GRAPE_VINE_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.LEMON_OAK_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.PINEAPPLE_OAK_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.ORANGE_OAK_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.BANANA_JUNGLE_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.ALJAME_BIRCH_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.GUAVA_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.JABUTICABA_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(AxolotlTest.CORK_OAK_SAPLING.get(), 1),
                8, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(AxolotlTest.RED_YELLOW_ALLIUM.get(), 1),
                12, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(AxolotlTest.FRIED_EGG_FLOWER.get(), 1),
                12, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(AxolotlTest.TURTLE_FRIED_EGG_FLOWER.get(), 1),
                12, 1, 0.05F));
        genericTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(AxolotlTest.RED_YELLOW_DYE.get(), 3),
                12, 1, 0.05F));
    }

    @SubscribeEvent
    public static void adjustMiningSpeed(PlayerEvent.BreakSpeed event) {
        if (event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).getItem().is(BMItemTags.CHESTPLATE_MINING_ITEMS)) {
            event.setNewSpeed(event.getOriginalSpeed() + 1.25F);
        }
    }

    @SubscribeEvent
    public static void adjustHarvestLevel(PlayerEvent.HarvestCheck event) {
        if (event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).getItem().is(BMItemTags.CHESTPLATE_MINING_ITEMS)) {
            if (event.getTargetBlock().getHarvestLevel() <= 3) event.setCanHarvest(true);
        }
    }

    @SubscribeEvent
    public static void onResourceReload(AddReloadListenerEvent event) {
        event.addListener(new WandererSophieVariantManager());
        event.addListener(new QueenLucyVariantManager());
        event.addListener(new QueenLucyPetVariantManager());
        event.addListener(new OutfitDefinitionManager());
    }

    @SubscribeEvent
    public static void renderOutfitInArm(RenderArmEvent event) {
        HandArmorRenderer.renderOutfitInArm(event.getPlayer(), event.getArm(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight());
        HandArmorRenderer.renderArmorInArm(event.getPlayer(), event.getArm(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight());
    }
}
