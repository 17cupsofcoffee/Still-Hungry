package seventeencups.stillhungry.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
* Still-Hungry
*
* WorldGenBanana
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class WorldGenBanana extends WorldGenerator {

    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        for (int y = 62; y < 160; ++y) {
            for (int z = 0; z < 16; ++z) {
                for (int x = 0; x < 16; ++x) {
                    if (par1World.getBlockId(par3 + x, y, par5 + z) == 18
                            && (par1World.getBiomeGenForCoords(par3, par5) == BiomeGenBase.jungle
                            || par1World.getBiomeGenForCoords(par3, par5) == BiomeGenBase.jungleHills)) {
                        if (par1World.isAirBlock(par3 + x, y - 1, par5 + z)) {
                            if (par1World.getBlockId(par3 + x + 1, y - 1, par5 + z) == 17
                                    || par1World.getBlockId(par3 + x - 1, y - 1, par5 + z) == 17
                                    || par1World.getBlockId(par3 + x, y - 1, par5 + z + 1) == 17
                                    || par1World.getBlockId(par3 + x, y - 1, par5 + z - 1) == 17) {
                                if (par2Random.nextInt(5) == 0) {
                                    //par1World.setBlock(par3 + x, y - 1, par5 + z, ModBlocks.bananaBlock.blockID);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
