package com.nemonotfound.nemos.woodcutter.screen;

import com.nemonotfound.nemos.woodcutter.client.gui.screen.WoodcutterMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.client.gui.screen.ModMenuTypes.WOODCUTTER_SCREEN_HANDLER;

public class ModMenuTypesNeoForge {

    public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(BuiltInRegistries.MENU, MOD_ID);

    public static void register(IEventBus eventBus) {
        LOG.info("Registering menu types");
        MENU.register(eventBus);

        WOODCUTTER_SCREEN_HANDLER = MENU.register("woodcutter", () -> new MenuType<>(WoodcutterMenu::new, FeatureFlags.VANILLA_SET));
    }
}
