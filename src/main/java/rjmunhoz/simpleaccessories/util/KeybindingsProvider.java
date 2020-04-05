package rjmunhoz.simpleaccessories.util;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import rjmunhoz.simpleaccessories.SimpleAccessories;
import rjmunhoz.simpleaccessories.config.ModConfig;

@Environment(EnvType.CLIENT)
public class KeybindingsProvider {
  public static String CATEGORY_NAME = "Simple Accessories";

  public static FabricKeyBinding CONFIG = FabricKeyBinding.Builder.create(
    new Identifier(SimpleAccessories.MOD_ID, "config"),
    InputUtil.Type.KEYSYM,
    GLFW.GLFW_KEY_PERIOD,
    KeybindingsProvider.CATEGORY_NAME
  ).build();

  public static void register() {
    KeyBindingRegistry.INSTANCE.addCategory(KeybindingsProvider.CATEGORY_NAME);
    KeyBindingRegistry.INSTANCE.register(KeybindingsProvider.CONFIG);

    ClientTickCallback.EVENT.register(e -> {
      if (KeybindingsProvider.CONFIG.isPressed()) {
        MinecraftClient.getInstance().openScreen(AutoConfig.getConfigScreen(ModConfig.class, null).get());
      }
    });
  }
}
