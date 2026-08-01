package dev.upcraft.bifrost.datagen;

import com.google.auto.service.AutoService;
import dev.upcraft.bifrost.datagen.client.BifrostEnglishLanguageProvider;
import dev.upcraft.sparkweave.api.datagen.DataGenerationContext;
import dev.upcraft.sparkweave.api.datagen.DynamicRegistryBuilder;
import dev.upcraft.sparkweave.api.entrypoint.DataGenerationEntryPoint;

@AutoService(DataGenerationEntryPoint.class)
public class BifrostDataGeneration implements DataGenerationEntryPoint {

    @Override
    public void generateDynamicRegistryEntries(DynamicRegistryBuilder builder) {

    }

    @Override
    public void generate(DataGenerationContext ctx) {
        ctx.getDefaultPack().addProvider(DataGenerationContext::includeClient, BifrostEnglishLanguageProvider::new);
    }
}
