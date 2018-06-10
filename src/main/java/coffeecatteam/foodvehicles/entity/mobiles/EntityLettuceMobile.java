package coffeecatteam.foodvehicles.entity.mobiles;

import coffeecatteam.foodvehicles.entity.EntityFoodMobile;
import coffeecatteam.foodvehicles.init.InitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLettuceMobile extends EntityFoodMobile {

    @SideOnly(Side.CLIENT)
    public ItemStack leaf;
    @SideOnly(Side.CLIENT)
    public ItemStack leaf_front;

    public EntityLettuceMobile(World world) {
        super(world);
        this.setSpeed(15F);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(InitItem.LETTUCE_MOBILE_BODY);
            leaf = new ItemStack(InitItem.LETTUCE_MOBILE_LEAF);
            leaf_front = new ItemStack(InitItem.LETTUCE_MOBILE_LEAF_FRONT);
        }
    }

    @Override
    public boolean shouldRenderSteeringWheel() {
        return true;
    }

    @Override
    public boolean shouldRenderEngine() {
        return false;
    }

    @Override
    public double getMountedYOffset() {
        return 0.4D;
    }
}
