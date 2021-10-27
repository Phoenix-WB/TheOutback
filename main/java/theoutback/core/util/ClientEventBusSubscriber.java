package theoutback.core.util;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import theoutback.TheOutback;
import theoutback.core.init.BlockInit;

@Mod.EventBusSubscriber(modid = TheOutback.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
		RenderTypeLookup.setRenderLayer(BlockInit.GUM_LEAVES.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GUM_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MALLEE_SHRUB.get(), RenderType.cutout());

	}
}
