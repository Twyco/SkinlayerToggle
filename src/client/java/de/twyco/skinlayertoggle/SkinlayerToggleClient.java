package de.twyco.skinlayertoggle;

import de.twyco.skinlayertoggle.events.keybinds.ToggleAllEvent;
import de.twyco.skinlayertoggle.keybinds.KeybindManager;
import de.twyco.skinlayertoggle.keybinds.Keybinds;
import de.twyco.skinlayertoggle.listener.keybinds.ToggleAllHandler;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkinlayerToggleClient implements ClientModInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger("skinlayertoggle");

	@Override
	public void onInitializeClient() {
		this.registerKeybinds(new KeybindManager());
		LOGGER.info("[SkinlayerToggle] Client initialized.");
	}

	private void registerKeybinds(KeybindManager manager) {
		Keybinds.init();
		manager.register(new ToggleAllHandler(new ToggleAllEvent()));

		manager.init();
	}
}
