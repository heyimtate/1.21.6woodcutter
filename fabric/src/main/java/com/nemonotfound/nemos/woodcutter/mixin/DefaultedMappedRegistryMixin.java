package com.nemonotfound.nemos.woodcutter.mixin;

import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;

@Mixin(DefaultedMappedRegistry.class)
public class DefaultedMappedRegistryMixin {

    @ModifyVariable(at = @At("HEAD"), method = "getValue", argsOnly = true)
    ResourceLocation getValue(@Nullable ResourceLocation resourceLocation) {
        if (resourceLocation != null) {
            if (resourceLocation.getNamespace().contains("nemos-woodcutter")) {
                return ResourceLocation.fromNamespaceAndPath(MOD_ID, resourceLocation.getPath());
            }
        }
        return resourceLocation;
    }


}
