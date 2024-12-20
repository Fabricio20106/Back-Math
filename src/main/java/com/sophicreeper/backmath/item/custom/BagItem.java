package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.dispenser.BagDispenseBehavior;
import com.sophicreeper.backmath.loot.BMLootTableUtils;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class BagItem extends Item {
    private final ResourceLocation defaultLootTable;

    public BagItem(ResourceLocation defaultLootTable, Properties properties) {
        super(properties);
        this.defaultLootTable = defaultLootTable;
        DispenserBlock.registerBehavior(this, new BagDispenseBehavior());
    }

    public ResourceLocation getDefaultLootTable() {
        return this.defaultLootTable;
    }

    public ItemStack getStack() {
        return getStack(this.defaultLootTable);
    }

    public ItemStack getStack(ResourceLocation lootTable) {
        ItemStack stack = new ItemStack(this);
        stack.getOrCreateTag().putString("loot_table", lootTable.toString());
        return stack;
    }

    protected ResourceLocation getLootTable(ItemStack stack) {
        CompoundNBT tag = stack.getOrCreateTag();
        if (tag.contains("loot_table")) {
            ResourceLocation tableLoc = ResourceLocation.tryParse(tag.getString("loot_table"));
            if (tableLoc != null) return tableLoc;
        }
        return this.defaultLootTable;
    }

    protected Collection<ItemStack> getLootTableDrops(ItemStack handStack, ServerPlayerEntity playerEntity) {
        return BMLootTableUtils.giftFromPlayer(getLootTable(handStack), playerEntity);
    }

    // Copied from LootContainerItem.java by SilentChaos512 (repository SilentLib)
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getItemInHand(hand);
        if (!(player instanceof ServerPlayerEntity)) {
            return ActionResult.success(handStack);
        }

        // Generate items from the bag loot table, and give those items to the player.
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
        Collection<ItemStack> lootTableDrops = this.getLootTableDrops(handStack, serverPlayer);

        if (lootTableDrops.isEmpty()) LogManager.getLogger().warn(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.bag.no_drops",
                handStack.getItem().getRegistryName(), getLootTable(handStack))).getString());
        if (lootTableDrops.isEmpty()) {
            player.displayClientMessage(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.bag.no_drops",
                    new StringTextComponent(handStack.getItem().getRegistryName().toString()).withStyle((style -> style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new HoverEvent.ItemHover(handStack))).withUnderlined(true))),
                    getLootTable(handStack)))
                    .withStyle(TextFormatting.ITALIC).withStyle(TextFormatting.GRAY), false);
        }
        lootTableDrops.forEach(serverPlayer::addItem);

        // Play the item pickup sound.
        BMUtils.playItemPickupSound(serverPlayer);
        handStack.shrink(1);
        return ActionResult.success(handStack);
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> items) {
        if (this.allowdedIn(tab)) items.add(this.getStack());
    }
}
