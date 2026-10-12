package de.twyco.skinlayertoggle.listener.keybinds;

import de.twyco.skinlayertoggle.events.KeybindEvent;
import de.twyco.skinlayertoggle.keybinds.Keybinds;
import net.minecraft.client.Minecraft;

public record ToggleAllHandler(KeybindEvent event) implements KeybindHandler {

    @Override
    public void onClientTick(Minecraft client) {
        while (Keybinds.TOGGLE_ALL.consumeClick()) {
            event.execute(client);
        }
    }
}
