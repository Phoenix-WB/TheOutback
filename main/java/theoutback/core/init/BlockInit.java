package theoutback.core.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import theoutback.TheOutback;
import theoutback.common.block.CustomSaplingBlock;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TheOutback.MOD_ID);

	public static final RegistryObject<Block> MALLEE_SHRUB = BLOCKS.register("mallee_shrub",
			() -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.3f, 0.8f)
					.harvestTool(ToolType.AXE).harvestLevel(0).sound(SoundType.WOOD).noOcclusion().noCollission().jumpFactor(0.4f).speedFactor(0.1f)));

	public static final RegistryObject<Block> GUM_PLANKS = BLOCKS.register("gum_planks",
			() -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2f, 2f)
					.harvestTool(ToolType.AXE).harvestLevel(0).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> GUM_LOG = BLOCKS.register("gum_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2f, 2f)
					.harvestTool(ToolType.AXE).harvestLevel(0).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_GUM_LOG = BLOCKS.register("stripped_gum_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2f, 2f)
					.harvestTool(ToolType.AXE).harvestLevel(0).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> GUM_LEAVES = BLOCKS.register("gum_leaves",
			() -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.GRASS).strength(0.2f, 0.2f)
					.sound(SoundType.GRASS).randomTicks().noOcclusion()));

	public static final RegistryObject<Block> GUM_SAPLING = BLOCKS.register("gum_sapling",
			() -> new CustomSaplingBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.GRASS).strength(0f)
					.sound(SoundType.GRASS).randomTicks().noOcclusion(), TreeInit.GUM));
}
