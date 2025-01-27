package com.sophicreeper.backmath.item.behavior.effecttype;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.effect.BMEffectInstance;
import com.sophicreeper.backmath.effect.BMEffects;
import com.sophicreeper.backmath.item.behavior.ItemBehaviorParameters;
import com.sophicreeper.backmath.item.behavior.effecttype.custom.*;
import com.sophicreeper.backmath.misc.BMRegistries;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class BMItemBehaviorEffectTypes {
    public static final DeferredRegister<ItemBehaviorEffectType> TYPES = DeferredRegister.create(BMRegistries.ITEM_BEHAVIOR_EFFECT_TYPE, BackMath.MOD_ID);

    public static final RegistryObject<ItemBehaviorEffectType> IGNITE = TYPES.register("ignite", IgniteEffectType::new);
    public static final RegistryObject<ItemBehaviorEffectType> DAMAGE_ENTITY = TYPES.register("damage_entity", DamageEntityEffectType::new);
    public static final RegistryObject<ItemBehaviorEffectType> GIVE_MILKED_SWORD_ITEM = TYPES.register("give_milked_sword_item", GiveMilkedSwordItemEffectType::new);
    public static final RegistryObject<ItemBehaviorEffectType> ADD_EXPERIENCE = TYPES.register("add_experience", () -> new AddExperienceEffectType(500));
    public static final RegistryObject<ItemBehaviorEffectType> ADD_BAKUGOU_OUTFIT = TYPES.register("add_bakugou_outfit", AddBakugouOutfitEffectType::new);
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_MID_TERM_EFFECTS = TYPES.register("apply_mid_term_effects", () -> new ApplyTagEffectsEffectType(Lists.newArrayList(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2)))); // Slowness III (0:05) (from 1 second)
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_PINK_GUM_FRYING_PAN_EFFECTS = TYPES.register("apply_pink_gum_frying_pan_effects", () -> new ApplyTagEffectsEffectType(Lists.newArrayList(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 3), new EffectInstance(Effects.HARM, 200)))); // Slowness IV (0:10), Instant Damage (0:10)
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_PATIENCE_TEA_EFFECTS = TYPES.register("apply_patience_tea_effects", () -> new ApplyTagEffectsEffectType(Lists.newArrayList(new BMEffectInstance(BMEffects.PATIENCE, 600)))); // Patience (0:30)
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_PEACE_TEA_EFFECTS = TYPES.register("apply_peace_tea_effects", () -> new ApplyTagEffectsEffectType(ItemBehaviorParameters.getPeaceTeaEffects())); // Almost all good effects (5:00)
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_DISGUST_TEA_EFFECTS = TYPES.register("apply_disgust_tea_effects", () -> new ApplyTagEffectsEffectType(Lists.newArrayList(new BMEffectInstance(BMEffects.DISGUST, 600)))); // Disgust (0:30)
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_MOOD_TEA_EFFECTS = TYPES.register("apply_mood_tea_effects", () -> new ApplyTagEffectsEffectType(Lists.newArrayList(new BMEffectInstance(BMEffects.MOOD, 6000)))); // Mood (5:00)
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_SPAREY_EFFECTS = TYPES.register("apply_sparey_effects", ApplySpareyEffectsEffectType::new);
    public static final RegistryObject<ItemBehaviorEffectType> APPLY_DEVIL_SPAREY_EFFECTS = TYPES.register("apply_devil_sparey_effects", ApplyDevilSpareyEffectsType::new);
}
