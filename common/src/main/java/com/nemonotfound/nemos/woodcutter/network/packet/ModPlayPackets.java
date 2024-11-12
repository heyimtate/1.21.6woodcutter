package com.nemonotfound.nemos.woodcutter.network.packet;

import com.nemonotfound.nemos.woodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.PacketType;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;

public class ModPlayPackets {

    public static final PacketType<SynchronizeModRecipesS2CPacket> UPDATE_RECIPES = s2c("update_recipes");

    private static <T extends Packet<ClientGamePacketListener>> PacketType<T> s2c(String id) {
        return new PacketType<>(PacketFlow.CLIENTBOUND, ResourceLocation.fromNamespaceAndPath(MOD_ID, id));
    }
}
