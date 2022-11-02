package com.phoenixwb.theoutback.block.flammable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PlanksBlock extends Block {
	public PlanksBlock(Properties pProperties) {
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
		return 20;
	}
}
