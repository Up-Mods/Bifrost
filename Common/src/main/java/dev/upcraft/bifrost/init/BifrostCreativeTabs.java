package dev.upcraft.bifrost.init;

import dev.upcraft.bifrost.Bifrost;
import dev.upcraft.sparkweave.api.item.CreativeTabHelper;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class BifrostCreativeTabs {
    public static final RegistryHandler<CreativeModeTab> CREATIVE_TABS = RegistryHandler.create(Registries.CREATIVE_MODE_TAB, Bifrost.MOD_ID);
    public static final RegistrySupplier<CreativeModeTab> ITEMS = CREATIVE_TABS.register("items", () -> CreativeTabHelper.newBuilder(Bifrost.id("items")).icon(() -> new ItemStack(Blocks.PACKED_ICE)).displayItems((itemDisplayParameters, output) -> {
        CreativeTabHelper.addRegistryEntries(itemDisplayParameters, output, BifrostBlocks.BLOCKS, BifrostItems.ITEMS);
    }).build());
}
