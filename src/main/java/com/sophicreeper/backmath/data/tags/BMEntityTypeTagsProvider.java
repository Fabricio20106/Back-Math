package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BMEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public BMEntityTypeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, BackMath.MOD_ID, fileHelper);
    }

    @Override
    @Nonnull
    public String getName() {
        return "Back Math - Entity Type Tags";
    }

    @Override
    protected void addTags() {
        this.tag(BMEntityTypeTags.ALJAMIC_WARS_IDEA).add(BMEntities.MALAIKA.get());
        this.tag(BMEntityTypeTags.SOPHIE_IDEA).addTag(BMEntityTypeTags.ALJAMIC_WARS_IDEA);

        this.tag(BMEntityTypeTags.SOPHIES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.ANGRY_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(),
                BMEntities.QUEEN_LUCY.get(), BMEntities.QUEEN_LUCY_PET.get());
        this.tag(BMEntityTypeTags.LUCIAS).add(BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get());
        this.tag(BMEntityTypeTags.ALCALYTES).add(BMEntities.SHY_ALCALYTE.get(), BMEntities.COLLECTOR_ALCALYTE.get());

        this.tag(BMEntityTypeTags.PLAYER_LIKE).addTag(BMEntityTypeTags.SOPHIES).addTag(BMEntityTypeTags.LUCIAS).addTag(BMEntityTypeTags.ALCALYTES).add(BMEntities.MALAIKA.get());

        this.tag(BMEntityTypeTags.QLP_TARGETS_TAMED).addTag(BMEntityTypeTags.QLP_TARGETS_NOT_TAMED).addTag(EntityTypeTags.RAIDERS).addTag(EntityTypeTags.SKELETONS).add(BMEntities.INSOMNIA_SOPHIE.get())
                .add(BMEntities.ARCHER_INSOMNIA_SOPHIE.get()).add(BMEntities.WARRIOR_SOPHIE.get(), BMEntities.ARCHER_LUCIA.get(), BMEntities.JANTICLE.get(), BMEntities.INSOMNIA_ZOMBIE.get(), BMEntities.ZOMBIE_FABRICIO.get())
                .add(BMEntities.AMARACAMELER.get(), EntityType.ZOMBIE, EntityType.HUSK, EntityType.DROWNED, EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIFIED_PIGLIN, EntityType.VEX, EntityType.ZOGLIN);
        this.tag(BMEntityTypeTags.QLP_TARGETS_NOT_TAMED).add(BMEntities.ANGRY_SOPHIE.get(), BMEntities.SHY_ALCALYTE.get(), BMEntities.COLLECTOR_ALCALYTE.get());
        this.tag(BMEntityTypeTags.QLP_CANNOT_TARGET);

        this.tag(BMEntityTypeTags.MALAIKA_TARGETS).addTag(EntityTypeTags.RAIDERS).addTag(BMEntityTypeTags.PLAYER_LIKE).add(EntityType.PLAYER, EntityType.VILLAGER, EntityType.WANDERING_TRADER);
        this.tag(BMEntityTypeTags.ALCALYTE_TARGETS).add(BMEntities.INSOMNIA_ZOMBIE.get(), BMEntities.ZOMBIE_FABRICIO.get(), BMEntities.ALJAMIC_BONES.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.AMARACAMELER.get(),
                BMEntities.JANTICLE.get(), BMEntities.MALAIKA.get(), BMEntities.ANGRY_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_LUCIA.get(),
                BMEntities.QUEEN_LUCY.get());
        this.tag(BMEntityTypeTags.AMARACAMELER_TARGETS).add(EntityType.IRON_GOLEM, BMEntities.COLLECTOR_ALCALYTE.get(), BMEntities.SHY_ALCALYTE.get());

        this.tag(BMEntityTypeTags.DEVIL_SPAREY_EFFECTIVES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get())
                .add(BMEntities.QUEEN_LUCY_PET.get(), BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get(), BMEntities.SHY_ALCALYTE.get(), BMEntities.COLLECTOR_ALCALYTE.get(), BMEntities.MALAIKA.get());
        this.tag(BMEntityTypeTags.SPAREY_EFFECTIVES).add(BMEntities.ANGRY_SOPHIE.get());
        this.tag(BMEntityTypeTags.SPAREYS_PROHIBITED).add(BMEntities.QUEEN_LUCY.get());

        this.tag(BMEntityTypeTags.SHY_ALCALYTE_FRIENDLIES).add(BMEntities.SHY_ALCALYTE.get(), BMEntities.COLLECTOR_ALCALYTE.get(), EntityType.ARMOR_STAND);

        this.tag(BMEntityTypeTags.TERMIAN_RAIDERS_ATTACK).add(EntityType.IRON_GOLEM, EntityType.PLAYER);
        this.tag(BMEntityTypeTags.CANNOT_JOIN_SOPHIE_RAID);

        this.tag(BMEntityTypeTags.SOPHIE_ALLIES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), BMEntities.QUEEN_LUCY.get(),
                BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get(), BMEntities.MALAIKA.get());
        this.tag(BMEntityTypeTags.ELIGIBLE_TO_CAPES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), BMEntities.QUEEN_LUCY.get(),
                BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get());

        this.tag(BMEntityTypeTags.ANGER_DUNGEON_MOBS).add(BMEntities.ANGRY_SOPHIE.get(), BMEntities.ANGRY_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get());
        this.tag(BMEntityTypeTags.ALJAN_DUNGEON_MOBS).add(BMEntities.ALJAMIC_BONES.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.INSOMNIA_ZOMBIE.get());

        this.tag(BMEntityTypeTags.IMMUNE_TO_SUMMONER_STAFF_SMASHES);

        // Melony Tags
        this.tag(BMEntityTypeTags.CAN_SPAWN_ON_LEAVES).add(EntityType.OCELOT, EntityType.PARROT);

        // Minecraft Tags
        this.tag(EntityTypeTags.SKELETONS).add(BMEntities.ALJAMIC_BONES.get(), BMEntities.SLEEPISH_SKELETON.get());
        this.tag(EntityTypeTags.ARROWS).add(BMEntities.INSOMNIA_ARROW.get());
        this.tag(EntityTypeTags.IMPACT_PROJECTILES).add(BMEntities.CHOCOGLUE_PROJECTILE.get());
    }
}
