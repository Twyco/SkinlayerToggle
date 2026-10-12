package de.twyco.skinlayertoggle.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public final class Keybinds {

    private Keybinds() {}

    public static KeyMapping.Category CATEGORY;
    public static KeyMapping TOGGLE_ALL;

    public static void init() {
        CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("skinlayertoggle", "main"));
        TOGGLE_ALL = KeyBindingHelper.registerKeyBinding(
                new KeyMapping(
                        "key.skinlayertoggle.toggle.all",
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_J,
                        CATEGORY
                )
        );
    }
}
