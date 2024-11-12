package com.nemonotfound.nemos.woodcutter.datagen;

import com.nemonotfound.nemos.woodcutter.block.ModBlocks;
import com.nemonotfound.nemos.woodcutter.recipe.WoodcuttingRecipeJsonBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public abstract class WoodcutterRecipeProvider extends RecipeProvider {

    protected WoodcutterRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, Item result) {
        String tagPath = inputTag.location().getPath();
        Ingredient ingredient = tag(inputTag);

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, result)
                .unlockedBy(criteria, this.has(inputTag))
                .save(output, convertBetween(result, tagPath) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, int inputCount, Item result) {
        String tagPath = inputTag.location().getPath();
        Ingredient ingredient = tag(inputTag);

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, inputCount, result)
                .unlockedBy(criteria, this.has(inputTag))
                .save(output, convertBetween(result, tagPath) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, Item result, int outputCount) {
        String tagPath = inputTag.location().getPath();
        Ingredient ingredient = tag(inputTag);

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, result, outputCount)
                .unlockedBy(criteria, this.has(inputTag))
                .save(output, convertBetween(result, tagPath) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, ItemLike input, Item result) {
        Ingredient ingredient = Ingredient.of(input);
        String blockName = BuiltInRegistries.ITEM.getKey(input.asItem()).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, result)
                .unlockedBy(getHasName(input), this.has(input))
                .save(output, convertBetween(result, blockName) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, ItemLike input, int inputCount, Item result) {
        Ingredient ingredient = Ingredient.of(input);
        String blockName = BuiltInRegistries.ITEM.getKey(input.asItem()).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, inputCount, result)
                .unlockedBy(getHasName(input), this.has(input))
                .save(output, convertBetween(result, blockName) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, ItemLike input, Item result, int outputCount) {
        Ingredient ingredient = Ingredient.of(input);
        String blockName = BuiltInRegistries.ITEM.getKey(input.asItem()).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, result, outputCount)
                .unlockedBy(getHasName(input), this.has(input))
                .save(output, convertBetween(result, blockName) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, ItemLike input, int inputCount, Item result, int outputCount) {
        Ingredient ingredient = Ingredient.of(input);
        String blockName = BuiltInRegistries.ITEM.getKey(input.asItem()).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, inputCount, result, outputCount)
                .unlockedBy(getHasName(input), this.has(input))
                .save(output, convertBetween(result, blockName) + "_woodcutting");
    }

    protected static String convertBetween(ItemLike to, String from) {
        return getItemName(to) + "_from_" + from;
    }

    protected void createWoodCutterRecipe() {
        this.shaped(RecipeCategory.DECORATIONS, ModBlocks.WOODCUTTER.get())
                .define('I', Items.IRON_INGOT)
                .define('#', ItemTags.LOGS)
                .pattern(" I ")
                .pattern("###")
                .unlockedBy("has_logs", this.has(ItemTags.LOGS))
                .save(output);
    }
}
