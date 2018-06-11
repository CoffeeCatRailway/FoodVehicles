package coffeecatteam.foodvehicles.render;

import coffeecatteam.foodvehicles.entity.EntityFoodMobile;
import com.mrcrayfish.vehicle.client.render.RenderLandVehicle;
import com.mrcrayfish.vehicle.client.render.RenderVehicle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public abstract class RenderFoodMobile<T extends EntityFoodMobile> extends RenderLandVehicle<T> {

    public RenderFoodMobile(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return null;
    }

    public abstract void renderBody(double bodyOffset, T entity, double x, double y, double z, float currentYaw, float partialTicks);

    public void renderHandlesBars(double bodyOffset, T entity, double x, double y, double z, float currentYaw, float partialTicks) {
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

    @Override
    public void doRender(T entity, double x, double y, double z, float currentYaw, float partialTicks) {
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
                renderBody(bodyOffset, entity, x, y, z, currentYaw, partialTicks);
            }
            GlStateManager.popMatrix();

            // Render the handles bars
            if (entity.shouldRenderSteeringWheel()) {
                GlStateManager.pushMatrix();
                {
                    renderHandlesBars(bodyOffset, entity, x, y, z, currentYaw, partialTicks);
                }
                GlStateManager.popMatrix();
            }

            GlStateManager.translate(0, 3.5F * 0.0625F, 0);
            super.doRender(entity, x, y, z, currentYaw, partialTicks);
        }
        GlStateManager.popMatrix();
    }
}
