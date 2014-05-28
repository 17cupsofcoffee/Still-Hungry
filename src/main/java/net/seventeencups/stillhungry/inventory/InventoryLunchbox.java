package net.seventeencups.stillhungry.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.seventeencups.stillhungry.lib.Strings;
import net.seventeencups.stillhungry.util.INBTTaggable;
import net.seventeencups.stillhungry.util.NBTHelper;

import java.util.UUID;

/**
 * Created by 17CupsOfCoffee on 28/05/2014.
 */
public class InventoryLunchbox implements IInventory, INBTTaggable {
    public ItemStack parentItemStack;
    protected ItemStack[] inventory;

    public InventoryLunchbox(ItemStack itemStack) {
        this.parentItemStack = itemStack;

        inventory = new ItemStack[6];

        readFromNBT(itemStack.getTagCompound());
    }

    public void onGuiSaved(EntityPlayer entityPlayer) {
        parentItemStack = findParentItemStack(entityPlayer);

        if (parentItemStack != null) {
            save();
        }
    }

    public ItemStack findParentItemStack(EntityPlayer entityPlayer) {
        if (NBTHelper.hasUUID(parentItemStack)) {
            UUID parentItemStackUUID = new UUID(parentItemStack.getTagCompound().getLong(Strings.UUID_MOST_SIG),
                    parentItemStack.getTagCompound().getLong(Strings.UUID_LEAST_SIG));
            for (int i = 0; i < entityPlayer.inventory.getSizeInventory(); i++) {
                ItemStack itemStack = entityPlayer.inventory.getStackInSlot(i);

                if (NBTHelper.hasUUID(itemStack)) {
                    if (itemStack.getTagCompound().getLong(Strings.UUID_MOST_SIG) == parentItemStackUUID.getMostSignificantBits()
                            && itemStack.getTagCompound().getLong(Strings.UUID_LEAST_SIG) == parentItemStackUUID.getLeastSignificantBits())
                    {
                        return itemStack;
                    }
                }
            }

        }

        return null;
    }

    public boolean matchesUUID(UUID uuid) {
       return NBTHelper.hasUUID(parentItemStack) && parentItemStack.getTagCompound().getLong(Strings.UUID_LEAST_SIG) == uuid.getLeastSignificantBits()
               && parentItemStack.getTagCompound().getLong(Strings.UUID_MOST_SIG) == uuid.getMostSignificantBits();
    }

    public void save() {
        NBTTagCompound nbtTagCompound = parentItemStack.getTagCompound();

        if (nbtTagCompound == null) {
            nbtTagCompound = new NBTTagCompound();

            UUID uuid = UUID.randomUUID();
            nbtTagCompound.setLong(Strings.UUID_MOST_SIG, uuid.getMostSignificantBits());
            nbtTagCompound.setLong(Strings.UUID_LEAST_SIG, uuid.getLeastSignificantBits());
        }

        writeToNBT(nbtTagCompound);
        parentItemStack.setTagCompound(nbtTagCompound);
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex) {
        return inventory[slotIndex];
    }

    @Override
    public ItemStack decrStackSize(int slotIndex, int decrementAmount) {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            if (itemStack.stackSize <= decrementAmount)
            {
                setInventorySlotContents(slotIndex, null);
            }
            else
            {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.stackSize == 0)
                {
                    setInventorySlotContents(slotIndex, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex)
    {
        if (inventory[slotIndex] != null)
        {
            ItemStack itemStack = inventory[slotIndex];
            inventory[slotIndex] = null;
            return itemStack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack itemStack)
    {
        inventory[slotIndex] = itemStack;
    }

    @Override
    public String getInventoryName() {
        return "container.lunchbox";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
        // Required
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory() {
        // Required
    }

    @Override
    public void closeInventory() {
        // Required
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack) {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        if (nbtTagCompound != null) {
            if (nbtTagCompound.hasKey("Items")) {
                NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
                inventory = new ItemStack[this.getSizeInventory()];
                for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    byte slotIndex = tagCompound.getByte("Slot");
                    if (slotIndex >= 0 && slotIndex < inventory.length) {
                        inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
                    }
                }
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        NBTTagList tagList = new NBTTagList();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) i);
                inventory[i].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }
}
