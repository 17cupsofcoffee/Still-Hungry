package net.seventeencups.stillhungry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.seventeencups.stillhungry.block.ModBlocks;
import net.seventeencups.stillhungry.client.gui.GuiHandler;
import net.seventeencups.stillhungry.configuration.ConfigurationHandler;
import net.seventeencups.stillhungry.item.ModItems;
import net.seventeencups.stillhungry.potion.PotionDrunkenness;
import net.seventeencups.stillhungry.tileentity.TileBarrel;
import net.seventeencups.stillhungry.tileentity.TileStove;
import net.seventeencups.stillhungry.worldgen.WorldGenerator;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
* Still-Hungry
*
* StillHungry
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

@Mod(modid = StillHungry.modid, name = "Still Hungry!", version = "1.7.2-2.1.0")
public class StillHungry {

    public static final String modid = "stillhungry";

    // Coming next update ;D
    //public static boolean medievalMode;

    @Instance("stillhungry")
    public static StillHungry instance;
    @SidedProxy(clientSide = "net.seventeencups.stillhungry.ClientProxy",
            serverSide = "net.seventeencups.stillhungry.CommonProxy")
    public static CommonProxy proxy;
    
    public static Potion potionDrunkenness;

    public static CreativeTabs tabStillHungry = new CreativeTabs("tabStillHungry") {
        @Override
        public Item getTabIconItem() {
            return ModItems.fryingPan;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        
        // REFLECTION CODE : This is used to add more potions to the game :)
        
        Potion[] potionTypes = null;
        
        for (Field f :Potion.class.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
                    
                    potionTypes = (Potion[])f.get(null);
                    final Potion[] newPotionTypes = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            }
            catch (Exception e) {
                System.err.println("Potion list reflection failed, please file a bug report:");
                System.err.println(e);
            }
        }

        MinecraftForge.EVENT_BUS.register(new EventHooks());
        FMLCommonHandler.instance().bus().register(new FMLEventHooks());

        proxy.registerRenderers();

        ModBlocks.init();

        potionDrunkenness = (new PotionDrunkenness(32, false, 0)).setIconIndex(0, 0)
                .setPotionName("potion.drunkenness");

        ModItems.init();

        GameRegistry.registerWorldGenerator(new WorldGenerator(), 0);

        GameRegistry.registerTileEntity(TileStove.class, "Tile Entity Stove");
        GameRegistry.registerTileEntity(TileBarrel.class, "Tile Entity Barrel");

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {


    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
