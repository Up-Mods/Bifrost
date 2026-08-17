package dev.upcraft.bifrost.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;

public class BifrostLevelStems {
    public static final ResourceKey<LevelStem> BIFROST = fromDimension(BifrostDimensions.BIFROST);

    private static ResourceKey<LevelStem> fromDimension(ResourceKey<Level> levelKey) {
        return ResourceKey.create(Registries.LEVEL_STEM, levelKey.identifier());
    }
}
