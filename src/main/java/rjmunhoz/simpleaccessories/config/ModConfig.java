package rjmunhoz.simpleaccessories.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "simpleaccessories")
public class ModConfig implements ConfigData {
  @ConfigEntry.Gui.Tooltip()
  @ConfigEntry.BoundedDiscrete(min = 1, max = 288)
  int ticksToLive = 200;

  public double getDecayRate() {
    return 1.0 / this.ticksToLive;
  }
}
