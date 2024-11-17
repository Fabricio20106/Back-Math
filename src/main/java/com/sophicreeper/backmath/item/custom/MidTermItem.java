package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.crystallizer.item.CrystallizerMaterialItem;
import com.sophicreeper.backmath.item.custom.food.VSConsumable;
import com.sophicreeper.backmath.util.BMKeys;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.IntArrayNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class MidTermItem extends CrystallizerMaterialItem {
    public MidTermItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.getTag() != null && stack.getTag().contains("supercharge_duration", TagTypes.ANY_NUMERIC);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        CompoundNBT tag = stack.getTag();
        if (tag != null && tag.contains("supercharge_duration", TagTypes.ANY_NUMERIC)) {
            tag.putInt("supercharge_duration", tag.getInt("supercharge_duration") + 1);
            if (tag.getInt("supercharge_duration") >= 12000) {
                stack.shrink(1);
                tag.remove("connected_players");
                tag.remove("supercharge_duration");
                world.playSound(null, entity.blockPosition(), SoundEvents.ENDER_EYE_DEATH, SoundCategory.PLAYERS, 1, 1);
                world.playSound(null, entity.blockPosition(), SoundEvents.BEACON_DEACTIVATE, SoundCategory.PLAYERS, 1, 1.5F);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return stack.getTag() != null && stack.getTag().contains("supercharge_duration", TagTypes.ANY_NUMERIC);
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        CompoundNBT tag = stack.getTag();
        return tag != null && tag.contains("supercharge_duration", TagTypes.ANY_NUMERIC) ? ((double) tag.getInt("supercharge_duration") / 12000D) : 0;
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            world.playSound(null, player.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundCategory.PLAYERS, 1, 1.5F);
            world.playSound(null, player.blockPosition(), SoundEvents.ENDER_EYE_DEATH, SoundCategory.PLAYERS, 1, 1);

            //world.getNearbyPlayers(EntityPredicate.DEFAULT.ignoreInvisibilityTesting(), player, new AxisAlignedBB(player.blockPosition()).inflate(8))
            List<ServerPlayerEntity> nearbyPlayers = world.getServer().getPlayerList().getPlayers();
            for (PlayerEntity player1 : nearbyPlayers) {
                CompoundNBT tag = stack.getOrCreateTag();
                if (!tag.contains("connected_players", TagTypes.LIST)) {
                    ListNBT connectedPlayers = new ListNBT();
                    connectedPlayers.add(NBTUtil.createUUID(player1.getUUID()));
                    tag.put("connected_players", connectedPlayers);
                    tag.putInt("supercharge_duration", 0);
                }
            }

            VSConsumable.applyCooldown(stack, player, 40);
            player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            return ActionResult.sidedSuccess(stack, true);
        }
        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        CompoundNBT tag = stack.getTag();
        if (tag != null && tag.contains("supercharge_duration", TagTypes.ANY_NUMERIC)) {
            tooltip.add(new TranslationTextComponent("tooltip.backmath.mid_term.supercharge_timer", StringUtils.formatTickDuration(stack.getTag().getInt("supercharge_duration"))).withStyle(TextFormatting.GRAY));
        }
        if (tag != null && tag.contains("connected_players", TagTypes.LIST) && world != null) {
            ListNBT connectedPlayers = tag.getList("connected_players", TagTypes.INTEGER_ARRAY);
            IFormattableTextComponent component = new TranslationTextComponent("tooltip.backmath.mid_term.connected_players").withStyle(TextFormatting.GRAY);
            for (int i = 0; i < connectedPlayers.size(); ++i) {
                UUID uuid = UUIDCodec.uuidFromIntArray(connectedPlayers.getIntArray(i));

                if (i > 0) {
                    TranslationTextComponent separatorComponent = new TranslationTextComponent("tooltip.backmath.comma_separator");
                    if (i == connectedPlayers.size() - 1) separatorComponent = new TranslationTextComponent("tooltip.backmath.and_separator");
                    component.append(separatorComponent).withStyle(TextFormatting.GRAY);
                }
                PlayerEntity player = world.getPlayerByUUID(uuid);
                component.append(player == null ? new StringTextComponent("") : player.getName());
            }
            tooltip.add(component);
        }

        if (!BMKeys.isShiftDown()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift", BMKeys.getTranslation(BMKeys.SHOW_TOOLTIPS_KEY).withStyle(TextFormatting.GRAY)).withStyle(TextFormatting.DARK_GRAY));
        if (BMKeys.isShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift", BMKeys.getTranslation(BMKeys.SHOW_TOOLTIPS_KEY).withStyle(TextFormatting.WHITE)).withStyle(TextFormatting.DARK_GRAY));
            tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".mid_term"));
        }
    }
}
