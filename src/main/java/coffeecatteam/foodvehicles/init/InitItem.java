package coffeecatteam.foodvehicles.init;

import coffeecatteam.foodvehicles.FoodVehicles;
import net.minecraft.item.Item;

public class InitItem {

	public static Item CHEESE_MOBILE_BODY = new FoodPartItem("cheese_mobile_body", FoodVehicles.TAB);
    public static Item GRILLED_CHEESE_MOBILE_BODY = new FoodPartItem("grilled_cheese_mobile_body", FoodVehicles.TAB);
    public static Item HAM_RAW_MOBILE_BODY = new FoodPartItem("ham_raw_mobile_body", FoodVehicles.TAB);
    public static Item HAM_COOKED_MOBILE_BODY = new FoodPartItem("ham_cooked_mobile_body", FoodVehicles.TAB);

    public static Item CARROT_MOBILE_BODY = new FoodPartItem("carrot_mobile_body", FoodVehicles.TAB);

    public static Item LETTUCE_MOBILE_BODY = new FoodPartItem("lettuce_mobile_body", FoodVehicles.TAB);
    public static Item LETTUCE_MOBILE_LEAF = new FoodPartItem("lettuce_mobile_leaf", FoodVehicles.TAB);
    public static Item LETTUCE_MOBILE_LEAF_FRONT = new FoodPartItem("lettuce_mobile_leaf_front", null);

    //public static Item COFFEE_CUP_MOBILE_BODY = new FoodPartItem("coffee_cup_mobile_body", FoodVehicles.TAB);

    public static void init() {
        register(CHEESE_MOBILE_BODY, GRILLED_CHEESE_MOBILE_BODY, HAM_RAW_MOBILE_BODY, HAM_COOKED_MOBILE_BODY);
        register(CARROT_MOBILE_BODY);
        register(LETTUCE_MOBILE_BODY, LETTUCE_MOBILE_LEAF, LETTUCE_MOBILE_LEAF_FRONT);
        //register(COFFEE_CUP_MOBILE_BODY);
    }

    private static void register(Item... items) {
        for (Item item : items)
            register(item);
    }

    private static void register(Item item) {
        RegistrationHandler.Items.ITEMS.add(item);
    }
}
