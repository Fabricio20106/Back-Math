package com.sophicreeper.backmath.entity.custom.termian;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.goal.termian.TermianPatrolGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class TermianPatrollerEntity extends CreatureEntity {
    private BlockPos patrolTarget;
    private boolean patrolLeader;
    private boolean patrolling;

    public TermianPatrollerEntity(EntityType<? extends CreatureEntity> mob, World world) {
        super(mob, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TermianPatrolGoal<>(this, 0.7D, 0.595D));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        if (this.patrolTarget != null) tag.put("patrol_target", NBTUtil.writeBlockPos(this.patrolTarget));
        tag.putBoolean("patrol_leader", this.patrolLeader);
        tag.putBoolean("is_patrolling", this.patrolling);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("patrol_target")) this.patrolTarget = NBTUtil.readBlockPos(tag.getCompound("patrol_target"));
        this.patrolLeader = tag.getBoolean("patrol_leader");
        this.patrolling = tag.getBoolean("is_patrolling");
    }

    @Override
    public double getMyRidingOffset() {
        return -0.35D;
    }

    public boolean canBePatrolLeader() {
        return true;
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT dataTag) {
        if (reason != SpawnReason.PATROL && reason != SpawnReason.EVENT && reason != SpawnReason.STRUCTURE && this.random.nextFloat() < 0.06F && this.canBePatrolLeader()) this.patrolLeader = true;

        if (this.isPatrolLeader()) {
            this.setItemSlot(EquipmentSlotType.HEAD, getTermianBannerInstance());
            this.setDropChance(EquipmentSlotType.HEAD, 2);
        }
        if (reason == SpawnReason.PATROL) this.patrolling = true;

        return super.finalizeSpawn(world, difficulty, reason, entityData, dataTag);
    }

    public static ItemStack getTermianBannerInstance() {
        ItemStack lightBlueBanner = new ItemStack(Items.LIGHT_BLUE_BANNER);
        CompoundNBT blockEntityTag = lightBlueBanner.getOrCreateTagElement("BlockEntityTag");
        ListNBT patterns = new BannerPattern.Builder().addPattern(BannerPattern.GRADIENT_UP, DyeColor.PURPLE).addPattern(BannerPattern.STRIPE_CENTER, DyeColor.LIGHT_BLUE).addPattern(
                BannerPattern.RHOMBUS_MIDDLE, DyeColor.CYAN).addPattern(BannerPattern.FLOWER, DyeColor.RED).addPattern(BannerPattern.FLOWER, DyeColor.YELLOW).toListTag();
        blockEntityTag.put("Patterns", patterns);
        lightBlueBanner.hideTooltipPart(ItemStack.TooltipDisplayFlags.ADDITIONAL);
        lightBlueBanner.setHoverName(new TranslationTextComponent("block." + BackMath.MOD_ID + ".termian_empire_banner").withStyle(Style.EMPTY.withColor(Color.fromRgb(0x1DC2D1)).withItalic(false)));
        return lightBlueBanner;
    }

    public static boolean checkTermianPatrolSpawnRules(EntityType<? extends TermianPatrollerEntity> patroller, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return world.getBrightness(LightType.BLOCK, pos) <= 8 && checkAnyLightMonsterSpawnRules(patroller, world, reason, pos, rand);
    }

    private static boolean checkAnyLightMonsterSpawnRules(EntityType<? extends CreatureEntity> mob, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return world.getDifficulty() != Difficulty.PEACEFUL && checkMobSpawnRules(mob, world, reason, pos, rand);
    }

    public boolean removeWhenFarAway(double distance) {
        return !this.patrolling || distance > 16384;
    }

    public void setPatrolTarget(BlockPos pos) {
        this.patrolTarget = pos;
        this.patrolling = true;
    }

    public BlockPos getPatrolTarget() {
        return this.patrolTarget;
    }

    public boolean hasPatrolTarget() {
        return this.patrolTarget != null;
    }

    public void setPatrolLeader(boolean leader) {
        this.patrolLeader = leader;
        this.patrolling = true;
    }

    public boolean isPatrolLeader() {
        return this.patrolLeader;
    }

    public boolean canJoinPatrol() {
        return true;
    }

    public void findPatrolTarget() {
        this.patrolTarget = this.blockPosition().offset(-500 + this.random.nextInt(1000), 0, -500 + this.random.nextInt(1000));
        this.patrolling = true;
    }

    public boolean isPatrolling() {
        return this.patrolling;
    }

    public void setPatrolling(boolean patrolling) {
        this.patrolling = patrolling;
    }
}
