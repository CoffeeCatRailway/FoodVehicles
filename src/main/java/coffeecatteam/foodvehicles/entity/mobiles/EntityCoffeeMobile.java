package coffeecatteam.foodvehicles.entity.mobiles;

import coffeecatteam.foodvehicles.entity.EntityFoodMobile;
import coffeecatteam.foodvehicles.init.InitBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCoffeeMobile extends EntityFoodMobile {

    public EntityCoffeeMobile(World world) {
        super(world);
        this.setSize(1.8F, 2.0F);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(InitBlock.COFFEE_CUP_MOBILE_BODY);
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
