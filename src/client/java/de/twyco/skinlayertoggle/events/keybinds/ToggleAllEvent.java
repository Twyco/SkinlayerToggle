package de.twyco.skinlayertoggle.events.keybinds;

import de.twyco.skinlayertoggle.events.KeybindEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToggleAllEvent implements KeybindEvent {

    private static final Logger LOG = LoggerFactory.getLogger("skinlayertoggle");

    private static final PlayerModelPart[] LAYER_PARTS = new PlayerModelPart[] {
            PlayerModelPart.HAT,
            PlayerModelPart.JACKET,
            PlayerModelPart.LEFT_SLEEVE, PlayerModelPart.RIGHT_SLEEVE,
            PlayerModelPart.LEFT_PANTS_LEG, PlayerModelPart.RIGHT_PANTS_LEG
    };

    @Override
    public void execute(MinecraftClient client) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null) return;
        GameOptions opts = mc.options;

        boolean allEnabled = true;
        for (PlayerModelPart p : LAYER_PARTS) {
            if (!opts.isPlayerModelPartEnabled(p)) {
                allEnabled = false;
                break;
            }
        }
        for (PlayerModelPart p : LAYER_PARTS) {
            opts.setPlayerModelPart(p, !allEnabled);
        }
        opts.write();

        boolean nowOn = !allEnabled;
        if (client.player != null) {
            Text statusText = nowOn
                    ? Text.literal("ON").formatted(Formatting.GREEN, Formatting.BOLD)
                    : Text.literal("OFF").formatted(Formatting.RED, Formatting.BOLD);

            client.player.sendMessage(Text.literal("Second layer: ").append(statusText), true);
        }
        LOG.info("[SkinlayerToggle] Second layer -> {}", nowOn ? "ON" : "OFF");
    }
}
