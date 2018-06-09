package coffeecatteam.foodvehicles.entity.mobiles;

import coffeecatteam.foodvehicles.entity.EntityFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHamRawMobile extends EntityFoodMobile {

    public EntityHamRawMobile(World world) {
        super(world);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(InitItem.HAM_RAW_MOBILE_BODY);
        }
    }
}
