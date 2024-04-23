package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.entity.BMEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BMEntityTagsProvider extends EntityTypeTagsProvider {
    public BMEntityTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, BackMath.MOD_ID, fileHelper);
    }

    @Override
    public String getName() {
        return "Back Math - Entity Tags";
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
                .add(BMEntities.ARCHER_INSOMNIA_SOPHIE.get()).add(BMEntities.WARRIOR_SOPHIE.get()).add(BMEntities.ARCHER_LUCIA.get()).add(BMEntities.JANTICLE.get()).add(BMEntities.INSOMNIA_ZOMBIE.get()).add(BMEntities.ZOMBIE_FABRICIO.get())
                .add(BMEntities.AMARACAMELER.get()).add(EntityType.ZOMBIE).add(EntityType.HUSK).add(EntityType.DROWNED).add(EntityType.ZOMBIE_VILLAGER).add(EntityType.ZOMBIFIED_PIGLIN).add(EntityType.VEX);
        this.tag(BMTags.EntityTypes.QLP_TARGETS_NOT_TAMED).add(BMEntities.ANGRY_SOPHIE.get()).add(BMEntities.SHY_FABRICIO.get());
        this.tag(BMTags.EntityTypes.QLP_CANNOT_TARGET).add(BMEntities.QUEEN_LUCY_PET.get());

        this.tag(BMTags.EntityTypes.MALAIKA_TARGETS).add(BMEntities.INSOMNIA_ZOMBIE.get()).add(BMEntities.ZOMBIE_FABRICIO.get()).add(BMEntities.ALJAMIC_BONES.get()).add(BMEntities.SLEEPISH_SKELETON.get()).add(BMEntities.AMARACAMELER.get())
                .add(BMEntities.JANTICLE.get());

        this.tag(BMTags.EntityTypes.DEVIL_SPAREY_EFFECTIVES).add(BMEntities.WANDERER_SOPHIE.get()).add(BMEntities.INSOMNIA_SOPHIE.get()).add(BMEntities.ARCHER_INSOMNIA_SOPHIE.get()).add(BMEntities.WARRIOR_SOPHIE.get())
                .add(BMEntities.QUEEN_LUCY_PET.get()).add(BMEntities.ARCHER_LUCIA.get()).add(BMEntities.KARATE_LUCIA.get()).add(BMEntities.SHY_FABRICIO.get()).add(BMEntities.MALAIKA.get());
        this.tag(BMTags.EntityTypes.SPAREY_EFFECTIVES).add(BMEntities.ANGRY_SOPHIE.get());
        this.tag(BMTags.EntityTypes.SPAREYS_PROHIBITED).add(BMEntities.QUEEN_LUCY.get());

        this.tag(BMTags.EntityTypes.SHY_FABRICIO_FRIENDLIES).add(BMEntities.SHY_FABRICIO.get()).add(EntityType.ARMOR_STAND);

        // Melony Tags
        this.tag(BMTags.EntityTypes.CAN_SPAWN_ON_LEAVES).add(EntityType.OCELOT).add(EntityType.PARROT);

        this.tag(EntityTypeTags.SKELETONS).add(BMEntities.ALJAMIC_BONES.get()).add(BMEntities.SLEEPISH_SKELETON.get());
        this.tag(EntityTypeTags.ARROWS).add(BMEntities.INSOMNIA_ARROW.get());
        this.tag(EntityTypeTags.IMPACT_PROJECTILES).add(BMEntities.CHOCOGLUE_PROJECTILE.get());
    }
}
