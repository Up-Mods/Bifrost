package dev.upcraft.bifrost.data;

import dev.upcraft.bifrost.Bifrost;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class BifrostNoiseParameters {
    public static final ResourceKey<NormalNoise.NoiseParameters> BIFROST_NOISE = ResourceKey.create(Registries.NOISE, Bifrost.id("bifrost_noise"));
}
