package dev.upcraft.bifrost.datagen;

import com.google.auto.service.AutoService;
import dev.upcraft.bifrost.datagen.client.BifrostEnglishLanguageProvider;
import dev.upcraft.bifrost.datagen.common.*;
import dev.upcraft.sparkweave.api.datagen.DataGenerationContext;
import dev.upcraft.sparkweave.api.datagen.DynamicRegistryBuilder;
import dev.upcraft.sparkweave.api.entrypoint.DataGenerationEntryPoint;

@AutoService(DataGenerationEntryPoint.class)
public class BifrostDataGeneration implements DataGenerationEntryPoint {

    @Override
    public void generateDynamicRegistryEntries(DynamicRegistryBuilder builder) {
        builder.add(BifrostBiomeProvider::new);
        builder.add(BifrostNoiseParametersProvider::new);
        builder.add(BifrostNoiseSettingsProvider::new);
        builder.add(BifrostDimensionTypeProvider::new);
        builder.add(BifrostLevelStemProvider::new);
    }

    @Override
    public void generate(DataGenerationContext ctx) {
        ctx.getDefaultPack().addProvider(BifrostBlockTagsProvider::new);

        ctx.getDefaultPack().addProvider(DataGenerationContext::includeClient, BifrostEnglishLanguageProvider::new);
    }
}
