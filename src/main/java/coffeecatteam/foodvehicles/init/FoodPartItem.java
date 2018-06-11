package coffeecatteam.foodvehicles.init;

import com.mrcrayfish.vehicle.item.ItemPart;
import net.minecraft.creativetab.CreativeTabs;

public class FoodPartItem extends ItemPart {

    public FoodPartItem(String name, CreativeTabs tab) {
        super(name);
        this.setCreativeTab(tab);
    }
}
