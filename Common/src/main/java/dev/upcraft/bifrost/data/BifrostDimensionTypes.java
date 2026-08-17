package dev.upcraft.bifrost.data;

import dev.upcraft.bifrost.Bifrost;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.DimensionType;

public class BifrostDimensionTypes {
    public static final ResourceKey<DimensionType> BIFROST = ResourceKey.create(Registries.DIMENSION_TYPE, Bifrost.id("bifrost"));
}
