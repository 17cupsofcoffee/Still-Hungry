package net.seventeencups.stillhungry.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

/**
 * Still-Hungry
 *
 * SlotLunchbox
 *
 * @author 17cupsofcoffee
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */

public class SlotLunchbox extends Slot {

    private final EntityPlayer entityPlayer;
    private ContainerLunchbox containerLunchbox;

    public SlotLunchbox(ContainerLunchbox containerLunchbox, IInventory inventory, EntityPlayer entityPlayer, int x, int y, int z) {
        super(inventory, x, y, z);
        this.entityPlayer = entityPlayer;
        this.containerLunchbox = containerLunchbox;
    }

    @Override
    public void onSlotChange(ItemStack itemStack1, ItemStack itemStack2) {
        super.onSlotChange(itemStack1, itemStack2);
        containerLunchbox.saveInventory(entityPlayer);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack.getItem() instanceof ItemFood;
    }
}
