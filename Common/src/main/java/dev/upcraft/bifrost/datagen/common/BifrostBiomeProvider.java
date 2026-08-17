package dev.upcraft.bifrost.datagen.common;

import dev.upcraft.bifrost.data.BifrostBiomes;
import dev.upcraft.sparkweave.api.datagen.provider.common.dynamic.SparkweaveBiomeProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BifrostBiomeProvider extends SparkweaveBiomeProvider {
    @Override
    protected void generateBiomes(Context ctx, HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        var glowLichen = placedFeatures.getOrThrow(CavePlacements.GLOW_LICHEN);
        var trees = placedFeatures.getOrThrow(VegetationPlacements.TREES_PLAINS);
        var patchGrass = placedFeatures.getOrThrow(VegetationPlacements.PATCH_GRASS_PLAIN);
        var sugarCane = placedFeatures.getOrThrow(VegetationPlacements.PATCH_SUGAR_CANE);

        ctx.register(BifrostBiomes.BIFROST_DEFAULT, new Biome.BiomeBuilder()
                        .temperature(0.8F)
                        .downfall(0.4F)
                        .specialEffects(new BiomeSpecialEffects.Builder()
                                .waterColor(0xD4F1F9)
                                .grassColorOverride(0x6A89A7)
                                .foliageColorOverride(0xFAE7AC)
                                .build()
                        )
                        .mobSpawnSettings(new MobSpawnSettings.Builder().build())
                        .generationSettings(new BiomeGenerationSettings.PlainBuilder()
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, glowLichen)
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, trees)
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, patchGrass)
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, sugarCane)
                                .build()
                        )
                .build(), "Bifrost Default");
    }
}
