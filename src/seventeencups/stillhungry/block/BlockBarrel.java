package seventeencups.stillhungry.block;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import seventeencups.stillhungry.StillHungry;
import seventeencups.stillhungry.tileentity.TileBarrel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
* Still-Hungry
*
* BlockBarrel
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class BlockBarrel extends BlockContainer {

    public TileBarrel tileEntity;
    protected Icon barrelBottomIcon;
    protected Icon barrelTopIcon;

    public BlockBarrel(int id, Material material) {
        super(id, material);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Side");
        this.barrelBottomIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Bottom");
        this.barrelTopIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Top");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileBarrel();
    }

    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        par1World.setBlockTileEntity(par2, par3, par4, createTileEntity(par1World, par1World.getBlockMetadata(par2, par3, par4)));
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int side) {
        switch (side) {
            case 0:
                return barrelBottomIcon;
            case 1:
                return barrelTopIcon;
            default:
                return blockIcon;
        }
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        switch (side) {
            case 0:
                return barrelBottomIcon;
            case 1:
                return barrelTopIcon;
            default:
                return blockIcon;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int idk, float what, float these, float are) {
        TileEntity te = world.getBlockTileEntity(x, y, z);
        if (te == null || player.isSneaking()) {
            return false;
        }

        if (!world.isRemote) {
            player.openGui(StillHungry.instance, 1, world, x, y, z);
        }

        return true;
    }

    public static void updateBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
        TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);

        if (var6 != null) {
            var6.validate();
            par1World.setBlockTileEntity(par2, par3, par4, var6);
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z) {
        Random rand = new Random();

        TileEntity te = world.getBlockTileEntity(x, y, z);
        if (!(te instanceof IInventory)) {
            return;
        }
        IInventory inventory = (IInventory) te;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world,
                        x + rx, y + ry, z + rz,
                        new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }
}
