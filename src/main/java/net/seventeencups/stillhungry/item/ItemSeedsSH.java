package net.seventeencups.stillhungry.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.seventeencups.stillhungry.StillHungry;

/**
 * Still-Hungry
 * <p/>
 * ItemSeedsSH
 *
 * @author 17cupsofcoffee
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class ItemSeedsSH extends ItemSeeds implements IPlantable {

    private Block blockType;
    private Block soilBlock;

    public ItemSeedsSH(String unlocalizedName, Block type, Block soil) {
        super(type, soil);

        setTextureName(StillHungry.modid + ":" + unlocalizedName);
        setUnlocalizedName(unlocalizedName);

        blockType = type;
        soilBlock = soil;

        setCreativeTab(StillHungry.tabStillHungry);
        setMaxStackSize(64);

    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return blockType;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }

    @Override
    public ItemSeedsSH setUnlocalizedName(String par1Str) {
        super.setUnlocalizedName(par1Str);
        return this;
    }
}
