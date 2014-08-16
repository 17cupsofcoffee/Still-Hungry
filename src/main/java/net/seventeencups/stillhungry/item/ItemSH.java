package net.seventeencups.stillhungry.item;

import net.minecraft.item.Item;
import net.seventeencups.stillhungry.StillHungry;


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
    public ItemSH(String unlocalizedName) {
        super();

        setTextureName(StillHungry.modid + ":" + unlocalizedName);
        setUnlocalizedName(unlocalizedName);
        setCreativeTab(StillHungry.tabStillHungry);
    }

    // This is overridden so I can chain the methods in ModItems.java - makes the code more readable
    @Override
    public ItemSH setMaxStackSize(int size)
    {
        this.maxStackSize = size;
        return this;
    }
}
