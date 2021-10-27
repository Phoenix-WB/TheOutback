package theoutback.core.util;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import theoutback.core.init.BlockInit;

public class StrippingMap {
	public static void createStrippable(Block input, Block output) {
		AxeItem.STRIPABLES = Maps.newHashMap(AxeItem.STRIPABLES);
		AxeItem.STRIPABLES.put(input, output);
	}
	
	public static void registerStrippables() {
		createStrippable(BlockInit.GUM_LOG.get(), BlockInit.STRIPPED_GUM_LOG.get());
	}
}
