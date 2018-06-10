package coffeecatteam.foodvehicles.init;

import coffeecatteam.foodvehicles.FoodVehicles;
import coffeecatteam.foodvehicles.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

public class InitItem {

	public static final Item CHEESE_MOBILE_BODY;
    public static final Item GRILLED_CHEESE_MOBILE_BODY;
    public static final Item HAM_RAW_MOBILE_BODY;
    public static final Item HAM_COOKED_MOBILE_BODY;

    public static final Item CARROT_MOBILE_BODY;

    public static final Item LETTUCE_MOBILE_BODY;
    public static final Item LETTUCE_MOBILE_LEAF;
    public static final Item LETTUCE_MOBILE_LEAF_FRONT;

    static {
        CHEESE_MOBILE_BODY = new FoodPart("cheese_mobile_body", FoodVehicles.TAB);
        GRILLED_CHEESE_MOBILE_BODY = new FoodPart("grilled_cheese_mobile_body", FoodVehicles.TAB);
        HAM_RAW_MOBILE_BODY = new FoodPart("ham_raw_mobile_body", FoodVehicles.TAB);
        HAM_COOKED_MOBILE_BODY = new FoodPart("ham_cooked_mobile_body", FoodVehicles.TAB);

        CARROT_MOBILE_BODY = new FoodPart("carrot_mobile_body", FoodVehicles.TAB);

        LETTUCE_MOBILE_BODY = new FoodPart("lettuce_mobile_body", FoodVehicles.TAB);
        LETTUCE_MOBILE_LEAF = new FoodPart("lettuce_mobile_leaf", FoodVehicles.TAB);
        LETTUCE_MOBILE_LEAF_FRONT = new FoodPart("lettuce_mobile_leaf_front", null);
    }
    
    @EventBusSubscriber(modid = Reference.MODID)
	public static class ItemRegistrationHandler {
		public static final Set<Item> ITEM_LIST = new HashSet<>();

		private static Item[] items = {
                CHEESE_MOBILE_BODY,
                GRILLED_CHEESE_MOBILE_BODY,
                HAM_RAW_MOBILE_BODY,
                HAM_COOKED_MOBILE_BODY,

                CARROT_MOBILE_BODY,

                LETTUCE_MOBILE_BODY,
                LETTUCE_MOBILE_LEAF,
                LETTUCE_MOBILE_LEAF_FRONT
        };

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			IForgeRegistry<Item> reg = event.getRegistry();

			for (Item item : items) {
				reg.register(item);
				ITEM_LIST.add(item);
			}
		}

		@SubscribeEvent
		public static void registerModels(final ModelRegistryEvent event) {
			ITEM_LIST.forEach(ItemRegistrationHandler::registerModel);
		}
		
		private static void registerModel(Item item) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		}
	}
}
