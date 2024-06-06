package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.entity.BMEntities;
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
        this.tag(BMTags.EntityTypes.ALJAMIC_WARS_IDEA).add(BMEntities.MALAIKA.get());
        this.tag(BMTags.EntityTypes.SOPHIE_IDEA).addTag(BMTags.EntityTypes.ALJAMIC_WARS_IDEA);

        this.tag(BMTags.EntityTypes.SOPHIES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.ANGRY_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(),
                BMEntities.QUEEN_LUCY.get(), BMEntities.QUEEN_LUCY_PET.get());
        this.tag(BMTags.EntityTypes.LUCIAS).add(BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get());
        this.tag(BMTags.EntityTypes.FABRICIOS).add(BMEntities.SHY_FABRICIO.get());

        this.tag(BMTags.EntityTypes.PLAYER_LIKE).addTag(BMTags.EntityTypes.SOPHIES).addTag(BMTags.EntityTypes.LUCIAS).addTag(BMTags.EntityTypes.FABRICIOS).add(BMEntities.MALAIKA.get());

        this.tag(BMTags.EntityTypes.QLP_TARGETS_TAMED).addTag(BMTags.EntityTypes.QLP_TARGETS_NOT_TAMED).addTag(EntityTypeTags.RAIDERS).addTag(EntityTypeTags.SKELETONS).add(BMEntities.INSOMNIA_SOPHIE.get())
                .add(BMEntities.ARCHER_INSOMNIA_SOPHIE.get()).add(BMEntities.WARRIOR_SOPHIE.get(), BMEntities.ARCHER_LUCIA.get(), BMEntities.JANTICLE.get(), BMEntities.INSOMNIA_ZOMBIE.get(), BMEntities.ZOMBIE_FABRICIO.get())
                .add(BMEntities.AMARACAMELER.get(), EntityType.ZOMBIE, EntityType.HUSK, EntityType.DROWNED, EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIFIED_PIGLIN, EntityType.VEX);
        this.tag(BMTags.EntityTypes.QLP_TARGETS_NOT_TAMED).add(BMEntities.ANGRY_SOPHIE.get(), BMEntities.SHY_FABRICIO.get());
        this.tag(BMTags.EntityTypes.QLP_CANNOT_TARGET).add(BMEntities.QUEEN_LUCY_PET.get());

        this.tag(BMTags.EntityTypes.MALAIKA_TARGETS).add(BMEntities.INSOMNIA_ZOMBIE.get(), BMEntities.ZOMBIE_FABRICIO.get(), BMEntities.ALJAMIC_BONES.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.AMARACAMELER.get())
                .add(BMEntities.JANTICLE.get());

        this.tag(BMTags.EntityTypes.DEVIL_SPAREY_EFFECTIVES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get())
                .add(BMEntities.QUEEN_LUCY_PET.get(), BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get(), BMEntities.SHY_FABRICIO.get(), BMEntities.MALAIKA.get());
        this.tag(BMTags.EntityTypes.SPAREY_EFFECTIVES).add(BMEntities.ANGRY_SOPHIE.get());
        this.tag(BMTags.EntityTypes.SPAREYS_PROHIBITED).add(BMEntities.QUEEN_LUCY.get());

        this.tag(BMTags.EntityTypes.SHY_FABRICIO_FRIENDLIES).add(BMEntities.SHY_FABRICIO.get(), EntityType.ARMOR_STAND);

        this.tag(BMTags.EntityTypes.TERMIAN_RAIDERS_ATTACK).add(EntityType.IRON_GOLEM, EntityType.PLAYER);
        this.tag(BMTags.EntityTypes.CANNOT_JOIN_SOPHIE_RAID);

        this.tag(BMTags.EntityTypes.SOPHIE_ALLIES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), BMEntities.QUEEN_LUCY.get(),
                BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get(), BMEntities.MALAIKA.get());
        this.tag(BMTags.EntityTypes.ELIGIBLE_TO_CAPES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), BMEntities.QUEEN_LUCY.get(),
                BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get());

        this.tag(BMTags.EntityTypes.ANGER_DUNGEON_MOBS).add(BMEntities.ANGRY_SOPHIE.get(), BMEntities.ANGRY_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get());
        this.tag(BMTags.EntityTypes.ALJAN_DUNGEON_MOBS).add(BMEntities.ALJAMIC_BONES.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.SLEEPISH_SKELETON.get(), BMEntities.INSOMNIA_ZOMBIE.get());

        // Melony Tags
        this.tag(BMTags.EntityTypes.CAN_SPAWN_ON_LEAVES).add(EntityType.OCELOT, EntityType.PARROT);

        this.tag(EntityTypeTags.SKELETONS).add(BMEntities.ALJAMIC_BONES.get(), BMEntities.SLEEPISH_SKELETON.get());
        this.tag(EntityTypeTags.ARROWS).add(BMEntities.INSOMNIA_ARROW.get());
        this.tag(EntityTypeTags.IMPACT_PROJECTILES).add(BMEntities.CHOCOGLUE_PROJECTILE.get());
    }
}
