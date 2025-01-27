package com.sophicreeper.backmath.item.behavior.effecttype.custom;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.item.behavior.effecttype.ItemBehaviorEffectType;
import com.sophicreeper.backmath.util.TagTypes;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public abstract class SpareyEffectType extends ItemBehaviorEffectType {
    public ITag<EntityType<?>> inSpareyEffectivesTag(ItemStack stack) {
        ITag<EntityType<?>> effectiveEntities = BMEntityTypeTags.SPAREY_EFFECTIVES;
        CompoundNBT tag = stack.getTag();
        if (tag != null && tag.contains("effective_entities", TagTypes.STRING)) {
            ResourceLocation tagLocation = ResourceLocation.tryParse(tag.getString("effective_entities"));
            if (tagLocation != null) {
                ITag<EntityType<?>> managerTag = TagCollectionManager.getInstance().getEntityTypes().getTag(tagLocation);
                if (managerTag != null) return managerTag;
                else return effectiveEntities;
            }
        }
        return effectiveEntities;
    }

    public ITag<EntityType<?>> inDevilSpareyEffectivesTag(ItemStack stack) {
        ITag<EntityType<?>> effectiveEntities = BMEntityTypeTags.DEVIL_SPAREY_EFFECTIVES;
        CompoundNBT tag = stack.getTag();
        if (tag != null && tag.contains("effective_entities", TagTypes.STRING)) {
            ResourceLocation tagLocation = ResourceLocation.tryParse(tag.getString("effective_entities"));
            if (tagLocation != null) {
                ITag<EntityType<?>> managerTag = TagCollectionManager.getInstance().getEntityTypes().getTag(tagLocation);
                if (managerTag != null) return managerTag;
            }
        }
        return effectiveEntities;
    }

    public ITag<EntityType<?>> inSpareyProhibitedTag(ItemStack stack) {
        ITag<EntityType<?>> prohibitedEntities = BMEntityTypeTags.SPAREYS_PROHIBITED;
        CompoundNBT tag = stack.getTag();
        if (tag != null && tag.contains("prohibited_entities", TagTypes.STRING)) {
            ResourceLocation tagLocation = ResourceLocation.tryParse(tag.getString("prohibited_entities"));
            if (tagLocation != null) {
                ITag<EntityType<?>> managerTag = TagCollectionManager.getInstance().getEntityTypes().getTag(tagLocation);
                if (managerTag != null) return managerTag;
            }
        }
        return prohibitedEntities;
    }

    public EffectInstance getSpareyEffect(EffectInstance defaultEffect, ItemStack stack, World world, String tagType) {
        CompoundNBT tag = stack.getTag();

        if (tag != null && tag.contains(tagType, TagTypes.COMPOUND)) {
            CompoundNBT effectTag = tag.getCompound(tagType);
            int duration = 20;
            int amplifier = 0;
            boolean ambient = false;
            boolean showParticles = true;
            boolean showIcon = true;
            boolean noCounter = false;
            List<ItemStack> curativeItems = Lists.newArrayList();
            if (effectTag.contains("duration", TagTypes.ANY_NUMERIC)) duration = effectTag.getInt("duration");
            if (effectTag.contains("amplifier", TagTypes.ANY_NUMERIC)) amplifier = effectTag.getInt("amplifier");
            if (effectTag.contains("ambient", TagTypes.ANY_NUMERIC)) ambient = effectTag.getBoolean("ambient");
            if (effectTag.contains("show_particles", TagTypes.ANY_NUMERIC)) showParticles = effectTag.getBoolean("show_particles");
            if (effectTag.contains("show_icon", TagTypes.ANY_NUMERIC)) showIcon = effectTag.getBoolean("show_icon");
            if (effectTag.contains("no_counter", TagTypes.ANY_NUMERIC)) noCounter = effectTag.getBoolean("no_counter");
            if (effectTag.contains("curative_items", TagTypes.LIST)) {
                ListNBT curativeList = effectTag.getList("curative_items", TagTypes.COMPOUND);
                for (int i = 0; i < curativeList.size(); i++) curativeItems.add(ItemStack.of(curativeList.getCompound(i)));
            }

            Effect effect = ForgeRegistries.POTIONS.getValue(ResourceLocation.tryParse(effectTag.getString("id")));
            if (effect != null) {
                EffectInstance instance = new EffectInstance(effect, duration, amplifier, ambient, showParticles, showIcon);
                if (world.isClientSide) instance.setNoCounter(noCounter);
                if (!curativeItems.isEmpty()) instance.setCurativeItems(curativeItems);
                return instance;
            }
        }
        return defaultEffect;
    }
}
