package coffeecatteam.foodvehicles.render;

import coffeecatteam.foodvehicles.entity.EntityAirFoodMobile;
import com.mrcrayfish.vehicle.client.render.RenderVehicle;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;

public abstract class RenderAirFoodMobiles<T extends EntityAirFoodMobile> extends RenderVehicle<T> {

    public RenderAirFoodMobiles(RenderManager renderManager) {
        super(renderManager);
    }

    public abstract void renderBody(T entity, double x, double y, double z, float currentYaw, float partialTicks, double bodyLevelToGround, float bodyPitch, float bodyRoll);

    public void doRender(T entity, double x, double y, double z, float currentYaw, float partialTicks) {
        RenderHelper.enableStandardItemLighting();
        EntityLivingBase entityLivingBase = (EntityLivingBase)entity.getControllingPassenger();
        if (entityLivingBase != null) {
            entityLivingBase.renderYawOffset = currentYaw;
            entityLivingBase.prevRenderYawOffset = currentYaw;
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(-currentYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0D, -0.03125D, -0.25D);
        this.setupBreakAnimation(entity, partialTicks);
        double bodyLevelToGround = 0.5D;
        float bodyPitch = entity.prevBodyRotationX + (entity.bodyRotationX - entity.prevBodyRotationX) * partialTicks;
        float bodyRoll = entity.prevBodyRotationZ + (entity.bodyRotationZ - entity.prevBodyRotationZ) * partialTicks;
        GlStateManager.pushMatrix();
        GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0D, bodyLevelToGround, 0.0D);
        GlStateManager.rotate(bodyRoll, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-bodyPitch, 0.0F, 0.0F, 1.0F);
        this.renderBody(entity, x, y, z, currentYaw, partialTicks, bodyLevelToGround, bodyPitch, bodyRoll);
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
    }
}
