package net.seventeencups.stillhungry.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;
import net.seventeencups.stillhungry.tileentity.TileStove;

import java.util.Random;

/**
* Still-Hungry
*
* BlockStove
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class BlockStove extends BlockContainer {

    public TileStove tileEntity;
    public boolean isActive = false;
    private static boolean keepInventory = false;
    @SideOnly(Side.CLIENT)
    protected IIcon stoveBackIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon stoveFrontIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon stoveLeftIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon stoveRightIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon stoveBottomIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon stoveTopOnIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon stoveTopOffIcon;

    public BlockStove(boolean active) {
        super(Material.iron);
        setHardness(2.0F);
        setResistance(5.0F);
        setBlockName("stoveBlock");
        setCreativeTab(CreativeTabs.tabDecorations);
        isActive = active;

    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.stoveBackIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Back");
        this.stoveFrontIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Front");
        this.stoveLeftIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Left");
        this.stoveRightIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Right");
        this.stoveBottomIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "Bottom");
        this.stoveTopOnIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "TopOn");
        this.stoveTopOffIcon = par1IconRegister.registerIcon(StillHungry.modid + ":" + this.getUnlocalizedName() + "TopOff");

    }

    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4) {
        if (!par1World.isRemote) {
            if (!keepInventory) {
                Block l = par1World.getBlock(par2, par3, par4 - 1);
                Block i1 = par1World.getBlock(par2, par3, par4 + 1);
                Block j1 = par1World.getBlock(par2 - 1, par3, par4);
                Block k1 = par1World.getBlock(par2 + 1, par3, par4);
                byte b0 = 3;

                if (l.isOpaqueCube() && !i1.isOpaqueCube()) {
                    b0 = 3;
                }

                if (i1.isOpaqueCube() && !l.isOpaqueCube()) {
                    b0 = 2;
                }

                if (j1.isOpaqueCube() && !k1.isOpaqueCube()) {
                    b0 = 5;
                }

                if (k1.isOpaqueCube() && !j1.isOpaqueCube()) {
                    b0 = 4;
                }

                par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
            }
        }
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        switch (metadata) {
            case 2:
                switch (side) {
                    case 0:
                        return stoveBottomIcon;
                    case 1:
                        if (isActive) {
                            return stoveTopOnIcon;
                        } else {
                            return stoveTopOffIcon;
                        }
                    case 2:
                        return stoveFrontIcon;
                    case 3:
                        return stoveBackIcon;
                    case 4:
                        return stoveRightIcon;
                    case 5:
                        return stoveLeftIcon;
                }
            case 3:
                switch (side) {
                    case 0:
                        return stoveBottomIcon;
                    case 1:
                        if (isActive) {
                            return stoveTopOnIcon;
                        } else {
                            return stoveTopOffIcon;
                        }
                    case 2:
                        return stoveBackIcon;
                    case 3:
                        return stoveFrontIcon;
                    case 4:
                        return stoveLeftIcon;
                    case 5:
                        return stoveRightIcon;
                }
            case 4:
                switch (side) {
                    case 0:
                        return stoveBottomIcon;
                    case 1:
                        if (isActive) {
                            return stoveTopOnIcon;
                        } else {
                            return stoveTopOffIcon;
                        }
                    case 2:
                        return stoveLeftIcon;
                    case 3:
                        return stoveRightIcon;
                    case 4:
                        return stoveFrontIcon;
                    case 5:
                        return stoveBackIcon;
                }
            case 5:
                switch (side) {
                    case 0:
                        return stoveBottomIcon;
                    case 1:
                        if (isActive) {
                            return stoveTopOnIcon;
                        } else {
                            return stoveTopOffIcon;
                        }
                    case 2:
                        return stoveRightIcon;
                    case 3:
                        return stoveLeftIcon;
                    case 4:
                        return stoveBackIcon;
                    case 5:
                        return stoveFrontIcon;
                }

            default:
                switch (side) {
                    case 0:
                        return stoveBottomIcon;
                    case 1:
                        return stoveTopOffIcon;
                    case 2:
                        return stoveLeftIcon;
                    case 3:
                        return stoveRightIcon;
                    case 4:
                        return stoveFrontIcon;
                    case 5:
                        return stoveBackIcon;
                    default:
                        return stoveBackIcon;
                }
        }
    }

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int idk, float what, float these, float are) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te == null || player.isSneaking()) {
            return false;
        }

        player.openGui(StillHungry.instance, 0, world, x, y, z);
        return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
        if (!keepInventory) {
            dropItems(world, x, y, z);
            super.breakBlock(world, x, y, z, par5, par6);
        }
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

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileStove();
    }

    public static void updateBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity var6 = par1World.getTileEntity(par2, par3, par4);
        keepInventory = true;

        if (par0) {
            par1World.setBlock(par2, par3, par4, ModBlocks.stoveBlockBurning, var5, 2);
        } else {
            par1World.setBlock(par2, par3, par4, ModBlocks.stoveBlock, var5, 2);
        }

        keepInventory = false;

        if (var6 != null) {
            var6.validate();
            par1World.setTileEntity(par2, par3, par4, var6);
        }
    }

    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (this.isActive) {
            float x1 = (float) par2 + 0.23F;
            float y = (float) par3 + 1F;
            float z1 = (float) par4 + 0.25F;

            float x2 = (float) par2 + 0.73F;
            float z2 = (float) par4 + 0.25F;

            float x3 = (float) par2 + 0.73F;
            float z3 = (float) par4 + 0.75F;

            float x4 = (float) par2 + 0.23F;
            float z4 = (float) par4 + 0.75F;

            par1World.spawnParticle("smoke", (double) x1, (double) y, (double) z1, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("smoke", (double) x2, (double) y, (double) z2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("smoke", (double) x3, (double) y, (double) z3, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("smoke", (double) x4, (double) y, (double) z4, 0.0D, 0.0D, 0.0D);
        }
    }
}
