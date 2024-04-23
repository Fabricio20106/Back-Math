package com.sophicreeper.backmath.entity;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BackMath.MOD_ID);

    public static final RegistryObject<EntityType<WandererSophie>> WANDERER_SOPHIE = ENTITIES.register("friend_sophie", () ->
            EntityType.Builder.of(WandererSophie::new, EntityClassification.AMBIENT).sized(0.6F, 1.8F).clientTrackingRange(32).build("friend_sophie"));

    public static final RegistryObject<EntityType<AngrySophie>> ANGRY_SOPHIE = ENTITIES.register("angry_sophie", () ->
            EntityType.Builder.of(AngrySophie::new, EntityClassification.MONSTER).sized(0.6F, 1.8F).clientTrackingRange(32).build("angry_sophie"));

    public static final RegistryObject<EntityType<InsomniaSophie>> INSOMNIA_SOPHIE = ENTITIES.register("insomnia_sophie", () ->
            EntityType.Builder.of(InsomniaSophie::new, EntityClassification.MONSTER).sized(0.6F, 1.8F).clientTrackingRange(32).build(BackMath.resourceLoc("insomnia_sophie").toString()));

    public static final RegistryObject<EntityType<ArcherInsomniaSophie>> ARCHER_INSOMNIA_SOPHIE = ENTITIES.register("archer_insomnia_sophie", () ->
            EntityType.Builder.of(ArcherInsomniaSophie::new, EntityClassification.MONSTER).sized(0.6F, 1.8F).clientTrackingRange(32).build(BackMath.resourceLoc("archer_insomnia_sophie").toString()));

    public static final RegistryObject<EntityType<QueenLucy>> QUEEN_LUCY = ENTITIES.register("queen_sophie", () ->
            EntityType.Builder.of(QueenLucy::new, EntityClassification.MONSTER).sized(0.6F, 1.8F).fireImmune().clientTrackingRange(64).build(BackMath.resourceLoc("queen_sophie").toString()));

    public static final RegistryObject<EntityType<WarriorSophie>> WARRIOR_SOPHIE = ENTITIES.register("warrior_sophie", () ->
            EntityType.Builder.of(WarriorSophie::new, EntityClassification.MONSTER).sized(0.6F, 1.8F).clientTrackingRange(32).build(BackMath.resourceLoc("warrior_sophie").toString()));

    public static final RegistryObject<EntityType<ArcherLucia>> ARCHER_LUCIA = ENTITIES.register("archer_lucia", () ->
            EntityType.Builder.of(ArcherLucia::new, EntityClassification.AMBIENT).sized(0.6F, 1.8F).clientTrackingRange(32).build(BackMath.resourceLoc("archer_lucia").toString()));

    public static final RegistryObject<EntityType<KarateLucia>> KARATE_LUCIA = ENTITIES.register("karate_lucia", () ->
            EntityType.Builder.of(KarateLucia::new, EntityClassification.AMBIENT).sized(0.6F, 1.8F).clientTrackingRange(64).build(BackMath.resourceLoc("karate_lucia").toString()));

    public static final RegistryObject<EntityType<ShyFabricio>> SHY_FABRICIO = ENTITIES.register("shy_fabricio", () ->
            EntityType.Builder.of(ShyFabricio::new, EntityClassification.AMBIENT).sized(0.6F, 1.8F).clientTrackingRange(32).build(BackMath.resourceLoc("shy_fabricio").toString()));

    public static final RegistryObject<EntityType<QueenLucyPet>> QUEEN_LUCY_PET = ENTITIES.register("queen_sophie_pet", () ->
            EntityType.Builder.of(QueenLucyPet::new, EntityClassification.CREATURE).clientTrackingRange(10).fireImmune().sized(0.3F, 0.9F).build(BackMath.resourceLoc("queen_sophie_pet").toString()));

    // BM 1.7.0: Aljamic Wars Creatures and Enemies
    public static final RegistryObject<EntityType<InsomniaZombie>> INSOMNIA_ZOMBIE = ENTITIES.register("insomnia_zombie", () ->
            EntityType.Builder.of(InsomniaZombie::new, EntityClassification.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(BackMath.resourceLoc("insomnia_zombie").toString()));

    public static final RegistryObject<EntityType<ZombieFabricio>> ZOMBIE_FABRICIO = ENTITIES.register("zombie_fabricio", () ->
            EntityType.Builder.of(ZombieFabricio::new, EntityClassification.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(BackMath.resourceLoc("zombie_fabricio").toString()));

    public static final RegistryObject<EntityType<AljamicBones>> ALJAMIC_BONES = ENTITIES.register("aljamic_bones", () ->
            EntityType.Builder.of(AljamicBones::new, EntityClassification.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8).build(BackMath.resourceLoc("aljamic_bones").toString()));

    public static final RegistryObject<EntityType<SleepishSkeleton>> SLEEPISH_SKELETON = ENTITIES.register("sleepish_skeleton", () ->
            EntityType.Builder.of(SleepishSkeleton::new, EntityClassification.MONSTER).sized(0.6F, 1.99F).clientTrackingRange(8).build(BackMath.resourceLoc("sleepish_skeleton").toString()));

    public static final RegistryObject<EntityType<Amaracameler>> AMARACAMELER = ENTITIES.register("amaracameler", () ->
            EntityType.Builder.of(Amaracameler::new, EntityClassification.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).build(BackMath.resourceLoc("amaracameler").toString()));

    public static final RegistryObject<EntityType<Malaika>> MALAIKA = ENTITIES.register("malaika", () ->
            EntityType.Builder.of(Malaika::new, EntityClassification.CREATURE).sized(0.6F, 1.8F).clientTrackingRange(10).build(BackMath.resourceLoc("malaika").toString()));

    public static final RegistryObject<EntityType<Janticle>> JANTICLE = ENTITIES.register("janticle", () ->
            EntityType.Builder.<Janticle>of(Janticle::new, EntityClassification.MONSTER).sized(0.5F, 0.5F).clientTrackingRange(16).build(BackMath.resourceLoc("janticle").toString()));

    // BM 1.8.0: Bountifully Expansive Creatures and Enemies
    public static final RegistryObject<EntityType<BMBoat>> BACK_MATH_BOAT = ENTITIES.register("backmath_boat", () ->
            EntityType.Builder.<BMBoat>of(BMBoat::new, EntityClassification.MISC).sized(1.375F, 0.5F).build(BackMath.resourceLoc("backmath_boat").toString()));

    public static final RegistryObject<EntityType<InsomniaArrow>> INSOMNIA_ARROW = ENTITIES.register("insomnia_arrow", () ->
            EntityType.Builder.<InsomniaArrow>of(InsomniaArrow::new, EntityClassification.MISC).sized(0.5F, 0.5F).build(BackMath.resourceLoc("insomnia_arrow").toString()));

    public static final RegistryObject<EntityType<ChocoGlueProjEntity>> CHOCOGLUE_PROJECTILE = ENTITIES.register("chocoglue_proj", () ->
            EntityType.Builder.<ChocoGlueProjEntity>of(ChocoGlueProjEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).build(BackMath.resourceLoc("chocoglue_proj").toString()));
}
