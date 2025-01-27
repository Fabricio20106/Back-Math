package com.sophicreeper.backmath.util;

import com.google.common.collect.Lists;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;
import java.util.List;

// Utility methods copied from or related to Variants.
public class VSUtils {
    public static CompoundNBT saveStack(ItemStack stack, CompoundNBT tag) {
        if (stack == ItemStack.EMPTY) {
            tag.putString("id", "minecraft:air");
            tag.putInt("count", 0);
        } else {
            tag.putString("id", stack.getItem().getRegistryName().toString());
            if (stack.getCount() != 1) tag.putInt("count", stack.getCount());
            if (stack.getTag() != null) tag.put("components", stack.getTag().copy());
        }
        return tag;
    }

    // Custom stack loading method that supports integer stack counts and string tag parsing.
    public static ItemStack loadStack(CompoundNBT tag) {
        Item item;
        if (tag.contains("id", TagTypes.STRING)) {
            item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(tag.getString("id")));
        } else {
            item = Items.AIR;
        }
        int count;
        if (tag.contains("count", TagTypes.ANY_NUMERIC)) {
            count = tag.getInt("count");
        } else {
            count = 1;
        }
        ItemStack stack = new ItemStack(item, count);

        if (tag.contains("components", TagTypes.STRING)) {
            try {
                CompoundNBT componentsTag = JsonToNBT.parseTag(tag.getString("components"));
                tag.put("components", componentsTag);
            } catch (CommandSyntaxException exception) {
                LogManager.getLogger().error(new TranslationTextComponent("error.backmath.stack_loading.tag", tag.getString("components")).getString(), exception.getMessage());
            }
        }

        if (tag.contains("components", TagTypes.COMPOUND)) {
            stack.setTag(tag.getCompound("components"));
            stack.getItem().verifyTagAfterLoad(tag);
        } else if (tag.contains("tag", TagTypes.COMPOUND)) {
            stack.setTag(tag.getCompound("tag"));
            stack.getItem().verifyTagAfterLoad(tag);
        }

        if (stack.getItem().isDamageable(stack)) stack.setDamageValue(stack.getDamageValue());
        return stack;
    }

    public static Style getFromRGB(int color) {
        return Style.EMPTY.withColor(Color.fromRgb(color));
    }

    public static BlockPos readBlockPos(CompoundNBT tag) {
        return readBlockPos(tag, "pos");
    }

    public static BlockPos readBlockPos(CompoundNBT tag, String tagName) {
        int[] pos = tag.getIntArray(tagName);
        if (pos.length <= 3) return new BlockPos(pos[0], pos[1], pos[2]);
        return new BlockPos(0, 0, 0);
    }

    // Copied from Variants and modified to work with Back Math's tool behaviors.
    @Nullable
    public static List<EffectInstance> getAppliedEffectsFromNBT(@Nullable World world, ItemStack stack) {
        CompoundNBT tag = stack.getTag();
        List<EffectInstance> effects = Lists.newArrayList();

        if (tag != null && tag.contains("applied_effects", TagTypes.LIST)) {
            ListNBT effectList = tag.getList("applied_effects", TagTypes.COMPOUND);

            for (int i = 0; i < effectList.size(); ++i) {
                int duration = 20;
                int amplifier = 0;
                boolean ambient = false;
                boolean showParticles = true;
                boolean showIcon = true;
                boolean noCounter = false;
                List<ItemStack> curativeItems = Lists.newArrayList();
                CompoundNBT effectTag = effectList.getCompound(i);
                if (effectTag.contains("duration", TagTypes.ANY_NUMERIC)) duration = effectTag.getInt("duration");
                if (effectTag.contains("amplifier", TagTypes.ANY_NUMERIC)) amplifier = effectTag.getInt("amplifier");
                if (effectTag.contains("ambient", TagTypes.ANY_NUMERIC)) ambient = effectTag.getBoolean("ambient");
                if (effectTag.contains("show_particles", TagTypes.ANY_NUMERIC)) showParticles = effectTag.getBoolean("show_particles");
                if (effectTag.contains("show_icon", TagTypes.ANY_NUMERIC)) showIcon = effectTag.getBoolean("show_icon");
                if (effectTag.contains("no_counter", TagTypes.ANY_NUMERIC)) noCounter = effectTag.getBoolean("no_counter");
                if (effectTag.contains("curative_items", TagTypes.LIST)) {
                    ListNBT curativeList = effectTag.getList("curative_items", TagTypes.COMPOUND);
                    for (int b = 0; b < curativeList.size(); b++) curativeItems.add(ItemStack.of(curativeList.getCompound(b)));
                }

                Effect effect = ForgeRegistries.POTIONS.getValue(ResourceLocation.tryParse(effectTag.getString("id")));
                if (effect != null) {
                    EffectInstance instance = new EffectInstance(effect, duration, amplifier, ambient, showParticles, showIcon);
                    if (world != null && world.isClientSide) instance.setNoCounter(noCounter);
                    if (!curativeItems.isEmpty()) instance.setCurativeItems(curativeItems);
                    effects.add(instance);
                }
            }
            return effects;
        }
        return null;
    }

    public static CompoundNBT saveAllItems(CompoundNBT tag, NonNullList<ItemStack> stackList) {
        return saveAllItems(tag, stackList, true);
    }

    public static CompoundNBT saveAllItems(CompoundNBT tag, NonNullList<ItemStack> stackList, boolean saveEmpty) {
        ListNBT itemsList = new ListNBT();

        for (int i = 0; i < stackList.size(); ++i) {
            ItemStack stack = stackList.get(i);
            if (!stack.isEmpty()) {
                CompoundNBT stackTag = new CompoundNBT();
                stackTag.putInt("slot", i);
                saveStack(stack, stackTag);
                itemsList.add(stackTag);
            }
        }

        if (!itemsList.isEmpty() || saveEmpty) tag.put("items", itemsList);

        return tag;
    }

    public static void loadAllItems(CompoundNBT tag, NonNullList<ItemStack> stackList) {
        ListNBT itemsNBT = tag.getList("items", TagTypes.COMPOUND);

        for (int i = 0; i < itemsNBT.size(); ++i) {
            CompoundNBT stackTag = itemsNBT.getCompound(i);
            int slot = stackTag.getInt("slot") & 255;
            if (slot < stackList.size()) stackList.set(slot, loadStack(stackTag));
        }
    }
}
