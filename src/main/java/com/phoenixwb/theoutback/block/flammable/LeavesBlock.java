package com.phoenixwb.theoutback.block.flammable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class LeavesBlock extends net.minecraft.world.level.block.LeavesBlock {
	public LeavesBlock(Properties pProperties) {
		super(pProperties);
	}
	
	@Override
	public boolean isFlammable(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return true;
	}

	@Override
	public int getFlammability(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return 30;
	}

	@Override
	public int getFireSpreadSpeed(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return 60;
	}
}
