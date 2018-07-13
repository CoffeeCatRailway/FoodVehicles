package coffeecatteam.foodvehicles.entity;

import com.mrcrayfish.vehicle.entity.EntityAirVehicle;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAirFoodMobile extends EntityAirVehicle {

    public EntityAirFoodMobile(World world) {
        super(world);
    }

    @Override
    public SoundEvent getMovingSound() {
        return null;
    }

    @Override
    public SoundEvent getRidingSound() {
        return null;
    }

    public double getMountedYOffset() {
        return 0.0D;
    }
}
