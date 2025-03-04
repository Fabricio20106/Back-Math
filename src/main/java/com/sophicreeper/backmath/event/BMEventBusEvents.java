package com.sophicreeper.backmath.event;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.*;
import com.sophicreeper.backmath.entity.custom.alcalyte.CollectorAlcalyteEntity;
import com.sophicreeper.backmath.entity.custom.alcalyte.ShyAlcalyteEntity;
import com.sophicreeper.backmath.entity.custom.aljan.*;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import com.sophicreeper.backmath.world.spawner.TermianPatrolSpawner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.RenderItemInFrameEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMEventBusEvents {
    @SubscribeEvent
    public static void createEntityAttributes(EntityAttributeCreationEvent event) {
        // Back Fields Mobs
        event.put(BMEntities.WANDERER_SOPHIE.get(), WandererSophieEntity.createWandererSophieAttributes().build());
        event.put(BMEntities.ANGRY_SOPHIE.get(), AngrySophieEntity.createAngrySophieAttributes().build());
        event.put(BMEntities.WARRIOR_SOPHIE.get(), WarriorSophieEntity.createWarriorSophieAttributes().build());
        event.put(BMEntities.INSOMNIA_SOPHIE.get(), InsomniaSophieEntity.createInsomniaSophieAttributes().build());
        event.put(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), ArcherInsomniaSophieEntity.createArcherInsomniaSophieAttributes().build());
        event.put(BMEntities.QUEEN_LUCY.get(), QueenLucyEntity.createQueenLucyAttributes().build());
        event.put(BMEntities.QUEEN_LUCY_PET.get(), QueenLucyPetEntity.createQueenLucyPetAttributes().build());
        event.put(BMEntities.ARCHER_LUCIA.get(), ArcherLuciaEntity.createArcherLuciaAttributes().build());
        event.put(BMEntities.KARATE_LUCIA.get(), KarateLuciaEntity.createKarateLuciaAttributes().build());
        event.put(BMEntities.SHY_ALCALYTE.get(), ShyAlcalyteEntity.createShyAlcalyteAttributes().build());

        // Aljan Mobs
        event.put(BMEntities.INSOMNIA_ZOMBIE.get(), InsomniaZombieEntity.createInsomniaZombieAttributes().build());
        event.put(BMEntities.ZOMBIE_FABRICIO.get(), ZombieFabricioEntity.createZombieFabricioAttributes().build());
        event.put(BMEntities.ALJAMIC_BONES.get(), AljamicBonesEntity.createAljamicBonesAttributes().build());
        event.put(BMEntities.SLEEPISH_SKELETON.get(), SleepishSkeletonEntity.createSleepishSkeletonAttributes().build());
        event.put(BMEntities.AMARACAMELER.get(), MonsterEntity.createMonsterAttributes().build());
        event.put(BMEntities.JANTICLE.get(), JanticleEntity.createJanticleAttributes().build());
        event.put(BMEntities.MALAIKA.get(), MalaikaEntity.createMalaikaAttributes().build());
        event.put(BMEntities.COLLECTOR_ALCALYTE.get(), CollectorAlcalyteEntity.createCollectorAlcalyteAttributes().build());
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.world;
            TermianPatrolSpawner specialSpawner = new TermianPatrolSpawner();
            specialSpawner.tick(serverWorld, serverWorld.getChunkSource().spawnEnemies, serverWorld.getChunkSource().spawnFriendlies);
        }
    }

    @SubscribeEvent
    public void renderFullbrightItems(final RenderItemInFrameEvent event) {
        if (event.getItem().getItem().is(BMItemTags.FULLY_LIT_ITEMS)) {
            event.setCanceled(true);
            MatrixStack stack = event.getMatrix();
            stack.scale(0.5F, 0.5F, 0.5F);
            Minecraft.getInstance().getItemRenderer().renderStatic(event.getItem(), ItemCameraTransforms.TransformType.FIXED, LightTexture.pack(15, 15), OverlayTexture.NO_OVERLAY, stack, event.getBuffers());
        }
    }
}
