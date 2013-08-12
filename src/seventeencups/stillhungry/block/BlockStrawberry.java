package seventeencups.stillhungry.block;

import seventeencups.stillhungry.item.ModItems;

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
    public BlockStrawberry(int par1) {
        super(par1);
    }
    
    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    protected int getSeedItem() {
        return ModItems.strawberrySeed.itemID;
    }

    @Override
    protected int getCropItem() {
        return ModItems.strawberry.itemID;
    }
}