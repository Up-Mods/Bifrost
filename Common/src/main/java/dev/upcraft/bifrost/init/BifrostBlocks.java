package dev.upcraft.bifrost.init;

import dev.upcraft.bifrost.Bifrost;
import dev.upcraft.bifrost.block.FrozenCoreBlock;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import dev.upcraft.sparkweave.api.registry.block.BlockRegistryHandler;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BifrostBlocks {

    public static final BlockRegistryHandler BLOCKS = RegistryHandler.blocks(Bifrost.MOD_ID);

    public static final RegistrySupplier<Block> FROZEN_CORE = BLOCKS.register("frozen_core", FrozenCoreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE));
}
