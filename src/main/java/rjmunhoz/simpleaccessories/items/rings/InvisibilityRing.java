package rjmunhoz.simpleaccessories.items.rings;

import net.minecraft.entity.effect.StatusEffects;

public class InvisibilityRing extends BaseRing {
  public InvisibilityRing() {
    super("invisibility_ring");
    this.setEffect(StatusEffects.INVISIBILITY);
  }
}
