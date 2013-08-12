package seventeencups.stillhungry.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import seventeencups.stillhungry.StillHungry;

/**
* Still-Hungry
*
* ItemSH
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemSH extends Item {
    public ItemSH(int id) {
        super(id);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
