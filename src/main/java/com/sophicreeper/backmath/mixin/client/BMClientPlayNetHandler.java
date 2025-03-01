package com.sophicreeper.backmath.mixin.client;

import com.sophicreeper.backmath.blockentity.custom.QueenLucyHeadBlockEntity;
import com.sophicreeper.backmath.blockentity.custom.WandererSophieHeadBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetHandler.class)
public class BMClientPlayNetHandler {
    @Shadow
    private Minecraft minecraft;

    @Inject(method = "handleBlockEntityData", at = @At("HEAD"))
    public void handleBlockEntityData(SUpdateTileEntityPacket packet, CallbackInfo callback) {
        TileEntity blockEntity = this.minecraft.level.getBlockEntity(packet.getPos());
        if ((blockEntity instanceof WandererSophieHeadBlockEntity || blockEntity instanceof QueenLucyHeadBlockEntity) && packet.getType() == 14) {
            blockEntity.load(this.minecraft.level.getBlockState(packet.getPos()), packet.getTag());
        }
    }
}
