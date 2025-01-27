package com.sophicreeper.backmath.item.custom.tool.misc;

import com.sophicreeper.backmath.item.behavior.BMItemBehaviors;
import com.sophicreeper.backmath.item.custom.behavior.BMSwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class WaterTalcPowderItem extends BMSwordItem {
    public WaterTalcPowderItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(BMItemBehaviors.WATER_TALC_POWDER, tier, attackDamage, swingSpeed, properties);
        this.cancelAttackBehavior = true;
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) this.getBehavior().get().run(stack, (PlayerEntity) livEntity, livEntity, world);
        return super.finishUsingItem(stack, world, livEntity);
    }
}
