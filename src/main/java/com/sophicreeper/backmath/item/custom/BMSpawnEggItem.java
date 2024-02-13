package com.sophicreeper.backmath.item.custom;

import com.google.common.collect.Lists;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class BMSpawnEggItem extends SpawnEggItem {
    private static final List<BMSpawnEggItem> BACKMATH_EGGS = Lists.newArrayList();
    private final Supplier<? extends EntityType<? extends Entity>> typeSupplier;

    public BMSpawnEggItem(Supplier<? extends EntityType<? extends Entity>> type, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        this.typeSupplier = type;
        BACKMATH_EGGS.add(this);
    }

    public static void initBackMathEggs() {
        DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEggs : BACKMATH_EGGS) {
            EGGS.put(spawnEggs.getType(null), spawnEggs);
            DispenserBlock.registerDispenseBehavior(spawnEggs, dispenseItemBehavior);
        }

        BACKMATH_EGGS.clear();
        EGGS.remove(null);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            CompoundNBT entityTagNBT = tag.getCompound("EntityTag");
            if (entityTagNBT.contains("id", 8)) {
                return EntityType.byKey(entityTagNBT.getString("id")).orElse(this.typeSupplier.get());
            }
        }

        return this.typeSupplier.get();
    }
}
