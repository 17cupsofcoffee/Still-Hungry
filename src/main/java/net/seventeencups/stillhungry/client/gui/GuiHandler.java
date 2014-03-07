package net.seventeencups.stillhungry.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.client.gui.inventory.GuiBarrel;
import net.seventeencups.stillhungry.client.gui.inventory.GuiLunchbox;
import net.seventeencups.stillhungry.client.gui.inventory.GuiStove;
import net.seventeencups.stillhungry.inventory.ContainerBarrel;
import net.seventeencups.stillhungry.inventory.ContainerLunchbox;
import net.seventeencups.stillhungry.inventory.ContainerStove;
import net.seventeencups.stillhungry.tileentity.TileBarrel;
import net.seventeencups.stillhungry.tileentity.TileStove;

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
        TileEntity tileEntity = world.getTileEntity(x, y, z);
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
        TileEntity tileEntity = world.getTileEntity(x, y, z);
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
