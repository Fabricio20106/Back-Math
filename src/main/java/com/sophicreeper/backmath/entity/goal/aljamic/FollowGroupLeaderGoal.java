package com.sophicreeper.backmath.entity.goal.aljamic;

import com.sophicreeper.backmath.entity.custom.aljamic.AljamicGroupMemberEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class FollowGroupLeaderGoal extends Goal {
    private final AljamicGroupMemberEntity entity;
    private int timeToRecalculatePath;
    private int nextStartTick;

    public FollowGroupLeaderGoal(AljamicGroupMemberEntity entity) {
        this.entity = entity;
        this.nextStartTick = this.nextStartTick(entity);
    }

    private int nextStartTick(AljamicGroupMemberEntity entity) {
        return 200 + entity.getRandom().nextInt(200) % 20;
    }

    @Override
    public boolean canUse() {
        if (this.entity.hasFollowers()) {
            return false;
        } else if (this.entity.isFollower()) {
            return true;
        } else if (this.nextStartTick > 0) {
            --this.nextStartTick;
            return false;
        } else {
            this.nextStartTick = this.nextStartTick(this.entity);
            Predicate<AljamicGroupMemberEntity> leaderPredicate = member -> member.canBeFollowed() || !member.isFollower();
            List<AljamicGroupMemberEntity> membersList = this.entity.level.getEntitiesOfClass(this.entity.getClass(), this.entity.getBoundingBox().inflate(8, 8, 8), leaderPredicate);
            AljamicGroupMemberEntity memberEntity = membersList.stream().filter(AljamicGroupMemberEntity::canBeFollowed).findAny().orElse(this.entity);
            memberEntity.addFollowers(membersList.stream().filter(member -> !member.isFollower()));
            return this.entity.isFollower();
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.entity.isFollower() && this.entity.isInRangeOfLeader();
    }

    @Override
    public void start() {
        this.timeToRecalculatePath = 0;
    }

    @Override
    public void stop() {
        this.entity.stopFollowing();
    }

    @Override
    public void tick() {
        if (--this.timeToRecalculatePath <= 0) {
            this.timeToRecalculatePath = 40;
            this.entity.pathfindToLeader();
        }
    }
}
