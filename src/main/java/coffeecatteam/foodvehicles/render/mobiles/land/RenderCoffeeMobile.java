package coffeecatteam.foodvehicles.render.mobiles.land;

import coffeecatteam.foodvehicles.entity.mobiles.land.EntityCoffeeMobile;
import coffeecatteam.foodvehicles.render.RenderLandFoodMobile;
import com.mrcrayfish.vehicle.client.render.Wheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCoffeeMobile extends RenderLandFoodMobile<EntityCoffeeMobile> {

    public RenderCoffeeMobile(RenderManager renderManager) {
        super(renderManager);

        float frontX = 12.0F;
        float frontZ = 8.0F;
        float frontScale = 1.4F;

        float rearX = 12.0F;
        float rearZ = -8.0F;
        float rearScale = 1.4F;

        wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.FRONT, frontX, frontZ, frontScale));
        wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.FRONT, frontX, frontZ, frontScale));
        wheels.add(new Wheel(Wheel.Side.LEFT, Wheel.Position.REAR, rearX, rearZ, rearScale));
        wheels.add(new Wheel(Wheel.Side.RIGHT, Wheel.Position.REAR, rearX, rearZ, rearScale));
    }

    @Override
    public void renderBody(double bodyOffset, EntityCoffeeMobile entity, double x, double y, double z, float currentYaw, float partialTicks) {
        GlStateManager.translate(0, bodyOffset + 1.6, 0);
        GlStateManager.rotate(180F, 0, 1, 0);
        double scaleBody = 4D;
        GlStateManager.scale(scaleBody, scaleBody, scaleBody);
        Minecraft.getMinecraft().getRenderItem().renderItem(entity.body, ItemCameraTransforms.TransformType.NONE);
    }
}
