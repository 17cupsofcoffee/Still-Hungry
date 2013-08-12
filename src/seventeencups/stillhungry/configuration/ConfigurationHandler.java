package seventeencups.stillhungry.configuration;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import seventeencups.stillhungry.lib.BlockIds;
import seventeencups.stillhungry.lib.ItemIds;
import seventeencups.stillhungry.lib.Strings;

import net.minecraftforge.common.Configuration;

/**
* Still-Hungry
*
* ConfigurationHandler
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File configFile) {
        configuration = new Configuration(configFile);

        try {
            configuration.load();

            //BLOCK IDS

            BlockIds.HEDGE = configuration.getBlock(Strings.HEDGE_NAME, BlockIds.HEDGE_DEFAULT).getInt(BlockIds.HEDGE_DEFAULT);
            BlockIds.ROSEHEDGE = configuration.getBlock(Strings.ROSEHEDGE_NAME, BlockIds.ROSEHEDGE_DEFAULT).getInt(BlockIds.ROSEHEDGE_DEFAULT);
            BlockIds.DAFFODILHEDGE = configuration.getBlock(Strings.DAFFODILHEDGE_NAME, BlockIds.DAFFODILHEDGE_DEFAULT).getInt(BlockIds.DAFFODILHEDGE_DEFAULT);

            BlockIds.RICEBLOCK = configuration.getBlock(Strings.RICEBLOCK_NAME, BlockIds.RICEBLOCK_DEFAULT).getInt(BlockIds.RICEBLOCK_DEFAULT);
            BlockIds.STRAWBERRYBLOCK = configuration.getBlock(Strings.STRAWBERRYBLOCK_NAME, BlockIds.STRAWBERRYBLOCK_DEFAULT).getInt(BlockIds.STRAWBERRYBLOCK_DEFAULT);

            BlockIds.STOVEBLOCK = configuration.getBlock(Strings.STOVEBLOCK_NAME, BlockIds.STOVEBLOCK_DEFAULT).getInt(BlockIds.STOVEBLOCK_DEFAULT);
            BlockIds.STOVEBLOCKBURNING = configuration.getBlock(Strings.STOVEBLOCKBURNING_NAME, BlockIds.STOVEBLOCKBURNING_DEFAULT).getInt(BlockIds.STOVEBLOCKBURNING_DEFAULT);

            BlockIds.BREWINGBARREL = configuration.getBlock(Strings.BREWINGBARREL_NAME, BlockIds.BREWINGBARREL_DEFAULT).getInt(BlockIds.BREWINGBARREL_DEFAULT);

            BlockIds.BANANABLOCK = configuration.getBlock(Strings.BANANABLOCK_NAME, BlockIds.BANANABLOCK_DEFAULT).getInt(BlockIds.BANANABLOCK_DEFAULT);

            BlockIds.GRAPEBLOCK = configuration.getBlock(Strings.GRAPEBLOCK_NAME, BlockIds.GRAPEBLOCK_DEFAULT).getInt(BlockIds.GRAPEBLOCK_DEFAULT);

            //ITEM IDS

            ItemIds.APPLEPIE = configuration.getItem(Strings.APPLEPIE_NAME, ItemIds.APPLEPIE_DEFAULT).getInt(ItemIds.APPLEPIE_DEFAULT);
            ItemIds.BACON = configuration.getItem(Strings.BACON_NAME, ItemIds.BACON_DEFAULT).getInt(ItemIds.BACON_DEFAULT);
            ItemIds.BANANA = configuration.getItem(Strings.BANANA_NAME, ItemIds.BANANA_DEFAULT).getInt(ItemIds.BANANA_DEFAULT);
            ItemIds.BANANABREAD = configuration.getItem(Strings.BANANABREAD_NAME, ItemIds.BANANABREAD_DEFAULT).getInt(ItemIds.BANANABREAD_DEFAULT);
            ItemIds.CHEESE = configuration.getItem(Strings.CHEESE_NAME, ItemIds.CHEESE_DEFAULT).getInt(ItemIds.CHEESE_DEFAULT);
            ItemIds.CHEESEBURGER = configuration.getItem(Strings.CHEESEBURGER_NAME, ItemIds.CHEESEBURGER_DEFAULT).getInt(ItemIds.CHEESEBURGER_DEFAULT);
            ItemIds.BEEFBURGER = configuration.getItem(Strings.BEEFBURGER_NAME, ItemIds.BEEFBURGER_DEFAULT).getInt(ItemIds.BEEFBURGER_DEFAULT);
            ItemIds.BOTTLE = configuration.getItem(Strings.BOTTLE_NAME, ItemIds.BOTTLE_DEFAULT).getInt(ItemIds.BOTTLE_DEFAULT);
            ItemIds.BOTTLEWINE = configuration.getItem(Strings.BOTTLEWINE_NAME, ItemIds.BOTTLEWINE_DEFAULT).getInt(ItemIds.BOTTLEWINE_DEFAULT);
            ItemIds.BOTTLECIDER = configuration.getItem(Strings.BOTTLECIDER_NAME, ItemIds.BOTTLECIDER_DEFAULT).getInt(ItemIds.BOTTLECIDER_DEFAULT);
            ItemIds.BOXLUNCH = configuration.getItem(Strings.BOXLUNCH_NAME, ItemIds.BOXLUNCH_DEFAULT).getInt(ItemIds.BOXLUNCH_DEFAULT);
            ItemIds.BUTTER = configuration.getItem(Strings.BUTTER_NAME, ItemIds.BUTTER_DEFAULT).getInt(ItemIds.BUTTER_DEFAULT);
            ItemIds.CHICKENBURGER = configuration.getItem(Strings.CHICKENBURGER_NAME, ItemIds.CHICKENBURGER_DEFAULT).getInt(ItemIds.CHICKENBURGER_DEFAULT);
            ItemIds.CHOCOLATE = configuration.getItem(Strings.CHOCOLATE_NAME, ItemIds.CHOCOLATE_DEFAULT).getInt(ItemIds.CHOCOLATE_DEFAULT);
            ItemIds.EYECANDY = configuration.getItem(Strings.EYECANDY_NAME, ItemIds.EYECANDY_DEFAULT).getInt(ItemIds.EYECANDY_DEFAULT);
            ItemIds.FLOUR = configuration.getItem(Strings.FLOUR_NAME, ItemIds.FLOUR_DEFAULT).getInt(ItemIds.FLOUR_DEFAULT);
            ItemIds.FRENCHTOAST = configuration.getItem(Strings.FRENCHTOAST_NAME, ItemIds.FRENCHTOAST_DEFAULT).getInt(ItemIds.FRENCHTOAST_DEFAULT);
            ItemIds.FRIEDEGG = configuration.getItem(Strings.FRIEDEGG_NAME, ItemIds.FRIEDEGG_DEFAULT).getInt(ItemIds.FRIEDEGG_DEFAULT);
            ItemIds.FRUITSALAD = configuration.getItem(Strings.FRUITSALAD_NAME, ItemIds.FRUITSALAD_DEFAULT).getInt(ItemIds.FRUITSALAD_DEFAULT);
            ItemIds.FRYINGPAN = configuration.getItem(Strings.FRYINGPAN_NAME, ItemIds.FRYINGPAN_DEFAULT).getInt(ItemIds.FRYINGPAN_DEFAULT);
            ItemIds.GRAPES = configuration.getItem(Strings.GRAPES_NAME, ItemIds.GRAPES_DEFAULT).getInt(ItemIds.GRAPES_DEFAULT);
            ItemIds.GRAPESEED = configuration.getItem(Strings.GRAPESEED_NAME, ItemIds.GRAPESEED_DEFAULT).getInt(ItemIds.GRAPESEED_DEFAULT);
            ItemIds.JAMJAR = configuration.getItem(Strings.JAMJAR_NAME, ItemIds.JAMJAR_DEFAULT).getInt(ItemIds.JAMJAR_DEFAULT);
            ItemIds.JAMJARAPPLE = configuration.getItem(Strings.JAMJARAPPLE_NAME, ItemIds.JAMJARAPPLE_DEFAULT).getInt(ItemIds.JAMJARAPPLE_DEFAULT);
            ItemIds.JAMJARMELON = configuration.getItem(Strings.JAMJARMELON_NAME, ItemIds.JAMJARMELON_DEFAULT).getInt(ItemIds.JAMJARMELON_DEFAULT);
            ItemIds.JAMJARSTRAWBERRY = configuration.getItem(Strings.JAMJARSTRAWBERRY_NAME, ItemIds.JAMJARSTRAWBERRY_DEFAULT).getInt(ItemIds.JAMJARSTRAWBERRY_DEFAULT);
            ItemIds.LAMB = configuration.getItem(Strings.LAMB_NAME, ItemIds.LAMB_DEFAULT).getInt(ItemIds.LAMB_DEFAULT);
            ItemIds.LAMBBURGER = configuration.getItem(Strings.LAMBBURGER_NAME, ItemIds.LAMBBURGER_DEFAULT).getInt(ItemIds.LAMBBURGER_DEFAULT);
            ItemIds.LAMBCOOKED = configuration.getItem(Strings.LAMBCOOKED_NAME, ItemIds.LAMBCOOKED_DEFAULT).getInt(ItemIds.LAMBCOOKED_DEFAULT);
            ItemIds.LAMBSTEAK = configuration.getItem(Strings.LAMBSTEAK_NAME, ItemIds.LAMBSTEAK_DEFAULT).getInt(ItemIds.LAMBSTEAK_DEFAULT);
            ItemIds.MUFFIN = configuration.getItem(Strings.MUFFIN_NAME, ItemIds.MUFFIN_DEFAULT).getInt(ItemIds.MUFFIN_DEFAULT);
            ItemIds.MUFFINCHOC = configuration.getItem(Strings.MUFFINCHOC_NAME, ItemIds.MUFFINCHOC_DEFAULT).getInt(ItemIds.MUFFINCHOC_DEFAULT);
            ItemIds.MUG = configuration.getItem(Strings.MUG_NAME, ItemIds.MUG_DEFAULT).getInt(ItemIds.MUG_DEFAULT);
            ItemIds.MUGCHOC = configuration.getItem(Strings.MUGCHOC_NAME, ItemIds.MUGCHOC_DEFAULT).getInt(ItemIds.MUGCHOC_DEFAULT);
            ItemIds.OIL = configuration.getItem(Strings.OIL_NAME, ItemIds.OIL_DEFAULT).getInt(ItemIds.OIL_DEFAULT);
            ItemIds.OMELETTE = configuration.getItem(Strings.OMELETTE_NAME, ItemIds.OMELETTE_DEFAULT).getInt(ItemIds.OMELETTE_DEFAULT);
            ItemIds.PANCAKES = configuration.getItem(Strings.PANCAKES_NAME, ItemIds.PANCAKES_DEFAULT).getInt(ItemIds.PANCAKES_DEFAULT);
            ItemIds.PANCAKESAPPLE = configuration.getItem(Strings.PANCAKESAPPLE_NAME, ItemIds.PANCAKESAPPLE_DEFAULT).getInt(ItemIds.PANCAKESAPPLE_DEFAULT);
            ItemIds.PORKBURGER = configuration.getItem(Strings.PORKBURGER_NAME, ItemIds.PORKBURGER_DEFAULT).getInt(ItemIds.PORKBURGER_DEFAULT);
            ItemIds.RAMEN = configuration.getItem(Strings.RAMEN_NAME, ItemIds.RAMEN_DEFAULT).getInt(ItemIds.RAMEN_DEFAULT);
            ItemIds.RICE = configuration.getItem(Strings.RICE_NAME, ItemIds.RICE_DEFAULT).getInt(ItemIds.RICE_DEFAULT);
            ItemIds.RICESEED = configuration.getItem(Strings.RICESEED_NAME, ItemIds.RICESEED_DEFAULT).getInt(ItemIds.RICESEED_DEFAULT);
            ItemIds.SANDWICHAPPLE = configuration.getItem(Strings.SANDWICHAPPLE_NAME, ItemIds.SANDWICHAPPLE_DEFAULT).getInt(ItemIds.SANDWICHAPPLE_DEFAULT);
            ItemIds.SANDWICHMELON = configuration.getItem(Strings.SANDWICHMELON_NAME, ItemIds.SANDWICHMELON_DEFAULT).getInt(ItemIds.SANDWICHMELON_DEFAULT);
            ItemIds.SANDWICHSTRAWBERRY = configuration.getItem(Strings.SANDWICHSTRAWBERRY_NAME, ItemIds.SANDWICHSTRAWBERRY_DEFAULT).getInt(ItemIds.SANDWICHSTRAWBERRY_DEFAULT);
            ItemIds.SCRAMBLEDEGG = configuration.getItem(Strings.SCRAMBLEDEGG_NAME, ItemIds.SCRAMBLEDEGG_DEFAULT).getInt(ItemIds.SCRAMBLEDEGG_DEFAULT);
            ItemIds.SPIDERLOLLIPOP = configuration.getItem(Strings.SPIDERLOLLIPOP_NAME, ItemIds.SPIDERLOLLIPOP_DEFAULT).getInt(ItemIds.SPIDERLOLLIPOP_DEFAULT);
            ItemIds.SQUID = configuration.getItem(Strings.SQUID_NAME, ItemIds.SQUID_DEFAULT).getInt(ItemIds.SQUID_DEFAULT);
            ItemIds.SQUIDCOOKED = configuration.getItem(Strings.SQUIDCOOKED_NAME, ItemIds.SQUIDCOOKED_DEFAULT).getInt(ItemIds.SQUIDCOOKED_DEFAULT);
            ItemIds.STRAWBERRY = configuration.getItem(Strings.STRAWBERRY_NAME, ItemIds.STRAWBERRY_DEFAULT).getInt(ItemIds.STRAWBERRY_DEFAULT);
            ItemIds.STRAWBERRYSEED = configuration.getItem(Strings.STRAWBERRYSEED_NAME, ItemIds.STRAWBERRYSEED_DEFAULT).getInt(ItemIds.STRAWBERRYSEED_DEFAULT);
            ItemIds.SUSHI = configuration.getItem(Strings.SUSHI_NAME, ItemIds.SUSHI_DEFAULT).getInt(ItemIds.SUSHI_DEFAULT);
            ItemIds.TACO = configuration.getItem(Strings.TACO_NAME, ItemIds.TACO_DEFAULT).getInt(ItemIds.TACO_DEFAULT);
            ItemIds.TACOSHELL = configuration.getItem(Strings.TACOSHELL_NAME, ItemIds.TACOSHELL_DEFAULT).getInt(ItemIds.TACOSHELL_DEFAULT);
            ItemIds.ZOMBIEBURGER = configuration.getItem(Strings.ZOMBIEBURGER_NAME, ItemIds.ZOMBIEBURGER_DEFAULT).getInt(ItemIds.ZOMBIEBURGER_DEFAULT);
            ItemIds.SANDWICHCHEESE = configuration.getItem(Strings.SANDWICHCHEESE_NAME, ItemIds.SANDWICHCHEESE_DEFAULT).getInt(ItemIds.SANDWICHCHEESE_DEFAULT);;
            ItemIds.MACANDCHEESE = configuration.getItem(Strings.MACANDCHEESE_NAME, ItemIds.MACANDCHEESE_DEFAULT).getInt(ItemIds.MACANDCHEESE_DEFAULT);
            ItemIds.JAMJARGRAPE = configuration.getItem(Strings.JAMJARGRAPE_NAME, ItemIds.JAMJARGRAPE_DEFAULT).getInt(ItemIds.JAMJARGRAPE_DEFAULT);
            ItemIds.SANDWICHGRAPE = configuration.getItem(Strings.SANDWICHGRAPE_NAME, ItemIds.SANDWICHGRAPE_DEFAULT).getInt(ItemIds.SANDWICHGRAPE_DEFAULT);
            ItemIds.FRENCHFRIES = configuration.getItem(Strings.FRENCHFRIES_NAME, ItemIds.FRENCHFRIES_DEFAULT).getInt(ItemIds.FRENCHFRIES_DEFAULT);
            ItemIds.FISHBURGER = configuration.getItem(Strings.FISHBURGER_NAME, ItemIds.FISHBURGER_DEFAULT).getInt(ItemIds.FISHBURGER_DEFAULT);
            ItemIds.POTATOCAKE = configuration.getItem(Strings.POTATOCAKE_NAME, ItemIds.POTATOCAKE_DEFAULT).getInt(ItemIds.POTATOCAKE_DEFAULT);
            ItemIds.LUNCHBOX = configuration.getItem(Strings.LUNCHBOX_NAME, ItemIds.LUNCHBOX_DEFAULT).getInt(ItemIds.LUNCHBOX_DEFAULT);


        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, "Still Hungry has had a problem loading its configuration");
        } finally {
            configuration.save();
        }
    }

    public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }
}
