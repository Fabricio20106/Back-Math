package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.BagItem;
import com.sophicreeper.backmath.loot.BMLootTableUtils;
import com.sophicreeper.backmath.util.BMResourceLocations;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class BagDispenseBehavior extends DefaultDispenseItemBehavior {
    @Override
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);
        Collection<ItemStack> lootTableDrops = this.getLootTableDrops(stack, source);
        if (lootTableDrops.isEmpty()) {
            LogManager.getLogger().warn(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.bag.no_drops",
                    stack.getItem().getRegistryName(), getLootTable(stack))).getString());
        }
        lootTableDrops.forEach(stack1 -> spawnItem(source.getLevel(), stack1, 6, direction, iPos));
        stack.shrink(1);
        return stack;
    }

    protected ResourceLocation getLootTable(ItemStack stack) {
        if (stack.getItem() == AxolotlTest.AMARACAMEL_BATTER_BAG.get()) {
            return BMResourceLocations.AMARACAMEL_BATTER_BAG;
        } else if (stack.getItem() == AxolotlTest.BOOT_PACK.get()) {
            return BMResourceLocations.BOOT_PACK;
        } else if (stack.getItem() instanceof BagItem) {
            BagItem bagItem = (BagItem) stack.getItem();
            CompoundNBT bagLoot = bagItem.getStack().getOrCreateTagElement("bag_loot");
            if (bagLoot.contains("loot_table")) {
                String lootTable = bagLoot.getString("loot_table");
                ResourceLocation tableLoc = ResourceLocation.tryParse(lootTable);
                if (tableLoc != null) return tableLoc;
            }
        }
        return LootTables.EMPTY;
    }

    protected Collection<ItemStack> getLootTableDrops(ItemStack stack, IBlockSource source) {
        return BMLootTableUtils.giftFromDispenser(getLootTable(stack), source);
    }
}
