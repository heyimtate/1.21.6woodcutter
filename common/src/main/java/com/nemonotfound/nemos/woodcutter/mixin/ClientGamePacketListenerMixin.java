package com.nemonotfound.nemos.woodcutter.mixin;

import com.nemonotfound.nemos.woodcutter.network.listener.ModClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientGamePacketListener.class)
public interface ClientGamePacketListenerMixin extends ModClientGamePacketListener {
}
