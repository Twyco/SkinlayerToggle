package de.twyco.skinlayertoggle.keybinds;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public final class Keybinds {

    private Keybinds() {}

    public static KeyBinding.Category CATEGORY;
    public static KeyBinding TOGGLE_ALL;

    public static void init() {
        CATEGORY = KeyBinding.Category.create(Identifier.of("skinlayertoggle", "main"));
        TOGGLE_ALL = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.skinlayertoggle.toggle.all",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_J,
                        CATEGORY
                )
        );
    }
}
