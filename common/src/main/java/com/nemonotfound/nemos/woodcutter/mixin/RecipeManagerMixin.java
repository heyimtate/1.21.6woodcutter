package com.nemonotfound.nemos.woodcutter.mixin;

import com.nemonotfound.nemos.woodcutter.interfaces.WoodcutterRecipeGetter;
import com.nemonotfound.nemos.woodcutter.recipe.WoodcuttingRecipe;
import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin implements WoodcutterRecipeGetter {

    @Shadow private RecipeMap recipes;
    @Unique
    private WoodcuttingRecipeDisplay.Grouping nemosWoodcutter$woodcutterRecipes;

    @Override
    public WoodcuttingRecipeDisplay.Grouping nemosWoodcutter$getWoodcutterRecipeForSync() {
        return this.nemosWoodcutter$woodcutterRecipes;
    }

    @Override
    public WoodcuttingRecipeDisplay.Grouping nemosWoodcutter$getWoodcutterRecipes() {
        return this.nemosWoodcutter$woodcutterRecipes;
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(HolderLookup.Provider registries, CallbackInfo ci) {
        nemosWoodcutter$woodcutterRecipes = WoodcuttingRecipeDisplay.Grouping.empty();
    }

    @Inject(method = "finalizeRecipeLoading", at = @At("TAIL"))
    private void finalizeRecipeLoading(FeatureFlagSet featureFlagSet, CallbackInfo ci) {
        List<WoodcuttingRecipeDisplay.GroupEntry> woodcuttingRecipeEntries = new ArrayList<>();
        this.recipes.values().forEach(
                recipeEntry -> {
                    Recipe<?> recipe = recipeEntry.value();
                    if (recipe instanceof WoodcuttingRecipe woodcuttingRecipe) {
                        woodcuttingRecipeEntries.add(new WoodcuttingRecipeDisplay.GroupEntry(woodcuttingRecipe.ingredient(),
                                woodcuttingRecipe.inputCount(), new WoodcuttingRecipeDisplay(woodcuttingRecipe.createResultDisplay(), Optional.of((RecipeHolder<WoodcuttingRecipe>) recipeEntry))));
                    }
                }
        );
        this.nemosWoodcutter$woodcutterRecipes = new WoodcuttingRecipeDisplay.Grouping(woodcuttingRecipeEntries);
    }
}
