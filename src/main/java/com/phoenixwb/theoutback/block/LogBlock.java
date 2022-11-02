package com.phoenixwb.theoutback.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

public class LogBlock extends RotatedPillarBlock {
	public LogBlock(Properties pProperties) {
		super(pProperties);
	}
	
	@Override
	public boolean isFlammable(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return true;
	}
	
	@Override
	public int getFlammability(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return 5;
	}
	
	@Override
	public int getFireSpreadSpeed(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return 5;
	}
	
	@Override
	public @Nullable BlockState getToolModifiedState(BlockState pState, UseOnContext pContext, ToolAction pToolAction, boolean pSimulate) {
		if(pContext.getItemInHand().getItem() instanceof AxeItem) {
			if(pState.is(null)) {
				
			}
			if(pState.is(null)) {
				
			}
		}
		
		return super.getToolModifiedState(pState, pContext, pToolAction, pSimulate);
	}
}
