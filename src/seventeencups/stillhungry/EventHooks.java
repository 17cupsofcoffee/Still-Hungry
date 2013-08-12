package seventeencups.stillhungry;

import seventeencups.stillhungry.block.ModBlocks;
import seventeencups.stillhungry.item.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

/**
* Still-Hungry
*
* EventHooks
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class EventHooks {

    @ForgeSubscribe
    public void entityDrops(LivingDropsEvent event) {
        EntityLivingBase killedEnt = event.entityLiving;
        DamageSource source = event.source;
        boolean recentlyHit = event.recentlyHit;

        if (recentlyHit) {
            if (source.getEntity() instanceof EntityPlayer) {
                if (killedEnt instanceof EntitySquid) {
                    event.drops.add(new EntityItem(killedEnt.worldObj, killedEnt.posX, killedEnt.posY, killedEnt.posZ,
                            new ItemStack(ModItems.squid, 1)));
                }

                if (killedEnt instanceof EntitySheep) {
                    event.drops.add(new EntityItem(killedEnt.worldObj, killedEnt.posX, killedEnt.posY, killedEnt.posZ,
                            new ItemStack(ModItems.lamb, 1)));
                }
            }
        }
    }

    @ForgeSubscribe
    public void bonemealUsed(BonemealEvent event) {
        if (event.world.getBlockId(event.X, event.Y, event.Z) == ModBlocks.riceBlock.blockID) {
            if (event.world.getBlockMetadata(event.X, event.Y, event.Z) != 7) {
                event.world.setBlockMetadataWithNotify(event.X, event.Y, event.Z, 7, 2);
                event.setResult(Result.ALLOW);
            }
        }
        if (event.world.getBlockId(event.X, event.Y, event.Z) == ModBlocks.strawberryBlock.blockID) {
            if (event.world.getBlockMetadata(event.X, event.Y, event.Z) != 7) {
                event.world.setBlockMetadataWithNotify(event.X, event.Y, event.Z, 7, 2);
                event.setResult(Result.ALLOW);
            }
        }

        if (event.world.getBlockId(event.X, event.Y, event.Z) == ModBlocks.grapeBlock.blockID) {
            if (event.world.getBlockMetadata(event.X, event.Y, event.Z) != 7) {
                event.world.setBlockMetadataWithNotify(event.X, event.Y, event.Z, 7, 2);
                event.setResult(Result.ALLOW);
            }
        }
    }
    
    @ForgeSubscribe
    public void onEntityUpdate(LivingUpdateEvent event) {
        if (event.entityLiving.isPotionActive(StillHungry.potionDrunkenness)) {
            if (event.entityLiving.getActivePotionEffect(StillHungry.potionDrunkenness).duration >= (30 * 20)) {
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 7 * 20, 0));
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.regeneration.id, 7 * 20, 0));
            }
            else if (event.entityLiving.getActivePotionEffect(StillHungry.potionDrunkenness).duration < (30 * 20)) {
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.id, 7 * 20, 0));
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.blindness.id, 7 * 20, 0));
            }
        }
    }
}
