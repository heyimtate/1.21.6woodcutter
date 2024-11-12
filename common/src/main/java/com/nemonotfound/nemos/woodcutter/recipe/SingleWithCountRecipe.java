package com.nemonotfound.nemos.woodcutter.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class SingleWithCountRecipe implements Recipe<SingleRecipeInput> {

    private final String group;
    private final Ingredient ingredient;
    private final int inputCount;
    private final ItemStack result;
    @Nullable
    private PlacementInfo ingredientPlacement;

    public SingleWithCountRecipe(String group, Ingredient ingredient, int inputCount, ItemStack result) {
        this.group = group;
        this.ingredient = ingredient;
        this.inputCount = inputCount;
        this.result = result;
    }

    @Override
    public abstract @NotNull RecipeSerializer<? extends SingleWithCountRecipe> getSerializer();

    @Override
    public abstract @NotNull RecipeType<? extends SingleWithCountRecipe> getType();

    public boolean matches(SingleRecipeInput singleStackRecipeInput, @NotNull Level world) {
        return this.ingredient.test(singleStackRecipeInput.item());
    }

    @Override
    public @NotNull String group() {
        return this.group;
    }

    public Ingredient ingredient() {
        return this.ingredient;
    }

    public int inputCount() {
        return this.inputCount;
    }

    protected ItemStack result() {
        return this.result;
    }

    @Override
    public @NotNull PlacementInfo placementInfo() {
        if (this.ingredientPlacement == null) {
            this.ingredientPlacement = PlacementInfo.create(this.ingredient);
        }

        return this.ingredientPlacement;
    }

    public @NotNull ItemStack assemble(@NotNull SingleRecipeInput singleRecipeInput, HolderLookup.@NotNull Provider wrapperLookup) {
        return this.result.copy();
    }

    @FunctionalInterface
    public interface RecipeFactory<T extends SingleWithCountRecipe> {
        T create(String group, Ingredient ingredient, int inputCount, ItemStack result);
    }

    public static class Serializer<T extends SingleWithCountRecipe> implements RecipeSerializer<T> {
        private final MapCodec<T> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, T> packetCodec;

        public Serializer(RecipeFactory<T> recipeFactory) {
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(SingleWithCountRecipe::group),
                                    Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleWithCountRecipe::ingredient),
                                    Codec.INT.fieldOf("inputCount").forGetter(SingleWithCountRecipe::inputCount),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(SingleWithCountRecipe::result)
                            )
                            .apply(instance, recipeFactory::create)
            );
            this.packetCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8,
                    SingleWithCountRecipe::group,
                    Ingredient.CONTENTS_STREAM_CODEC,
                    SingleWithCountRecipe::ingredient,
                    ByteBufCodecs.INT,
                    SingleWithCountRecipe::inputCount,
                    ItemStack.STREAM_CODEC,
                    SingleWithCountRecipe::result,
                    recipeFactory::create
            );
        }

        @Override
        public @NotNull MapCodec<T> codec() {
            return this.codec;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
            return this.packetCodec;
        }
    }
}
