package com.sophicreeper.backmath.container;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.container.custom.CrateContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMContainers {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, BackMath.MOD_ID);

    public static final RegistryObject<ContainerType<CrateContainer>> CRATE = CONTAINERS.register("crate", () -> new ContainerType<>(CrateContainer::new));
}
