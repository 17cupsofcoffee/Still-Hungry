package seventeencups.stillhungry.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import seventeencups.stillhungry.StillHungry;
import seventeencups.stillhungry.inventory.ContainerBarrel;
import seventeencups.stillhungry.tileentity.TileBarrel;

/**
* Still-Hungry
*
* GuiBarrel
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class GuiBarrel extends GuiContainer {

    private TileBarrel te;
    private int displayFruitType;
    private int displayHasSugar;

    public GuiBarrel(InventoryPlayer inventoryPlayer,
            TileBarrel tileEntity) {
        //the container is instanciated and passed to the superclass for handling
        super(new ContainerBarrel(inventoryPlayer, tileEntity));
        te = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
            int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.func_110577_a(new ResourceLocation(StillHungry.modid + ":textures/gui/barrelBack.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        if (this.te.isFilled == 1) {
            if (this.te.lastIsFilled != this.te.isFilled) {
                this.te.waterLevel = 1;
            }

            if (this.te.waterLevel < 48) {
                this.te.waterLevel++;
            }

            displayFruitType = this.te.fruitType;
            displayHasSugar = this.te.hasSugar; // to stop texture changing on depletion
        } else {
            if (this.te.lastIsFilled != this.te.isFilled) {
                this.te.depleting = true;
            }

            if (this.te.waterLevel > 0) {
                if (this.te.depleting) {
                    this.te.waterLevel--;
                }
            } else {
                this.te.depleting = false;
                displayFruitType = 0;
                displayHasSugar = 0;
            }
        }

        if (this.displayFruitType == 0) {
            this.drawTexturedModalRect(x + 64,
                    y + 18 + (48 - this.te.waterLevel),
                    176, 96, 48, this.te.waterLevel);
        } else if (this.displayFruitType == 1) {
            switch (this.te.fruitLevel) {
                case 1:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            0, 166, 48, this.te.waterLevel);
                    break;
                case 2:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            48, 166, 48, this.te.waterLevel);
                    break;
                case 3:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            96, 166, 48, this.te.waterLevel);
                    break;
                default:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            176, 0, 48, this.te.waterLevel);
                    break;
            }

        } else if (this.displayFruitType == 2) {
            switch (this.te.fruitLevel) {
                case 1:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            176, 144, 48, this.te.waterLevel);
                    break;
                case 2:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            144, 192, 48, this.te.waterLevel);
                    break;
                case 3:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            192, 192, 48, this.te.waterLevel);
                    break;
                default:
                    this.drawTexturedModalRect(x + 64,
                            y + 18 + (48 - this.te.waterLevel),
                            176, 48, 48, this.te.waterLevel);
                    break;
            }
        }

        if (this.displayHasSugar == 1 && this.te.waterLevel >= 10) {
            this.drawTexturedModalRect(x + 64,
                    y + 5 + (48 - this.te.waterLevel),
                    0, 214, 48, 18);
        }

        mc.renderEngine.func_110577_a(new ResourceLocation(StillHungry.modid + ":textures/gui/barrelFore.png"));
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        this.te.lastIsFilled = this.te.isFilled;
    }
}