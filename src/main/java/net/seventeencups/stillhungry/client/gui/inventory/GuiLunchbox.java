package net.seventeencups.stillhungry.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;
import net.seventeencups.stillhungry.inventory.ContainerLunchbox;
import net.seventeencups.stillhungry.inventory.InventoryLunchbox;
import org.lwjgl.opengl.GL11;

/**
* Still-Hungry
*
* GuiLunchbox
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class GuiLunchbox extends GuiContainer {
    private final ItemStack parentItemStack;
    private final InventoryLunchbox inventoryLunchbox;

    public GuiLunchbox(EntityPlayer entityPlayer, InventoryLunchbox inventoryLunchbox) {
        //the container is instanciated and passed to the superclass for handling
        super(new ContainerLunchbox(entityPlayer, inventoryLunchbox));

        this.parentItemStack = inventoryLunchbox.parentItemStack;
        this.inventoryLunchbox = inventoryLunchbox;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(StillHungry.modid + ":textures/gui/lunchbox.png"));
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, this.xSize, this.ySize);
    }
}