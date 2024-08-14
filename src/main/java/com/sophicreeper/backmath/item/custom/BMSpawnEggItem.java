package com.sophicreeper.backmath.item.custom;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.dispenser.BMSpawnEggDispenseBehavior;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class BMSpawnEggItem extends SpawnEggItem {
    private static final List<BMSpawnEggItem> BACK_MATH_EGGS = Lists.newArrayList();
    private final Supplier<? extends EntityType<? extends Entity>> typeSupplier;

    public BMSpawnEggItem(Supplier<? extends EntityType<? extends Entity>> type, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        this.typeSupplier = type;
        BACK_MATH_EGGS.add(this);
    }

    public static void initBackMathEggs() {
        for (final SpawnEggItem spawnEgg : BACK_MATH_EGGS) {
            BY_ID.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerBehavior(spawnEgg, new BMSpawnEggDispenseBehavior());
        }
        BACK_MATH_EGGS.clear();
        BY_ID.remove(null);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT tag) {
        if (tag != null && tag.contains("entity_data", TagTypes.COMPOUND)) {
            CompoundNBT entityTag = tag.getCompound("entity_data");
            if (entityTag.contains("id", 8)) return EntityType.byString(entityTag.getString("id")).orElse(this.typeSupplier.get());
        }
        return this.typeSupplier.get();
    }
}
