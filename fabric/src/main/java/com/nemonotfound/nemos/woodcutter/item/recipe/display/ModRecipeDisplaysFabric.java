package com.nemonotfound.nemos.woodcutter.item.recipe.display;

import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcutterRecipeDisplay;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.display.RecipeDisplay;

import java.util.function.Supplier;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.recipe.display.ModRecipeDisplays.WOODCUTTER;

public class ModRecipeDisplaysFabric {

    public static void register() {
        LOG.info("Registering recipe displays");

        WOODCUTTER = register("woodcutter", WoodcutterRecipeDisplay.TYPE);
    }

    private  static <T extends RecipeDisplay> Supplier<RecipeDisplay.Type<?>> register(String path, RecipeDisplay.Type<T> recipeDisplayType) {
        RecipeDisplay.Type<?> registeredRecipeDisplayType = Registry.register(BuiltInRegistries.RECIPE_DISPLAY,
                ResourceLocation.fromNamespaceAndPath(MOD_ID, path), recipeDisplayType);

        return () -> registeredRecipeDisplayType;
    }
}
