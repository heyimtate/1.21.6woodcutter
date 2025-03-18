package com.nemonotfound.nemos.woodcutter.network.protocol.game;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.PacketType;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;

public class GamePacketTypes {

    public static final PacketType<ClientboundUpdateRecipesPacket> CLIENTBOUND_UPDATE_RECIPES = createClientbound("update_recipes");

    private static <T extends Packet<ClientGamePacketListener>> PacketType<T> createClientbound(String id) {
        return new PacketType<>(PacketFlow.CLIENTBOUND, ResourceLocation.fromNamespaceAndPath(MOD_ID, id));
    }
}
