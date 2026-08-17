package dev.upcraft.bifrost.datagen.common;

import dev.upcraft.bifrost.Bifrost;
import dev.upcraft.bifrost.data.BifrostTags;
import dev.upcraft.sparkweave.api.datagen.provider.common.SparkweaveBlockTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BifrostBlockTagsProvider extends SparkweaveBlockTagProvider {
    public BifrostBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Bifrost.MOD_ID, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BifrostTags.Blocks.INFINIBURN_BIFROST, "Bifrost Infiniburn")
                .addExistingTag(BlockTags.INFINIBURN_OVERWORLD);
    }
}
