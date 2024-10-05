package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.aljamic.CollectorFabricioEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PickupWantedItemsGoal extends Goal {
    private Optional<ItemEntity> itemToPickup = Optional.empty();
    private final CollectorFabricioEntity collector;
    private final int maxWalkableDistance;
    private final Predicate<ItemStack> pickupPredicate;

    public PickupWantedItemsGoal(CollectorFabricioEntity collector, int maxWalkableDistance, Predicate<ItemStack> pickupPredicate) {
        this.collector = collector;
        this.maxWalkableDistance = maxWalkableDistance;
        this.pickupPredicate = pickupPredicate;
    }

    @Override
    public boolean canUse() {
        return this.itemToPickup.isPresent() && this.itemToPickup.get().closerThan(this.collector, this.maxWalkableDistance);
    }

    @Override
    public void start() {
        this.itemToPickup = checkForNearestItem((ServerWorld) this.collector.level, this.collector);
        if (this.itemToPickup.isPresent()) {
            this.collector.getNavigation().moveTo(this.itemToPickup.get(), 1.1);
            this.collector.lookAt(this.itemToPickup.get(), 90, 90);
        }
    }

    protected Optional<ItemEntity> checkForNearestItem(ServerWorld world, MobEntity entity) {
        List<ItemEntity> itemEntities = world.getEntitiesOfClass(ItemEntity.class, entity.getBoundingBox().inflate(this.maxWalkableDistance, 4, this.maxWalkableDistance),
                item -> true);
        itemEntities.sort(Comparator.comparingDouble(entity::distanceToSqr));
        Optional<ItemEntity> optionalEntity = itemEntities.stream().filter(item -> entity.wantsToPickUp(item.getItem())).filter(item -> item.closerThan(entity, 9))
                .filter(entity::canSee).filter(item -> this.pickupPredicate.test(item.getItem())).findFirst();
        if (optionalEntity.isPresent()) this.itemToPickup = optionalEntity;
        return optionalEntity;
    }
}
