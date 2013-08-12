package seventeencups.stillhungry.block;

import seventeencups.stillhungry.StillHungry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

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

    public BlockHedge(int id, Material material) {
        super(id, material);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName());
    }
}
