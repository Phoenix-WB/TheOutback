package com.phoenixwb.theoutback.world.region;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;
import com.phoenixwb.theoutback.init.BiomeInit;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class GumForestRegion extends Region {
	public GumForestRegion(ResourceLocation name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}

	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
		addBiome(mapper, Climate.parameters(2.7F, 0.8F, 0, 5.4F, 0, 0, 0), BiomeInit.GUM_FOREST);
	}
}
