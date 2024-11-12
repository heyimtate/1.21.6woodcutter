package com.nemonotfound.nemos.woodcutter;


import com.nemonotfound.nemos.woodcutter.block.ModBlocksNeoForge;
import com.nemonotfound.nemos.woodcutter.item.ModCreativeModeTabs;
import com.nemonotfound.nemos.woodcutter.item.ModItemsNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeSerializerNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeTypesNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.book.ModRecipeBookCategoryNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.display.ModRecipeDisplaysNeoForge;
import com.nemonotfound.nemos.woodcutter.screen.ModMenuTypesNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class NemosWoodcutterNeoForge {

    public NemosWoodcutterNeoForge(IEventBus eventBus) {
        NemosWoodcutterCommon.init();

        eventBus.addListener(ModCreativeModeTabs::modifyFunctionalItemGroup);

        ModBlocksNeoForge.register(eventBus);
        ModItemsNeoForge.register(eventBus);
        ModRecipeSerializerNeoForge.register(eventBus);
        ModRecipeTypesNeoForge.register(eventBus);
        ModRecipeBookCategoryNeoForge.register(eventBus);
        ModRecipeDisplaysNeoForge.register(eventBus);
        ModMenuTypesNeoForge.register(eventBus);
    }
}