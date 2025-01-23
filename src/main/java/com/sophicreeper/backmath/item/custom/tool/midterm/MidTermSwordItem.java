package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.sophicreeper.backmath.item.behavior.BMItemBehaviors;
import com.sophicreeper.backmath.item.custom.MidTermToolBehaviors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

// TODO: work on this for now ~isa 23-1-25
public class MidTermSwordItem extends SwordItem implements MidTermToolBehaviors {
    public MidTermSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        // if (entity instanceof LivingEntity) midTermEffects(stack, (LivingEntity) entity);
        if (entity instanceof LivingEntity) BMItemBehaviors.MID_TERM.get().effects.run(stack, (LivingEntity) entity, entity.level);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMItemBehaviors.MID_TERM.get().getDurabilityBarColor().getAsInt();
    }
}
