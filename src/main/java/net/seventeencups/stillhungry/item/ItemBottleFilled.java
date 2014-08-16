package net.seventeencups.stillhungry.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.seventeencups.stillhungry.StillHungry;

/**
* Still-Hungry
*
* ItemBottleFilled
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemBottleFilled extends ItemFood {

    public ItemBottleFilled(String unlocalizedName, int hunger, float sat, boolean wolf) {
        super(hunger, sat, wolf);

        setTextureName(StillHungry.modid + ":" + unlocalizedName);
        setUnlocalizedName(unlocalizedName);
        setCreativeTab(StillHungry.tabStillHungry);

        setContainerItem(ModItems.bottle);
        setMaxStackSize(1);
    }

    @Override
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
            par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
            par3EntityPlayer.getFoodStats().func_151686_a(this, par1ItemStack);
        }
        
        par3EntityPlayer.addPotionEffect(new PotionEffect(StillHungry.potionDrunkenness.id, 120 * 20, 0));

        return par1ItemStack.stackSize <= 0 ? new ItemStack(ModItems.bottle) : par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items
     * is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
}
