package com.nemonotfound.nemos.woodcutter.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends WoodcutterRecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
            super(output, provider);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput output) {
            return new ModRecipeProvider(provider, output);
        }

        @Override
        public @NotNull String getName() {
            return "Nemo's Woodcutter Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        createWoodCutterRecipe();

        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.PLANKS, "has_planks", Items.COMPOSTER);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.LOGS, "has_planks", Items.COMPOSTER, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.PLANKS, "has_planks", Items.CRAFTING_TABLE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.LOGS, "has_planks", Items.CRAFTING_TABLE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.PLANKS, "has_planks", 4, Items.BARREL);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.LOGS, "has_planks", Items.BARREL);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.PLANKS, "has_planks",4, Items.CHEST);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.LOGS, "has_planks", Items.CHEST);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.PLANKS, "has_planks", 4, Items.CHISELED_BOOKSHELF);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.LOGS, "has_planks", Items.CHISELED_BOOKSHELF);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_WOOD, Items.STRIPPED_ACACIA_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_BLOCK, Items.STRIPPED_BAMBOO_BLOCK);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_WOOD, Items.STRIPPED_BIRCH_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_LOG, Items.STRIPPED_CHERRY_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_WOOD, Items.STRIPPED_CHERRY_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.PALE_OAK_LOG, Items.STRIPPED_PALE_OAK_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.PALE_OAK_WOOD, Items.STRIPPED_PALE_OAK_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CRIMSON_HYPHAE, Items.STRIPPED_CRIMSON_HYPHAE);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_WOOD, Items.STRIPPED_DARK_OAK_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_WOOD, Items.STRIPPED_JUNGLE_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_WOOD, Items.STRIPPED_MANGROVE_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_LOG, Items.STRIPPED_OAK_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_WOOD, Items.STRIPPED_OAK_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_WOOD, Items.STRIPPED_SPRUCE_WOOD);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_STEM, Items.STRIPPED_WARPED_STEM);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_HYPHAE, Items.STRIPPED_WARPED_HYPHAE);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.ACACIA_PLANKS, 2, Items.ACACIA_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.ACACIA_PLANKS, Items.ACACIA_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.ACACIA_PLANKS, 2, Items.ACACIA_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.ACACIA_PLANKS, Items.ACACIA_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.ACACIA_PLANKS, Items.ACACIA_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.ACACIA_PLANKS, Items.ACACIA_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.ACACIA_PLANKS, Items.ACACIA_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_PLANKS, Items.ACACIA_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_PLANKS, Items.ACACIA_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.ACACIA_PLANKS, Items.ACACIA_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.BAMBOO_PLANKS, 2, Items.BAMBOO_RAFT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BAMBOO_PLANKS, Items.BAMBOO_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BAMBOO_PLANKS, 2, Items.BAMBOO_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BAMBOO_PLANKS, Items.BAMBOO_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BAMBOO_PLANKS, Items.BAMBOO_FENCE);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_PLANKS, Items.BAMBOO_MOSAIC_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_PLANKS, Items.BAMBOO_MOSAIC_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_PLANKS, Items.BAMBOO_MOSAIC);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BAMBOO_PLANKS, Items.BAMBOO_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BAMBOO_PLANKS, Items.BAMBOO_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_PLANKS, Items.BAMBOO_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_PLANKS, Items.BAMBOO_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BAMBOO_PLANKS, Items.BAMBOO_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_MOSAIC, Items.BAMBOO_MOSAIC_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_MOSAIC, Items.BAMBOO_MOSAIC_STAIRS);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.BIRCH_PLANKS, 2, Items.BIRCH_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BIRCH_PLANKS, Items.BIRCH_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BIRCH_PLANKS, 2, Items.BIRCH_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BIRCH_PLANKS, Items.BIRCH_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BIRCH_PLANKS, Items.BIRCH_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BIRCH_PLANKS, Items.BIRCH_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BIRCH_PLANKS, Items.BIRCH_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_PLANKS, Items.BIRCH_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_PLANKS, Items.BIRCH_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.BIRCH_PLANKS, Items.BIRCH_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.CHERRY_PLANKS, 2, Items.CHERRY_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CHERRY_PLANKS, Items.CHERRY_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CHERRY_PLANKS, 2, Items.CHERRY_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CHERRY_PLANKS, Items.CHERRY_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CHERRY_PLANKS, Items.CHERRY_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CHERRY_PLANKS, Items.CHERRY_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CHERRY_PLANKS, Items.CHERRY_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_PLANKS, Items.CHERRY_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_PLANKS, Items.CHERRY_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CHERRY_PLANKS, Items.CHERRY_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.PALE_OAK_PLANKS, 2, Items.PALE_OAK_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.PALE_OAK_PLANKS, 2, Items.PALE_OAK_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CRIMSON_PLANKS, Items.CRIMSON_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CRIMSON_PLANKS, 2, Items.CRIMSON_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CRIMSON_PLANKS, Items.CRIMSON_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CRIMSON_PLANKS, Items.CRIMSON_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CRIMSON_PLANKS, Items.CRIMSON_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CRIMSON_PLANKS, Items.CRIMSON_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CRIMSON_PLANKS, Items.CRIMSON_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.CRIMSON_PLANKS, Items.CRIMSON_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.CRIMSON_PLANKS, Items.CRIMSON_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.DARK_OAK_PLANKS, 2, Items.DARK_OAK_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.DARK_OAK_PLANKS, 2, Items.DARK_OAK_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.JUNGLE_PLANKS, 2, Items.JUNGLE_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.JUNGLE_PLANKS, Items.JUNGLE_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.JUNGLE_PLANKS, 2, Items.JUNGLE_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.JUNGLE_PLANKS, Items.JUNGLE_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.JUNGLE_PLANKS, Items.JUNGLE_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.JUNGLE_PLANKS, Items.JUNGLE_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.JUNGLE_PLANKS, Items.JUNGLE_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_PLANKS, Items.JUNGLE_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_PLANKS, Items.JUNGLE_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.JUNGLE_PLANKS, Items.JUNGLE_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.MANGROVE_PLANKS, 2, Items.MANGROVE_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.MANGROVE_PLANKS, Items.MANGROVE_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.MANGROVE_PLANKS, 2, Items.MANGROVE_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.MANGROVE_PLANKS, Items.MANGROVE_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.MANGROVE_PLANKS, Items.MANGROVE_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.MANGROVE_PLANKS, Items.MANGROVE_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.MANGROVE_PLANKS, Items.MANGROVE_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_PLANKS, Items.MANGROVE_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_PLANKS, Items.MANGROVE_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.MANGROVE_PLANKS, Items.MANGROVE_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.OAK_PLANKS, 2, Items.OAK_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.OAK_PLANKS, Items.OAK_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.OAK_PLANKS, 2, Items.OAK_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.OAK_PLANKS, Items.OAK_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.OAK_PLANKS, Items.OAK_FENCE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.OAK_PLANKS, Items.LADDER, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.OAK_PLANKS, Items.OAK_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.OAK_PLANKS, Items.OAK_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_PLANKS, Items.OAK_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_PLANKS, Items.OAK_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.OAK_PLANKS, Items.OAK_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, Blocks.SPRUCE_PLANKS, 2, Items.SPRUCE_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.SPRUCE_PLANKS, Items.SPRUCE_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.SPRUCE_PLANKS, 2, Items.SPRUCE_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.SPRUCE_PLANKS, Items.SPRUCE_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.SPRUCE_PLANKS, Items.SPRUCE_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.SPRUCE_PLANKS, Items.SPRUCE_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.SPRUCE_PLANKS, Items.SPRUCE_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_PLANKS, Items.SPRUCE_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_PLANKS, Items.SPRUCE_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.SPRUCE_PLANKS, Items.SPRUCE_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.WARPED_PLANKS, Items.WARPED_BUTTON, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.WARPED_PLANKS, 2, Items.WARPED_DOOR, 2);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.WARPED_PLANKS, Items.WARPED_FENCE_GATE);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.WARPED_PLANKS, Items.WARPED_FENCE);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.WARPED_PLANKS, Items.WARPED_PRESSURE_PLATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.WARPED_PLANKS, Items.WARPED_SIGN, 3);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_PLANKS, Items.WARPED_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_PLANKS, Items.WARPED_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, Blocks.WARPED_PLANKS, Items.WARPED_TRAPDOOR, 2);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_RAFT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_MOSAIC_SLAB, 2);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_MOSAIC_STAIRS);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_MOSAIC);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.MANGROVE_LOGS,"mangrove_logs", Items.MANGROVE_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.OAK_LOGS, "oak_logs", Items.OAK_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.TRANSPORTATION, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_BOAT);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_TRAPDOOR, 8);

        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_PLANKS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_BUTTON, 16);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_DOOR, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_FENCE_GATE, 4);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_FENCE, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_PRESSURE_PLATE, 16);
        createWoodcuttingRecipe(RecipeCategory.DECORATIONS, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_SIGN, 12);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_SLAB, 8);
        createWoodcuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_STAIRS, 4);
        createWoodcuttingRecipe(RecipeCategory.REDSTONE, ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_TRAPDOOR, 8);
    }
}
