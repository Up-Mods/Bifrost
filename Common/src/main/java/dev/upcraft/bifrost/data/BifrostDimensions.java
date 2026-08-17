package dev.upcraft.bifrost.data;

import dev.upcraft.bifrost.Bifrost;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class BifrostDimensions {
    public static final ResourceKey<Level> BIFROST = ResourceKey.create(Registries.DIMENSION, Bifrost.id("bifrost"));
}
