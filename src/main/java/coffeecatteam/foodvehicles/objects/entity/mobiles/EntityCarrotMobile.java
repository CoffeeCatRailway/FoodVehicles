package coffeecatteam.foodvehicles.objects.entity.mobiles;

import coffeecatteam.foodvehicles.init.InitItem;
import coffeecatteam.foodvehicles.objects.entity.EntityFoodMobile;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityCarrotMobile extends EntityFoodMobile {

    public EntityCarrotMobile(World world) {
        super(world);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            body = new ItemStack(InitItem.CARROT_MOBILE_BODY);
        }
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();

        if (this.getControllingPassenger() != null) {
            int x = MathHelper.floor(this.posX);
            int y = MathHelper.floor(this.posY - 0.2D);
            int z = MathHelper.floor(this.posZ);
//            BlockPos pos = new BlockPos(x, y, z);
//            IBlockState state = this.world.getBlockState(pos);
//
//            Vec3d flamePosition = new Vec3d(0.0D, 1.0D, 0.0D);
//            flamePosition.rotateYaw(-(this.rotationYaw - this.additionalYaw) * 0.017453292F);
//            this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX + flamePosition.x, this.posY + flamePosition.y, this.posZ + flamePosition.z, -this.motionX, 0.0D, -this.motionZ, new int[]{Block.getStateId(state)});
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
