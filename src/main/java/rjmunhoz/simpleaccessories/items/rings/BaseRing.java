package rjmunhoz.simpleaccessories.items.rings;


import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import net.minecraft.entity.effect.StatusEffect;
import rjmunhoz.simpleaccessories.items.BaseTrinket;

import java.util.Optional;

public abstract class BaseRing extends BaseTrinket {
  public BaseRing(String id, StatusEffect effect) {
    super(id, SlotGroups.HAND, Slots.RING, Optional.of(effect));
  }

  public BaseRing(String id) {
    super(id, SlotGroups.HAND, Slots.RING, Optional.empty());
  }
}
