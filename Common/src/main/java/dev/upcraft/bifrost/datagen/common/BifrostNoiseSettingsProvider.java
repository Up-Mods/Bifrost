package dev.upcraft.bifrost.datagen.common;

import dev.upcraft.bifrost.data.BifrostNoiseParameters;
import dev.upcraft.bifrost.data.BifrostNoiseSettings;
import dev.upcraft.bifrost.init.BifrostBlocks;
import dev.upcraft.sparkweave.api.datagen.provider.common.dynamic.SparkweaveDynamicRegistryEntryProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;

import java.util.List;

public class BifrostNoiseSettingsProvider extends SparkweaveDynamicRegistryEntryProvider {
    @Override
    public void generate(RegistrySetBuilder builder) {
        builder.add(Registries.NOISE_SETTINGS, ctx -> {
            var defaultBlock = BifrostBlocks.FROZEN_CORE.get().defaultBlockState();
            var defaultFluid = Blocks.ICE.defaultBlockState();


            var noise = ctx.lookup(Registries.NOISE);
            var bifrostNoise = noise.getOrThrow(BifrostNoiseParameters.BIFROST_NOISE);
            ctx.register(BifrostNoiseSettings.BIFROST, new NoiseGeneratorSettings(
                    new NoiseSettings(
                            0,
                            256,
                            1,
                            3
                    ),
                    defaultBlock,
                    defaultFluid,
                    NoiseRouterData.simpleRouter(
                            DensityFunctions.add(
                                    DensityFunctions.yClampedGradient(
                                            50,
                                            75,
                                            1.1D,
                                            -1.1D
                                    ),
                                    DensityFunctions.noise(
                                            bifrostNoise,
                                            0.75,
                                            0.5
                                    )
                            )
                    ),
                    SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()))
                    ),
                    List.of(),
                    63,
                    true,
                    true,
                    false,
                    false
                    )
            );
        });
    }

    @Override
    public String getName() {
        return "NoiseGeneratorSettings";
    }
}
