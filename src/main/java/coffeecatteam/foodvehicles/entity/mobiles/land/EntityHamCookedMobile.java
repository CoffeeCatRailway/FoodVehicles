package coffeecatteam.foodvehicles.entity.mobiles.land;

import coffeecatteam.foodvehicles.entity.EntityLandFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityHamCookedMobile extends EntityLandFoodMobile {

    public EntityHamCookedMobile(World world) {
        super(world);
    }

    @SideOnly(Side.CLIENT)
    public void onClientInit() {
        super.onClientInit();
        body = new ItemStack(InitItem.HAM_COOKED_MOBILE_BODY);
    }
}
