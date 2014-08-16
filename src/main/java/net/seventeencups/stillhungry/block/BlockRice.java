package net.seventeencups.stillhungry.block;

import net.minecraft.item.Item;
import net.seventeencups.stillhungry.item.ModItems;
import net.seventeencups.stillhungry.reference.Strings;

/**
* Still-Hungry
*
* BlockRice
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class BlockRice extends BlockCrop {
    public BlockRice() {
        super();

        setBlockName(Strings.RICEBLOCK_NAME);
    }
    
    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    protected Item func_149866_i() { //getSeedItem
        return ModItems.riceSeed;
    }

    @Override
    protected Item func_149865_P() { //getCropItem
        return ModItems.rice;
    }
}