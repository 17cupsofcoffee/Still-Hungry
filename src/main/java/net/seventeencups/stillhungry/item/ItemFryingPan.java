package net.seventeencups.stillhungry.item;

import net.seventeencups.stillhungry.reference.Strings;

/**
* Still-Hungry
*
* ItemFryingPan
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ItemFryingPan extends ItemCookingTool {

    public ItemFryingPan() {
        super(Strings.FRYINGPAN_NAME);

        setMaxStackSize(1);
        setMaxDamage(250);
    }
}