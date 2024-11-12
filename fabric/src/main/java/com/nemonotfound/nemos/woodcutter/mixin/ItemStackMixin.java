package com.nemonotfound.nemos.woodcutter.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @ModifyVariable(at = @At("HEAD"), method = "parse", argsOnly = true)
    private static Tag parse(Tag tag) {
        if (tag instanceof CompoundTag) {
            String tagString = tag.getAsString();
            if (tagString.contains("nemos-woodcutter:woodcutter")) {
                ((CompoundTag) tag).put("id", StringTag.valueOf("nemos_woodcutter:woodcutter"));
            }
        }

        return tag;
    }
}
