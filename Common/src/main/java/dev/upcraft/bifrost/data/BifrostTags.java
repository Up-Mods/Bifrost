package dev.upcraft.bifrost.data;

import dev.upcraft.bifrost.Bifrost;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BifrostTags {
    public static class Blocks {
        public static final TagKey<Block> INFINIBURN_BIFROST = TagKey.create(Registries.BLOCK, Bifrost.id("infiniburn_bifrost"));
    }
}
