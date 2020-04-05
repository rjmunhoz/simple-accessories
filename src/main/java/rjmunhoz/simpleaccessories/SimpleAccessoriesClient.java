package rjmunhoz.simpleaccessories;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import rjmunhoz.simpleaccessories.util.KeybindingsProvider;

public class SimpleAccessoriesClient implements ClientModInitializer {
  @Override
  @Environment(EnvType.CLIENT)
  public void onInitializeClient() {
    KeybindingsProvider.register();
  }
}
