package com.sophicreeper.backmath.entity.goal.termian;

import com.sophicreeper.backmath.entity.custom.termian.TermianRaiderEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ItemEntity;

import java.util.EnumSet;
import java.util.List;

public class PromoteTermianLeaderGoal<T extends TermianRaiderEntity> extends Goal {
    private final T mob;

    public PromoteTermianLeaderGoal(T mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return false; // False for now, too lazy to add the entire raid system.
    }

    @Override
    public void tick() {
        if (this.mob.getNavigation().getTargetPos().closerThan(this.mob.position(), 1.414D)) {
            List<ItemEntity> itemsList = this.mob.level.getEntitiesOfClass(ItemEntity.class, this.mob.getBoundingBox().inflate(4, 4, 4), TermianRaiderEntity.ALLOWED_ITEMS);
            if (!itemsList.isEmpty()) {
                this.mob.pickUpItem(itemsList.get(0));
            }
        }
    }
}
