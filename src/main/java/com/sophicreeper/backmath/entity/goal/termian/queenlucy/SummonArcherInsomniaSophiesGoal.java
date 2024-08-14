package com.sophicreeper.backmath.entity.goal.termian.queenlucy;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.ArcherInsomniaSophieEntity;
import com.sophicreeper.backmath.entity.custom.QueenLucyEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.SpawnReason;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class SummonArcherInsomniaSophiesGoal extends CastSpellGoal {
    private final EntityPredicate predicate = new EntityPredicate().range(16).allowInvulnerable().allowSameTeam();
    private final QueenLucyEntity queenLucy;

    public SummonArcherInsomniaSophiesGoal(QueenLucyEntity queenLucy) {
        super(queenLucy);
        this.queenLucy = queenLucy;
    }

    @Override
    public boolean canUse() {
        if (super.canUse()) {
            int nearbyEntityCount = this.queenLucy.level.getNearbyEntities(ArcherInsomniaSophieEntity.class, this.predicate, this.queenLucy, this.queenLucy.getBoundingBox().inflate(16)).size();
            return this.queenLucy.getRandom().nextInt(8) + 1 > nearbyEntityCount;
        }
        return false;
    }

    @Override
    public void castSpell() {
        ServerWorld world = (ServerWorld) this.queenLucy.level;

        for (int i = 0; i < 3; ++i) {
            BlockPos pos = this.queenLucy.blockPosition().offset(-2 + this.queenLucy.getRandom().nextInt(5), 1, -2 + this.queenLucy.getRandom().nextInt(5));
            ArcherInsomniaSophieEntity archerInsomniaSophie = BMEntities.ARCHER_INSOMNIA_SOPHIE.get().create(this.queenLucy.level);
            archerInsomniaSophie.moveTo(pos, 0, 0);
            archerInsomniaSophie.setNoAi(this.queenLucy.isNoAi());
            archerInsomniaSophie.setInvulnerable(this.queenLucy.isInvulnerable());
            if (this.queenLucy.isPersistenceRequired()) archerInsomniaSophie.setPersistenceRequired();
            if (this.queenLucy.getTeam() != null) archerInsomniaSophie.level.getScoreboard().addPlayerToTeam(archerInsomniaSophie.getStringUUID(), (ScorePlayerTeam) this.queenLucy.getTeam()); // Fix MC-118403 for Queen Lucy (https://bugs.mojang.com/browse/MC-118403)
            archerInsomniaSophie.finalizeSpawn(world, this.queenLucy.level.getCurrentDifficultyAt(pos), SpawnReason.MOB_SUMMONED, null, null);
            world.addFreshEntity(archerInsomniaSophie);
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
        return QueenLucySpells.SUMMON_ARCHER_INSOMNIA_SOPHIES;
    }
}
