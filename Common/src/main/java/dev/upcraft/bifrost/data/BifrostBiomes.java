package dev.upcraft.bifrost.data;

import dev.upcraft.bifrost.Bifrost;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class BifrostBiomes {
    public static final ResourceKey<Biome> BIFROST_DEFAULT = ResourceKey.create(Registries.BIOME, Bifrost.id("bifrost_default"));
}
