package net.seventeencups.stillhungry.util;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Still-Hungry
 *
 * INBTTaggable
 *
 * @author Pahimar
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */

public interface INBTTaggable
{
    void readFromNBT(NBTTagCompound nbtTagCompound);

    void writeToNBT(NBTTagCompound nbtTagCompound);
}