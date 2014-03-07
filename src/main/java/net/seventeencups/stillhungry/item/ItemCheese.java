package net.seventeencups.stillhungry.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

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
    
    public ItemCheese(int hunger, float sat, boolean wolf) {
        super(hunger, sat, wolf);
    }
    
    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote) {
            EntityItem entityItem = new EntityItem(world, entityPlayer.posX, entityPlayer.posY - 1.0D, entityPlayer.posZ, new ItemStack(Items.bucket, 1));
            world.spawnEntityInWorld(entityItem);
            if (!(entityPlayer instanceof FakePlayer)) {
                entityItem.onCollideWithPlayer(entityPlayer);
            }
        }
    }
    
}
