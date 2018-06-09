package coffeecatteam.foodvehicles.proxy;

import coffeecatteam.foodvehicles.FoodVehicles;
import coffeecatteam.foodvehicles.Reference;
import coffeecatteam.foodvehicles.objects.entity.mobiles.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ProxyCommon {

	public void preInit(FMLPreInitializationEvent event) {
        register("cheese", 0, EntityCheeseMobile.class);
        register("grilled_cheese", 1, EntityGrilledCheeseMobile.class);
        register("ham_raw", 2, EntityHamRawMobile.class);
        register("ham_cooked", 3, EntityHamCookedMobile.class);

	    register("carrot", 4, EntityCarrotMobile.class);
	}

	private void register(String name, int  id, Class<? extends Entity> clazz) {
	    name += "_mobile";
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), clazz, name, id, FoodVehicles.instance, 64, 1, true);
    }

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
