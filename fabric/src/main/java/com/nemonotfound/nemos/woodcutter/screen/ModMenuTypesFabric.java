package com.nemonotfound.nemos.woodcutter.screen;

import com.nemonotfound.nemos.woodcutter.client.gui.screen.WoodcutterMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.client.gui.screen.ModMenuTypes.WOODCUTTER_SCREEN_HANDLER;

public class ModMenuTypesFabric {

    public static void register() {
        LOG.info("Registering menu types");

        WOODCUTTER_SCREEN_HANDLER = register(MOD_ID, WoodcutterMenu::new);
    }

    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> register(String key, MenuType.MenuSupplier<T> factory) {
        MenuType<T> registeredMenuType = Registry.register(BuiltInRegistries.MENU, key, new MenuType<>(factory, FeatureFlags.VANILLA_SET));

        return () -> registeredMenuType;
    }
}
