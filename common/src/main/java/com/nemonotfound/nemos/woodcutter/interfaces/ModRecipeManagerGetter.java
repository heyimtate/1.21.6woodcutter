package com.nemonotfound.nemos.woodcutter.interfaces;

import com.nemonotfound.nemos.woodcutter.client.recipebook.ClientModRecipeManager;
import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;

public interface ModRecipeManagerGetter {

    default ClientModRecipeManager nemosWoodcutter$getModRecipeManager() {
        return new ClientModRecipeManager(WoodcuttingRecipeDisplay.Grouping.empty());
    }
}
