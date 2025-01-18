package com.nemonotfound.nemos.woodcutter;


import com.nemonotfound.nemos.woodcutter.block.ModBlocks;
import com.nemonotfound.nemos.woodcutter.block.ModBlocksForge;
import com.nemonotfound.nemos.woodcutter.item.ModCreativeModeTabs;
import com.nemonotfound.nemos.woodcutter.item.ModItemsForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeSerializerForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeTypesForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.book.ModRecipeBookCategoryForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.display.ModRecipeDisplaysForge;
import com.nemonotfound.nemos.woodcutter.screen.ModMenuTypes;
import com.nemonotfound.nemos.woodcutter.screen.ModMenuTypesForge;
import com.nemonotfound.nemos.woodcutter.screen.WoodcutterScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Optional;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;

@Mod(MOD_ID)
public class NemosWoodcutterForge {

    public NemosWoodcutterForge(FMLJavaModLoadingContext context) {
        final IEventBus eventBus = context.getModEventBus();
        NemosWoodcutterCommon.init();

        eventBus.addListener(ModCreativeModeTabs::modifyFunctionalItemGroup);

        ModBlocksForge.register(eventBus);
        ModItemsForge.register(eventBus);
        ModRecipeSerializerForge.register(eventBus);
        ModRecipeTypesForge.register(eventBus);
        ModRecipeBookCategoryForge.register(eventBus);
        ModRecipeDisplaysForge.register(eventBus);
        ModMenuTypesForge.register(eventBus);

        context.getModEventBus().register(this);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WOODCUTTER.get(), RenderType.cutout());
            MenuScreens.register(ModMenuTypes.WOODCUTTER_SCREEN_HANDLER.get(), WoodcutterScreen::new);
        }
    }

    @SubscribeEvent
    public void addBuiltInResourcePack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(MOD_ID).getFile().findResource("resourcepacks/dark_mode");
            var packLocationInfo = new PackLocationInfo(
                    "builtin/dark_mode",
                    Component.translatable("resourcePack.nemos_woodcutter.dark_mode.name"),
                    PackSource.BUILT_IN,
                    Optional.empty());
            var pathResourcesSupplier = new PathPackResources.PathResourcesSupplier(resourcePath);
            var packSelectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
            var pack = Pack.readMetaAndCreate(packLocationInfo,
                    pathResourcesSupplier,
                    PackType.CLIENT_RESOURCES,
                    packSelectionConfig);

            event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
        }
    }
}