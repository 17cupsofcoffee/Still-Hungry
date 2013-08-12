package seventeencups.stillhungry.block;

import seventeencups.stillhungry.StillHungry;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

/**
* Still-Hungry
*
* BlockCrop
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public abstract class BlockCrop extends BlockCrops {

    public Icon[] iconArray;

    public BlockCrop(int blockId) {
        super(blockId);
        setTickRandomly(true);
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[8];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "_stage_" + i);
        }
    }
    
    @Override
    protected abstract int getSeedItem();
    
    @Override
    protected abstract int getCropItem();
    
    @Override
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > 7)
        {
            par2 = 7;
        }

        return this.iconArray[par2];
    }
}
