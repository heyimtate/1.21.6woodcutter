package com.nemonotfound.nemos.woodcutter.item.recipe.book;

import com.nemonotfound.nemos.woodcutter.recipe.book.ModRecipeBookCategory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeBookCategory;

import java.util.function.Supplier;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.recipe.book.ModRecipeBookCategory.WOODCUTTER;

public class ModRecipeBookCategoryFabric {

    public static void register() {
        LOG.info("Registering recipe book categories");

        WOODCUTTER = register("woodcutter");
    }

    private static Supplier<RecipeBookCategory> register(String path) {
        RecipeBookCategory recipeBookCategory = Registry.register(BuiltInRegistries.RECIPE_BOOK_CATEGORY, ResourceLocation.fromNamespaceAndPath(MOD_ID, path), new RecipeBookCategory());

        return () -> recipeBookCategory;
    }
}
