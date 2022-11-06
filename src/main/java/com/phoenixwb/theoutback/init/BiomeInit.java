package com.phoenixwb.theoutback.init;

import java.util.function.Supplier;

import com.phoenixwb.theoutback.TheOutback;
import com.phoenixwb.theoutback.world.biome.TheOutbackBiomeCreation;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(modid = TheOutback.MODID, bus = Bus.MOD)
public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY,
			TheOutback.MODID);

	public static final ResourceKey<Biome> GUM_FOREST = registerBiome("gum_forest", TheOutbackBiomeCreation::gumForest);
	
	private static ResourceKey<Biome> registerBiome(String name, Supplier<Biome> biome) {
		ResourceKey<Biome> resourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(TheOutback.MODID, name));
		BIOMES.register(resourceKey.location().getPath(), biome);
		return resourceKey;
	}
}
