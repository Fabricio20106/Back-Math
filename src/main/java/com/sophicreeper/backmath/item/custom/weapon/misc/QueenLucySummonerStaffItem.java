package com.sophicreeper.backmath.item.custom.weapon.misc;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.sophicreeper.backmath.dispenser.QLSSDispenseBehavior;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

// The Queen Lucy's Summoner Staff is mostly a copy of the BMSpawnEggItem class
// June 01/06/24 - Mace-ified the Q.L.S.S.
public class QueenLucySummonerStaffItem extends SpawnEggItem implements IVanishable {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public QueenLucySummonerStaffItem(Properties properties) {
        super(null, 0xFFFFFF, 0xFFFFFF, properties);
        DispenserBlock.registerBehavior(this, new QLSSDispenseBehavior());
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Q.L.S.S. Attack Damage Modifier", 9, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Q.L.S.S. Swing Speed Modifier", -3, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) attacker;
            if (canDoSmashAttack(serverPlayer)) {
                ServerWorld world = (ServerWorld) attacker.level;
                serverPlayer.setDeltaMovement(with(serverPlayer.getDeltaMovement(), Direction.Axis.Y, 0.009999999776482582));
                target.hurt(DamageSource.playerAttack(serverPlayer), getAttackDamageBonus(DamageSource.playerAttack(serverPlayer)));
                if (target.isOnGround()) {
                    // Smash Particles
                    Vector3d vector3D = Vector3d.atCenterOf(target.blockPosition()).add(0, 0.5, 0);
                    int particlesPerDistance = (int) MathHelper.clamp(50 * attacker.fallDistance, 0, 500);
                    world.sendParticles(new BlockParticleData(ParticleTypes.BLOCK, world.getBlockState(target.blockPosition().below())), vector3D.x, vector3D.y, vector3D.z, particlesPerDistance, 0.30000001192092896, 0.30000001192092896,
                            0.30000001192092896, 0.15000000596046448);

                    // Smash Sounds (anvil sounds as of now)
                    SoundEvent smashSound = serverPlayer.fallDistance > 5 ? BMSounds.ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_GROUND_HEAVY : BMSounds.ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_GROUND;
                    world.playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), smashSound, serverPlayer.getSoundSource(), 1, 1);
                } else {
                    world.playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), BMSounds.ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_AIR, serverPlayer.getSoundSource(), 1, 1);
                }
                knockback(world, serverPlayer, target);
                serverPlayer.fallDistance = 0;
            }
        }
        stack.hurtAndBreak(1, attacker, player -> player.broadcastBreakEvent(Hand.MAIN_HAND));
        return true;
    }

    public float getAttackDamageBonus(DamageSource source) {
        Entity directEntity = source.getDirectEntity();
        if (directEntity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) directEntity;
            if (!canDoSmashAttack(livEntity)) {
                return 0;
            } else {
                float fallDistance = livEntity.fallDistance;
                float damageBonus;
                if (fallDistance <= 3) {
                    damageBonus = 4 * fallDistance;
                } else if (fallDistance <= 8) {
                    damageBonus = 12 + 2 * (fallDistance - 3);
                } else {
                    damageBonus = 22 + fallDistance - 8;
                }
                return damageBonus;
            }
        } else {
            return 0;
        }
    }

    public Vector3d with(Vector3d originalVector, Direction.Axis axis, double velocity) {
        double x = axis == Direction.Axis.X ? velocity : originalVector.x;
        double y = axis == Direction.Axis.Y ? velocity : originalVector.y;
        double z = axis == Direction.Axis.Z ? velocity : originalVector.z;
        return new Vector3d(x, y, z);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT tag) {
        if (tag != null && tag.contains("entity_tag", 10)) {
            CompoundNBT entityTag = tag.getCompound("entity_tag");
            if (entityTag.contains("id", 8)) return EntityType.byString(entityTag.getString("id")).orElse(BMEntities.QUEEN_LUCY_PET.get());
        }
        return BMEntities.QUEEN_LUCY_PET.get();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
        return slot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean canAttackBlock(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public boolean isValidRepairItem(ItemStack thisStack, ItemStack repairStack) {
        return repairStack.getItem().is(BMTags.Items.INGOTS_OBSIDIAN);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        // Terraria like tooltip, also says what food is used to tame her. Like parrots that don't like cookies, QSP's don't like aljame.
        tooltip.add(new TranslationTextComponent("tooltip.backmath.queen_lucy_summoner_staff").withStyle(TextFormatting.ITALIC));
        tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.SHARPNESS || enchantment == Enchantments.MOB_LOOTING || enchantment == Enchantments.FIRE_ASPECT || enchantment == Enchantments.SMITE || enchantment == Enchantments.BANE_OF_ARTHROPODS ||
                enchantment == Enchantments.SWEEPING_EDGE  || enchantment == Enchantments.KNOCKBACK || super.canApplyAtEnchantingTable(stack, enchantment);
    }

    private static void knockback(World world, PlayerEntity player, Entity entity) {
        world.levelEvent(2013, entity.getOnPos(), 750);
        world.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(3.5), knockbackPredicate(player, entity)).forEach((livEntity) -> {
            Vector3d vector3D = livEntity.position().subtract(entity.position());
            double knockbackPower = getKnockbackPower(player, livEntity, vector3D);
            Vector3d vector3D1 = vector3D.normalize().scale(knockbackPower);
            if (knockbackPower > 0) livEntity.push(vector3D1.x, 0.699999988079071, vector3D1.z);
        });
    }

    // Mace methods backported from 1.21 Pre-Release 1.
    private static Predicate<LivingEntity> knockbackPredicate(PlayerEntity player, Entity entity) {
        return (livEntity) -> {
            boolean bool;
            boolean notSpectator;
            boolean typeCheck;
            boolean notSameTeamAs;
            label62: {
                notSpectator = !livEntity.isSpectator();
                typeCheck = livEntity != player && livEntity != entity;
                notSameTeamAs = !player.isAlliedTo(livEntity);
                if (livEntity instanceof TameableEntity) {
                    TameableEntity tameableEntity = (TameableEntity) livEntity;
                    if (tameableEntity.isTame() && player.getUUID().equals(tameableEntity.getOwnerUUID())) {
                        bool = true;
                        break label62;
                    }
                }
                bool = false;
            }

            boolean notBool;
            notMarkerStand: {
                notBool = !bool;
                if (livEntity instanceof ArmorStandEntity) {
                    ArmorStandEntity armorStand = (ArmorStandEntity) livEntity;
                    if (armorStand.isMarker()) {
                        break notMarkerStand;
                    }
                }

                bool = true;
            }
            return notSpectator && typeCheck && notSameTeamAs && notBool && bool && entity.distanceToSqr(livEntity) <= Math.pow(3.5, 2);
        };
    }

    private static double getKnockbackPower(PlayerEntity player, LivingEntity livEntity, Vector3d vector3D) {
        return (3.5 - vector3D.length()) * 0.699999988079071 * (double) (player.fallDistance > 5 ? 2 : 1) * (1 - livEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
    }

    public static boolean canDoSmashAttack(LivingEntity livEntity) {
        return livEntity.fallDistance > 1.5F && !livEntity.isFallFlying();
    }
}
