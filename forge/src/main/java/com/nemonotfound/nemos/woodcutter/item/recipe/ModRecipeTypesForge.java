package com.nemonotfound.nemos.woodcutter.item.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.recipe.ModRecipeTypes.WOODCUTTING;

public class ModRecipeTypesForge {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, MOD_ID);

    public static void register(IEventBus eventBus) {
        LOG.info("Register recipe types");
        RECIPE_TYPE.register(eventBus);

        WOODCUTTING = RECIPE_TYPE.register("woodcutting", () -> new RecipeType<>() {
            public String toString() {
                return "woodcutting";
            }
        });
    }
}
