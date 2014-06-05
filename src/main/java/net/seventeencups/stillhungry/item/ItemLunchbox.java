package net.seventeencups.stillhungry.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;
import net.seventeencups.stillhungry.inventory.InventoryLunchbox;
import net.seventeencups.stillhungry.reference.GuiIds;
import net.seventeencups.stillhungry.util.NBTHelper;

import java.util.List;

/**
* Still-Hungry
*
* ItemLunchbox
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemLunchbox extends ItemSH {

    public ItemLunchbox() {
        super();
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote) {
            NBTHelper.setUUID(itemStack);
            entityPlayer.openGui(StillHungry.instance, GuiIds.LUNCHBOX, entityPlayer.worldObj, (int)entityPlayer.posX, (int)entityPlayer.posY, (int)entityPlayer.posZ);
        }

        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
        InventoryLunchbox inventoryLunchbox = new InventoryLunchbox(itemStack);

        if (inventoryLunchbox.getSizeInventory() > 0) {
            for (int i = 0; i < inventoryLunchbox.getSizeInventory(); i++) {
                if (inventoryLunchbox.getStackInSlot(i) != null) {
                    list.add(inventoryLunchbox.getStackInSlot(i).stackSize + "x " +
                            inventoryLunchbox.getStackInSlot(i).getDisplayName());
                }
            }
        }
    }

}
