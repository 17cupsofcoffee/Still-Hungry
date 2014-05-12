package net.seventeencups.stillhungry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.seventeencups.stillhungry.item.ModItems;

/**
 * Still-Hungry
 *
 * FMLEventHooks
 *
 * @author 17cupsofcoffee
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */

public class FMLEventHooks {
    @SubscribeEvent
    public void onPlayerSmelting(PlayerEvent.ItemSmeltedEvent event) {
        ItemStack itemStack = event.smelting;
        if (itemStack.getItem() == ModItems.cheese) {
            event.player.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
        }
    }
}
