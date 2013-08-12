package seventeencups.stillhungry.block;

import seventeencups.stillhungry.lib.BlockIds;
import seventeencups.stillhungry.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

/**
* Still-Hungry
*
* ModBlocks
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ModBlocks {

    public static Block hedge;
    public static Block roseHedge;
    public static Block daffodilHedge;
    public static Block riceBlock;
    public static Block strawberryBlock;
    public static Block stoveBlock;
    public static Block stoveBlockBurning;
    public static Block brewingBarrel;
    //public static Block bananaBlock;
    public static Block grapeBlock;

    public static void init() {
        hedge = new BlockHedge(BlockIds.HEDGE, Material.leaves).setHardness(0.25f)
                .setStepSound(Block.soundGrassFootstep).setUnlocalizedName("hedge")
                .setCreativeTab(CreativeTabs.tabDecorations);

        roseHedge = new BlockHedge(BlockIds.ROSEHEDGE, Material.leaves)
                .setHardness(0.25f).setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("roseHedge")
                .setCreativeTab(CreativeTabs.tabDecorations);

        daffodilHedge = new BlockHedge(BlockIds.DAFFODILHEDGE, Material.leaves)
                .setHardness(0.25f).setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("daffodilHedge")
                .setCreativeTab(CreativeTabs.tabDecorations);

        riceBlock = new BlockRice(BlockIds.RICEBLOCK)
                .setHardness(0.0f)
                .setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("riceBlock");

        strawberryBlock = new BlockStrawberry(BlockIds.STRAWBERRYBLOCK)
                .setHardness(0.0f)
                .setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("strawberryBlock");

        stoveBlock = new BlockStove(BlockIds.STOVEBLOCK, false);
        stoveBlockBurning = new BlockStove(BlockIds.STOVEBLOCKBURNING, true)
                .setLightValue(0.875F).setCreativeTab(null);

        brewingBarrel = new BlockBarrel(BlockIds.BREWINGBARREL, Material.wood)
                .setCreativeTab(CreativeTabs.tabDecorations)
                .setUnlocalizedName("brewingBarrel");

        //bananaBlock = new BlockBanana(BlockIds.BANANABLOCK, Material.plants)
        //		.setCreativeTab(CreativeTabs.tabDecorations)
        //		.setUnlocalizedName("bananaBlock");

        grapeBlock = new BlockGrape(BlockIds.GRAPEBLOCK)
                .setHardness(0.0f)
                .setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("grapeBlock");

        GameRegistry.registerBlock(hedge, Strings.HEDGE_NAME);
        GameRegistry.registerBlock(roseHedge, Strings.ROSEHEDGE_NAME);
        GameRegistry.registerBlock(daffodilHedge, Strings.DAFFODILHEDGE_NAME);

        GameRegistry.registerBlock(riceBlock, Strings.RICEBLOCK_NAME);
        GameRegistry.registerBlock(strawberryBlock, Strings.STRAWBERRYBLOCK_NAME);

        GameRegistry.registerBlock(stoveBlock, Strings.STOVEBLOCK_NAME);
        GameRegistry.registerBlock(stoveBlockBurning, Strings.STOVEBLOCKBURNING_NAME);

        GameRegistry.registerBlock(brewingBarrel, Strings.BREWINGBARREL_NAME);

        //GameRegistry.registerBlock(bananaBlock, Strings.BANANABLOCK_NAME);

        GameRegistry.registerBlock(grapeBlock, Strings.GRAPEBLOCK_NAME);

        initBlockRecipes();

        initLanguages();
    }

    private static void initBlockRecipes() {
        ItemStack hedgeStack = new ItemStack(hedge);
        ItemStack leavesStack = new ItemStack(Block.leaves, 1, -1);

        GameRegistry.addRecipe(new ItemStack(stoveBlock), "iii", "s s", "sss",
                'i', new ItemStack(Item.ingotIron), 's', new ItemStack(Block.stone));
        GameRegistry.addRecipe(new ItemStack(brewingBarrel), "www", "iii", "www",
                'w', new ItemStack(Block.planks, 1, -1), 'i', new ItemStack(Item.ingotIron));

        GameRegistry.addRecipe(hedgeStack, "ll", "ll", 'l', leavesStack);
        GameRegistry.addShapelessRecipe(new ItemStack(roseHedge), hedgeStack, new ItemStack(BlockFlower.plantRed));
        GameRegistry.addShapelessRecipe(new ItemStack(daffodilHedge), hedgeStack, new ItemStack(BlockFlower.plantYellow));
    }

    private static void initLanguages() {
        LanguageRegistry.addName(hedge, "Hedge");
        MinecraftForge.setBlockHarvestLevel(hedge, "axe", 0);

        LanguageRegistry.addName(roseHedge, "Flowered Hedge");
        MinecraftForge.setBlockHarvestLevel(roseHedge, "axe", 0);

        LanguageRegistry.addName(daffodilHedge, "Flowered Hedge");
        MinecraftForge.setBlockHarvestLevel(daffodilHedge, "axe", 0);

        LanguageRegistry.addName(riceBlock, "Rice");

        LanguageRegistry.addName(strawberryBlock, "Strawberry");

        LanguageRegistry.addName(stoveBlock, "Stove");

        LanguageRegistry.addName(brewingBarrel, "Barrel");

        //LanguageRegistry.addName(bananaBlock, "Banana Bunch");

        LanguageRegistry.addName(grapeBlock, "Grape Vine");
    }
}
