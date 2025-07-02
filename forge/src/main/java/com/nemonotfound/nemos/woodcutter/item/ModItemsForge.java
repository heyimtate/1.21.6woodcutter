package com.nemonotfound.nemos.woodcutter.item;

import com.nemonotfound.nemos.woodcutter.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.block.ModBlocksForge.WOODCUTTER_HOLDER;
import static com.nemonotfound.nemos.woodcutter.item.ModItems.WOODCUTTER;

public class ModItemsForge {

    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static void register(BusGroup eventBus) {
        LOG.info("Registering items");
        ITEM.register(eventBus);

        WOODCUTTER = ITEM.register("woodcutter", () -> new BlockItem(ModBlocks.WOODCUTTER.get(), new Item.Properties()
                .useBlockDescriptionPrefix()
                .setId(keyOf(WOODCUTTER_HOLDER.getId()))));
    }

    private static ResourceKey<Item> keyOf(ResourceLocation resourceLocation) {
        return ResourceKey.create(Registries.ITEM, resourceLocation);
    }
}
