package com.phoenixwb.theoutback.world.region;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;
import com.phoenixwb.theoutback.init.BiomeInit;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.Continentalness;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.Erosion;
import terrablender.api.ParameterUtils.Humidity;
import terrablender.api.ParameterUtils.Temperature;
import terrablender.api.ParameterUtils.Weirdness;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class GumForestRegion extends Region {
	public GumForestRegion(ResourceLocation name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}

	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
		addBiome(mapper, Climate.parameters(Temperature.span(Temperature.NEUTRAL, Temperature.WARM),
				Humidity.span(Humidity.NEUTRAL, Humidity.DRY),
				Continentalness.span(Continentalness.MID_INLAND, Continentalness.FAR_INLAND),
				Erosion.span(Erosion.EROSION_3, Erosion.EROSION_4), Depth.SURFACE.parameter(),
				Weirdness.span(Weirdness.LOW_SLICE_NORMAL_DESCENDING, Weirdness.MID_SLICE_VARIANT_ASCENDING), 1),
				BiomeInit.GUM_FOREST);
	}
}
