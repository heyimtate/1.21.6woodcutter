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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class NemosWoodcutterForge {

    public NemosWoodcutterForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        NemosWoodcutterCommon.init();

        eventBus.addListener(ModCreativeModeTabs::modifyFunctionalItemGroup);

        ModBlocksForge.register(eventBus);
        ModItemsForge.register(eventBus);
        ModRecipeSerializerForge.register(eventBus);
        ModRecipeTypesForge.register(eventBus);
        ModRecipeBookCategoryForge.register(eventBus);
        ModRecipeDisplaysForge.register(eventBus);
        ModMenuTypesForge.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WOODCUTTER.get(), RenderType.cutout());
            MenuScreens.register(ModMenuTypes.WOODCUTTER_SCREEN_HANDLER.get(), WoodcutterScreen::new);
        }
    }
}