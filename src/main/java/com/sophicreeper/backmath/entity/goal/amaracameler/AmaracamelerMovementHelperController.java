package com.sophicreeper.backmath.entity.goal.amaracameler;

import com.sophicreeper.backmath.entity.custom.aljan.AmaracamelerEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;

public class AmaracamelerMovementHelperController extends MovementController {
    private final AmaracamelerEntity amaracameler;
    private float yRot;
    private int jumpDelay;
    private boolean isAggressive;

    public AmaracamelerMovementHelperController(AmaracamelerEntity amaracameler) {
        super(amaracameler);
        this.amaracameler = amaracameler;
        this.yRot = 180 * amaracameler.yRot / (float) Math.PI;
    }

    public void setDirection(float yaw, boolean aggressive) {
        this.yRot = yaw;
        this.isAggressive = aggressive;
    }

    public void setSpeed(double speed) {
        this.speedModifier = speed;
        this.operation = MovementController.Action.MOVE_TO;
    }

    public void tick() {
        this.mob.yRot = this.rotlerp(this.mob.yRot, this.yRot, 90);
        this.mob.yHeadRot = this.mob.yRot;
        this.mob.yBodyRot = this.mob.yRot;
        if (this.operation != MovementController.Action.MOVE_TO) {
            this.mob.setZza(0);
        } else {
            this.operation = MovementController.Action.WAIT;
            if (this.mob.isOnGround()) {
                this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                if (this.jumpDelay-- <= 0) {
                    this.jumpDelay = this.amaracameler.getJumpDelay();
                    if (this.isAggressive) {
                        this.jumpDelay /= 3;
                    }

                    this.amaracameler.getJumpControl().jump();
                    if (this.amaracameler.makesSoundOnJump()) {
                        this.amaracameler.playSound(this.amaracameler.getJumpSound(), this.amaracameler.getSoundVolume(), this.amaracameler.getSoundPitch());
                    }
                } else {
                    this.amaracameler.xxa = 0;
                    this.amaracameler.zza = 0;
                    this.mob.setSpeed(0);
                }
            } else {
                this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            }
        }
    }
}