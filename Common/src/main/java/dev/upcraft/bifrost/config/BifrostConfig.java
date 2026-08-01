package dev.upcraft.bifrost.config;

import com.teamresourceful.resourcefulconfig.api.annotations.Config;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption;
import dev.upcraft.bifrost.Bifrost;

@ConfigInfo(
        titleTranslation = "bifrost.title",
        links = {
                @ConfigInfo.Link(value = "https://upcraft.dev", icon = "globe", text = "Website", textTranslation = "bifrost.config.links.website"),
                @ConfigInfo.Link(value = "https://mods.upcraft.dev/discord", icon = "gamepad-2", text = "Discord", textTranslation = "bifrost.config.links.discord")
        }
)
@Config(Bifrost.MOD_ID)
public class BifrostConfig {

    @ConfigOption.Color
    @ConfigEntry(id = "color")
    public static int exampleColor = 0xFFFFFF;
}
