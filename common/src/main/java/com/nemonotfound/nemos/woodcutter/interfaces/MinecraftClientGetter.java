package com.nemonotfound.nemos.woodcutter.interfaces;

import net.minecraft.client.Minecraft;

public interface MinecraftClientGetter {

    default Minecraft nemosWoodcutter$getMinecraft() {
        return null;
    }
}
