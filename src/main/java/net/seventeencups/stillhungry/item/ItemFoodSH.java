package net.seventeencups.stillhungry.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;

/**
* Still-Hungry
*
* ItemFoodSH
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemFoodSH extends ItemFood {
    public ItemFoodSH(String unlocalizedName, int hunger, float sat, boolean wolf) {
        super(hunger, sat, wolf);

        setTextureName(StillHungry.modid + ":" + unlocalizedName);
        setUnlocalizedName(unlocalizedName);
        setCreativeTab(StillHungry.tabStillHungry);
    }

    @Override
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        --par1ItemStack.stackSize;
        par3EntityPlayer.getFoodStats().func_151686_a(this, par1ItemStack);
        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);

        if (this.hasContainerItem(par1ItemStack)) {
            return par1ItemStack.stackSize <= 0 ? new ItemStack(this.getContainerItem()) : par1ItemStack;
        }
        else { return par1ItemStack; }
    }

    // This is overridden so I can chain the methods in ModItems.java - makes the code more readable
    @Override
    public ItemFoodSH setMaxStackSize(int size)
    {
        this.maxStackSize = size;
        return this;
    }
}
