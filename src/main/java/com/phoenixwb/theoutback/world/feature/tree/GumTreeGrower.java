package com.phoenixwb.theoutback.world.feature.tree;

import com.phoenixwb.theoutback.init.ConfiguredFeatureInit;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class GumTreeGrower extends AbstractTreeGrower {
	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
		return ConfiguredFeatureInit.GUM.getHolder().get();
	}
}
