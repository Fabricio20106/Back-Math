package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.entity.BMEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
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
    protected void registerTags() {
        this.getOrCreateBuilder(BMTags.EntityTypes.ALJAMIC_WARS_IDEA).add(BMEntities.MALAIKA.get());
        this.getOrCreateBuilder(BMTags.EntityTypes.SOPHIE_IDEA).addTag(BMTags.EntityTypes.ALJAMIC_WARS_IDEA);

        this.getOrCreateBuilder(BMTags.EntityTypes.SOPHIES).add(BMEntities.WANDERER_SOPHIE.get(), BMEntities.ANGRY_SOPHIE.get(), BMEntities.WARRIOR_SOPHIE.get(), BMEntities.INSOMNIA_SOPHIE.get(), BMEntities.ARCHER_INSOMNIA_SOPHIE.get(),
                BMEntities.QUEEN_LUCY.get(), BMEntities.QUEEN_LUCY_PET.get());
        this.getOrCreateBuilder(BMTags.EntityTypes.LUCIAS).add(BMEntities.ARCHER_LUCIA.get(), BMEntities.KARATE_LUCIA.get());
        this.getOrCreateBuilder(BMTags.EntityTypes.FABRICIOS).add(BMEntities.SHY_FABRICIO.get());

        this.getOrCreateBuilder(BMTags.EntityTypes.PLAYER_LIKE).addTag(BMTags.EntityTypes.SOPHIES).addTag(BMTags.EntityTypes.LUCIAS).addTag(BMTags.EntityTypes.FABRICIOS).add(BMEntities.MALAIKA.get());

        this.getOrCreateBuilder(EntityTypeTags.SKELETONS).add(BMEntities.ALJAMIC_BONES.get()).add(BMEntities.SLEEPISH_SKELETON.get());
        this.getOrCreateBuilder(EntityTypeTags.ARROWS).add(BMEntities.INSOMNIA_ARROW.get());
    }
}
