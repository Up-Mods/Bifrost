package dev.upcraft.bifrost;

import com.google.auto.service.AutoService;
import com.teamresourceful.resourcefulconfig.api.loader.Configurator;
import dev.upcraft.bifrost.config.BifrostConfig;
import dev.upcraft.bifrost.init.BifrostBlocks;
import dev.upcraft.bifrost.init.BifrostCreativeTabs;
import dev.upcraft.bifrost.init.BifrostItems;
import dev.upcraft.sparkweave.api.entrypoint.MainEntryPoint;
import dev.upcraft.sparkweave.api.platform.ModContainer;
import dev.upcraft.sparkweave.api.platform.services.RegistryService;
import net.minecraft.resources.Identifier;

@AutoService(MainEntryPoint.class)
public class Bifrost implements MainEntryPoint {
    public static final String MOD_ID = "bifrost";

    private static final Configurator CONFIGURATOR = new Configurator(MOD_ID);

    @Override
    public void onInitialize(ModContainer mod) {
        CONFIGURATOR.register(BifrostConfig.class);

        var registryService = RegistryService.get();
        BifrostBlocks.BLOCKS.accept(registryService);
        BifrostItems.ITEMS.accept(registryService);
        BifrostCreativeTabs.CREATIVE_TABS.accept(registryService);
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
