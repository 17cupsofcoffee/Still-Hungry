package net.seventeencups.stillhungry.block;

import net.minecraft.item.Item;
import net.seventeencups.stillhungry.item.ModItems;

/**
* Still-Hungry
*
* BlockStrawberry
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class BlockStrawberry extends BlockCrop {
    public BlockStrawberry() {
        super();
    }
    
    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    protected Item func_149866_i() { //getSeedItem
        return ModItems.strawberrySeed;
    }

    @Override
    protected Item func_149865_P() { //getCropItem
        return ModItems.strawberry;
    }
}