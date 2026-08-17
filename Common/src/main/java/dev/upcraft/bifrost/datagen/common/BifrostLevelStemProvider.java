package dev.upcraft.bifrost.datagen.common;

import dev.upcraft.bifrost.data.BifrostBiomes;
import dev.upcraft.bifrost.data.BifrostDimensionTypes;
import dev.upcraft.bifrost.data.BifrostLevelStems;
import dev.upcraft.bifrost.data.BifrostNoiseSettings;
import dev.upcraft.sparkweave.api.datagen.provider.common.dynamic.SparkweaveDynamicRegistryEntryProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;

public class BifrostLevelStemProvider extends SparkweaveDynamicRegistryEntryProvider {
    @Override
    public void generate(RegistrySetBuilder builder) {
        builder.add(Registries.LEVEL_STEM, ctx -> {
            var biomes = ctx.lookup(Registries.BIOME);
            var dimensionTypes = ctx.lookup(Registries.DIMENSION_TYPE);
            var noiseParameters = ctx.lookup(Registries.NOISE_SETTINGS);

            var bifrostDefaultBiome = biomes.getOrThrow(BifrostBiomes.BIFROST_DEFAULT);
            var bifrostDimensionType = dimensionTypes.getOrThrow(BifrostDimensionTypes.BIFROST);
            var bifrostNoise = noiseParameters.getOrThrow(BifrostNoiseSettings.BIFROST);

            ctx.register(BifrostLevelStems.BIFROST, new LevelStem(
                bifrostDimensionType,
                new NoiseBasedChunkGenerator(
                        new FixedBiomeSource(bifrostDefaultBiome),
                        bifrostNoise
                )
            ));
        });
    }

    @Override
    public String getName() {
        return "Dimension";
    }
}
