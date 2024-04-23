package com.sophicreeper.backmath.entity.goal.queenlucy;

import com.sophicreeper.backmath.entity.custom.QueenLucy;
import com.sophicreeper.backmath.misc.BMSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.SoundEvent;

import javax.annotation.Nullable;
import java.util.EnumSet;

// Renamed class, and added some code from SpellcastingIllagerEntity.CastingASpellGoal to match the behavior of Evokers more. - June 21/04/24 (Sunday)
public abstract class CastSpellGoal extends Goal {
    private final QueenLucy queenLucy;
    protected int spellWarmup;
    protected int spellCooldown;

    public CastSpellGoal(QueenLucy queenLucy) {
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        this.queenLucy = queenLucy;
    }

    public boolean canUse() {
        LivingEntity lucyTarget = this.queenLucy.getTarget();
        if (lucyTarget != null && lucyTarget.isAlive() && this.queenLucy.getSpellTicks() > 0) {
            if (this.queenLucy.isCastingSpell()) {
                return false;
            } else {
                return this.queenLucy.tickCount >= this.spellCooldown;
            }
        } else {
            return false;
        }
    }

    public boolean canContinueToUse() {
        LivingEntity lucyTarget = this.queenLucy.getTarget();
        return lucyTarget != null && lucyTarget.isAlive() && this.spellWarmup > 0;
    }

    public void start() {
        this.spellWarmup = this.getCastWarmupTime();
        this.queenLucy.spellTicks = this.getCastingTime();
        this.spellCooldown = this.queenLucy.tickCount + this.getCastingInterval();
        SoundEvent prepareSpellSound = this.getSpellPrepareSound();
        if (prepareSpellSound != null) this.queenLucy.playSound(prepareSpellSound, 1, 1);
        this.queenLucy.setSpellType(this.getSpellType());
    }

    @Override
    public void stop() {
        super.stop();
        this.queenLucy.setSpellType(QueenLucySpells.NONE);
    }

    public void tick() {
        --this.spellWarmup;
        if (this.spellWarmup == 0) {
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

    protected abstract void castSpell();

    protected int getCastWarmupTime() {
        return 20;
    }

    protected abstract int getCastingTime();

    protected abstract int getCastingInterval();

    protected abstract QueenLucySpells getSpellType();
}
