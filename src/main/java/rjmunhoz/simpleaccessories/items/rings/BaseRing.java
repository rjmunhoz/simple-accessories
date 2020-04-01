package rjmunhoz.simpleaccessories.items.rings;

import dev.emi.trinkets.api.ITrinket;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import rjmunhoz.simpleaccessories.SimpleAccessories;

public abstract class BaseRing extends Item implements ITrinket {
  private String id;
  private double damage = 0;
  private StatusEffect effect;
  private boolean hasEffect = false;

  public BaseRing(String id, Settings settings) {
    super(settings.maxDamage(500));
    this.id = id;
  }

  public BaseRing(String id) {
    super(new Item.Settings().group(ItemGroup.TOOLS));
    this.id = id;
  }

  public void setEffect(StatusEffect effect) {
    this.effect = effect;
    this.hasEffect = true;
  }

  public Identifier getIdentifier() {
    return new Identifier(SimpleAccessories.MOD_ID, this.id);
  }

  @Override
  public boolean canWearInSlot(String group, String slot) {
    return (group.equals(SlotGroups.HAND)) && (slot.equals(Slots.RING));
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

  @Override
  public void tick(PlayerEntity player, ItemStack stack) {
    boolean shouldIncreaseStackDamage = this.damage >= 1;

    System.out.format("Processing damage. Current damage level: %.2f. shouldIncreaseStackDamage: %s\n", this.damage, shouldIncreaseStackDamage);

    if (shouldIncreaseStackDamage) {
      this.damage = 0;
      stack.setDamage(stack.getDamage() + 1);
      System.out.format("Current item damage: %s\n", stack.getDamage());
      TrinketsApi.getTrinketsInventory(player).markDirty();
      return;
    }

    System.out.format("Setting internal damage level to %.2f\n", this.damage + 0.1);
    this.damage += 0.1;
  }
}
