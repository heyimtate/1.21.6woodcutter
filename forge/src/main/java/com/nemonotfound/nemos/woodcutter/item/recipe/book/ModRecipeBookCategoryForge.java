package com.nemonotfound.nemos.woodcutter.item.recipe.book;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.recipe.book.ModRecipeBookCategory.WOODCUTTER;

public class ModRecipeBookCategoryForge {

    public static final DeferredRegister<RecipeBookCategory> RECIPE_BOOK_CATEGORY = DeferredRegister.create(Registries.RECIPE_BOOK_CATEGORY, MOD_ID);

    public static void register(BusGroup eventBus) {
        LOG.info("Registering recipe book categories");
        RECIPE_BOOK_CATEGORY.register(eventBus);

        WOODCUTTER = RECIPE_BOOK_CATEGORY.register("woodcutter", RecipeBookCategory::new);
    }
}
