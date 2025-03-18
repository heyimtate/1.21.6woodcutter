package com.nemonotfound.nemos.woodcutter.mixin;

import com.nemonotfound.nemos.woodcutter.network.protocol.game.ClientGamePacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.network.protocol.game.ClientGamePacketListener.class)
public interface ClientGamePacketListenerMixin extends ClientGamePacketListener {
}
