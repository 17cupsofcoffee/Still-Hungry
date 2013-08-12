package seventeencups.stillhungry.client.gui;

import seventeencups.stillhungry.inventory.ContainerStove;
import seventeencups.stillhungry.tileentity.TileStove;
import seventeencups.stillhungry.inventory.ContainerBarrel;
import seventeencups.stillhungry.tileentity.TileBarrel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import seventeencups.stillhungry.client.gui.inventory.GuiBarrel;
import seventeencups.stillhungry.client.gui.inventory.GuiLunchbox;
import seventeencups.stillhungry.client.gui.inventory.GuiStove;
import seventeencups.stillhungry.inventory.ContainerLunchbox;

/**
* Still-Hungry
*
* GuiHandler
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (id == 0) {
            if (tileEntity instanceof TileStove) {
                return new ContainerStove(player.inventory, (TileStove) tileEntity);
            }
        } else if (id == 1) {
            if (tileEntity instanceof TileBarrel) {
                return new ContainerBarrel(player.inventory, (TileBarrel) tileEntity);
            }
        } else if (id == 2) {
                return new ContainerLunchbox(player.inventory, world, player);
        }
        return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (id == 0) {
            if (tileEntity instanceof TileStove) {
                return new GuiStove(player.inventory, (TileStove) tileEntity);
            }
        } else if (id == 1) {
            if (tileEntity instanceof TileBarrel) {
                return new GuiBarrel(player.inventory, (TileBarrel) tileEntity);
            }
        } else if (id == 2) {
                return new GuiLunchbox(player.inventory, world, player);
        }
        return null;
    }
}
