package coffeecatteam.foodvehicles.objects.entity.mobiles;

import coffeecatteam.foodvehicles.objects.entity.EntityFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHamCookedMobile extends EntityFoodMobile {

    public EntityHamCookedMobile(World world) {
        super(world);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(InitItem.HAM_COOKED_MOBILE_BODY);
        }
    }
}
