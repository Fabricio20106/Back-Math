package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;

import java.util.EnumSet;

public class QLPOwnersTargetGoal extends TargetGoal {
    private final QueenLucyPetEntity queenLucyPet;
    private LivingEntity attacker;
    private int timestamp;

    public QLPOwnersTargetGoal(QueenLucyPetEntity queenLucyPet) {
        super(queenLucyPet, false);
        this.queenLucyPet = queenLucyPet;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    public boolean canUse() {
        if (this.queenLucyPet.isTame() && !this.queenLucyPet.isOrderedToSit()) {
            LivingEntity qlpOwner = this.queenLucyPet.getOwner();
            if (qlpOwner == null) {
                return false;
            } else {
                this.attacker = qlpOwner.getLastHurtMob();
                int timeSinceAttackedMob = qlpOwner.getLastHurtMobTimestamp();
                return timeSinceAttackedMob != this.timestamp && this.canAttack(this.attacker, EntityPredicate.DEFAULT) && this.canAttack(this.attacker, EntityPredicate.DEFAULT.selector((livEntity -> !livEntity.getType().is(
                        BMEntityTypeTags.QLP_CANNOT_TARGET)))) && this.queenLucyPet.wantsToAttack(this.attacker, qlpOwner);
            }
        } else {
            return false;
        }
    }

    // Execute a one shot task or start executing a continuous task.
    public void start() {
        this.mob.setTarget(this.attacker);
        LivingEntity qlpOwner = this.queenLucyPet.getOwner();
        if (qlpOwner != null) this.timestamp = qlpOwner.getLastHurtMobTimestamp();
        super.start();
    }
}
