package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.QueenLucyPet;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;

import java.util.EnumSet;

public class QLPOwnersTargetGoal extends TargetGoal {
    private final QueenLucyPet queenLucyPet;
    private LivingEntity attacker;
    private int timestamp;

    public QLPOwnersTargetGoal(QueenLucyPet queenLucyPet) {
        super(queenLucyPet, false);
        this.queenLucyPet = queenLucyPet;
        this.setMutexFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    public boolean shouldExecute() {
        if (this.queenLucyPet.isTamed() && !this.queenLucyPet.isSitting()) {
            LivingEntity qlpOwner = this.queenLucyPet.getOwner();
            if (qlpOwner == null) {
                return false;
            } else {
                this.attacker = qlpOwner.getLastAttackedEntity();
                int timeSinceAttackedMob = qlpOwner.getLastAttackedEntityTime();
                return timeSinceAttackedMob != this.timestamp && this.isSuitableTarget(this.attacker, EntityPredicate.DEFAULT) && this.isSuitableTarget(this.attacker, EntityPredicate.DEFAULT.setCustomPredicate((livEntity -> !livEntity.getType().isContained(
                        BMTags.EntityTypes.QLP_CANNOT_TARGET)))) && this.queenLucyPet.shouldAttackEntity(this.attacker, qlpOwner);
            }
        } else {
            return false;
        }
    }

    // Execute a one shot task or start executing a continuous task.
    public void startExecuting() {
        this.goalOwner.setAttackTarget(this.attacker);
        LivingEntity qlpOwner = this.queenLucyPet.getOwner();
        if (qlpOwner != null) this.timestamp = qlpOwner.getLastAttackedEntityTime();
        super.startExecuting();
    }
}
