package seventeencups.stillhungry.item;

import seventeencups.stillhungry.StillHungry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

/**
* Still-Hungry
*
* ItemSeedsSH
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemSeedsSH extends ItemSeeds implements IPlantable {

    private int blockType;
    private int soilBlockID;

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    public ItemSeedsSH(int par1, int par2, int par3) {
        super(par1, par2, par3);
        blockType = par2;
        soilBlockID = par3;
        this.setCreativeTab(CreativeTabs.tabMaterials);
        setMaxStackSize(64);
        
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z) {
        return blockType;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z) {
        return 0;
    }
    
    @Override
    public ItemSeedsSH setUnlocalizedName(String par1Str)
    {
        super.setUnlocalizedName(par1Str);
        return this;
    }
}
