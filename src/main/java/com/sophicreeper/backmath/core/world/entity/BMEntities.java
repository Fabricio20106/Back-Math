package com.sophicreeper.backmath.core.world.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.WandererSophie;
import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import com.sophicreeper.backmath.core.world.entity.misc.BMBoat;
import com.sophicreeper.backmath.core.world.entity.misc.InsomniaArrow;
import com.sophicreeper.backmath.core.world.entity.monster.*;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BackMath.MOD_ID);

    public static final RegistryObject<EntityType<WandererSophie>> WANDERER_SOPHIE = ENTITIES.register("friend_sophie", () ->
            EntityType.Builder.create(WandererSophie::new, EntityClassification.AMBIENT).size(0.6F, 1.8F).trackingRange(32).build("friend_sophie"));

    public static final RegistryObject<EntityType<AngrySophie>> ANGRY_SOPHIE = ENTITIES.register("angry_sophie", () ->
            EntityType.Builder.create(AngrySophie::new, EntityClassification.MONSTER).size(0.6F, 1.8F).trackingRange(32).build("angry_sophie"));

    public static final RegistryObject<EntityType<InsomniaSophie>> INSOMNIA_SOPHIE = ENTITIES.register("insomnia_sophie", () ->
            EntityType.Builder.create(InsomniaSophie::new, EntityClassification.MONSTER).size(0.6F, 2.0F).trackingRange(32).build("insomnia_sophie"));

    public static final RegistryObject<EntityType<ArcherInsomniaSophie>> ARCHER_INSOMNIA_SOPHIE = ENTITIES.register("archer_insomnia_sophie", () ->
            EntityType.Builder.create(ArcherInsomniaSophie::new, EntityClassification.MONSTER).size(0.6F, 2.0F).trackingRange(32).build("archer_insomnia_sophie"));

    public static final RegistryObject<EntityType<QueenSophie>> QUEEN_SOPHIE = ENTITIES.register("queen_sophie", () ->
            EntityType.Builder.create(QueenSophie::new, EntityClassification.MONSTER).size(0.6F, 2.0F).immuneToFire().trackingRange(64).build("queen_sophie"));

    public static final RegistryObject<EntityType<WarriorSophie>> WARRIOR_SOPHIE = ENTITIES.register("warrior_sophie", () ->
            EntityType.Builder.create(WarriorSophie::new, EntityClassification.MONSTER).size(0.6F, 2.0F).trackingRange(32).build("warrior_sophie"));

    public static final RegistryObject<EntityType<ArcherLucia>> ARCHER_LUCIA = ENTITIES.register("archer_lucia", () ->
            EntityType.Builder.create(ArcherLucia::new, EntityClassification.AMBIENT).size(0.6F, 1.8F).trackingRange(32).build("archer_lucia"));

    public static final RegistryObject<EntityType<KarateLucia>> KARATE_LUCIA = ENTITIES.register("karate_lucia", () ->
            EntityType.Builder.create(KarateLucia::new, EntityClassification.AMBIENT).size(0.6F, 1.8F).trackingRange(64).build("karate_lucia"));

    public static final RegistryObject<EntityType<ShyFabricio>> SHY_FABRICIO = ENTITIES.register("shy_fabricio", () ->
            EntityType.Builder.create(ShyFabricio::new, EntityClassification.AMBIENT).size(0.6F, 1.8F).trackingRange(32).build("shy_fabricio"));

    public static final RegistryObject<EntityType<QueenSophiePet>> QUEEN_SOPHIE_PET = ENTITIES.register("queen_sophie_pet", () ->
            EntityType.Builder.create(QueenSophiePet::new, EntityClassification.CREATURE).trackingRange(10).immuneToFire().size(0.3f, 0.9f).build("queen_sophie_pet"));

    // BM 1.7.0: Aljamic Wars Creatures and Enemies
    public static final RegistryObject<EntityType<InsomniaZombie>> INSOMNIA_ZOMBIE = ENTITIES.register("insomnia_zombie", () ->
            EntityType.Builder.create(InsomniaZombie::new, EntityClassification.MONSTER).size(0.6F, 1.95F).trackingRange(8).build(BackMath.resourceLoc("insomnia_zombie").toString()));

    public static final RegistryObject<EntityType<ZombieFabricio>> ZOMBIE_FABRICIO = ENTITIES.register("zombie_fabricio", () ->
            EntityType.Builder.create(ZombieFabricio::new, EntityClassification.MONSTER).size(0.6F, 1.95F).trackingRange(8).build(BackMath.resourceLoc("zombie_fabricio").toString()));

    public static final RegistryObject<EntityType<AljamicBones>> ALJAMIC_BONES = ENTITIES.register("aljamic_bones", () ->
            EntityType.Builder.create(AljamicBones::new, EntityClassification.MONSTER).size(0.6F, 1.99F).trackingRange(8).build(BackMath.resourceLoc("aljamic_bones").toString()));

    public static final RegistryObject<EntityType<SleepishSkeleton>> SLEEPISH_SKELETON = ENTITIES.register("sleepish_skeleton", () ->
            EntityType.Builder.create(SleepishSkeleton::new, EntityClassification.MONSTER).size(0.6F, 1.99F).trackingRange(8).build(BackMath.resourceLoc("sleepish_skeleton").toString()));

    public static final RegistryObject<EntityType<Amaracameler>> AMARACAMELER = ENTITIES.register("amaracameler", () ->
            EntityType.Builder.create(Amaracameler::new, EntityClassification.MONSTER).size(2.04F, 2.04F).trackingRange(10).build(BackMath.resourceLoc("amaracameler").toString()));

    public static final RegistryObject<EntityType<Malaika>> MALAIKA = ENTITIES.register("malaika", () ->
            EntityType.Builder.create(Malaika::new, EntityClassification.CREATURE).size(0.6f, 1.8f).trackingRange(10).build(BackMath.resourceLoc("malaika").toString()));

    public static final RegistryObject<EntityType<Janticle>> JANTICLE = ENTITIES.register("janticle", () ->
            EntityType.Builder.<Janticle>create(Janticle::new, EntityClassification.MONSTER).size(0.5f, 0.5f).trackingRange(16).build(BackMath.resourceLoc("janticle").toString()));

    // BM 1.8.0: Bountifully Expansive Creatures and Enemies
    public static final RegistryObject<EntityType<BMBoat>> BACKMATH_BOAT = ENTITIES.register("backmath_boat", () ->
            EntityType.Builder.<BMBoat>create(BMBoat::new, EntityClassification.MISC).size(1.375f, 0.5f).build(BackMath.resourceLoc("backmath_boat").toString()));

    public static final RegistryObject<EntityType<InsomniaArrow>> INSOMNIA_ARROW = ENTITIES.register("insomnia_arrow", () ->
            EntityType.Builder.<InsomniaArrow>create(InsomniaArrow::new, EntityClassification.MISC).size(0.5F, 0.5F).build("insomnia_arrow"));
}
