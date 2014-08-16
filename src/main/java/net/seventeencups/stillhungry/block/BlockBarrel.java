package net.seventeencups.stillhungry.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;
import net.seventeencups.stillhungry.reference.GuiIds;
import net.seventeencups.stillhungry.reference.Strings;
import net.seventeencups.stillhungry.tileentity.TileBarrel;

import java.util.Random;

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
    protected IIcon barrelBottomIcon;
    protected IIcon barrelTopIcon;

    public BlockBarrel() {
        super(Material.wood);

        setCreativeTab(StillHungry.tabStillHungry);
        setBlockName(Strings.BREWINGBARREL_NAME);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Side");
        this.barrelBottomIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Bottom");
        this.barrelTopIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Top");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileBarrel();
    }

    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        par1World.setTileEntity(par2, par3, par4, createTileEntity(par1World, par1World.getBlockMetadata(par2, par3, par4)));
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

//    @Override
//    public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int side) { // Is this necessary anymore?
//        switch (side) {
//            case 0:
//                return barrelBottomIcon;
//            case 1:
//                return barrelTopIcon;
//            default:
//                return blockIcon;
//        }
//    }

    @Override
    public IIcon getIcon(int side, int metadata) {
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
        TileEntity te = world.getTileEntity(x, y, z);
        if (te == null || player.isSneaking()) {
            return false;
        }

        if (!world.isRemote) {
            player.openGui(StillHungry.instance, GuiIds.BARREL, world, x, y, z);
        }

        return true;
    }

    public static void updateBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
        TileEntity var6 = par1World.getTileEntity(par2, par3, par4);

        if (var6 != null) {
            var6.validate();
            par1World.setTileEntity(par2, par3, par4, var6);
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
        dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z) {
        Random rand = new Random();

        TileEntity te = world.getTileEntity(x, y, z);
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
                        new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

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
