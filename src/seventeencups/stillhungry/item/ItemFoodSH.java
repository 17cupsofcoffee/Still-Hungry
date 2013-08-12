package seventeencups.stillhungry.item;

import seventeencups.stillhungry.StillHungry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

/**
* Still-Hungry
*
* ItemFoodSH
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemFoodSH extends ItemFood {
    public ItemFoodSH(int id, int hunger, float sat, boolean wolf) {
        super(id, hunger, sat, wolf);
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
