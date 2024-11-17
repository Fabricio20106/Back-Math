package com.sophicreeper.backmath.event;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.entity.custom.*;
import com.sophicreeper.backmath.entity.custom.aljamic.CollectorFabricioEntity;
import com.sophicreeper.backmath.entity.custom.aljamic.ShyFabricioEntity;
import com.sophicreeper.backmath.entity.custom.aljan.*;
import com.sophicreeper.backmath.entity.model.BMOutfitModel;
import com.sophicreeper.backmath.item.custom.armor.OutfitItem;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import com.sophicreeper.backmath.world.spawner.TermianPatrolSpawner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.RenderArmEvent;
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
        event.put(BMEntities.SHY_FABRICIO.get(), ShyFabricioEntity.createShyFabricioAttributes().build());

        // Aljan Mobs
        event.put(BMEntities.INSOMNIA_ZOMBIE.get(), InsomniaZombieEntity.createInsomniaZombieAttributes().build());
        event.put(BMEntities.ZOMBIE_FABRICIO.get(), ZombieFabricioEntity.createZombieFabricioAttributes().build());
        event.put(BMEntities.ALJAMIC_BONES.get(), AljamicBonesEntity.createAljamicBonesAttributes().build());
        event.put(BMEntities.SLEEPISH_SKELETON.get(), SleepishSkeletonEntity.createSleepishSkeletonAttributes().build());
        event.put(BMEntities.AMARACAMELER.get(), MonsterEntity.createMonsterAttributes().build());
        event.put(BMEntities.JANTICLE.get(), JanticleEntity.createJanticleAttributes().build());
        event.put(BMEntities.MALAIKA.get(), MalaikaEntity.createMalaikaAttributes().build());
        event.put(BMEntities.COLLECTOR_FABRICIO.get(), CollectorFabricioEntity.createCollectorFabricioAttributes().build());
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

    @SubscribeEvent
    public void renderOutfitInArm(final RenderArmEvent event) {
        event.setCanceled(true);
        AbstractClientPlayerEntity player = event.getPlayer();
        if (player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof OutfitItem) {
            PlayerModel<AbstractClientPlayerEntity> outfitModel = new PlayerModel<>(0, player.getModelName().equals("slim"));
            ModelRenderer rightArm = outfitModel.rightArm;
            ModelRenderer leftArm = outfitModel.leftArm;

            if (event.getArm() == HandSide.LEFT) {
                rightArm = outfitModel.leftArm;
                leftArm = outfitModel.rightArm;
            }

            OutfitItem item = (OutfitItem) player.getItemBySlot(EquipmentSlotType.CHEST).getItem();
            outfitModel.attackTime = 0;
            outfitModel.crouching = false;
            outfitModel.swimAmount = 0;
            outfitModel.setupAnim(player, 0, 0, 0, 0, 0);
            rightArm.xRot = 0;
            rightArm.render(event.getPoseStack(), event.getMultiBufferSource().getBuffer(RenderType.entitySolid(parseOutfitLocation(item.getMaterial().getName(), item.getSlot(), outfitModel))), event.getPackedLight(), OverlayTexture.NO_OVERLAY);
            leftArm.xRot = 0;
            leftArm.render(event.getPoseStack(), event.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(parseOutfitLocation(item.getMaterial().getName(), item.getSlot(), outfitModel))), event.getPackedLight(), OverlayTexture.NO_OVERLAY);
        }
    }

    private static ResourceLocation parseOutfitLocation(String name, EquipmentSlotType slotType, PlayerModel<AbstractClientPlayerEntity> model) {
        ResourceLocation location = new ResourceLocation(name);
        ResourceLocation chestLocation = new ResourceLocation(location.getNamespace(), "textures/models/outfit/" + location.getPath() + "_" + slotType.getName() + "_" + (model.slim ? "slim" : "wide") + ".png");
        ResourceLocation defaultLocation = new ResourceLocation(location.getNamespace(), "textures/models/outfit/" + location.getPath() + "_" + slotType.getName() + ".png");

        return slotType == EquipmentSlotType.CHEST ? chestLocation : defaultLocation;
    }
}
