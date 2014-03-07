package net.seventeencups.stillhungry.worldgen;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.seventeencups.stillhungry.block.ModBlocks;

import java.util.Random;

/**
* Still-Hungry
*
* WorldGenStrawberry
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class WorldGenStrawberry extends WorldGenerator {

    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        // 64 is pumpkin freq
        for (int var6 = 0; var6 < 64; ++var6) {
            int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
            int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
            int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

            if (par1World.isAirBlock(var7, var8, var9) && par1World.getBlock(var7, var8 - 1, var9) == Blocks.grass && Blocks.pumpkin.canPlaceBlockAt(par1World, var7, var8, var9)) {
                par1World.setBlock(var7, var8 - 1, var9, Blocks.farmland);
                par1World.setBlock(var7, var8, var9, ModBlocks.strawberryBlock, 7, 2);
            }
        }

        return true;
    }
}
