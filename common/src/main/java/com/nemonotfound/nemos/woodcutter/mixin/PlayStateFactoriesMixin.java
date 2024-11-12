package com.nemonotfound.nemos.woodcutter.mixin;

import com.nemonotfound.nemos.woodcutter.network.packet.ModPlayPackets;
import com.nemonotfound.nemos.woodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.ProtocolInfoBuilder;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.GameProtocols;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Consumer;

@Mixin(GameProtocols.class)
public class PlayStateFactoriesMixin {

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/ProtocolInfoBuilder;clientboundProtocol(Lnet/minecraft/network/ConnectionProtocol;Ljava/util/function/Consumer;)Lnet/minecraft/network/ProtocolInfo$Unbound;"))
    private static Consumer<ProtocolInfoBuilder<ClientGamePacketListener, RegistryFriendlyByteBuf>> sc2(Consumer<ProtocolInfoBuilder<ClientGamePacketListener, RegistryFriendlyByteBuf>> registrar) {
        return registrar.andThen(builder -> builder.addPacket(ModPlayPackets.UPDATE_RECIPES, SynchronizeModRecipesS2CPacket.CODEC));
    }
}
