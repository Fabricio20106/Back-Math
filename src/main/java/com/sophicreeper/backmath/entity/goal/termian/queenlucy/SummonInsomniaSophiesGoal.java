package com.sophicreeper.backmath.entity.goal.termian.queenlucy;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.InsomniaSophie;
import com.sophicreeper.backmath.entity.custom.QueenLucy;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.SpawnReason;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class SummonInsomniaSophiesGoal extends CastSpellGoal {
    private final EntityPredicate predicate = new EntityPredicate().range(16).allowInvulnerable().allowSameTeam();
    private final QueenLucy queenLucy;

    public SummonInsomniaSophiesGoal(QueenLucy queenLucy) {
        super(queenLucy);
        this.queenLucy = queenLucy;
    }

    @Override
    public boolean canUse() {
        if (super.canUse()) {
            int nearbyEntityCount = this.queenLucy.level.getNearbyEntities(InsomniaSophie.class, this.predicate, this.queenLucy, this.queenLucy.getBoundingBox().inflate(16)).size();
            return this.queenLucy.getRandom().nextInt(8) + 1 > nearbyEntityCount;
        }
        return false;
    }

    @Override
    public void castSpell() {
        ServerWorld world = (ServerWorld) this.queenLucy.level;

        for (int i = 0; i < 3; ++i) {
            BlockPos pos = this.queenLucy.blockPosition().offset(-2 + this.queenLucy.getRandom().nextInt(5), 1, -2 + this.queenLucy.getRandom().nextInt(5));
            InsomniaSophie insomniaSophie = BMEntities.INSOMNIA_SOPHIE.get().create(this.queenLucy.level);
            insomniaSophie.moveTo(pos, 0, 0);
            insomniaSophie.setNoAi(this.queenLucy.isNoAi());
            insomniaSophie.setInvulnerable(this.queenLucy.isInvulnerable());
            if (this.queenLucy.isPersistenceRequired()) insomniaSophie.setPersistenceRequired();
            if (this.queenLucy.getTeam() != null) insomniaSophie.level.getScoreboard().addPlayerToTeam(insomniaSophie.getStringUUID(), (ScorePlayerTeam) this.queenLucy.getTeam()); // Fix MC-118403 for Queen Lucy (https://bugs.mojang.com/browse/MC-118403)
            insomniaSophie.finalizeSpawn(world, this.queenLucy.level.getCurrentDifficultyAt(pos), SpawnReason.MOB_SUMMONED, null, null);
            world.addFreshEntity(insomniaSophie);
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
        return QueenLucySpells.SUMMON_INSOMNIA_SOPHIES;
    }
}
