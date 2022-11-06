package com.phoenixwb.theoutback.init;

import com.phoenixwb.theoutback.TheOutback;
import com.phoenixwb.theoutback.world.placer.GumTrunkPlacer;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlacerInit {
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister
			.create(Registry.TRUNK_PLACER_TYPE_REGISTRY, TheOutback.MODID);

	public static final RegistryObject<TrunkPlacerType<?>> GUM_TRUNK_PLACER = TRUNK_PLACERS.register("gum_trunk_placer",
			() -> new TrunkPlacerType<>(GumTrunkPlacer.CODEC));
}
