package com.nemonotfound.nemos.woodcutter.network.listener;

import com.nemonotfound.nemos.woodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import net.minecraft.network.protocol.ping.ClientPongPacketListener;

public interface ModClientGamePacketListener extends ClientPongPacketListener {

    void nemosWoodcutter$onSynchronizeModRecipes(SynchronizeModRecipesS2CPacket packet);
}
