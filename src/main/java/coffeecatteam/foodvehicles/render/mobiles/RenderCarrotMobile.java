package coffeecatteam.foodvehicles.render.mobiles;

import coffeecatteam.foodvehicles.entity.mobiles.EntityCarrotMobile;
import coffeecatteam.foodvehicles.render.RenderFoodMobile;
import com.mrcrayfish.vehicle.client.render.Wheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCarrotMobile extends RenderFoodMobile<EntityCarrotMobile> {

	public RenderCarrotMobile(RenderManager renderManager) {
		super(renderManager);
		this.setEnginePosition(0F, 7.5F, -9F, 180F, 1.2F);

        float frontX = 6.0F;
        float frontZ = 13.5F;
        float frontScale = 1.4F;

        float rearX = 8.0F;
        float rearZ = -8.5F;
        float rearScale = 2.0F;

		wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.FRONT, frontX, frontZ, frontScale));
		wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.FRONT, frontX, frontZ, frontScale));
		wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.REAR, rearX, rearZ, rearScale));
		wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.REAR, rearX, rearZ, rearScale));
	}

    @Override
    public void renderBody(double bodyOffset, EntityCarrotMobile entity, double x, double y, double z, float currentYaw, float partialTicks) {
        GlStateManager.translate(0, bodyOffset + 0.4, 0);
        GlStateManager.rotate(180F, 0, 1, 0);
        GlStateManager.rotate(-5.0F, 1, 0, 0);
        double scaleBody = 2D;
        GlStateManager.scale(scaleBody, scaleBody, scaleBody);
        Minecraft.getMinecraft().getRenderItem().renderItem(entity.body, ItemCameraTransforms.TransformType.NONE);
    }

    @Override
    public void renderHandlesBars(double bodyOffset, EntityCarrotMobile entity, double x, double y, double z, float currentYaw, float partialTicks) {
    }
}
