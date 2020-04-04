package rjmunhoz.simpleaccessories.items;

import dev.emi.trinkets.api.ITrinket;
import dev.emi.trinkets.api.TrinketSlots;
import dev.emi.trinkets.api.TrinketSlots.SlotGroup;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import rjmunhoz.simpleaccessories.SimpleAccessories;

import java.util.Optional;

public abstract class BaseTrinket extends Item implements ITrinket {
  private String id;

  private double damage = 0;
  private boolean damageable = true;

  private StatusEffect effect;
  private boolean hasEffect = false;

  private String group;
  private String slot;

  private boolean isCraftingOnly = false;

  public BaseTrinket(String id, String group, String slot, Optional<StatusEffect> effect) {
    super(new Item.Settings().group(Items.ITEM_GROUP).maxDamage(5000));
    this.id = id;
    this.group = group;
    this.slot = slot;
    effect.ifPresent(statusEffect -> {
      this.effect = statusEffect;
      this.hasEffect = true;
    });
  }

  public Identifier getIdentifier() {
    return new Identifier(SimpleAccessories.MOD_ID, this.id);
  }

  @Override
  public boolean canWearInSlot(String group, String slot) {
    if (this.isCraftingOnly) return false;
    return (group.equals(this.group)) && (slot.equals(this.slot));
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
    return ITrinket.equipTrinket(player, hand);
  }

  @Override
  public void onEquip(PlayerEntity player, ItemStack stack) {
    if (!this.hasEffect || player.hasStatusEffect(this.effect)) return;
    player.addStatusEffect(new StatusEffectInstance(this.effect, Integer.MAX_VALUE, 0, true, false));
  }

  @Override
  public void onUnequip(PlayerEntity player, ItemStack stack) {
    if (!this.hasEffect || !player.hasStatusEffect(this.effect)) return;
    player.removeStatusEffect(this.effect);
  }

  private int getSlotFromSlotName() {
    int i = 0;

    for (SlotGroup group : TrinketSlots.slotGroups) {
      for (TrinketSlots.Slot slot : group.slots) {
        if (group.getName().equals(this.group) && slot.getName().equals(this.slot)) return i;

        i++;
      }
    }

    return -1;
  }

  @Override
  public void tick(PlayerEntity player, ItemStack stack) {
    if (!this.damageable) return;

    Inventory trinketsInventory = TrinketsApi.getTrinketsInventory(player);

    if (stack.getDamage() >= 4999) {
      int slot = this.getSlotFromSlotName();

      if (slot == -1) {
        return;
      }
      ;

      trinketsInventory.setInvStack(slot, ItemStack.EMPTY);
      trinketsInventory.markDirty();
      return;
    }

    if (this.damage > 1) {
      stack.setDamage(stack.getDamage() + 1);
      trinketsInventory.markDirty();
      this.damage = 0;
      return;
    }

    this.damage += 0.005;
  }

  public BaseTrinket setDamageable(boolean damageable) {
    this.damageable = damageable;
    return this;
  }

  public BaseTrinket setIsCraftingOnly() {
    this.isCraftingOnly = true;
    return this;
  }
}
