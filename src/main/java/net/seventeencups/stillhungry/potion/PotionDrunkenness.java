package net.seventeencups.stillhungry.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.seventeencups.stillhungry.StillHungry;

/**
* Still-Hungry
*
* PotionDrunkenness
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class PotionDrunkenness extends Potion {
    public PotionDrunkenness(int par1, boolean par2, int par3) {
        super(par1, par2, par3);
    }
    
    @Override
    public Potion setIconIndex(int par1, int par2) {
        super.setIconIndex(par1, par2);
        return this;
    }
    
    @Override
    public int getStatusIconIndex() {
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StillHungry.modid + ":textures/gui/potion.png"));;
        return super.getStatusIconIndex();
    }
}
