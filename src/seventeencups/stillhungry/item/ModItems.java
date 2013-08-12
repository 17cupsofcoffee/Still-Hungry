package seventeencups.stillhungry.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import seventeencups.stillhungry.lib.BlockIds;
import seventeencups.stillhungry.lib.ItemIds;

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

    public static Item zombieBurger;
    public static Item porkBurger;
    public static Item beefBurger;
    public static Item chickenBurger;
    public static Item lambBurger;
    public static Item chocolate;
    public static Item muffin;
    public static Item muffinChoc;
    public static Item mug;
    public static Item mugChoc;
    public static Item squid;
    public static Item squidCooked;
    public static Item lamb;
    public static Item lambCooked;
    public static Item flour;
    public static Item applePie;
    public static ItemSeeds riceSeed;
    public static Item rice;
    public static Item fryingPan;
    public static Item omelette;
    public static Item oil;
    public static Item bacon;
    public static Item sushi;
    public static ItemSeeds strawberrySeed;
    public static Item strawberry;
    public static Item jamJar;
    public static Item jamJarApple;
    public static Item jamJarMelon;
    public static Item jamJarStrawberry;
    public static Item sandwichApple;
    public static Item sandwichMelon;
    public static Item sandwichStrawberry;
    public static Item pancakes;
    public static Item pancakesApple;
    public static Item frenchToast;
    public static Item boxLunch;
    public static Item fruitSalad;
    public static Item friedEgg;
    public static Item scrambledEgg;
    public static Item tacoShell;
    public static Item taco;
    public static Item eyeCandy;
    public static Item spiderLollipop;
    public static Item lambSteak;
    public static Item cheese;
    public static Item cheeseBurger;
    public static Item sandwichCheese;
    public static Item macAndCheese;
    public static Item ramen;
    public static ItemSeeds grapeSeed;
    public static Item grapes;
    public static Item bottle;
    public static Item bottleWine;
    public static Item bottleCider;
    public static Item butter;
    public static Item jamJarGrape;
    public static Item sandwichGrape;
    public static Item frenchFries;
    public static Item fishBurger;
    public static Item potatoCake;
    public static Item lunchbox;
    
    public static void init() {
        zombieBurger = new ItemFoodSH(ItemIds.ZOMBIEBURGER, 14, 1f, false)
                .setPotionEffect(Potion.hunger.id, 15, 0, 0.4f)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("zombieBurger");
        
        porkBurger = new ItemFoodSH(ItemIds.PORKBURGER, 18, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("porkBurger");
        
        beefBurger = new ItemFoodSH(ItemIds.BEEFBURGER, 18, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("beefBurger");
        
        chickenBurger = new ItemFoodSH(ItemIds.CHICKENBURGER, 16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("chickenBurger");
        
        lambBurger = new ItemFoodSH(ItemIds.LAMBBURGER, 18, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("lambBurger");

        chocolate = new ItemFoodSH(ItemIds.CHOCOLATE, 4, 0.7f, false)
                .setMaxStackSize(16)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("chocolate");

        muffin = new ItemFoodSH(ItemIds.MUFFIN, 4, 0.7f, false)
                .setMaxStackSize(16)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("muffin");
        
        muffinChoc = new ItemFoodSH(ItemIds.MUFFINCHOC, 6, 0.8f, false)
                .setMaxStackSize(16)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("muffinChoc");

        mug = new ItemSH(ItemIds.MUG)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("mug");
        
        mugChoc = new ItemMugFilled(ItemIds.MUGCHOC, 4, 0.5f, false)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("mugChoc")
                .setContainerItem(mug);

        squid = new ItemFoodSH(ItemIds.SQUID, 2, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("squid");
        
        squidCooked = new ItemFoodSH(ItemIds.SQUIDCOOKED, 5, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("squidCooked");

        lamb = new ItemFoodSH(ItemIds.LAMB, 3, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("lamb");
        
        lambCooked = new ItemFoodSH(ItemIds.LAMBCOOKED, 8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("lambCooked");

        flour = new ItemSH(ItemIds.FLOUR)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("flour");
        
        applePie = new ItemFoodSH(ItemIds.APPLEPIE, 8, 0.8f, false)
                .setMaxStackSize(16)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("applePie");

        riceSeed = new ItemSeedsSH(ItemIds.RICESEED, BlockIds.RICEBLOCK, Block.tilledField.blockID)
                .setUnlocalizedName("riceSeed");
        
        rice = new ItemSH(ItemIds.RICE)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("rice");

        fryingPan = new ItemFryingPan(ItemIds.FRYINGPAN)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("fryingPan")
                .setMaxDamage(250);

        omelette = new ItemFoodSH(ItemIds.OMELETTE, 4, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("omelette");
        
        oil = new ItemSH(ItemIds.OIL)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("oil");
        
        bacon = new ItemFoodSH(ItemIds.BACON, 10, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("bacon");
        
        sushi = new ItemFoodSH(ItemIds.SUSHI, 8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("sushi");

        strawberrySeed = new ItemSeedsSH(ItemIds.STRAWBERRYSEED, BlockIds.STRAWBERRYBLOCK, Block.tilledField.blockID)
                .setUnlocalizedName("strawberrySeed");
        
        strawberry = new ItemFoodSH(ItemIds.STRAWBERRY, 3, 0.4f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("strawberry");

        jamJar = new ItemSH(ItemIds.JAMJAR)
                .setMaxStackSize(16)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("jamJar");
        
        jamJarApple = new ItemSH(ItemIds.JAMJARAPPLE)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("jamJarApple")
                .setContainerItem(jamJar);
        
        jamJarMelon = new ItemSH(ItemIds.JAMJARMELON)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("jamJarMelon")
                .setContainerItem(jamJar);
        
        jamJarStrawberry = new ItemSH(ItemIds.JAMJARSTRAWBERRY)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("jamJarStrawberry")
                .setContainerItem(jamJar);

        sandwichApple = new ItemFoodSH(ItemIds.SANDWICHAPPLE, 16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("sandwichApple");
        
        sandwichMelon = new ItemFoodSH(ItemIds.SANDWICHMELON, 16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("sandwichMelon");
        
        sandwichStrawberry = new ItemFoodSH(ItemIds.SANDWICHSTRAWBERRY, 16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("sandwichStrawberry");

        pancakes = new ItemFoodSH(ItemIds.PANCAKES, 6, 0.8f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("pancakes");
        
        pancakesApple = new ItemFoodSH(ItemIds.PANCAKESAPPLE, 11, 0.8f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("pancakesApple");

        frenchToast = new ItemFoodSH(ItemIds.FRENCHTOAST, 6, 0.8f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("frenchToast");

        boxLunch = new ItemFoodSH(ItemIds.BOXLUNCH, 10, 1f, false)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("boxLunch");
        
        fruitSalad = new ItemFoodSH(ItemIds.FRUITSALAD, 13, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("fruitSalad");

        friedEgg = new ItemFoodSH(ItemIds.FRIEDEGG, 4, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("friedEgg");
        
        scrambledEgg = new ItemFoodSH(ItemIds.SCRAMBLEDEGG, 8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("scrambledEgg");

        tacoShell = new ItemFoodSH(ItemIds.TACOSHELL, 6, 0.5f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("tacoShell");
        
        taco = new ItemFoodSH(ItemIds.TACO, 14, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("taco");

        eyeCandy = new ItemEyeCandy(ItemIds.EYECANDY, 0, 0.8f, false)
                .setAlwaysEdible()
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("eyeCandy");
        
        spiderLollipop = new ItemSpiderLollipop(ItemIds.SPIDERLOLLIPOP, 0, 0.8f, false)
                .setAlwaysEdible()
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("spiderLollipop");

        lambSteak = new ItemFoodSH(ItemIds.LAMBSTEAK, 10, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("lambSteak");

        cheese = new ItemFoodSH(ItemIds.CHEESE, 3, 0.8F, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("cheese");
        
        sandwichCheese = new ItemFoodSH(ItemIds.SANDWICHCHEESE, 16, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("sandwichCheese");
        
        cheeseBurger = new ItemFoodSH(ItemIds.CHEESEBURGER, 20, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("cheeseBurger");
        
        macAndCheese = new ItemFoodSH(ItemIds.MACANDCHEESE, 17, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("macAndCheese")
                .setContainerItem(Item.bowlEmpty);

        ramen = new ItemFoodSH(ItemIds.RAMEN, 18, 1F, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("ramen");

        grapeSeed = new ItemSeedsSH(ItemIds.GRAPESEED, BlockIds.GRAPEBLOCK, Block.tilledField.blockID)
                .setUnlocalizedName("grapeSeed");
                
        
        grapes = new ItemFoodSH(ItemIds.GRAPES, 3, 0.8F, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("grapes");

        bottle = new ItemSH(ItemIds.BOTTLE)
                .setMaxStackSize(16)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("bottle");
        
        bottleWine = new ItemBottleFilled(ItemIds.BOTTLEWINE, 1, 0.4F, false)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("bottleWine")
                .setContainerItem(bottle);
        
        bottleCider = new ItemBottleFilled(ItemIds.BOTTLECIDER, 1, 0.4F, false)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("bottleCider")
                .setContainerItem(bottle);
        
        butter = new ItemSH(ItemIds.BUTTER)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("butter");
        
        jamJarGrape = new ItemSH(ItemIds.JAMJARGRAPE)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("jamJarGrape")
                .setContainerItem(jamJar);
        
        sandwichGrape = new ItemFoodSH(ItemIds.SANDWICHGRAPE, 16, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("sandwichGrape");
        
        frenchFries = new ItemFoodSH(ItemIds.FRENCHFRIES, 6, 0.5f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("frenchFries");
        
        fishBurger = new ItemFoodSH(ItemIds.FISHBURGER, 18, 0.9f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("fishBurger");
        
        potatoCake = new ItemFoodSH(ItemIds.POTATOCAKE, 8, 1f, false)
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("potatoCake");
        
        lunchbox = new ItemLunchbox(ItemIds.LUNCHBOX)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("lunchbox");

        initItemRecipes();

        initLanguages();
    }

    private static void initItemRecipes() {
        ItemStack breadStack = new ItemStack(Item.bread);
        ItemStack cocoaStack = new ItemStack(Item.dyePowder, 1, 3);
        ItemStack milkStack = new ItemStack(Item.bucketMilk);
        ItemStack chocStack = new ItemStack(chocolate);
        ItemStack sugarStack = new ItemStack(Item.sugar);
        ItemStack eggStack = new ItemStack(Item.egg);
        ItemStack wheatStack = new ItemStack(Item.wheat);
        ItemStack paperStack = new ItemStack(Item.paper);

        GameRegistry.addRecipe(new ItemStack(zombieBurger), "b", "f", "b",
                'b', breadStack, 'f', new ItemStack(Item.rottenFlesh));
        GameRegistry.addRecipe(new ItemStack(porkBurger), "b", "p", "b",
                'b', breadStack, 'p', new ItemStack(Item.porkCooked));
        GameRegistry.addRecipe(new ItemStack(beefBurger), "b", "m", "b",
                'b', breadStack, 'm', new ItemStack(Item.beefCooked));
        GameRegistry.addRecipe(new ItemStack(chickenBurger), "b", "c", "b",
                'b', breadStack, 'c', new ItemStack(Item.chickenCooked));
        GameRegistry.addRecipe(new ItemStack(lambBurger), "b", "l", "b",
                'b', breadStack, 'l', new ItemStack(lambCooked));
        GameRegistry.addRecipe(new ItemStack(fishBurger), "b", "f", "b",
                'b', breadStack, 'f', new ItemStack(Item.fishCooked));
        GameRegistry.addRecipe(new ItemStack(cheeseBurger), "c", "b",
                'c', new ItemStack(cheese), 'b', new ItemStack(beefBurger));
        
        GameRegistry.addRecipe(new ItemStack(chocolate, 2), "s", "c", "m",
                's', new ItemStack(Item.sugar), 'c', cocoaStack, 'm', milkStack);
        GameRegistry.addRecipe(new ItemStack(muffin, 3), "mmm", "ses", "wpw",
                'm', milkStack, 's', sugarStack, 'e', eggStack,
                'w', wheatStack, 'p', paperStack);
        GameRegistry.addRecipe(new ItemStack(muffinChoc, 3), "mcm", "ses", "wpw",
                'm', milkStack, 's', sugarStack, 'e', eggStack,
                'w', wheatStack, 'p', paperStack, 'c', chocStack);
        GameRegistry.addRecipe(new ItemStack(mug), "c c", " c ",
                'c', new ItemStack(Item.clay));
        GameRegistry.addShapelessRecipe(new ItemStack(flour, 4), wheatStack, wheatStack);
        GameRegistry.addRecipe(new ItemStack(applePie, 2), "fsf", "aaa", "www",
                'f', new ItemStack(flour), 's', sugarStack, 'a', new ItemStack(Item.appleRed),
                'w', wheatStack);
        GameRegistry.addRecipe(new ItemStack(fryingPan), "iii", "iii", " s ",
                'i', new ItemStack(Item.ingotIron), 's', new ItemStack(Item.stick));

        GameRegistry.addRecipe(new ItemStack(oil), "r", "b", 'r', new ItemStack(rice), 'b', new ItemStack(Item.glassBottle));
        GameRegistry.addRecipe(new ItemStack(sushi), "f", "r", 'f', new ItemStack(Item.fishRaw), 'r', new ItemStack(rice));

        GameRegistry.addRecipe(new ItemStack(jamJar, 3), "g g", "ggg", 'g', new ItemStack(Block.glass));
        GameRegistry.addRecipe(new ItemStack(jamJarApple), "s", "a", "j", 's', new ItemStack(Item.sugar),
                'a', new ItemStack(Item.appleRed), 'j', new ItemStack(jamJar));
        GameRegistry.addRecipe(new ItemStack(jamJarMelon), "s", "a", "j", 's', new ItemStack(Item.sugar),
                'a', new ItemStack(Item.melon), 'j', new ItemStack(jamJar));
        GameRegistry.addRecipe(new ItemStack(jamJarStrawberry), "s", "a", "j", 's', new ItemStack(Item.sugar),
                'a', new ItemStack(strawberry), 'j', new ItemStack(jamJar));
        GameRegistry.addRecipe(new ItemStack(jamJarGrape), "s", "a", "j", 's', new ItemStack(Item.sugar),
                'a', new ItemStack(grapes), 'j', new ItemStack(jamJar));

        GameRegistry.addRecipe(new ItemStack(sandwichApple), "b", "a", "b", 'b', new ItemStack(Item.bread),
                'a', new ItemStack(jamJarApple));
        GameRegistry.addRecipe(new ItemStack(sandwichMelon), "b", "a", "b", 'b', new ItemStack(Item.bread),
                'a', new ItemStack(jamJarMelon));
        GameRegistry.addRecipe(new ItemStack(sandwichStrawberry), "b", "a", "b", 'b', new ItemStack(Item.bread),
                'a', new ItemStack(jamJarStrawberry));
        GameRegistry.addRecipe(new ItemStack(sandwichGrape), "b", "a", "b", 'b', new ItemStack(Item.bread),
                'a', new ItemStack(jamJarGrape));
        GameRegistry.addRecipe(new ItemStack(sandwichCheese), "b", "a", "b", 'b', new ItemStack(Item.bread),
                'a', new ItemStack(cheese));

        GameRegistry.addRecipe(new ItemStack(pancakesApple), "a", "p", 'a', new ItemStack(Item.appleRed),
                'p', new ItemStack(pancakes));

        GameRegistry.addRecipe(new ItemStack(boxLunch), " r ", "sfs", " r ", 'r', new ItemStack(rice),
                's', new ItemStack(Item.stick), 'f', new ItemStack(Item.fishRaw));
        GameRegistry.addRecipe(new ItemStack(fruitSalad), "sma", " b ", 's', new ItemStack(strawberry),
                'm', new ItemStack(Item.melon), 'a', new ItemStack(Item.appleRed), 'b', new ItemStack(Item.bowlEmpty));

        GameRegistry.addRecipe(new ItemStack(eyeCandy, 2), "s", "e", "p", 's', new ItemStack(Item.sugar),
                'e', new ItemStack(Item.spiderEye), 'p', new ItemStack(Item.paper));
        GameRegistry.addRecipe(new ItemStack(spiderLollipop), "c", "s", 'c', new ItemStack(eyeCandy),
                's', new ItemStack(Item.stick));

        GameRegistry.addRecipe(new ItemStack(ramen), "cbc", " f ", " w ", 'c', new ItemStack(Item.carrot), 'b', new ItemStack(Item.beefCooked),
                'f', new ItemStack(flour), 'w', new ItemStack(Item.bucketWater));

        GameRegistry.addRecipe(new ItemStack(bottle, 3), " g ", "g g", "ggg", 'g', new ItemStack(Block.glass));
        
        GameRegistry.addRecipe(new ItemStack(macAndCheese), " c ", "bfm", " u ",
                'c', new ItemStack(cheese), 'b', new ItemStack(butter), 'f', new ItemStack(flour),
                'm', new ItemStack(Item.bucketMilk), 'u', new ItemStack(Item.bowlEmpty));
        
        GameRegistry.addRecipe(new ItemStack(lunchbox), "ccc", "i i", "iii",
                'c', new ItemStack(Item.clay), 'i', new ItemStack(Item.ingotIron));
        
        GameRegistry.addRecipe(new ItemStack(butter), "o", "m", 'o', new ItemStack(oil),
                'm', new ItemStack(Item.bucketMilk));

        GameRegistry.addSmelting(squid.itemID, new ItemStack(squidCooked), 0.35f);
        GameRegistry.addSmelting(lamb.itemID, new ItemStack(lambCooked), 0.35f);
        GameRegistry.addSmelting(Item.bucketMilk.itemID, new ItemStack(cheese), 0.35f);


        GameRegistry.addShapelessRecipe(new ItemStack(strawberrySeed), new ItemStack(strawberry));
        GameRegistry.addShapelessRecipe(new ItemStack(riceSeed), new ItemStack(rice));
        GameRegistry.addShapelessRecipe(new ItemStack(grapeSeed), new ItemStack(grapes));
    }

    private static void initLanguages() {
        LanguageRegistry.addName(zombieBurger, "Zombie Burger");
        LanguageRegistry.addName(porkBurger, "Pork Burger");
        LanguageRegistry.addName(beefBurger, "Beef Burger");
        LanguageRegistry.addName(chickenBurger, "Chicken Burger");
        LanguageRegistry.addName(lambBurger, "Lamb Burger");
        LanguageRegistry.addName(chocolate, "Chocolate");
        LanguageRegistry.addName(muffin, "Muffin");
        LanguageRegistry.addName(muffinChoc, "Chocolate Muffin");
        LanguageRegistry.addName(mug, "Mug");
        LanguageRegistry.addName(mugChoc, "Hot Chocolate");
        LanguageRegistry.addName(squid, "Squid Meat");
        LanguageRegistry.addName(squidCooked, "Cooked Squid Meat");
        LanguageRegistry.addName(lamb, "Lamb");
        LanguageRegistry.addName(lambCooked, "Cooked Lamb");
        LanguageRegistry.addName(flour, "Flour");
        LanguageRegistry.addName(applePie, "Apple Pie");

        LanguageRegistry.addName(riceSeed, "Rice Seeds");
        LanguageRegistry.addName(rice, "Rice");

        LanguageRegistry.addName(fryingPan, "Frying Pan");

        LanguageRegistry.addName(omelette, "Omelette");
        LanguageRegistry.addName(oil, "Rice Oil");
        LanguageRegistry.addName(bacon, "Bacon");
        LanguageRegistry.addName(sushi, "Sushi");


        LanguageRegistry.addName(strawberrySeed, "Strawberry Seeds");
        LanguageRegistry.addName(strawberry, "Strawberry");

        LanguageRegistry.addName(jamJar, "Jam Jar");
        LanguageRegistry.addName(jamJarApple, "Apple Jam");
        LanguageRegistry.addName(jamJarMelon, "Melon Jam");
        LanguageRegistry.addName(jamJarStrawberry, "Strawberry Jam");

        LanguageRegistry.addName(sandwichApple, "Apple Jam Sandwich");
        LanguageRegistry.addName(sandwichMelon, "Melon Jam Sandwich");
        LanguageRegistry.addName(sandwichStrawberry, "Strawberry Jam Sandwich");

        LanguageRegistry.addName(pancakes, "Pancakes");
        LanguageRegistry.addName(pancakesApple, "Apple Pancakes");

        LanguageRegistry.addName(frenchToast, "French Toast");

        LanguageRegistry.addName(boxLunch, "Bento");
        LanguageRegistry.addName(fruitSalad, "Fruit Salad");

        LanguageRegistry.addName(friedEgg, "Fried Egg");
        LanguageRegistry.addName(scrambledEgg, "Scrambled Egg");

        LanguageRegistry.addName(tacoShell, "Taco Shell");
        LanguageRegistry.addName(taco, "Taco");

        LanguageRegistry.addName(eyeCandy, "Eye Candy");
        LanguageRegistry.addName(spiderLollipop, "Spider Lollipop");

        LanguageRegistry.addName(lambSteak, "Lamb Steak");

        LanguageRegistry.addName(cheese, "Cheese");
        LanguageRegistry.addName(cheeseBurger, "Cheese Burger");

        LanguageRegistry.addName(ramen, "Ramen");

        LanguageRegistry.addName(grapeSeed, "Grape Seeds");
        LanguageRegistry.addName(grapes, "Grapes");

        LanguageRegistry.addName(bottle, "Bottle");
        LanguageRegistry.addName(bottleWine, "Wine");
        LanguageRegistry.addName(bottleCider, "Cider");
        
        LanguageRegistry.addName(butter, "Butter");
        
        LanguageRegistry.addName(sandwichCheese, "Cheese Sandwich");
        LanguageRegistry.addName(macAndCheese, "Macaroni and Cheese");
        LanguageRegistry.addName(jamJarGrape, "Grape Jam");
        LanguageRegistry.addName(sandwichGrape, "Grape Jam Sandwich");
        LanguageRegistry.addName(frenchFries, "French Fries");
        LanguageRegistry.addName(fishBurger, "Fish Burger");
        LanguageRegistry.addName(potatoCake, "Potato Cake");
        LanguageRegistry.addName(lunchbox, "Lunchbox");
    }
}
