package com.phoenixwb.theoutback.init;

import com.phoenixwb.theoutback.TheOutback;
import com.phoenixwb.theoutback.block.flammable.LeavesBlock;
import com.phoenixwb.theoutback.block.flammable.LogBlock;
import com.phoenixwb.theoutback.block.flammable.PlanksBlock;
import com.phoenixwb.theoutback.world.feature.tree.GumTreeGrower;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TheOutback.MODID);

	public static final RegistryObject<Block> GUM_LOG = BLOCKS.register("gum_log",
			() -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> GUM_WOOD = BLOCKS.register("gum_wood",
			() -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

	public static final RegistryObject<Block> STRIPPED_GUM_LOG = BLOCKS.register("stripped_gum_log",
			() -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

	public static final RegistryObject<Block> STRIPPED_GUM_WOOD = BLOCKS.register("stripped_gum_wood",
			() -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

	public static final RegistryObject<Block> GUM_PLANKS = BLOCKS.register("gum_planks",
			() -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> GUM_LEAVES = BLOCKS.register("gum_leaves",
			() -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> GUM_SAPLING = BLOCKS.register("gum_sapling",
			() -> new SaplingBlock(new GumTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
}
