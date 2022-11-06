package com.phoenixwb.theoutback.init;

import java.util.List;

import com.phoenixwb.theoutback.TheOutback;
import com.phoenixwb.theoutback.world.placer.GumTrunkPlacer;

import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ConfiguredFeatureInit {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister
			.create(Registry.CONFIGURED_FEATURE_REGISTRY, TheOutback.MODID);

	public static final RegistryObject<ConfiguredFeature<?, ?>> GUM = CONFIGURED_FEATURES.register("gum",
			() -> new ConfiguredFeature<>(Feature.TREE,
					new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockInit.GUM_LOG.get()),
							new GumTrunkPlacer(9, 14, 7), BlockStateProvider.simple(BlockInit.GUM_LEAVES.get()),
							new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
							new TwoLayersFeatureSize(1, 0, 2)).build()));

	public static final RegistryObject<ConfiguredFeature<?, ?>> GUM_SPAWN = CONFIGURED_FEATURES.register("gum_spawn",
			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
					new RandomFeatureConfiguration(
							List.of(new WeightedPlacedFeature(PlacedFeatureInit.GUM_CHECKED.getHolder().get(), 0.5F)),
							PlacedFeatureInit.GUM_CHECKED.getHolder().get())));
}
