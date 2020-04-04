package rjmunhoz.simpleaccessories.items.cloaks;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import net.minecraft.entity.effect.StatusEffect;
import rjmunhoz.simpleaccessories.items.BaseTrinket;

import java.util.Optional;

public class BaseCloak extends BaseTrinket {
  public BaseCloak(String id) {
    super(id, SlotGroups.CHEST, Slots.CAPE, Optional.empty());
  }

  public BaseCloak(String id, StatusEffect effect) {
    super(id, SlotGroups.CHEST, Slots.CAPE, Optional.of(effect));
  }
}
