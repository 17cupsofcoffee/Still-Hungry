package net.seventeencups.stillhungry.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;

/**
* Still-Hungry
*
* BlockCrop
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class BlockCrop extends BlockCrops {

    public IIcon[] iconArray;

    public BlockCrop() {
        super();

        setHardness(0.0f);
        setStepSound(Block.soundTypeGrass);
        setTickRandomly(true);
    }
    
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.iconArray = new IIcon[8];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "_stage_" + i);
        }
    }
    
//    @Override
//    protected Item func_149866_i(); //getSeedItem
//
//    @Override
//    protected Item func_149865_P(); //getCropItem
    
    @Override
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > 7)
        {
            par2 = 7;
        }

        return this.iconArray[par2];
    }
}
