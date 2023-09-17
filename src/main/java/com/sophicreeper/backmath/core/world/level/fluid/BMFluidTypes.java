package com.sophicreeper.backmath.core.world.level.fluid;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

import static com.sophicreeper.backmath.core.util.BMResourceLocations.*;

public class BMFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, BackMath.MOD_ID);

    // b0a0df
    public static final RegistryObject<FluidType> HILLARY = FLUID_TYPES.register("hilary_fluid", () ->
            new KaupenFluidType(HILLARY_STILL, FLOWING_HILLARY, HILLARY_OVERLAY, 0, new Vector3f(
                    184f / 255f, 170f / 255f, 227f / 255f), FluidType.Properties.create().canHydrate(true).supportsBoating(true)
                    .canConvertToSource(true).viscosity(500)));
}
