package de.twyco.skinlayertoggle.listener.keybinds;

import de.twyco.skinlayertoggle.events.KeybindEvent;
import de.twyco.skinlayertoggle.keybinds.Keybinds;
import net.minecraft.client.MinecraftClient;

public record ToggleAllHandler(KeybindEvent event) implements KeybindHandler {

    @Override
    public void onClientTick(MinecraftClient client) {
        while (Keybinds.TOGGLE_ALL.wasPressed()) {
            event.execute(client);
        }
    }
}
