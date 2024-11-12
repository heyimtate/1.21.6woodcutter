package com.nemonotfound.nemos.woodcutter.recipe;

import com.nemonotfound.nemos.woodcutter.item.ModItems;
import com.nemonotfound.nemos.woodcutter.recipe.book.ModRecipeBookCategory;
import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcutterRecipeDisplay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WoodcuttingRecipe extends SingleWithCountRecipe {

    public WoodcuttingRecipe(String group, Ingredient ingredient, int inputCount, ItemStack result) {
        super(group, ingredient, inputCount, result);
    }

    @Override
    public @NotNull RecipeSerializer<WoodcuttingRecipe> getSerializer() {
        return ModRecipeSerializer.WOODCUTTING.get();
    }

    @Override
    public @NotNull RecipeType<WoodcuttingRecipe> getType() {
        return ModRecipeTypes.WOODCUTTING.get();
    }

    @Override
    public @NotNull List<RecipeDisplay> display() {
        return List.of(new WoodcutterRecipeDisplay(this.ingredient().display(), this.createResultDisplay(),
                new SlotDisplay.ItemSlotDisplay(ModItems.WOODCUTTER.get())));
    }

    public SlotDisplay createResultDisplay() {
        return new SlotDisplay.ItemStackSlotDisplay(this.result());
    }

    @Override
    public @NotNull RecipeBookCategory recipeBookCategory() {
        return ModRecipeBookCategory.WOODCUTTER.get();
    }
}
