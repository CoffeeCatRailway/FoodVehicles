package coffeecatteam.foodvehicles.entity.mobiles;

import coffeecatteam.foodvehicles.init.InitItem;
import coffeecatteam.foodvehicles.entity.EntityFoodMobile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCarrotMobile extends EntityFoodMobile {

    public EntityCarrotMobile(World world) {
        super(world);
        this.setSize(2.0F, 1.5F);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(InitItem.CARROT_MOBILE_BODY);
        }
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
