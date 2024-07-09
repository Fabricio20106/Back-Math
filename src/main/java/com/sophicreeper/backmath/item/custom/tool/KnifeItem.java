package com.sophicreeper.backmath.item.custom.tool;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.sophicreeper.backmath.loot.BMLootTableUtils;
import com.sophicreeper.backmath.util.BMResourceLocations;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class KnifeItem extends ToolItem {
    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.GRASS, Blocks.TALL_GRASS, Blocks.FERN, Blocks.LARGE_FERN, Blocks.SEAGRASS, Blocks.TALL_SEAGRASS, Blocks.KELP, Blocks.KELP_PLANT, Blocks.CRIMSON_ROOTS, Blocks.WARPED_ROOTS, Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS, Blocks.NETHER_SPROUTS, Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS, Blocks.NETHER_WART, Blocks.SWEET_BERRY_BUSH, Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING);
    public static final Map<Block, ResourceLocation> CUTTING_MAP = new ImmutableMap.Builder<Block, ResourceLocation>().put(Blocks.PUMPKIN, BMResourceLocations.CUTTING_PUMPKIN).put(Blocks.CARVED_PUMPKIN, BMResourceLocations.CUTTING_CARVED_PUMPKIN).put(Blocks.JACK_O_LANTERN, BMResourceLocations.CUTTING_JACK_O_LANTERN).put(Blocks.MELON, BMResourceLocations.CUTTING_MELON).put(Blocks.HAY_BLOCK, BMResourceLocations.CUTTING_HAY_BLOCK).build();
    public static final ToolType KNIFE = ToolType.get("knife");

    public KnifeItem(float attackDamage, float swingSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, swingSpeed, tier, EFFECTIVE_ON, properties.addToolType(KNIFE, tier.getLevel()));
    }

    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (getToolTypes(stack).stream().anyMatch(state::isToolEffective)) return speed;
        return state.is(BMTags.Blocks.MINEABLE_KNIVES) ? this.speed : 1;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack container = stack.copy();
        if (container.hurt(1, random, null)) {
            return ItemStack.EMPTY;
        } else {
            return container;
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    @Nonnull
    public ActionResultType useOn(ItemUseContext context) {
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (CUTTING_MAP.containsKey(state.getBlock())) {
            Collection<ItemStack> lootTableDrops = this.getLootTableDrops(CUTTING_MAP.get(state.getBlock()), context);
            world.destroyBlock(pos, false, player);
            lootTableDrops.forEach(stack1 -> Block.popResource(world, pos, stack1));
            if (player != null) stack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
            return ActionResultType.SUCCESS;
        }
        return super.useOn(context);
    }

    protected Collection<ItemStack> getLootTableDrops(ResourceLocation cuttingTable, ItemUseContext context) {
        return BMLootTableUtils.dropFromCutting(cuttingTable, context);
    }
}
