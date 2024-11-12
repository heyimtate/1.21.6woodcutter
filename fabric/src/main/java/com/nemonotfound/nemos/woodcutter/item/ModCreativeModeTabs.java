package com.nemonotfound.nemos.woodcutter.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;

public class ModCreativeModeTabs {

    public static void register() {
        LOG.info("Registering creative mode tabs");

        modifyFunctionalItemGroup();
    }

    private static void modifyFunctionalItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(entries -> entries.addAfter(Items.STONECUTTER, ModItems.WOODCUTTER.get()));
    }
}
