package coffeecatteam.foodvehicles;

import coffeecatteam.foodvehicles.init.InitItem;
import com.mrcrayfish.vehicle.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import coffeecatteam.foodvehicles.proxy.ProxyCommon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPENDCIES)
public class FoodVehicles {

	private static Logger logger = LogManager.getFormatterLogger(Reference.NAME.replace(" ", ""));
    public static final CreativeTabs TAB = new CreativeTabs("tabVehicle") {
        public ItemStack getTabIconItem() {
            return new ItemStack(InitItem.CHEESE_MOBILE_BODY);
        }
    };
	
	@Mod.Instance
	public static FoodVehicles instance;

	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	private static ProxyCommon proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger.info("Pre Initialize");
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("Initialize");
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info("Post Initialize");
		proxy.postInit(event);
	}
}
