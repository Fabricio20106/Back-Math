package com.sophicreeper.backmath.core.world.item;

public class BMSpawnEggItem /*extends SpawnEggItem*/ {
    /*private static final List<BMSpawnEggItem> UNADDED_EGGS = Lists.newArrayList();
    private final Supplier<? extends EntityType<? extends Entity>> typeSupplier;

    public BMSpawnEggItem(Supplier<? extends EntityType<? extends Entity>> type, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        this.typeSupplier = type;
        UNADDED_EGGS.add(this);
    }

    public static void initUnaddedEggs() {
        DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getLevel(), stack, null, source.getPos().offset(direction),
                        MobSpawnType.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEgg : UNADDED_EGGS) {
            BY_ID.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerBehavior(spawnEgg, dispenseItemBehavior);
        }

        UNADDED_EGGS.clear();
        BY_ID.remove(null);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundTag compoundNBT) {
        if (compoundNBT != null && compoundNBT.contains("EntityTag", 10)) {
            CompoundTag entityTagNBT = compoundNBT.getCompound("EntityTag");
            if (entityTagNBT.contains("id", 8)) {
                return EntityType.byString(entityTagNBT.getString("id")).orElse(this.typeSupplier.get());
            }
        }

        return this.typeSupplier.get();
    }*/
}
