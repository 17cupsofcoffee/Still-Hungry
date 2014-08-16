package net.seventeencups.stillhungry.item;

import net.minecraft.item.ItemStack;
import net.seventeencups.stillhungry.reference.Strings;

/**
* Still-Hungry
*
* ItemFryingPan
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemFryingPan extends ItemSH {

    public ItemFryingPan() {
        super(Strings.FRYINGPAN_NAME);

        setMaxStackSize(1);
        setMaxDamage(250);
    }
    
    public ItemStack damageTool(ItemStack tool, int damage)
      {
             tool.setItemDamage(tool.getItemDamage()+damage);
             if(tool.getItemDamage() > tool.getMaxDamage())
             {
                  return null;
             }
             return tool;
      }
}