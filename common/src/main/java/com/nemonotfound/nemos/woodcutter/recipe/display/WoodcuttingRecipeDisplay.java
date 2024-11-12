package com.nemonotfound.nemos.woodcutter.recipe.display;

import com.nemonotfound.nemos.woodcutter.recipe.WoodcuttingRecipe;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.display.SlotDisplay;

import java.util.List;
import java.util.Optional;

public record WoodcuttingRecipeDisplay(SlotDisplay optionDisplay, Optional<RecipeHolder<WoodcuttingRecipe>> recipe) {

    public static StreamCodec<RegistryFriendlyByteBuf, WoodcuttingRecipeDisplay> codec() {
        return StreamCodec.composite(SlotDisplay.STREAM_CODEC,
                WoodcuttingRecipeDisplay::optionDisplay, display -> new WoodcuttingRecipeDisplay(display, Optional.empty()));
    }

    public record GroupEntry(Ingredient input, int inputCount, WoodcuttingRecipeDisplay recipe) {

        public static StreamCodec<RegistryFriendlyByteBuf, GroupEntry> codec() {
            return StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC,
                    GroupEntry::input,
                    ByteBufCodecs.INT,
                    GroupEntry::inputCount,
                    WoodcuttingRecipeDisplay.codec(),
                    GroupEntry::recipe,
                    GroupEntry::new
            );
        }
    }

    public record Grouping(List<GroupEntry> entries) {

        public static Grouping empty() {
            return new Grouping(List.of());
        }

        public static StreamCodec<RegistryFriendlyByteBuf, Grouping> codec() {
            return StreamCodec.composite(
                    GroupEntry.codec().apply(ByteBufCodecs.list()),
                    Grouping::entries, Grouping::new
            );
        }

        public boolean contains(ItemStack stack) {
            return this.entries.stream().anyMatch(entry -> entry.input.test(stack));
        }

        public Grouping filter(ItemStack stack) {
            return new Grouping(this.entries.stream().filter(entry -> entry.input.test(stack)).toList());
        }

        public boolean hasRecipes() {
            return !this.entries.isEmpty();
        }

        public int size() {
            return this.entries.size();
        }
    }
}
