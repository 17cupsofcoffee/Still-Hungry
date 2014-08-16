package net.seventeencups.stillhungry.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.seventeencups.stillhungry.StillHungry;
import net.seventeencups.stillhungry.block.ModBlocks;
import net.seventeencups.stillhungry.reference.Strings;

/**
* Still-Hungry
*
* ModItems
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class ModItems {

    public static final ItemSH lunchbox                 = new ItemLunchbox();
    public static final ItemSH fryingPan                = new ItemFryingPan();
    public static final ItemSH oil                      = new ItemSH(Strings.OIL_NAME);
    public static final ItemSH flour                    = new ItemSH(Strings.FLOUR_NAME);

    public static final ItemSeedsSH strawberrySeed      = new ItemSeedsSH(Strings.STRAWBERRYSEED_NAME, ModBlocks.strawberryBlock, Blocks.farmland);
    public static final ItemSeedsSH riceSeed            = new ItemSeedsSH(Strings.RICESEED_NAME, ModBlocks.riceBlock, Blocks.farmland);
    public static final ItemSeedsSH grapeSeed           = new ItemSeedsSH(Strings.GRAPESEED_NAME, ModBlocks.grapeBlock, Blocks.farmland);
    public static final ItemFoodSH strawberry           = new ItemFoodSH(Strings.STRAWBERRY_NAME, 3, 0.4f, false);
    public static final ItemSH rice                     = new ItemSH(Strings.RICE_NAME);
    public static final ItemFoodSH grapes               = new ItemFoodSH(Strings.GRAPES_NAME, 3, 0.8F, false);

    public static final ItemFoodSH squid                = new ItemFoodSH(Strings.SQUID_NAME, 2, 1f, false);
    public static final ItemFoodSH squidCooked          = new ItemFoodSH(Strings.SQUIDCOOKED_NAME, 5, 1f, false);
    public static final ItemFoodSH lamb                 = new ItemFoodSH(Strings.LAMB_NAME, 3, 1f, false);
    public static final ItemFoodSH lambCooked           = new ItemFoodSH(Strings.LAMBCOOKED_NAME, 8, 1f, false);

    public static final ItemFoodSH zombieBurger         = (ItemFoodSH) new ItemFoodSH(Strings.ZOMBIEBURGER_NAME, 14, 1f, false)
                                                            .setPotionEffect(Potion.hunger.id, 15, 0, 0.4f);

    public static final ItemFoodSH porkBurger           = new ItemFoodSH(Strings.PORKBURGER_NAME, 18, 1f, false);
    public static final ItemFoodSH beefBurger           = new ItemFoodSH(Strings.BEEFBURGER_NAME, 18, 1f, false);
    public static final ItemFoodSH chickenBurger        = new ItemFoodSH(Strings.CHICKENBURGER_NAME, 16, 1f, false);
    public static final ItemFoodSH lambBurger           = new ItemFoodSH(Strings.LAMBBURGER_NAME, 18, 1f, false);
    public static final ItemFoodSH cheeseBurger         = new ItemFoodSH(Strings.CHEESEBURGER_NAME, 20, 1F, false);
    public static final ItemFoodSH fishBurger           = new ItemFoodSH(Strings.FISHBURGER_NAME, 18, 0.9f, false);

    public static final ItemFoodSH chocolate            = new ItemFoodSH(Strings.CHOCOLATE_NAME, 4, 0.7f, false).setMaxStackSize(16);
    public static final ItemFoodSH muffin               = new ItemFoodSH(Strings.MUFFIN_NAME, 4, 0.7f, false).setMaxStackSize(16);
    public static final ItemFoodSH muffinChoc           = new ItemFoodSH(Strings.MUFFINCHOC_NAME, 6, 0.8f, false).setMaxStackSize(16);
    public static final ItemSH mug                      = new ItemSH(Strings.MUG_NAME).setMaxStackSize(1);
    public static final ItemMugFilled mugChoc           = new ItemMugFilled(Strings.MUGCHOC_NAME, 4, 0.5f, false);

    public static final ItemFoodSH applePie             = new ItemFoodSH(Strings.APPLEPIE_NAME, 8, 0.8f, false).setMaxStackSize(16);
    public static final ItemFoodSH omelette             = new ItemFoodSH(Strings.OMELETTE_NAME, 4, 1f, false);
    public static final ItemFoodSH bacon                = new ItemFoodSH(Strings.BACON_NAME, 10, 1f, false);
    public static final ItemFoodSH sushi                = new ItemFoodSH(Strings.SUSHI_NAME, 8, 1f, false);

    public static final ItemSH jamJar                   = new ItemSH(Strings.JAMJAR_NAME).setMaxStackSize(16);
    public static final ItemSH jamJarApple              = (ItemSH) new ItemSH(Strings.JAMJARAPPLE_NAME).setContainerItem(jamJar).setMaxStackSize(1);
    public static final ItemSH jamJarMelon              = (ItemSH) new ItemSH(Strings.JAMJARMELON_NAME).setContainerItem(jamJar).setMaxStackSize(1);
    public static final ItemSH jamJarStrawberry         = (ItemSH) new ItemSH(Strings.JAMJARSTRAWBERRY_NAME).setContainerItem(jamJar).setMaxStackSize(1);
    public static final ItemSH jamJarGrape              = (ItemSH) new ItemSH(Strings.JAMJARGRAPE_NAME).setContainerItem(jamJar).setMaxStackSize(1);

    public static final ItemFoodSH sandwichApple        = new ItemFoodSH(Strings.SANDWICHAPPLE_NAME, 16, 1f, false);
    public static final ItemFoodSH sandwichMelon        = new ItemFoodSH(Strings.SANDWICHMELON_NAME, 16, 1f, false);
    public static final ItemFoodSH sandwichStrawberry   = new ItemFoodSH(Strings.SANDWICHSTRAWBERRY_NAME, 16, 1f, false);
    public static final ItemFoodSH sandwichGrape        = new ItemFoodSH(Strings.SANDWICHGRAPE_NAME, 16, 1f, false);
    public static final ItemFoodSH sandwichCheese       = new ItemFoodSH(Strings.SANDWICHCHEESE_NAME, 16, 1f, false);

    public static final ItemFoodSH pancakes             = new ItemFoodSH(Strings.PANCAKES_NAME, 6, 0.8f, false);
    public static final ItemFoodSH pancakesApple        = new ItemFoodSH(Strings.PANCAKESAPPLE_NAME, 11, 0.8f, false);

    public static final ItemFoodSH frenchToast          = new ItemFoodSH(Strings.FRENCHTOAST_NAME, 6, 0.8f, false);
    public static final ItemFoodSH boxLunch             = new ItemFoodSH(Strings.BOXLUNCH_NAME, 10, 1f, false).setMaxStackSize(1);
    public static final ItemFoodSH fruitSalad           = (ItemFoodSH) new ItemFoodSH(Strings.FRUITSALAD_NAME, 13, 1f, false).setContainerItem(Items.bowl).setMaxStackSize(1);
    public static final ItemFoodSH friedEgg             = new ItemFoodSH(Strings.FRIEDEGG_NAME, 4, 1f, false);
    public static final ItemFoodSH scrambledEgg         = new ItemFoodSH(Strings.SCRAMBLEDEGG_NAME, 8, 1f, false);
    public static final ItemFoodSH tacoShell            = new ItemFoodSH(Strings.TACOSHELL_NAME, 6, 0.5f, false);
    public static final ItemFoodSH taco                 = new ItemFoodSH(Strings.TACO_NAME, 14, 1f, false);

    public static final ItemFoodSH lambSteak            = new ItemFoodSH(Strings.LAMBSTEAK_NAME, 10, 1f, false);
    public static final ItemSH bucketCheese             = (ItemSH) new ItemSH(Strings.BUCKETCHEESE_NAME).setContainerItem(Items.bucket).setMaxStackSize(1);
    public static final ItemFoodSH cheese               = new ItemFoodSH(Strings.CHEESE_NAME, 3, 0.8F, false);
    public static final ItemFoodSH macAndCheese         = (ItemFoodSH) new ItemFoodSH(Strings.MACANDCHEESE_NAME, 17, 1F, false).setContainerItem(Items.bowl).setMaxStackSize(1);
    public static final ItemFoodSH ramen                = new ItemFoodSH(Strings.RAMEN_NAME, 18, 1F, false);

    public static final ItemSH butter                   = new ItemSH(Strings.BUTTER_NAME);
    public static final ItemFoodSH frenchFries          = new ItemFoodSH(Strings.FRENCHFRIES_NAME, 6, 0.5f, false);
    public static final ItemFoodSH potatoCake           = new ItemFoodSH(Strings.POTATOCAKE_NAME, 8, 1f, false);

    public static final ItemSH bottle                   = new ItemSH(Strings.BOTTLE_NAME).setMaxStackSize(16);
    public static final ItemBottleFilled bottleWine     = new ItemBottleFilled(Strings.BOTTLEWINE_NAME, 1, 0.4F, false);
    public static final ItemBottleFilled bottleCider    = new ItemBottleFilled(Strings.BOTTLECIDER_NAME,1, 0.4F, false);

    public static final ItemEyeCandy eyeCandy           = new ItemEyeCandy(Strings.EYECANDY_NAME, 0, 0.8f, false);
    public static final ItemSpiderLollipop spiderLollipop = new ItemSpiderLollipop(Strings.SPIDERLOLLIPOP_NAME, 0, 0.8f, false);
    
    public static void init() {

        GameRegistry.registerItem(lunchbox, "StillHungry_lunchbox");
        GameRegistry.registerItem(fryingPan, "StillHungry_fryingPan");
        GameRegistry.registerItem(oil, "StillHungry_oil");
        GameRegistry.registerItem(flour, "StillHungry_flour");

        GameRegistry.registerItem(strawberrySeed, "StillHungry_strawberrySeed");
        GameRegistry.registerItem(grapeSeed, "StillHungry_grapeSeed");
        GameRegistry.registerItem(riceSeed, "StillHungry_riceSeed");
        GameRegistry.registerItem(strawberry, "StillHungry_strawberry");
        GameRegistry.registerItem(grapes, "StillHungry_grapes");
        GameRegistry.registerItem(rice, "StillHungry_rice");

        GameRegistry.registerItem(zombieBurger, "StillHungry_zombieBurger");
        GameRegistry.registerItem(porkBurger, "StillHungry_porkBurger");
        GameRegistry.registerItem(beefBurger, "StillHungry_beefBurger");
        GameRegistry.registerItem(chickenBurger, "StillHungry_chickenBurger");
        GameRegistry.registerItem(lambBurger, "StillHungry_lambBurger");
        GameRegistry.registerItem(fishBurger, "StillHungry_fishBurger");
        GameRegistry.registerItem(cheeseBurger, "StillHungry_cheeseBurger");

        GameRegistry.registerItem(chocolate, "StillHungry_chocolate");

        GameRegistry.registerItem(muffin, "StillHungry_muffin");
        GameRegistry.registerItem(muffinChoc, "StillHungry_muffinChoc");
        GameRegistry.registerItem(mug, "StillHungry_mug");
        GameRegistry.registerItem(mugChoc, "StillHungry_mugChoc");

        GameRegistry.registerItem(squid, "StillHungry_squid");
        GameRegistry.registerItem(squidCooked, "StillHungry_squidCooked");

        GameRegistry.registerItem(lamb, "StillHungry_lamb");
        GameRegistry.registerItem(lambCooked, "StillHungry_lambCooked");
        GameRegistry.registerItem(lambSteak, "StillHungry_lambSteak");

        GameRegistry.registerItem(applePie, "StillHungry_applePie");

        GameRegistry.registerItem(omelette, "StillHungry_omelette");
        GameRegistry.registerItem(bacon, "StillHungry_bacon");
        GameRegistry.registerItem(sushi, "StillHungry_sushi");


        GameRegistry.registerItem(jamJar, "StillHungry_jamJar");
        GameRegistry.registerItem(jamJarApple, "StillHungry_jamJarApple");
        GameRegistry.registerItem(jamJarMelon, "StillHungry_jamJarMelon");
        GameRegistry.registerItem(jamJarStrawberry, "StillHungry_jamJarStrawberry");
        GameRegistry.registerItem(jamJarGrape, "StillHungry_jamJarGrape");

        GameRegistry.registerItem(sandwichApple, "StillHungry_sandwichApple");
        GameRegistry.registerItem(sandwichMelon, "StillHungry_sandwichMelon");
        GameRegistry.registerItem(sandwichStrawberry, "StillHungry_sandwichStrawberry");
        GameRegistry.registerItem(sandwichCheese, "StillHungry_sandwichCheese");
        GameRegistry.registerItem(sandwichGrape, "StillHungry_sandwichGrape");

        GameRegistry.registerItem(pancakes, "StillHungry_pancakes");
        GameRegistry.registerItem(pancakesApple, "StillHungry_pancakesApple");

        GameRegistry.registerItem(frenchToast, "StillHungry_frenchToast");
        GameRegistry.registerItem(boxLunch, "StillHungry_boxLunch");
        GameRegistry.registerItem(fruitSalad, "StillHungry_fruitSalad");
        GameRegistry.registerItem(friedEgg, "StillHungry_friedEgg");
        GameRegistry.registerItem(scrambledEgg, "StillHungry_scrambledEgg");
        GameRegistry.registerItem(tacoShell, "StillHungry_tacoShell");
        GameRegistry.registerItem(taco, "StillHungry_taco");

        GameRegistry.registerItem(bucketCheese, "StillHungry_bucketCheese");
        GameRegistry.registerItem(cheese, "StillHungry_cheese");
        GameRegistry.registerItem(macAndCheese, "StillHungry_macAndCheese");
        GameRegistry.registerItem(ramen, "StillHungry_ramen");

        GameRegistry.registerItem(butter, "StillHungry_butter");
        GameRegistry.registerItem(frenchFries, "StillHungry_frenchFries");
        GameRegistry.registerItem(potatoCake, "StillHungry_potatoCake");

        GameRegistry.registerItem(bottle, "StillHungry_bottle");
        GameRegistry.registerItem(bottleWine, "StillHungry_bottleWine");
        GameRegistry.registerItem(bottleCider, "StillHungry_bottleCider");

        GameRegistry.registerItem(eyeCandy, "StillHungry_eyeCandy");
        GameRegistry.registerItem(spiderLollipop, "StillHungry_spiderLollipop");

        initItemRecipes();
    }

    private static void initItemRecipes() {
        ItemStack breadStack = new ItemStack(Items.bread);
        ItemStack cocoaStack = new ItemStack(Items.dye, 1, 3);
        ItemStack milkStack = new ItemStack(Items.milk_bucket);
        ItemStack chocStack = new ItemStack(chocolate);
        ItemStack sugarStack = new ItemStack(Items.sugar);
        ItemStack eggStack = new ItemStack(Items.egg);
        ItemStack wheatStack = new ItemStack(Items.wheat);
        ItemStack paperStack = new ItemStack(Items.paper);

        GameRegistry.addRecipe(new ItemStack(zombieBurger), "b", "f", "b",
                'b', breadStack, 'f', new ItemStack(Items.rotten_flesh));
        GameRegistry.addRecipe(new ItemStack(porkBurger), "b", "p", "b",
                'b', breadStack, 'p', new ItemStack(Items.cooked_porkchop));
        GameRegistry.addRecipe(new ItemStack(beefBurger), "b", "m", "b",
                'b', breadStack, 'm', new ItemStack(Items.cooked_beef));
        GameRegistry.addRecipe(new ItemStack(chickenBurger), "b", "c", "b",
                'b', breadStack, 'c', new ItemStack(Items.cooked_chicken));
        GameRegistry.addRecipe(new ItemStack(lambBurger), "b", "l", "b",
                'b', breadStack, 'l', new ItemStack(lambCooked));
        GameRegistry.addRecipe(new ItemStack(fishBurger), "b", "f", "b",
                'b', breadStack, 'f', new ItemStack(Items.cooked_fished));
        GameRegistry.addRecipe(new ItemStack(cheeseBurger), "c", "b",
                'c', new ItemStack(cheese), 'b', new ItemStack(beefBurger));
        
        GameRegistry.addRecipe(new ItemStack(chocolate, 2), "s", "c", "m",
                's', new ItemStack(Items.sugar), 'c', cocoaStack, 'm', milkStack);
        GameRegistry.addRecipe(new ItemStack(muffin, 3), "mmm", "ses", "wpw",
                'm', milkStack, 's', sugarStack, 'e', eggStack,
                'w', wheatStack, 'p', paperStack);
        GameRegistry.addRecipe(new ItemStack(muffinChoc, 3), "mcm", "ses", "wpw",
                'm', milkStack, 's', sugarStack, 'e', eggStack,
                'w', wheatStack, 'p', paperStack, 'c', chocStack);
        GameRegistry.addRecipe(new ItemStack(mug), "c c", " c ",
                'c', new ItemStack(Items.clay_ball));
        GameRegistry.addShapelessRecipe(new ItemStack(flour, 4), wheatStack, wheatStack);
        GameRegistry.addRecipe(new ItemStack(applePie, 2), "fsf", "aaa", "www",
                'f', new ItemStack(flour), 's', sugarStack, 'a', new ItemStack(Items.apple),
                'w', wheatStack);
        GameRegistry.addRecipe(new ItemStack(fryingPan), "iii", "iii", " s ",
                'i', new ItemStack(Items.iron_ingot), 's', new ItemStack(Items.stick));

        GameRegistry.addRecipe(new ItemStack(oil), "r", "b", 'r', new ItemStack(rice), 'b', new ItemStack(Items.glass_bottle));
        GameRegistry.addRecipe(new ItemStack(sushi), "f", "r", 'f', new ItemStack(Items.fish), 'r', new ItemStack(rice));

        GameRegistry.addRecipe(new ItemStack(jamJar, 3), "g g", "ggg", 'g', new ItemStack(Blocks.glass));
        GameRegistry.addRecipe(new ItemStack(jamJarApple), "s", "a", "j", 's', new ItemStack(Items.sugar),
                'a', new ItemStack(Items.apple), 'j', new ItemStack(jamJar));
        GameRegistry.addRecipe(new ItemStack(jamJarMelon), "s", "a", "j", 's', new ItemStack(Items.sugar),
                'a', new ItemStack(Items.melon), 'j', new ItemStack(jamJar));
        GameRegistry.addRecipe(new ItemStack(jamJarStrawberry), "s", "a", "j", 's', new ItemStack(Items.sugar),
                'a', new ItemStack(strawberry), 'j', new ItemStack(jamJar));
        GameRegistry.addRecipe(new ItemStack(jamJarGrape), "s", "a", "j", 's', new ItemStack(Items.sugar),
                'a', new ItemStack(grapes), 'j', new ItemStack(jamJar));

        GameRegistry.addRecipe(new ItemStack(sandwichApple), "b", "a", "b", 'b', new ItemStack(Items.bread),
                'a', new ItemStack(jamJarApple));
        GameRegistry.addRecipe(new ItemStack(sandwichMelon), "b", "a", "b", 'b', new ItemStack(Items.bread),
                'a', new ItemStack(jamJarMelon));
        GameRegistry.addRecipe(new ItemStack(sandwichStrawberry), "b", "a", "b", 'b', new ItemStack(Items.bread),
                'a', new ItemStack(jamJarStrawberry));
        GameRegistry.addRecipe(new ItemStack(sandwichGrape), "b", "a", "b", 'b', new ItemStack(Items.bread),
                'a', new ItemStack(jamJarGrape));
        GameRegistry.addRecipe(new ItemStack(sandwichCheese), "b", "a", "b", 'b', new ItemStack(Items.bread),
                'a', new ItemStack(cheese));

        GameRegistry.addRecipe(new ItemStack(pancakesApple), "a", "p", 'a', new ItemStack(Items.apple),
                'p', new ItemStack(pancakes));

        GameRegistry.addRecipe(new ItemStack(boxLunch), " r ", "sfs", " r ", 'r', new ItemStack(rice),
                's', new ItemStack(Items.stick), 'f', new ItemStack(Items.fish));
        GameRegistry.addRecipe(new ItemStack(fruitSalad), "sma", " b ", 's', new ItemStack(strawberry),
                'm', new ItemStack(Items.melon), 'a', new ItemStack(Items.apple), 'b', new ItemStack(Items.bowl));

        GameRegistry.addRecipe(new ItemStack(eyeCandy, 2), "s", "e", "p", 's', new ItemStack(Items.sugar),
                'e', new ItemStack(Items.spider_eye), 'p', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(spiderLollipop), "c", "s", 'c', new ItemStack(eyeCandy),
                's', new ItemStack(Items.stick));

        GameRegistry.addRecipe(new ItemStack(ramen), "cbc", " f ", " w ", 'c', new ItemStack(Items.carrot), 'b', new ItemStack(Items.cooked_beef),
                'f', new ItemStack(flour), 'w', new ItemStack(Items.water_bucket));

        GameRegistry.addRecipe(new ItemStack(bottle, 3), " g ", "g g", "ggg", 'g', new ItemStack(Blocks.glass));
        
        GameRegistry.addRecipe(new ItemStack(macAndCheese), " c ", "bfm", " u ",
                'c', new ItemStack(cheese), 'b', new ItemStack(butter), 'f', new ItemStack(flour),
                'm', new ItemStack(Items.milk_bucket), 'u', new ItemStack(Items.bowl));
        
        GameRegistry.addRecipe(new ItemStack(lunchbox), "ccc", "i i", "iii",
                'c', new ItemStack(Items.clay_ball), 'i', new ItemStack(Items.iron_ingot));
        
        GameRegistry.addRecipe(new ItemStack(butter), "o", "m", 'o', new ItemStack(oil),
                'm', new ItemStack(Items.milk_bucket));

        GameRegistry.addSmelting(squid, new ItemStack(squidCooked), 0.35f);
        GameRegistry.addSmelting(lamb, new ItemStack(lambCooked), 0.35f);
        GameRegistry.addSmelting(Items.milk_bucket, new ItemStack(bucketCheese), 0.35f);


        GameRegistry.addShapelessRecipe(new ItemStack(strawberrySeed), new ItemStack(strawberry));
        GameRegistry.addShapelessRecipe(new ItemStack(riceSeed), new ItemStack(rice));
        GameRegistry.addShapelessRecipe(new ItemStack(grapeSeed), new ItemStack(grapes));
        GameRegistry.addShapelessRecipe(new ItemStack(cheese), new ItemStack(bucketCheese));
    }
}
