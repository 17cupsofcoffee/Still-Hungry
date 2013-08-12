package seventeencups.stillhungry.item;

import net.minecraft.item.ItemStack;

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

    public ItemFryingPan(int id) {
        super(id);
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