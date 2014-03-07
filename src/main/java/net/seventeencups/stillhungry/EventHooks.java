package net.seventeencups.stillhungry;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.seventeencups.stillhungry.block.ModBlocks;
import net.seventeencups.stillhungry.item.ModItems;

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

    @SubscribeEvent
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
                    if (killedEnt.isBurning()) {
                        event.drops.add(new EntityItem(killedEnt.worldObj, killedEnt.posX, killedEnt.posY, killedEnt.posZ,
                                new ItemStack(ModItems.lambCooked, 1)));
                    }
                    else {
                        event.drops.add(new EntityItem(killedEnt.worldObj, killedEnt.posX, killedEnt.posY, killedEnt.posZ,
                                new ItemStack(ModItems.lamb, 1)));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void bonemealUsed(BonemealEvent event) {
        int plantMetadata = event.world.getBlockMetadata(event.x, event.y, event.z);

        if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.riceBlock) {
            if (plantMetadata != 7) {
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, plantMetadata + 1, 2);
                event.setResult(Result.ALLOW);
            }
        }
        if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.strawberryBlock) {
            if (plantMetadata != 7) {
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, plantMetadata + 1, 2);
                event.setResult(Result.ALLOW);
            }
        }

        if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.grapeBlock) {
            if (plantMetadata != 7) {
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, plantMetadata + 1, 2);
                event.setResult(Result.ALLOW);
            }
        }
    }
    
    @SubscribeEvent
    public void onEntityUpdate(LivingUpdateEvent event) {
        if (event.entityLiving.isPotionActive(StillHungry.potionDrunkenness)) {
            if (event.entityLiving.getActivePotionEffect(StillHungry.potionDrunkenness).getDuration() >= (30 * 20)) {
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 7 * 20, 0));
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.regeneration.id, 7 * 20, 0));
            }
            else if (event.entityLiving.getActivePotionEffect(StillHungry.potionDrunkenness).getDuration() < (30 * 20)) {
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.id, 7 * 20, 0));
                event.entityLiving.addPotionEffect(new PotionEffect(Potion.blindness.id, 7 * 20, 0));
            }
        }
    }
}
