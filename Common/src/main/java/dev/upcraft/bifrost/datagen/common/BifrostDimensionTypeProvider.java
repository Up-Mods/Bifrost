package dev.upcraft.bifrost.datagen.common;

import dev.upcraft.bifrost.data.BifrostDimensionTypes;
import dev.upcraft.bifrost.data.BifrostTags;
import dev.upcraft.sparkweave.api.datagen.provider.common.dynamic.SparkweaveDynamicRegistryEntryProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TimelineTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.*;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.List;
import java.util.Optional;

public class BifrostDimensionTypeProvider extends SparkweaveDynamicRegistryEntryProvider {
    @Override
    public void generate(RegistrySetBuilder builder) {
        builder.add(Registries.DIMENSION_TYPE, ctx -> {
            var timelines = ctx.lookup(Registries.TIMELINE);
            var clocks = ctx.lookup(Registries.WORLD_CLOCK);

            var overworldTimelines = timelines.getOrThrow(TimelineTags.IN_OVERWORLD);
            var overworldClock = clocks.getOrThrow(WorldClocks.OVERWORLD);

            ctx.register(BifrostDimensionTypes.BIFROST, new DimensionType(
                    false,
                    true,
                    false,
                    false,
                    1.0D,
                    -64,
                    384,
                    384,
                    BifrostTags.Blocks.INFINIBURN_BIFROST,
                    0.0F,
                    new DimensionType.MonsterSettings(
                            UniformInt.of(0, 7),
                            0
                    ),
                    DimensionType.Skybox.NONE, // TODO custom skybox?
                    CardinalLighting.Type.DEFAULT,
                    EnvironmentAttributeMap.builder()
                            .set(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(
                                    Optional.empty(),
                                    Optional.of(new AmbientMoodSettings(
                                        SoundEvents.AMBIENT_CAVE,
                                        6000,
                                        8,
                                        2.0D
                                    )),
                                    List.of()
                            ))
                            .set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(
                                    Optional.of(new Music(
                                            SoundEvents.MUSIC_GAME,
                                            12000,
                                            24000,
                                            false
                                    )),
                                    Optional.of(new Music(
                                            SoundEvents.MUSIC_CREATIVE,
                                            12000,
                                            24000,
                                            false
                                    )),
                                    Optional.empty()
                            ))
                            .set(EnvironmentAttributes.BED_RULE, new BedRule(
                                    BedRule.Rule.NEVER,
                                    BedRule.Rule.ALWAYS,
                                    false,
                                    Optional.of(Component.translatable("block.minecraft.bed.no_sleep"))
                            ))
                            .set(EnvironmentAttributes.NETHER_PORTAL_SPAWNS_PIGLINS, false)
                            .set(EnvironmentAttributes.RESPAWN_ANCHOR_WORKS, false)
                            .set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, 0x0A0A0A)
                            .set(EnvironmentAttributes.CLOUD_COLOR, 0xCCFFFFFF)
                            .set(EnvironmentAttributes.CLOUD_HEIGHT, 192.33F)
                            .set(EnvironmentAttributes.FOG_COLOR, 0xC0D8FF)
                            .set(EnvironmentAttributes.SKY_COLOR, 0x3A0A4E)
                            .build(),
                    overworldTimelines,
                    Optional.of(overworldClock)
            ));
        });
    }

    @Override
    public String getName() {
        return "DimensionType";
    }
}
