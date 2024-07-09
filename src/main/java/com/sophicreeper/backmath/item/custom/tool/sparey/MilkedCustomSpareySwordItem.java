package com.sophicreeper.backmath.item.custom.tool.sparey;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.entity.custom.AngrySophie;
import com.sophicreeper.backmath.item.custom.tool.MilkedSwordItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MilkedCustomSpareySwordItem extends MilkedSwordItem {
    public MilkedCustomSpareySwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof AngrySophie) {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1));
        } else {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
