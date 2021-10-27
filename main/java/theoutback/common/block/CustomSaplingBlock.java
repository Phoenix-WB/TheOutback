package theoutback.common.block;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import theoutback.common.world.TreeSpawner;

public class CustomSaplingBlock extends SaplingBlock {
	
	private final TreeSpawner tree;

	public CustomSaplingBlock(Properties properties, TreeSpawner spawner) {
		super(null, properties);
		this.tree = spawner;
	}
	
	@Override
	public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
		if (state.getValue(STAGE) == 0) {
			world.setBlock(pos, state.cycle(STAGE), 4);
		}
		else {
			tree.spawn(world, world.getChunkSource().getGenerator(), pos, state, rand);
		}
	}
}
