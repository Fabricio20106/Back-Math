package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.sophicreeper.backmath.effect.BMEffects;
import com.sophicreeper.backmath.item.custom.MidTermToolBehaviors;
import com.sophicreeper.backmath.item.custom.tool.BMBowItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class MidTermBowItem extends BMBowItem implements MidTermToolBehaviors {
    public MidTermBowItem(Properties properties) {
        super(COMMON_CONFIGS.midTermBowFCA.get(), COMMON_CONFIGS.midTermBowCBD.get(), COMMON_CONFIGS.midTermBowAAD.get(), COMMON_CONFIGS.midTermBowFIT.get(), COMMON_CONFIGS.midTermBowFRD.get(), properties);
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
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (entity instanceof LivingEntity) this.useDuration = ((LivingEntity) entity).hasEffect(BMEffects.SUPERCHARGED.get()) ? 11 : COMMON_CONFIGS.midTermBowFRD.get();
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity livEntity, int count) {
        if (count == 1) this.onPlayerStoppedUsing(stack, livEntity.level, livEntity, count);
    }

    @Override
    public AbstractArrowEntity customArrow(AbstractArrowEntity oldArrow) {
        ArrowEntity arrow = new ArrowEntity(oldArrow.level, oldArrow.getX(), oldArrow.getY(), oldArrow.getZ());
        for (EffectInstance instance : this.getAppliedEffects()) arrow.addEffect(instance);
        return arrow;
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
