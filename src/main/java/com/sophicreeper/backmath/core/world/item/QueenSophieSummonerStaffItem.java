package com.sophicreeper.backmath.core.world.item;

import com.google.common.collect.Lists;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

// The Queen Sophie's Summoner Staff is a copy of the BMSpawnEggItem class
public class QueenSophieSummonerStaffItem extends SpawnEggItem {
    private static final List<QueenSophieSummonerStaffItem> UNADDED_EGGS = Lists.newArrayList();
    private final Supplier<? extends EntityType<? extends Entity>> typeSupplier;

    public QueenSophieSummonerStaffItem(Supplier<? extends EntityType<? extends Entity>> typeIn, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        this.typeSupplier = typeIn;
        UNADDED_EGGS.add(this);
    }

    public static void initUnaddedEggs() {
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
            CompoundNBT compoundnbt = compoundNBT.getCompound("EntityTag");
            if (compoundnbt.contains("id", 8)) {
                return EntityType.byKey(compoundnbt.getString("id")).orElse(this.typeSupplier.get());
            }
        }

        return this.typeSupplier.get();
    }

    // Adds tooltips for this item:
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        // Supposed to be an empty space to represent an actual weapon, like a sword.
        tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
        // "When in main hand:".
        tooltip.add(new TranslationTextComponent("tooltip.backmath.when.in_main_hand"));
        // Queen Sophie pets deal 17 damage, the "summon" damage is inspired by Terraria.
        tooltip.add(new TranslationTextComponent("tooltip.backmath.qsss_summon_damage"));
        // Terraria like tooltip, also says what food is used to tame her. Like parrots that don't like cookies, QSP's don't like aljame.
        tooltip.add(new TranslationTextComponent("tooltip.backmath.qsss_desc"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
