package com.phoenixwb.theoutback.init;

import com.phoenixwb.theoutback.TheOutback;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheOutback.MODID);

	public static final RegistryObject<Item> GUM_LOG = ITEMS.register("gum_log",
			() -> new BlockItem(BlockInit.GUM_LOG.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> GUM_WOOD = ITEMS.register("gum_wood",
			() -> new BlockItem(BlockInit.GUM_WOOD.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> STRIPPED_GUM_LOG = ITEMS.register("stripped_gum_log",
			() -> new BlockItem(BlockInit.STRIPPED_GUM_LOG.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> STRIPPED_GUM_WOOD = ITEMS.register("stripped_gum_wood",
			() -> new BlockItem(BlockInit.STRIPPED_GUM_WOOD.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> GUM_PLANKS = ITEMS.register("gum_planks",
			() -> new BlockItem(BlockInit.GUM_PLANKS.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> GUM_LEAVES = ITEMS.register("gum_leaves",
			() -> new BlockItem(BlockInit.GUM_LEAVES.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

	public static final RegistryObject<Item> GUM_SAPLING = ITEMS.register("gum_sapling",
			() -> new BlockItem(BlockInit.GUM_SAPLING.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
}
