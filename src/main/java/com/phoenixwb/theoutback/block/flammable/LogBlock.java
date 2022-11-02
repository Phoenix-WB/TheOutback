package com.phoenixwb.theoutback.block.flammable;

import javax.annotation.Nullable;

import com.phoenixwb.theoutback.init.BlockInit;

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
			if(pState.is(BlockInit.GUM_LOG.get())) {
				return BlockInit.STRIPPED_GUM_LOG.get().defaultBlockState().setValue(AXIS, pState.getValue(AXIS));
			}
			if(pState.is(BlockInit.GUM_WOOD.get())) {
				return BlockInit.STRIPPED_GUM_WOOD.get().defaultBlockState().setValue(AXIS, pState.getValue(AXIS));
			}
		}
		
		return super.getToolModifiedState(pState, pContext, pToolAction, pSimulate);
	}
}
