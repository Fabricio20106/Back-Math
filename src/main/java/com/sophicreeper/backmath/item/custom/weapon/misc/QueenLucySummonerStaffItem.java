package com.sophicreeper.backmath.item.custom.weapon.misc;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

// The Queen Lucy's Summoner Staff is a copy of the BMSpawnEggItem class
public class QueenLucySummonerStaffItem extends SpawnEggItem {
    private static final List<QueenLucySummonerStaffItem> BACKMATH_EGGS = Lists.newArrayList();
    private final Supplier<? extends EntityType<? extends Entity>> typeSupplier;
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public QueenLucySummonerStaffItem(Supplier<? extends EntityType<? extends Entity>> type, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Q.L.S.S. Attack Damage Modifier", 16, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Q.L.S.S. Swing Speed Modifier", -2.4F, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
        this.typeSupplier = type;
        BACKMATH_EGGS.add(this);
    }

    public static void initQueenLucyPet() {
        DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEggs : BACKMATH_EGGS) {
            EGGS.put(spawnEggs.getType(null), spawnEggs);
            DispenserBlock.registerDispenseBehavior(spawnEggs, dispenseItemBehavior);
        }

        BACKMATH_EGGS.clear();
        EGGS.remove(null);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            CompoundNBT entityTag = tag.getCompound("EntityTag");
            if (entityTag.contains("id", 8)) {
                return EntityType.byKey(entityTag.getString("id")).orElse(this.typeSupplier.get());
            }
        }

        return this.typeSupplier.get();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
        return slot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        // Terraria like tooltip, also says what food is used to tame her. Like parrots that don't like cookies, QSP's don't like aljame.
        tooltip.add(new TranslationTextComponent("tooltip.backmath.qlss_desc"));
        tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
    }
}
