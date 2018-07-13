package coffeecatteam.foodvehicles.entity.mobiles.land;

import coffeecatteam.foodvehicles.entity.EntityLandFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGrilledCheeseMobile extends EntityLandFoodMobile {

    public EntityGrilledCheeseMobile(World world) {
        super(world);
    }

    @SideOnly(Side.CLIENT)
    public void onClientInit() {
        super.onClientInit();
        body = new ItemStack(InitItem.GRILLED_CHEESE_MOBILE_BODY);
    }
}
