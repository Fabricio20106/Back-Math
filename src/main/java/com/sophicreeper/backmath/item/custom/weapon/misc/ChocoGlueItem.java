package com.sophicreeper.backmath.item.custom.weapon.misc;

import com.sophicreeper.backmath.entity.custom.ChocoGlueProjEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ChocoGlueItem extends Item {
    public ChocoGlueItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldStack = player.getHeldItem(hand);
        world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL,
                0.5f, 0.4f / (random.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote) {
            ChocoGlueProjEntity chocoGlueProj = new ChocoGlueProjEntity(world, player);
            chocoGlueProj.setItem(heldStack);
            chocoGlueProj.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0, 1.5f, 1);
            world.addEntity(chocoGlueProj);
        }

        player.addStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.isCreativeMode) {
            heldStack.shrink(1);
        }

        return ActionResult.func_233538_a_(heldStack, world.isRemote());
    }
}
