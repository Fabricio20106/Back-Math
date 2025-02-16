package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.item.custom.behavior.BMArmorItem;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.World;

public class TurtleShellItem extends BMArmorItem {
    public TurtleShellItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        ItemStack shellStack = player.getItemBySlot(EquipmentSlotType.HEAD);
        if (shellStack.getItem().is(BMItemTags.PROVIDES_WATER_BREATHING) && !player.isEyeInFluid(FluidTags.WATER)) {
            player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        }
        super.onArmorTick(stack, world, player);
    }
}
