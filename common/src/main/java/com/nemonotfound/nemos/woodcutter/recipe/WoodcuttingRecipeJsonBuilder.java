package com.nemonotfound.nemos.woodcutter.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;

public class WoodcuttingRecipeJsonBuilder implements RecipeBuilder {

    private final RecipeCategory category;
    private final SingleWithCountRecipe.RecipeFactory<?> recipeFactory;
    private final Ingredient input;
    private final int inputCount;
    private final Item output;
    private final int count;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    public WoodcuttingRecipeJsonBuilder(
            RecipeCategory category, SingleWithCountRecipe.RecipeFactory<?> recipeFactory, Ingredient input,
            int inputCount, ItemLike output, int count) {
        this.category = category;
        this.recipeFactory = recipeFactory;
        this.input = input;
        this.inputCount = inputCount;
        this.output = output.asItem();
        this.count = count;
    }

    public static WoodcuttingRecipeJsonBuilder createWoodcutting(RecipeCategory category, Ingredient input, ItemLike output) {
        return new WoodcuttingRecipeJsonBuilder(category, WoodcuttingRecipe::new, input, 1, output, 1);
    }

    public static WoodcuttingRecipeJsonBuilder createWoodcutting(RecipeCategory category, Ingredient input, ItemLike output, int count) {
        return new WoodcuttingRecipeJsonBuilder(category, WoodcuttingRecipe::new, input, 1, output, count);
    }

    public static WoodcuttingRecipeJsonBuilder createWoodcutting(RecipeCategory category, Ingredient input, int inputCount, ItemLike output) {
        return new WoodcuttingRecipeJsonBuilder(category, WoodcuttingRecipe::new, input, inputCount, output, 1);
    }

    public static WoodcuttingRecipeJsonBuilder createWoodcutting(RecipeCategory category, Ingredient input, int inputCount, ItemLike output, int count) {
        return new WoodcuttingRecipeJsonBuilder(category, WoodcuttingRecipe::new, input, inputCount, output, count);
    }

    @Override
    public @NotNull RecipeBuilder unlockedBy(@NotNull String name, @NotNull Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return this.output;
    }

    @Override
    public void save(@NotNull RecipeOutput recipeOutput, @NotNull String id) {
        ResourceLocation defaultRecipeResourceLocation = RecipeBuilder.getDefaultRecipeId(this.getResult());
        ResourceLocation recipeResourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, id);

        if (recipeResourceLocation.equals(defaultRecipeResourceLocation)) {
            throw new IllegalStateException("Recipe " + id + " should remove its 'save' argument as it is equal to default one");
        } else {
            this.save(recipeOutput, ResourceKey.create(Registries.RECIPE, recipeResourceLocation));
        }
    }

    @Override
    public void save(RecipeOutput exporter, @NotNull ResourceKey<Recipe<?>> resourceKey) {
        this.validate(resourceKey);
        Advancement.Builder builder = exporter.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        SingleWithCountRecipe singleWithCountRecipe = this.recipeFactory
                .create(Objects.requireNonNullElse(this.group, ""), this.input, this.inputCount, new ItemStack(this.output, this.count));
        exporter.accept(resourceKey, singleWithCountRecipe, builder.build(resourceKey.location().withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void validate(ResourceKey<Recipe<?>> resourceKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceKey.location());
        }
    }
}
