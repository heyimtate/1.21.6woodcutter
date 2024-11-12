package com.nemonotfound.nemos.woodcutter;

import com.nemonotfound.nemos.woodcutter.block.ModBlocks;
import com.nemonotfound.nemos.woodcutter.screen.WoodcutterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;

import static com.nemonotfound.nemos.woodcutter.screen.ModMenuTypes.WOODCUTTER_SCREEN_HANDLER;

public class NemosWoodcutterClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MenuScreens.register(WOODCUTTER_SCREEN_HANDLER.get(), WoodcutterScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODCUTTER.get(), RenderType.cutout());
    }
}
