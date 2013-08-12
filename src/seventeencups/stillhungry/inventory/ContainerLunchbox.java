package seventeencups.stillhungry.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
* Still-Hungry
*
* ContainerLunchbox
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ContainerLunchbox extends Container {
    
    public ContainerLunchbox(InventoryPlayer inventoryPlayer, World world, EntityPlayer player) {
        
        if ((InventoryLunchbox)world.perWorldStorage.loadData(InventoryLunchbox.class, player.username + ".lunchbox") == null) {
            InventoryLunchbox data = new InventoryLunchbox(player.username + ".lunchbox");
            world.perWorldStorage.setData(player.username + ".lunchbox", data);
        }
        
        InventoryLunchbox data = (InventoryLunchbox)world.perWorldStorage.loadData(InventoryLunchbox.class, player.username + ".lunchbox");

        addSlotToContainer(new Slot(data, 0, 62, 31));
        addSlotToContainer(new Slot(data, 1, 80, 31));
        addSlotToContainer(new Slot(data, 2, 98, 31));
        addSlotToContainer(new Slot(data, 3, 62, 49));
        addSlotToContainer(new Slot(data, 4, 80, 49));
        addSlotToContainer(new Slot(data, 5, 98, 49));

        bindPlayerInventory(inventoryPlayer);
    }
    
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }
	
	@Override
	/**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 < 6)
            {
                if (!this.mergeItemStack(itemstack1, 6, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 6, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
    
}
