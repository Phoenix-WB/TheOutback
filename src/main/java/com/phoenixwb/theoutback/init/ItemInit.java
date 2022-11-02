package com.phoenixwb.theoutback.init;

import com.phoenixwb.theoutback.TheOutback;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheOutback.MODID);

	public static final RegistryObject<Item> GUM_LOG = registerBlockItem("gum_log", BlockInit.GUM_LOG.get(),
			CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Item> GUM_WOOD = registerBlockItem("gum_wood", BlockInit.GUM_WOOD.get(),
			CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Item> STRIPPED_GUM_LOG = registerBlockItem("stripped_gum_log",
			BlockInit.STRIPPED_GUM_LOG.get(), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Item> STRIPPED_GUM_WOOD = registerBlockItem("stripped_gum_wood",
			BlockInit.STRIPPED_GUM_WOOD.get(), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Item> GUM_PLANKS = registerBlockItem("gum_planks", BlockInit.GUM_PLANKS.get(),
			CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Item> GUM_LEAVES = registerBlockItem("gum_leaves", BlockInit.GUM_LEAVES.get(),
			CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Item> GUM_SAPLING = registerBlockItem("gum_sapling", BlockInit.GUM_SAPLING.get(),
			CreativeModeTab.TAB_DECORATIONS);

	public static RegistryObject<Item> registerBlockItem(String name, Block block, CreativeModeTab tab) {
		return ITEMS.register(name, () -> new BlockItem(block, new Item.Properties().tab(tab)));
	}
}
