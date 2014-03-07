package net.seventeencups.stillhungry.block;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.seventeencups.stillhungry.item.ModItems;

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
    public BlockGrape() {
        super();
    }
    
    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    protected Item func_149866_i() { //getSeedItem
        return ModItems.grapeSeed;
    }

    @Override
    protected Item func_149865_P() { //getCropItem
        return ModItems.grapes;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                                    EntityPlayer player, int idk, float what, float these, float are) {
        if (world.isRemote) { return true; }
        else {
            if (world.getBlockMetadata(x, y, z) == 7) {
                world.setBlockMetadataWithNotify(x, y, z, 5, 2);
                EntityItem entityItemCrop = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(ModItems.grapes, 1));
                EntityItem entityItemSeed = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(ModItems.grapeSeed, 1));

                world.spawnEntityInWorld(entityItemCrop);
                world.spawnEntityInWorld(entityItemSeed);

                if (!(player instanceof FakePlayer)) {
                    entityItemCrop.onCollideWithPlayer(player);
                    entityItemSeed.onCollideWithPlayer(player);
                }

                return true;
            }

            else { return false; }
        }
    }
    
}