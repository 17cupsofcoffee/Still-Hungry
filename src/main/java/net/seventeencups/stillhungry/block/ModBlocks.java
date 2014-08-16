package net.seventeencups.stillhungry.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.seventeencups.stillhungry.StillHungry;
import net.seventeencups.stillhungry.reference.Strings;

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

    public static final BlockHedge hedge                = new BlockHedge(Strings.HEDGE_NAME);
    public static final BlockHedge roseHedge            = new BlockHedge(Strings.ROSEHEDGE_NAME);
    public static final BlockHedge daffodilHedge        = new BlockHedge(Strings.DAFFODILHEDGE_NAME);
    public static final BlockRice riceBlock             = new BlockRice();
    public static final BlockStrawberry strawberryBlock = new BlockStrawberry();
    public static final BlockGrape grapeBlock           = new BlockGrape();
    public static final BlockStove stoveBlock           = new BlockStove(false);
    public static final BlockStove stoveBlockBurning    = (BlockStove) new BlockStove(true).setLightLevel(0.875F).setCreativeTab(null);
    public static final BlockBarrel brewingBarrel       = new BlockBarrel();


    public static void init() {
        GameRegistry.registerBlock(hedge, Strings.HEDGE_NAME);
        GameRegistry.registerBlock(roseHedge, Strings.ROSEHEDGE_NAME);
        GameRegistry.registerBlock(daffodilHedge, Strings.DAFFODILHEDGE_NAME);

        GameRegistry.registerBlock(riceBlock, Strings.RICEBLOCK_NAME);
        GameRegistry.registerBlock(strawberryBlock, Strings.STRAWBERRYBLOCK_NAME);

        GameRegistry.registerBlock(stoveBlock, Strings.STOVEBLOCK_NAME);
        GameRegistry.registerBlock(stoveBlockBurning, Strings.STOVEBLOCKBURNING_NAME);

        GameRegistry.registerBlock(brewingBarrel, Strings.BREWINGBARREL_NAME);

        GameRegistry.registerBlock(grapeBlock, Strings.GRAPEBLOCK_NAME);

        initBlockRecipes();
    }

    private static void initBlockRecipes() {
        ItemStack hedgeStack = new ItemStack(hedge);
        ItemStack leavesStack = new ItemStack(Blocks.leaves, 1, -1);

        GameRegistry.addRecipe(new ItemStack(stoveBlock), "iii", "s s", "sss",
                'i', new ItemStack(Items.iron_ingot), 's', new ItemStack(Blocks.stone));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(brewingBarrel), "www", "iii", "www",
                'w', "plankWood", 'i', new ItemStack(Items.iron_ingot)));

        GameRegistry.addRecipe(hedgeStack, "ll", "ll", 'l', leavesStack);
        GameRegistry.addShapelessRecipe(new ItemStack(roseHedge), hedgeStack, new ItemStack(Blocks.red_flower));
        GameRegistry.addShapelessRecipe(new ItemStack(daffodilHedge), hedgeStack, new ItemStack(Blocks.yellow_flower));
    }
}
