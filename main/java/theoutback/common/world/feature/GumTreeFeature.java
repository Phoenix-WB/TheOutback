package theoutback.common.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
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
	
	public int heightState(int heightVal, int otherHeight)
	{
		int exitVal = 0;
		if(heightVal - otherHeight == 14)
		{
			exitVal = 2;
			return exitVal;
		}
		else if (heightVal == 20)
		{
			exitVal = -1;
			return exitVal;
		}
		else if(heightVal == 21)
		{
			exitVal = -2;
			return exitVal;
		}
		else if (heightVal == 27)
		{
			exitVal = -1;
			return exitVal;
		}
		else if(heightVal == 28)
		{
			exitVal = -3;
			return exitVal;
		} 
		else if (heightVal < 23)
		{
			exitVal = 1;
			return exitVal;
		}
		return exitVal;
	}

	private static final BlockState LOG = BlockInit.GUM_LOG.get().defaultBlockState();
	private static final BlockState LEAVES = BlockInit.GUM_LEAVES.get().defaultBlockState()
			.setValue(LeavesBlock.DISTANCE, 5);

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
		int height = 10 + rand.nextInt(13);
		if (pos.getY() >= 1 && pos.getY() + 7 + 1 < reader.getMaxBuildHeight()
				&& height + (height / 3) + 4 < reader.getMaxBuildHeight()) {
			for (int i = pos.getY() + 1; i < pos.getY() + height + 1; i++) {
				reader.setBlock(new BlockPos(pos.getX(), i, pos.getZ()), LOG, 3);
			}

			// Top of Trunk here:
			for (int i = -2; i < (height / 3) + (height % 3); i += 2) {
				for (Direction d : DIRECTIONS) {
					reader.setBlock(
							new BlockPos(pos.getX(), pos.getY() + height + i / 2, pos.getZ()).relative(d, i / 2), LOG,
							3);
					reader.setBlock(
							new BlockPos(pos.getX(), pos.getY() + height + i / 2, pos.getZ()).relative(d, i / 2 + 1),
							LOG, 3);
				}
			}
		} else

		{
			return false;
		}

		// Leaves
		for (Direction d : DIRECTIONS) {
			reader.setBlock(new BlockPos(pos.getX(), pos.getY() + height + (height / 3) -2 + heightState(pos.getY() + height + (height / 3) - 2, (height / 3) + (height % 3)), pos.getZ()).relative(d, (height / 3)), LEAVES,
					3);
		}
		return true;
	}

}
