package net.seventeencups.stillhungry.configuration;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.seventeencups.stillhungry.StillHungry;
import org.apache.logging.log4j.Level;

import java.io.File;

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

            // Coming next update ;D
            //StillHungry.medievalMode = configuration.get("Game Options", "MedievalMode", false).getBoolean(false);

        } catch (Exception e) {
            FMLLog.log(Level.ERROR, e, "Still Hungry has had a problem loading its configuration");
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
