package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.item.behavior.BMItemBehaviors;
import com.sophicreeper.backmath.item.behavior.ItemBehavior;
import com.sophicreeper.backmath.item.behavior.effecttype.ItemBehaviorEffectType;
import com.sophicreeper.backmath.item.custom.Swappable;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class CrownItem extends Item implements Swappable {
    private final Supplier<ItemBehavior> behavior;

    public CrownItem(Supplier<ItemBehavior> behavior, Properties properties) {
        super(properties);
        this.behavior = behavior;
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public CrownItem(Properties properties) {
        this(BMItemBehaviors.NONE, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity attacker, Entity target) {
        if (target instanceof LivingEntity) this.behavior.get().run(stack, attacker, (LivingEntity) target, target.level);
        return super.onLeftClickEntity(stack, attacker, target);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (ModList.get().isLoaded("variants")) return this.equipOrSwapItem(this, world, player, hand);
        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (!this.behavior.get().effects.isEmpty()) tooltip.add(new TranslationTextComponent("tooltip.backmath.behavior.when_used").withStyle(TextFormatting.GRAY));
        for (Supplier<ItemBehaviorEffectType> type : this.behavior.get().effects) {
            if (type != null) type.get().addToTooltip(stack, world, tooltip, flag);
        }
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return this.behavior.get().hasGlint(stack) || super.isFoil(stack);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return this.behavior.get().getDurabilityBarColor(super.getRGBDurabilityForDisplay(stack));
    }
}
