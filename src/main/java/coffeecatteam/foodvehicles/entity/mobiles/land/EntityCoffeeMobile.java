package coffeecatteam.foodvehicles.entity.mobiles.land;

import coffeecatteam.foodvehicles.entity.EntityLandFoodMobile;
import coffeecatteam.foodvehicles.init.InitBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCoffeeMobile extends EntityLandFoodMobile {

    public EntityCoffeeMobile(World world) {
        super(world);
        this.setSize(1.8F, 2.0F);
    }

    @SideOnly(Side.CLIENT)
    public void onClientInit() {
        super.onClientInit();
        body = new ItemStack(InitBlock.COFFEE_CUP_MOBILE_BODY);
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
