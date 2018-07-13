package coffeecatteam.foodvehicles.proxy;

import coffeecatteam.foodvehicles.entity.mobiles.*;
import coffeecatteam.foodvehicles.entity.mobiles.vegetables.EntityCarrotMobile;
import coffeecatteam.foodvehicles.entity.mobiles.vegetables.EntityLettuceMobile;
import coffeecatteam.foodvehicles.render.mobiles.*;
import coffeecatteam.foodvehicles.render.mobiles.vegetables.RenderCarrotMobile;
import coffeecatteam.foodvehicles.render.mobiles.vegetables.RenderLettuceMobile;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityCheeseMobile.class, RenderCheeseMobile::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGrilledCheeseMobile.class, RenderGrilledCheeseMobile::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHamRawMobile.class, RenderHamRawMobile::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHamCookedMobile.class, RenderHamCookedMobile::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityCarrotMobile.class, RenderCarrotMobile::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityLettuceMobile.class, RenderLettuceMobile::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityCoffeeMobile.class, RenderCoffeeMobile::new);
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
