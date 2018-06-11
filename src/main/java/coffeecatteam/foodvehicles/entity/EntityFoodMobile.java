package coffeecatteam.foodvehicles.entity;

import com.mrcrayfish.vehicle.entity.EntityLandVehicle;
import com.mrcrayfish.vehicle.entity.EntityVehicle;
import com.mrcrayfish.vehicle.init.ModItems;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityFoodMobile extends EntityLandVehicle {

    @SideOnly(Side.CLIENT)
    public ItemStack steeringWheel;

    public EntityFoodMobile(World world) {
        super(world);
        this.setSpeed(12F);
        this.setTurnSensitivity(15);
        this.setSize(1.5F, 1.5F);
    }

    @Override
    public void entityInit() {
        super.entityInit();

        if (world.isRemote) {
            wheel = new ItemStack(ModItems.WHEEL);
            steeringWheel = new ItemStack(ModItems.GO_KART_STEERING_WHEEL);
        }
    }

    public boolean shouldRenderSteeringWheel() {
        return true;
    }

    public SoundEvent getMovingSound() {
        return ModSounds.GO_KART_ENGINE_MONO;
    }

    public SoundEvent getRidingSound() {
        return ModSounds.GO_KART_ENGINE_STEREO;
    }

    public double getMountedYOffset() {
        return 0.2F;
    }
}
