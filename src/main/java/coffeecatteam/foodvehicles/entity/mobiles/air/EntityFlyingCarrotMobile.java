package coffeecatteam.foodvehicles.entity.mobiles.air;

import coffeecatteam.foodvehicles.entity.EntityAirFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFlyingCarrotMobile extends EntityAirFoodMobile {

    public EntityFlyingCarrotMobile(World world) {
        super(world);
        this.setSize(2.0F, 1.5F);
    }

    @Override
    public void onClientInit() {
        this.body = new ItemStack(InitItem.CARROT_MOBILE_BODY, 1, 0);
    }

    @Override
    public double getMountedYOffset() {
        return 0.5D;
    }
}
