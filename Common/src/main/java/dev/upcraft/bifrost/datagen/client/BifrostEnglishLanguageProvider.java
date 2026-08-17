package dev.upcraft.bifrost.datagen.client;

import dev.upcraft.bifrost.init.BifrostBlocks;
import dev.upcraft.bifrost.init.BifrostCreativeTabs;
import dev.upcraft.sparkweave.api.datagen.ContextAwarePackOutput;
import dev.upcraft.sparkweave.api.datagen.TranslationBuilder;
import dev.upcraft.sparkweave.api.datagen.provider.client.SparkweaveLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.locale.Language;

import java.util.concurrent.CompletableFuture;

public class BifrostEnglishLanguageProvider extends SparkweaveLanguageProvider {

    public BifrostEnglishLanguageProvider(ContextAwarePackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, Language.DEFAULT);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registries, TranslationBuilder builder) {
        builder.add("bifrost.title", "Enter the Bifrost");
        builder.add("bifrost.config.links.website", "Website");
        builder.add("bifrost.config.links.discord", "Discord");

        builder.block(BifrostBlocks.FROZEN_CORE, "Frozen Core");
        builder.creativeTab(BifrostCreativeTabs.ITEMS, "Enter the Bifrost");
    }
}
