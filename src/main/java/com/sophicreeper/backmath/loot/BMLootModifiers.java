package com.sophicreeper.backmath.loot;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.loot.modifier.AddToTableLootModifier;
import com.sophicreeper.backmath.loot.modifier.ItemStackAdditionLootModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMLootModifiers {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, BackMath.MOD_ID);

    // Discs
    public static final RegistryObject<GlobalLootModifierSerializer<ItemStackAdditionLootModifier>> WELLERMAN_DISC_MODIFIER = LOOT_MODIFIERS.register("wellerman_disc_modifier", ItemStackAdditionLootModifier.Serializer::new);
    public static final RegistryObject<GlobalLootModifierSerializer<ItemStackAdditionLootModifier>> SNOWMAN_DISC_MODIFIER = LOOT_MODIFIERS.register("snowman_disc_modifier", ItemStackAdditionLootModifier.Serializer::new);
    public static final RegistryObject<GlobalLootModifierSerializer<ItemStackAdditionLootModifier>> ERICWHO_DISC_MODIFIER = LOOT_MODIFIERS.register("ericwho_disc_modifier", ItemStackAdditionLootModifier.Serializer::new);
    public static final RegistryObject<GlobalLootModifierSerializer<ItemStackAdditionLootModifier>> ARCADE_DISC_MODIFIER = LOOT_MODIFIERS.register("arcade_disc_modifier", ItemStackAdditionLootModifier.Serializer::new);
    public static final RegistryObject<GlobalLootModifierSerializer<ItemStackAdditionLootModifier>> STAY_DISC_MODIFIER = LOOT_MODIFIERS.register("stay_disc_modifier", ItemStackAdditionLootModifier.Serializer::new);

    // Others
    public static final RegistryObject<GlobalLootModifierSerializer<ItemStackAdditionLootModifier>> MECH_MECH_MODIFIER = LOOT_MODIFIERS.register("mech_mech_modifier", ItemStackAdditionLootModifier.Serializer::new);
    public static final RegistryObject<GlobalLootModifierSerializer<ItemStackAdditionLootModifier>> GREEN_APPLE_MODIFIER = LOOT_MODIFIERS.register("green_apple_modifier", ItemStackAdditionLootModifier.Serializer::new);
    public static final RegistryObject<GlobalLootModifierSerializer<AddToTableLootModifier>> RED_YELLOW_WOOL_MODIFIER = LOOT_MODIFIERS.register("red_yellow_wool_modifier", AddToTableLootModifier.Serializer::new);
}
