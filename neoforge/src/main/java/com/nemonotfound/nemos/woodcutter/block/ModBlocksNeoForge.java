package com.nemonotfound.nemos.woodcutter.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.block.ModBlocks.WOODCUTTER;

public class ModBlocksNeoForge {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredBlock<Block> WOODCUTTER_HOLDER = BLOCKS.registerBlock("woodcutter", WoodcutterBlock::new,
            BlockBehaviour.Properties.of()
            .sound(SoundType.WOOD)
            .mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0f));

    public static void register(IEventBus eventBus) {
        LOG.info("Registering mod blocks");
        BLOCKS.register(eventBus);

        WOODCUTTER = WOODCUTTER_HOLDER;
    }
}
