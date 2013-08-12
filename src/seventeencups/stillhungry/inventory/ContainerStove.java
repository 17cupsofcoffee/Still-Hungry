package seventeencups.stillhungry.inventory;

import java.util.Iterator;

import seventeencups.stillhungry.tileentity.TileStove;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
* Still-Hungry
*
* ContainerStove
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ContainerStove extends Container {

    private TileStove tileEntity;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerStove(InventoryPlayer inventoryPlayer, TileStove te) {
        tileEntity = te;

        addSlotToContainer(new Slot(tileEntity, 0, 46, 8));
        addSlotToContainer(new Slot(tileEntity, 1, 66, 8));
        addSlotToContainer(new Slot(tileEntity, 2, 56, 29));
        addSlotToContainer(new Slot(tileEntity, 3, 56, 64));
        addSlotToContainer(new Slot(tileEntity, 4, 116, 35));
        addSlotToContainer(new Slot(tileEntity, 5, 116, 60));

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
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slot) {
//            ItemStack stack = null;
//            Slot slotObject = (Slot) inventorySlots.get(slot);
//
//            //null checks and checks if the item can be stacked (maxStackSize > 1)
//            if (slotObject != null && slotObject.getHasStack()) {
//                    ItemStack stackInSlot = slotObject.getStack();
//                    stack = stackInSlot.copy();
//
//                    //merges the item into player inventory since its in the tileEntity
//                    //this assumes only 1 slot, for inventories with > 1 slots, check out the Chest Container.
//                    if (slot <= 4) {
//                            if (!mergeItemStack(stackInSlot, 1,
//                                            inventorySlots.size(), true)) {
//                                    return null;
//                            }
//                            
//                    //places it into the tileEntity is possible since its in the player inventory
//                    } else if (MoreFoodsStoveTileEntity.isItemFuel(stackInSlot)){
//                    	if (!mergeItemStack(stackInSlot, 3, 4, false)) {
//                            return null; 
//                    	}
//                    } else if (!mergeItemStack(stackInSlot, 0, 3, false)) {
//                    	return null;
//                    }
//
//                    if (stackInSlot.stackSize == 0) {
//                            slotObject.putStack(null);
//                    } else {
//                            slotObject.onSlotChanged();
//                    }
//            }
//
//            return stack;
        return null;
    }

    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting) {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tileEntity.stoveCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tileEntity.stoveBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.tileEntity.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext()) {
            ICrafting var2 = (ICrafting) var1.next();

            if (this.lastCookTime != this.tileEntity.stoveCookTime) {
                var2.sendProgressBarUpdate(this, 0, this.tileEntity.stoveCookTime);
            }

            if (this.lastBurnTime != this.tileEntity.stoveBurnTime) {
                var2.sendProgressBarUpdate(this, 1, this.tileEntity.stoveBurnTime);
            }

            if (this.lastItemBurnTime != this.tileEntity.currentItemBurnTime) {
                var2.sendProgressBarUpdate(this, 2, this.tileEntity.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.tileEntity.stoveCookTime;
        this.lastBurnTime = this.tileEntity.stoveBurnTime;
        this.lastItemBurnTime = this.tileEntity.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2) {
        if (par1 == 0) {
            this.tileEntity.stoveCookTime = par2;
        }

        if (par1 == 1) {
            this.tileEntity.stoveBurnTime = par2;
        }

        if (par1 == 2) {
            this.tileEntity.currentItemBurnTime = par2;
        }
    }
}
