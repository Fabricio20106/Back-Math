package com.sophicreeper.backmath.item.custom.tool.misc;

import com.sophicreeper.backmath.entity.custom.ChocoGlueProjEntity;
import com.sophicreeper.backmath.misc.BMSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ChocoGlueItem extends Item {
    public ChocoGlueItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getItemInHand(hand);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), BMSounds.ITEM_CHOCOGLUE_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world.isClientSide) {
            ChocoGlueProjEntity chocoGlueProj = new ChocoGlueProjEntity(world, player);
            chocoGlueProj.setItem(handStack);
            chocoGlueProj.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, 1);
            world.addFreshEntity(chocoGlueProj);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            handStack.shrink(1);
        }

        return ActionResult.sidedSuccess(handStack, world.isClientSide());
    }
}
