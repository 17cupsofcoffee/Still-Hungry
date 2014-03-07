package net.seventeencups.stillhungry.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;
import net.seventeencups.stillhungry.inventory.ContainerLunchbox;
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

    public GuiLunchbox(InventoryPlayer inventoryPlayer, World world, EntityPlayer player) {
        //the container is instanciated and passed to the superclass for handling
        super(new ContainerLunchbox(inventoryPlayer, world, player));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
            int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(StillHungry.modid + ":textures/gui/lunchbox.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}