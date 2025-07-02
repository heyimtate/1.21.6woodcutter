package com.nemonotfound.nemos.woodcutter.client.gui.screen;

import com.nemonotfound.nemos.woodcutter.block.ModBlocks;
import com.nemonotfound.nemos.woodcutter.interfaces.ModRecipeManagerGetter;
import com.nemonotfound.nemos.woodcutter.interfaces.WoodcutterRecipeGetter;
import com.nemonotfound.nemos.woodcutter.recipe.WoodcuttingRecipe;
import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

import static com.nemonotfound.nemos.woodcutter.client.gui.screen.ModMenuTypes.WOODCUTTER_SCREEN_HANDLER;

//TODO: Needs refactoring
public class WoodcutterMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private WoodcuttingRecipeDisplay.Grouping recipesForInput = WoodcuttingRecipeDisplay.Grouping.empty();
    private ItemStack inputStack = ItemStack.EMPTY;
    long lastTakeTime;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {};
    public final Container input = new SimpleContainer(1){

        @Override
        public void setChanged() {
            super.setChanged();
            WoodcutterMenu.this.slotsChanged(this);
            WoodcutterMenu.this.slotUpdateListener.run();
        }
    };

    final ResultContainer resultContainer = new ResultContainer();

    public WoodcutterMenu(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, ContainerLevelAccess.NULL);
    }

    public WoodcutterMenu(int syncId, Inventory playerInventory, final ContainerLevelAccess access) {
        super(WOODCUTTER_SCREEN_HANDLER.get(), syncId);
        int i;
        this.access = access;
        this.level = playerInventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {

            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
                stack.onCraftedBy(player, stack.getCount());
                WoodcutterMenu.this.resultContainer.awardUsedRecipes(player, this.getInputStacks());
                int recipeInputCount = recipesForInput.entries().get(selectedRecipeIndex.get()).inputCount();
                ItemStack itemStack = WoodcutterMenu.this.inputSlot.remove(recipeInputCount);

                if (!itemStack.isEmpty()) {
                    WoodcutterMenu.this.setupResultSlot(WoodcutterMenu.this.selectedRecipeIndex.get());
                }
                access.execute((level, pos) -> {
                    long l = level.getGameTime();
                    if (WoodcutterMenu.this.lastTakeTime != l) {
                        level.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                                SoundSource.BLOCKS, 1.0f, 1.0f);
                        WoodcutterMenu.this.lastTakeTime = l;
                    }
                });
                super.onTake(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(WoodcutterMenu.this.inputSlot.getItem());
            }
        });

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public WoodcuttingRecipeDisplay.Grouping getVisibleRecipes() {
        return this.recipesForInput;
    }

    public int getAvailableRecipeCount() {
        return this.recipesForInput.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasItem() && this.recipesForInput.hasRecipes();
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return WoodcutterMenu.stillValid(this.access, player, ModBlocks.WOODCUTTER.get());
    }

    @Override
    public boolean clickMenuButton(@NotNull Player player, int id) {
        if (this.selectedRecipeIndex.get() == id) {
            return false;
        } else {
            if (this.isValidRecipeIndex(id)) {
                getRecipeHolder(id).ifPresent(recipeDisplay -> {
                    var optionalRecipeHolder = recipeDisplay.recipe();

                    if (optionalRecipeHolder.isEmpty()) {
                        return;
                    }

                    var recipeHolder = optionalRecipeHolder.get();
                    var recipe = recipeHolder.value();
                    var inputCount = inputSlot.getItem().getCount();

                    if (inputCount >= recipe.inputCount()) {
                        this.selectedRecipeIndex.set(id);
                        this.resultContainer.setRecipeUsed(recipeHolder);
                        this.resultSlot.set(recipe.assemble(createRecipeInput(), this.level.registryAccess()));
                    }
                });
            }

            return true;
        }
    }

    private Optional<WoodcuttingRecipeDisplay> getRecipeHolder(int id) {
        if (this.recipesForInput.hasRecipes() && this.isValidRecipeIndex(id)) {
            var groupEntry = this.recipesForInput.entries().get(id);
            return Optional.of(groupEntry.recipe());

        } else {
            return Optional.empty();
        }
    }

    private boolean isValidRecipeIndex(int recipeIndex) {
        return recipeIndex >= 0 && recipeIndex < this.recipesForInput.size();
    }

    @Override
    public void slotsChanged(@NotNull Container inventory) {
        ItemStack itemStack = this.inputSlot.getItem();

        if (!itemStack.is(this.inputStack.getItem())) {
            this.inputStack = itemStack.copy();
            this.updateInput(itemStack);
        }
    }

    private void updateInput(ItemStack stack) {
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);

        if (!stack.isEmpty()) {
            if (this.level instanceof ServerLevel serverWorld) {
                this.recipesForInput = ((WoodcutterRecipeGetter) serverWorld.recipeAccess()).nemosWoodcutter$getWoodcutterRecipes().filter(stack);
            } else if (this.level instanceof ClientLevel clientWorld) {
                this.recipesForInput = ((ModRecipeManagerGetter) clientWorld).nemosWoodcutter$getModRecipeManager().getWoodcutterRecipes().filter(stack);
            }
        } else {
            this.recipesForInput = WoodcuttingRecipeDisplay.Grouping.empty();
        }
    }

    private void setupResultSlot(int selectedId) {
        Optional<RecipeHolder<WoodcuttingRecipe>> optionalRecipe;

        if (this.recipesForInput.hasRecipes() && this.isValidRecipeIndex(selectedId)) {
            var groupEntry = this.recipesForInput.entries().get(selectedId);
            optionalRecipe = groupEntry.recipe().recipe();

        } else {
            optionalRecipe = Optional.empty();
        }

        optionalRecipe.ifPresentOrElse(
                recipeEntry -> {
                    WoodcuttingRecipe woodcuttingRecipe = recipeEntry.value();
                    var inputCount = inputSlot.getItem().getCount();

                    if (inputCount < woodcuttingRecipe.inputCount()) {
                        this.resultSlot.set(ItemStack.EMPTY);
                        this.resultContainer.setRecipeUsed(null);
                    } else {
                        this.resultContainer.setRecipeUsed(recipeEntry);
                        this.resultSlot.set(woodcuttingRecipe.assemble(createRecipeInput(), this.level.registryAccess()));
                    }
                },
                () -> {
                    this.resultSlot.set(ItemStack.EMPTY);
                    this.resultContainer.setRecipeUsed(null);
                }
        );

        this.broadcastChanges();
    }

    private SingleRecipeInput createRecipeInput() {
        return new SingleRecipeInput(this.input.getItem(0));
    }

    @Override
    public @NotNull MenuType<?> getType() {
        return WOODCUTTER_SCREEN_HANDLER.get();
    }

    public void registerUpdateListener(Runnable slotUpdateListener) {
        this.slotUpdateListener = slotUpdateListener;
    }

    @Override
    public boolean canTakeItemForPickAll(@NotNull ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2.hasItem()) {
            ItemStack itemStack2 = slot2.getItem();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (slot == 1) {
                item.onCraftedBy(itemStack2, player);
                if (!this.moveItemStackTo(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickCraft(itemStack2, itemStack);
            } else if (slot == 0) {
                if (!this.moveItemStackTo(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (isWoodcuttingRecipe(itemStack2)) {
                if (!this.moveItemStackTo(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 2 && slot < 29) {
                if (!this.moveItemStackTo(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 29 && slot < 38 && !this.moveItemStackTo(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setByPlayer(ItemStack.EMPTY);
            }

            slot2.setChanged();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTake(player, itemStack2);
            if (slot == 1) {
                player.drop(itemStack2, false);
            }

            this.broadcastChanges();
        }

        return itemStack;
    }

    private boolean isWoodcuttingRecipe(ItemStack itemStack2) {
        boolean isClientSide = this.level.isClientSide();

        return (!isClientSide &&
                ((WoodcutterRecipeGetter) this.level.recipeAccess()).nemosWoodcutter$getWoodcutterRecipes().contains(itemStack2)) ||
                (isClientSide && ((ModRecipeManagerGetter) this.level).nemosWoodcutter$getModRecipeManager().getWoodcutterRecipes().contains(itemStack2));
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((world, pos) -> this.clearContainer(player, this.input));
    }
}

