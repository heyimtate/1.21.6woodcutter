package com.nemonotfound.nemos.woodcutter.screen;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.screen.ModMenuTypes.WOODCUTTER_SCREEN_HANDLER;

public class ModMenuTypesForge {

    public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MOD_ID);

    public static void register(IEventBus eventBus) {
        LOG.info("Registering menu types");
        MENU.register(eventBus);

        WOODCUTTER_SCREEN_HANDLER = MENU.register("woodcutter", () -> new MenuType<>(WoodcutterMenu::new, FeatureFlags.DEFAULT_FLAGS));
    }
}
