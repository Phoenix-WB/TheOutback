package theoutback;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import theoutback.core.init.BlockInit;
import theoutback.core.init.FeatureInit;
import theoutback.core.init.ItemInit;
import theoutback.core.itemgroup.TheOutbackItemGroup;
import theoutback.core.util.StrippingMap;

@Mod("theoutback")
@Mod.EventBusSubscriber(modid = TheOutback.MOD_ID, bus = Bus.MOD)
public class TheOutback {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "theoutback";

	public TheOutback() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.addListener(this::onLoadComplete);

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		FeatureInit.FEATURES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			event.getRegistry()
					.register(new BlockItem(block, new Item.Properties().tab(TheOutbackItemGroup.THE_OUTBACK))
							.setRegistryName(block.getRegistryName()));
		});
	}
	
	public void onLoadComplete(final FMLLoadCompleteEvent event) {
		StrippingMap.registerStrippables();
	}
}
