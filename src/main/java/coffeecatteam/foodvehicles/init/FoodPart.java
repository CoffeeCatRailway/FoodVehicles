package coffeecatteam.foodvehicles.init;

import com.mrcrayfish.vehicle.item.ItemPart;
import net.minecraft.creativetab.CreativeTabs;

public class FoodPart extends ItemPart {

    public FoodPart(String name, CreativeTabs tab) {
        super(name);
        this.setCreativeTab(tab);
    }
}
