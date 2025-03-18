package com.nemonotfound.nemos.woodcutter.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemos.woodcutter.interfaces.WoodcutterRecipeGetter;
import com.nemonotfound.nemos.woodcutter.network.protocol.game.ClientboundUpdateRecipesPacket;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerList.class)
public class PlayerListMixin {

    @Inject(method = "placeNewPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;sendPlayerPermissionLevel(Lnet/minecraft/server/level/ServerPlayer;)V"))
    private void onPlayerConnect(Connection pConnection, ServerPlayer pPlayer, CommonListenerCookie pCookie, CallbackInfo ci, @Local ServerGamePacketListenerImpl serverPlayNetworkHandler, @Local RecipeManager serverRecipeManager) {
        serverPlayNetworkHandler.send(new ClientboundUpdateRecipesPacket(((WoodcutterRecipeGetter)serverRecipeManager).nemosWoodcutter$getWoodcutterRecipeForSync()));
    }
}
