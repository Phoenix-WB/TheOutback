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
	
	static Random woodHeight = new Random();
	
	private int randWeight() {
		int randomNumbers[] = {0, woodHeight.nextInt(6), woodHeight.nextInt(6), woodHeight.nextInt(6), woodHeight.nextInt(11), woodHeight.nextInt(11), woodHeight.nextInt(16)};
		return randomNumbers[woodHeight.nextInt(6)];
	}

	private static final Direction[] DIRECTIONS = new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH,
			Direction.WEST };

	private static final BlockState LOG = BlockInit.GUM_LOG.get().defaultBlockState();
	private static final BlockState LEAVES = BlockInit.GUM_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 5);

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

		// Trunk
		int height = 10 + randWeight();
		if (pos.getY() >= 1 && pos.getY() + 7 + 1 < reader.getMaxBuildHeight()) {
			for (int i = pos.getY() + 1; i < pos.getY() + height + 1; i++) {
				reader.setBlock(new BlockPos(pos.getX(), i, pos.getZ()), LOG, 3);
			}
		}
		else {
			return false;
		}

		// Leaves
		for (int i = 1; i < 5; i++) {
			for (Direction d : DIRECTIONS) {
				reader.setBlock(new BlockPos(pos.getX(), pos.getY() + height - i, pos.getZ()).relative(d, i), LEAVES,
						3);
			}
		}

		return true;
	}

}
