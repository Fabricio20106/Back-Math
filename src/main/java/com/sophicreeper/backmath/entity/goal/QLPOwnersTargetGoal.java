package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;

import java.util.EnumSet;

public class QLPOwnersTargetGoal extends TargetGoal {
    private final QueenLucyPetEntity lucyPet;
    private LivingEntity attacker;
    private int timestamp;

    public QLPOwnersTargetGoal(QueenLucyPetEntity lucyPet) {
        super(lucyPet, false);
        this.lucyPet = lucyPet;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    public boolean canUse() {
        if (this.lucyPet.isTame() && !this.lucyPet.isOrderedToSit()) {
            LivingEntity qlpOwner = this.lucyPet.getOwner();
            if (qlpOwner == null) {
                return false;
            } else {
                this.attacker = qlpOwner.getLastHurtMob();
                int timeSinceAttackedMob = qlpOwner.getLastHurtMobTimestamp();
                return timeSinceAttackedMob != this.timestamp && this.canAttack(this.attacker, EntityPredicate.DEFAULT) && this.lucyPet.wantsToAttack(this.attacker, qlpOwner);
            }
        } else {
            return false;
        }
    }

    // Execute a one shot task or start executing a continuous task.
    public void start() {
        this.mob.setTarget(this.attacker);
        LivingEntity qlpOwner = this.lucyPet.getOwner();
        if (qlpOwner != null) this.timestamp = qlpOwner.getLastHurtMobTimestamp();
        super.start();
    }
}
