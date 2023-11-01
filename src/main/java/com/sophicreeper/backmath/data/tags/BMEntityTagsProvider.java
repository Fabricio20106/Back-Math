package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.entity.BMEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
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
    }
}
