package seventeencups.stillhungry.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import seventeencups.stillhungry.tileentity.TileBarrel;

import java.util.Iterator;

/**
* Still-Hungry
*
* ContainerBarrel
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ContainerBarrel extends Container {

    private TileBarrel tileEntity;
    private int lastIsFilled = 0;
    private int lastFruitLevel = 0;
    private int lastFruitType = 0;
    private int lastHasSugar = 0;

    public ContainerBarrel(InventoryPlayer inventoryPlayer, TileBarrel te) {
        tileEntity = te;

        addSlotToContainer(new Slot(tileEntity, 0, 80, 25));
        addSlotToContainer(new Slot(tileEntity, 1, 123, 56));

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
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tileEntity.isFilled);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tileEntity.fruitLevel);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.tileEntity.fruitType);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.tileEntity.hasSugar);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext()) {
            ICrafting icrafting = (ICrafting) var1.next();

            if (this.lastIsFilled != this.tileEntity.isFilled) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.isFilled);
            }

            if (this.lastFruitLevel != this.tileEntity.fruitLevel) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.fruitLevel);
            }

            if (this.lastFruitType != this.tileEntity.fruitType) {
                icrafting.sendProgressBarUpdate(this, 2, this.tileEntity.fruitType);
            }

            if (this.lastHasSugar != this.tileEntity.hasSugar) {
                icrafting.sendProgressBarUpdate(this, 3, this.tileEntity.hasSugar);
            }
        }

        this.lastIsFilled = this.tileEntity.isFilled;
        this.lastFruitLevel = this.tileEntity.fruitLevel;
        this.lastFruitType = this.tileEntity.fruitType;
        this.lastHasSugar = this.tileEntity.hasSugar;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2) {
        if (par1 == 0) {
            this.tileEntity.isFilled = par2;
        }

        if (par1 == 1) {
            this.tileEntity.fruitLevel = par2;
        }

        if (par1 == 2) {
            this.tileEntity.fruitType = par2;
        }

        if (par1 == 3) {
            this.tileEntity.hasSugar = par2;
        }
    }
}
