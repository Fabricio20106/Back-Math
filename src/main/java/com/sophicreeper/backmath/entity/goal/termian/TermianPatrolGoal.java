package com.sophicreeper.backmath.entity.goal.termian;

import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.gen.Heightmap;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class TermianPatrolGoal<T extends TermianPatrollerEntity> extends Goal {
    private final T termianMember;
    private final double speedModifier;
    private final double leaderSpeedModifier;
    private long cooldownUntil;

    public TermianPatrolGoal(T mob, double speedModifier, double leaderSpeedModifier) {
        this.termianMember = mob;
        this.speedModifier = speedModifier;
        this.leaderSpeedModifier = leaderSpeedModifier;
        this.cooldownUntil = -1L;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return this.termianMember.isPatrolling() && this.termianMember.getTarget() == null && !this.termianMember.isVehicle() && this.termianMember.hasPatrolTarget() && !(this.termianMember.level.getGameTime() < this.cooldownUntil);
    }

    @Override
    public void start() {}

    @Override
    public void stop() {}

    @Override
    public void tick() {
        boolean patrolLeader = this.termianMember.isPatrolLeader();
        PathNavigator pathNavigator = this.termianMember.getNavigation();
        if (pathNavigator.isDone()) {
            List<TermianPatrollerEntity> patrollers = this.findPatrolCompanions();
            if (this.termianMember.isPatrolling() && patrollers.isEmpty()) {
                this.termianMember.setPatrolling(false);
            } else if (patrolLeader && this.termianMember.getPatrolTarget().closerThan(this.termianMember.position(), 10)) {
                this.termianMember.findPatrolTarget();
            } else {
                Vector3d patrolTarget = Vector3d.atBottomCenterOf(this.termianMember.getPatrolTarget());
                Vector3d termianPos = this.termianMember.position();
                Vector3d vec3D = termianPos.subtract(patrolTarget);
                patrolTarget = vec3D.yRot(90).scale(0.4D).add(patrolTarget);
                Vector3d vec3D1 = patrolTarget.subtract(termianPos).normalize().scale(10).add(termianPos);
                BlockPos pos = new BlockPos(vec3D1);
                pos = this.termianMember.level.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos);
                if (!pathNavigator.moveTo(pos.getX(), pos.getY(), pos.getZ(), patrolLeader ? this.leaderSpeedModifier : this.speedModifier)) {
                    this.moveRandomly();
                    this.cooldownUntil = this.termianMember.level.getGameTime() + 200L;
                } else if (patrolLeader) {
                    for (TermianPatrollerEntity termianPatroller : patrollers) {
                        termianPatroller.setPatrolTarget(pos);
                    }
                }
            }
        }
    }

    private List<TermianPatrollerEntity> findPatrolCompanions() {
        return this.termianMember.level.getEntitiesOfClass(TermianPatrollerEntity.class, this.termianMember.getBoundingBox().inflate(16), (patroller) -> patroller.canJoinPatrol() && !patroller.is(this.termianMember));
    }

    private void moveRandomly() {
        Random rand = this.termianMember.getRandom();
        BlockPos pos = this.termianMember.level.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, this.termianMember.blockPosition().offset(-8 + rand.nextInt(16), 0, -8 + rand.nextInt(16)));
        this.termianMember.getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), this.speedModifier);
    }
}
