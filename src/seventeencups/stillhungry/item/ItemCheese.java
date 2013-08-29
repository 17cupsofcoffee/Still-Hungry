package seventeencups.stillhungry.item;

import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
* Still-Hungry
*
* ItemCheese
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemCheese extends ItemFoodSH {
    // This item has a subclass because it needs to give the bucket from the recipe
    // back when it's smelted. I doubt this is the most elegant solution to this
    // problem, if you have a better one please pull request!
    
    public ItemCheese(int id, int hunger, float sat, boolean wolf) {
        super(id, hunger, sat, wolf);
    }
    
    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!entityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty))) {
            entityPlayer.dropPlayerItem(new ItemStack(Item.bucketEmpty.itemID, 1, 0));
        }
    }
    
}
