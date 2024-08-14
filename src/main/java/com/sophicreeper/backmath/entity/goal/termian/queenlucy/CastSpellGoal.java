package com.sophicreeper.backmath.entity.goal.termian.queenlucy;

import com.sophicreeper.backmath.entity.custom.QueenLucyEntity;
import com.sophicreeper.backmath.misc.BMSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.SoundEvent;

import javax.annotation.Nullable;
import java.util.EnumSet;

// Renamed class, and added some code from SpellcastingIllagerEntity.CastingASpellGoal to match the behavior of Evokers more. - June 21/04/24 (Sunday)
public abstract class CastSpellGoal extends Goal {
    private final QueenLucyEntity queenLucy;
    protected int warmupTicks;
    protected int spellCooldown;

    public CastSpellGoal(QueenLucyEntity queenLucy) {
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        this.queenLucy = queenLucy;
    }

    @Override
    public boolean canUse() {
        LivingEntity lucyTarget = this.queenLucy.getTarget();
        if (lucyTarget != null && lucyTarget.isAlive()) {
            if (this.queenLucy.isCastingSpell()) {
                return false;
            } else {
                return this.queenLucy.tickCount >= this.spellCooldown;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        LivingEntity lucyTarget = this.queenLucy.getTarget();
        return lucyTarget != null && lucyTarget.isAlive() && this.warmupTicks > 0;
    }

    @Override
    public void start() {
        this.warmupTicks = this.castWarmupTicks();
        this.queenLucy.spellCooldownTicks = this.castingTime();
        this.spellCooldown = this.queenLucy.tickCount + this.castingInterval();
        SoundEvent prepareSpellSound = this.getSpellPrepareSound();
        if (prepareSpellSound != null) this.queenLucy.playSound(prepareSpellSound, 1, 1);
        this.queenLucy.setSpellType(this.spellType());
    }

    @Override
    public void stop() {
        super.stop();
        this.queenLucy.setSpellType(QueenLucySpells.NONE);
    }

    @Override
    public void tick() {
        --this.warmupTicks;
        if (this.warmupTicks == 0) {
            this.castSpell();
            this.queenLucy.playSound(this.queenLucy.getSpellSound(), 1, 1);
        }
        if (this.queenLucy.getTarget() != null) {
            this.queenLucy.getLookControl().setLookAt(this.queenLucy.getTarget(), this.queenLucy.getMaxHeadYRot(), this.queenLucy.getMaxHeadXRot());
        }
    }

    @Nullable
    protected SoundEvent getSpellPrepareSound() {
        return BMSounds.ENTITY_QUEEN_LUCY_PREPARE_SUMMON;
    }

    public abstract void castSpell();

    public int castWarmupTicks() {
        return 20;
    }

    public abstract int castingTime();

    public abstract int castingInterval();

    public abstract QueenLucySpells spellType();
}
