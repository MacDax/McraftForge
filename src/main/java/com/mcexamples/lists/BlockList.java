package com.mcexamples.lists;

import com.mcexamples.examplemod.ExampleMod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockList {
	
	    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);
	    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () ->
	    		new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops()
	    				.strength(4.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	   /* public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> 
	    		new Block(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops()
	    				.strength(3.0f, 3.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));*/
	
}
