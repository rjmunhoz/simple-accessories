package rjmunhoz.simpleaccessories.config;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import rjmunhoz.simpleaccessories.SimpleAccessories;

@Environment(EnvType.CLIENT)
public class ConfigScreen implements ModMenuApi {
  @Override
  public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
    return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
  }
}
