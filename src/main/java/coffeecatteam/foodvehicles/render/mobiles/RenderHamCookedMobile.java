package coffeecatteam.foodvehicles.render.mobiles;

import coffeecatteam.foodvehicles.entity.mobiles.EntityHamCookedMobile;
import coffeecatteam.foodvehicles.render.RenderFoodMobile;
import com.mrcrayfish.vehicle.client.render.Wheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderHamCookedMobile extends RenderFoodMobile<EntityHamCookedMobile> {

	public RenderHamCookedMobile(RenderManager renderManager) {
		super(renderManager);
		this.setEnginePosition(0F, 7.5F, -9F, 180F, 1.2F);
		wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.FRONT, 9.0F, 13.5F, 1.4F));
		wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.FRONT, 9.0F, 13.5F, 1.4F));
		wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.REAR, 9.0F, -8.5F, 1.4F));
		wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.REAR, 9.0F, -8.5F, 1.4F));
	}

    @Override
    public void renderBody(double bodyOffset, EntityHamCookedMobile entity, double x, double y, double z, float currentYaw, float partialTicks) {
        GlStateManager.translate(0, bodyOffset + 0.15, 0);
        Minecraft.getMinecraft().getRenderItem().renderItem(entity.body, ItemCameraTransforms.TransformType.NONE);
    }
}
