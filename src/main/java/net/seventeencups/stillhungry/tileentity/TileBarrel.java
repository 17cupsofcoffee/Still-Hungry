package net.seventeencups.stillhungry.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.seventeencups.stillhungry.item.ModItems;

/**
* Still-Hungry
*
* TileBarrel
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class TileBarrel extends TileEntity implements ISidedInventory {

    private ItemStack[] inv;
    public int isFilled = 0;
    public int fruitLevel = 0;
    public int fruitType = 0; // 0 = None, 1 = Grapes, 2 = Apples
    public int hasSugar = 0;
    // GUI stuff
    public int lastIsFilled = 0;
    public int waterLevel = 0;
    public boolean depleting = false;

    public TileBarrel() {
        inv = new ItemStack[2];
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
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
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
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this
                && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        NBTTagList tagList = tagCompound.getTagList("Items", 10);
        this.inv = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length) {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }

        this.isFilled = tagCompound.getShort("IsFilled");
        this.fruitLevel = tagCompound.getShort("FruitLevel");
        this.fruitType = tagCompound.getShort("FruitType");
        this.hasSugar = tagCompound.getShort("HasSugar");
        this.lastIsFilled = tagCompound.getShort("LastIsFilled");
        this.waterLevel = tagCompound.getShort("WaterLevel");
        this.depleting = tagCompound.getBoolean("Depleting");
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setShort("IsFilled", (short) this.isFilled);
        tagCompound.setShort("FruitLevel", (short) this.fruitLevel);
        tagCompound.setShort("FruitType", (short) this.fruitType);
        tagCompound.setShort("HasSugar", (short) this.hasSugar);
        tagCompound.setShort("LastIsFilled", (short) this.lastIsFilled);
        tagCompound.setShort("WaterLevel", (short) this.waterLevel);
        tagCompound.setBoolean("Depleting", this.depleting);


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

    @Override
    public String getInventoryName() {
        return "container.barrel";
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        boolean var2 = false;         // Has the inv changed?

        if (!this.worldObj.isRemote) {
            if (this.isFilled == 0) {
                if (this.fruitType == 0 && this.inv[0] != null) {
                    if (this.inv[0].isItemEqual(new ItemStack(Items.water_bucket))) {
                        var2 = true;
                        this.inv[0] = new ItemStack(Items.bucket, 1);
                        isFilled = 1;
                    }
                }
            } else {
                if (this.fruitType == 0 && this.fruitLevel < 4 && this.inv[0] != null) {
                    if (this.inv[0].isItemEqual(new ItemStack(ModItems.grapes))) {
                        fruitType = 1;
                    }

                    if (this.inv[0].isItemEqual(new ItemStack(Items.apple))) {
                        fruitType = 2;
                    }


                }

                if (this.fruitType == 1 && this.fruitLevel < 4 && this.inv[0] != null) {
                    if (this.inv[0].isItemEqual(new ItemStack(ModItems.grapes))) {
                        var2 = true;
                        decrStackSize(0, 1);
                        fruitLevel++;
                    }
                }

                if (this.fruitType == 2 && this.fruitLevel < 4 && this.inv[0] != null) {
                    if (this.inv[0].isItemEqual(new ItemStack(Items.apple))) {
                        var2 = true;
                        decrStackSize(0, 1);
                        fruitLevel++;
                    }
                }

                if (this.hasSugar == 0 && this.inv[0] != null) {
                    if (this.inv[0].isItemEqual(new ItemStack(Items.sugar))) {
                        var2 = true;
                        decrStackSize(0, 1);
                        hasSugar = 1;
                    }
                }

                if (this.fruitLevel >= 4 && this.hasSugar == 1 && this.inv[1] != null) {
                    if (this.inv[1].isItemEqual(new ItemStack(ModItems.bottle)) && this.inv[1].stackSize == 1) {
                        var2 = true;
                        if (this.fruitType == 1) {
                            this.inv[1] = new ItemStack(ModItems.bottleWine);
                        } else if (this.fruitType == 2) {
                            this.inv[1] = new ItemStack(ModItems.bottleCider);
                        }

                        isFilled = 0;
                        fruitLevel = 0;
                        fruitType = 0;
                        hasSugar = 0;

                    }
                }
            }

        }

        if (var2) {
            this.markDirty();
        }
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        if (var1 == 1) {
            return new int[]{0};
        } else {
            return new int[]{};
        }
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        if (getAccessibleSlotsFromSide(i) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return true;
    }
}
