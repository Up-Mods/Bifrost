package dev.upcraft.bifrost.datagen.common;

import dev.upcraft.bifrost.data.BifrostNoiseParameters;
import dev.upcraft.sparkweave.api.datagen.provider.common.dynamic.SparkweaveDynamicRegistryEntryProvider;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class BifrostNoiseParametersProvider extends SparkweaveDynamicRegistryEntryProvider {
    @Override
    public void generate(RegistrySetBuilder builder) {
        builder.add(Registries.NOISE,ctx -> {
            ctx.register(BifrostNoiseParameters.BIFROST_NOISE, new NormalNoise.NoiseParameters(-8, DoubleList.of(1.0D, 3.0D, 5.0D, 6.0D)));
        });
    }

    @Override
    public String getName() {
        return "NoiseProvider";
    }
}
