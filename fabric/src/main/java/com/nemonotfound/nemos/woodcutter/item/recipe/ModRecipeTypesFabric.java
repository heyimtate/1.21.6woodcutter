package com.nemonotfound.nemos.woodcutter.item.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.recipe.ModRecipeTypes.WOODCUTTING;

public class ModRecipeTypesFabric {

    public static void register() {
        LOG.info("Register recipe types");

        WOODCUTTING = register("woodcutting");
    }

   private static <T extends Recipe<?>> Supplier<RecipeType<T>> register(String id) {
       RecipeType<T> registeredRecipeType = Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.fromNamespaceAndPath(MOD_ID, id), new RecipeType<T>() {
           public String toString() {
               return id;
           }
       });

       return () -> registeredRecipeType;
   }
}
