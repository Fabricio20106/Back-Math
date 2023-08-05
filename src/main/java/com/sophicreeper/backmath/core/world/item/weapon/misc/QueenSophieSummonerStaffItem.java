package com.sophicreeper.backmath.core.world.item.weapon.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

// The Queen Sophie's Summoner Staff is a copy of the BMSpawnEggItem class
public class QueenSophieSummonerStaffItem /*extends SpawnEggItem*/ extends Item {
    /*private static final List<QueenSophieSummonerStaffItem> UNADDED_EGGS = Lists.newArrayList();
    private final Supplier<? extends EntityType<? extends Entity>> typeSupplier;

    public QueenSophieSummonerStaffItem(Supplier<? extends EntityType<? extends Entity>> type, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        this.typeSupplier = type;
        UNADDED_EGGS.add(this);
    }*/

    public QueenSophieSummonerStaffItem(Properties properties) {
        super(properties);
    }

    /*public static void initUnaddedEggs() {
        DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction),
                        SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEgg : UNADDED_EGGS) {
            EGGS.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerDispenseBehavior(spawnEgg, dispenseItemBehavior);
        }

        UNADDED_EGGS.clear();
        EGGS.remove(null);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT compoundNBT) {
        if (compoundNBT != null && compoundNBT.contains("EntityTag", 10)) {
            CompoundNBT entityTagNBT = compoundNBT.getCompound("EntityTag");
            if (entityTagNBT.contains("id", 8)) {
                return EntityType.byKey(entityTagNBT.getString("id")).orElse(this.typeSupplier.get());
            }
        }

        return this.typeSupplier.get();
    }*/

    // Adds tooltips for this item:
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        // Supposed to be an empty space to represent an actual weapon, like a sword.
        tooltip.add(Component.translatable("tooltip.backmath.empty"));
        // "When in main hand:".
        tooltip.add(Component.translatable("tooltip.backmath.when.in_main_hand"));
        // Queen Sophie pets deal 17 damage, the "summon" damage is inspired by Terraria.
        tooltip.add(Component.translatable("tooltip.backmath.qsss_summon_damage"));
        // Terraria like tooltip, also says what food is used to tame her. Like parrots that don't like cookies, QSP's don't like aljame.
        tooltip.add(Component.translatable("tooltip.backmath.qsss_desc"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
