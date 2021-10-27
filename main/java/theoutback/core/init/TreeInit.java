package theoutback.core.init;

import java.util.Random;

import net.minecraft.world.gen.feature.Feature;
import theoutback.common.world.TreeSpawner;

@SuppressWarnings("rawtypes")
public class TreeInit {
	public static final TreeSpawner GUM = new TreeSpawner() {
		@Override
		protected Feature getFeature(Random random) {
			return FeatureInit.GUM_TREE.get();
		}
	};

}
