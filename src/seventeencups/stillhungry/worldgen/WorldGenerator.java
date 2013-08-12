package seventeencups.stillhungry.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import static net.minecraftforge.common.BiomeDictionary.Type;

/**
* Still-Hungry
*
* WorldGenerator
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class WorldGenerator implements IWorldGenerator {

    protected Random randomGenerator;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random random, int blockX,
            int blockZ) {
        
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(blockX, blockZ);

        if (random.nextInt(4) == 0) {
            int Xcoord1 = blockX + random.nextInt(16);
            int Ycoord1 = random.nextInt(80);
            int Zcoord1 = blockZ + random.nextInt(16);

            (new WorldGenRice()).generate(world, random, Xcoord1,
                    Ycoord1, Zcoord1);
        }

        if (random.nextInt(4) == 0) {
            int Xcoord1 = blockX + random.nextInt(16);
            int Ycoord1 = random.nextInt(80);
            int Zcoord1 = blockZ + random.nextInt(16);

            (new WorldGenStrawberry()).generate(world, random, Xcoord1,
                    Ycoord1, Zcoord1);
        }

        if (BiomeDictionary.isBiomeOfType(biome, Type.PLAINS)) {
            if (random.nextInt(3) == 0) {
            int Xcoord1 = blockX + random.nextInt(16);
            int Ycoord1 = random.nextInt(80);
            int Zcoord1 = blockZ + random.nextInt(16);

            (new WorldGenGrape()).generate(world, random, Xcoord1,
                    Ycoord1, Zcoord1);
        }
        }
    }

    private void generateNether(World world, Random random, int blockX,
            int blockZ) {
    }
}