package com.nemonotfound.nemos.woodcutter.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.nemonotfound.nemos.woodcutter.Constants.LOG;
import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;
import static com.nemonotfound.nemos.woodcutter.block.ModBlocks.WOODCUTTER;

public class ModBlocksFabric {

    public static void register() {
        LOG.info("Registering mod blocks");

        WOODCUTTER = register("woodcutter", WoodcutterBlock::new,
                BlockBehaviour.Properties.of()
                        .sound(SoundType.WOOD)
                        .mapColor(MapColor.WOOD)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0f));
    }

    private static Supplier<Block> register(String path, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return register(keyOf(path), factory, properties);
    }

    private static ResourceKey<Block> keyOf(String path) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, path));
    }

    public static Supplier<Block> register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId(key));
        Block registeredBlock = Registry.register(BuiltInRegistries.BLOCK, key, block);

        return () -> registeredBlock;
    }
}
