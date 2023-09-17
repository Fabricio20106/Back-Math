package com.sophicreeper.backmath.core.world.level.fluid;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

import static com.sophicreeper.backmath.core.util.BMResourceLocations.*;

public class BMFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, BackMath.MOD_ID);

    // The tint color is actually an ARGB value, so the transparent hillary from 16/09/2023 was caused by this.
    public static final RegistryObject<FluidType> HILLARY = FLUID_TYPES.register("hillary", () ->
            new KaupenFluidType(HILLARY_STILL, FLOWING_HILLARY, HILLARY_OVERLAY, 0xFFd7d0ef, new Vector3f(
                    184f / 255f, 170f / 255f, 227f / 255f), FluidType.Properties.create().canHydrate(true).supportsBoating(true)
                    .canConvertToSource(true).viscosity(500)));

    public static final RegistryObject<FluidType> MILKLLARY = FLUID_TYPES.register("milkllary", () ->
            new KaupenFluidType(MILKLLARY_STILL, FLOWING_MILKLLARY, MILKLLARY_OVERLAY, 0xFFd4cfe1, new Vector3f(
                    191f / 255f, 184f / 255f, 211f / 255f), FluidType.Properties.create().canHydrate(true).supportsBoating(true)
                    .viscosity(500).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<FluidType> LIQUID_ALJAME = FLUID_TYPES.register("liquid_aljame", () ->
            new KaupenFluidType(LIQUID_ALJAME_STILL, FLOWING_LIQUID_ALJAME, LIQUID_ALJAME_OVERLAY, 0xFFd0d8d8, new Vector3f(
                    186f / 255f, 198f / 255f, 198f / 255f), FluidType.Properties.create().supportsBoating(true).viscosity(500)));

    public static final RegistryObject<FluidType> LIQUID_MANGA = FLUID_TYPES.register("liquid_manga", () ->
            new KaupenFluidType(LIQUID_MANGA_STILL, FLOWING_LIQUID_MANGA, LIQUID_MANGA_OVERLAY, 0xFF95b3dc, new Vector3f(
                    125f / 255f, 163f / 255f, 212f / 255f), FluidType.Properties.create().supportsBoating(true).viscosity(500)));

    public static final RegistryObject<FluidType> LIQUEFIED_MONSTER = FLUID_TYPES.register("liquefied_monster", () ->
            new KaupenFluidType(LIQUEFIED_MONSTER_STILL, FLOWING_LIQUEFIED_MONSTER, LIQUEFIED_MONSTER_OVERLAY, 0xFF30582e, new Vector3f(
                    43f / 255f, 79f / 255f, 41f / 255f), FluidType.Properties.create().supportsBoating(true).canSwim(false).density(2000).viscosity(2000)));

    public static final RegistryObject<FluidType> SLEEPISHWATER = FLUID_TYPES.register("sleepishwater", () ->
            new KaupenFluidType(SLEEPISHWATER_STILL, FLOWING_SLEEPISHWATER, SLEEPISHWATER_OVERLAY, 0xFF8853a0, new Vector3f(
                    130f / 255f, 82f / 255f, 151f / 255f), FluidType.Properties.create().canHydrate(true).supportsBoating(true)
                    .canConvertToSource(true).viscosity(500)));
}
