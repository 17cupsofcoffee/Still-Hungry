package seventeencups.stillhungry.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import seventeencups.stillhungry.StillHungry;
import seventeencups.stillhungry.inventory.InventoryLunchbox;

/**
* Still-Hungry
*
* ItemLunchbox
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemLunchbox extends ItemSH {

    public ItemLunchbox(int id) {
        super(id);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!player.isSneaking()) {
            if (!world.isRemote) {
                player.openGui(StillHungry.instance, 2, world, 0, 0, 0);
            }
        }

        return itemStack;
    }
    
    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if ((InventoryLunchbox)world.perWorldStorage.loadData(InventoryLunchbox.class, player.username + ".lunchbox") == null) {
            InventoryLunchbox data = new InventoryLunchbox(player.username + ".lunchbox");
            world.perWorldStorage.setData(player.username + ".lunchbox", data);
        }
    }
}
