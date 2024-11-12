package com.nemonotfound.nemos.woodcutter.interfaces;

import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;

public interface WoodcutterRecipeGetter {

    default WoodcuttingRecipeDisplay.Grouping nemosWoodcutter$getWoodcutterRecipeForSync() {
        return WoodcuttingRecipeDisplay.Grouping.empty();
    }

    default WoodcuttingRecipeDisplay.Grouping nemosWoodcutter$getWoodcutterRecipes() {
        return WoodcuttingRecipeDisplay.Grouping.empty();
    }
}
