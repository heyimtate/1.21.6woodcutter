package com.nemonotfound.nemos.woodcutter.item.recipe;

import com.nemonotfound.nemos.woodcutter.recipe.SingleWithCountRecipe;
import com.nemonotfound.nemos.woodcutter.recipe.WoodcuttingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.recipe.ModRecipeSerializer.WOODCUTTING;

public class ModRecipeSerializerForge {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MOD_ID);

    public static void register(BusGroup eventBus) {
        LOG.info("Registering recipe serializer");
        RECIPE_SERIALIZER.register(eventBus);

        WOODCUTTING = RECIPE_SERIALIZER.register("woodcutting", () -> new SingleWithCountRecipe.Serializer<>(WoodcuttingRecipe::new));
    }
}
