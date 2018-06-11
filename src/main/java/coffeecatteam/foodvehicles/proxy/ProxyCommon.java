package coffeecatteam.foodvehicles.proxy;

import coffeecatteam.foodvehicles.FoodVehicles;
import coffeecatteam.foodvehicles.Reference;
import coffeecatteam.foodvehicles.entity.mobiles.*;
import coffeecatteam.foodvehicles.init.RegistrationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ProxyCommon {

	public void preInit(FMLPreInitializationEvent event) {
        RegistrationHandler.init();
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}
