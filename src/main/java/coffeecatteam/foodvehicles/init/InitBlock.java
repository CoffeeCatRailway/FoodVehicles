package coffeecatteam.foodvehicles.init;

import coffeecatteam.foodvehicles.FoodVehicles;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class InitBlock {

    public static Block COFFEE_CUP_MOBILE_BODY = new FoodPartBlock("coffee_cup_mobile_body", Material.ROCK, FoodVehicles.TAB);

    public static void init() {
        register(COFFEE_CUP_MOBILE_BODY);
    }

    private static void register(Block... blocks) {
        for (Block block : blocks)
            register(block);
    }

    private static void register(Block block) {
        RegistrationHandler.Blocks.BLOCKS.add(block);
        ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
        RegistrationHandler.Items.ITEMS.add(itemBlock);
    }
}
