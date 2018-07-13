package coffeecatteam.foodvehicles.render.mobiles.air;

import coffeecatteam.foodvehicles.entity.mobiles.air.EntityFlyingCarrotMobile;
import coffeecatteam.foodvehicles.render.RenderAirFoodMobiles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderFlyingCarrotMobile extends RenderAirFoodMobiles<EntityFlyingCarrotMobile> {

    public RenderFlyingCarrotMobile(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void renderBody(EntityFlyingCarrotMobile entity, double x, double y, double z, float currentYaw, float partialTicks, double bodyLevelToGround, float bodyPitch, float bodyRoll) {
        GlStateManager.rotate(90, 0, 1, 0);
        float scale = 1.5f;
        GlStateManager.scale(scale, scale, scale);
        Minecraft.getMinecraft().getRenderItem().renderItem(entity.body, ItemCameraTransforms.TransformType.NONE);
    }
}
