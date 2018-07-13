package coffeecatteam.foodvehicles.render.mobiles.vegetables;

import coffeecatteam.foodvehicles.entity.mobiles.vegetables.EntityLettuceMobile;
import coffeecatteam.foodvehicles.render.RenderFoodMobile;
import com.mrcrayfish.vehicle.client.render.Wheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderLettuceMobile extends RenderFoodMobile<EntityLettuceMobile> {

    public RenderLettuceMobile(RenderManager renderManager) {
        super(renderManager);
        this.setEnginePosition(0F, 7.5F, -9F, 180F, 1.2F);

        float frontX = 7.0F;
        float frontZ = 10.5F;
        float frontScale = 1.8F;

        float rearX = 7.0F;
        float rearZ = -10.5F;
        float rearScale = 1.8F;

        wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.FRONT, frontX, frontZ, frontScale));
        wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.FRONT, frontX, frontZ, frontScale));
        wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.REAR, rearX, rearZ, rearScale));
        wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.REAR, rearX, rearZ, rearScale));
    }

    @Override
    public void renderBody(double bodyOffset, EntityLettuceMobile entity, double x, double y, double z, float currentYaw, float partialTicks) {
        GlStateManager.translate(0, bodyOffset + 0.5F, -0.8F);
        GlStateManager.rotate(180F, 0, 1, 0);
        double scaleBody = 1.5D;
        GlStateManager.scale(scaleBody, scaleBody, scaleBody);
        Minecraft.getMinecraft().getRenderItem().renderItem(entity.body, ItemCameraTransforms.TransformType.NONE);

        // Leaf Front
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(0, 0, -0.8F);
            GlStateManager.rotate(90F, 1, 0, 0);
            GlStateManager.rotate(180F, 0, 0, 1);
            Minecraft.getMinecraft().getRenderItem().renderItem(entity.leaf_front, ItemCameraTransforms.TransformType.NONE);
        }
        GlStateManager.popMatrix();
        // Leaf Back
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(0, 0, 0.08F);
            Minecraft.getMinecraft().getRenderItem().renderItem(entity.leaf, ItemCameraTransforms.TransformType.NONE);
        }
        GlStateManager.popMatrix();
        // Leaf Right
        GlStateManager.translate(0, 0.1F, 0);
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(0.15F, 0, 0);
            GlStateManager.rotate(-23F, 0, 0, 1);
            GlStateManager.rotate(90F, 0, 1, 0);
            Minecraft.getMinecraft().getRenderItem().renderItem(entity.leaf, ItemCameraTransforms.TransformType.NONE);
        }
        GlStateManager.popMatrix();
        // Leaf Left
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(-0.15F, 0, 0);
            GlStateManager.rotate(23F, 0, 0, 1);
            GlStateManager.rotate(-90F, 0, 1, 0);
            Minecraft.getMinecraft().getRenderItem().renderItem(entity.leaf, ItemCameraTransforms.TransformType.NONE);
        }
        GlStateManager.popMatrix();
    }

    @Override
    public void renderHandlesBars(double bodyOffset, EntityLettuceMobile entity, double x, double y, double z, float currentYaw, float partialTicks) {
        GlStateManager.translate(0, bodyOffset + 0.6, 0.45);
        GlStateManager.rotate(-45F, 1, 0, 0);
        GlStateManager.translate(0, -0.02, 0);
        GlStateManager.scale(0.9, 0.9, 0.9);

        float wheelAngle = entity.prevWheelAngle + (entity.wheelAngle - entity.prevWheelAngle) * partialTicks;
        float wheelAngleNormal = wheelAngle / 45F;
        float turnRotation = wheelAngleNormal * 25F;
        GlStateManager.rotate(turnRotation, 0, 1, 0);

        Minecraft.getMinecraft().getRenderItem().renderItem(entity.steeringWheel, ItemCameraTransforms.TransformType.NONE);
    }
}
