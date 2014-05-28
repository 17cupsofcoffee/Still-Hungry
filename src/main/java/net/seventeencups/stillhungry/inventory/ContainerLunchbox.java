package net.seventeencups.stillhungry.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

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

    private final EntityPlayer entityPlayer;
    private final InventoryLunchbox inventoryLunchbox;

    public ContainerLunchbox(EntityPlayer entityPlayer, InventoryLunchbox inventoryLunchbox) {
        this.entityPlayer = entityPlayer;
        this.inventoryLunchbox = inventoryLunchbox;

        addSlotToContainer(new SlotLunchbox(this, inventoryLunchbox, entityPlayer, 0, 62, 31));
        addSlotToContainer(new SlotLunchbox(this, inventoryLunchbox, entityPlayer, 1, 80, 31));
        addSlotToContainer(new SlotLunchbox(this, inventoryLunchbox, entityPlayer, 2, 98, 31));
        addSlotToContainer(new SlotLunchbox(this, inventoryLunchbox, entityPlayer, 3, 62, 49));
        addSlotToContainer(new SlotLunchbox(this, inventoryLunchbox, entityPlayer, 4, 80, 49));
        addSlotToContainer(new SlotLunchbox(this, inventoryLunchbox, entityPlayer, 5, 98, 49));

        bindPlayerInventory(entityPlayer.inventory);
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
    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);

        if (!entityPlayer.worldObj.isRemote) {
            saveInventory(entityPlayer);
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        //TODO
        return null;
    }

    public void saveInventory(EntityPlayer entityPlayer) {
        inventoryLunchbox.onGuiSaved(entityPlayer);
    }
}
