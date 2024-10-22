package com.sophicreeper.backmath.util;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.entity.custom.WandererSophieEntity;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMRegistries;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import com.sophicreeper.backmath.world.structure.BMStructures;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;
import net.minecraftforge.client.event.EntityViewRenderEvent;

import java.util.*;

// Just generalized methods that are used more than twice throughout the code.
public class BMUtils {
    private static final List<String> VALID_WOOD_TYPES = Lists.newArrayList("aljanwood", "aljancap", "insomnian", "avondalic_willow");
    public static final Style EXPERIENCE = Style.EMPTY.withColor(Color.fromRgb(8453920));
    public static final int END_PORTAL_OPEN = 1038;
    private static final float[] FOG_COLORS = new float[3];
    private static float COLOR = 0;

    // Plays the item pickup sound at a (server) player.
    public static void playItemPickupSound(ServerPlayerEntity serverPlayer) {
        float pitch = ((serverPlayer.getRandom().nextFloat() - serverPlayer.getRandom().nextFloat()) * 0.7F + 1) + 2;
        serverPlayer.level.playSound(null, serverPlayer.blockPosition(), SoundEvents.ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, pitch);
    }

    // Adds the Bakugou armor set to the (server) player.
    // Used to replace the armor entirely.
    public static void addBakugouArmor(ServerPlayerEntity serverPlayer) {
        if (serverPlayer.getItemBySlot(EquipmentSlotType.HEAD).isEmpty()) {
            serverPlayer.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()));
        }
        if (serverPlayer.getItemBySlot(EquipmentSlotType.CHEST).isEmpty()) {
            serverPlayer.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.BAKUGOU_BLOUSE.get()));
        }
        if (serverPlayer.getItemBySlot(EquipmentSlotType.LEGS).isEmpty()) {
            serverPlayer.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.BAKUGOU_PANTS.get()));
        }
        if (serverPlayer.getItemBySlot(EquipmentSlotType.FEET).isEmpty()) {
            serverPlayer.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.BAKUGOU_SHOES.get()));
        }
    }

    // Returns a Back Fields Explorer Map. Used by cartographer villagers.
    public static ItemStack makeBackFieldsExplorerMap(Entity trader) {
        if (trader.level instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) trader.level;
            BlockPos structurePos = serverWorld.findNearestMapFeature(BMStructures.SOPHIE_TOWER.get(), trader.blockPosition(), 100, true);
            if (structurePos != null) {
                ItemStack mapStack = FilledMapItem.create(serverWorld, structurePos.getX(), structurePos.getZ(), (byte) 2, true, true);
                FilledMapItem.renderBiomePreviewMap(serverWorld, mapStack);
                MapData.addTargetDecoration(mapStack, structurePos, "+", MapDecoration.Type.TARGET_X);
                mapStack.setHoverName(new TranslationTextComponent("filled_map." + BMStructures.SOPHIE_TOWER.get().getFeatureName().toLowerCase(Locale.ROOT)));
                CompoundNBT displayTag = mapStack.getOrCreateTagElement("display");
                displayTag.putInt("MapColor", 4007551);
                return mapStack;
            } else {
                return new ItemStack(Items.MAP);
            }
        }
        return new ItemStack(Items.MAP);
    }

    // Returns a Termian Empire Banner. Used by termian patrollers.
    public static ItemStack getTermianBannerInstance() {
        ItemStack lightBlueBanner = new ItemStack(Items.LIGHT_BLUE_BANNER);
        CompoundNBT blockEntityTag = lightBlueBanner.getOrCreateTagElement("BlockEntityTag");
        ListNBT patterns = new BannerPattern.Builder().addPattern(BannerPattern.GRADIENT_UP, DyeColor.PURPLE).addPattern(BannerPattern.STRIPE_CENTER, DyeColor.LIGHT_BLUE).addPattern(
                BannerPattern.RHOMBUS_MIDDLE, DyeColor.CYAN).addPattern(BannerPattern.FLOWER, DyeColor.RED).addPattern(BannerPattern.FLOWER, DyeColor.YELLOW).toListTag();
        blockEntityTag.put("Patterns", patterns);
        lightBlueBanner.hideTooltipPart(ItemStack.TooltipDisplayFlags.ADDITIONAL);
        lightBlueBanner.setHoverName(new TranslationTextComponent("block." + BackMath.MOD_ID + ".termian_empire_banner").withStyle(Style.EMPTY.withColor(Color.fromRgb(0x1DC2D1)).withItalic(false)));
        return lightBlueBanner;
    }

    // Returns the resource location for a Termian Patroller's cape.
    public static ResourceLocation getTermianPatrollerCape(TermianPatrollerEntity patroller) {
        String capeNamespace = new ResourceLocation(patroller.getCapeTexture()).getNamespace();
        String capePath = new ResourceLocation(patroller.getCapeTexture()).getPath();

        if (capePath.isEmpty()) capePath = "cape/cherry_blossom";

        return new ResourceLocation(capeNamespace, "textures/entity/" + capePath + ".png");
    }

    // Sets a random cape to a Termian Patroller entity (out of the 7 vanilla/default capes).
    public static void setRandomCape(TermianPatrollerEntity patroller, Random rand) {
        int randomCape = rand.nextInt(9);
        if (randomCape == 0) {
            patroller.setCapeTexture(BackMath.backMath("cape/migrator").toString());
        } else if (randomCape == 1) {
            patroller.setCapeTexture(BackMath.backMath("cape/vanilla").toString());
        } else if (randomCape == 2) {
            patroller.setCapeTexture(BackMath.backMath("cape/cherry_blossom").toString());
        } else if (randomCape == 3) {
            patroller.setCapeTexture(BackMath.backMath("cape/followers").toString());
        } else if (randomCape == 4) {
            patroller.setCapeTexture(BackMath.backMath("cape/purple_heart").toString());
        } else if (randomCape == 5) {
            patroller.setCapeTexture(BackMath.backMath("cape/15th_anniversary").toString());
        } else if (randomCape == 6) {
            patroller.setCapeTexture(BackMath.backMath("cape/pan").toString());
        } else if (randomCape == 7) {
            patroller.setCapeTexture(BackMath.backMath("cape/mc_championship").toString());
        }
    }

    // Sets a random Wanderer Sophie variant from the wanderer_sophie_variant registry.
    public static void setRandomWSRegistryBasedVariant(WandererSophieEntity sophie) {
        ResourceLocation[] variants = WandererSophieVariant.DATA_DRIVEN_VARIANTS.keySet().toArray(new ResourceLocation[0]);
        ResourceLocation variant = variants[sophie.level.random.nextInt(WandererSophieVariant.DATA_DRIVEN_VARIANTS.size())];
        while (WandererSophieVariant.DATA_DRIVEN_VARIANTS.get(variant) != null &&
                !WandererSophieVariant.DATA_DRIVEN_VARIANTS.get(variant).spawnsNaturally()) {
            variant = variants[sophie.level.random.nextInt(WandererSophieVariant.DATA_DRIVEN_VARIANTS.size())];
        }
        sophie.setVariant(variant);
    }

    // Sets a random Queen Lucy Pet variant from the queen_lucy_pet_variant registry.
    public static void setRandomQLPRegistryBasedVariant(QueenLucyPetEntity lucy) {
        QueenLucyPetVariant[] variants = BMRegistries.QUEEN_LUCY_PET_VARIANT.getValues().toArray(new QueenLucyPetVariant[0]);
        lucy.setVariant(variants[lucy.level.random.nextInt(BMRegistries.QUEEN_LUCY_PET_VARIANT.getValues().size())]);
    }

    public static String getBoatType(ItemStack stack, String woodType) {
        CompoundNBT tag = stack.getTag();
        if (tag != null && tag.contains("wood_type", TagTypes.STRING)) {
            if (isValidWoodType(tag.getString("wood_type"))) return tag.getString("wood_type");
        }
        return woodType;
    }

    private static boolean isValidWoodType(String woodType) {
        return VALID_WOOD_TYPES.contains(woodType);
    }

    public static boolean aljanPackEnabled() {
        return Minecraft.getInstance().getResourcePackRepository().getSelectedIds().contains(BackMath.backMath("aljan_texture_update").toString());
    }

    // Copied from teamtwilight/twilightforest.
    public static void transitionFogColor(EntityViewRenderEvent.FogColors event, boolean shouldApplyColors) {
        float[] baseColors = {event.getRed(), event.getGreen(), event.getBlue()};
        float[] targetColors = {0.333F, 0.231F, 0.305F};
        for (int i = 0; i < 3; i++) {
            float base = baseColors[i];
            float target = targetColors[i];
            boolean inverse = base > target;
            FOG_COLORS[i] = base == target ? target : (float) MathHelper.clampedLerp(inverse ? target : base, inverse ? base : target, COLOR);
        }
        float shift = (float) (0.01F * event.getRenderPartialTicks());
        if (shouldApplyColors) COLOR += shift;
        else COLOR -= shift;
        COLOR = MathHelper.clamp(COLOR, 0, 1);
        event.setRed(FOG_COLORS[0]);
        event.setGreen(FOG_COLORS[1]);
        event.setBlue(FOG_COLORS[2]);
    }
}
