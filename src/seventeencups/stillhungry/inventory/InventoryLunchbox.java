package seventeencups.stillhungry.inventory;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.WorldSavedData;

/**
* Still-Hungry
*
* InventoryLunchbox
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class InventoryLunchbox extends WorldSavedData implements IInventory {
    
    private ItemStack[] inv;
    
    public InventoryLunchbox(String filePath) {
        super(filePath);
        inv = new ItemStack[6];
    }

    @Override
    public int getSizeInventory() {
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inv[slot];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        if (this.inv[par1] != null) {
            ItemStack var3;

            if (this.inv[par1].stackSize <= par2) {
                var3 = this.inv[par1];
                this.inv[par1] = null;
                return var3;
            } else {
                var3 = this.inv[par1].splitStack(par2);

                if (this.inv[par1].stackSize == 0) {
                    this.inv[par1] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {
        if (this.inv[par1] != null) {
            ItemStack var2 = this.inv[par1];
            this.inv[par1] = null;
            return var2;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return "container.lunchbox";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
        markDirty();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return true;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        if (itemstack.getItem().getCreativeTab() == CreativeTabs.tabFood) {
            return true;
        }
        else return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        NBTTagList tagList = tagCompound.getTagList("Items");
        this.inv = new ItemStack[this.getSizeInventory()];
        
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length) {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inv.length; i++) {
            if (this.inv[i] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) i);
                this.inv[i].writeToNBT(var4);
                itemList.appendTag(var4);
            }
        }
        tagCompound.setTag("Items", itemList);
    }
    
}
