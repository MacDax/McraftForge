package com.macdax.mcexamples;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StartupCommon {

	
	

//public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));


	 
	  
	  /*@SubscribeEvent
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
	  */
	  

	 /* @SubscribeEvent
	  public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
		  Material material = new Material(MaterialColor.COLOR_PURPLE, false, false, false, false, false, false, null );
		  Properties props = Properties.of(material);
	    blockSimple = (BlockSimple)(new BlockSimple(props).setRegistryName("testmod", "block_simple_registry_name"));
	    blockRegisterEvent.getRegistry().register(blockSimple);
	  }*/
	  
	/*  @SubscribeEvent
	  public static void registerBlocks(RegistryEvent.Register<Block> event) {
		 System.out.println("in register block of sc : " + event.getName() + "  reg name : " + event.getRegistry().getRegistryName());
		  blockSimple1 = (BlockSimple) new BlockSimple().setRegistryName("mcexamples", "block_simple_registry_name"); 
				  
				
	    System.out.println("block registered :" + blockSimple1);
	    event.getRegistry().register(blockSimple1);
	      //event.getRegistry().registerAll(blockSimple1);
	    
	    //final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
	    //final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(4.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	  }*/

	/*  @SubscribeEvent
	  public static void onItemsRegistration(RegistryEvent.Register<Item> itemRegisterEvent) {
	    // We need to create a BlockItem so the player can carry this block in their hand and it can appear in the inventory
	    final int MAXIMUM_STACK_SIZE = 20;  // player can only hold 20 of this block in their hand at once

	   // Item.Properties itemSimpleProperties = new Item.Properties().stacksTo(MAXIMUM_STACK_SIZE).tab(ItemGroup.TAB_BUILDING_BLOCKS);
	                                                   //.maxStackSize(MAXIMUM_STACK_SIZE)
	                                                  // .group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
	    
	    //Material material = new Material(MaterialColor.COLOR_PURPLE, false, false, false, false, false, false, null );
	    System.out.println(" iterm register : " + " regi name : " + blockSimple1.getRegistryName().getPath());
		  net.minecraft.item.Item.Properties props =  new net.minecraft.item.Item.Properties();
		  props.stacksTo(MAXIMUM_STACK_SIZE);
		  System.out.println(" props : " + props.getClass());
	    itemBlockSimple = new BlockItem(blockSimple1, new Item.Properties().stacksTo(MAXIMUM_STACK_SIZE).tab(ItemGroup.TAB_BUILDING_BLOCKS));
	    itemBlockSimple.setRegistryName(blockSimple1.getRegistryName());
	    itemRegisterEvent.getRegistry().register(itemBlockSimple);
	  }
*/
	  @SubscribeEvent
	  public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
	    // not actually required for this example....
	  }
}
