package com.nemonotfound.nemos.woodcutter;


import com.nemonotfound.nemos.woodcutter.block.ModBlocksNeoForge;
import com.nemonotfound.nemos.woodcutter.item.ModCreativeModeTabs;
import com.nemonotfound.nemos.woodcutter.item.ModItemsNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeSerializerNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.ModRecipeTypesNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.book.ModRecipeBookCategoryNeoForge;
import com.nemonotfound.nemos.woodcutter.item.recipe.display.ModRecipeDisplaysNeoForge;
import com.nemonotfound.nemos.woodcutter.screen.ModMenuTypesNeoForge;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;

import java.util.Optional;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;

@Mod(Constants.MOD_ID)
@EventBusSubscriber(modid = MOD_ID)
public class NemosWoodcutterNeoForge {

    public NemosWoodcutterNeoForge(IEventBus eventBus) {
        NemosWoodcutterCommon.init();

        eventBus.addListener(ModCreativeModeTabs::modifyFunctionalItemGroup);

        ModBlocksNeoForge.register(eventBus);
        ModItemsNeoForge.register(eventBus);
        ModRecipeSerializerNeoForge.register(eventBus);
        ModRecipeTypesNeoForge.register(eventBus);
        ModRecipeBookCategoryNeoForge.register(eventBus);
        ModRecipeDisplaysNeoForge.register(eventBus);
        ModMenuTypesNeoForge.register(eventBus);
    }

    @SubscribeEvent
    public static void addBuiltInResourcePack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(MOD_ID).getFile().findResource("resourcepacks/dark_mode");
            var packLocationInfo = new PackLocationInfo(
                    "builtin/dark_mode",
                    Component.translatable("resourcePack.nemos_woodcutter.dark_mode.name"),
                    PackSource.BUILT_IN,
                    Optional.empty());
            var pathResourcesSupplier = new PathPackResources.PathResourcesSupplier(resourcePath);
            var packSelectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
            var pack = Pack.readMetaAndCreate(packLocationInfo,
                    pathResourcesSupplier,
                    PackType.CLIENT_RESOURCES,
                    packSelectionConfig);

            event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
        }
    }
}