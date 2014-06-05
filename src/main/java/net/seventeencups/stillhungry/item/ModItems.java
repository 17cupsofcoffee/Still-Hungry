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

    public static Item lunchbox;
    public static Item fryingPan;
    public static Item oil;
    public static Item flour;

    public static Item strawberrySeed;
    public static Item riceSeed;
    public static Item grapeSeed;
    public static Item strawberry;
    public static Item rice;
    public static Item grapes;

    public static Item squid;
    public static Item squidCooked;
    public static Item lamb;
    public static Item lambCooked;

    public static Item zombieBurger;
    public static Item porkBurger;
    public static Item beefBurger;
    public static Item chickenBurger;
    public static Item lambBurger;
    public static Item cheeseBurger;
    public static Item fishBurger;

    public static Item chocolate;
    public static Item muffin;
    public static Item muffinChoc;
    public static Item mug;
    public static Item mugChoc;

    public static Item applePie;
    public static Item omelette;
    public static Item bacon;
    public static Item sushi;

    public static Item jamJar;
    public static Item jamJarApple;
    public static Item jamJarMelon;
    public static Item jamJarStrawberry;
    public static Item jamJarGrape;

    public static Item sandwichApple;
    public static Item sandwichMelon;
    public static Item sandwichStrawberry;
    public static Item sandwichGrape;
    public static Item sandwichCheese;

    public static Item pancakes;
    public static Item pancakesApple;

    public static Item frenchToast;
    public static Item boxLunch;
    public static Item fruitSalad;
    public static Item friedEgg;
    public static Item scrambledEgg;
    public static Item tacoShell;
    public static Item taco;

    public static Item lambSteak;
    public static Item bucketCheese;
    public static Item cheese;
    public static Item macAndCheese;
    public static Item ramen;

    public static Item butter;
    public static Item frenchFries;
    public static Item potatoCake;

    public static Item bottle;
    public static Item bottleWine;
    public static Item bottleCider;

    public static Item eyeCandy;
    public static Item spiderLollipop;
    
    public static void init() {

        lunchbox = new ItemLunchbox()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.LUNCHBOX_NAME)
                .setUnlocalizedName("lunchbox");

        fryingPan = new ItemFryingPan()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.FRYINGPAN_NAME)
                .setUnlocalizedName("fryingPan")
                .setMaxDamage(250);

        oil = new ItemSH()
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.OIL_NAME)
                .setUnlocalizedName("oil");

        flour = new ItemSH()
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.FLOUR_NAME)
                .setUnlocalizedName("flour");



        strawberrySeed = new ItemSeedsSH(ModBlocks.strawberryBlock, Blocks.farmland)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.STRAWBERRYSEED_NAME)
                .setUnlocalizedName("strawberrySeed");

        riceSeed = new ItemSeedsSH(ModBlocks.riceBlock, Blocks.farmland)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.RICESEED_NAME)
                .setUnlocalizedName("riceSeed");

        grapeSeed = new ItemSeedsSH(ModBlocks.grapeBlock, Blocks.farmland)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.GRAPESEED_NAME)
                .setUnlocalizedName("grapeSeed");

        strawberry = new ItemFoodSH(3, 0.4f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.STRAWBERRY_NAME)
                .setUnlocalizedName("strawberry");

        rice = new ItemSH()
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.RICE_NAME)
                .setUnlocalizedName("rice");

        grapes = new ItemFoodSH(3, 0.8F, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.GRAPES_NAME)
                .setUnlocalizedName("grapes");



        squid = new ItemFoodSH(2, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SQUID_NAME)
                .setUnlocalizedName("squid");

        squidCooked = new ItemFoodSH(5, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SQUIDCOOKED_NAME)
                .setUnlocalizedName("squidCooked");

        lamb = new ItemFoodSH(3, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.LAMB_NAME)
                .setUnlocalizedName("lamb");

        lambCooked = new ItemFoodSH(8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.LAMBCOOKED_NAME)
                .setUnlocalizedName("lambCooked");



        zombieBurger = new ItemFoodSH(14, 1f, false)
                .setPotionEffect(Potion.hunger.id, 15, 0, 0.4f)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.ZOMBIEBURGER_NAME)
                .setUnlocalizedName("zombieBurger");
        
        porkBurger = new ItemFoodSH(18, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.PORKBURGER_NAME)
                .setUnlocalizedName("porkBurger");
        
        beefBurger = new ItemFoodSH(18, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BEEFBURGER_NAME)
                .setUnlocalizedName("beefBurger");
        
        chickenBurger = new ItemFoodSH(16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.CHICKENBURGER_NAME)
                .setUnlocalizedName("chickenBurger");
        
        lambBurger = new ItemFoodSH(18, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.LAMBBURGER_NAME)
                .setUnlocalizedName("lambBurger");

        cheeseBurger = new ItemFoodSH(20, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.CHEESEBURGER_NAME)
                .setUnlocalizedName("cheeseBurger");

        fishBurger = new ItemFoodSH(18, 0.9f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.FISHBURGER_NAME)
                .setUnlocalizedName("fishBurger");



        chocolate = new ItemFoodSH(4, 0.7f, false)
                .setMaxStackSize(16)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.CHOCOLATE_NAME)
                .setUnlocalizedName("chocolate");

        muffin = new ItemFoodSH(4, 0.7f, false)
                .setMaxStackSize(16)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.MUFFIN_NAME)
                .setUnlocalizedName("muffin");
        
        muffinChoc = new ItemFoodSH(6, 0.8f, false)
                .setMaxStackSize(16)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.MUFFINCHOC_NAME)
                .setUnlocalizedName("muffinChoc");

        mug = new ItemSH()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.MUG_NAME)
                .setUnlocalizedName("mug");
        
        mugChoc = new ItemMugFilled(4, 0.5f, false)
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.MUGCHOC_NAME)
                .setUnlocalizedName("mugChoc")
                .setContainerItem(mug);



        applePie = new ItemFoodSH(8, 0.8f, false)
                .setMaxStackSize(16)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.APPLEPIE_NAME)
                .setUnlocalizedName("applePie");

        omelette = new ItemFoodSH(4, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.OMELETTE_NAME)
                .setUnlocalizedName("omelette");
        
        bacon = new ItemFoodSH(10, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BACON_NAME)
                .setUnlocalizedName("bacon");
        
        sushi = new ItemFoodSH(8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SUSHI_NAME)
                .setUnlocalizedName("sushi");



        jamJar = new ItemSH()
                .setMaxStackSize(16)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.JAMJAR_NAME)
                .setUnlocalizedName("jamJar");
        
        jamJarApple = new ItemSH()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.JAMJARAPPLE_NAME)
                .setUnlocalizedName("jamJarApple")
                .setContainerItem(jamJar);
        
        jamJarMelon = new ItemSH()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.JAMJARMELON_NAME)
                .setUnlocalizedName("jamJarMelon")
                .setContainerItem(jamJar);
        
        jamJarStrawberry = new ItemSH()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.JAMJARSTRAWBERRY_NAME)
                .setUnlocalizedName("jamJarStrawberry")
                .setContainerItem(jamJar);

        jamJarGrape = new ItemSH()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.JAMJARGRAPE_NAME)
                .setUnlocalizedName("jamJarGrape")
                .setContainerItem(jamJar);



        sandwichApple = new ItemFoodSH(16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SANDWICHAPPLE_NAME)
                .setUnlocalizedName("sandwichApple");
        
        sandwichMelon = new ItemFoodSH(16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SANDWICHMELON_NAME)
                .setUnlocalizedName("sandwichMelon");
        
        sandwichStrawberry = new ItemFoodSH(16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SANDWICHSTRAWBERRY_NAME)
                .setUnlocalizedName("sandwichStrawberry");

        sandwichGrape = new ItemFoodSH(16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SANDWICHGRAPE_NAME)
                .setUnlocalizedName("sandwichGrape");

        sandwichCheese = new ItemFoodSH(16, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SANDWICHCHEESE_NAME)
                .setUnlocalizedName("sandwichCheese");



        pancakes = new ItemFoodSH(6, 0.8f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.PANCAKES_NAME)
                .setUnlocalizedName("pancakes");
        
        pancakesApple = new ItemFoodSH(11, 0.8f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.PANCAKESAPPLE_NAME)
                .setUnlocalizedName("pancakesApple");



        frenchToast = new ItemFoodSH(6, 0.8f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.FRENCHTOAST_NAME)
                .setUnlocalizedName("frenchToast");

        boxLunch = new ItemFoodSH(10, 1f, false)
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BOXLUNCH_NAME)
                .setUnlocalizedName("boxLunch");
        
        fruitSalad = new ItemFoodSH(13, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.FRUITSALAD_NAME)
                .setContainerItem(Items.bowl)
                .setUnlocalizedName("fruitSalad");

        friedEgg = new ItemFoodSH(4, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.FRIEDEGG_NAME)
                .setUnlocalizedName("friedEgg");
        
        scrambledEgg = new ItemFoodSH(8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SCRAMBLEDEGG_NAME)
                .setUnlocalizedName("scrambledEgg");

        tacoShell = new ItemFoodSH(6, 0.5f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.TACOSHELL_NAME)
                .setUnlocalizedName("tacoShell");
        
        taco = new ItemFoodSH(14, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.TACO_NAME)
                .setUnlocalizedName("taco");

        lambSteak = new ItemFoodSH(10, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.LAMBSTEAK_NAME)
                .setUnlocalizedName("lambSteak");

        bucketCheese = new ItemSH()
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BUCKETCHEESE_NAME)
                .setContainerItem(Items.bucket)
                .setUnlocalizedName("bucketCheese");

        cheese = new ItemFoodSH(3, 0.8F, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.CHEESE_NAME)
                .setUnlocalizedName("cheese");
        
        macAndCheese = new ItemFoodSH(17, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.MACANDCHEESE_NAME)
                .setContainerItem(Items.bowl)
                .setUnlocalizedName("macAndCheese");

        ramen = new ItemFoodSH(18, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.RAMEN_NAME)
                .setUnlocalizedName("ramen");
        
        butter = new ItemSH()
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BUTTER_NAME)
                .setUnlocalizedName("butter");
        
        frenchFries = new ItemFoodSH(6, 0.5f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.FRENCHFRIES_NAME)
                .setUnlocalizedName("frenchFries");
        
        potatoCake = new ItemFoodSH(8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.POTATOCAKE_NAME)
                .setUnlocalizedName("potatoCake");



        bottle = new ItemSH()
                .setMaxStackSize(16)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BOTTLE_NAME)
                .setUnlocalizedName("bottle");

        bottleWine = new ItemBottleFilled(1, 0.4F, false)
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BOTTLEWINE_NAME)
                .setUnlocalizedName("bottleWine")
                .setContainerItem(bottle);

        bottleCider = new ItemBottleFilled(1, 0.4F, false)
                .setMaxStackSize(1)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.BOTTLECIDER_NAME)
                .setUnlocalizedName("bottleCider")
                .setContainerItem(bottle);



        eyeCandy = new ItemEyeCandy(0, 0.8f, false)
                .setAlwaysEdible()
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.EYECANDY_NAME)
                .setUnlocalizedName("eyeCandy");

        spiderLollipop = new ItemSpiderLollipop(0, 0.8f, false)
                .setAlwaysEdible()
                .setMaxStackSize(64)
                .setCreativeTab(StillHungry.tabStillHungry)
                .setTextureName(StillHungry.modid + ":" + Strings.SPIDERLOLLIPOP_NAME)
                .setUnlocalizedName("spiderLollipop");

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
