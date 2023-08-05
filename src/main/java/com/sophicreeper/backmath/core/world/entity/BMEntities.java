package com.sophicreeper.backmath.core.world.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.entity.misc.ChocoGlueProjEntity;
import com.sophicreeper.backmath.core.world.entity.misc.InsomniaArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BMEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BackMath.MOD_ID);

    /*public static final RegistryObject<EntityType<WandererSophie>> WANDERER_SOPHIE = ENTITIES.register("friend_sophie", () ->
            EntityType.Builder.of(WandererSophie::new, MobCategory.AMBIENT).sized(0.6F, 1.8F).trackingRange(32).build("friend_sophie"));

    public static final RegistryObject<EntityType<AngrySophie>> ANGRY_SOPHIE = ENTITIES.register("angry_sophie", () ->
            EntityType.Builder.of(AngrySophie::new, MobCategory.MONSTER).sized(0.6F, 1.8F).trackingRange(32).build("angry_sophie"));

    public static final RegistryObject<EntityType<InsomniaSophie>> INSOMNIA_SOPHIE = ENTITIES.register("insomnia_sophie", () ->
            EntityType.Builder.of(InsomniaSophie::new, MobCategory.MONSTER).sized(0.6F, 2.0F).trackingRange(32).build("insomnia_sophie"));

    public static final RegistryObject<EntityType<ArcherInsomniaSophie>> ARCHER_INSOMNIA_SOPHIE = ENTITIES.register("archer_insomnia_sophie", () ->
            EntityType.Builder.of(ArcherInsomniaSophie::new, MobCategory.MONSTER).sized(0.6F, 2.0F).trackingRange(32).build("archer_insomnia_sophie"));

    public static final RegistryObject<EntityType<QueenSophie>> QUEEN_SOPHIE = ENTITIES.register("queen_sophie", () ->
            EntityType.Builder.of(QueenSophie::new, MobCategory.MONSTER).sized(0.6F, 2.0F).immuneToFire().trackingRange(64).build("queen_sophie"));

    public static final RegistryObject<EntityType<WarriorSophie>> WARRIOR_SOPHIE = ENTITIES.register("warrior_sophie", () ->
            EntityType.Builder.of(WarriorSophie::new, MobCategory.MONSTER).sized(0.6F, 2.0F).trackingRange(32).build("warrior_sophie"));

    public static final RegistryObject<EntityType<ArcherLucia>> ARCHER_LUCIA = ENTITIES.register("archer_lucia", () ->
            EntityType.Builder.of(ArcherLucia::new, MobCategory.AMBIENT).sized(0.6F, 1.8F).trackingRange(32).build("archer_lucia"));

    public static final RegistryObject<EntityType<KarateLucia>> KARATE_LUCIA = ENTITIES.register("karate_lucia", () ->
            EntityType.Builder.of(KarateLucia::new, MobCategory.AMBIENT).sized(0.6F, 1.8F).trackingRange(64).build("karate_lucia"));

    public static final RegistryObject<EntityType<ShyFabricio>> SHY_FABRICIO = ENTITIES.register("shy_fabricio", () ->
            EntityType.Builder.of(ShyFabricio::new, MobCategory.AMBIENT).sized(0.6F, 1.8F).trackingRange(32).build("shy_fabricio"));

    public static final RegistryObject<EntityType<QueenSophiePet>> QUEEN_SOPHIE_PET = ENTITIES.register("queen_sophie_pet", () ->
            EntityType.Builder.of(QueenSophiePet::new, MobCategory.CREATURE).trackingRange(10).immuneToFire().sized(0.3f, 0.9f).build("queen_sophie_pet"));

    // BM 1.7.0: Aljamic Wars Creatures and Enemies
    public static final RegistryObject<EntityType<InsomniaZombie>> INSOMNIA_ZOMBIE = ENTITIES.register("insomnia_zombie", () ->
            EntityType.Builder.of(InsomniaZombie::new, MobCategory.MONSTER).sized(0.6F, 1.95F).trackingRange(8).build(BackMath.resourceLoc("insomnia_zombie").toString()));

    public static final RegistryObject<EntityType<ZombieFabricio>> ZOMBIE_FABRICIO = ENTITIES.register("zombie_fabricio", () ->
            EntityType.Builder.of(ZombieFabricio::new, MobCategory.MONSTER).sized(0.6F, 1.95F).trackingRange(8).build(BackMath.resourceLoc("zombie_fabricio").toString()));

    public static final RegistryObject<EntityType<AljamicBones>> ALJAMIC_BONES = ENTITIES.register("aljamic_bones", () ->
            EntityType.Builder.of(AljamicBones::new, MobCategory.MONSTER).sized(0.6F, 1.99F).trackingRange(8).build(BackMath.resourceLoc("aljamic_bones").toString()));

    public static final RegistryObject<EntityType<SleepishSkeleton>> SLEEPISH_SKELETON = ENTITIES.register("sleepish_skeleton", () ->
            EntityType.Builder.of(SleepishSkeleton::new, MobCategory.MONSTER).sized(0.6F, 1.99F).trackingRange(8).build(BackMath.resourceLoc("sleepish_skeleton").toString()));

    public static final RegistryObject<EntityType<Amaracameler>> AMARACAMELER = ENTITIES.register("amaracameler", () ->
            EntityType.Builder.of(Amaracameler::new, MobCategory.MONSTER).sized(2.04F, 2.04F).trackingRange(10).build(BackMath.resourceLoc("amaracameler").toString()));

    public static final RegistryObject<EntityType<Malaika>> MALAIKA = ENTITIES.register("malaika", () ->
            EntityType.Builder.of(Malaika::new, MobCategory.CREATURE).sized(0.6f, 1.8f).trackingRange(10).build(BackMath.resourceLoc("malaika").toString()));

    public static final RegistryObject<EntityType<Janticle>> JANTICLE = ENTITIES.register("janticle", () ->
            EntityType.Builder.<Janticle>of(Janticle::new, MobCategory.MONSTER).sized(0.5f, 0.5f).trackingRange(16).build(BackMath.resourceLoc("janticle").toString()));

    // BM 1.8.0: Bountifully Expansive Creatures and Enemies
    public static final RegistryObject<EntityType<BMBoat>> BACKMATH_BOAT = ENTITIES.register("backmath_boat", () ->
            EntityType.Builder.<BMBoat>of(BMBoat::new, MobCategory.MISC).sized(1.375f, 0.5f).build(BackMath.resourceLoc("backmath_boat").toString()));*/

    public static final RegistryObject<EntityType<InsomniaArrow>> INSOMNIA_ARROW = ENTITIES.register("insomnia_arrow", () ->
            EntityType.Builder.<InsomniaArrow>of(InsomniaArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).build("insomnia_arrow"));

    public static final RegistryObject<EntityType<ChocoGlueProjEntity>> CHOCOGLUE_PROJ = ENTITIES.register("chocoglue_proj", () ->
            EntityType.Builder.<ChocoGlueProjEntity>of(ChocoGlueProjEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).build("chocoglue_proj"));
}
