package com.nemonotfound.nemos.woodcutter.mixin;

import com.nemonotfound.nemos.woodcutter.client.recipebook.ClientModRecipeManager;
import com.nemonotfound.nemos.woodcutter.interfaces.MinecraftClientGetter;
import com.nemonotfound.nemos.woodcutter.interfaces.ModRecipeManagerGetter;
import com.nemonotfound.nemos.woodcutter.network.listener.ModClientGamePacketListener;
import com.nemonotfound.nemos.woodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketUtils;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ClientPacketListener.class)
public abstract class ClientGameNetworkHandlerMixin extends ClientCommonPacketListenerImpl implements ClientGamePacketListener, ModClientGamePacketListener, ModRecipeManagerGetter {

    @Unique
    private ClientModRecipeManager nemosWoodcutter$modRecipeManager = new ClientModRecipeManager(WoodcuttingRecipeDisplay.Grouping.empty());

    protected ClientGameNetworkHandlerMixin(Minecraft client, Connection connection, CommonListenerCookie connectionState) {
        super(client, connection, connectionState);
    }

    @Override
    public ClientModRecipeManager nemosWoodcutter$getModRecipeManager() {
        return this.nemosWoodcutter$modRecipeManager;
    }

    @Override
    public void nemosWoodcutter$onSynchronizeModRecipes(SynchronizeModRecipesS2CPacket packet) {
        Minecraft minecraft = ((MinecraftClientGetter)this).nemosWoodcutter$getMinecraft();
        PacketUtils.ensureRunningOnSameThread(packet, this, minecraft);
        this.nemosWoodcutter$modRecipeManager = new ClientModRecipeManager(packet.woodcuttingRecipes());
    }
}
