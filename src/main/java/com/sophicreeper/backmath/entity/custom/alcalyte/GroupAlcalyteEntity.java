package com.sophicreeper.backmath.entity.custom.alcalyte;

import com.sophicreeper.backmath.entity.goal.alcalyte.FollowGroupLeaderGoal;
import com.sophicreeper.backmath.entity.misc.AlcalyteGroupData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public class GroupAlcalyteEntity extends AlcalyteEntity {
    private GroupAlcalyteEntity groupLeader;
    private int groupSize = 1;

    public GroupAlcalyteEntity(EntityType<? extends GroupAlcalyteEntity> type, World world) {
        super(type, world);
    }

    public int getMaxGroupSize() {
        return 4;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new FollowGroupLeaderGoal(this));
    }

    public boolean isLeader() {
        return this.groupLeader == this;
    }

    public boolean isFollower() {
        return this.groupLeader != null && this.groupLeader.isAlive();
    }

    public GroupAlcalyteEntity startFollowing(GroupAlcalyteEntity leader) {
        this.groupLeader = leader;
        leader.addFollower();
        return leader;
    }

    public void stopFollowing() {
        this.groupLeader.removeFollower();
        this.groupLeader = null;
    }

    private void addFollower() {
        ++this.groupSize;
    }

    private void removeFollower() {
        --this.groupSize;
    }

    public boolean canBeFollowed() {
        return this.hasFollowers() && this.groupSize < this.getMaxGroupSize();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.hasFollowers() && this.level.random.nextInt(200) == 1) {
            List<GroupAlcalyteEntity> memberList = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8, 8, 8));
            if (memberList.size() <= 1) this.groupSize = 1;
        }
    }

    public boolean hasFollowers() {
        return this.groupSize > 1;
    }

    public boolean isInRangeOfLeader() {
        return this.distanceToSqr(this.groupLeader) <= 121;
    }

    public void pathfindToLeader() {
        if (this.isFollower()) this.getNavigation().moveTo(this.groupLeader, 1.1);
    }

    public void addFollowers(Stream<GroupAlcalyteEntity> membersStream) {
        membersStream.limit(this.getMaxGroupSize() - this.groupSize).filter(member -> member != this).forEach(member -> member.startFollowing(this));
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance instance, SpawnReason reason, @Nullable ILivingEntityData groupData, @Nullable CompoundNBT tag) {
        super.finalizeSpawn(world, instance, reason, groupData, tag);
        if (groupData == null) groupData = new AlcalyteGroupData(this);
        else this.startFollowing(((AlcalyteGroupData) groupData).leader);
        return groupData;
    }
}
