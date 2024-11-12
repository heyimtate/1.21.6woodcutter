package com.nemonotfound.nemos.woodcutter.item;

import com.nemonotfound.nemos.woodcutter.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.item.ModItems.WOODCUTTER;
import static net.minecraft.world.item.Items.registerBlock;

public class ModItemsFabric {

    public static void register() {
        LOG.info("Registering items");

        WOODCUTTER = register(ModBlocks.WOODCUTTER.get());
    }

    private static Supplier<Item> register(Block block) {
        Item registeredItem = registerBlock(block);

        return () -> registeredItem;
    }
}
