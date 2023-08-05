package com.sophicreeper.backmath.core.world.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class CrystallizerItem extends BlockItem {
    public CrystallizerItem(RegistryObject<Block> block, Properties properties) {
        super(block.get(), properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("messages.backmath.hold_shift"));
        tooltip.add(Component.translatable(this.getDescriptionId() + ".desc"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
