package coffeecatteam.foodvehicles.entity.mobiles.land;

import coffeecatteam.foodvehicles.entity.EntityLandFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCheeseMobile extends EntityLandFoodMobile {

    public EntityCheeseMobile(World world) {
        super(world);
    }

    @SideOnly(Side.CLIENT)
    public void onClientInit() {
        super.onClientInit();
        body = new ItemStack(InitItem.CHEESE_MOBILE_BODY);
    }
}
