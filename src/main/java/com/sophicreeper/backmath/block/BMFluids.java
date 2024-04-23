package com.sophicreeper.backmath.block;

import com.sophicreeper.backmath.util.BMResourceLocations;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sophicreeper.backmath.util.BMResourceLocations.*;

public class BMFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, BackMath.MOD_ID);

    // Hillary
    public static final RegistryObject<FlowingFluid> HILLARY = FLUIDS.register("hilary_fluid", () ->
            new ForgeFlowingFluid.Source(BMFluids.HILLARY_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HILLARY = FLUIDS.register("hilary_flowing", () ->
            new ForgeFlowingFluid.Flowing(BMFluids.HILLARY_PROPERTIES));

    // Milkllary
    public static final RegistryObject<FlowingFluid> MILKLLARY = FLUIDS.register("milklary_fluid", () ->
            new ForgeFlowingFluid.Source(BMFluids.MILKLLARY_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MILKLLARY = FLUIDS.register("milklary_flowing", () ->
            new ForgeFlowingFluid.Flowing(BMFluids.MILKLLARY_PROPERTIES));

    // Liquid Aljame
    public static final RegistryObject<FlowingFluid> LIQUID_ALJAME = FLUIDS.register("liquid_aljame", () ->
            new ForgeFlowingFluid.Source(BMFluids.LIQUID_ALJAME_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_ALJAME = FLUIDS.register("flowing_liquid_aljame", () ->
            new ForgeFlowingFluid.Flowing(BMFluids.LIQUID_ALJAME_PROPERTIES));

    // Liquid Manga
    public static final RegistryObject<FlowingFluid> LIQUID_MANGA = FLUIDS.register("liquid_manga", () ->
            new ForgeFlowingFluid.Source(BMFluids.LIQUID_MANGA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_MANGA = FLUIDS.register("flowing_liquid_manga", () ->
            new ForgeFlowingFluid.Flowing(BMFluids.LIQUID_MANGA_PROPERTIES));

    // Liquefied Monster
    public static final RegistryObject<FlowingFluid> LIQUEFIED_MONSTER = FLUIDS.register("liquefied_monster", () ->
            new ForgeFlowingFluid.Source(BMFluids.LIQUEFIED_MONSTER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIQUEFIED_MONSTER = FLUIDS.register("flowing_liquefied_monster", () ->
            new ForgeFlowingFluid.Flowing(BMFluids.LIQUEFIED_MONSTER_PROPERTIES));

    // Sleepishwater
    public static final RegistryObject<FlowingFluid> SLEEPISHWATER = FLUIDS.register("sleepishwater", () ->
            new ForgeFlowingFluid.Source(BMFluids.SLEEPISHWATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SLEEPISHWATER = FLUIDS.register("flowing_sleepishwater", () ->
            new ForgeFlowingFluid.Flowing(BMFluids.SLEEPISHWATER_PROPERTIES));

    // Fluid Properties
    public static final ForgeFlowingFluid.Properties MILKLLARY_PROPERTIES = new ForgeFlowingFluid.Properties(MILKLLARY, FLOWING_MILKLLARY,
            FluidAttributes.builder(MILKLLARY_STILL, BMResourceLocations.FLOWING_MILKLLARY).rarity(Rarity.COMMON).sound(SoundEvents.BUCKET_EMPTY).overlay(MILKLLARY_OVERLAY))
            .block(BMBlocks.MILKLLARY).bucket(AxolotlTest.MILKLLARY_BUCKET);

    public static final ForgeFlowingFluid.Properties HILLARY_PROPERTIES = new ForgeFlowingFluid.Properties(HILLARY, FLOWING_HILLARY,
            FluidAttributes.builder(HILLARY_STILL, BMResourceLocations.FLOWING_HILLARY).rarity(Rarity.UNCOMMON).sound(SoundEvents.BUCKET_EMPTY).overlay(HILLARY_OVERLAY))
            .canMultiply().block(BMBlocks.HILLARY).bucket(AxolotlTest.HILLARY_BUCKET);

    public static final ForgeFlowingFluid.Properties LIQUID_ALJAME_PROPERTIES = new ForgeFlowingFluid.Properties(LIQUID_ALJAME, FLOWING_LIQUID_ALJAME,
            FluidAttributes.builder(LIQUID_ALJAME_STILL, BMResourceLocations.FLOWING_LIQUID_ALJAME).rarity(Rarity.UNCOMMON).sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIQUID_ALJAME_OVERLAY)).bucket(AxolotlTest.LIQUID_ALJAME_BUCKET).block(BMBlocks.LIQUID_ALJAME);

    public static final ForgeFlowingFluid.Properties LIQUID_MANGA_PROPERTIES = new ForgeFlowingFluid.Properties(LIQUID_MANGA, FLOWING_LIQUID_MANGA,
            FluidAttributes.builder(LIQUID_MANGA_STILL, BMResourceLocations.FLOWING_LIQUID_MANGA).rarity(Rarity.UNCOMMON).sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIQUID_MANGA_OVERLAY)).bucket(AxolotlTest.LIQUID_MANGA_BUCKET).block(BMBlocks.LIQUID_MANGA);

    public static final ForgeFlowingFluid.Properties LIQUEFIED_MONSTER_PROPERTIES = new ForgeFlowingFluid.Properties(LIQUEFIED_MONSTER, FLOWING_LIQUEFIED_MONSTER,
            FluidAttributes.builder(LIQUEFIED_MONSTER_STILL, BMResourceLocations.FLOWING_LIQUEFIED_MONSTER).rarity(Rarity.UNCOMMON).sound(SoundEvents.BUCKET_EMPTY)
                    .overlay(LIQUEFIED_MONSTER_OVERLAY)).bucket(AxolotlTest.LIQUEFIED_MONSTER_BUCKET).block(BMBlocks.LIQUEFIED_MONSTER);

    public static final ForgeFlowingFluid.Properties SLEEPISHWATER_PROPERTIES = new ForgeFlowingFluid.Properties(SLEEPISHWATER, FLOWING_SLEEPISHWATER,
            FluidAttributes.builder(SLEEPISHWATER_STILL, FLOWING_SLEEPISHWATER_RL).rarity(Rarity.COMMON).sound(SoundEvents.BUCKET_EMPTY).overlay(SLEEPISHWATER_OVERLAY))
            .canMultiply().block(BMBlocks.SLEEPISHWATER).bucket(AxolotlTest.SLEEPISHWATER_BUCKET);
}
