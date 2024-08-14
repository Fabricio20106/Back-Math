package com.sophicreeper.backmath.util;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.entity.custom.WandererSophieEntity;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMRegistries;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import com.sophicreeper.backmath.world.structure.BMStructures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.potion.PotionUtils;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.*;

// Just generalized methods that are used more than twice throughout the code.
public class BMUtils {
    private static final IFormattableTextComponent NO_EFFECT = new TranslationTextComponent("effect.none").withStyle(TextFormatting.GRAY);
    public static final Style EXPERIENCE = Style.EMPTY.withColor(Color.fromRgb(8453920));
    public static final int END_PORTAL_OPEN = 1038;

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
        WandererSophieVariant[] variants = BMRegistries.WANDERER_SOPHIE_VARIANT.getValues().toArray(new WandererSophieVariant[0]);
        sophie.setVariant(variants[sophie.level.random.nextInt(BMRegistries.WANDERER_SOPHIE_VARIANT.getValues().size())]);
    }

    // Sets a random Queen Lucy Pet variant from the queen_lucy_pet_variant registry.
    public static void setRandomQLPRegistryBasedVariant(QueenLucyPetEntity lucy) {
        QueenLucyPetVariant[] variants = BMRegistries.QUEEN_LUCY_PET_VARIANT.getValues().toArray(new QueenLucyPetVariant[0]);
        lucy.setVariant(variants[lucy.level.random.nextInt(BMRegistries.QUEEN_LUCY_PET_VARIANT.getValues().size())]);
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
                if (effectTag.contains("duration", TagTypes.INTEGER)) duration = effectTag.getInt("duration");
                if (effectTag.contains("amplifier", TagTypes.INTEGER)) amplifier = effectTag.getInt("amplifier");
                if (effectTag.contains("ambient")) ambient = effectTag.getBoolean("ambient");
                if (effectTag.contains("show_particles")) showParticles = effectTag.getBoolean("show_particles");
                if (effectTag.contains("show_icon")) showIcon = effectTag.getBoolean("show_icon");
                if (effectTag.contains("no_counter")) noCounter = effectTag.getBoolean("no_counter");
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

    // From PotionUtils, copied to change attribute tooltip.
    @OnlyIn(Dist.CLIENT)
    public static void addPotionTooltip(ItemStack stack, List<ITextComponent> tooltip, float durationFactor) {
        List<EffectInstance> effectsList = PotionUtils.getMobEffects(stack);
        List<Pair<Attribute, AttributeModifier>> attributesList = Lists.newArrayList();
        if (effectsList.isEmpty()) {
            tooltip.add(NO_EFFECT);
        } else {
            for (EffectInstance instance : effectsList) {
                IFormattableTextComponent component = new TranslationTextComponent(instance.getDescriptionId());
                Effect effect = instance.getEffect();
                Map<Attribute, AttributeModifier> attributeMap = effect.getAttributeModifiers();
                if (!attributeMap.isEmpty()) {
                    for (Map.Entry<Attribute, AttributeModifier> entry : attributeMap.entrySet()) {
                        AttributeModifier modifier = entry.getValue();
                        AttributeModifier newModifier = new AttributeModifier(modifier.getName(), effect.getAttributeModifierValue(instance.getAmplifier(), modifier), modifier.getOperation());
                        attributesList.add(new Pair<>(entry.getKey(), newModifier));
                    }
                }

                if (instance.getAmplifier() > 0) component = new TranslationTextComponent("potion.withAmplifier", component, new TranslationTextComponent("potion.potency." + instance.getAmplifier()));
                if (instance.getDuration() > 20) component = new TranslationTextComponent("potion.withDuration", component, EffectUtils.formatDuration(instance, durationFactor));
                tooltip.add(component.withStyle(effect.getCategory().getTooltipFormatting()));
            }
        }

        if (!attributesList.isEmpty()) {
            tooltip.add(StringTextComponent.EMPTY);
            tooltip.add(new TranslationTextComponent("tooltip.backmath.effect_jam.when_drank").withStyle(TextFormatting.GRAY));

            for (Pair<Attribute, AttributeModifier> attributePair : attributesList) {
                AttributeModifier modifier = attributePair.getSecond();
                double baseAmount = modifier.getAmount();
                double amount;

                if (modifier.getOperation() != AttributeModifier.Operation.MULTIPLY_BASE && modifier.getOperation() != AttributeModifier.Operation.MULTIPLY_TOTAL) {
                    amount = modifier.getAmount();
                } else {
                    amount = modifier.getAmount() * 100;
                }

                if (baseAmount > 0) {
                    tooltip.add(new TranslationTextComponent("attribute.modifier.plus." + modifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(amount), new TranslationTextComponent(attributePair.getFirst().getDescriptionId())).withStyle(TextFormatting.BLUE));
                } else if (baseAmount < 0) {
                    amount = amount * -1;
                    tooltip.add(new TranslationTextComponent("attribute.modifier.take." + modifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(amount), new TranslationTextComponent(attributePair.getFirst().getDescriptionId())).withStyle(TextFormatting.RED));
                }
            }
        }
    }
}
