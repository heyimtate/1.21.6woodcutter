package com.nemonotfound.nemos.woodcutter.network.protocol.game;

import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketType;
import org.jetbrains.annotations.NotNull;

public record ClientboundUpdateRecipesPacket(WoodcuttingRecipeDisplay.Grouping woodcuttingRecipes) implements Packet<net.minecraft.network.protocol.game.ClientGamePacketListener> {

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundUpdateRecipesPacket> CODEC = StreamCodec.composite(
            WoodcuttingRecipeDisplay.Grouping.codec(),
            ClientboundUpdateRecipesPacket::woodcuttingRecipes,
            ClientboundUpdateRecipesPacket::new
    );

    @Override
    public @NotNull PacketType<? extends Packet<net.minecraft.network.protocol.game.ClientGamePacketListener>> type() {
        return GamePacketTypes.CLIENTBOUND_UPDATE_RECIPES;
    }

    @Override
    public void handle(@NotNull net.minecraft.network.protocol.game.ClientGamePacketListener clientPlayPacketListener) {
        ((ClientGamePacketListener) clientPlayPacketListener).nemosWoodcutter$handleUpdateRecipes(this);
    }
}
