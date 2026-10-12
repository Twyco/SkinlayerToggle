package de.twyco.skinlayertoggle.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public final class Keybinds {

    private Keybinds() {}

    public static KeyMapping.Category CATEGORY;
    public static KeyMapping TOGGLE_ALL;

    public static void init() {
        CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("skinlayertoggle", "main"));
        TOGGLE_ALL = KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        "key.skinlayertoggle.toggle.all",
                        InputConstants.Type.KEYBOARD,
                        InputConstants.KEY_J,
                        CATEGORY
                )
        );
    }
}
