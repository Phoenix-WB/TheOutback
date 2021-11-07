package theoutback.common.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import theoutback.core.init.BlockInit;

public class GumTreeFeature extends Feature<NoFeatureConfig> {

	private static final Direction[] DIRECTIONS = new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH,
			Direction.WEST };
	private static final BlockState LOG = BlockInit.GUM_LOG.get().defaultBlockState();
	private static final BlockState LEAVES = BlockInit.GUM_LEAVES.get().defaultBlockState()
			.setValue(LeavesBlock.DISTANCE, 7);
	protected int trunkHeights[] = { 0, 0, 0, 3, 3, 3, 6, 6, 9, 9, 12, 15 };

	protected int getTrunkHeight() {
		Random randomTrunkHeight = new Random();
		return 12 + trunkHeights[randomTrunkHeight.nextInt(13)];
	}

	protected int getBranchHeight() {
		return getTrunkHeight() / 3;
	}

	protected int getLeavesRadius() {
		Random randomLeavesRadius = new Random();
		return getBranchHeight() + 3 + randomLeavesRadius.nextInt(4);
	}

	public GumTreeFeature(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	@SuppressWarnings("deprecation")
	public boolean isAirOrLeaves(IWorldGenerationBaseReader reader, BlockPos pos) {
		if (!(reader instanceof IWorldReader)) {
			return reader.isStateAtPosition(pos, state -> state.isAir() || state.is(BlockTags.LEAVES));
		} else {
			return reader.isStateAtPosition(pos, state -> state.canBeReplacedByLeaves((IWorldReader) reader, pos));
		}
	}

	@Override
	public boolean place(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos,
			NoFeatureConfig config) {
		while (pos.getY() > 1 && isAirOrLeaves(reader, pos)) {
			pos = pos.below();
		}

		if (!isGrassOrDirt(reader, pos)) {
			return false;
		}

		int trunkHeight = getTrunkHeight();
		int branchHeight = getBranchHeight();
		int leavesRadius = getLeavesRadius();

		if (pos.getY() >= 1 && pos.getY() + 27 + 2 < reader.getHeight())

		{
			for (int i = pos.getY() + 1; i < pos.getY() + 1 + trunkHeight; i++) {
				reader.setBlock(new BlockPos(pos.getX(), i, pos.getZ()), LOG, 3);
			}
		}

		for (Direction dirBranch : DIRECTIONS) {
			for (int i = 0; i < branchHeight; i++) {
				reader.setBlock(new BlockPos(pos.getX(), trunkHeight + 4 + i, pos.getZ()).relative(dirBranch, i), LOG,
						3);
				reader.setBlock(new BlockPos(pos.getX(), trunkHeight + 3 + i, pos.getZ()).relative(dirBranch, i), LOG,
						3);
			}
		}

		for (Direction dirLeaves : DIRECTIONS) {
			for (int i = 0; i < leavesRadius; i++) {
				reader.setBlock(
						new BlockPos(pos.getX(), trunkHeight + branchHeight + 4, pos.getZ()).relative(dirLeaves, i),
						LEAVES, 3);
			}
			for (int i = 0; i < leavesRadius - 1; i++) {
				reader.setBlock(
						new BlockPos(pos.getX(), trunkHeight + branchHeight + 5, pos.getZ()).relative(dirLeaves, i),
						LEAVES, 3);
			}
		}

		return true;
	}
}
