package com.nemonotfound.nemos.woodcutter.screen;

import com.nemonotfound.nemos.woodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplayContext;
import org.jetbrains.annotations.NotNull;

import static com.nemonotfound.nemos.woodcutter.Constants.MOD_ID;

public class WoodcutterScreen extends AbstractContainerScreen<WoodcutterMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/container/woodcutter.png");
    private static final ResourceLocation SCROLLER_TEXTURE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/woodcutter/scroller");
    private static final ResourceLocation SCROLLER_DISABLED_TEXTURE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/woodcutter/scroller_disabled");
    private static final ResourceLocation RECIPE_SELECTED_TEXTURE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/woodcutter/recipe_selected");
    private static final ResourceLocation RECIPE_HIGHLIGHTED_TEXTURE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/woodcutter/recipe_highlighted");
    private static final ResourceLocation RECIPE_DISABLED_TEXTURE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/woodcutter/recipe_disabled");
    private static final ResourceLocation RECIPE_TEXTURE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/woodcutter/recipe");
    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft;

    public WoodcutterScreen(WoodcutterMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        menu.setContentsChangedListener(this::onInventoryChange);
        --this.titleLabelY;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float delta, int mouseX, int mouseY) {
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, leftPos, topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        int yPosAfterScrolling = (int) (41.0f * this.scrollAmount);
        ResourceLocation scrollerTexture = this.shouldScroll() ? SCROLLER_TEXTURE : SCROLLER_DISABLED_TEXTURE;
        guiGraphics.blitSprite(RenderType::guiTextured, scrollerTexture, leftPos + 119, topPos + 15 + yPosAfterScrolling, 12, 15);
        int xPosForRecipe = this.leftPos + 52;
        int yPosForRecipe = this.topPos + 14;
        int scrollOffset = this.scrollOffset + 12;
        this.renderRecipeBackground(guiGraphics, mouseX, mouseY, xPosForRecipe, yPosForRecipe, scrollOffset);
        this.renderRecipeIcons(guiGraphics, xPosForRecipe, yPosForRecipe, scrollOffset);
    }

    @Override
    protected void renderTooltip(@NotNull GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);

        if (this.canCraft) {
            int toolPosX = this.leftPos + 52;
            int toolPosY = this.topPos + 14;
            int scrollOffset = this.scrollOffset + 12;
            WoodcuttingRecipeDisplay.Grouping availableRecipes = this.menu.getAvailableRecipes();

            for (int l = this.scrollOffset; l < scrollOffset && l < availableRecipes.size(); ++l) {
                int m = l - this.scrollOffset;
                int n = toolPosX + m % 4 * 16;
                int o = toolPosY + m / 4 * 18 + 2;
                if (x >= n && x < n + 16 && y >= o && y < o + 18) {
                    ContextMap contextMap = SlotDisplayContext.fromLevel(this.minecraft.level);
                    SlotDisplay slotDisplay = availableRecipes.entries().get(l).recipe().optionDisplay();
                    guiGraphics.renderTooltip(this.font, slotDisplay.resolveForFirstStack(contextMap), x, y);
                }
            }
        }
    }

    private void renderRecipeBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, int xPosForRecipe,
                                        int yPosForRecipe, int scrollOffset) {
        for (int i = this.scrollOffset; i < scrollOffset && i < this.menu.getAvailableRecipeCount(); ++i) {
            int yPosWithoutScrollOffset = i - this.scrollOffset;
            int k = xPosForRecipe + yPosWithoutScrollOffset % 4 * 16;
            int l = yPosWithoutScrollOffset / 4;
            int m = yPosForRecipe + l * 18 + 2;
            int actualInput = this.menu.inputSlot.getItem().getCount();
            int expectedInput = this.menu.getAvailableRecipes().entries().get(i).inputCount();

            if (actualInput < expectedInput) {
                guiGraphics.blitSprite(RenderType::guiTextured, RECIPE_DISABLED_TEXTURE, k, m - 1, 16, 18);
            } else {
                renderRecipeBackgroundForCraftableRecipe(guiGraphics, i, mouseX, mouseY, k, m);
            }
        }
    }

    private void renderRecipeBackgroundForCraftableRecipe(GuiGraphics guiGraphics, int i, int mouseX, int mouseY, int k, int m) {
        ResourceLocation ResourceLocation = i == this.menu.getSelectedRecipe() ? RECIPE_SELECTED_TEXTURE :
                (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18 ? RECIPE_HIGHLIGHTED_TEXTURE : RECIPE_TEXTURE);
        guiGraphics.blitSprite(RenderType::guiTextured, ResourceLocation, k, m - 1, 16, 18);
    }

    private void renderRecipeIcons(GuiGraphics guiGraphics, int x, int y, int scrollOffset) {
        WoodcuttingRecipeDisplay.Grouping availableRecipes = this.menu.getAvailableRecipes();
        ContextMap contextMap = SlotDisplayContext.fromLevel(this.minecraft.level);

        for (int i = this.scrollOffset; i < scrollOffset && i < availableRecipes.size(); ++i) {
            int yPosWithoutScrollOffset = i - this.scrollOffset;
            int k = x + yPosWithoutScrollOffset % 4 * 16;
            int l = yPosWithoutScrollOffset / 4;
            int m = y + l * 18 + 2;
            SlotDisplay slotDisplay = (availableRecipes.entries().get(i)).recipe().optionDisplay();
            guiGraphics.renderItem(slotDisplay.resolveForFirstStack(contextMap), k, m);
        }
    }

    //TODO: Needs refactoring
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;
        if (this.canCraft) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.scrollOffset + 12;
            for (int l = this.scrollOffset; l < k; ++l) {
                int m = l - this.scrollOffset;
                double d = mouseX - (double) (i + m % 4 * 16);
                double e = mouseY - (double) (j + m / 4 * 18);

                if (!(d >= 0.0) || !(e >= 0.0) || !(d < 16.0) || !(e < 18.0) || !(this.menu).clickMenuButton(this.minecraft.player, l)) {
                    continue;
                }

                if (this.menu.getAvailableRecipeCount() > l) {
                    int recipeInputCount = this.menu.getAvailableRecipes().entries().get(l).inputCount();
                    int inputCount = this.menu.inputSlot.getItem().getCount();

                    if (inputCount < recipeInputCount) {
                        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 4.0f));
                    } else {
                        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0f));
                    }
                }

                this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, l);
                return true;
            }
            i = this.leftPos + 119;
            j = this.topPos + 9;
            if (mouseX >= (double) i && mouseX < (double) (i + 12) && mouseY >= (double) j && mouseY < (double) (j + 54)) {
                this.mouseClicked = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.mouseClicked && this.shouldScroll()) {
            int i = this.topPos + 14;
            int j = i + 54;
            this.scrollAmount = ((float) mouseY - (float) i - 7.5f) / ((float) (j - i) - 15.0f);
            this.scrollAmount = Mth.clamp(this.scrollAmount, 0.0f, 1.0f);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) this.getMaxScroll()) + 0.5) * 4;

            return true;
        }

        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.shouldScroll()) {
            int i = this.getMaxScroll();
            float f = (float) verticalAmount / (float) i;
            this.scrollAmount = Mth.clamp(this.scrollAmount - f, 0.0f, 1.0f);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) i) + 0.5) * 4;
        }

        return true;
    }

    private boolean shouldScroll() {
        return this.canCraft && (this.menu).getAvailableRecipeCount() > 12;
    }

    protected int getMaxScroll() {
        return ((this.menu).getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    private void onInventoryChange() {
        this.canCraft = (this.menu).canCraft();
        if (!this.canCraft) {
            this.scrollAmount = 0.0f;
            this.scrollOffset = 0;
        }
    }
}

