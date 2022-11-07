package com.phoenixwb.theoutback;

import com.phoenixwb.theoutback.init.BiomeInit;
import com.phoenixwb.theoutback.init.BlockInit;
import com.phoenixwb.theoutback.init.ConfiguredFeatureInit;
import com.phoenixwb.theoutback.init.ItemInit;
import com.phoenixwb.theoutback.init.PlacedFeatureInit;
import com.phoenixwb.theoutback.init.PlacerInit;
import com.phoenixwb.theoutback.world.region.GumForestRegion;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;

@Mod(TheOutback.MODID)
public class TheOutback {
	public static final String MODID = "theoutback";

	public TheOutback() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::commonSetup);

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		BiomeInit.BIOMES.register(bus);
		PlacerInit.TRUNK_PLACERS.register(bus);
		ConfiguredFeatureInit.CONFIGURED_FEATURES.register(bus);
		PlacedFeatureInit.PLACED_FEATURES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			Regions.register(new GumForestRegion(new ResourceLocation(MODID, "gum_forest_region"), 1));
		});
	}
}
