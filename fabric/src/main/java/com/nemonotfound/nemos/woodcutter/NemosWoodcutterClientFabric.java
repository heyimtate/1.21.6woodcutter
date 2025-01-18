package com.nemonotfound.nemos.woodcutter;

import com.nemonotfound.nemos.woodcutter.block.ModBlocks;
import com.nemonotfound.nemos.woodcutter.screen.WoodcutterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.screen.ModMenuTypes.WOODCUTTER_SCREEN_HANDLER;

public class NemosWoodcutterClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MenuScreens.register(WOODCUTTER_SCREEN_HANDLER.get(), WoodcutterScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODCUTTER.get(), RenderType.cutout());
        registerBuiltInResourcePack();
    }

    private void registerBuiltInResourcePack() {
        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(container ->
                ResourceManagerHelper.registerBuiltinResourcePack(
                        ResourceLocation.fromNamespaceAndPath(MOD_ID, "dark_mode"),
                        container,
                        Component.translatable("resourcePack.nemos_woodcutter.dark_mode.name"),
                        ResourcePackActivationType.NORMAL
                ));
    }
}
