package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.item.custom.MidTermToolBehaviors;
import com.sophicreeper.backmath.util.BMDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MidTermArmorItem extends BMArmorItem implements MidTermToolBehaviors {
    public MidTermArmorItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }

    // Needs more testing/changing to work.
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (stack.getMaxDamage() <= stack.getDamageValue()) {
            world.explode(player, BMDamageSources.MID_TERM_ARMOR_INSTABILITY, null, player.getX(), player.getY(), player.getZ(), 8, false, Explosion.Mode.DESTROY);
            stack.shrink(1);
        }
        super.onArmorTick(stack, world, player);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) midTermEffects(stack, (LivingEntity) entity);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
