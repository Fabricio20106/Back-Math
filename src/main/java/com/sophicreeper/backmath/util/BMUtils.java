package com.sophicreeper.backmath.util;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.WandererSophie;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.registry.BMRegistries;
import com.sophicreeper.backmath.registry.wsvariant.WandererSophieVariant;
import com.sophicreeper.backmath.world.structure.BMStructures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;

import java.util.*;

// Just generalized methods that are used more than twice throughout the code.
public class BMUtils {
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

    // Returns the resource location for a Termian Patroller's cape.
    public static ResourceLocation getTermianPatrollerCape(TermianPatrollerEntity patroller) {
        String capeNamespace = new ResourceLocation(patroller.getCapeTexture()).getNamespace();
        String capePath = new ResourceLocation(patroller.getCapeTexture()).getPath();

        if (capePath.isEmpty()) capePath = "cape/cherry_blossom";

        return new ResourceLocation(capeNamespace, "textures/entity/" + capePath + ".png");
    }

    // Sets a random cape to a Termian Patroller entity (out of the 7 vanilla/default capes).
    public static void setRandomCape(TermianPatrollerEntity patroller, Random rand) {
        int randomCape = rand.nextInt(8);
        if (randomCape == 0) {
            patroller.setCapeTexture(BackMath.resourceLoc("cape/migrator").toString());
        } else if (randomCape == 1) {
            patroller.setCapeTexture(BackMath.resourceLoc("cape/vanilla").toString());
        } else if (randomCape == 2) {
            patroller.setCapeTexture(BackMath.resourceLoc("cape/cherry_blossom").toString());
        } else if (randomCape == 3) {
            patroller.setCapeTexture(BackMath.resourceLoc("cape/followers").toString());
        } else if (randomCape == 4) {
            patroller.setCapeTexture(BackMath.resourceLoc("cape/purple_heart").toString());
        } else if (randomCape == 5) {
            patroller.setCapeTexture(BackMath.resourceLoc("cape/15th_anniversary").toString());
        } else if (randomCape == 6) {
            patroller.setCapeTexture(BackMath.resourceLoc("cape/pan").toString());
        }
    }

    // Sets a random Wanderer Sophie variant from the wanderer_sophie_variant registry.
    public static void setRandomRegistryBasedVariant(WandererSophie sophie) {
        WandererSophieVariant[] variants = BMRegistries.WANDERER_SOPHIE_VARIANT.getValues().toArray(new WandererSophieVariant[0]);
        sophie.setRegistryBasedVariant(variants[sophie.level.random.nextInt(BMRegistries.WANDERER_SOPHIE_VARIANT.getValues().size())]);
    }
}
