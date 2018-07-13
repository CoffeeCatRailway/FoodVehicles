package coffeecatteam.foodvehicles.proxy;

import coffeecatteam.foodvehicles.entity.mobiles.air.EntityFlyingCarrotMobile;
import coffeecatteam.foodvehicles.entity.mobiles.land.*;
import coffeecatteam.foodvehicles.entity.mobiles.land.EntityCarrotMobile;
import coffeecatteam.foodvehicles.entity.mobiles.land.EntityLettuceMobile;
import coffeecatteam.foodvehicles.render.mobiles.air.RenderFlyingCarrotMobile;
import coffeecatteam.foodvehicles.render.mobiles.land.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		this.registerRenderLandMobiles();
		this.registerRenderAirMobiles();
	}

	private void registerRenderLandMobiles() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCheeseMobile.class, RenderCheeseMobile::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGrilledCheeseMobile.class, RenderGrilledCheeseMobile::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHamRawMobile.class, RenderHamRawMobile::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHamCookedMobile.class, RenderHamCookedMobile::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityCarrotMobile.class, RenderCarrotMobile::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityLettuceMobile.class, RenderLettuceMobile::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityCoffeeMobile.class, RenderCoffeeMobile::new);
    }

    private void registerRenderAirMobiles() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyingCarrotMobile.class, RenderFlyingCarrotMobile::new);
    }

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
