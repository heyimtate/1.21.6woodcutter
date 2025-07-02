package com.nemonotfound.nemos.woodcutter.item.recipe.display;

import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcutterRecipeDisplay;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.recipe.display.ModRecipeDisplays.WOODCUTTER;

public class ModRecipeDisplaysForge {

    public static final DeferredRegister<RecipeDisplay.Type<?>> RECIPE_DISPLAY = DeferredRegister.create(Registries.RECIPE_DISPLAY, MOD_ID);

    public static void register(BusGroup eventBus) {
        LOG.info("Registering recipe displays");
        RECIPE_DISPLAY.register(eventBus);

        WOODCUTTER = RECIPE_DISPLAY.register("woodcutter", () -> WoodcutterRecipeDisplay.TYPE);
    }
}
