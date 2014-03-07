package net.seventeencups.stillhungry.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.seventeencups.stillhungry.StillHungry;

/**
* Still-Hungry
*
* BlockHedge
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class BlockHedge extends Block {

    public BlockHedge() {
        super(Material.leaves);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName());
    }
}
