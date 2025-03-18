package com.nemonotfound.nemos.woodcutter.mixin;

import com.nemonotfound.nemos.woodcutter.client.recipebook.ClientModRecipeManager;
import com.nemonotfound.nemos.woodcutter.interfaces.ModRecipeManagerGetter;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientLevel.class)
public class ClientLevelMixin implements ModRecipeManagerGetter {

    @Shadow @Final
    private ClientPacketListener connection;

    @Override
    public ClientModRecipeManager nemosWoodcutter$getModRecipeManager() {
        return ((ModRecipeManagerGetter)connection).nemosWoodcutter$getModRecipeManager();
    }
}
