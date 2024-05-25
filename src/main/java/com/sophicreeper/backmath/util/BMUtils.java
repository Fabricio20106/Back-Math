package com.sophicreeper.backmath.util;

import com.google.gson.*;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.world.structure.BMStructures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.util.JSONUtils;
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
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

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

    // Reads the "addition" tag from loot modifiers into a CompoundNBT for an ItemStack.
    public static CompoundNBT jsonToTag(JsonObject additionTag) {
        CompoundNBT stackTag = new CompoundNBT();
        try {
            JsonElement nbt = additionTag.get("nbt");
            CompoundNBT tag;
            if (nbt.isJsonObject()) {
                tag = JsonToNBT.parseTag(GSON.toJson(nbt));
            } else {
                tag = JsonToNBT.parseTag(JSONUtils.convertToString(nbt, "nbt"));
            }
            stackTag.put("tag", tag);
            stackTag.putString("id", new ResourceLocation(JSONUtils.getAsString(additionTag, "id")).toString());
            stackTag.putInt("Count", additionTag.get("count").getAsInt());
        } catch (CommandSyntaxException syntaxException) {
            throw new JsonSyntaxException(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.json_syntax.invalid_nbt", syntaxException)).getString());
        }
        return stackTag;
    }

    // Writes the item NBT into a JSON object for the loot modifier.
//    public static JsonObject tagToJSON(CompoundNBT tag) {
//        Set<String> tags = tag.getAllKeys();
//    }
}
