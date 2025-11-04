package de.twyco.skinlayertoggle.keybinds;

import de.twyco.skinlayertoggle.listener.keybinds.KeybindHandler;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class KeybindManager {

    private static final Logger LOG = LoggerFactory.getLogger("skinlayertoggle");
    private final List<KeybindHandler> handlers = new ArrayList<>();
    private boolean initialized = false;

    public void register(KeybindHandler handler) {
        handlers.add(handler);
    }

    public void init() {
        if (initialized) return;
        initialized = true;

        ClientTickEvents.END_CLIENT_TICK.register((MinecraftClient client) -> {
            for (KeybindHandler h : handlers) {
                try {
                    h.onClientTick(client);
                } catch (Throwable t) {
                    LOG.error("Hotkey handler {} threw an exception", h.getClass().getSimpleName(), t);
                }
            }
        });
    }

}
