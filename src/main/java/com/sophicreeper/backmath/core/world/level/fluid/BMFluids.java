package com.sophicreeper.backmath.core.world.level.fluid;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
    public static final ForgeFlowingFluid.Properties HILLARY_PROPERTIES = new ForgeFlowingFluid.Properties(
            BMFluidTypes.HILLARY, HILLARY, FLOWING_HILLARY).slopeFindDistance(8).levelDecreasePerBlock(1)
            .block(BMBlocks.HILLARY).bucket(AxolotlTest.HILLARY_BUCKET);

    public static final ForgeFlowingFluid.Properties MILKLLARY_PROPERTIES = new ForgeFlowingFluid.Properties(
            BMFluidTypes.MILKLLARY, MILKLLARY, FLOWING_MILKLLARY).slopeFindDistance(8).levelDecreasePerBlock(1)
            .block(BMBlocks.MILKLLARY).bucket(AxolotlTest.MILKLLARY_BUCKET);

    public static final ForgeFlowingFluid.Properties LIQUID_ALJAME_PROPERTIES = new ForgeFlowingFluid.Properties(
            BMFluidTypes.LIQUID_ALJAME, LIQUID_ALJAME, FLOWING_LIQUID_ALJAME).slopeFindDistance(8).levelDecreasePerBlock(1)
            .block(BMBlocks.LIQUID_ALJAME).bucket(AxolotlTest.LIQUID_ALJAME_BUCKET);

    public static final ForgeFlowingFluid.Properties LIQUID_MANGA_PROPERTIES = new ForgeFlowingFluid.Properties(
            BMFluidTypes.LIQUID_MANGA, LIQUID_MANGA, FLOWING_LIQUID_MANGA).slopeFindDistance(8).levelDecreasePerBlock(1)
            .block(BMBlocks.LIQUID_MANGA).bucket(AxolotlTest.LIQUID_MANGA_BUCKET);

    public static final ForgeFlowingFluid.Properties LIQUEFIED_MONSTER_PROPERTIES = new ForgeFlowingFluid.Properties(
            BMFluidTypes.LIQUEFIED_MONSTER, LIQUEFIED_MONSTER, FLOWING_LIQUEFIED_MONSTER).slopeFindDistance(8).levelDecreasePerBlock(2)
            .block(BMBlocks.LIQUEFIED_MONSTER).bucket(AxolotlTest.LIQUEFIED_MONSTER_BUCKET);

    public static final ForgeFlowingFluid.Properties SLEEPISHWATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            BMFluidTypes.SLEEPISHWATER, SLEEPISHWATER, FLOWING_SLEEPISHWATER).slopeFindDistance(8).levelDecreasePerBlock(1)
            .block(BMBlocks.SLEEPISHWATER).bucket(AxolotlTest.SLEEPISHWATER_BUCKET);
}
