package coffeecatteam.foodvehicles.objects.entity.mobiles;

import coffeecatteam.foodvehicles.init.InitItem;
import coffeecatteam.foodvehicles.objects.entity.EntityFoodMobile;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityCarrotMobile extends EntityFoodMobile {

    public EntityCarrotMobile(World world) {
        super(world);
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
