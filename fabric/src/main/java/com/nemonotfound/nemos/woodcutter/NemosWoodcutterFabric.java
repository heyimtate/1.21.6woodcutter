package com.nemonotfound.nemos.woodcutter;

import com.nemonotfound.nemos.woodcutter.block.ModBlocksFabric;
import com.nemonotfound.nemos.woodcutter.item.ModCreativeModeTabs;
import com.nemonotfound.nemos.woodcutter.item.ModItemsFabric;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeSerializerFabric;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeTypesFabric;
import com.nemonotfound.nemos.woodcutter.item.recipe.book.ModRecipeBookCategoryFabric;
import com.nemonotfound.nemos.woodcutter.item.recipe.display.ModRecipeDisplaysFabric;
import com.nemonotfound.nemos.woodcutter.screen.ModMenuTypesFabric;
import net.fabricmc.api.ModInitializer;

public class NemosWoodcutterFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        NemosWoodcutterCommon.init();

        ModBlocksFabric.register();
        ModItemsFabric.register();
        ModCreativeModeTabs.register();
        ModRecipeSerializerFabric.register();
        ModRecipeTypesFabric.register();
        ModRecipeBookCategoryFabric.register();
        ModRecipeDisplaysFabric.register();
        ModMenuTypesFabric.register();
    }
}
