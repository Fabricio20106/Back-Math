package com.sophicreeper.backmath.util.tag;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.entity.EntityType;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class BMEntityTypeTags {
    public static final ITag.INamedTag<EntityType<?>> SOPHIE_IDEA = backMath("sophie_idea");
    public static final ITag.INamedTag<EntityType<?>> ALJAMIC_WARS_IDEA = backMath("sophie_idea/aljamic_wars");

    public static final ITag.INamedTag<EntityType<?>> PLAYER_LIKE = backMath("player_like");
    public static final ITag.INamedTag<EntityType<?>> SOPHIES = backMath("sophies");
    public static final ITag.INamedTag<EntityType<?>> LUCIAS = backMath("lucias");
    public static final ITag.INamedTag<EntityType<?>> FABRICIOS = backMath("fabricios");

    public static final ITag.INamedTag<EntityType<?>> QLP_TARGETS_TAMED = backMath("qlp_targets/tamed");
    public static final ITag.INamedTag<EntityType<?>> QLP_TARGETS_NOT_TAMED = backMath("qlp_targets/not_tamed");
    public static final ITag.INamedTag<EntityType<?>> QLP_CANNOT_TARGET = backMath("qlp_targets/disallowed");
    public static final ITag.INamedTag<EntityType<?>> MALAIKA_TARGETS = backMath("malaika_targets");
    public static final ITag.INamedTag<EntityType<?>> DEVIL_SPAREY_EFFECTIVES = backMath("devil_sparey_effectives");
    public static final ITag.INamedTag<EntityType<?>> SPAREY_EFFECTIVES = backMath("sparey_effectives");
    public static final ITag.INamedTag<EntityType<?>> SPAREYS_PROHIBITED = backMath("sparey_prohibited");
    public static final ITag.INamedTag<EntityType<?>> SHY_FABRICIO_FRIENDLIES = backMath("shy_fabricio_friendlies");
    public static final ITag.INamedTag<EntityType<?>> SOPHIE_ALLIES = backMath("sophie_allies");
    public static final ITag.INamedTag<EntityType<?>> ANGER_DUNGEON_MOBS = backMath("anger_dungeon_mobs");
    public static final ITag.INamedTag<EntityType<?>> ALJAN_DUNGEON_MOBS = backMath("aljan_dungeon_mobs");
    public static final ITag.INamedTag<EntityType<?>> ELIGIBLE_TO_CAPES = backMath("eligible_for_capes");
    public static final ITag.INamedTag<EntityType<?>> IMMUNE_TO_SUMMONER_STAFF_SMASHES = backMath("immune_to_summoner_staff_smashes");
    public static final ITag.INamedTag<EntityType<?>> ALJAMIC_MEMBER_TARGETS = backMath("aljamic_member_targets");
    public static final ITag.INamedTag<EntityType<?>> AMARACAMELER_TARGETS = backMath("amaracameler_targets");

    // Raider-related Tags
    public static final ITag.INamedTag<EntityType<?>> TERMIAN_RAIDERS_ATTACK = backMath("termian_raiders_attack");
    public static final ITag.INamedTag<EntityType<?>> CANNOT_JOIN_SOPHIE_RAID = backMath("cannot_join_sophie_raid");

    // Melony Tags
    public static final ITag.INamedTag<EntityType<?>> CAN_SPAWN_ON_LEAVES = melony("can_spawn_on_leaves");

    private static ITag.INamedTag<EntityType<?>> backMath(String name) {
        return EntityTypeTags.bind(BackMath.backMath(name).toString());
    }

    private static ITag.INamedTag<EntityType<?>> melony(String name) {
        return EntityTypeTags.bind(new ResourceLocation("melony", name).toString());
    }
}
