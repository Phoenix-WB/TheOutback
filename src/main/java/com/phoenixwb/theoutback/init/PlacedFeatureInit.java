package com.phoenixwb.theoutback.init;

import java.util.List;

import com.phoenixwb.theoutback.TheOutback;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlacedFeatureInit {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister
			.create(Registry.PLACED_FEATURE_REGISTRY, TheOutback.MODID);

	public static final RegistryObject<PlacedFeature> GUM_CHECKED = PLACED_FEATURES.register("gum_checked",
			() -> new PlacedFeature(ConfiguredFeatureInit.GUM.getHolder().get(),
					List.of(PlacementUtils.filteredByBlockSurvival(BlockInit.GUM_SAPLING.get()))));

	public static final RegistryObject<PlacedFeature> GUM_PLACED = PLACED_FEATURES.register("gum_placed",
			() -> new PlacedFeature(ConfiguredFeatureInit.GUM_SPAWN.getHolder().get(),
					VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 1.0F, 0))));
}
