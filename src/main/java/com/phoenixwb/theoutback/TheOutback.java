package com.phoenixwb.theoutback;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(TheOutback.MODID)
public class TheOutback {
	public static final String MODID = "theoutback";

	public TheOutback() {
		// IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
	}
}
