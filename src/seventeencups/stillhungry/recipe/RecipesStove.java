package seventeencups.stillhungry.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seventeencups.stillhungry.item.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
* Still-Hungry
*
* RecipesStove
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

public class RecipesStove {

    private static final RecipesStove cookingBase = new RecipesStove();
    /**
     * The list of cooking results.
     */
    private HashMap<List<Integer>, ItemStack> cookingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Boolean> consumeList = new HashMap<List<Integer>, Boolean>();
    private List<Integer> omeletteRecipe = Arrays.asList(Item.egg.itemID, Item.egg.itemID, ModItems.fryingPan.itemID);
    private List<Integer> baconRecipe = Arrays.asList(Item.porkRaw.itemID, ModItems.oil.itemID, ModItems.fryingPan.itemID);
    private List<Integer> mugChocRecipe = Arrays.asList(ModItems.chocolate.itemID, Item.bucketMilk.itemID, ModItems.mug.itemID);
    private List<Integer> pancakesRecipe = Arrays.asList(ModItems.flour.itemID, Item.egg.itemID, ModItems.fryingPan.itemID);
    private List<Integer> frenchToastRecipe = Arrays.asList(Item.bread.itemID, ModItems.butter.itemID, ModItems.fryingPan.itemID);
    private List<Integer> friedEggRecipe = Arrays.asList(Item.egg.itemID, ModItems.oil.itemID, ModItems.fryingPan.itemID);
    private List<Integer> scrambledEggRecipe = Arrays.asList(Item.egg.itemID, Item.bucketMilk.itemID, ModItems.fryingPan.itemID);
    private List<Integer> tacoShellRecipe = Arrays.asList(ModItems.oil.itemID, Item.bread.itemID, ModItems.fryingPan.itemID);
    private List<Integer> tacoRecipe = Arrays.asList(ModItems.tacoShell.itemID, Item.beefRaw.itemID, ModItems.fryingPan.itemID);
    private List<Integer> lambSteakRecipe = Arrays.asList(ModItems.lamb.itemID, ModItems.oil.itemID, ModItems.fryingPan.itemID);
    private List<Integer> frenchFriesRecipe = Arrays.asList(Item.potato.itemID, ModItems.oil.itemID, ModItems.fryingPan.itemID);
    private List<Integer> potatoCakeRecipe = Arrays.asList(Item.potato.itemID, ModItems.flour.itemID, ModItems.fryingPan.itemID);

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final RecipesStove cooking() {
        return cookingBase;
    }

    private RecipesStove() {
        this.addCooking(omeletteRecipe, new ItemStack(ModItems.omelette, 1), false);
        this.addCooking(baconRecipe, new ItemStack(ModItems.bacon, 1), false);
        this.addCooking(mugChocRecipe, new ItemStack(ModItems.mugChoc, 1), true);
        this.addCooking(pancakesRecipe, new ItemStack(ModItems.pancakes, 1), false);
        this.addCooking(frenchToastRecipe, new ItemStack(ModItems.frenchToast, 1), false);
        this.addCooking(friedEggRecipe, new ItemStack(ModItems.friedEgg, 1), false);
        this.addCooking(scrambledEggRecipe, new ItemStack(ModItems.scrambledEgg, 1), false);
        this.addCooking(tacoShellRecipe, new ItemStack(ModItems.tacoShell, 1), false);
        this.addCooking(tacoRecipe, new ItemStack(ModItems.taco, 1), false);
        this.addCooking(lambSteakRecipe, new ItemStack(ModItems.lambSteak, 1), false);
        this.addCooking(frenchFriesRecipe, new ItemStack(ModItems.frenchFries, 1), false);
        this.addCooking(potatoCakeRecipe, new ItemStack(ModItems.potatoCake, 1), false);
    }

    /**
     * Adds a cooking recipe.
     */
    public void addCooking(List<Integer> par1ItemStack, ItemStack par2, boolean consumeTool) {
        this.cookingList.put(par1ItemStack, par2);
        this.consumeList.put(par1ItemStack, consumeTool);
    }

    public ItemStack getCookingResult(List<Integer> par1) {
        return this.cookingList.get(par1);
    }

    public boolean getConsumeResult(List<Integer> par1) {
        return this.consumeList.get(par1);
    }

    public Map getCookingList() {
        return this.cookingList;
    }
}
