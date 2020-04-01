package rjmunhoz.simpleaccessories.items;

import net.minecraft.util.registry.Registry;
import rjmunhoz.simpleaccessories.items.rings.GemlessRing;
import rjmunhoz.simpleaccessories.items.rings.InvisibilityRing;
import rjmunhoz.simpleaccessories.items.rings.SpeedRing;

public class Items {
  public static final GemlessRing GEMLESS_RING = new GemlessRing();
  public static final SpeedRing SPEED_RING = new SpeedRing();
  public static final InvisibilityRing INVISIBILITY_RING = new InvisibilityRing();

  public static void register() {
    Registry.register(Registry.ITEM, Items.GEMLESS_RING.getIdentifier(), Items.GEMLESS_RING);
    Registry.register(Registry.ITEM, Items.SPEED_RING.getIdentifier(), Items.SPEED_RING);
    Registry.register(Registry.ITEM, Items.INVISIBILITY_RING.getIdentifier(), Items.INVISIBILITY_RING);
  }
}
