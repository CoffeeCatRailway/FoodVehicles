package coffeecatteam.foodvehicles.entity.mobiles.land;

import coffeecatteam.foodvehicles.init.InitItem;
import coffeecatteam.foodvehicles.entity.EntityLandFoodMobile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCarrotMobile extends EntityLandFoodMobile {

    public EntityCarrotMobile(World world) {
        super(world);
        this.setSize(2.0F, 1.5F);
    }

    @SideOnly(Side.CLIENT)
    public void onClientInit() {
        super.onClientInit();
        body = new ItemStack(InitItem.CARROT_MOBILE_BODY);
    }

    @Override
    public boolean shouldRenderSteeringWheel() {
        return false;
    }

    @Override
    public boolean shouldRenderEngine() {
        return false;
    }

    @Override
    public double getMountedYOffset() {
        return 1.0D;
    }
}
