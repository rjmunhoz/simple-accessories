package rjmunhoz.simpleaccessories.items.cloaks;

public class RegularCloak extends BaseCloak {
  public RegularCloak() {
    super("regular_cloak");
    this.setDamageable(false)
      .setIsCraftingOnly();
  }
}
