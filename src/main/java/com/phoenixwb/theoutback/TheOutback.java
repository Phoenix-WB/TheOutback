package com.phoenixwb.theoutback;

import com.phoenixwb.theoutback.init.BlockInit;
import com.phoenixwb.theoutback.init.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TheOutback.MODID)
public class TheOutback {
	public static final String MODID = "theoutback";

	public TheOutback() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
