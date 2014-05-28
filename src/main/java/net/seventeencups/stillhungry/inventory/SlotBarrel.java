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

public class SlotBarrel extends Slot {

    public SlotBarrel(IInventory inventory, int x, int y, int z) {
        super(inventory, x, y, z);

    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

}
