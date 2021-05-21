package com.mcexamples.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcexamples.lists.BlockList;
import com.mcexamples.lists.EntityList;
import com.mcexamples.lists.ItemList;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.*;

import java.util.function.Supplier;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MOD_ID)
@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static Item item;
    public static final String MOD_ID = "mcexamples";
    
   // private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

//public static final RegistryObject<Block> ROCK_BLOCK;// = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));

/*public ExampleMod() {
    BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
}
     */
    
    public ExampleMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
      //  
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        //registerCommonEvents(modEventBus);
       // BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockList.BLOCKS.register(modEventBus);
        ItemList.ITEMS.register(modEventBus);
        EntityList.ENTITIES.register(modEventBus);
        // Register the doClientStuff method for modloading
       

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    /*private void registerCommonEvents(IEventBus modEventBus) {
    	System.out.println("register startupCommon class : " + modEventBus.toString());
		modEventBus.register(com.mcexamples.examplemod.StartupCommon.class);
		
	}*/
    
    @SubscribeEvent
    public static void createBlockItem(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockList.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
        {
                final Item.Properties properties = new Item.Properties().tab(ItemGroup.TAB_MISC);
                final BlockItem blockitem  = new BlockItem(block, properties);
                blockitem.setRegistryName(block.getRegistryName());
                registry.register(blockitem);
        });
    }
  

	private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT. Good Luck");
        // LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.description());
        RegisterEntityModels(event.getMinecraftSupplier());
    }

    private void RegisterEntityModels(Supplier<Minecraft> minecraftSupplier) {
		 ItemRenderer renderer = minecraftSupplier.get().getItemRenderer();
    	 RenderingRegistry.registerEntityRenderingHandler(EntityList.SILVER_PISTOL_BULLET_PROJECTILE.get(), (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer));
         RenderingRegistry.registerEntityRenderingHandler(EntityList.IRON_PISTOL_BULLET_PROJECTILE.get(), (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer));
	}

	private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
  /*  @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block .. what is going on : " +  blockRegistryEvent.getRegistry().getRegistryName());
            blockRegistryEvent.getRegistry();
        }
    }*/
}
