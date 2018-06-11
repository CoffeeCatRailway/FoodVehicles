package coffeecatteam.foodvehicles.init;

import coffeecatteam.foodvehicles.FoodVehicles;
import coffeecatteam.foodvehicles.Reference;
import coffeecatteam.foodvehicles.entity.mobiles.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

public class RegistrationHandler {

    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class Items {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> reg = event.getRegistry();

            for (Item item : ITEMS)
                reg.register(item);
        }

        @SubscribeEvent
        public static void registerModels(final ModelRegistryEvent event) {
            for (Item item : ITEMS)
                registerItemModel(item);
        }

        private static void registerItemModel(final Item item) {
            final String registryName = item.getRegistryName().toString();
            final ModelResourceLocation location = new ModelResourceLocation(registryName, "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, location);
        }
    }

    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class Blocks {
        public static final Set<Block> BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> reg = event.getRegistry();

            for (final Block block : BLOCKS)
                reg.register(block);
        }

        @SubscribeEvent
        public static void registerModels(final ModelRegistryEvent event) {
            for (Block block : BLOCKS)
                registerBlockModel(block);
        }

        private static void registerBlockModel(final Block block) {
            final String registryName = block.getRegistryName().toString();
            final ModelResourceLocation location = new ModelResourceLocation(registryName, "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, location);
        }
    }

    public static void init() {
        InitBlock.init();
        InitItem.init();
        FoodVehicles.logger.info("Items & blocks registered!");

        // Vehicles
        registerEntity("cheese", 0, EntityCheeseMobile.class);
        registerEntity("grilled_cheese", 1, EntityGrilledCheeseMobile.class);
        registerEntity("ham_raw", 2, EntityHamRawMobile.class);
        registerEntity("ham_cooked", 3, EntityHamCookedMobile.class);

        registerEntity("carrot", 4, EntityCarrotMobile.class);

        registerEntity("lettuce", 5, EntityLettuceMobile.class);

        registerEntity("coffee", 6, EntityCoffeeMobile.class);
        FoodVehicles.logger.info("Vehicles registered!");
    }

    private static void registerEntity(String name, int  id, Class<? extends Entity> clazz) {
        name += "_mobile";
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), clazz, name, id, FoodVehicles.instance, 64, 1, true);
    }
}
