package seventeencups.stillhungry.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import seventeencups.stillhungry.StillHungry;

import seventeencups.stillhungry.inventory.ContainerStove;
import seventeencups.stillhungry.tileentity.TileStove;

/**
* Still-Hungry
*
* GuiStove
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class GuiStove extends GuiContainer {

    private TileStove te;

    public GuiStove(InventoryPlayer inventoryPlayer,
            TileStove tileEntity) {
        //the container is instanciated and passed to the superclass for handling
        super(new ContainerStove(inventoryPlayer, tileEntity));
        te = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
            int par3) {
        //draw your Gui here, only thing you need to change is the path
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.func_110577_a(new ResourceLocation(StillHungry.modid + ":textures/gui/stove.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        int var7;

        if (this.te.isBurning()) {
            var7 = this.te.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(x + 57, y + 48 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = this.te.getCookProgressScaled(24);
        this.drawTexturedModalRect(x + 79, y + 34, 176, 14, var7 + 1, 16);
    }
}