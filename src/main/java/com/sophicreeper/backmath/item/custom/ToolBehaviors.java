package com.sophicreeper.backmath.item.custom;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.TagTypes;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import com.sophicreeper.backmath.util.VSUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public interface ToolBehaviors {
    default void setOnFire(ItemStack stack, LivingEntity livEntity) {
        setOnFire(stack, livEntity, 5);
    }

    default void setOnFire(ItemStack stack, LivingEntity livEntity, int seconds) {
        if (!livEntity.isInvulnerableTo(DamageSource.IN_FIRE) || !livEntity.isInvulnerableTo(DamageSource.ON_FIRE)) {
            CompoundNBT tag = stack.getTag();
            if (tag != null && tag.contains("seconds_on_fire", TagTypes.ANY_NUMERIC)) livEntity.setSecondsOnFire(tag.getInt("seconds_on_fire"));
            else livEntity.setSecondsOnFire(seconds);
        }
    }

    default void giveMilkedSwordItem(ItemStack stack, PlayerEntity player) {
        if (BMConfigs.COMMON_CONFIGS.milkedSwordsEnabled.get()) {
            CompoundNBT tag = stack.getTag();
            ItemStack bucketStack = new ItemStack(Items.MILK_BUCKET);
            if (tag != null && tag.contains("milked_sword_item", TagTypes.STRING)) {
                ResourceLocation itemLocation = ResourceLocation.tryParse(tag.getString("milked_sword_item"));
                if (itemLocation != null && ForgeRegistries.ITEMS.containsKey(itemLocation)) {
                    ItemStack tagStack = new ItemStack(ForgeRegistries.ITEMS.getValue(itemLocation));
                    tag.remove("milked_sword_item");
                    tag.put("milked_sword_item", tagStack.save(new CompoundNBT()));
                }
            }
            if (tag != null && tag.contains("milked_sword_item", TagTypes.COMPOUND)) {
                ItemStack tagStack = VSUtils.loadStack(tag.getCompound("milked_sword_item"));
                if (!tagStack.isEmpty()) bucketStack = tagStack;
            }
            if (!player.inventory.add(bucketStack)) player.drop(bucketStack, false);
        }
    }

    default void applyTagEffects(ItemStack stack, LivingEntity livEntity) {
        CompoundNBT tag = stack.getTag();
        List<EffectInstance> tagEffects = VSUtils.getAppliedEffectsFromNBT(livEntity.level, stack);
        if (tag != null && tagEffects != null && !tagEffects.isEmpty()) {
            for (EffectInstance instance : tagEffects) livEntity.addEffect(instance);
        } else if (!getAppliedEffects().isEmpty()) {
            for (EffectInstance instance : getAppliedEffects()) livEntity.addEffect(instance);
        }
    }

    @Nonnull
    default List<EffectInstance> getAppliedEffects() {
        return Lists.newArrayList();
    }

    default ItemStack getFoodUseRemainder(ItemStack stack) {
        return getFoodUseRemainder(stack, new ItemStack(Items.GLASS_BOTTLE));
    }

    default ItemStack getFoodUseRemainder(ItemStack stack, ItemStack defaultStack) {
        ItemStack containerStack = defaultStack.copy();
        CompoundNBT tag = stack.getTag();
        if (tag != null && tag.contains("use_remainder", TagTypes.STRING)) {
            ResourceLocation itemLocation = ResourceLocation.tryParse(tag.getString("use_remainder"));
            if (itemLocation != null && ForgeRegistries.ITEMS.containsKey(itemLocation)) {
                ItemStack tagStack = new ItemStack(ForgeRegistries.ITEMS.getValue(itemLocation));
                tag.remove("use_remainder");
                tag.put("use_remainder", tagStack.save(new CompoundNBT()));
                if (!tagStack.isEmpty()) return tagStack;
            }
        }
        if (tag != null && tag.contains("use_remainder", TagTypes.COMPOUND)) {
            ItemStack tagStack = VSUtils.loadStack(tag.getCompound("use_remainder"));
            if (!tagStack.isEmpty()) return tagStack;
        }
        return containerStack;
    }

    default ITag<EntityType<?>> inSpareyEffectivesTag(ItemStack stack) {
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

    default ITag<EntityType<?>> inDevilSpareyEffectivesTag(ItemStack stack) {
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

    default ITag<EntityType<?>> inSpareyProhibitedTag(ItemStack stack) {
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

    default EffectInstance getSpareyEffect(EffectInstance defaultEffect, ItemStack stack, World world, String tagType) {
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
