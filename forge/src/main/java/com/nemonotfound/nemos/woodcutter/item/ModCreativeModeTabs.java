package com.nemonotfound.nemos.woodcutter.item;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModCreativeModeTabs {

    @SubscribeEvent
    public static void modifyFunctionalItemGroup(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModItems.WOODCUTTER.get());
        }
    }
}
