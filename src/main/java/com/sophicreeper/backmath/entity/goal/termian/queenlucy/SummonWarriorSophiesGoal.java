package com.sophicreeper.backmath.entity.goal.termian.queenlucy;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.QueenLucyEntity;
import com.sophicreeper.backmath.entity.custom.WarriorSophieEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.SpawnReason;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class SummonWarriorSophiesGoal extends CastSpellGoal {
    private final EntityPredicate predicate = new EntityPredicate().range(16).allowInvulnerable().allowSameTeam();
    private final QueenLucyEntity queenLucy;

    public SummonWarriorSophiesGoal(QueenLucyEntity queenLucy) {
        super(queenLucy);
        this.queenLucy = queenLucy;
    }

    @Override
    public boolean canUse() {
        if (super.canUse()) {
            int nearbyEntityCount = this.queenLucy.level.getNearbyEntities(WarriorSophieEntity.class, this.predicate, this.queenLucy, this.queenLucy.getBoundingBox().inflate(16)).size();
            return this.queenLucy.getRandom().nextInt(8) + 1 > nearbyEntityCount;
        }
        return false;
    }

    @Override
    public void castSpell() {
        ServerWorld world = (ServerWorld) this.queenLucy.level;

        for (int i = 0; i < 3; ++i) {
            BlockPos pos = this.queenLucy.blockPosition().offset(-2 + this.queenLucy.getRandom().nextInt(5), 1, -2 + this.queenLucy.getRandom().nextInt(5));
            WarriorSophieEntity warriorSophie = BMEntities.WARRIOR_SOPHIE.get().create(this.queenLucy.level);
            warriorSophie.moveTo(pos, 0, 0);
            warriorSophie.setNoAi(this.queenLucy.isNoAi());
            warriorSophie.setInvulnerable(this.queenLucy.isInvulnerable());
            if (this.queenLucy.isPersistenceRequired()) warriorSophie.setPersistenceRequired();
            if (this.queenLucy.getTeam() != null) warriorSophie.level.getScoreboard().addPlayerToTeam(warriorSophie.getStringUUID(), (ScorePlayerTeam) this.queenLucy.getTeam()); // Fix MC-118403 for Queen Lucy (https://bugs.mojang.com/browse/MC-118403)
            warriorSophie.finalizeSpawn(world, this.queenLucy.level.getCurrentDifficultyAt(pos), SpawnReason.MOB_SUMMONED, null, null);
            world.addFreshEntity(warriorSophie);
        }
    }

    @Override
    public int castingTime() {
        return 100;
    }

    @Override
    public int castingInterval() {
        return 340;
    }

    @Override
    public QueenLucySpells spellType() {
        return QueenLucySpells.SUMMON_WARRIOR_SOPHIES;
    }
}
