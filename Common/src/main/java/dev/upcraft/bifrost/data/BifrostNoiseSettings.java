package dev.upcraft.bifrost.data;

import dev.upcraft.bifrost.Bifrost;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class BifrostNoiseSettings {
    public static final ResourceKey<NoiseGeneratorSettings> BIFROST = ResourceKey.create(Registries.NOISE_SETTINGS, Bifrost.id("bifrost"));
}
