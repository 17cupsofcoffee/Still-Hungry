package seventeencups.stillhungry;

import seventeencups.stillhungry.block.ModBlocks;
import seventeencups.stillhungry.configuration.ConfigurationHandler;
import seventeencups.stillhungry.client.gui.GuiHandler;
import seventeencups.stillhungry.item.ModItems;
import seventeencups.stillhungry.tileentity.TileBarrel;
import seventeencups.stillhungry.tileentity.TileStove;
import seventeencups.stillhungry.worldgen.WorldGenerator;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.potion.Potion;
import seventeencups.stillhungry.potion.PotionDrunkenness;

/**
* Still-Hungry
*
* StillHungry
*
* @author 17cupsofcoffee
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*
*/

@Mod(modid = StillHungry.modid, name = "Still Hungry!", version = "2.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class StillHungry {

    public static final String modid = "stillhungry";
    @Instance("stillhungry")
    public static StillHungry instance;
    @SidedProxy(clientSide = "seventeencups.stillhungry.ClientProxy",
            serverSide = "seventeencups.stillhungry.CommonProxy")
    public static CommonProxy proxy;
    
    public static Potion potionDrunkenness;

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
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventHooks());

        proxy.registerRenderers();

        ModBlocks.init();
        
        potionDrunkenness = (new PotionDrunkenness(32, false, 0)).setIconIndex(0, 0)
                .setPotionName("potion.drunkenness");
        
        LanguageRegistry.instance().addStringLocalization("potion.drunkenness", "Drunkenness");

        ModItems.init();

        GameRegistry.registerWorldGenerator(new WorldGenerator());

        GameRegistry.registerTileEntity(TileStove.class, "Tile Entity Stove");
        GameRegistry.registerTileEntity(TileBarrel.class, "Tile Entity Barrel");

        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
