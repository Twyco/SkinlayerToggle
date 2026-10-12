package de.twyco.skinlayertoggle.events.keybinds;

import de.twyco.skinlayertoggle.events.KeybindEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.PlayerModelPart;
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
    public void execute(Minecraft client) {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null) return;
        Options opts = mc.options;

        boolean allEnabled = true;
        for (PlayerModelPart p : LAYER_PARTS) {
            if (!opts.isModelPartEnabled(p)) {
                allEnabled = false;
                break;
            }
        }
        for (PlayerModelPart p : LAYER_PARTS) {
            opts.setModelPart(p, !allEnabled);
        }
        opts.save();

        boolean nowOn = !allEnabled;
        if (client.player != null) {
            Component statusText = nowOn
                    ? Component.literal("ON").withStyle(ChatFormatting.GREEN, ChatFormatting.BOLD)
                    : Component.literal("OFF").withStyle(ChatFormatting.RED, ChatFormatting.BOLD);

            client.player.sendOverlayMessage(
                    Component.literal("Second layer: ").append(statusText)
            );
        }
        LOG.info("[SkinlayerToggle] Second layer -> {}", nowOn ? "ON" : "OFF");
    }
}
