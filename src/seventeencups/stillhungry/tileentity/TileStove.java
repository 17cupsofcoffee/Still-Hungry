package seventeencups.stillhungry.tileentity;

import java.util.Arrays;
import java.util.List;

import seventeencups.stillhungry.block.BlockStove;
import seventeencups.stillhungry.item.ModItems;
import seventeencups.stillhungry.recipe.RecipesStove;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.inventory.ISidedInventory;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import seventeencups.stillhungry.item.ItemFryingPan;

/**
* Still-Hungry
*
* TileStove
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class TileStove extends TileEntity implements ISidedInventory {

    private ItemStack[] inv;
    public int stoveBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int stoveCookTime = 0;

    public TileStove() {
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
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this
                && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        NBTTagList tagList = tagCompound.getTagList("Items");
        this.inv = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length) {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }

        this.stoveBurnTime = tagCompound.getShort("BurnTime");
        this.stoveCookTime = tagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.inv[3]);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setShort("BurnTime", (short) this.stoveBurnTime);
        tagCompound.setShort("CookTime", (short) this.stoveCookTime);

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
    public String getInvName() {
        return "container.stove";
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1) {
        return this.stoveCookTime * par1 / 200;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }

        return this.stoveBurnTime * par1 / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.stoveBurnTime > 0;
    }

    @Override
    public void updateEntity() {
        boolean var1 = this.stoveBurnTime > 0;
        boolean var2 = false;

        if (this.stoveBurnTime > 0) {
            --this.stoveBurnTime;
        }

        if (!this.worldObj.isRemote) {

            if (this.stoveBurnTime == 0 && this.canCook()) {
                this.currentItemBurnTime = this.stoveBurnTime = getItemBurnTime(this.inv[3]);

                if (this.stoveBurnTime > 0) {
                    var2 = true;

                    if (this.inv[3] != null) {
                        --this.inv[3].stackSize;

                        if (this.inv[3].stackSize == 0) {
                            this.inv[3] = this.inv[3].getItem().getContainerItemStack(inv[3]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canCook()) {
                ++this.stoveCookTime;


                if (this.stoveCookTime == 200) {
                    this.stoveCookTime = 0;
                    this.cookItem();
                    var2 = true;
                }
            } else {
                this.stoveCookTime = 0;
            }

            if (var1 != this.stoveBurnTime > 0) {
                var2 = true;
                BlockStove.updateBlockState(this.stoveBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2) {
            this.onInventoryChanged();
        }
    }

    private boolean canCook() {
        if (this.inv[0] == null || this.inv[1] == null || this.inv[2] == null) {
            return false;
        } else {
            List<Integer> slots = Arrays.asList(this.inv[0].itemID, this.inv[1].itemID, this.inv[2].itemID);
            ItemStack var1 = RecipesStove.cooking().getCookingResult(slots);
            if (var1 == null) {
                return false;
            }

            if (this.inv[5] != null) {
                if ((this.inv[0].isItemEqual(new ItemStack(ModItems.oil)) || this.inv[1].isItemEqual(new ItemStack(ModItems.oil)))
                        && !this.inv[5].isItemEqual(new ItemStack(Item.glassBottle))) {
                    return false;
                }
                if ((this.inv[0].isItemEqual(new ItemStack(Item.bucketMilk)) || this.inv[1].isItemEqual(new ItemStack(Item.bucketMilk)))
                        && !this.inv[5].isItemEqual(new ItemStack(Item.bucketEmpty))) {
                    return false;
                }
            }

            if (this.inv[4] == null) {
                return true;
            }
            if (!this.inv[4].isItemEqual(var1)) {
                return false;
            }



            int result = inv[4].stackSize + var1.stackSize;
            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
        }
    }

    public void cookItem() {
        if (this.canCook()) {
            List<Integer> slots = Arrays.asList(this.inv[0].itemID, this.inv[1].itemID, this.inv[2].itemID);
            ItemStack var1 = RecipesStove.cooking().getCookingResult(slots);
            boolean consume = RecipesStove.cooking().getConsumeResult(slots);

            if (this.inv[4] == null) {
                this.inv[4] = var1.copy();
            } else if (this.inv[4].isItemEqual(var1)) {
                inv[4].stackSize += var1.stackSize;
            }

            if (this.inv[0].isItemEqual(new ItemStack(ModItems.oil)) || this.inv[1].isItemEqual(new ItemStack(ModItems.oil))) {
                if (this.inv[5] == null) {
                    this.inv[5] = new ItemStack(Item.glassBottle, 1);
                } else {
                    ++this.inv[5].stackSize;
                }
            }

            if (this.inv[0].isItemEqual(new ItemStack(Item.bucketMilk)) || this.inv[1].isItemEqual(new ItemStack(Item.bucketMilk))) {
                if (this.inv[5] == null) {
                    this.inv[5] = new ItemStack(Item.bucketEmpty, 1);
                } else {
                    ++this.inv[5].stackSize;
                }
            }

            --this.inv[0].stackSize;
            --this.inv[1].stackSize;

            if (this.inv[0].stackSize <= 0) {
                this.inv[0] = null;
            }
            if (this.inv[1].stackSize <= 0) {
                this.inv[1] = null;
            }

            if (consume) {
                --this.inv[2].stackSize;

                if (this.inv[2].stackSize <= 0) {
                    this.inv[2] = null;
                }
            }
            else if (this.inv[2].getItem() instanceof ItemFryingPan) {
                // this feels so hacky
                ItemFryingPan fp = (ItemFryingPan)this.inv[2].getItem();
                this.inv[2] = fp.damageTool(this.inv[2], 1);
            }
        }
    }

    public static int getItemBurnTime(ItemStack par0ItemStack) {
        if (par0ItemStack == null)
        {
            return 0;
        }
        else
        {
            int i = par0ItemStack.getItem().itemID;
            Item item = par0ItemStack.getItem();

            if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
            {
                Block block = Block.blocksList[i];

                if (block == Block.woodSingleSlab)
                {
                    return 150;
                }

                if (block.blockMaterial == Material.wood)
                {
                    return 300;
                }

                if (block == Block.field_111034_cE)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
            if (i == Item.stick.itemID) return 100;
            if (i == Item.coal.itemID) return 1600;
            if (i == Item.bucketLava.itemID) return 20000;
            if (i == Block.sapling.blockID) return 100;
            if (i == Item.blazeRod.itemID) return 2400;
            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack) {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return new int[]{};
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        if (i == 3 && isItemFuel(itemstack)) {
            return true;
        } else {
            return false;
        }
    }
}
