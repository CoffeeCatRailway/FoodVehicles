package coffeecatteam.foodvehicles.render.mobiles;

import coffeecatteam.foodvehicles.entity.mobiles.EntityCheeseMobile;
import com.mrcrayfish.vehicle.client.render.RenderVehicle;
import com.mrcrayfish.vehicle.client.render.Wheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCheeseMobile extends RenderVehicle<EntityCheeseMobile> {

	public RenderCheeseMobile(RenderManager renderManager) {
		super(renderManager);
		this.setEnginePosition(0F, 7.5F, -9F, 180F, 1.2F);
		wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.FRONT, 9.0F, 13.5F, 1.4F));
		wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.FRONT, 9.0F, 13.5F, 1.4F));
		wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.REAR, 9.0F, -8.5F, 1.4F));
		wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.REAR, 9.0F, -8.5F, 1.4F));
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityCheeseMobile entity) {
		return null;
	}

	@Override
	public void doRender(EntityCheeseMobile entity, double x, double y, double z, float currentYaw, float partialTicks) {
		RenderHelper.enableStandardItemLighting();

		float additionalYaw = entity.prevAdditionalYaw + (entity.additionalYaw - entity.prevAdditionalYaw) * partialTicks;

		EntityLivingBase entityLivingBase = (EntityLivingBase) entity.getControllingPassenger();
		if (entityLivingBase != null) {
			entityLivingBase.renderYawOffset = currentYaw - additionalYaw;
			entityLivingBase.prevRenderYawOffset = currentYaw - additionalYaw;
		}

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(-currentYaw, 0, 1, 0);
			GlStateManager.rotate(additionalYaw, 0, 1, 0);
			GlStateManager.scale(1, 1, 1);

			this.setupBreakAnimation(entity, partialTicks);

			double bodyOffset = 0.5625;

			// Render the body
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(0, bodyOffset + 0.15, 0);
				Minecraft.getMinecraft().getRenderItem().renderItem(entity.body, ItemCameraTransforms.TransformType.NONE);
			}
			GlStateManager.popMatrix();

			// Render the handles bars
            if (entity.shouldRenderSteeringWheel()) {
                GlStateManager.pushMatrix();
                {
                    GlStateManager.translate(0, bodyOffset + 0.09, 0.49);
                    GlStateManager.rotate(-45F, 1, 0, 0);
                    GlStateManager.translate(0, -0.02, 0);
                    GlStateManager.scale(0.9, 0.9, 0.9);

                    float wheelAngle = entity.prevWheelAngle + (entity.wheelAngle - entity.prevWheelAngle) * partialTicks;
                    float wheelAngleNormal = wheelAngle / 45F;
                    float turnRotation = wheelAngleNormal * 25F;
                    GlStateManager.rotate(turnRotation, 0, 1, 0);

                    Minecraft.getMinecraft().getRenderItem().renderItem(entity.steeringWheel, ItemCameraTransforms.TransformType.NONE);
                }
                GlStateManager.popMatrix();
            }

			GlStateManager.translate(0, 3.5F * 0.0625F, 0);
			super.doRender(entity, x, y, z, currentYaw, partialTicks);
		}
		GlStateManager.popMatrix();
	}
}
