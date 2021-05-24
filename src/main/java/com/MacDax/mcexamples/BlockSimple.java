package com.macdax.mcexamples;
/*package com.mcexamples.examplemod;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.MixinEnvironment.Side;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockSimple extends Block {

	  private static final String REGISTRY_NAME = "block_simple_registry_name.json";

	public BlockSimple() {
		
		 super(AbstractBlock.Properties.of(Material.METAL));
	                //.sound(SoundType.METAL)
	                //.strength(2.0f));
	                //.lightLevel(state -> state.getValue(BlockStateProperties.POWERED) ? 14 : 0)
	        //);
		 
		
	}

	 

	 @Nullable
	    @Override
	    public BlockState getStateForPlacement(BlockItemUseContext context) {
	        return defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
	    }
	
	 public BlockRenderType getRenderType(BlockState blockState) {
	    return BlockRenderType.MODEL;
	  }
	 
	 @SideOnly(Side.class)
	 public BlockRenderLayer getBlockLayer() {
		 
	 }
	 
	 @Override
	    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
	        builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
	    }
	
	
}
*/