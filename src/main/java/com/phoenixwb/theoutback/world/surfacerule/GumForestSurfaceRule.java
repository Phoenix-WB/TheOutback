package com.phoenixwb.theoutback.world.surfacerule;

import com.phoenixwb.theoutback.init.BiomeInit;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class GumForestSurfaceRule {
	private static final SurfaceRules.RuleSource GRASS = SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState());
	private static final SurfaceRules.RuleSource DIRT = SurfaceRules.state(Blocks.DIRT.defaultBlockState());

	public static SurfaceRules.RuleSource registerRules() {
		return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeInit.GUM_FOREST), GRASS), DIRT);
	}
}
