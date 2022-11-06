package com.phoenixwb.theoutback.world.placer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.phoenixwb.theoutback.init.PlacerInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class GumTrunkPlacer extends TrunkPlacer {
	public static final Codec<GumTrunkPlacer> CODEC = RecordCodecBuilder.create((placer) -> {
		return trunkPlacerParts(placer).apply(placer, GumTrunkPlacer::new);
	});

	public GumTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
		super(pBaseHeight, pHeightRandA, pHeightRandB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PlacerInit.GUM_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel,
			BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos,
			TreeConfiguration pConfig) {
		setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
		int trunkHeight = pFreeTreeHeight - (pFreeTreeHeight / (2 + pRandom.nextInt(3)));

		List<? extends TrunkSegment> segments = List.of(
				new TrunkSegment(pPos.above(trunkHeight), pFreeTreeHeight - trunkHeight, pRandom),
				new BranchingTrunkSegment(pPos.above(trunkHeight - 1), Direction.NORTH,
						pRandom.nextInt(pFreeTreeHeight - (trunkHeight + 3)) + 3, pRandom),
				new BranchingTrunkSegment(pPos.above(trunkHeight - 1), Direction.SOUTH,
						pRandom.nextInt(pFreeTreeHeight - (trunkHeight + 3)) + 3, pRandom),
				new BranchingTrunkSegment(pPos.above(trunkHeight - 1), Direction.EAST,
						pRandom.nextInt(pFreeTreeHeight - (trunkHeight + 3)) + 3, pRandom),
				new BranchingTrunkSegment(pPos.above(trunkHeight - 1), Direction.WEST,
						pRandom.nextInt(pFreeTreeHeight - (trunkHeight + 3)) + 3, pRandom));

		for (int i = 0; i < trunkHeight; ++i) {
			this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
		}

		for (int i = trunkHeight; i < pFreeTreeHeight; ++i) {
			segments.forEach(segment -> {
				segment.grow();
				this.placeLog(pLevel, pBlockSetter, pRandom, segment.currentPos, pConfig);
			});
		}

		List<FoliageAttachment> foliage = segments.stream()
				.map(trunk -> new FoliagePlacer.FoliageAttachment(trunk.currentPos.above().above(), 0, false))
				.collect(Collectors.toList());
		return foliage;
	}

	static class TrunkSegment {
		BlockPos startPos, currentPos;
		int height;
		float directionChance;
		RandomSource random;

		public TrunkSegment(BlockPos startPos, int height, RandomSource random) {
			this.startPos = startPos;
			this.currentPos = startPos;
			this.height = height;
			this.random = random;
			directionChance = 0.0F;
		}

		public void grow() {
			if (!canGrow()) {
				return;
			}
			if (currentPos.getY() - startPos.getY() == height / 2) {
				directionChance = 1.0F;
			}
			if (directionChance > 0.0F) {
				currentPos = randomOffset();
				directionChance = 0.0F;
			}
			currentPos = currentPos.above();
		}

		public boolean canGrow() {
			return currentPos.getY() - startPos.getY() <= height;
		}

		public BlockPos randomOffset() {
			int randNum = random.nextInt(4);
			if (randNum == 0)
				return currentPos.north();
			if (randNum == 1)
				return currentPos.south();
			if (randNum == 2)
				return currentPos.east();
			return currentPos.west();
		}
	}

	static class BranchingTrunkSegment extends TrunkSegment {
		Direction direction;

		public BranchingTrunkSegment(BlockPos startPos, Direction direction, int height, RandomSource random) {
			super(startPos, height, random);
			this.direction = direction;
			directionChance = 1.0F;
		}

		@Override
		public void grow() {
			if (!canGrow()) {
				return;
			}
			if (directionChance != 0.0F && random.nextFloat() <= directionChance) {
				currentPos = forward();
				directionChance = 0.0F;
			}
			currentPos = currentPos.above();
			this.directionChance = Math.min(directionChance + random.nextFloat(), 1.0F);
		}

		public BlockPos forward() {
			if (direction.equals(Direction.NORTH))
				return currentPos.north();
			if (direction.equals(Direction.SOUTH))
				return currentPos.south();
			if (direction.equals(Direction.WEST))
				return currentPos.west();
			return currentPos.east();
		}

		public BlockPos opposite() {
			if (direction.equals(Direction.NORTH))
				return currentPos.south();
			if (direction.equals(Direction.SOUTH))
				return currentPos.north();
			if (direction.equals(Direction.WEST))
				return currentPos.east();
			return currentPos.west();
		}
	}
}
