package seventeencups.stillhungry.block;

import seventeencups.stillhungry.item.ModItems;

/**
* Still-Hungry
*
* BlockGrape
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class BlockGrape extends BlockCrop {
    public BlockGrape(int par1) {
        super(par1);
    }
    
    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    protected int getSeedItem() {
        return ModItems.grapeSeed.itemID;
    }

    @Override
    protected int getCropItem() {
        return ModItems.grapes.itemID;
    }
    
}