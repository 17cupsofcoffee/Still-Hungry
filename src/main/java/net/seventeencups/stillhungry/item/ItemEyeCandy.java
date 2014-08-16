package net.seventeencups.stillhungry.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
* Still-Hungry
*
* ItemEyeCandy
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemEyeCandy extends ItemFoodSH {

    public ItemEyeCandy(String unlocalizedName, int hunger, float sat, boolean wolf) {
        super(unlocalizedName, hunger, sat, wolf);

        setAlwaysEdible();
    }

    @Override
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            par3EntityPlayer.addExperience((int) (par3EntityPlayer.xpBarCap() - par3EntityPlayer.experience));
        }
    }
}