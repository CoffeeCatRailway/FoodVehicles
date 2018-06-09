package coffeecatteam.foodvehicles.objects.entity.mobiles;

import coffeecatteam.foodvehicles.objects.entity.EntityFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCheeseMobile extends EntityFoodMobile {

    public EntityCheeseMobile(World world) {
        super(world);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(InitItem.CHEESE_MOBILE_BODY);
        }
    }
}
