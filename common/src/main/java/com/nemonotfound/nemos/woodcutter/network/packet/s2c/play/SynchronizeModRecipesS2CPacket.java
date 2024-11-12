package com.nemonotfound.nemos.woodcutter.network.packet.s2c.play;

import com.nemonotfound.nemos.woodcutter.network.listener.ModClientGamePacketListener;
import com.nemonotfound.nemos.woodcutter.network.packet.ModPlayPackets;
import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketType;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import org.jetbrains.annotations.NotNull;

public record SynchronizeModRecipesS2CPacket(WoodcuttingRecipeDisplay.Grouping woodcuttingRecipes) implements Packet<ClientGamePacketListener> {

    public static final StreamCodec<RegistryFriendlyByteBuf, SynchronizeModRecipesS2CPacket> CODEC = StreamCodec.composite(
            WoodcuttingRecipeDisplay.Grouping.codec(),
            SynchronizeModRecipesS2CPacket::woodcuttingRecipes,
            SynchronizeModRecipesS2CPacket::new
    );

    @Override
    public @NotNull PacketType<? extends Packet<ClientGamePacketListener>> type() {
        return ModPlayPackets.UPDATE_RECIPES;
    }

    @Override
    public void handle(@NotNull ClientGamePacketListener clientPlayPacketListener) {
        ((ModClientGamePacketListener) clientPlayPacketListener).nemosWoodcutter$onSynchronizeModRecipes(this);
    }
}
