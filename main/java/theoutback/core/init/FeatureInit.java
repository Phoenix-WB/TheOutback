package theoutback.core.init;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import theoutback.TheOutback;
import theoutback.common.world.feature.GumTreeFeature;

public class FeatureInit {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
			TheOutback.MOD_ID);

	public static final RegistryObject<GumTreeFeature> GUM_TREE = FEATURES.register("gum_tree",
			() -> new GumTreeFeature(NoFeatureConfig.CODEC));

}
