package net.seventeencups.stillhungry.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.seventeencups.stillhungry.item.ItemSH;
import net.seventeencups.stillhungry.item.ModItems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private HashMap<List<Item>, ItemStack> cookingList = new HashMap<List<Item>, ItemStack>();
    private HashMap<List<Item>, Boolean> consumeList = new HashMap<List<Item>, Boolean>();
    private List<Item> omeletteRecipe = Arrays.asList(Items.egg, Items.egg, ModItems.fryingPan);
    private List<Item> baconRecipe = Arrays.asList(Items.porkchop, ModItems.oil, ModItems.fryingPan);
    private List<Item> mugChocRecipe = Arrays.asList(ModItems.chocolate, Items.milk_bucket, ModItems.mug);
    private List<Item> pancakesRecipe = Arrays.asList(ModItems.flour, Items.egg, ModItems.fryingPan);
    private List<Item> frenchToastRecipe = Arrays.asList(Items.bread, Items.egg, ModItems.fryingPan);
    private List<Item> friedEggRecipe = Arrays.asList(Items.egg, ModItems.oil, ModItems.fryingPan);
    private List<Item> scrambledEggRecipe = Arrays.asList(Items.egg, Items.milk_bucket, ModItems.fryingPan);
    private List<Item> tacoShellRecipe = Arrays.asList(ModItems.oil, Items.bread, ModItems.fryingPan);
    private List<Item> tacoRecipe = Arrays.asList(ModItems.tacoShell, Items.beef, ModItems.fryingPan);
    private List<Item> lambSteakRecipe = Arrays.asList(ModItems.lamb, ModItems.oil, ModItems.fryingPan);
    private List<Item> frenchFriesRecipe = Arrays.asList(Items.potato, ModItems.oil, ModItems.fryingPan);
    private List<Item> potatoCakeRecipe = Arrays.asList(Items.potato, ModItems.flour, ModItems.fryingPan);

    // Used for shift clicking in the stove
    public List<ItemSH> toolList = Arrays.asList(ModItems.fryingPan, ModItems.mug);

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
    public void addCooking(List<Item> par1ItemStack, ItemStack par2, boolean consumeTool) {
        this.cookingList.put(par1ItemStack, par2);
        this.consumeList.put(par1ItemStack, consumeTool);
    }

    public ItemStack getCookingResult(List<Item> par1) {
        return this.cookingList.get(par1);
    }

    public boolean getConsumeResult(List<Item> par1) {
        return this.consumeList.get(par1);
    }

    public Map getCookingList() {
        return this.cookingList;
    }
}
