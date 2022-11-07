package com.phoenixwb.theoutback.world.biome;

import javax.annotation.Nullable;

import com.phoenixwb.theoutback.init.PlacedFeatureInit;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class TheOutbackBiomeCreation {
	protected static int calculateSkyColour(float colour) {
		float colourChanged = colour / 3.0F;
		colourChanged = Mth.clamp(colourChanged, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - colourChanged * 0.05F, 0.5F + colourChanged * 0.1F, 1.0F);
	}

	private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor,
			int waterFogColor, int grassColor, int foliageColor, MobSpawnSettings.Builder spawnBuilder,
			BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
		return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temperature).downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor)
						.fogColor(12638463).grassColorOverride(grassColor).foliageColorOverride(foliageColor)
						.skyColor(calculateSkyColour(temperature))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build())
				.mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
	}

	public static Biome gumForest() {
		MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.caveSpawns(spawnBuilder);
		monsters(spawnBuilder, 65, 1, 30, false);

		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
		biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacedFeatureInit.GUM_PLACED.getHolder().get());
		BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
		BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
		BiomeDefaultFeatures.addForestGrass(biomeBuilder);

		return biome(Biome.Precipitation.RAIN, 2.7F, 0.13F, 3961685, 2974028, 5212728, 9616761, spawnBuilder,
				biomeBuilder, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));
	}

	public static void monsters(MobSpawnSettings.Builder pBuilder, int pZombieWeight, int pZombieVillageWeight,
			int pSkeletonWeight, boolean pIsUnderwater) {
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 250, 4, 4));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
				pIsUnderwater ? EntityType.DROWNED : EntityType.ZOMBIE, pZombieWeight, 4, 4));
		pBuilder.addSpawn(MobCategory.MONSTER,
				new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, pZombieVillageWeight, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER,
				new MobSpawnSettings.SpawnerData(EntityType.SKELETON, pSkeletonWeight, 4, 4));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 150, 4, 4));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
	}
}
