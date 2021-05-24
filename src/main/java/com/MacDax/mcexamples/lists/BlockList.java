package com.macdax.mcexamples.lists;

import com.macdax.mcexamples.ExampleMod;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockList {
	
	    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);
	 
	    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () ->
	    		new Block(Properties.of(Material.CLAY, MaterialColor.COLOR_CYAN))); //.requiresCorrectToolForDrops()
	    				//.strength(4.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	    
	    
	    
	  /*  public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () ->
		new Block(Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops()
				.strength(4.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));*/
	    
	   /* public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> 
	    		new Block(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops()
	    				.strength(3.0f, 3.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));*/
	    
	    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);
	    public  RegistryObject<Item> itemsRegistry;
	    
	    
	    public void getBlocks(RegistryEvent.Register<Item> event) {
	    		BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
	    			{
               // final Item.Properties properties = new Item.Properties().tab(ItemGroup.TAB_MISC);
               // final BlockItem blockitem  = new BlockItem(block, properties);
               // blockitem.setRegistryName(block.getRegistryName());
                //itemsRegistry.register(blockitem);
                ITEMS.register("silver_block", () ->
                	new BlockItem(block, new Item.Properties().tab(ItemGroup.TAB_COMBAT))
                );
        });
	    }
	    /*public static final RegistryObject<Item> obsidianBlock = ITEMS.register("silver_block", () -> 
	    		new BlockItem(BLOCKS.getEntries().forEach(arg0);, new Item.Properties().group(ModGroup.ITEM_GROUP)));*/
}
