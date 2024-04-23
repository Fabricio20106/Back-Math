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
            protected ItemStack execute(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getLevel(), stack, null, source.getPos().relative(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEggs : BACKMATH_EGGS) {
            BY_ID.put(spawnEggs.getType(null), spawnEggs);
            DispenserBlock.registerBehavior(spawnEggs, dispenseItemBehavior);
        }

        BACKMATH_EGGS.clear();
        BY_ID.remove(null);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            CompoundNBT entityTagNBT = tag.getCompound("EntityTag");
            if (entityTagNBT.contains("id", 8)) {
                return EntityType.byString(entityTagNBT.getString("id")).orElse(this.typeSupplier.get());
            }
        }

        return this.typeSupplier.get();
    }
}
