package rjmunhoz.simpleaccessories.items.rings;

public class GemlessRing extends BaseRing {
  public GemlessRing() {
    super("gemless_ring");
    this.setDamageable(false)
    .setIsCraftingOnly();
  }
}
