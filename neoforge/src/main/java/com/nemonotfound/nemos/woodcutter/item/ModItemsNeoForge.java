package com.nemonotfound.nemos.woodcutter.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.block.ModBlocksNeoForge.WOODCUTTER_HOLDER;
import static com.nemonotfound.nemos.woodcutter.item.ModItems.WOODCUTTER;

public class ModItemsNeoForge {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static void register(IEventBus eventBus) {
        LOG.info("Registering items");
        ITEMS.register(eventBus);

        WOODCUTTER = ITEMS.registerSimpleBlockItem(WOODCUTTER_HOLDER);
    }
}
