package com.sophicreeper.backmath.core.world.item.weapon.misc;

import com.sophicreeper.backmath.core.world.entity.misc.ChocoGlueProjEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChocoGlueItem extends Item {
    public ChocoGlueItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL,
                0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClientSide) {
            ChocoGlueProjEntity chocoGlueProj = new ChocoGlueProjEntity(world, player);
            chocoGlueProj.setItem(heldStack);
            chocoGlueProj.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 1.5f, 1);
            world.addFreshEntity(chocoGlueProj);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            heldStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(heldStack, world.isClientSide());
    }
}
